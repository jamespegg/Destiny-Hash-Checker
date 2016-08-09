import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Destiny Hash Checker
 * @author Family
 *
 */
public class Hasher implements Runnable {
	private byte[] input;
	private String hash = "1ceab1f5b327682c7835e21b96711429";
	private int hashLength = 24;
	private Random random = new Random();
	private MessageDigest md;
	private char[] chars = "abcdefghijklmnopqrstuvwxyz.".toCharArray();
	public static final AtomicInteger count = new AtomicInteger();
	
	public List<String> tlds = Arrays.asList("AAA","ABB","ABBOTT","ABOGADO","AC","ACADEMY","ACCENTURE","ACCOUNTANT","ACCOUNTANTS","ACO","ACTIVE","ACTOR","AD","ADS","ADULT","AE","AEG","AERO","AF","AFL","AG","AGENCY","AI","AIG","AIRFORCE","AIRTEL","AL","ALLFINANZ","ALSACE","AM","AMICA","AMSTERDAM","ANDROID","AO","APARTMENTS","APP","AQ","AQUARELLE","AR","ARCHI","ARMY","ARPA","AS","ASIA","ASSOCIATES","AT","ATTORNEY","AU","AUCTION","AUDIO","AUTO","AUTOS","AW","AX","AXA","AZ","AZURE","BA","BAND","BANK","BAR","BARCELONA","BARCLAYCARD","BARCLAYS","BARGAINS","BAUHAUS","BAYERN","BB","BBC","BBVA","BCN","BD","BE","BEER","BENTLEY","BERLIN","BEST","BET","BF","BG","BH","BHARTI","BI","BIBLE","BID","BIKE","BING","BINGO","BIO","BIZ","BJ","BLACK","BLACKFRIDAY","BLOOMBERG","BLUE","BM","BMW","BN","BNL","BNPPARIBAS","BO","BOATS","BOND","BOO","BOOTS","BOUTIQUE","BR","BRADESCO","BRIDGESTONE","BROKER","BROTHER","BRUSSELS","BS","BT","BUDAPEST","BUILD","BUILDERS","BUSINESS","BUZZ","BV","BW","BY","BZ","BZH","CA","CAB","CAFE","CAL","CAMERA","CAMP","CANCERRESEARCH","CANON","CAPETOWN","CAPITAL","CAR","CARAVAN","CARDS","CARE","CAREER","CAREERS","CARS","CARTIER","CASA","CASH","CASINO","CAT","CATERING","CBA","CBN","CC","CD","CEB","CENTER","CEO","CERN","CF","CFA","CFD","CG","CH","CHANEL","CHANNEL","CHAT","CHEAP","CHLOE","CHRISTMAS","CHROME","CHURCH","CI","CISCO","CITIC","CITY","CK","CL","CLAIMS","CLEANING","CLICK","CLINIC","CLOTHING","CLOUD","CLUB","CM","CN","CO","COACH","CODES","COFFEE","COLLEGE","COLOGNE","COM","COMMBANK","COMMUNITY","COMPANY","COMPUTER","CONDOS","CONSTRUCTION","CONSULTING","CONTRACTORS","COOKING","COOL","COOP","CORSICA","COUNTRY","COUPONS","COURSES","CR","CREDIT","CREDITCARD","CRICKET","CROWN","CRS","CRUISES","CSC","CU","CUISINELLA","CV","CW","CX","CY","CYMRU","CYOU","CZ","DABUR","DAD","DANCE","DATE","DATING","DATSUN","DAY","DCLK","DE","DEALS","DEGREE","DELIVERY","DELTA","DEMOCRAT","DENTAL","DENTIST","DESI","DESIGN","DEV","DIAMONDS","DIET","DIGITAL","DIRECT","DIRECTORY","DISCOUNT","DJ","DK","DM","DNP","DO","DOCS","DOG","DOHA","DOMAINS","DOOSAN","DOWNLOAD","DRIVE","DURBAN","DVAG","DZ","EARTH","EAT","EC","EDU","EDUCATION","EE","EG","EMAIL","EMERCK","ENERGY","ENGINEER","ENGINEERING","ENTERPRISES","EPSON","EQUIPMENT","ER","ERNI","ES","ESQ","ESTATE","ET","EU","EUROVISION","EUS","EVENTS","EVERBANK","EXCHANGE","EXPERT","EXPOSED","EXPRESS","FAGE","FAIL","FAITH","FAMILY","FAN","FANS","FARM","FASHION","FEEDBACK","FI","FILM","FINANCE","FINANCIAL","FIRMDALE","FISH","FISHING","FIT","FITNESS","FJ","FK","FLIGHTS","FLORIST","FLOWERS","FLSMIDTH","FLY","FM","FO","FOO","FOOTBALL","FOREX","FORSALE","FORUM","FOUNDATION","FR","FRL","FROGANS","FUND","FURNITURE","FUTBOL","FYI","GA","GAL","GALLERY","GAME","GARDEN","GB","GBIZ","GD","GDN","GE","GEA","GENT","GENTING","GF","GG","GGEE","GH","GI","GIFT","GIFTS","GIVES","GIVING","GL","GLASS","GLE","GLOBAL","GLOBO","GM","GMAIL","GMO","GMX","GN","GOLD","GOLDPOINT","GOLF","GOO","GOOG","GOOGLE","GOP","GOV","GP","GQ","GR","GRAPHICS","GRATIS","GREEN","GRIPE","GROUP","GS","GT","GU","GUGE","GUIDE","GUITARS","GURU","GW","GY","HAMBURG","HANGOUT","HAUS","HEALTHCARE","HELP","HERE","HERMES","HIPHOP","HITACHI","HIV","HK","HM","HN","HOCKEY","HOLDINGS","HOLIDAY","HOMEDEPOT","HOMES","HONDA","HORSE","HOST","HOSTING","HOTELES","HOTMAIL","HOUSE","HOW","HR","HSBC","HT","HU","IBM","ICBC","ICE","ICU","ID","IE","IFM","IINET","IL","IM","IMMO","IMMOBILIEN","IN","INDUSTRIES","INFINITI","INFO","ING","INK","INSTITUTE","INSURE","INT","INTERNATIONAL","INVESTMENTS","IO","IPIRANGA","IQ","IR","IRISH","IS","IST","ISTANBUL","IT","ITAU","IWC","JAVA","JCB","JE","JETZT","JEWELRY","JLC","JLL","JM","JO","JOBS","JOBURG","JP","JPRS","JUEGOS","KAUFEN","KDDI","KE","KG","KH","KI","KIM","KITCHEN","KIWI","KM","KN","KOELN","KOMATSU","KP","KR","KRD","KRED","KW","KY","KYOTO","KZ","LA","LACAIXA","LANCASTER","LAND","LASALLE","LAT","LATROBE","LAW","LAWYER","LB","LC","LDS","LEASE","LECLERC","LEGAL","LEXUS","LGBT","LI","LIAISON","LIDL","LIFE","LIGHTING","LIMITED","LIMO","LINK","LIVE","LIXIL","LK","LOAN","LOANS","LOL","LONDON","LOTTE","LOTTO","LOVE","LR","LS","LT","LTDA","LU","LUPIN","LUXE","LUXURY","LV","LY","MA","MADRID","MAIF","MAISON","MAN","MANAGEMENT","MANGO","MARKET","MARKETING","MARKETS","MARRIOTT","MBA","MC","MD","ME","MEDIA","MEET","MELBOURNE","MEME","MEMORIAL","MEN","MENU","MG","MH","MIAMI","MICROSOFT","MIL","MINI","MK","ML","MM","MMA","MN","MO","MOBI","MODA","MOE","MOM","MONASH","MONEY","MONTBLANC","MORMON","MORTGAGE","MOSCOW","MOTORCYCLES","MOV","MOVIE","MOVISTAR","MP","MQ","MR","MS","MT","MTN","MTPC","MU","MUSEUM","MV","MW","MX","MY","MZ","NA","NADEX","NAGOYA","NAME","NAVY","NC","NE","NEC","NET","NETBANK","NETWORK","NEUSTAR","NEW","NEWS","NEXUS","NF","NG","NGO","NHK","NI","NICO","NINJA","NISSAN","NL","NO","NOKIA","NP","NR","NRA","NRW","NTT","NU","NYC","NZ","OFFICE","OKINAWA","OM","OMEGA","ONE","ONG","ONL","ONLINE","OOO","ORACLE","ORANGE","ORG","ORGANIC","OSAKA","OTSUKA","OVH","PA","PAGE","PANERAI","PARIS","PARTNERS","PARTS","PARTY","PE","PET","PF","PG","PH","PHARMACY","PHILIPS","PHOTO","PHOTOGRAPHY","PHOTOS","PHYSIO","PIAGET","PICS","PICTET","PICTURES","PINK","PIZZA","PK","PL","PLACE","PLAY","PLUMBING","PLUS","PM","PN","POHL","POKER","PORN","POST","PR","PRAXI","PRESS","PRO","PROD","PRODUCTIONS","PROF","PROPERTIES","PROPERTY","PS","PT","PUB","PW","PY","QA","QPON","QUEBEC","RACING","RE","REALTOR","REALTY","RECIPES","RED","REDSTONE","REHAB","REISE","REISEN","REIT","REN","RENT","RENTALS","REPAIR","REPORT","REPUBLICAN","REST","RESTAURANT","REVIEW","REVIEWS","RICH","RICOH","RIO","RIP","RO","ROCKS","RODEO","RS","RSVP","RU","RUHR","RUN","RW","RYUKYU","SA","SAARLAND","SAKURA","SALE","SAMSUNG","SANDVIK","SANDVIKCOROMANT","SANOFI","SAP","SARL","SAXO","SB","SC","SCA","SCB","SCHMIDT","SCHOLARSHIPS","SCHOOL","SCHULE","SCHWARZ","SCIENCE","SCOR","SCOT","SD","SE","SEAT","SEEK","SENER","SERVICES","SEW","SEX","SEXY","SG","SH","SHIKSHA","SHOES","SHOW","SHRIRAM","SI","SINGLES","SITE","SJ","SK","SKI","SKY","SKYPE","SL","SM","SN","SNCF","SO","SOCCER","SOCIAL","SOFTWARE","SOHU","SOLAR","SOLUTIONS","SONY","SOY","SPACE","SPIEGEL","SPREADBETTING","SR","SRL","ST","STARHUB","STATOIL","STC","STCGROUP","STUDIO","STUDY","STYLE","SU","SUCKS","SUPPLIES","SUPPLY","SUPPORT","SURF","SURGERY","SUZUKI","SV","SWATCH","SWISS","SX","SY","SYDNEY","SYSTEMS","SZ","TAIPEI","TATAMOTORS","TATAR","TATTOO","TAX","TAXI","TC","TD","TEAM","TECH","TECHNOLOGY","TEL","TELEFONICA","TEMASEK","TENNIS","TF","TG","TH","THD","THEATER","TICKETS","TIENDA","TIPS","TIRES","TIROL","TJ","TK","TL","TM","TN","TO","TODAY","TOKYO","TOOLS","TOP","TORAY","TOSHIBA","TOURS","TOWN","TOYOTA","TOYS","TR","TRADE","TRADING","TRAINING","TRAVEL","TRUST","TT","TUI","TV","TW","TZ","UA","UBS","UG","UK","UNIVERSITY","UNO","UOL","US","UY","UZ","VA","VACATIONS","VC","VE","VEGAS","VENTURES","VERSICHERUNG","VET","VG","VI","VIAJES","VIDEO","VILLAS","VIN","VISION","VISTA","VISTAPRINT","VIVA","VLAANDEREN","VN","VODKA","VOTE","VOTING","VOTO","VOYAGE","VU","WALES","WALTER","WANG","WATCH","WEBCAM","WEBSITE","WED","WEDDING","WEIR","WF","WHOSWHO","WIEN","WIKI","WILLIAMHILL","WIN","WINDOWS","WINE","WME","WORK","WORKS","WORLD","WS","WTC","WTF","XBOX","XEROX","XIN","XPERIA","XXX","XYZ","YACHTS","YANDEX","YE","YODOBASHI","YOGA","YOKOHAMA","YOUTUBE","YT","ZA","ZIP","ZM","ZONE","ZUERICH","ZW");
	
	/**
	 * Sets up the MessageDigest
	 */
	public Hasher() throws NoSuchAlgorithmException{
		this.md = MessageDigest.getInstance("md5");
	}
	
	public void run() {
		while (!check()) {
			// Don't do anything because it's checking
		}
		
		System.out.println("Thread done, answer found");
		
		// Stop all threads
		System.exit(0);
	}	
	
	/**
	 * Keeps looping to generate a new input until a match is found
	 * @return
	 */
	public boolean check() {

		boolean found = false;
		
		while (!found) {
			try {
				input = generateInput(1);
			} catch (HasherException e) {
				continue;
			}
			
			// Only increment if the hash was eligible
			count.getAndIncrement();
			
			found = isHash(input);
		}
		
		
		// Obviously print out the match!
		System.out.println();
		System.out.println("We found a match! " + new String(input));
		return true;
	}
	
	/**
	 * Checks if the input matches our Destiny hash
	 * @param input
	 * @return
	 */
	public boolean isHash(byte[] input) {
		md.update(input);
		byte[] output = md.digest(input);
		
		if (Arrays.equals(output, hexStringToByteArray(hash))) {
			return true;
		} else {
			return false;
		}	
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}	
	
	/**
	 * Generates a new byte array hash
	 * @param counter
	 * @return
	 */
	public byte[] generateInput(int counter) throws HasherException {
		byte[] tld = tlds.get(random.nextInt(tlds.size())).toLowerCase().getBytes();
		
		// 4 because we need at least two dots and a letter
		if (tld.length >= (hashLength - 4)) {
			throw new HasherException("TLD too long");
		}
		
		input = new byte[hashLength];

		for (int i = 0; i < hashLength - tld.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			
			if (i == 0 && c == '.') {
				throw new HasherException("Dot in first space");
			} else if (i == (hashLength - tld.length - 1) && c != '.') {
				throw new HasherException("Dot in first space");
			} else {
				input[i] = (byte) c;
			}

		}

		int j = 0;
		for (int i = hashLength - tld.length; i < input.length; i++) {
			input[i] = tld[j];
			++j;
		}
		
		
		
		// We have three words, so we need two spaces
		// Also, an input can't start or end with a space
		if (countByte(input, (byte) '.') == 2) {
			return input;
		} else {
			throw new HasherException("Spaces in the wrong place");
		}
	}
	
	public int countByte(byte[] input, byte search) {
		int count = 0;
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == search) {
				++count;
			}
		}
		
		return count;
	}
	
	/**
	 * Converts a byte array into a hex string
	 * @param input
	 * @return
	 */
	public String toHex(byte[] input) {
        StringBuffer hexString = new StringBuffer();
        
    	for (int i=0;i<input.length;i++) {
    		String hex=Integer.toHexString(0xff & input[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	
    	return hexString.toString();
	}	
}
