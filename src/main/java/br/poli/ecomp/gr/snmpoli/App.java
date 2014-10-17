package br.poli.ecomp.gr.snmpoli;

import java.io.IOException;

import br.poli.ecomp.gr.snmpoli.network.RequestManager;
import br.poli.ecomp.gr.snmpoli.pojo.SNMPMessage;

/**
 * SNMPoli - Simple Network Management Protocol tool
 * 
 * Network Management, eComp Escola Politécnica de Pernambuco 2014.2
 * 
 * @version 0.0.1
 * @author Gearlles Viana
 * @author Milla Alcoforado
 * @author Nestor Maciel
 */
public class App {

	public static void main(String[] args) {
		try {
			SNMPMessage message = null;
			RequestManager manager = new RequestManager("localhost", 161);
			manager.connect();
			for (int i = 0; i < 5; i++) {
				manager.send(message);
				String response = manager.getResponse();
				System.out.println(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
