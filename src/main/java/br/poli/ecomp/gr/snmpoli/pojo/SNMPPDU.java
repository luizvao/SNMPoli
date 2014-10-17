package br.poli.ecomp.gr.snmpoli.pojo;

import java.util.List;

import br.poli.ecomp.gr.snmpoli.interfaces.Encodable;

public class SNMPPDU implements Encodable {

	private int requestId;
	private int errorStatus;
	private int errorIndex;
	private List<VarBind> varbinds;

	public byte[] encode() {
		// TODO Auto-generated method stub
		return null;
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
