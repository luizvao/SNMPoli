package br.poli.ecomp.gr.snmpoli.pojo;

import br.poli.ecomp.gr.snmpoli.interfaces.Encodable;

public class VarBind implements Encodable {

	private int[] objectId;
	private int[] value;

	public byte[] encode() {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] getObjectId() {
		return objectId;
	}

	public void setObjectId(int[] objectId) {
		this.objectId = objectId;
	}

	public int[] getValue() {
		return value;
	}

	public void setValue(int[] value) {
		this.value = value;
	}

}
