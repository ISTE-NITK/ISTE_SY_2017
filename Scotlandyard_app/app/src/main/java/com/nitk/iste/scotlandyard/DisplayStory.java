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

            "It was a beautiful Sunday morning, as the dawn light up the veranda of Alex's house by the beachfront.\n" +
                    "Looking from afar, the broad lawns and the fancy cars in the parking lot in the front yard screamed of\n" +
                    "Alex's good fortune. The money meant he had friends and fame a plenty. But Alex's character, was\n" +
                    "unlike what one would generally expect of a “rich” brat. His good-nature and charming personality had\n" +
                    "earned him everyone's adoration. The fact that he treated everyone around him from his butler Rowney,\n" +
                    "to the president of an MNC with great respect, was a standout virtue of his. Rowney, who'd been loyally\n" +
                    "serving the Greens, well before Alex's birth, often praised Alex's humility. Though Rowney’s\n" +
                    "dedication, was partly because, he wanted to pool enough money for his daughter’s heart surgery.\n",


            "“We don't need no education” went the song in Detective Marge’s iPod. “That's a double negative!”,\n" +
                    "she quipped to herself and chuckled. The newest recruit of Alderaan police station, Marge, found that\n" +
                    "police work involved more of paperwork than kicking ass, unlike what they had yapped about in the\n" +
                    "academy. As her thoughts took over, the song drifted off… only to be interrupted by the shrill ring of\n" +
                    "the DeskPhone.\n" +
                    "Madeleine, the only daughter of Alderaan’s shipping magnate, Mr. Black, was kidnapped on the way\n" +
                    "back from school. A muffled voice had demanded a ransom of 5 million dollars…\n" +
                    "The next day, with help from Mr. Black, Marge rounded off a list of 5 suspects for questioning in the\n" +
                    "station.\n",


            "As the hour hand touched midnight the gentle waters off the pier reflected a pretty little picture: playful\n" +
                    "flames flickering defiantly against the frigid night air. Ironically enough, the fire was fuelled by the\n" +
                    "Bluth’s Frozen Banana Stand. All too soon their greed turned the playful flames fiercer and they surged\n" +
                    "into an inferno which burned itself to death within minutes. By the time the police arrived on the scene\n" +
                    "all that was left were faintly glowing embers that cast shadows on the hollowed husk of what was once\n" +
                    "a local landmark. ",


            "Geisha (Mameha) - a Japanese hostess trained to entertain with conversation, dance, and song.\n" +
                    "Okiya - The lodging house in which a geisha lives during the length of her career as a geisha.\n" +
                    "Ochaya - In Japan, an ochaya (literally \"tea house\") is an establishment where patrons are entertained\n" +
                    "by geisha.\n" +
                    "Mother (Okasan) - The proprietress of the okiya is called okā-san (the Japanese word for \"mother\").\n" +
                    "Tatsuya Fujiwara - A patron of Ichiriki Ochaya\n" +
                    "Yuki Fujiwara- Tatsuya's Wife\n" +
                    "Hatsumomo Murasaki - Yuki's Sister",


            "With the release of the new movie \"Pink\", four friends Abhiram, Bhabesh, Chelsee, Dhruv decide to go\n" +
                    "together for it.\n" +
                    "Just before the start of the movie, Abhiram decides to go and buy food for everyone. During the interval\n" +
                    "when the lights were switched on, Dhruv was found frothing from his mouth, his face was purple from\n" +
                    "asphyxiation and his heart had stopped beating.\n" +
                    "Soon the police came to investigate the incident. They conducted a security check on the personal\n" +
                    "inventory of Abhiram, Bhabesh and Chelsee; during which they came across the facts that Abhiram's\n" +
                    "hood of the jacket was wet, Bhabesh’s shoes had kernels of popcorn stuck in the soles and Chelsee had\n" +
                    "brown stains on her shirt's sleeves.\n" +
                    "The police commissioner then asked Abhram, Bhabesh, Chelsee for their respective statements:\n",


            "The dawn of 26th September saw quite a commotion on Fleet Street, with police sirens and an\n" +
                    "assemblage of detectives, reporters and onlookers disturbing the otherwise prevalent placidity of\n" +
                    "Winchester Manor. Robert Winchester, aged 46, was found dead in his backyard at daybreak, seemingly\n" +
                    "due to a fatal fall from the balcony of his bedchamber. Robert, an affluent businessman and an excellent\n" +
                    "administrator, was at the helm of Winchester Enterprises. However, even his impressive social standing\n" +
                    "and lack of vices could not counter his ruthlessness and utter disregard for personal relations.",


            "Bruce Wayne was the second of three sons of the late Thomas Wayne , Christian Wayne being the\n" +
                    "eldest and Keaton Wayne being the youngest. The city's rich and famous had gathered at the Wayne\n" +
                    "Manor to celebrate the biggest event to be held in the city; Keaton Wayne's marriage. The guests at the\n" +
                    "event, were having a great time, drinking the fine wine, admiring the elegant furnishing and indulging\n" +
                    "in some good old banter and gossiping. Suddenly, amidst all this, there was a loud scream. Everyone at\n" +
                    "once, rushed towards the source of the scream. To their horror ,they saw Selina Wayne, Bruce Wayne’s\n" +
                    "wife, staring at her husband's dead body. With Bruce Wayne about to sell his company and enjoy the\n" +
                    "bliss of family life, people did expect changes to occur in Bruce’s life. But a murder, was most\n" +
                    "unexpected. The whole manor was sealed to prevent the culprit from fleeing. Captain Jim Gordon was\n" +
                    "called to handle the case. He observed that there were no signs of struggle and that the room was one\n" +
                    "of the most private rooms in the manor, thus, known only to the closest few. He instructed the butler\n" +
                    "Alfred, to open the gates and let the guest leave except for the closest few. After questioning he realised,\n" +
                    "that it was obvious who the murderer was. ",


            "Detective Moira MacTaggert was quite annoyed as she had to cut short her Sunday afternoon siesta\n" +
                    "only to attend to the primary investigation of a seemingly boring homicide that had taken place earlier\n" +
                    "in the day. She groaned as the GPS tracked her destination to be somewhere in suburban New York –\n" +
                    "murder in quiet suburbia, can’t get more mundane than that. As she pulled into the driveway of Number\n" +
                    "12, Westchester County, she couldn’t help but note that the pall of gloom that had set in jarringly stood\n" +
                    "out against the tacky party decorations. The faint smell of barbecue smoke still hung in the air as the\n" +
                    "medical examiner wasted no time in explaining to her that the victim, Mr Scott Summers had been shot\n" +
                    "in the stomach around 11 am and met with an almost immediate demise. The bullet came from an\n" +
                    "unauthorized standard handgun which was later found on-site but rubbed clean of fingerprints. The\n" +
                    "incident took place in the kitchen shortly after he had excused himself from the party to refill the wine\n" +
                    "decanter. On hearing that one of the guests claims to have witnessed the murder first-hand, Detective\n" +
                    "MacTaggert resorts to questioning as her plan of action. ",


            "As chirping birds broke the silence of dawn, a bright Sunday was in the offing. Terrence, the leader of\n" +
                    "a worker’s union was quite infamous. A grumpy, pessimistic personality; he was a slave to his cheap\n" +
                    "OMR and Mills cigarettes. Notorious for picking up fights with just about any soul left, right and centre;\n" +
                    "his name evoked disgust, in other union circles too.\n" +
                    "That Sunday, the filth of a man, woke up early to go out for a walk and lose himself to the nature around.\n" +
                    "But just as he got out of his apartment, he noticed someone lurking over his shoulders. Before he could\n" +
                    "turn around a strong pair of hands shoved him inside the apartment and locked the door. It was darkness\n" +
                    "all around. A faint light penetrated through the window sill in the far corner; but it didn’t really help.\n" +
                    "He was scared to death, and feared the worst. No sooner, he was stabbed from behind, thrice! with those\n" +
                    "strong hands muffling out his screams. “You shall rot in hell for all your sins, your traitor! This is what\n" +
                    "happens for those who don’t keep their word!”\n" +
                    "That Sunday had just turned bloody. Mrs. Smith, a neighbour had spotted a thin film of blood creeping\n" +
                    "from under the door and had at once dialled for the police. The police soon arrived and started their\n" +
                    "investigation. They were told that no one had entered or left the main gate of the apartment in the\n" +
                    "morning, from the security guard, as he lit up a cigar. The police then interrogated each and every\n" +
                    "person inside the premises which consisted of 6 houses and a security accommodation.\n",


            "So, Emma, our very own elderly neighbour, loved curling up with her mittens on her hands, warm and\n" +
                    "cosy in bed every night, her prized pearls on the bed stand next to her. One could even call her vain,\n" +
                    "considering the attachment she had toward this possession of hers. Oh! the terror that crossed her face\n" +
                    "when she found them missing.\n",


            "After Harry’s first year at Hogwarts, he returned to his aunt’s home at 4 Privet Drive. Every year during\n" +
                    "Dudley’s birthday a chocolate cake was ordered from the nearby bakery. But this time around, as his\n" +
                    "birthday fell on a Sunday, and the bakery was closed, aunt Petunia herself baked a delicious looking\n" +
                    "chocolate cake. Like every year, Dudley had planned for a grand party with his friends but (as usual)\n" +
                    "poor Harry Potter was not invited. Just before the start of the party, Aunt petunia found that the cake\n" +
                    "was missing. Frantically searching everywhere, she found a few crumbs lying in front of Harry’s room\n" +
                    "under the stairs. Connecting the two, she started banging on his door, accusing him of stealing the cake.\n" +
                    "Realizing he is in deep trouble, Harry at once sends for Ron and Hermione, his best friends. Moreover,\n" +
                    "he places the time the cake went missing to be around 5:00 pm. Arthur dropped Ron and Hermione in\n" +
                    "his Flying Ford Anglia in about half an hour.\n" +
                    "The six people that were present at the party excluding Harry were; Uncle Vernon (father), Aunt Petunia\n" +
                    "(mother), Dudley, Marvin and Sam (Dudley’s friends) and Marge (aunt).\n",

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
