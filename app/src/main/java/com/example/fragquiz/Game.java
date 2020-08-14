package com.example.fragquiz;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Game class
 * Contains information about the current game, such as the current question
 */
public class Game {
    private MyDB db;
    private Question currentQuestion;
    private String question;
    private int progress;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private int correctAnswerIndex;
    private Context context;


/*
    private ArrayList<Question> questions = new ArrayList<>();
    private Question question1 = new Question("Hvad er verdensrekorden for at drikke 1 liter øl?", "0,9 sekunder", "1,3 sekunder", "1,8 sekunder", "2,2 sekunder", 2, 4);
    private Question question2 = new Question("hvad er det officielle videnskabelige navn for ølstudier og ølvidenskab?", "Zythologi", "Ønologi", "Vicimetri", "Mycologi", 1, 5);
    private Question question3 = new Question("Hvilket land indtager mest øl pr. indbygger?", "Polen", "Danmark", "Bulgarien", "Tjekkiet", 4, 3);
    private Question question4 = new Question("Hvad er navnet på geden i Valhal, der drypper mjød fra yveret?", "Heidrun", "Særimner", "Sleipnir", "Tanngrisner", 1, 3);
    private Question question5 = new Question("Hvilken er forbien for at have et tomt ølkrus", "Nomofobi", "Coprastasofobi", "Cenosillicafobi", "Charofobi", 3, 5);
    private Question question6 = new Question("Hvad er navnet på verdens største ølfestival?", "Great Canadian Beer Festival", "Oktoberfest", "The Big Brew Beer Festival", "Pilsner Fest", 2, 1);
    private Question question7 = new Question("Hvilke 3 basisingredienser findes, sammen med vand, i øl?", "byg, gær og humle", "malt, gær og sukker", "malt, humle og gær", "malt, byg og sukker", 3, 2);
    private Question question8 = new Question("Hvilket stof indeholder tonic-vand, der bruges i gin og tonic, der blev brugt mod malaria?", "Malarone", "Kinin", "Klorokin", "Artemisinin", 2, 1);
    private Question question9 = new Question("I hvilken alkohol kan man finde en orm i flasken?", "Rom", "Tequila", "Vodka", "Whisky", 2, 1);
    private Question question10 = new Question("Hvilken spiritus er den mest populære i verden?", "Whisky", "Vodka", "Gin", "Rom", 2, 1);
    private Question question11 = new Question("Ethanol gør dig fuld, men hvilket stof giver tømmermænd?", "Diethyl-ether", "Ethanal", "Glycerol", "Benzen", 2, 2);
    private Question question12 = new Question("Hvad er sundhedsstyrelsens anbefalinger for maksimale genstande om ugen for mænd og kvinder?", "7 for kvinder, 21 for mænd", "10 for kvinder, 14 for mænd","14 for kvinder, 21 for mænd","14 for kvinder og mænd", 3, 1 );
    private Question question13 = new Question("Hvilken type vin er i virkeligheden en øl?", "Portvin", "Dessertvin", "Isvin", "Risvin", 4, 3);
    private Question question14 = new Question("Hvor stor en procentdel af alle dødsfald i 2012 skyldtes alkohol?", "3,90%", "4,80%", "5,90%", "6,40%", 3, 4);
    private Question question15 = new Question("Hvornår starter de fleste unge med at drikke?", "13-14 års alderen", "14-15 års alderen","15-16 års alderen","16-17 års alderen", 3,1);
    private Question question16 = new Question("Ved hvilken temperatur koger ethanol?", "76,18 grader C", "78,24 grader C", "82,40 grader C", "84,64 grader C", 2, 2);
    private Question question17 = new Question("Hvad betyder 'overgæret'?", "Langsom gæring ved lav temperatur", "Hurtig gæring ved lav temperatur", "Langsom gæring ved høj temperatur", "Hurtig gæring ved høj temperatur", 4, 3);
    private Question question18 = new Question("Hvilket bryghus er Danmarks ældste?","Kongens Bryghus", "Tuborg Bryghus", "Svaneke Bryghus", "Albani Bryggeri", 1,4);
    private Question question19 = new Question("Hvor meget rent alkohol er der i en genstand?", "1,3 centiliter", "1,5 centiliter", "1,8 centiliter", "2 centiliter", 2, 3);
    private Question question20 = new Question("Hvilken øl er den mest populære i Danmark?", "Ceres Top", "Carlsberg", "Tuborg", "Haboe", 3, 1);
    private Question question21 = new Question("Hvilken pilsner er Danmarks ældste?", "Grøn Tuborg", "Carlsberg Pilsner", "Ceres Top", "Royal Pilsner", 1, 2);
    private Question question22 = new Question("Hvor mange liter øl kan der være i en dansk øltønde?", "118,7 liter", "131,4 liter", "185,4 liter", "207,8 liter", 2, 2);
    private Question question23 = new Question("Hvor stærk er verdens stærkeste øl?", "40% alkohol", "50% alkohol","60% alkohol","70% alkohol", 4, 5);
    private Question question24 = new Question("Hvor gammel er den ældste kendte ølopskrift?", "2700 år gammel", "3900 år gammel", "4300 år gammel", "5400 år gammel", 2, 3);
    private Question question25 = new Question("Hvor meget øl blev der på verdensplan brygget i 2013?", "126 mia. liter", "165 mia. liter", "197 mia. liter", "213 mia. liter", 3, 4);
    private Question question26 = new Question("Hvor mange procent af den daglige anbefalede dosis vitamin B6 indeholder 1 liter øl?", "8%", "13%", "22%", "35%", 4, 4);
    private Question question27 = new Question("Hvor mange kalorier er der i en almindelig pilsner?", "98 kcal", "125 kcal", "186 kcal", "243 kcal", 2, 3);
    private Question question28 = new Question("Hvilken øl er verdens mest populære?", "Snow", "Budweiser", "Heineken", "Bud-light", 1,4);
    private Question question29 = new Question("Hvornår blev verdens ældste stadigt fungerende bryggeri grundlagt?", "År 1236", "År 1127", "År 1040", "År 978", 3, 4);
    private Question question30 = new Question("Det såkaldte IBU skala (International Bitterness Unit) måler mængden af bitre kemiske forbindelser i øl. Hvad scorer verdens bitreste øl på IBU skalaen?", "1000", "1500", "2000", "2500", 4, 5);
    private Question question31 = new Question("Hvornår lancerede Carlsberg deres første pilsner?", "År 1856", "År 1877", "År 1889", "År 1897", 4, 3);
    private Question question32 = new Question("Hvilket år blev Carlsberg og Tuborg slået sammen?", "År 1958", "År 1964", "År 1970", "År 1977", 3, 2);
    private Question question33 = new Question("Fra hvilket land stammer pilsneren?", "Tyskland", "Danmark", "Tjekkiet", "Ungarn", 3, 2);
    private Question question34 = new Question( "Hvor i Danmark ligger Refsvindinge bryggeriet?", "Bornholm", "Lolland", "Sjælland", "Fyn", 4, 3);
    private Question question35 = new Question("Hvilken øl har sloganet 'Værtens bedste øl'?", "Grøn Tuborg", "Carlsberg Pilsner", "Haboe Pilsner", "Ceres Top", 4, 2);
    private Question question36 = new Question( "Hvornår stammer de ældste tegn på ølbrygning fra?", "6000 fvt.", "7000 fvt.", "8000 fvt.", "9000 fvt.", 3, 3);
    private Question question37 = new Question("Hvad betyder det at en vin er 'Blanc de Blancs'?", "Kun produceret med lokale druer", "Produceret med 100% hvide druer","Produceret med 100% blå druer", "Er en blanding af hvide og blå druer", 2, 4);
    private Question question38 = new Question("Hvor mange flasker Champagne bliver der produceret om året?", "50 mio. flasker", "100 mio. flasker","200 mio. flasker","300 mio. flasker", 4, 3);
    private Question question39 = new Question("Hvor mange liter kan der være i verdens største ølglas?", "998 liter",  "1267 liter","1499 liter", "1654 liter", 3, 3);
    private Question question40 = new Question( "Krunoslav Budiselic er indehaver af verdensrekorden i at åbne 2000 flasker på tid. Hvor lang tid tog det ham?", "15 min & 34 sek", "18 min & 38 sek", "22 min & 59 sek", "28 min & 11 sek", 4, 4);
    private Question question41 = new Question("Rusland og vodka hænger i dag utvetydigt sammen, men vodka stammer ikke fra Rusland. Fra hvilket land stammer vodka fra?", "Polen", "Bulgarien", "Mongoliet", "Tyrkiet", 1, 2);
    private Question question42 = new Question("Efter Chernobyl katastrofen anbefalede Sovjet at oprydningsarbejdere skulle drikke vodka, da man mente at vodka hjalp mod strålingen der blev ophobet i kroppen. Hvor meget vodka skulle arbejderne drikke hver 2. time ifølge Sovjetiske anbefalinger?", "20 ml", "40 ml", "75 ml", "125 ml", 4, 4);
    private Question question43 = new Question("Pepsi er engang blevet betalt i spiritus for at sælge sine produkter i et land der ikke kunne betale med penge. Hvilken spiritus blev de betalt i?", "Rom","Vodka", "Tequila", "Snaps", 2, 2);
    private Question question44 = new Question("Billionare Vodka er verdens dyreste vodka. Med købet følger også en 24 timers service af en concierge, der serverer for gæsterne. Hvor meget koster Billionare Vodka?", "2,2 mio dollars", "3,7 mio dollars", "4,8 mio dollars", "8,5 mio dollars", 2, 3);
    private Question question45 = new Question("Guns N’ Roses’ bassist Duff McKagan havde i sine yngre dage et stort alkoholforbrug, der sendte ham på hospitalet som 30 årig. Hvor meget vodka om dagen skulle han efter sigende have drukket når det var værst?", "0,75 liter", "1 liter", "2 liter", "4 liter", 4, 2);
    private Question question46 = new Question("Imperial stout er den mørkeste øltype der gives. Hvad måler en imperial stout på EBC (European Brewery Convention), der giver en talværdi for hvor mørk øllet er?", "56", "62", "75", "79", 4, 3);
    private Question question47 = new Question("Saccharomyces cerevisiae er en type gær der er blevet brugt til brygning af øl og vin siden oldtiden. Hvor menes det at gæren stammer fra?", "Fra luften, hvor den landede i bryggekaret","Skrællen af vindruer", "Fra humleplanten", "Fundet i fugtigt mel", 2, 2);
    private Question question48 = new Question("En amerikansk stat har udråbt gærtypen Saccharomyces cerevisiae som statens officielle mikroorganisme, pga. gærets betydning for statens bryggerier. Hvilken stat er der tale om?", "Oregon","Wisconsin","Wyoming","North Dakota", 1, 5);
    private Question question49 = new Question("Forskelllige stammer af gærceller benyttes til forskellige typer af øl. Hvilken type øl brygges med gærtypen Saccharomyces pastorianus?", "Saison","Lager", "Brown ale", "Stout", 2, 4);
    private Question question50 = new Question("En stout er i dag betegnelsen for en meget mørk øl, men den oprindelige betydning var en stærk øl. Hvornår blev ordet Strout første gang brugt om øl?", "1677", "1689", "1720","1734", 1, 4);
    private Question question51 = new Question("Ninkasi er den ældste kendte gud for ølbryggernes beskyttelse og alkohol. Fra hvilken religion stammer Ninkasi fra?", "Oldtidens Egypten", "Oldtidens Mesapotaminen",	"Oldtidens Grækenland","Oldtidens Kina", 2, 1);
    private Question question52 = new Question("Ved hvilken alhoholpromille bliver hjernens evne til at skabe nye minder blokeret?", "1-2 ‰",	"2-3 ‰",	"4-5 ‰",	"6-7 ‰", 2, 1);
    private Question question53 = new Question("Hvornår blev Carlsberg grundlagt?", "år 1798","år 1847","år 1870","år 1872", 2, 1);
    private Question question54 = new Question("Hvornår blev Carlsberg udnævnt til kongelig Hofleverandør?", "år 1897",	"år 1904","år 1933","år 1970", 2, 2);
    private Question question55 = new Question("Hvem tegnede Carlsbergs berømte logo?", "Thorvald Bindesbøll","Andreas Clemmensen","August Jerndorff","Joakim Skovgaard", 1, 5);
    private Question question56 = new Question("Rendyrkningsmetoden af gær blev opfundet i 1883 af et dansk bryghus. Hvilket?", "Carlsberg",	"Tuborg",	"Haboe",	"Albani", 1, 1);
    private Question question57 = new Question("Hvilken i dag meget udbredt skala blev i 1909 udviklet på Carlsberg Laboratorium til at forbedre og ensarte produktionen af øl?", "Standard Reference Method skalaen","European Brewing Convention skalaen","PH-skalaen","International Bitterness Unit skalaen", 3, 4);
    private Question question58 = new Question("Hvad kaldes første fase af brygprocessen, hvor malt blandes med vand?", "Maltning","Mæskning", "Støbning","Urtkogning", 2, 2);
    private Question question59 = new Question("Det ældste bevis på øl i Danmark  findes i Egtvedfundet. Hvornår er dette fund fra?" , "500 fvt.",	"750 fvt.",	"1370 fvt.",	"2120 fvt.", 3, 3);
    private Question question60 = new Question("Et gammelt europæisk bryghus har omdannet de gamle ølkar til pools fyldt med øl, så gæster kan nyde en dukkert i den gyldne drik, der samtidigt skulle være godt for huden. I hvilket land ligger dette bryghus?", "Spanien","Holland","Tjekkiet","Østrig", 4, 4);
    private Question question61 = new Question("Den første dåseøl blev produceret i New Jersey. Hvilket bryghus stod bag produktionen?", "Renault Winery","Gottfried Krueger Brewery","Atco Brewing Company","Bolero Snort Brewery", 2, 5);
    private Question question62 = new Question("Carlsberg Laboratoriums forskning inden for gær og enzymer har haft stor betydning for andet end øl, men hvad?", "Konservering","Pasteurisering","Vaskepulver","Plastik", 3, 2);
    private Question question63 = new Question("Forskning inden for øl har ført til bedre behandlig af sygdomme. Hvilken sygdoms behandlig er blevet forbedret på grund af forskning omkring øl?","Gigt","Diabetes","Kræft","Knogleskørhed", 2, 1);
    private Question question64 = new Question("Hvilken kemiker udformede i 1909 PH-skalaen, der i dag er central inden for syre-base kemi?","Sophus Mads Jørgensen","Alfred Werner","Gilbert N. Lewis","Søren Peter Lauritz Sørensen", 4, 4);
    private Question question65 = new Question("Sloganet 'Probably the best beer in the world' blev lanceret i 1973. Hvilket ølmærke har dette slogan?","Carlsberg","Tuborg","Heineken","Grimbergen", 1, 1);
    private Question question66 = new Question("Elefantporten er inspireret af den obeliskbærende elefant fra Piazza della Minerva i Rom, og har også lagt navn til elefantøllet. Hvornår er elefantøllet fra?","1955","1966","1977","1988", 1,3);
*/




    public Game(Context context) {
        this.context = context;
        // db = new MyDB(context);

    }

/*
    public void setQuestions() {
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);
        questions.add(question11);
        questions.add(question12);
        questions.add(question13);
        questions.add(question14);
        questions.add(question15);
        questions.add(question16);
        questions.add(question17);
        questions.add(question18);
        questions.add(question19);
        questions.add(question20);
        questions.add(question21);
        questions.add(question22);
        questions.add(question23);
        questions.add(question24);
        questions.add(question25);
        questions.add(question26);
        questions.add(question27);
        questions.add(question28);
        questions.add(question29);
        questions.add(question30);
        questions.add(question31);
        questions.add(question32);
        questions.add(question33);
        questions.add(question34);
        questions.add(question35);
        questions.add(question36);
        questions.add(question37);
        questions.add(question38);
        questions.add(question39);
        questions.add(question40);
        questions.add(question41);
        questions.add(question42);
        questions.add(question43);
        questions.add(question44);
        questions.add(question45);
        questions.add(question46);
        questions.add(question47);
        questions.add(question48);
        questions.add(question49);
        questions.add(question50);
        questions.add(question51);
        questions.add(question52);
        questions.add(question53);
        questions.add(question54);
        questions.add(question55);
        questions.add(question56);
        questions.add(question57);
        questions.add(question58);
        questions.add(question59);
        questions.add(question60);
        questions.add(question61);
        questions.add(question62);
        questions.add(question63);
        questions.add(question64);
        questions.add(question65);
        questions.add(question66);






    }
*/

/*


    public ArrayList<Question> getQuestions() {
        return questions;
    }

 */

    /**
     * Returns the current question stored in the object
     * @return      Question    The current question
     */
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Returns the first of the four possible answers
     * @return      String      The string containing the first answer
     */
    public String getAnswerOne() {
        return answerOne;
    }

    /**
     * Returns the second of the four possible answers
     * @return      String      The string containing the second answer
     */
    public String getAnswerTwo() {
        return answerTwo;
    }

    /**
     * Returns the third of the four possible answers
     * @return      String      The string containing the third answer
     */
    public String getAnswerThree() {
        return answerThree;
    }

    /**
     * Returns the fourth of the four possible answers
     * @return      String      The string containing the fourth answer
     */
    public String getAnswerFour() {
        return answerFour;
    }

    /**
     * Returns the difficulty tier of the current question
     * Can be between [1 and 5], 1 being easiest, and 5 being hardest
     * @return      int         The difficulty tier
     */
    public int getCurrentTier() {return currentQuestion.getTier(); }


/*
    public void nextQuestion () {
        currentQuestion = getNewQuestion(getCurrentTier() + 1);
        answerOne = currentQuestion.getAnswerOne();
        answerTwo = currentQuestion.getAnswerTwo();
        answerThree = currentQuestion.getAnswerThree();
        answerFour = currentQuestion.getAnswerFour();
        question = currentQuestion.getQuestion();
        progress = currentQuestion.getTier();
        correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
    }

 */
/*
    public void restartQuiz () {
        currentQuestion = getNewQuestion(1);
        answerOne = currentQuestion.getAnswerOne();
        answerTwo = currentQuestion.getAnswerTwo();
        answerThree = currentQuestion.getAnswerThree();
        answerFour = currentQuestion.getAnswerFour();
        question = currentQuestion.getQuestion();
        progress = currentQuestion.getTier();
        correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
    }

 */
/*
    public Question getNewQuestion(int questionTier) {

        Random random = new Random();
        Question newQuestion;
        ArrayList<Question> availableQuestions = new ArrayList<>();
        for(Question q : questions) {
            if (q.getTier() == questionTier) {
                availableQuestions.add(q);
            }
        }
        newQuestion = availableQuestions.get(new Random().nextInt(availableQuestions.size()));
        return newQuestion;
        // return db.getOneQuestionOfDifficulty(questionTier);
    }

 */
/*
    public void setNewQuestion(int tier) {
        currentQuestion = getNewQuestion(tier);
        answerOne = currentQuestion.getAnswerOne();
        answerTwo = currentQuestion.getAnswerTwo();
        answerThree = currentQuestion.getAnswerThree();
        answerFour = currentQuestion.getAnswerFour();
        question = currentQuestion.getQuestion();
        progress = currentQuestion.getTier();
        correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
    }

 */

    /**
     * Sets the question and relevant field variables to the question specified
     *
     * @param questionObject    Question    The question to replace the existing.
     */
    public void setQuestion(Question questionObject) {
        currentQuestion = questionObject;
        answerOne = currentQuestion.getAnswerOne();
        answerTwo = currentQuestion.getAnswerTwo();
        answerThree = currentQuestion.getAnswerThree();
        answerFour = currentQuestion.getAnswerFour();
        question = currentQuestion.getQuestion();
        progress = currentQuestion.getTier();
        correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
    }
}
