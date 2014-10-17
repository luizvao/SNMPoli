package br.poli.ecomp.gr.snmpoli.pojo;

import java.io.IOException;
import java.util.List;

import br.poli.ecomp.gr.snmpoli.interfaces.Encodable;
import br.poli.ecomp.gr.snmpoli.util.ByteArrayBuilder;

public class SNMPPDU implements Encodable {

	private int requestId;
	private int errorStatus;
	private int errorIndex;
	private List<VarBind> varbinds;

	public byte[] encode() {
		ByteArrayBuilder builder = new ByteArrayBuilder();
		try {
			builder.writeInt(requestId)
			.writeInt(errorStatus)
			.writeInt(errorIndex);
			for (VarBind varBind : varbinds) {
				builder.writeBytes(varBind.encode());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.getBytes();
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}

	public int getErrorIndex() {
		return errorIndex;
	}

	public void setErrorIndex(int errorIndex) {
		this.errorIndex = errorIndex;
	}

	public List<VarBind> getVarbinds() {
		return varbinds;
	}

	public void setVarbinds(List<VarBind> varbinds) {
		this.varbinds = varbinds;
	}

}
