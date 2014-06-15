package jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy;

import java.util.ArrayList;
import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;

/**
 * @author FUJIWARA
 * 
 */
public class KatsushikaExtractor extends PdfExtractor {

	/**
	 * 空き情報行を引っ掛ける正規表現
	 */
	protected static final String NURSERY_INFO_REGEX_PATTERN = "^.+?\\s[\\d-]+\\s[\\d-]+\\s[\\d-]+\\s[\\d-]+\\s[\\d-]+\\s[\\d-]+.*$";

	@Override
	public List<NurseryVacancyInfo> extract(String url) {

		List<NurseryVacancyInfo> nurseryList = new ArrayList<>();

		String result = getPdfContent(url);
		String[] lines = result.split("\n");
		for (String line : lines) {

			if (line.matches(NURSERY_INFO_REGEX_PATTERN)) {
				// 空き状況の行だけ相手にする
				String[] strs = line.split("\\s");

				NurseryVacancyInfo info = new NurseryVacancyInfo();
				info.name = strs[0];
				info.zeroCnt = strs[3];
				info.firstCnt = strs[4];
				info.secondCnt = strs[5];
				info.thirdCnt = strs[6];
				info.fourthCnt = strs[7];
				info.fifthCnt = strs[8];

				nurseryList.add(info);
			}
		}

		return nurseryList;
	}
}
