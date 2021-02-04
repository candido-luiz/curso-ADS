package pased;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtil {
    public static boolean gravarObjeto(Object obj, String caminho){
        File arquivo = new File(caminho);
        if(! arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        
        try{
            FileOutputStream fileOutput = new FileOutputStream(arquivo);
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
          
            objOutput.writeObject(obj);
            
            objOutput.flush();
            fileOutput.flush();
            
            objOutput.close();
            fileOutput.close();
            
            return true;
            
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public static Object recuperarObjeto(Object obj,String caminho){
        
        File arquivo = new File(caminho);
        
        if(! arquivo.exists()){
            try {
                FileUtil.gravarObjeto(obj, caminho);
            } catch (Exception e){
                e.printStackTrace();
            }
            return obj;
        }else{
            try{
                FileInputStream fileInput = new FileInputStream(arquivo);
                ObjectInputStream objInput = new ObjectInputStream(fileInput);

                Object retorno = objInput.readObject();

                objInput.close();
                fileInput.close();

                return retorno;


            } catch (Exception e ){
                e.printStackTrace();
                return null;
            }
        }
    }
}