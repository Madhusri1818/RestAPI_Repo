
import { describe } from "mocha";
import request from "../config/common";
const faker=require('faker');
require('dotenv').config();
const TOKEN= process.env.USER_TOKEN;
describe.only('testsuit',async ()=>{
    it('firstTestcase',()=>{
        const res=request.get('users').then((res)=>{
            console.log(res.body)
        });
    })
    it.only('firstTestcase',async ()=>{
        const x={
            name:faker.name.firstName(),
            email:faker.internet.email(),
           // title:faker.lorem.sentence(),
            gender:'female',
            status:'Inactive'
        };
        const res=await request.post('users')
        .send(x)
        .set('Authorization','Bearer '+TOKEN);
        console.log(x)
        console.log(res.body)

     })
})