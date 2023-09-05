import { describe } from "mocha";
import supertest from "supertest";
import { expect } from "chai";
const request = supertest('https://gorest.co.in/public/v2/');
const TOKEN='ca68838913f1b919af4007bd1ad30ba34572fb8f0aebc7680dacc1b8d053ffb8';
describe('suit', async function(){
    let id,userid;
    before(async()=>{
         userid= Math.round(Math.random() * 10);
        console.log(userid)
    })
    
    const res=it.skip('test1',()=>{
          request.get('posts/65409')
          .then((res)=>{
            console.log(res.body)
          })
          
    })

    it('postTest',async ()=>{
        const x={
            user_id: userid,
            title: 'Drama_c',
            body: 'Drama makes Happy'
          
          }
        const res= await request.post('posts')
        .set('Authorization','Bearer '+TOKEN)
        .send(x);
            console.log(res.body);
           // console.log(x);
          //  userid=res.body.user_id;
            
    
            
            console.log('new id :'+id)
        
    });
        it('put',async ()=>{
            const x={
                title: 'Journey of the ChongGi'
            }
            const res1= await request.put('posts/'+id)
            .set('Authorization','Bearer '+TOKEN)
            .send(x);
               // id=res.body.id;
                console.log(res1.body); 
                //expect(res1.body.title).to.be.eql(x.title) 
        
    })

    it('del',async()=>{
        const res1= await request.del('posts/'+id)
        .set('Authorization','Bearer '+TOKEN)
       .then((res)=>{
           // id=res.body.id;
            console.log(res.body); 
            expect(res.body).to.be.empty; 
    })
    })
       
})   
       //console.log(res.body)
    
