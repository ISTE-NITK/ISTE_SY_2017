package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DisplayStory extends Activity implements OnClickListener {

    Button b1,b2,b3,b4,b5,b6;
    String tag;
    int tagvalue;
    public static String filename = "Progress";
    SharedPreferences Prog;

    String[] prefaces = {

            "On Sunday,February the 28th 2010, sometime late in the morning, Kanan Hiremath went missing from his home in Bangalore. The Missing Person report, however, was not filed until the next morning, when his neighbour, Dr Ezekiel Philip, contacted the police informing them of a call that he had received at dawn, demanding a ransom of 54 lakh Rupees for the release of Mr Hiremath. Dr Philip was questioned further on the victim, his features and his personality. Kanan Hiremath was the son of a businessman who ran a firm selling machine components for several industries, and had taken over the business after his parents’ untimely death. He was between 30 and 35 years in age, and stood around 5’10” tall, with a muscular frame. He had been involved in the freak road accident which had killed his parents five years ago, and whenever the subject came up he would get visibly uncomfortable and try to avoid talking about it. Mr Hiremath had inherited his house, a massive colonial villa from his parents. He generally lived in isolation, mostly only commuting to and from work. Dr Philip then described the ransom call; the voice had sounded like that of a middle-aged male, somewhat deep and rough. It had also sounded familiar to him. Moreover, the voice demanded a strangely exact amount of money and gave Dr Philip instructions on where the money was kept in the victim’s house, and how to get it, which lead the police to speculate that the culprit was someone that both the doctor and Mr Hiremath knew. On tracing, the ransom call was found to have originated from a PCO payphone 27 km away from where the abductee was last seen in the neighbourhood. ",


            "The New Year's Day of ’09 wasn’t a happy one, as the world-renowned actor, Joey Tribbiani, had been found murdered in his villa in Las Vegas. The famous detective Gunther had been called upon to crack the case. On talking to Joey’s assistant Janice, he learned that, all through the previous year, Joey had been stalked, blackmailed and had even received death threats. Upon investigating the crime scene, he determined that the stalker (who was the murderer) was someone, who was a very close friend of Joey, as there were no signs of a struggle. He caught the next flight to New York, to interrogate Joey's famous friends. ",


            "One eerie night at Miss Peregrine’s home for Psychiatric persons, lit by the dim yellow hue of the only light in the room, lay Ms. Wilkinson’s cold, lifeless body surrounded by a group of pseudomaniacs; Tom McCarthy, John Doe, Macey Quill, Eva Adams and Marcus Sanders, eagerly waiting to falsely claim to having committed the crime of killing their warden. The murder as investigated by Alan Ston, the best detective and cryptographer in town, was clean, sophisticated and perfectly planned with absolutely no evidence left behind except a note that flashed the question ”You Ever Care About Me?” While searching through Ms.Wilkinsons files, Mr.Ston found a note containing the ID (D-1-3-5-19) for the patient who was eligible to have been discharged two weeks back. Now, Mr. Ston had the impossible task of interrogating a bunch of pseudomanics and finding out who the actual culprit was. ",


          "It was a cold night in December. In the house at the far end of the street, a woman was found lying outside on the cold brickwork in a pool of dark crimson blood. Inside the house, another woman was found dead on the sofa. But there was no blood around her. All that was there was a face twisted in pain and a lifeless body trying to match the coldness of the weather outside. The first woman was Alice, a rising supermodel in the industry. The one inside the house was Dinah, who used to be one of Alice’s closest friends before some unfortunate events tore them apart. There were three other people in the house at that moment. First was Connell, who was Alice's live in relationship partner and Dinah's former boyfriend. Next, there was Bernard Peterson, the short-tempered designer who found Alice and mentored her for 10 years, taking her to the top of the industry. And finally, Rosy, the maid who had been in Alice’s employ for the last 8 years. The police, lead by DI Joe, arrived at the scene and so began the investigation into the events of that dreadful night. ",



            "It had been a very cold couple of nights at the Braavos Asylum, ever since winter was here. The chilling winds at night had been giving a hard time for the guards around the asylum especially at night. And the inmates’ rooms had no proper heating system and that made quite a few inmates to go sick thanks to the cold. And on 13th of September, it was a night just like that.  A cold night, and a there had been a cold-blooded murder as well. The head guard of the Asylum had been murdered in the dim night light. He had been murdered right on his office chair, right around 3 in the night. The murder weapon was right next to him, his baton. The officer had decided to catch his regular late night nap and dozed off on his chair. The lights had been out the since 10 in the night due to a power failure. As soon as the head guard had dozed off the murderer got in and used the baton lying on his table and smashed the officer’s head. No fingerprints on the door, on the baton or anywhere around the room because most of the members of the asylum wore gloves due to the extreme cold. There are 5 rooms in the same corridor. 3 of them belong to the inmates, one belonging to the room of the Deputy Head Guard and the final one is that of the Chief Psychiatrist. As Detective Tyrion of WCPD rolled into the asylum he knew, that these were the 5 major suspects he had to look into.",


            "The cool September breeze ruffled and brushed apart the red and white rose petals strewn artistically on the aisle leading to the altar. The wedding guests, impeccably dressed in suits and dresses, sat motionless, gripped with shock. The air between them was as grim as the look on Edward Patterson’s face. He had just heard the news. His fiancé, Alayna Kingsley was found dead in the woods a mere six miles from the resort. A white handkerchief, a hair band and a small, disheveled piece of paper was all that was found beside the decked-up body at the crime scene. Even dead, she looked beautiful, what with the make-up accentuating her features.  She was last seen at breakfast the previous morning. Edward was visibly shattered. His fiancé was a lean woman with beautiful pale skin, friendly blue eyes contrasting her strong, sharp features. Her pixie haircut had grown just long enough to flow over to her lower neck. She worked as an analyst in Gray Holdings Inc., where she’d met Edward. He loved her immensely.",



            "Ridley's Station was a quaint little town nestled in the imposing Rocky Mountains. The town got its name from being the spot where searchers used to alight from packed trains in the search for gold during the gold rush. The town used to bustle with traffic and trade but like any mining town it was doomed to be abandoned when the mines ran dry, and they soon did. The few remaining residents too changed their character as their homes became dilapidated shacks, their valuables became detritus and ambitions became a mere memory. Some brave souls started new ventures to keep some sense of self-importance. Daniel Mason was one such soul until his lifeless body was found, hogtied, scalped and mutilated in the middle of the town square one winter morning\n"+ 
"Below his cold dead body, a placard read:\n"+  
" ”My hand will be against the prophets who see false visions and utter lying divinations. They will not belong to the council of my people or be listed in the records of Israel, nor will they enter the land of Israel. Then you will know that I am the sovereign lord.”\n"+  
"-Ezekiel 13:9",


            "Year 1851\n"+ 
"Amidst heavy rains and violent thunderstorms, Nikola Tesla lay dead in his London apartment. He lay on the ground like Da Vinci’s Vitruvian man, hands and legs spread to the farthest possible. Blood came bubbling down his mouth and the smell of fleas inhabiting his dead body was unbearable. All in all, it was a gruesome sight to behold.",


            "Lincolnshire, England.\n"+
"It is the year 1860, the cold morning breeze blows past the Harlaxton Manor as the snow slowly collects on its walls. The occupants of the mansion are extremely busy as they prepare for the Sunday Luncheon. The family currently residing in the Harlaxton Manor are the Scrimgours. Brutus Scrimgour is the patriarch of the family. He is a very wealthy man and is very influential; earning a bulk of his wealth through trade with India. Today the Duke of Wellington was stopping by for lunch and so he wanted everything in the house to be perfect. The responsibility of this fell squarely on the shoulders of Martha Scrimgour.\n"+
" ”Thomas, where have you been” yelled Martha. A man in his early 40's put down the vase he was dusting and turned to address Martha. He was wearing a dress coat with formal trousers and a black bow tie. His name was Thomas Rhett and he was the butler. Thomas replied  ”I had gone to collect the mail Ma'am”.  ”Forget about the mail” replied Martha.  ”Have the flowers come in yet?”  ”I am not quite sure about that, I will check up on that” said Thomas.  ”Go quickly and I want those flowers to look perfect” said Martha. Thomas left with a curt nod. Martha quickly made her way to the kitchen and found the chef coating the lamb with a mix of rosemary and basil. She was pleased to see that her chef Harry was finally working hard. But just as soon as Harry had completed coating the meat he turned and picked up the pipe lying on the counter and started to smoke. This gesture infuriated Martha and she stormed into the kitchen and snatched the pipe and screamed  ”I saw you working hard and thought that it was bad of me to fire you. But now I am sure of what I am doing. This is the last dish you will ever cook in this house, after this I want you out”.\n"+
"Martha stormed out of the kitchen and entered into the gardens for a bit for fresh-air. She noticed her gardener Sam, removing the snow from the garden. He saw her and greeted her. She smiled back and she then took a deep breath and walked back into the house. She saw her servant Paula exiting the kitchen with a glass of water. As soon as Paula saw her she quickly came in front of her and said  ”Ma'am I have finished arranging and setting your clothes and the emeralds have also been polished and kept on the bed”. Martha nodded and slowly climbed up the stairs to her bedroom. As she reached the top she heard the doorbell, the door was answered by Paula and Brutus walked in and took of his coat and boots. He looked at his wife and exclaimed  ”Honey get dressed, the Duke will be here any minute now”. Martha promised that she would be ready as soon as possible and then opened the door to her bedroom. As she looked at the clothes arranged on her bed, she noticed something missing. The shining green emeralds her husband had got her from India were missing. She screamed as loud as she could. Hearing her screams the entire household entered the room. She then looked at Brutus's face and said  ”Someone has stolen the emeralds” as tears rolled down her face. Brutus looked at her and then to his working staff and said  ”Paula shut the doors, the thief is among us. Nobody is to leave until we catch the individual and send a telegram to Hercules Pirate and ask him to come here now. Only he can solve this now”.",


            "If vanity could be described as an object then nothing would describe it better than the White Mansion. Its wide archways with huge supporting pillars and the interiors filled with exquisite furniture from all around the world, scream false pride. But the most outrageous of them is the dog house. A two-storeyed building filled with all sorts of mad eccentricities, up to date with the latest trends. This morning though, the atmosphere was filled with a solemn silence of the unexpected. A girl was found dead in the woods surrounding the mansion grounds. How and why an unknown girl scaled the walls of this place in the dead of the night, no one knows or so they say. Forensics have confirmed the reason for death as multiple, fatal animal bites, probably by a dog.\n"+
"Considering their high social status and immense fortune one would assume that the Whites are highly sociable and amicable. Quite to the contrary, they happen to be a bunch of social misfits consisting of an old mother, two widowed daughters and a trusted servant. None of them have ever been spotted at social gatherings. Narcissa White, the old mother suddenly came into possession of the huge fortune following the demise of her husband, Dr Nebula White. ",


            "Habib Tariq admired the picturesque beauty of his surroundings. He was a guest of the Anale Owa tribe that occupied the Upper Guinea forests of Southern Guinea. An ethnobotanist by profession, he had set out on a journey to study and learn the relationship of tribal communities with their forest.\n"+
"Today Habib was in the midst of a group of people waiting outside the hut of the Abenaki family. Timiska Abenaki was giving birth to her first child and everyone was excited and jubilant. The crowd began to whoop as the midwife came out; probably to give the news of a successful delivery. The cheers however, began to dissipate at the sight of her grim expression.\n"+
"”The chin is divided,” she proclaimed. A hush fell over the crowd followed by a wave of frantic whispers. ",

            "Mr.Fletcher raised his arms and stretched. Another pile of papers to score and his job here was done.\n"+
"”I’m going to miss this place,” he thought to himself ”Pretoria will be great but it’s hard to leave all this behind. Mr. Sutachan might be a bit crude and domineering but he’s a good man; all the children, especially Danyal and Tanya have come such a long way; and Maria-”\n"+
"The chain of his thoughts were interrupted by a knock on the door. He got up, opened the door and beamed.\n"+
"”It’s you,” he said, ”Come in..” ",

             "On a chilly Thursday morning, Greg Daniels was found dead. He was the senior journalist for The Scranton Chronicle based in Scranton, Missouri. Private Investigator Billy Macklin was called at 8AM to the Chronicle’s newsroom.\n"+
"Said the janitor, ”I came in a little later after 7:30AM and got right to cleaning. Mr. Greg’s office is at the other end so by the time I started to clean his room, it should have been 7:50AM. I opened the door and I immediately saw his body lying in a pool of blood on the floor. By that time, Mr. Steve and Mr. Frank had come to the newsroom. I yelled out to them and we checked his pulse even though he was clearly dead. Steve decided to call you to avoid any bad press.” ",

"I woke up in the middle of the night to the sound of my phone ringing. 11:35pm; another call from the department. They wanted me at Blueberry Manor right away. Blueberry Manor was owned by the wealthy Mr. Jeremy who had hit a jackpot in business after college and had come across loads of money. I was quite shocked to hear that Mr. Jeremy had been found dead at the Manor at around 11:30pm. I drove faster than usual and reached the crime scene at 11:55pm. ",

"It’s another gloomy morning in Seattle. The traffic gridlock on Elliott avenue St. is driving everyone impatient including Ava Maria Vasquez, a thirty-something psychiatrist; tall, attractive brunette with doe eyes so black, with the depth of someone wise beyond her years. But she was more than beautiful; she also possessed the powerful gift of understanding those whom the world considers ”mad”, ”crazy” or ”psychotic”, and a strong willingness to help and make people’s lives better. As she checks the time on her watch; which belonged to her deceased father, she realizes she might not make it in time for her appointment with Sam. The last few days have been hard on her as the more she found out about Sam, the more she realized how many similarities they shared; intellectually and physically. 'Sam is special' she wonders. There is something about her which makes Ava feel an instant connection every time they meet. She instantly rings up Martha; the receptionist at her office, and requests her to keep her client engaged until she arrives. As she is on the phone with Martha, she sees that the traffic has come to a standstill because of the presence of police vans and an ambulance. She could also spot the media at a distance. Although she wants to know what’s happening, she tells herself that she could use this time to work on another ongoing case; that of 13-year old Matilda. She opens the diary and starts reading from the page she stopped at last night. Somehow it is always a difficulty to figure this out as she falls asleep, almost after every read. " 

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        tagvalue = intent.getIntExtra("storytag", 0);
        Prog=getSharedPreferences(filename, 0);
        SharedPreferences.Editor editor = Prog.edit();

        editor.putString("preface", prefaces[tagvalue-1]);
        editor.apply();

        setContentView(R.layout.display_story);
        b1=(Button)findViewById(R.id.story1clue1);
        b2=(Button)findViewById(R.id.story1clue2);
        b3=(Button)findViewById(R.id.story1clue3);
        b4=(Button)findViewById(R.id.story1clue4);
        b5=(Button)findViewById(R.id.story1clue5);
        b6=(Button)findViewById(R.id.story1showprogress);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

    }
    @Override
    public void onClick(View arg0) {
        Intent i=new Intent(DisplayStory.this, UnlockType.class);
        Intent i2 = null;

        switch(arg0.getId()) {
            case R.id.story1clue1: i.putExtra("cluetag", tagvalue*10 + 1); break;
            case R.id.story1clue2: i.putExtra("cluetag", tagvalue*10 + 2); break;
            case R.id.story1clue3: i.putExtra("cluetag", tagvalue*10 + 3); break;
            case R.id.story1clue4: i.putExtra("cluetag", tagvalue*10 + 4); break;
            case R.id.story1clue5: i.putExtra("cluetag", tagvalue*10 + 5); break;
            case R.id.story1showprogress: i2 = new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
        }

        if(i2 == null)
            startActivity(i);

        /*switch(tagvalue){
            case 1:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "11");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "12");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "13");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "14");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "15");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 2:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "21");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "22");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "23");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "24");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "25");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 3:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "31");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "32");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "33");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "34");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "35");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 4:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "41");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "42");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "43");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "44");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "45");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 5:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "51");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "52");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "53");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "54");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "55");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 6:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "61");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "62");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "63");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "64");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "65");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 7:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "71");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "72");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "73");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "74");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "75");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 8:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "81");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "82");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "83");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "84");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "85");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 9:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "91");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "92");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "93");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "94");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "95");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
            case 10:{
                switch(arg0.getId()){
                    case R.id.story1clue1:i.putExtra("cluetag", "101");startActivity(i);break;
                    case R.id.story1clue2:i.putExtra("cluetag", "102");startActivity(i);break;
                    case R.id.story1clue3:i.putExtra("cluetag", "103");startActivity(i);break;
                    case R.id.story1clue4:i.putExtra("cluetag", "104");startActivity(i);break;
                    case R.id.story1clue5:i.putExtra("cluetag", "105");startActivity(i);break;
                    case R.id.story1showprogress:Intent i2=new Intent("com.nitk.iste.scotlandyard.SHOWPROGRESS");startActivity(i2);break;
                }
            }break;
        }*/
    }
}
