package jp.co.casleyconsulting.www.nurseryVacancy.extactor;

import java.util.ArrayList;
import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;

/**
 * 新宿用
 * 
 * @author FUJIWARA
 * 
 */
public class ShinjukuExtractor extends PdfExtractor {

	/**
     *
     */
	protected static final String NURSERY_INFO_REGEX_PATTERN = "^(.+?)\\s([\\d]+)\\s(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\d+).*$";

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * jp.co.casleyconsulting.www.nurseryVacancy.extactor.Extractor#extract(
	 * java.lang.String)
	 */
	@Override
	public List<NurseryVacancyInfo> extract(String url) {

		List<NurseryVacancyInfo> nurseryList = new ArrayList<>();

		String test = getPdfContent(url);

		String[] lines = test.split("\n");
		for (String line : lines) {

			if (line.matches(NURSERY_INFO_REGEX_PATTERN)) {
				// 空き状況の行だけ相手にする
				String[] strs = line.split("\\s");

				NurseryVacancyInfo info = new NurseryVacancyInfo();
				info.name = strs[0];
				info.zeroCnt = strs[1];
				info.firstCnt = strs[2];
				info.secondCnt = strs[3];
				info.thirdCnt = strs[4];
				info.fourthCnt = strs[5];
				info.fifthCnt = strs[6];

				nurseryList.add(info);
			}
		}

		return nurseryList;
	}
}
