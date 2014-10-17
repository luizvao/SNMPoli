package br.poli.ecomp.gr.snmpoli.pojo;

import br.poli.ecomp.gr.snmpoli.interfaces.Encodable;

public class SNMPMessage implements Encodable {

	private int version;
	private char[] community;
	private SNMPPDU snmpPDU;

	public byte[] encode() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setCommunity(char[] community) {
		this.community = community;
	}

	public void setSnmpPDU(SNMPPDU snmpPDU) {
		this.snmpPDU = snmpPDU;
	}

	public int getVersion() {
		return version;
	}

	public char[] getCommunity() {
		return community;
	}

	public SNMPPDU getSnmpPDU() {
		return snmpPDU;
	}
}
