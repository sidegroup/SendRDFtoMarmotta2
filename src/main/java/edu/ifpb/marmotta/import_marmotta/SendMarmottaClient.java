package edu.ifpb.marmotta.import_marmotta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.marmotta.client.ClientConfiguration;
import org.apache.marmotta.client.clients.ImportClient;
import org.apache.marmotta.client.exception.MarmottaClientException;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.Rio;


public class SendMarmottaClient {

	public static void main(String[] args) {
		String path = "people.rdf";
		String context = "";
		ClientConfiguration configuration = new ClientConfiguration("http://127.0.0.1:8080/marmotta/");
		ImportClient importClient = new ImportClient(configuration);
		System.out.println("foi");
		InputStream is = null;
		try {
			is = new FileInputStream(new File(path));
			RDFFormat format = Rio.getParserFormatForFileName(path);
			importClient.uploadDataset(is, "application/rdf+xml");//format.getDefaultMIMEType(), context);
		} catch (IOException | MarmottaClientException e) {
			e.printStackTrace();
		}
		
	}
}
