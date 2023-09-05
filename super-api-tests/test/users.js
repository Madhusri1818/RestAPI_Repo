 
import { describe } from "mocha";
import supertest from "supertest";
import { expect } from "chai";
const request = supertest('https://gorest.co.in/public/v2/');
const TOKEN='ca68838913f1b919af4007bd1ad30ba34572fb8f0aebc7680dacc1b8d053ffb8';
describe('Users',()=>{
    it('Get/User',(done)=>{
        console.log(TOKEN);
        request.get('users?primary-token=${TOKEN}').end((err,res)=>{

console.log(res.body);
console.log(err);
expect(200,done);
expect(res.body).to.not.be.empty;
done();
        })
    })
    it.skip('GetsingleUser',function(done){
        request.get('users/2840?primary-token=${TOKEN}').then((res)=>{
            expect(res.body).to.not.be.empty;
            console.log(res.body)
            expect(res.body.id).to.be.eql(2840);
            done();
        })
    })
    it('GetUsersWithQueryParams',()=>{
        const url="users?primary-token=${TOKEN}&page=4&gender=female&status=active"
       return request.get(url).then((res)=>{
            expect(res.body).to.not.be.empty;
            console.log(res.body)
            res.body.forEach(body => {
               expect(body.gender).to.be.eql('female');
               expect(body.status).to.be.eql('active')
            });
           // expect(res.body.id).to.be.eql(2840);
            //done();
        })
    })
    it('Post Req',function(){
        const x={
            name:'Madhu',
            email:Math.round(Math.random()*999)+'test'+'@gmail.com',
            gender:'female',
            status:'Inactive'
        };
        return request.post('users')
        
        .set('Authorization','Bearer '+TOKEN)
        .send(x)
        .then((res)=>{
            //console.log(body)
           // console.log(TOKEN)
            console.log(res.body)
            expect(res.body.name).to.be.eql('Madhu')
          //  expect(res.body).to.deep.include(email)
          //  expect(res.body.email).to.be.eq('madhu123@gmail.example');

        })
    })
    it('Put/Update name Req',function(){
        const x={
            name:'Madhusri',
            status:'active'
        };
        return request.put('users/2847')
        
        .set('Authorization','Bearer '+TOKEN)
        .send(x)
        .then((res)=>{
            //console.log(body)
           // console.log(TOKEN)
            console.log(res.body)
           // expect(res.body.email).to.be.eq('madhu123@gmail.example');

        })
    })
    
    it('Delete user',()=>{
        console.log(TOKEN);
       return request.del('users?primary-token=${TOKEN}'+'/4890403').then((res)=>{


//expect(204,done);
expect(res.body).to.be.empty;

        })
    })
})