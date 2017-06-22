package myNLProject;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
 
 
import java.util.*;
 
public class MySentimentAnalyser
{
    public static void main( String[] args )
    {
    	
        Properties pipelineProps = new Properties();
        Properties tokenizerProps = new Properties();
        pipelineProps.setProperty("annotators", "parse, sentiment");
        pipelineProps.setProperty("parse.binaryTrees", "true");
        pipelineProps.setProperty("enforceRequirements", "false");
        tokenizerProps.setProperty("annotators", "tokenize ssplit");
        StanfordCoreNLP tokenizer = new StanfordCoreNLP(tokenizerProps);
        StanfordCoreNLP pipeline = new StanfordCoreNLP(pipelineProps);
        
        System.out.println("Since you nd emotions u knw ;D for yah..Type in emotionsss ;))");
        Scanner sc=new Scanner(System.in);
        String emotion=sc.nextLine().toString();
           Annotation annotation = tokenizer.process(emotion);
        pipeline.annotate(annotation);
        // normal output
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            String output = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            System.out.println(output);
        }
    }
}