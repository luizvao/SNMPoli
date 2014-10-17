package br.poli.ecomp.gr.snmpoli.pojo;

import java.io.IOException;

import br.poli.ecomp.gr.snmpoli.constant.DataType;
import br.poli.ecomp.gr.snmpoli.interfaces.Encodable;
import br.poli.ecomp.gr.snmpoli.util.ByteArrayBuilder;

public class SNMPMessage implements Encodable {

	private int version;
	private char[] community;
	private SNMPPDU snmpPDU;

	public byte[] encode() {
		ByteArrayBuilder builder = new ByteArrayBuilder();
		try {
			int length = 30; // FIXME
			
			builder.writeInt(DataType.SEQUENCE)
			.writeInt(length)
			
			.writeInt(DataType.INTEGER)
			.writeInt(1)
			.writeInt(version)
			
			.writeInt(DataType.OCTET_STRING)
			.writeInt(community.length)
			.writeBytes(community)
			
			.writeBytes(snmpPDU.encode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.getBytes();
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
