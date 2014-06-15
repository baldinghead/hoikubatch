package jp.co.casleyconsulting.www.nurseryVacancy.factory;

import jp.co.casleyconsulting.www.nurseryVacancy.constants.ExtractType;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.Extractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.KatsushikaExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.MeguroExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.MinatoExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.NakanoExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.NerimaExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.SetagayaExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.ShinjukuExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.TaitoExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy.ToshimaExtractor;

/**
 * Extractorを返します
 *
 * @author FUJIWARA
 *
 */
public class VacancyExtractorFactory {

	/**
	 * @param type
	 * @return
	 */
	public static Extractor create(ExtractType type) {

		switch (type) {
		case NAKANO:

			return new NakanoExtractor();

		case SHINJUKU:

			return new ShinjukuExtractor();

		case KATSUSHIKA:

			return new KatsushikaExtractor();

		case TAITO:

			return new TaitoExtractor();

		case SETAGAYA:

			return new SetagayaExtractor();

		case TOSHIMA:

			return new ToshimaExtractor();

		case NERIMA:

			return new NerimaExtractor();

		case MINATO:

			return new MinatoExtractor();

		case MEGURO:

			return new MeguroExtractor();

		default:
			break;
		}

		return null;
	}
}
