package Main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Utils.XmlReader;

public class Main {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		XmlReader retornoFuncao = new XmlReader("F:\\Faculdade\\PM\\Trabalho\\Estados\\RJ\\33MUE250GC_SIR.kml");
		retornoFuncao.populandoHashMap();
	}
}