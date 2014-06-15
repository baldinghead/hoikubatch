package jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * @author FUJIWARA
 * 
 */
public abstract class PdfExtractor implements Extractor {

	/**
	 * @param url
	 * @return
	 */
	public String getPdfContent(String url) {

		String result = null;
		try {
			InputStream is = new URL(url).openStream();

			Parser parser = new AutoDetectParser();
			ContentHandler handler = new BodyContentHandler();

			Metadata metadata = new Metadata();

			parser.parse(is, handler, metadata, new ParseContext());

			result = handler.toString();

			is.close();

		} catch (IOException | SAXException | TikaException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return result;
	}

}
