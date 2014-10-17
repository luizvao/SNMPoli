package br.poli.ecomp.gr.snmpoli.pojo;

import java.io.IOException;

import br.poli.ecomp.gr.snmpoli.constant.DataType;
import br.poli.ecomp.gr.snmpoli.interfaces.Encodable;
import br.poli.ecomp.gr.snmpoli.util.ByteArrayBuilder;

public class VarBind implements Encodable {

	private int[] objectId;
	private int[] value;
	private int length;

	public byte[] encode() {
		ByteArrayBuilder builder = new ByteArrayBuilder();
		try {
			builder.writeInt(DataType.SEQUENCE)
			.writeInt(length) // FIXME
			
			.writeInt(DataType.OID)
			.writeInt(objectId.length)
			.writeInts(objectId)
			
			.writeInt(DataType.NULL)
			.writeInt(value.length)
			.writeInts(value);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.getBytes();
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
