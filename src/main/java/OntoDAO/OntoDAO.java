/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OntoDAO;


import Model.IndividualModel;
import Model.PlatformModel;
import Util.OntoConnection;
import com.hp.hpl.jena.datatypes.RDFDatatype;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.DatasetFactory;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.reasoner.Reasoner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.mindswap.pellet.jena.PelletReasonerFactory;


/**
 *
 * @author icarv
 */
public class OntoDAO {
    
    public static InfModel seco = OntoConnection.OntoConnection();  
    public static OntModel sec = OntoConnection.OntoConnectionSInferencia();
    static final String URI = "http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl";
    static final String Prefixo =  "    Prefix txt: <http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#>\n" +
                    "    Prefix owl: <http://www.w3.org/2002/07/owl#/>\n" +
                    "    Prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                    "    Prefix xml: <http://www.w3.org/XML/1998/namespace>\n" +
                    "    Prefix xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                    "    Prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                    "    Prefix seco: <http://www.seco.com/ontoloy/seco.owl#>\n" +
                    "    Prefix swrl: <http://www.w3.org/2003/11/swrl#>\n" +
                    "    Prefix swrla: <http://swrl.stanford.edu/ontologies/3.3/swrla.owl#>\n" +
                    "    Prefix swrlb: <http://www.w3.org/2003/11/swrlb#>\n"+
                    "    Prefix data:<http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#>";
    
    public static List<PlatformModel> returnPlatforms(){
                
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();    
        String sql = "SELECT * FROM platforms";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(PlatformModel.class);
        List<PlatformModel> platforms = query.list();
        trans.commit();
        //factory.close();
        session.flush();
        session.close();
        session.disconnect();
        return platforms;
    }      
    
    public static ArrayList<IndividualModel> returnHeterogeneity(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();

        if(seco != null){
        
            String query;
            query = Prefixo+
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Heterogeneity\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnRegenerationAbility(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();

        if(seco != null){
        
            String query;
            query = Prefixo+
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:RegenerationAbility\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnEffortBalance(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();

        if(seco != null){
        
            String query;
            query = Prefixo+
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:EffortBalance\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnExpertiseBalance(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();   
        
        if(seco != null){
        
            String query;
            query = Prefixo+
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:ExpertiseBalance\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnVisibility(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
        
        if(seco != null){
        
            String query;
            query = Prefixo+
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Visibility\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnSustainability(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
              
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Sustainability\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnHealth(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
        
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Health\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnProductivity(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<>();
              
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Productivity\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnDiversity(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
              
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Diversity\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnNicheCreation(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
              
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:NicheCreate\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnInformationConsistence(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
          
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:InformationConsistence\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnInterrelatedness(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
            
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Interrelatedness\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnClustering(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
              
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Clustering\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnFinancialConsistence(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();
              
        if(seco != null){
        
            String query;
            query = Prefixo +
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:FinancialConsistence\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<IndividualModel> returnRobustness(){
        
        IndividualModel model;
        //InfModel seco = OntoConnection.OntoConnection();
        ArrayList<IndividualModel> Result = new ArrayList<IndividualModel>();

        if(seco != null){
        
            String query;
            query = Prefixo+
                    "      SELECT *\n" +
                    "      WHERE \n" +
                    "	{?k rdf:type txt:Robustness\n}";

                    Dataset dataset = DatasetFactory.create(seco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new IndividualModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
    
    public static ArrayList<PlatformModel> returnData(String name){
        
        //PlatformModel model = new PlatformModel();
        PlatformModel model = returnPlatform(name);
        InfModel newseco = salvaIndividuos(model);
        ArrayList<PlatformModel> Result = new ArrayList<PlatformModel>();
              
        if(newseco != null){
        
            String query;
            query = Prefixo +
                    "SELECT *\n" +
                    "WHERE\n" +
                    "{?k data:numberOfCountries ?a.\n" +
                    "?k data:semanticClosenessAvg ?b.\n" +
                    "?k data:numberOfNodeTypes ?c.\n" +
                    "?k data:timeWorkTogether ?d.\n" +
                    "?k data:numberOfNewMembers ?e.\n" +
                    "?k data:DeveloperCommits ?f.\n" +
                    "?k data:activeMembers ?h.\n" +
                    "?k data:numberOfCommunits ?i.\n" +
                    "?k data:totalEffort ?l.\n" +
                    "?k data:numberOfEventParticipants ?o.\n" +
                    "?k data:numberOfJobAdvertisements ?q.\n" +
                    "?k data:numberOfDownloads ?r.\n" +
                    "?k data:numberOfReaders ?u.\n" +
                    "?k data:numberOfScientificPublication ?v.\n" +
                    "?k data:numberOfSocialMediaHits ?w.\n" +
                    "?k data:numberOfWebPageRequests ?x.\n" +
                    "?k data:numberOfDevelopers ?y.\n" +
                    "?k data:numberOfUsersGroups ?z.\n" +
                    "?k data:numberOfProgrammingLanguagesSupported ?aa.\n" +
                    "?k data:existPlanForCollapse ?ac.\n" +
                    "?k data:numberOfProjectsAdded ?ad.\n" +
                    "?k data:numberOfEvents ?ae.\n" +
                    "?k data:numberOfArtifacts ?ag.\n" +
                    "?k data:numberOfTransmittedMessages ?ah.\n" +
                    "?k data:bugFixTime ?ai.\n" +
                    "?k data:numberOfPartnersAdded ?aj.\n" +
                    "?k data:numberOfUsers ?ak.\n" +
                    "?k data:averageTimeUse ?al.\n" +
                    "?k data:numberOfNodesConnections ?am.\n" +
                    "?k data:ConnectivityCapacity ?an.\n" +
                    "?k data:ratioConnectionsCapacity ?ao.\n" +
                    "?k data:nodesCentrality ?ap.\n" +
                    "?k data:numberOfExternalPartners ?aq.\n" +
                    "?k data:numberOfProductTypes ?ar.\n" +
                    "?k data:GreaterCollaboration ?as.\n" +
                    "?k data:numberOfActiveProjects ?at.\n" +
                    "?k data:numberOfPartners ?av.\n" +
                    "?k data:numberOfCommercialSponsors ?aw.\n" +
                    "?k data:TotalContributionValue ?ax.\n" +
                    "?k data:numberOfActiveContributors ?ay.\n" +
                    "?k data:numberOfFrequentUsers ?az.\n" +
                    "?k data:haveDocumentation ?ba.\n" +
                    "?k data:numberOfContributorsTypes ?bb.\n" +
                    "?k data:numberOfTypesAppProjects ?bc.\n" +
                    "?k data:supportNaturalLanguages ?bd.\n" +
                    "?k data:numberOfTypesTechSupported ?be.\n" +
                    "?k data:numberOfTypesDevTechSupported ?bf.\n"+
                    "?k txt:hasParameter ?1.\n" +
                    "?1 data:numberOfCountriesPar ?2.\n" +
                    "?1 data:semanticClosenessAvgPar ?3.\n" +
                    "?1 data:numberOfNodeTypesPar ?4.\n" +
                    "?1 data:timeWorkTogetherPar ?5.\n" +
                    "?1 data:numberOfNewMembersPar ?6.\n" +
                    "?1 data:developerCommitsPar ?7.\n" +
                    "?1 data:activeMembersPar ?9.\n" +
                    "?1 data:numberOfCommunitsPar ?10.\n" +
                    "?1 data:totalEfforPar ?12.\n" +
                    "?1 data:numberOfEventParticipantsPar ?15.\n" +
                    "?1 data:numberOfJobAdvertisementsPar ?17.\n" +
                    "?1 data:numberOfDownloadsPar ?18.\n" +
                    "?1 data:numberOfReadersPar ?21.\n" +
                    "?1 data:numberOfScientificPublicationPar ?22.\n" +
                    "?1 data:numberOfSocialMediaHitsPar ?23.\n" +
                    "?1 data:numberOfWebPageRequestsPar ?24.\n" +
                    "?1 data:numberOfDevelopersPar ?25.\n" +
                    "?1 data:numberOfUsersGroupsPar ?26.\n" +
                    "?1 data:numberOfProgrammingLanguagesSupportedPar ?27.\n" +
                    "?1 data:existPlanForCollapsePar ?29.\n" +
                    "?1 data:numberOfProjectsAddedPar ?30.\n" +
                    "?1 data:numberOfEventsPar ?31.\n" +
                    "?1 data:numberOfArtifactsPar ?33.\n" +
                    "?1 data:numberOfTransmittedMessagesPar ?34.\n" +
                    "?1 data:bugFixTimePar ?35.\n" +
                    "?1 data:numberOfPartnersAddedPar ?36.\n" +
                    "?1 data:numberOfUsersPar ?37.\n" +
                    "?1 data:averageTimeUsePar ?38.\n" +
                    "?1 data:numberOfNodesConnectionsPar ?39.\n" +
                    "?1 data:ConnectivityCapacityPar ?40.\n" +
                    "?1 data:ratioConnectionsCapacityPar ?41.\n" +
                    "?1 data:nodesCentralityPar ?42.\n" +
                    "?1 data:numberOfExternalPartnersPar ?43.\n" +
                    "?1 data:numberOfProductTypesPar ?45.\n" +
                    "?1 data:GreaterCollaborationPar ?46.\n" +
                    "?1 data:numberOfActiveProjectsPar ?47.\n" +
                    "?1 data:numberOfPartnersPar ?49.\n" +
                    "?1 data:numberOfCommercialSponsorsPar ?50.\n" +
                    "?1 data:TotalContributionValuePar ?51.\n" +
                    "?1 data:numberOfActiveContributorsPar ?52.\n" +
                    "?1 data:numberOfFrequentUsersPar ?53.\n" +
                    "?1 data:haveDocumentationPar ?54.\n" +
                    "?1 data:numberOfContributorsTypesPar ?55.\n" +
                    "?1 data:numberOfTypesAppProjectsPar ?56.\n" +
                    "?1 data:supportNaturalLanguagesPar ?57.\n" +
                    "?1 data:numberOfTypesTechSupportedPar ?58.\n" +
                    "?1 data:numberOfTypesDevTechSupportedPar ?59}";
                    
                    Dataset dataset = DatasetFactory.create(newseco);
                    Query consulta = QueryFactory.create(query);
                    QueryExecution qexec = QueryExecutionFactory.create(consulta,dataset);
                    ResultSet resultado = qexec.execSelect();
                while(resultado.hasNext()) {
                    QuerySolution linha = (QuerySolution) resultado.next();
                    model = new PlatformModel();
                    RDFNode subject = linha.get("k");
                    model.setName(subject.toString().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-6.owl#", ""));
                    subject = linha.get("a");
                    model.setNumberOfCountries(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("b");
                    model.setSemanticClosenessAvg(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("c");
                    model.setNumberOfNodeTypes(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("d");
                    model.setTimeWorkTogether(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("e");
                    model.setNumberOfNewMembers(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("f");
                    model.setDeveloperCommits(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("h");
                    model.setActiveMembers(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("i");
                    model.setNumberOfCommunits(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("l");
                    model.setTotalEffor(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("o");
                    model.setNumberOfEventParticipants(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("q");
                    model.setNumberOfJobAdvertisements(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("r");
                    model.setNumberOfDownloads(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("u");
                    model.setNumberOfReaders(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("v");
                    model.setNumberOfScientificPublication(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("w");
                    model.setNumberOfSocialMediaHits(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("x");
                    model.setNumberOfWebPageRequests(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("y");
                    model.setNumberOfDevelopers(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("z");
                    model.setNumberOfUsersGroups(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("aa");
                    model.setNumberOfProgrammingLanguagesSupported(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ac");
                    model.setExistPlanForCollapse(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#string","").replace("\"", ""));
                    subject = linha.get("ad");
                    model.setNumberOfProjectsAdded(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ae");
                    model.setNumberOfEvents(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ag");
                    model.setNumberOfArtifacts(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ah");
                    model.setNumberOfTransmittedMessages(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ai");
                    model.setBugFixTime(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("aj");
                    model.setNumberOfPartnersAdded(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ak");
                    model.setNumberOfUsers(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("al");
                    model.setAverageTimeUse(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("am");
                    model.setNumberOfNodesConnections(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("an");
                    model.setConnectivityCapacity(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ao");
                    model.setRatioConnectionsCapacity(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ap");
                    model.setNodesCentrality(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("aq");
                    model.setNumberOfExternalPartners(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ar");
                    model.setNumberOfProductTypes(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("as");
                    model.setGreaterCollaboration(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("at");
                    model.setNumberOfActiveProjects(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("av");
                    model.setNumberOfPartners(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("aw");
                    model.setNumberOfCommercialSponsors(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ax");
                    model.setTotalContributionValue(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ay");
                    model.setNumberOfActiveContributors(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("az");
                    model.setNumberOfFrequentUsers(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("ba");
                    model.setHaveDocumentation(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#string","").replace("\"", ""));
                    subject = linha.get("bb");
                    model.setNumberOfContributorsTypes(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("bc");
                    model.setNumberOfTypesAppProjects(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("bd");
                    model.setSupportNaturalLanguages(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#string","").replace("\"", ""));
                    subject = linha.get("be");
                    model.setNumberOfTypesTechSupported(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("bf");
                    model.setNumberOfTypesDevTechSupported(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("2");
                    model.setNumberOfCountriesPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("3");
                    model.setSemanticClosenessAvgPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("4");
                    model.setNumberOfNodeTypesPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("5");
                    model.setTimeWorkTogetherPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("6");
                    model.setNumberOfNewMembersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("7");
                    model.setDeveloperCommitsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("9");
                    model.setActiveMembersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("10");
                    model.setNumberOfCommunitsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("12");
                    model.setTotalEfforPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("15");
                    model.setNumberOfEventParticipantsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("17");
                    model.setNumberOfJobAdvertisementsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("18");
                    model.setNumberOfDownloadsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("21");
                    model.setNumberOfReadersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("22");
                    model.setNumberOfScientificPublicationPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("23");
                    model.setNumberOfSocialMediaHitsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("24");
                    model.setNumberOfWebPageRequestsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("25");
                    model.setNumberOfDevelopersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("26");
                    model.setNumberOfUsersGroupsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("27");
                    model.setNumberOfProgrammingLanguagesSupportedPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("29");
                    model.setExistPlanForCollapsePar(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#string","").replace("\"", ""));
                    subject = linha.get("30");
                    model.setNumberOfProjectsAddedPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("31");
                    model.setNumberOfEventsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("33");
                    model.setNumberOfArtifactsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("34");
                    model.setNumberOfTransmittedMessagesPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("35");
                    model.setBugFixTimePar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("36");
                    model.setNumberOfPartnersAddedPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("37");
                    model.setNumberOfUsersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("38");
                    model.setAverageTimeUsePar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("39");
                    model.setNumberOfNodesConnectionsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("40");
                    model.setConnectivityCapacityPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("41");
                    model.setRatioConnectionsCapacityPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("42");
                    model.setNodesCentralityPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("43");
                    model.setNumberOfExternalPartnersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("45");
                    model.setNumberOfProductTypesPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("46");
                    model.setGreaterCollaborationPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("47");
                    model.setNumberOfActiveProjectsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("49");
                    model.setNumberOfPartnersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("50");
                    model.setNumberOfCommercialSponsorsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("51");
                    model.setTotalContributionValuePar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("52");
                    model.setNumberOfActiveContributorsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("53");
                    model.setNumberOfFrequentUsersPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("54");
                    model.setHaveDocumentationPar(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#string","").replace("\"", ""));
                    subject = linha.get("55");
                    model.setNumberOfContributorsTypesPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("56");
                    model.setNumberOfTypesAppProjectsPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("57");
                    model.setSupportNaturalLanguagesPar(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#string","").replace("\"", ""));
                    subject = linha.get("58");
                    model.setNumberOfTypesTechSupportedPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                    subject = linha.get("59");
                    model.setNumberOfTypesDevTechSupportedPar(Integer.parseInt(subject.toString().replace("^^http://www.w3.org/2001/XMLSchema#int","").replace("\"", "")));
                   
                    
                   boolean parametro = false;
                    
                    ArrayList<IndividualModel> lista = returnHeterogeneity();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setHeterogeneity(parametro);
                    parametro = false;
                    
                    lista = returnRegenerationAbility();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setRegenerationAbility(parametro);
                    parametro = false;
                    
                    lista = returnEffortBalance();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setEffortBalance(parametro);
                    parametro = false;
                    
                    lista = returnExpertiseBalance();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setExpertiseBalance(parametro);
                    parametro = false;
                    
                    lista = returnVisibility();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setVisibility(parametro);
                    parametro = false;
                    
                     lista = returnVisibility();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setVisibility(parametro);
                    parametro = false;
                    
                    lista = returnSustainability();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setSustainability(parametro);
                    parametro = false;
                    
                    lista = returnProductivity();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setProductivity(parametro);
                    parametro = false;
                    
                    lista = returnInterrelatedness();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setInterrelatedness(parametro);
                    parametro = false;
                    
                    
                    lista = returnClustering();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setClustering(parametro);
                    parametro = false;
                    
                    lista = returnFinancialConsistence();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setFinancialConsistence(parametro);
                    parametro = false;
                    
                     lista = returnRobustness();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setRobustness(parametro);
                    parametro = false;
                    
                    lista = returnNicheCreation();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setNicheCreation(parametro);
                    parametro = false;
                    
                    lista = returnHealth();
                    for(int i = 0 ; i < lista.size(); i++){
                        if(lista.get(i).getName().equals(model.getName()))
                            parametro = true;
                    }
                    model.setHealth(parametro);
                    
                    Result.add(model);
                }
                return Result;
        }else{
            return null;
        }
    }
   
    public static String createPlatform(PlatformModel model){
        
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();
        
        Serializable save = session.save(model); 
        trans.commit(); 
        factory.close();
        session.flush();
        session.close();
        session.disconnect();
        
        if(save != null){
            return "ok";
        }else{
            return null;
        }
        
    }
    
    public static String savePlatform(PlatformModel model){
        
        PlatformModel upModel = null;
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();    
        String sql = "SELECT * FROM platforms WHERE name = :name";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(PlatformModel.class);
        query.setParameter("name", model.getName());
        List<PlatformModel> platforms = query.list();
                
        for(int i = 0; i < platforms.size(); i++){
            if(platforms.get(i).getName().equals(model.getName())){
                upModel = platforms.get(i);
                break;
            }
        }
        
        if(upModel != null){
            
            model.setId(upModel.getId());
            model.setName(upModel.getName());
            session.merge(model);
            trans.commit();
             factory.close();
            session.flush();
            session.close();
            session.disconnect();
            return "ok";
            
        }else{
            trans.commit();
            factory.close();
            session.flush();
            session.close();
            session.disconnect();
            return null;
        }
        
    }
    
    public static PlatformModel returnPlatform(String name){
        PlatformModel returnModel = null;
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();    
        String sql = "SELECT * FROM platforms WHERE name = :name";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(PlatformModel.class);
        query.setParameter("name", name);
        List<PlatformModel> platforms = query.list();
        trans.commit();
        factory.close();
        session.flush();
        session.close();
        session.disconnect();
        
        for(int i = 0; i < platforms.size(); i++){
            if(platforms.get(i).getName().equals(name)){
                returnModel = platforms.get(i);
                break;
            }
        }
        
        if(returnModel != null){
            return returnModel;
        }else{
            return null;
        }
    }
        
    
    public static InfModel salvaIndividuos(PlatformModel platform){
                
        //if(sec == null){
        sec = OntoConnection.OntoConnectionSInferencia();
        //}
        
        Resource plat = sec.getResource(URI+"#Platform");
        Resource par = sec.getResource(URI+"#Parameter");
        Individual p = sec.createIndividual(platform.getName(), plat);
        Individual pa = sec.createIndividual(platform.getName() + "Par", par);
        Individual platfor = sec.getIndividual(p.getURI());
        Individual param = sec.getIndividual(pa.getURI());
             
        
        
       	DatatypeProperty ConnectivityCapacity = sec.getDatatypeProperty(URI + "#ConnectivityCapacity");
        platfor.addProperty(ConnectivityCapacity, String.valueOf(platform.getConnectivityCapacity()));

        DatatypeProperty DeveloperCommits = sec.getDatatypeProperty(URI + "#DeveloperCommits");
        platfor.addProperty(DeveloperCommits, String.valueOf(platform.getDeveloperCommits()));

        DatatypeProperty GreaterCollaboration = sec.getDatatypeProperty(URI + "#GreaterCollaboration");
        platfor.addProperty(GreaterCollaboration, String.valueOf(platform.getGreaterCollaboration()));

        DatatypeProperty TotalContributionValue = sec.getDatatypeProperty(URI + "#TotalContributionValue");
        platfor.addProperty(TotalContributionValue, String.valueOf(platform.getTotalContributionValue()));

		DatatypeProperty activeMembers = sec.getDatatypeProperty(URI + "#activeMembers");
        platfor.addProperty(activeMembers, String.valueOf(platform.getActiveMembers()));

        DatatypeProperty averageTimeUse = sec.getDatatypeProperty(URI + "#averageTimeUse");
        platfor.addProperty(averageTimeUse, String.valueOf(platform.getAverageTimeUse()));

        DatatypeProperty bugFixTime = sec.getDatatypeProperty(URI + "#bugFixTime");
        platfor.addProperty(bugFixTime, String.valueOf(platform.getBugFixTime()));

        DatatypeProperty existPlanForCollapse = sec.getDatatypeProperty(URI + "#existPlanForCollapse");
        platfor.addProperty(existPlanForCollapse, String.valueOf(platform.getExistPlanForCollapse()));

        DatatypeProperty haveDocumentation = sec.getDatatypeProperty(URI + "#haveDocumentation");
        platfor.addProperty(haveDocumentation, String.valueOf(platform.getHaveDocumentation()));

        DatatypeProperty nodesCentrality = sec.getDatatypeProperty(URI + "#nodesCentrality");
        platfor.addProperty(nodesCentrality, String.valueOf(platform.getNodesCentrality()));

        DatatypeProperty numberOfActiveContributors = sec.getDatatypeProperty(URI + "#numberOfActiveContributors");
        platfor.addProperty(numberOfActiveContributors, String.valueOf(platform.getNumberOfActiveContributors()));

        DatatypeProperty numberOfActiveProjects = sec.getDatatypeProperty(URI + "#numberOfActiveProjects");
        platfor.addProperty(numberOfActiveProjects, String.valueOf(platform.getNumberOfActiveProjects()));

        DatatypeProperty numberOfArtifacts = sec.getDatatypeProperty(URI + "#numberOfArtifacts");
        platfor.addProperty(numberOfArtifacts, String.valueOf(platform.getNumberOfArtifacts()));

        DatatypeProperty numberOfCommercialSponsors = sec.getDatatypeProperty(URI + "#numberOfCommercialSponsors");
        platfor.addProperty(numberOfCommercialSponsors, String.valueOf(platform.getNumberOfCommercialSponsors()));

        DatatypeProperty numberOfCommunits = sec.getDatatypeProperty(URI + "#numberOfCommunits");
        platfor.addProperty(numberOfCommunits, String.valueOf(platform.getNumberOfCommunits()));

        DatatypeProperty numberOfContributorsTypes = sec.getDatatypeProperty(URI + "#numberOfContributorsTypes");
        platfor.addProperty(numberOfContributorsTypes, String.valueOf(platform.getNumberOfContributorsTypes()));

        DatatypeProperty numberOfCountries = sec.getDatatypeProperty(URI + "#numberOfCountries");
        platfor.addProperty(numberOfCountries, String.valueOf(platform.getNumberOfCountries()));

        DatatypeProperty numberOfDevelopers = sec.getDatatypeProperty(URI + "#numberOfDevelopers");
        platfor.addProperty(numberOfDevelopers, String.valueOf(platform.getNumberOfDevelopers()));

        DatatypeProperty numberOfDownloads = sec.getDatatypeProperty(URI + "#numberOfDownloads");
        platfor.addProperty(numberOfDownloads, String.valueOf(platform.getNumberOfDownloads()));

        DatatypeProperty numberOfEventParticipants = sec.getDatatypeProperty(URI + "#numberOfEventParticipants");
        platfor.addProperty(numberOfEventParticipants, String.valueOf(platform.getNumberOfEventParticipants()));

        DatatypeProperty numberOfEvents = sec.getDatatypeProperty(URI + "#numberOfEvents");
        platfor.addProperty(numberOfEvents, String.valueOf(platform.getNumberOfEvents()));

        DatatypeProperty numberOfExternalPartners = sec.getDatatypeProperty(URI + "#numberOfExternalPartners");
        platfor.addProperty(numberOfExternalPartners, String.valueOf(platform.getNumberOfExternalPartners()));

        DatatypeProperty numberOfFrequentUsers = sec.getDatatypeProperty(URI + "#numberOfFrequentUsers");
        platfor.addProperty(numberOfFrequentUsers, String.valueOf(platform.getNumberOfFrequentUsers()));

        DatatypeProperty numberOfJobAdvertisements = sec.getDatatypeProperty(URI + "#numberOfJobAdvertisements");
        platfor.addProperty(numberOfJobAdvertisements, String.valueOf(platform.getNumberOfJobAdvertisements()));

        DatatypeProperty numberOfNewMembers = sec.getDatatypeProperty(URI + "#numberOfNewMembers");
        platfor.addProperty(numberOfNewMembers, String.valueOf(platform.getNumberOfNewMembers()));

        DatatypeProperty numberOfNodeTypes = sec.getDatatypeProperty(URI + "#numberOfNodeTypes");
        platfor.addProperty(numberOfNodeTypes, String.valueOf(platform.getNumberOfNodeTypes()));

        DatatypeProperty numberOfNodesConnections = sec.getDatatypeProperty(URI + "#numberOfNodesConnections");
        platfor.addProperty(numberOfNodesConnections, String.valueOf(platform.getNumberOfNodesConnections()));

        DatatypeProperty numberOfPartners = sec.getDatatypeProperty(URI + "#numberOfPartners");
        platfor.addProperty(numberOfPartners, String.valueOf(platform.getNumberOfPartners()));

        DatatypeProperty numberOfPartnersAdded = sec.getDatatypeProperty(URI + "#numberOfPartnersAdded");
        platfor.addProperty(numberOfPartnersAdded, String.valueOf(platform.getNumberOfPartnersAdded()));

		DatatypeProperty numberOfProductTypes = sec.getDatatypeProperty(URI + "#numberOfProductTypes");
        platfor.addProperty(numberOfProductTypes, String.valueOf(platform.getNumberOfProductTypes()));

        DatatypeProperty numberOfProgrammingLanguagesSupported = sec.getDatatypeProperty(URI + "#numberOfProgrammingLanguagesSupported");
        platfor.addProperty(numberOfProgrammingLanguagesSupported, String.valueOf(platform.getNumberOfProgrammingLanguagesSupported()));

        DatatypeProperty numberOfProjectsAdded = sec.getDatatypeProperty(URI + "#numberOfProjectsAdded");
        platfor.addProperty(numberOfProjectsAdded, String.valueOf(platform.getNumberOfProjectsAdded()));

        DatatypeProperty numberOfReaders = sec.getDatatypeProperty(URI + "#numberOfReaders");
        platfor.addProperty(numberOfReaders, String.valueOf(platform.getNumberOfReaders()));

        DatatypeProperty numberOfScientificPublication = sec.getDatatypeProperty(URI + "#numberOfScientificPublication");
        platfor.addProperty(numberOfScientificPublication, String.valueOf(platform.getNumberOfScientificPublication()));

        DatatypeProperty numberOfSocialMediaHits = sec.getDatatypeProperty(URI + "#numberOfSocialMediaHits");
        platfor.addProperty(numberOfSocialMediaHits, String.valueOf(platform.getNumberOfSocialMediaHits()));

        DatatypeProperty numberOfTransmittedMessages = sec.getDatatypeProperty(URI + "#numberOfTransmittedMessages");
        platfor.addProperty(numberOfTransmittedMessages, String.valueOf(platform.getNumberOfTransmittedMessages()));

        DatatypeProperty numberOfTypesAppProjects = sec.getDatatypeProperty(URI + "#numberOfTypesAppProjects");
        platfor.addProperty(numberOfTypesAppProjects, String.valueOf(platform.getNumberOfTypesAppProjects()));

        DatatypeProperty numberOfTypesDevTechSupported = sec.getDatatypeProperty(URI + "#numberOfTypesDevTechSupported");
        platfor.addProperty(numberOfTypesDevTechSupported, String.valueOf(platform.getNumberOfTypesDevTechSupported()));

        DatatypeProperty numberOfTypesTechSupported = sec.getDatatypeProperty(URI + "#numberOfTypesTechSupported");
        platfor.addProperty(numberOfTypesTechSupported, String.valueOf(platform.getNumberOfTypesTechSupported()));

        DatatypeProperty numberOfUsers = sec.getDatatypeProperty(URI + "#numberOfUsers");
        platfor.addProperty(numberOfUsers, String.valueOf(platform.getNumberOfUsers()));

        DatatypeProperty numberOfUsersGroups = sec.getDatatypeProperty(URI + "#numberOfUsersGroups");
        platfor.addProperty(numberOfUsersGroups, String.valueOf(platform.getNumberOfUsersGroups()));

        DatatypeProperty numberOfWebPageRequests = sec.getDatatypeProperty(URI + "#numberOfWebPageRequests");
        platfor.addProperty(numberOfWebPageRequests, String.valueOf(platform.getNumberOfWebPageRequests()));

        DatatypeProperty ratioConnectionsCapacity = sec.getDatatypeProperty(URI + "#ratioConnectionsCapacity");
        platfor.addProperty(ratioConnectionsCapacity, String.valueOf(platform.getRatioConnectionsCapacity()));

        DatatypeProperty semanticClosenessAvg = sec.getDatatypeProperty(URI + "#semanticClosenessAvg");
        platfor.addProperty(semanticClosenessAvg, String.valueOf(platform.getSemanticClosenessAvg()));

        DatatypeProperty supportNaturalLanguages = sec.getDatatypeProperty(URI + "#supportNaturalLanguages");
        platfor.addProperty(supportNaturalLanguages, String.valueOf(platform.getSupportNaturalLanguages()));

        DatatypeProperty timeWorkTogether = sec.getDatatypeProperty(URI + "#timeWorkTogether");
        platfor.addProperty(timeWorkTogether, String.valueOf(platform.getTimeWorkTogether()));

        DatatypeProperty totalEffort = sec.getDatatypeProperty(URI + "#totalEffort");
        platfor.addProperty(totalEffort, String.valueOf(platform.getTotalEffor()));

        DatatypeProperty ConnectivityCapacityPar = sec.getDatatypeProperty(URI + "#ConnectivityCapacityPar");
        param.addProperty(ConnectivityCapacityPar, String.valueOf(platform.getConnectivityCapacityPar()));

        DatatypeProperty GreaterCollaborationPar = sec.getDatatypeProperty(URI + "#GreaterCollaborationPar");
        param.addProperty(GreaterCollaborationPar, String.valueOf(platform.getGreaterCollaborationPar()));

        DatatypeProperty TotalContributionValuePar = sec.getDatatypeProperty(URI + "#TotalContributionValuePar");
        param.addProperty(TotalContributionValuePar, String.valueOf(platform.getTotalContributionValuePar()));

        DatatypeProperty activeMembersPar = sec.getDatatypeProperty(URI + "#activeMembersPar");
        param.addProperty(activeMembersPar, String.valueOf(platform.getActiveMembersPar()));

		DatatypeProperty averageTimeUsePar = sec.getDatatypeProperty(URI + "#averageTimeUsePar");
        param.addProperty(averageTimeUsePar, String.valueOf(platform.getAverageTimeUsePar()));

        DatatypeProperty bugFixTimePar = sec.getDatatypeProperty(URI + "#bugFixTimePar");
        param.addProperty(bugFixTimePar, String.valueOf(platform.getBugFixTimePar()));

        DatatypeProperty developerCommitsPar = sec.getDatatypeProperty(URI + "#developerCommitsPar");
        param.addProperty(developerCommitsPar, String.valueOf(platform.getDeveloperCommitsPar()));

        DatatypeProperty existPlanForCollapsePar = sec.getDatatypeProperty(URI + "#existPlanForCollapsePar");
        param.addProperty(existPlanForCollapsePar, String.valueOf(platform.getExistPlanForCollapsePar()));

        DatatypeProperty haveDocumentationPar = sec.getDatatypeProperty(URI + "#haveDocumentationPar");
        param.addProperty(haveDocumentationPar, String.valueOf(platform.getHaveDocumentationPar()));

        DatatypeProperty nodesCentralityPar = sec.getDatatypeProperty(URI + "#nodesCentralityPar");
        param.addProperty(nodesCentralityPar, String.valueOf(platform.getNodesCentralityPar()));

        DatatypeProperty numberOfActiveContributorsPar = sec.getDatatypeProperty(URI + "#numberOfActiveContributorsPar");
        param.addProperty(numberOfActiveContributorsPar, String.valueOf(platform.getNumberOfActiveContributorsPar()));

        DatatypeProperty numberOfActiveProjectsPar = sec.getDatatypeProperty(URI + "#numberOfActiveProjectsPar");
        param.addProperty(numberOfActiveProjectsPar, String.valueOf(platform.getNumberOfActiveProjectsPar()));

        DatatypeProperty numberOfArtifactsPar = sec.getDatatypeProperty(URI + "#numberOfArtifactsPar");
        param.addProperty(numberOfArtifactsPar, String.valueOf(platform.getNumberOfArtifactsPar()));

        DatatypeProperty numberOfCommercialSponsorsPar = sec.getDatatypeProperty(URI + "#numberOfCommercialSponsorsPar");
        param.addProperty(numberOfCommercialSponsorsPar, String.valueOf(platform.getNumberOfCommercialSponsorsPar()));

        DatatypeProperty numberOfCommunitsPar = sec.getDatatypeProperty(URI + "#numberOfCommunitsPar");
        param.addProperty(numberOfCommunitsPar, String.valueOf(platform.getNumberOfCommunitsPar()));

        DatatypeProperty numberOfContributorsTypesPar = sec.getDatatypeProperty(URI + "#numberOfContributorsTypesPar");
        param.addProperty(numberOfContributorsTypesPar, String.valueOf(platform.getNumberOfContributorsTypesPar()));

        DatatypeProperty numberOfCountriesPar = sec.getDatatypeProperty(URI + "#numberOfCountriesPar");
        param.addProperty(numberOfCountriesPar, String.valueOf(platform.getNumberOfCountriesPar()));

        DatatypeProperty numberOfDevelopersPar = sec.getDatatypeProperty(URI + "#numberOfDevelopersPar");
        param.addProperty(numberOfDevelopersPar, String.valueOf(platform.getNumberOfDevelopersPar()));

        DatatypeProperty numberOfDownloadsPar = sec.getDatatypeProperty(URI + "#numberOfDownloadsPar");
        param.addProperty(numberOfDownloadsPar, String.valueOf(platform.getNumberOfDownloadsPar()));

        DatatypeProperty numberOfEventParticipantsPar = sec.getDatatypeProperty(URI + "#numberOfEventParticipantsPar");
        param.addProperty(numberOfEventParticipantsPar, String.valueOf(platform.getNumberOfEventParticipantsPar()));

		DatatypeProperty numberOfEventsPar = sec.getDatatypeProperty(URI + "#numberOfEventsPar");
        param.addProperty(numberOfEventsPar, String.valueOf(platform.getNumberOfEventsPar()));

        DatatypeProperty numberOfExternalPartnersPar = sec.getDatatypeProperty(URI + "#numberOfExternalPartnersPar");
        param.addProperty(numberOfExternalPartnersPar, String.valueOf(platform.getNumberOfExternalPartnersPar()));

        DatatypeProperty numberOfFrequentUsersPar = sec.getDatatypeProperty(URI + "#numberOfFrequentUsersPar");
        param.addProperty(numberOfFrequentUsersPar, String.valueOf(platform.getNumberOfFrequentUsersPar()));

        DatatypeProperty numberOfJobAdvertisementsPar = sec.getDatatypeProperty(URI + "#numberOfJobAdvertisementsPar");
        param.addProperty(numberOfJobAdvertisementsPar, String.valueOf(platform.getNumberOfJobAdvertisementsPar()));

        DatatypeProperty numberOfNewMembersPar = sec.getDatatypeProperty(URI + "#numberOfNewMembersPar");
        param.addProperty(numberOfNewMembersPar, String.valueOf(platform.getNumberOfNewMembersPar()));

        DatatypeProperty numberOfNodeTypesPar = sec.getDatatypeProperty(URI + "#numberOfNodeTypesPar");
        param.addProperty(numberOfNodeTypesPar, String.valueOf(platform.getNumberOfNodeTypesPar()));

        DatatypeProperty numberOfNodesConnectionsPar = sec.getDatatypeProperty(URI + "#numberOfNodesConnectionsPar");
        param.addProperty(numberOfNodesConnectionsPar, String.valueOf(platform.getNumberOfNodesConnectionsPar()));

        DatatypeProperty numberOfPartnersAddedPar = sec.getDatatypeProperty(URI + "#numberOfPartnersAddedPar");
        param.addProperty(numberOfPartnersAddedPar, String.valueOf(platform.getNumberOfPartnersAddedPar()));

        DatatypeProperty numberOfPartnersPar = sec.getDatatypeProperty(URI + "#numberOfPartnersPar");
        param.addProperty(numberOfPartnersPar, String.valueOf(platform.getNumberOfPartnersPar()));

        DatatypeProperty numberOfProductTypesPar = sec.getDatatypeProperty(URI + "#numberOfProductTypesPar");
        param.addProperty(numberOfProductTypesPar, String.valueOf(platform.getNumberOfProductTypesPar()));

        DatatypeProperty numberOfProgrammingLanguagesSupportedPar = sec.getDatatypeProperty(URI + "#numberOfProgrammingLanguagesSupportedPar");
        param.addProperty(numberOfProgrammingLanguagesSupportedPar, String.valueOf(platform.getNumberOfProgrammingLanguagesSupportedPar()));

        DatatypeProperty numberOfProjectsAddedPar = sec.getDatatypeProperty(URI + "#numberOfProjectsAddedPar");
        param.addProperty(numberOfProjectsAddedPar, String.valueOf(platform.getNumberOfProjectsAddedPar()));

        DatatypeProperty numberOfReadersPar = sec.getDatatypeProperty(URI + "#numberOfReadersPar");
        param.addProperty(numberOfReadersPar, String.valueOf(platform.getNumberOfReadersPar()));

        DatatypeProperty numberOfScientificPublicationPar = sec.getDatatypeProperty(URI + "#numberOfScientificPublicationPar");
        param.addProperty(numberOfScientificPublicationPar, String.valueOf(platform.getNumberOfScientificPublicationPar()));

        DatatypeProperty numberOfSocialMediaHitsPar = sec.getDatatypeProperty(URI + "#numberOfSocialMediaHitsPar");
        param.addProperty(numberOfSocialMediaHitsPar, String.valueOf(platform.getNumberOfSocialMediaHitsPar()));

        DatatypeProperty numberOfTransmittedMessagesPar = sec.getDatatypeProperty(URI + "#numberOfTransmittedMessagesPar");
        param.addProperty(numberOfTransmittedMessagesPar, String.valueOf(platform.getNumberOfTransmittedMessagesPar()));

        DatatypeProperty numberOfTypesAppProjectsPar = sec.getDatatypeProperty(URI + "#numberOfTypesAppProjectsPar");
        param.addProperty(numberOfTypesAppProjectsPar, String.valueOf(platform.getNumberOfTypesAppProjectsPar()));

        DatatypeProperty numberOfTypesDevTechSupportedPar = sec.getDatatypeProperty(URI + "#numberOfTypesDevTechSupportedPar");
        param.addProperty(numberOfTypesDevTechSupportedPar, String.valueOf(platform.getNumberOfTypesDevTechSupportedPar()));

        DatatypeProperty numberOfTypesTechSupportedPar = sec.getDatatypeProperty(URI + "#numberOfTypesTechSupportedPar");
        param.addProperty(numberOfTypesTechSupportedPar, String.valueOf(platform.getNumberOfTypesTechSupportedPar()));

        DatatypeProperty numberOfUsersGroupsPar = sec.getDatatypeProperty(URI + "#numberOfUsersGroupsPar");
        param.addProperty(numberOfUsersGroupsPar, String.valueOf(platform.getNumberOfUsersGroupsPar()));

        DatatypeProperty numberOfUsersPar = sec.getDatatypeProperty(URI + "#numberOfUsersPar");
        param.addProperty(numberOfUsersPar, String.valueOf(platform.getNumberOfUsersPar()));

        DatatypeProperty numberOfWebPageRequestsPar = sec.getDatatypeProperty(URI + "#numberOfWebPageRequestsPar");
        param.addProperty(numberOfWebPageRequestsPar, String.valueOf(platform.getNumberOfWebPageRequestsPar()));

        DatatypeProperty ratioConnectionsCapacityPar = sec.getDatatypeProperty(URI + "#ratioConnectionsCapacityPar");
        param.addProperty(ratioConnectionsCapacityPar, String.valueOf(platform.getRatioConnectionsCapacityPar()));

        DatatypeProperty semanticClosenessAvgPar = sec.getDatatypeProperty(URI + "#semanticClosenessAvgPar");
        param.addProperty(semanticClosenessAvgPar, String.valueOf(platform.getSemanticClosenessAvgPar()));

        DatatypeProperty supportNaturalLanguagesPar = sec.getDatatypeProperty(URI + "#supportNaturalLanguagesPar");
        param.addProperty(supportNaturalLanguagesPar, String.valueOf(platform.getSupportNaturalLanguagesPar()));

        DatatypeProperty timeWorkTogetherPar = sec.getDatatypeProperty(URI + "#timeWorkTogetherPar");
        param.addProperty(timeWorkTogetherPar, String.valueOf(platform.getTimeWorkTogetherPar()));

        DatatypeProperty totalEfforPar = sec.getDatatypeProperty(URI + "#totalEfforPar");
        param.addProperty(totalEfforPar, String.valueOf(platform.getTotalEfforPar()));
				
		
        ObjectProperty hasParameter = sec.getObjectProperty(URI+"#hasParameter");        
        platfor.addProperty(hasParameter, param);
        
               
        Reasoner reasoner = (Reasoner) PelletReasonerFactory.theInstance().create();
        reasoner = reasoner.bindSchema(sec);
        InfModel infmodel = ModelFactory.createInfModel(reasoner,sec);
        infmodel.prepare();
        
        return infmodel;     
    }
    
    
    
    
    
    
    /*
    public static PlatformModel retornaPlatform(String nome){
        
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        
        PlatformModel modelSave = (PlatformModel) session.load(PlatformModel.class, 1);
        //model.setId(modelSave.getId());
        //session.saveOrUpdate(model); 
        
        //Query qr = session.createQuery("from minhaentidade me where me.descricao = ?1");
        //qr.setParameter(1,parametro);
        //return qr.getResultList();
        
        trans.commit();
        session.close();
        
        return null;
        
    }
    
    public List<String> retornaSavedPlatforms(){
        ArrayList<String> list = new ArrayList<String>();
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        
        org.hibernate.Query qr = session.createQuery("from platforms");
        List<String> preencher = qr.list();
        
        for(int i = 0; i<preencher.size(); i++){
            list.add(preencher.get(i));
        }
        
        return list;
    }*/
    
}
