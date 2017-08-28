package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordTwo extends Activity implements OnClickListener {

	String tag,pass;
	int tagvalue;
	Button b1;
	public static String filename = "Progress";
	EditText et1;
	static String st[]={
			"7ncYWf5PQdqgExv","wLhidsZkT8dr7bj","m9lenZD7rI46lE5","Y73MhQIqVhn0xYf","e8nckjLyIHb8I5U",
			"ny67IJJu2s9co1i","CUnEphs0eabJTAn","if7h6H2Zxma6mk1","h0vC0fax0jae5g6","e8nckjLyIHb8I5U",
			"hUKLDp0yb2GYE5o","GSIwxqV1Ct3V7PD","Ljmixzz1Kfn8EDH","7ncYWf5PQdqgExv","if7h6H2Zxma6mk1",
			"vs9neljpxiq7Zk3","hYtcaZIKI3LRUcd","C3C3WHHIS38oKhM","hUKLDp0yb2GYE5o","if7h6H2Zxma6mk1",
			"qLSw58gyLQbMiQQ","e8nckjLyIHb8I5U","ny67IJJu2s9co1i","UKIvgmR9SOGIUJ0","CUnEphs0eabJTAn",
			"C3C3WHHIS38oKhM","vs9neljpxiq7Zk3","h0vC0fax0jae5g6","wLhidsZkT8dr7bj","hYtcaZIKI3LRUcd",
			"Y73MhQIqVhn0xYf","ny67IJJu2s9co1i","wLhidsZkT8dr7bj","hUKLDp0yb2GYE5o","GSIwxqV1Ct3V7PD",
			"UKIvgmR9SOGIUJ0","7ncYWf5PQdqgExv","GSIwxqV1Ct3V7PD","h0vC0fax0jae5g6","e8nckjLyIHb8I5U",
			"vs9neljpxiq7Zk3","Y73MhQIqVhn0xYf","qLSw58gyLQbMiQQ","hUKLDp0yb2GYE5o","Ljmixzz1Kfn8EDH",
			"UKIvgmR9SOGIUJ0","C3C3WHHIS38oKhM","m9lenZD7rI46lE5","if7h6H2Zxma6mk1","ny67IJJu2s9co1i",
			"Ljmixzz1Kfn8EDH","CUnEphs0eabJTAn","qLSw58gyLQbMiQQ","wLhidsZkT8dr7bj","vs9neljpxiq7Zk3"
	};
	static String clues[]={

			//STORY A CLUES
			"As he walked down the stairs, his surprise and happiness knew no bounds, as an unexpected gathering\n" +
					"greeted him happy birthday! Among the gathering were familiar faces; Jessica - his girlfriend, Clement\n" +
					"- his most trusted and best friend, Walter - his step-brother, whom he was seeing after a long time and\n" +
					"his friends Robert and Saul.\n" +
					"Saul Brown was from Green’s rival family. The two were often compared. But lately, Alex was\n" +
					"outshining Saul in every sphere of competition. Alex’s smile faded away as his eyes fall on Jesse,\n" +
					"Jessica's ex, “damn that guy!”, muttered Alex under his breath. The whole surprise was planned by\n" +
					"Jessica and Clement for Alex’s 19th and had specially requested for Walter to turn up. But Walter wasn’t\n" +
					"too happy. He always considered himself unlucky for not inheriting their father’s property and\n" +
					"constantly envied Alex. ",
			"Later that evening, the mansion was lit in bright fashion and the attendees were all suited up, for the\n" +
					"birthday dinner, awaiting Alex’s arrival. The gathering started getting restless; it was already an hour\n" +
					"past the decided time, and Alex was still nowhere in sight. After a frantic search of the house and\n" +
					"hundreds of phone calls, Clement called the police. The police arrived and after investigating for a\n" +
					"couple of hours, declared that Alex had been kidnapped. On hearing this, Jessica was broke down and\n" +
					"had to be consoled by Jesse. The police ordered that all the guests to stay put, till end of interrogation. ",
			"The first one was Clement, who informed the police that he was occupied with planning of the party at\n" +
					"Alex’s hotel. He secretly informed the police that he suspected Jessica and Jesse for committing this\n" +
					"hideous crime, as he’d overheard Alex’s heated arguments with Jessica over her being close with Jesse,\n" +
					"in spite of him having expressed his dislike. Saul then told the police that he’d gone to the bank to\n" +
					"withdraw money to handle the payments for the “after party”, and ended up having an argument with\n" +
					"the manager. He also expressed his doubts over Robert and Rowney for conspiring Alex’s kidnap as\n" +
					"both were in dire need of money.",
			"Upon interrogation, Robert claimed that he’d been asleep through most part of the day and had asked\n" +
					"Rowney for medication. Rowney, who looked emotionally shattered, supported Robert’s testimony and\n" +
					"said that he’d been busy with household chores. His prime suspect was Saul, whom he’d asked Alex to\n" +
					"stay away from as he was from Green’s rival family and thus was up to no good! Moreover, on that\n" +
					"particular day had seen him slip out of the house in a hurried, rather suspicious manner. ",
			"Next up, Jessica, agitated, gave out that she’d gone shopping for Alex’s birthday gift, and that Jesse had\n" +
					"driven her to the mall. Jessica strongly expressed her suspicion towards Walter, as he’d always been\n" +
					"spiteful about Alex’s wealth. Jesse confirmed her statement. Walter stated that he’d been overburdened\n" +
					"with office work that his step-father had assigned for him but he did not have any suspects as he barely\n" +
					"socialized. The police later discovered Alex’s personal diary that contained Alex’s disappointment\n" +
					"about Jesse’s involvement in his life and how his relationship was under ruins.\n" +
					"A greed for ransom or the lust of two. Did half-blood and loyalty fail, pride or friendship outdo? Find\n" +
					"the culprit and the sin responsible for the crime.",


			//STORY B CLUES
			"Mr. White, once the top dog in shipping business, was now going through a period of crisis. His\n" +
					"company’s stock had plummeted ever since he refused to quickly adapt to the inevitable changes in the\n" +
					"industry. Just last month, the company was in the news for having failed to pay off overdue debts of\n" +
					"around 5 million dollars to the Federal Bank of Alderaan. “Listen up young lady! Achhoooo! I know\n" +
					"what you are thinking! But let me tell you this ain’t the way I do things. A man must have certain\n" +
					"principles! This is a job of a scumbag like that Brown fella waiting outside!” Saying so, he stormed off.\n",
			"Once an ex-business partner of Mr. Black, Mr. Brown was the person in charge of the Alderaan Harbor\n" +
					"Project. The project had run into various legal hassles for gross misappropriation of state funds. The\n" +
					"court had recently passed a verdict ordering the company involved (i.e. Mr. Brown’s) to cough up a\n" +
					"fine of 4.25 million dollars. “Granted my past record reflects poorly on me. But there is no way I would\n" +
					"do something like that to Mr. Black, or anybody for that matter! I am a father too and my heart goes out\n" +
					"to the Black Family! Trust me please! Achhoooo!” “One sympathetic scumbag! or a vengeance seeking\n" +
					"ex?” thought Marge as Mr. Brown left the room.\n",
			"“Achhoooo! Sorry detective! Caught a horrible cold from my trip to Luverne last week.” Saying so,\n" +
					"Mr. Grey put up a weak smile. A fine young man albeit with a catch; he suffered from a gambling\n" +
					"addiction. Two and a half years ago he had been fired from Mr. Black’s company for embezzling\n" +
					"company funds to support his addiction. 9 months in the Alderaan Rehab Centre had worked well for\n" +
					"him. Now the founder of an industrial equipment firm, he was slowly pulling his life together. Except,\n" +
					"Marge’s sources told her that the firm was soon headed for closure with outstanding debts of 4 million\n" +
					"dollars. When confronted, he grudgingly replied, “I could use the money, yes! But even I wouldn’t\n" +
					"stoop so low as to kidnap an innocent kid!” “In the end it always boils down to money, doesn’t it?”\n" +
					"wondered Marge.\n",
			"“5 million dollars, that’s sweet money, but let’s be practical. Aldicorp’s stocks are better than ever and\n" +
					"we might even surpass Mr. Black’s company at this rate! I am the last person that needs the money!\n" +
					"Whoever is collecting the ransom tonight, it ain’t me! You are wasting your time, detective! Now if\n" +
					"you would excuse me, I have more important things to address! Achhoooo! God! the cold!” moaned\n" +
					"Mr. Green as he left.",
			"“Hello sweetie! New to the force, aye?” greeted the flamboyant Mr. Pink; an ex-convict who had served\n" +
					"3 years in the Alderaan State Prison for robbery. “Kidnapping ain’t exactly my style sweetie, my records\n" +
					"would tell ya that much! If you have dreams of pinning this mess on me, forget it! Mr. Pink might be\n" +
					"the big fish! But he ain’t your man this time! Now if you would excuse me sweetie. Me and my babe\n" +
					"have a date tonight. Good luck with the case!”\n" +
					"“…to be dropped below Sailor’s bridge at 10:30pm the next day”, before the call was cut.\n" +
					"Marge leaned back in her chair and smiled. In her head the case had been solved! The guilty was one\n" +
					"among the five suspects. “And here’s to you Mrs. Robinson….” hummed Marge.\n" +
					"Who was the kidnapper and why? Also identify which of the seven sins, was the driving force behind\n" +
					"the crime.",


			//STORY C CLUES
			"Within an hour of the incident the forensic lead comes to you with an oral report. She explains that this\n" +
					"was definitely a case of arson. There was an obvious accelerant trail but no clean fingerprints on the\n" +
					"scene. She also shows you half a burnt cigarette, a playing card and a pink sea shell that was bagged as\n" +
					"potential evidence near the crime scene. ",
			"You interview George Bluth, successful entrepreneur and proprietor of the stand. The grey-haired, potbellied\n" +
					"man is visibly distraught and tells you that this has been a major loss to his business. When you\n" +
					"ask him who could have had a motive to target him, he immediately mentions his competitors; the\n" +
					"Sitwell brothers. They had apparently started their own Frozen Banana franchise recently and Mr. Bluth\n" +
					"tells you that that they must have resorted to dirty tricks to get an edge. Upon asking him for an alibi,\n" +
					"you find out that he was sound asleep at home.",
			"George’s wife Lucille was called to the scene of the crime as well. The tall statuesque woman, in her\n" +
					"fur coat and designer heels looks very out of place at the crime scene. She curtly informs you that she\n" +
					"doesn’t know anything about this arson nonsense and that the police better solve the case quickly\n" +
					"because the insurance claim won’t go through until then. When you ask her to account for her\n" +
					"whereabouts she dances around the question. After some more prodding she eventually caves, “I was\n" +
					"at the diner with my Nicotine Anonymous sponsor - not that it’s any of your business!”. “If you want a\n" +
					"suspect, take a look at those Sitwells,” she throws behind her, storming off. ",
			"You next question Michael Bluth, only child and heir to the Bluth business. As he walks towards you,\n" +
					"you see him throwing dark looks at the Sitwells. You converse with him politely and learn that he’s an\n" +
					"MBA graduate and that he’s been helping his father with the business. “I’m not too happy with the way\n" +
					"my father is running things but he’s gotten us this far”. You also learn that he was out drinking at the\n" +
					"pub last night. When you ask him who he thinks could have committed the arson he thinks for a moment \n" +
					"before regretfully answering, “I don’t think anyone would have actually set fire to this place”. ",
			"Later that day the Sitwell brothers, competitors with their own Frozen Banana franchise, arrive at the\n" +
					"scene. They offer their condolences to an unhappy Mr. Bluth before approaching you. They admit that\n" +
					"they haven’t been doing as well as they’d hoped but that there’s nothing wrong with some healthy\n" +
					"competition. You ask them to account for their whereabouts before and after midnight. The older\n" +
					"brother, Stan, tells you that he was out of town on a business trip and only just arrived two hours ago.\n" +
					"The younger brother, Sam tells you that he was in his office Skyping with a partner in Beijing.\n" +
					"Who was the culprit and why? Also identify which one of the seven sins, was the driving force behind\n" +
					"the crime.",


			//STORY D CLUES
			"On the 23rd of September, the calm of Ichiriki Ochaya was disrupted by a raging fire. The flames almost\n" +
					"completely consumed the teahouse, and the geisha presenting at the time was afflicted with third degree\n" +
					"burns. Chief Soichiro Yagami was assigned the task of investigating the case. A lighter with the initials\n" +
					"H.M was found near what was the dressing room before the fire destroyed it. Yagami immediately\n" +
					"recognized it as a case of arson and went on to question the guests who were present that evening.\n" +
					"Identify the culprit and which of the seven sins was the driving force.\n",
			"Mother\n" +
					"Mother peered at the audience nervously and was dismayed to find that pig Tatsuya ogling Mameha.\n" +
					"Half an hour later, after the dance, she saw Tatsuya making his way to the dressing room. She wasn’t\n" +
					"going to let him sway that naïve geisha again, so she followed him but was startled to find Yuki lurking\n" +
					"near the door.\n" +
					"Flames danced before Mother's eyes and she rushed out of the ochaya.\n" +
					"\"Where were you before the fire started?\" The chief made her nervous, this whole affair could\n" +
					"permanently damage the reputation of her okiya.\n" +
					"\"I was going to the dressing room to ensure Tatsuya didn’t go and sway that fool Mameha into falling\n" +
					"for him again but I was surprised to see his wife waiting in the shadows, considering women don’t\n" +
					"usually visit the ochaya\" she replied. I hope the fire has taught Mameha a lesson, it served her right for\n" +
					"being this irresponsible, Mother pondered.",
			"Tatsuya\n" +
					"I will see her today for the last time, thought Tatsuya. He entered the familiar setting of the ochaya and\n" +
					"went straight to the dressing room. When Mameha saw him, the man who deceived her, she lashed out.\n" +
					"\"I know what you've done Tatsuya, first me and now Hatsumomo? Do you have no shame? You will\n" +
					"confess to your wife tonight, or I will\". This upset Tatsuya and he stormed out.\n" +
					"After the geisha's dance he got up and walked away from his table. When he turned around he was\n" +
					"horrified to spot Yuki and Hatsumomo approaching him from different directions.\n" +
					"Flames danced before his eyes and he rushed out of the ochaya.\n" +
					"\"I’m aware that you got up to leave during the interval of the show, where did you go during this time?\"\n" +
					"interrogated Mr. Yagami the day after the fire burnt Ichiriki down.\n" +
					"\"I just got up to get some fresh air and I couldn’t have done anything during that time, I didn't even\n" +
					"have a lighter with me. Why would anyone try to hurt Mameha, it makes no sense.\" replied Tatsuya",
			"Yuki\n" +
					"Today I'll confront him and I'll show that shameless Geisha that I'm no fool, mused Yuki. On reaching\n" +
					"the ochaya she spotted Tatsuya and seated herself in a corner away from him. It broke her heart to watch\n" +
					"him look at the geisha with raw lust. When he got up to leave, she knew this was her chance to end\n" +
					"things once and for all. When she got to the dressing room she was shocked to find Hatsumomo\n" +
					"snooping around, hidden from sight. What was her sister doing here, thought Yuki as she waited in the\n" +
					"shadows.\n" +
					"Flames danced before her eyes and she rushed out of the ochaya.\n" +
					"\"What inspired you, a woman who has never visited an ochaya, to suddenly go to Ichiriki yesterday?\"\n" +
					"asked chief Yagami the next day.\n" +
					"\"It isn't a sin for a woman to visit an ochaya in the twenty first century, Mr. Yagami. I was there to see\n" +
					"the show like everyone else. I wasn't aware my sister and husband were there on the same day.\" she\n" +
					"replied. No one needed to know my husband was a cheating scoundrel, she thought cynically.\n",
			"Hatsumomo\n" +
					"She didn’t like sneaking behind her sister's back to be with Tatsuya but what enraged her was\n" +
					"the possibility that he was still seeing that Geisha Mameha. Tonight she would go to the ochaya and\n" +
					"bring an end to her doubts. This was going to be a long exhausting evening, she thought as she lit her\n" +
					"cigarette with a match and prepared herself for her day out. A while after the show had started she saw\n" +
					"Tatsuya leave and decided to follow him. Was he reverting to his old ways, she wondered.\n" +
					"Flames danced before her eyes and she rushed out of the ochaya.\n" +
					"\"What were you doing during the interval of the show at the ochaya yesterday?\" asked Chief Yagami.\n" +
					"\"I went to congratulate the geisha on her stellar performance\" Hatsumomo replied. She knew her sister\n" +
					"had seen her there but she was certain that making an open display of her jealousy to the detective\n" +
					"would mean trouble.",


			//STORY E CLUES
			"Abhiram said that he was the one closest to the aisle of the row and had gone to buy food for the gang.\n" +
					"The order consisted of soft drink for Abhiram, popcorn for Bhabesh, peanut butter sandwich for Chelsee\n" +
					"and a samosa for Dhruv. Abhiram was sitting next to Chelsee throughout the movie, when asked about\n" +
					"his relationship with Dhruv he said that they were business partners in a joint venture, however the\n" +
					"same could not be said about Chelsee and Dhruv. When asked if Abhiram had consumed any food\n" +
					"besides his own, he said that due to his braces, he could not eat the other foods available.",
			"Bhabesh had claimed to be sitting between Chelsee and Dhruv during the movie. He had not had the\n" +
					"cold drink, due to him being a diabetic. However, he did have a bite of the sandwich and had passed\n" +
					"the drink to Dhruv. When asked about his relationship with Dhruv, he replied saying that they were\n" +
					"colleagues at work and that recently Dhruv had been distracted at work for some personal reasons, about\n" +
					"which he did not divulge in further.",
			"Chelsee was sitting between Abhiram and Bhabesh. Chelsee was Dhruv's ex-girlfriend. However,\n" +
					"Chelsee claimed that everything was amicable between them and that there was no bad blood. Chelsee\n" +
					"ended up having the cold drink as soon as Abhiram had sat down to check the flavour and then had\n" +
					"given the drink back to Abhiram; which she then had later, passed to Dhruv; 20 minutes into the movie.\n" +
					"Chelsee didn't have the samosa as she didn’t like oily food.\n",
			"After a background check, it was found that Dhruv, was allergic to peanuts and its by-products. All \n" +
					"eyes were on the ex-girlfriend; knowing Chelsee could have easily done this in the pitch black theatre.\n" +
					"However, Bhabesh had the sandwich as well and claimed not to have given the sandwich to Dhruv.\n" +
					"However, no solid evidence is present to support his claim.",
			"On further investigation, some traces of poison were also found on the floor. During interrogation,\n" +
					"Abhiram was composed and cooperative, Chelsee broke down completely while Bhabesh accused the\n" +
					"police for unnecessarily harassing him.\n" +
					"Who committed the murder and why? Also identify which one of the seven sins, was the driving force\n" +
					"behind the crime.",


			//STORY F CLUES
			"The body was first spotted through the window of the scullery by the housemaid, Rose, who\n" +
					"immediately alerted her mistress. Rose was a young, pretty thing of 22, who caught the eye of many\n" +
					"men in the neighbourhood, including her late master. She claimed to have been unwell due to nausea\n" +
					"on 25th September and had retired to her room post her afternoon chores, only leaving its confines to let\n" +
					"Robert’s younger brother at 7pm, his friend at 8:30pm, and his wife at 9:30pm into the manor later that\n" +
					"evening",
			"Robert’s younger brother, Samuel Winchester, had worked under him for almost a decade. However,\n" +
					"he had never been particularly close to his sibling, and their conversations pertained strictly to work.\n" +
					"Since the Winchesters were without child, Samuel would gain the most financially after Robert’s\n" +
					"demise, being next-in-line to the inheritance. He claimed to have met his brother in the study that\n" +
					"evening for something work-related, but had left immediately since Robert insisted he was tired and\n" +
					"needed rest. ",
			"Jacob Simmons was Robert’s closest friend, who had also been a business partner until a few weeks\n" +
					"ago, when they abruptly parted ways in business. Jacob was in a financial crisis, and after a short period\n" +
					"of no interaction, he had approached Robert that evening to request monetary support. He claimed to\n" +
					"find Robert in the study, pacing up and down the room, visibly distraught over his wife discovering his\n" +
					"scandalous affair with the housemaid. After consoling his friend and sharing a smoke, Jacob left the\n" +
					"manor.\n",
			"Ira Winchester was as prim and proper a socialite as the position of Mrs Winchester required her to be.\n" +
					"Though she had been a perfect wife, her relations with her husband were far from perfect. Their\n" +
					"marriage was in tatters, and she had overlooked Robert’s faults for too long. Ira claimed to have left the\n" +
					"manor earlier in the afternoon that day to meet a childhood friend, and had returned to find an empty\n" +
					"bedchamber. Assuming the lights in the study meant that her husband was working late, which wasn’t\n" +
					"uncustomary in the slightest, she switched off the lights and retired for the night.\n",
			"Will Hudson, Mrs Winchester’s childhood friend, was once a business partner of Winchester\n" +
					"Enterprises. On being cheated by Robert, Will proceeded to set up a rivalling business, vowing to ruin\n" +
					"Robert. Now a successful businessman, he is extremely powerful and influential. After Ira Winchester\n" +
					"left his house, he claimed to have travelled to a neighbouring city, and his alibi was confirmed by the\n" +
					"investigating team.\n" +
					"On receiving the autopsy of the dead body, all clues and facts were put together, and a team of detectives\n" +
					"zoned in on the culprit. Who is responsible for Robert Winchester’s death, what was their motive, and\n" +
					"which of the seven deadly sins was the driving force behind this murder?",


			//STORY G CLUES
			"Alfred was the butler .He served with Thomas Wayne in the great war and before Thomas Wayne died,\n" +
					"he promised him that he would take care of his prized possessions- his three sons. He also helped\n" +
					"Thomas Wayne design the Wayne manor. But he was very sceptical of Bruce Wayne selling the\n" +
					"company, feeling it would not be something his father would approve of. He also felt that Bruce Wayne\n" +
					"was ruining his family's reputation for not taking action against Selina as there were rumours she was\n" +
					"having an affair.\n" +
					"That day he was in charge of providing the food for the guests and making sure everyone was having a\n" +
					"great time.",
			"Selina was Bruce's wife .She had been married to him for the past 5 years. She was supposed to marry\n" +
					"Keaton but her father insisted she marry the owner of Wayne Enterprises. She was supposed to help\n" +
					"Alfred with his work and was seen interacting throughout the party. ",
			"Christian Wayne, the eldest son of Thomas Wayne, is an alcoholic. He was supposed to take control of\n" +
					"Wayne Enterprises but he fell from grace when Thomas found out he was on drugs. He lived with his\n" +
					"younger brother Bruce. He spends most of the days in a drunken state and usually comes back to his\n" +
					"room at night, without people knowing what he was up to.\n",
			"Keaton Wayne, the youngest son of Thomas Wayne, was a war hero. He had saved the lives of several\n" +
					"of his comrades, during the war. Now at home, he was about to get married to a girl chosen by Bruce.\n" +
					"He was offered control over Wayne Enterprises, but he declined stating he had \"honour\".",
			"Bruce Wayne ,the most loved son of Thomas , was always favoured by his father. He was the owner of\n" +
					"the company and the apple of the eye of the Wayne family. .But recently he had an epiphany; when he\n" +
					"came to know of his brother's heroic act. He wanted to sell his company to do something more\n" +
					"meaningful in his life. Who committed the murder and why? Also identify which one of the seven sins,\n" +
					"was the driving force behind the crime.\n",


			//STORY H CLUES
			"Jean Summers, the wife of the deceased, managed to give a statement despite seeming utterly distraught\n" +
					"– “We were an hour into our annual Summer Barbecue. Scott went inside the house to get more wine.\n" +
					"I heard my best friend, Raven, scream from somewhere inside the house. We rush inside to find...” She\n" +
					"paused to regain her composure and then resumed. “Scott was far from being the perfect husband. He\n" +
					"was a miser at best – always saving, never living in the moment. I never had the liberty to splurge\n" +
					"despite the fact that he came from good money. If it weren’t for the occasional glimpses of the man I\n" +
					"once fell in love with, I would have left him a long time ago”, she concluded. Despite her being sighted\n" +
					"outside the house at the time of murder, the detective made a mental note of the fact that Mrs Summers\n" +
					"would inadvertently become the sole heir to all that “good money” owing to the absence of a will. ",
			"Logan Howlett, Scott’s colleague, seemed surprisingly calm and upon questioning, he said “As\n" +
					"disturbing as the murder may be, it doesn’t come off as a shock to me that someone would want to hurt\n" +
					"Scott. He was at the top of his game and was earning more than he deserved, at least in my opinion. He\n" +
					"had worked his way up merely through influence and hence, had picked up quite a few enemies along\n" +
					"the way.” He claims to have been tending to the barbecue at the time of the murder but, no sources\n" +
					"could confirm it.\n",
			"Alex Summers, brother of the deceased, approached the Detective and seemed to be in quite a frenzy\n" +
					"to get things off his chest ‘’Scotty was asking for it, what with all the egos he must have hurt in his\n" +
					"rather brash professional life. Even when we were little, he never failed to show me in a poor light for\n" +
					"his own benefit.” The strain in their relationship wasn’t lost on the detective. It was later confirmed that\n" +
					"his alibi of making a quick run to the grocer’s for last minute supplies, checks out.\n",
			"Detective MacTaggert exercised excessive caution while approaching Ms Raven Darkholm, best friend\n" +
					"to Mrs Summers and the one who claims to have witnessed the heinous act. “I had gone indoors to use\n" +
					"the restroom and happened to look over to the open kitchen while crossing the adjoining living room.\n" +
					"Scott was searching for something in the liquor cabinet, oblivious to the hooded man who stood behind\n" +
					"him silently, gun in hand. Before I could react, the man had shot him in the back and ran out through\n" +
					"the backdoor.” She stated. Upon being questioned about her relationship with the victim, she said “I\n" +
					"never really approved of Scott. He wasn’t one to keep Jean happy but then again, he was only a man\n" +
					"and men rarely succeed in pleasing a woman. Moreover, they had incompatibility to burn. The angel\n" +
					"that my Jean is, she clearly deserved better.”",
			"Dr. Hank McCoy, their next-door neighbour was brought in for questioning even though he wasn’t\n" +
					"invited to the party. Sources state that Mr. Summers was known to have picked constant fights with the\n" +
					"man and had once accused him of illegal possession of arms which later proved to be libellous. “Scott\n" +
					"was very paranoid when it came to my experimentations. I am a gun enthusiast at heart, which made\n" +
					"him suspicious of the numerous shipments that I had delivered. The police complaint was the final\n" +
					"straw. It’s a miracle that I kept my temper in check and didn’t retaliate immediately”\n" +
					"Detective MacTaggert leaves the premises quite satisfied as her questioning in itself was enough to\n" +
					"crack the case wide open. Have you cracked it as well? Who is the murderer? What was their motive?\n" +
					"How did they carry it out? Also identify which of the seven sins, was the driving force behind the crime.",


			//STORY I CLUES
			"John lived on the ground floor. According to him most of the morning went in doing his laundry. A pile\n" +
					"of wet clothes hung on the rope outside seemed to agree with his statement.",
			"Sam was the other resident on the ground floor. His night shifts on Saturday meant he spent the whole\n" +
					"of Sunday morning sleeping; or so Sam told the police. There was no conclusive evidence to back this\n" +
					"up.\n",
			"Walter lived on the second floor. A lunch date with couple of old friends and some grocery shopping\n" +
					"completed his morning. Later he had returned to his apartment via the elevator and cozied up with a\n" +
					"novel.",
			"Lester lived adjacent to Walter. Like every Sunday he had gone to visit the local church nearby and had\n" +
					"returned after lunch with a family friend in a nearby restaurant.",
			"Mrs. Smith, was the one who had called in. Her elder son has tuition in the morning. She had woken up\n" +
					"to prepare breakfast for him. It was during that time she had spotted the blood, while bidding him\n" +
					"goodbye.\n" +
					"Who was the murderer and why? Also identify which of the seven sins, was the driving force behind\n" +
					"the crime. ",


			//STORY J CLUES
			"It was a chilly evening in London, where she sat with her childhood friend Anna and distant niece Jane\n" +
					"for dinner while they uncorked this lovely, full-bodied wine bottle that Anna had bought for her. Mary,\n" +
					"the maid had been bustling all afternoon for this soiree that Emma had been planning for quite a while.\n",
			"Before you knew it, Jane sprung up from the dinner table and stormed into her room, all because she\n" +
					"didn't agree with her Aunt. The two elderly ladies found it unacceptable. Keeping the incident aside,\n" +
					"they continued with their meal, enjoying the food and wine, while Mary waited in the shadows, waiting\n" +
					"to be beckoned.",
			"\"It's such a shock to me\", remarked prim Anna. \"They meant so much to Emma. She wore it to every\n" +
					"social gathering and now it's just vanished? They were on her bedside table, when I left her. She was\n" +
					"very upset about the falling out with her niece, Jane, so I went with her to the room just to calm her\n" +
					"down. But she fell sound asleep in hardly any time, I guess the wine was a lot for her. It was then that\n" +
					"I told Mary that she should get Emma an aspirin in the morning, knowing that she would need it, and\n" +
					"told her not to disturb her. It's all because of that dreadful girl Jane, she shouldn't have kicked up a fuss\n" +
					"at dinner yesterday. I'm sure these yearly visits of hers are just a farce. She just wants the inheritance.\n" +
					"And she has started taking it for herself already!\"",
			"\"It's horrid!\", cried Jane, indignantly. \" I felt extremely guilty after that terrible argument with Aunty\n" +
					"so I asked Aunty Anna if she was alright and I went to her room to apologize. She was asleep, so I woke\n" +
					"her up and I just had to apologize! We had put things behind us. It was when she got all warm and\n" +
					"settled in bed that I left her. I didn't pay attention to the pearls but I'm pretty sure, the pearls were right\n" +
					"there: on the bed stand. Aunty cared too much about those pearls that her vanity was getting to her head.\n" +
					"You should talk to the maid Mary, I'm pretty sure she'd be the one with the pearls. She needs the money\n" +
					"anyway, and I'm sure they don’t like the way Aunty treats them, sometimes she can get a tad superior.\"",
			"On questioning, Mary recalled, \"I entered Madam's room at 7 in the morning to give her the Aspirin as\n" +
					"Madam Anna had directed me to. I drew the windows close and gave her the usual mittens she wears\n" +
					"every night. I placed the aspirin and jug of warm water on the table and left. I didn't remember her\n" +
					"pearls, so I'm not sure whether they were there or not. However, Madam Anna had told me not to enter \n" +
					"the room after she left. I just followed instructions. I was surprised she came for dinner, considering\n" +
					"how very envious she is of Madam Emma\", with a smirk on her face.\n" +
					"Emma was beside herself, weeping uncontrollably when she sobbed, \"How I wish I hadn't had so much\n" +
					"of that dratted wine! I don't remember a thing after dinner. I loved those pearls. How beautiful they\n" +
					"looked on me! And now they're gone. Oh I beg you, do find them for me! “ Who do you think took the\n" +
					"pearls and why? Also identify which one of the seven sins, was the driving force behind the crime.\n",


			//STORY K CLUES
			"Ron and Hermione first went to Uncle Vernon in the living room and asked him what he was doing at\n" +
					"around 5. He replied, saying that he was watching the news and reading his newspaper while having\n" +
					"his evening tea.",
			"Then Ron and Hermione went to Aunt Petunia and asked her what she was doing at 5. She said that she\n" +
					"was busy doing laundry and then went to prepare dinner for the evening.\n",
			"Marvin and Sam were next. they were playing catch, with the children down the street and when\n" +
					"questioned about their activities at 5; they stated that they were trying to mingle with the street kids,\n" +
					"asking them, if they could join in for football.\n",
			"Aunt Marge was next on the suspect list. After interrogating her, Ron and Hermione left empty handed,\n" +
					"as she was too arrogant to provide an alibi, stating that it was un-ladylike of her to sneak a piece of\n" +
					"cake.\n",
			"Finally, Ron and Hermione went to Dudley and asked for his alibi. He said that he went to collect the\n" +
					"mail and was stuck in the washroom ever since because he had to break wind.\n" +
					"Who stole the cake and why? Also identify which one of the seven sins, was the driving force behind\n" +
					"the crime."
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.password_two);
		Intent intent=getIntent();
		tagvalue=intent.getIntExtra("cluetag", 0);
		b1=(Button)findViewById(R.id.cluego);
		et1=(EditText)findViewById(R.id.cluepassword);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		SharedPreferences Prog;
		Prog = getSharedPreferences(filename, 0);
		SharedPreferences.Editor editor = Prog.edit();
		pass = et1.getText().toString();
		int index = tagvalue - (11 + (tagvalue/10 - 1)*5);
		String tagnames[] = {"","clue1","clue2","clue3","clue4","clue5"};

		if(pass.contentEquals(st[index]))
		{
			editor.putString(tagnames[tagvalue%10],clues[index]);
			Toast.makeText(getApplicationContext(), "Story segment unlocked", Toast.LENGTH_SHORT).show();
			finish();
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
			finish();
		}
		editor.apply();

	}
}
