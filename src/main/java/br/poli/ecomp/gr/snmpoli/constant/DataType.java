package br.poli.ecomp.gr.snmpoli.constant;

public interface DataType {
	public static final int INTEGER = 0x02;
	public static final int OCTET_STRING = 0x04;
	public static final int NULL = 0x05;
	public static final int OID = 0x06;
	public static final int SEQUENCE = 0x30;
	public static final int GET_REQUEST_PDU = 0xA0;
	public static final int GET_RESPONSE_PDU = 0xA2;
	public static final int SET_REQUEST_PDU = 0xA3;
}
