
import { describe } from "mocha";
import supertest from "supertest";
import { expect } from "chai";
const request = supertest('https://gorest.co.in/public/v2/');
const TOKEN='ca68838913f1b919af4007bd1ad30ba34572fb8f0aebc7680dacc1b8d053ffb8';
describe('Users',()=>{
    let id=0;
    
        it('Post Req_Get Id',function(){
            const x={
                name:'Madhu'+Math.round(Math.random()*10000),
                email:Math.round(Math.random()*999)+'test'+'@gmail.com',
                gender:'female',
                status:'Inactive'
            };
            return request.post('users')
             .set('Authorization','Bearer '+TOKEN)
            .send(x)
            .then((res)=>{
                console.log(res.body)
                id=res.body.id;
                console.log("The user id is : "+id)
                //expect(res.body.name).to.be.eql('Madhu');
            })
        })  
        it('get user id:/id',()=>{
            return request.get('users/'+id)
            .set('Authorization','Bearer '+TOKEN)
            .then((res)=>{
                console.log(res.body)
                expect(res.body.id).to.be.eql(id)
            })
        })
        it('update Request',()=>{
            const x={
                status:'active'
            };
            return request.put('users/'+id)
            .set('Authorization','Bearer '+TOKEN)
            .send(x)
            .then((res)=>{
                console.log(res.body)
                expect(res.body.id).to.be.eql(id)
                expect(res.body.status).to.be.eql('active')
            })
        })
        it(('delect user_id:/id'),()=>{
            return request.del('users/'+id)
            .set('Authorization','Bearer '+TOKEN)
         .then((res)=>{
                console.log(res.body)
            expect(res.body).to.be.empty;
            })
        })

    })

    