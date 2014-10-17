package br.poli.ecomp.gr.snmpoli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.poli.ecomp.gr.snmpoli.network.RequestManager;
import br.poli.ecomp.gr.snmpoli.pojo.SNMPMessage;
import br.poli.ecomp.gr.snmpoli.pojo.SNMPPDU;
import br.poli.ecomp.gr.snmpoli.pojo.VarBind;

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

			List<VarBind> varBinds = new ArrayList<VarBind>();
			VarBind varBindA = new VarBind();
			varBindA.setObjectId(new int[] { 1, 3, 6, 1, 2, 1, 1, 3, 0 });
			varBindA.setValue(new int[] { 1339 });
			varBinds.add(varBindA);

			SNMPPDU snmpPDU = new SNMPPDU();
			snmpPDU.setErrorIndex(0);
			snmpPDU.setErrorStatus(SNMPPDU.ERROR_STATUS.NO_ERROR);
			snmpPDU.setRequestId(4);
			snmpPDU.setVarbinds(varBinds);

			SNMPMessage message = new SNMPMessage();
			message.setVersion(1);
			message.setCommunity("public".toCharArray());
			message.setSnmpPDU(snmpPDU);

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
