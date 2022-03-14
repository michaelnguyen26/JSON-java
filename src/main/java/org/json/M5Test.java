package org.json;

import java.io.StringReader;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class M5Test {
    public static void main(String[] args) {

        String xml = "<?xml version=\"1.0\"?>\n" +
        "<catalog>\n" +
        "    <book id=\"bk101\">\n" +
        "        <author>Gambardella, Matthew</author>\n" +
        "        <title>XML Developer's Guide</title>\n" +
        "    </book>\n" +
        "    <book id=\"bk102\">\n" +
        "        <author>Ralls, Kim</author>\n" +
        "        <title>Midnight Rain</title>\n" +
        "    </book>"+
        "    </catalog>" ;

        // String xml2 = 
        // "<Books>" +
        //     "<book>" +
        //         "<title>AAA</title>" +
        //         "<author>ASmith</author>" +
        //     "</book>" +

        //     "<book>" +
        //         "<title>BBB</title>" +
        //         "<author>BSmith</author>" +
        //     "</book>" +
        // "</Books>";
        


        // Milestone 5

        System.out.println("\n-------------- Milestone 5 --------------\n\n");

        Consumer<Exception> sendError = (err) -> System.out.println(err);

        try {
            final long startTime = System.currentTimeMillis();
            
            CompletableFuture<JSONObject> jobj = XML.toJSONObject(new StringReader(xml), sendError);
            
            System.out.println(">> This should run first! (Asynchronous)\n");

            while(!jobj.isDone()){          
            }

            final long endTime = System.currentTimeMillis();
            System.out.println("\n--------- Async Done! Runtime: " + (endTime - startTime) + " ms ---------\n");
            System.out.println();

            // The get returns a result every time it’s invoked.
            System.out.println(jobj.get().toString(4));
          
   
        } catch (JSONException e) {
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}