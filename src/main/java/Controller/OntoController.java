/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.IndividualModel;
import Model.PlatformModel;
import OntoDAO.OntoDAO;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author icarv
 */
public class OntoController {
        
    public static List<PlatformModel> returnPlatforms(){
        return OntoDAO.returnPlatforms();
    }    
        
    public static ArrayList<PlatformModel> returnData(String name){
        return OntoDAO.returnData(name);
    } 
     
   
    public static String createPlatform(PlatformModel model){
        return OntoDAO.createPlatform(model);
    }
    
    public static String savePlatform(PlatformModel model){
        return OntoDAO.savePlatform(model);
    }
    
    public static PlatformModel returnPlatform(String name){
        return OntoDAO.returnPlatform(name);
    }
    
}
