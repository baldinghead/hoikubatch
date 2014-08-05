package jp.co.casleyconsulting.www.nurseryVacancy.constants;

/**
 * 抽出対象ページのタイプ
 * 
 * @author FUJIWARA,mmike<takumi.tanaka246@gmail.com>
 * 
 */
public enum ExtractType {

	NAKANO("東京都中野区"),
	SHINJUKU("東京都新宿区"),
	KATSUSHIKA("東京都葛飾区"),
	TAITO("東京都台東区"),
	SETAGAYA("東京都世田谷区"),
	TOSHIMA("東京都豊島区"),
	NERIMA("東京都練馬区"),
	MINATO("東京都港区"),
	MEGURO("東京都目黒区");

	private String addressPrx;

	private ExtractType(String addressPrx) {
		this.addressPrx = addressPrx;
	}

	public String getAddressPrx() {
		return this.addressPrx;
	}
}
