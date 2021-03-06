package com.example.textquest;

import java.util.ArrayList;

public class VVRepo implements IRepository {
	String[] locTexts;

	@Override
	public Location getLocation(int id) {
		String[] desc = c(locTexts[id]).split("\\|");
		Action[] actions = new Action[(desc.length - 2) / 2];
		for (int i = 0; i < actions.length; i++) {
			actions[i] = new Action(desc[i + 2], Integer.parseInt(desc[i + 2 + actions.length]));
		}
		return new Location(desc[1], actions);
	}

	public VVRepo() {
		locTexts = makeTexts();
	}

	private String[] makeTexts() {
		ArrayList<String> texts = new ArrayList<>();
		texts.add(" 0|Фэ дэчржкъю д щкуфрз срнз. Пв йвсвжз дкжпззфуб щётпвб фхщв. Мхжв фэ срлжёъю|пв йвсвж|д узнр|1|5");
		texts.add(" 1|Фэ сръён пв йвсвж. Срсвн срж жрижю.|Твумтрзъю йрпф|сргзикъю д узнр|2|5");
		texts.add(" 2|Х фзгб пзф йрпфв. Пр орипр сргзевфю срж жрижёо, яфр рщзпю дзузнр. Чрщзъю?|жв|пзф|3|5");
		texts.add(
				" 3|Жрижю рмвйэдвзфуб пзопрер мкунрфпэо. Фэ гзйхусзъпр сэфвзъюуб устбфвфюуб рф иехщкч мвсзню утзжк пздэурмкч мрнрумрд к фтвдкпрм.\nЙвфзо стксрнйвзф щзтзсвчв к схумвзф фзгб срж удрл свпшктю.|Щфр из жвнюъз?|4");
		texts.add(" 4|Фзсзтю фэ икдёъю у щзтзсвчвок! :) Срйжтвднба.|Мрпзш|20");
		texts.add(
				" 5|Фэ сткчржкъю д узнр. Йжзую мтвукдр к фкчр. Удзтмвзф урнпэъмр. Мрувтю кжёф у мрурл. Мхжв срлжзъю?|жрорл|пв тэпрм|6|14");
		texts.add(
				" 6|Сткжб жрорл, фэ пвчржкъю удрл йрпф. Рп рщзпю муфвфк - дсрнпз дзтрбфпр, щфр узержпб срлжёф жрижю.|Дрйюоёъю зер|срлжёъю пв хнкшх|13|7");
		texts.add(
				" 7|Фэ дэчржкъю пв хнкшх к дкжкъю, щфр жрижю ъсвткф дрдуа. Нажк стбщхфуб д хмтэфкб, пр кч сзущвпэз жров оепрдзппр твйоэдвзф.\nФэ дкжкъю, щфр пв йзонз нзивф пзумрнюмр грнюъкч твмрдкп, д мрфртэч хиз твйозуфкнкую мвмкз-фр хопкмк.|Йвлоёъю ржпх кй пкч|устбщзъюуб|10|8");
		texts.add(
				" 8|Фэ упрдв дгзевзъю д жро, пр рп фриз кй сзумв. Мтэъв ргкнюпр руэсвзфуб. Дчрж хиз йвдвнзп. Фзгб сретзгвзф срж сзумро...|Жвнюъз|9");
		texts.add(
				" 9|Ржпвмр фэ пз срекг жвтро. Усхуфб фэубщк нзф фзгб пвънк втчзрнрек. Рпк сткпбнк фзгб йв жтздпзер швтб вфнвпфрд, у щзуфюа срчртрпзппрер срж унрзо сзумв, к кч пвчржмв сткргтзнв октрдха кйдзуфпруфю.\nФзгб стрдрйенвукнк швтёо! :)|Мрпзш|20");
		texts.add(
				"10|Фэ йвнзйвзъю д твмрдкпх к вммхтвфпр йвмтэдвзъю уфдртмх. Мрежв држв пвщкпвзф йвчнёуфэдвфю дпхфтю, фэ ср пзруфртрипруфк йвызонбзъю узгз свнзш. Фэ мткщкъю, пр рф пзчдвфмк дрйжхчв фзтбзъю урйпвпкз...|Жвнюъз|11");
		texts.add(
				"11|Пзмрфртрз дтзоб усхуфб дзую окт ргнзфвзф кйдзуфкз р пвчржмз уворл грнюърл изощхикпэ д куфрткк щзнрдзщзуфдв. Внух хсрокпвзф зё д сзупз \"Дозуфз к пвдузежв\":\n К д рикжвпкк удрзо \n Нзикъю изощхикпрл пв жпз\n Пр зуфю дрнъзгпэз унрдв\n Срдзтю опз, срдзтю опз...|Жвнюъз|12");
		texts.add("12|Срйжтвднба, фэ - изощхикпв!|Мрпзш|20");
		texts.add(
				"13|Фэ гзтёъю яфр щхжпрз кйргтзфзпкз щзнрдзщзуфдв к дэчржкъю пв хнкшх. Хдкжзд, щфр х фзгб зуфю йрпфкм, узнющвпз угзевафуб м фзгз - жрижю хиз чнзызф дрдуа, твйоэдвб кч сзурщпэз чвнхсэ. Рпк сржуфхсвафуб м фзгз, ргтвйхб снрфпэл мро щзнрдзщзумрл снрфк...\nЩфр-фр жвёф фзгз српбфю, щфр држв сржпбнв дву к српзунв мхжв-фр...\nФвм србдкнуб сзтдэл д октз дрнюдрму кй нажзл :) Срйжтвднба!|Мрпзш|20");
		texts.add(
				"14|Фэ сткчржкъю пв тэпрм. Срчриз, озуфпэз к пз ургктвафуб удртвщкдвфюуб. Фртехаф узгз, евнжбф.\nФдрё дпковпкз сткднзмвзф уфтвппрз фрызз ухызуфдр ернхгрер шдзфв. Сржрлжб сргнкиз, фэ дэбупбзъю, щфр яфр ржкп кй фзч увоэч мхсшрд-стрфруурд, щфр сткнзфваф уажв у снвпзфэ Влхт.|Сржрлжёъю м пзох|срехнбзъю ср тэпмх|15|20");
		texts.add(
				"15|Стрфруу стзжнвевзф фзгз езпзтвфрт снвйозппрер ыкфв. \nЙзопэч жзпзе зох пз пхипр, пр зер йвкпфзтзурдвнв фдрб мрйэтпвб тхгвъмв! :) \nОзпбзъюуб|жв|пзф|16|20");
		texts.add(
				"16|Стрфруу срмвйэдвзф фзгз, мвм пвствднбфю хуфтрлуфдр к щфр пвиковфю. Фэ упковзъю тхгвчх к руфвёъюуб д овлмз к свпвоз, жрдрнюпэл ужзнмрл.|Жвнюъз|17");
		texts.add(
				"17|Джтхе фэ ргпвтхикдвзъю, щфр фхщв хиз пвж ертржро. Зер сртвиваф сзтдэз мвснк. Нажк свпкмхаф к учржбф у хов. \nСтртрм мткщкф:\n- Пз грлфзую! Кгр сткжёф Кйгвдкфзню к хмтрзф дву рф пзокпхзорл екгзнк.\nФэ дмнащвзъю ыкф к срмтэдвзъю ко дуё узнр.|Жвнюъз|18");
		texts.add("18|Дуз усвузпэ. Фэ руфвнуб щзнрдзмро); фзо пз озпзз, ФЭ ЕЗТРЛ! Срйжтвднба!|Жвнюъз|19");
		texts.add(
				"19|Дпзйвспр пвщкпвзфуб жрижю. Стрфруу дмнащвзф ыкф к срмтэдвзф ко узгб ржпрер. Дзую пвтрж гзикф м пзох д хмтэфкз.\nСтрфруу жруфвёф сзтзжвфщкм, щфр-фр дртщкф д пзер...\nДузч хпрукф у Йзонк...\nСржйтвднба! Фзсзтю дэ - дркпэ Влхтв!|Мрпзш|20");
		texts.add(
				"20|--- STAFF ---\n\nHaruki Murakami\nJackie Chan\nSong by Yiruma\n\n(c) Konami, 1985|Срстргрдвфю зыз твй|0");
		
String[] arr = {};
		return texts.toArray(arr);
	}

	private String c(String message) {
		StringBuilder result = new StringBuilder();
		for (char character : message.toCharArray()) {
			if (character >= 'а' && character <= 'я') {
				int newChar = ((int) character - 'а' - 2 + 32) % 32 + 'а';
				result.append((char) (newChar));
			} else if (character >= 'А' && character <= 'Я') {
				int newChar = ((int) character - 'А' - 2 + 32) % 32 + 'А';
				result.append((char) (newChar));
			} else {
				result.append(character);
			}
		}
		return result.toString();
	}
}
