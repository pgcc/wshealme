/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import static Util.OntoConnection.OntoHealth;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.shared.JenaException;
import com.hp.hpl.jena.util.FileManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindswap.pellet.jena.PelletReasonerFactory;




/**
 *
 * @author icarv
 */
public class OntoConnection {
    
    static final String OntoHealth = "/opt/tomcat/webapps/Ontologies/ontohealth.owl";
    //static final String OntoHealth = "C:\\OntoHealth\\OntoHealth.owl";
   
    public static InfModel OntoConnection(){
        
        
        
        try {
            //String f = new File("/resources/ontology/OntoHealth.owl").getPath();
            //String f = "https://sites.google.com/a/ice.ufjf.br/healme/files/OntoHealth.owl";        
            //String f = "C:\\seco6\\seco6.owl";               
            String f = OntoHealth;        
            OntModelSpec especRacioc = OntModelSpec.OWL_DL_MEM; 
            OntModel seco = ModelFactory.createOntologyModel(especRacioc, null);
            InputStream in = FileManager.get().open(f);
            seco.read(in, null);
            Reasoner reasoner = (Reasoner) PelletReasonerFactory.theInstance().create();
            //Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
            reasoner = reasoner.bindSchema(seco);
            InfModel infmodel = ModelFactory.createInfModel(reasoner,seco);
            infmodel.prepare();
            
            /*-----------------------------
            FileWriter arquivo = null;
            try {
            //caminho para o novo arquivo de ontologia
                arquivo = new FileWriter("C:\\Seco 7\\Seco 7.owl");
            //se não existir arquivo, o mesmo será criado, se não, será reescrito
            } catch (IOException ex) {
                ex.printStackTrace(); //verificando problemas
            }
            //determinando que o fluxo de saida vai para o arquivo e não para a tela            
            BufferedWriter out = new BufferedWriter(arquivo);
            infmodel.write(out);
            -----------------------------*/
                  
            return infmodel;
        } catch (JenaException je) {
            System.out.println("ERROR" + je.getMessage());
            je.printStackTrace();
        }/* catch (IOException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
        }*/
        
        return null;
    }
    
    public static OntModel OntoConnectionSInferencia(){
        
        //String f = "c:\\seco6\\seco6.owl";        
        String f = OntoHealth;
        
        
        try {
            //String f = new File("/ontology/OntoHealth.owl").getCanonicalPath();        
            //String f = "https://sites.google.com/a/ice.ufjf.br/healme/files/OntoHealth.owl";        
            OntModelSpec especRacioc = OntModelSpec.OWL_DL_MEM; 
            OntModel seco = ModelFactory.createOntologyModel(especRacioc);
            InputStream in = FileManager.get().open(f);
            seco.read(in, null);
            return seco;
        } catch (JenaException je) {
            System.out.println("ERROR" + je.getMessage());
            je.printStackTrace();
        }/* catch (IOException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
        }*/
        
        return null;
    }
    
    public static void gravaOnto(OntModel seco) throws IOException{
        
        //String f = "c:\\seco6\\seco6.owl";
        String f = OntoHealth;
        //String f = new File("/ontology/OntoHealth.owl").getCanonicalPath();
        //String f = "https://sites.google.com/a/ice.ufjf.br/healme/files/OntoHealth.owl";
        OntModelSpec especRacioc = OntModelSpec.OWL_DL_MEM; 
        //seco = ModelFactory.createOntologyModel(especRacioc, seco);        
                
        try {
                      
            FileWriter arquivo = null;
            try {
            //caminho para o novo arquivo de ontologia
                arquivo = new FileWriter(f);
            //se não existir arquivo, o mesmo será criado, se não, será reescrito
            } catch (IOException ex) {
                ex.printStackTrace(); //verificando problemas
            }
            //determinando que o fluxo de saida vai para o arquivo e não para a tela            
            BufferedWriter out = new BufferedWriter(arquivo);
            
            seco.write(out, "RDF/XML-ABBREV");
        } catch (JenaException je) {
            System.out.println("ERROR" + je.getMessage());
            je.printStackTrace();
        }
    }
    
    
}
