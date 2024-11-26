public class Document{
    String fileName;
    


    public Document(){
        this("documentTitle.ext");
        
    }

    public Document(String fileName){
        this.fileName = fileName;
        
    }

    public String getFileName(){
        return fileName;
    }

    @Override
    public String toString(){
        return String.format("%s\n",fileName);
    }
}