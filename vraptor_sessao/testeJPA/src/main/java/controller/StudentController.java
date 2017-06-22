package controller;

import javax.inject.Inject;
import br.com.caelum.vraptor.*;
import session.Session;

@Controller
public class StudentController {
    
    @Inject
    private Result result;
    @Inject
    private Session session;
    
    //public StudentController(Result result){
      //  String persistenceUnitName = "myPU";
        //this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        //this.entityManager = entityManagerFactory.createEntityManager();
        //this.result =  result;
    //}

    @Path("/")
    public void index() {
        //String mensagem = "Sistema de Gerenciamento do CORE";
        this.session.setValor(10);
        this.result.include("variable", this.session.getValor());
        
    }
    
    @Path("/student/toList")
    public void toList(){
        this.result.include("variable", this.session.getValor());        
    }

    
}
