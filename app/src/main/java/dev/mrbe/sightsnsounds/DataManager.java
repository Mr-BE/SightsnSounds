package dev.mrbe.sightsnsounds;

import java.util.ArrayList;
import java.util.List;


public class DataManager {
    //Data manager instance
    private static DataManager ourInstance = null;

    //Set up array list
    private List<Location> mLocations = new ArrayList<>();

    private List<Category> mCategories = new ArrayList<>();


    //Constructor
    public DataManager() {
    }

    /*Data Manager Instance*/
    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeArtLocations();
            ourInstance.initializeCategories();
        }
        return ourInstance;
    }

    /*Set up categories*/
    private void initializeCategories() {
        mCategories.add(initializeCat1());
        mCategories.add(initializeCat2());
        mCategories.add(initializeCat3());
        mCategories.add(initializeCat4());
        mCategories.add(initializeCat5());
    }

    private Category initializeCat1() {
        List<Location> nature = new ArrayList<>();
        nature.add(new Location("Agbokim Falls", "Ikom", R.drawable.agbokim_falls,
                "Nicknamed, \"The smoke that thunders\", this gem of nature is situated about 17 kilometers\n" +
                        "        from Ikom and 315 kilometers from Calabar in the Etung local Council area of Cross River State is Agbokim Waterfalls,\n" +
                        "        which is made up of seven streams.\n" +
                        "        Surrounded by steep hills and valleys, which are encircled in a rainbow-like atmosphere;\n" +
                        "        Agbokim fall remains one of the best destinations in Cross River State and Nigeria.\n" +
                        "        The closeness of the Waterfalls to a neighbouring Cameron provides revelers an ample\n" +
                        "        opportunity of having cross-border experience.\n" +
                        "        The waterfall is made up of seven streams, which chutes over steep cliff, providing\n" +
                        "        a seven faced falls. It sits on the cross river and descends in terraces,\n" +
                        "        through the tropical rainforest; which itself, is picturesque, as it always looks lush and green."));

        nature.add(new Location("Afi Mountain Wildlife Sanctuary", "Akamkpa", R.drawable.afi_drill,
                "Formerly part of the Afi River Forest Reserve, the Afi Mountain Wildlife Sanctuary was\n" +
                        "        established in 2000 to provide improved protection to important populations of several\n" +
                        "        endangered species including the critically endangered Cross River gorilla,\n" +
                        "        the Nigeria-Cameroon chimpanzee, the drill and the grey-necked Picathartes or rockfowl.\n" +
                        "        Afi is covered by roughly 100km² of lowland and sub-montane forest with rocky peaks\n" +
                        "        rising to altitudes of 1,300m.\n" +
                        "        On the western flank of the mountain is a large\n" +
                        "        grassland roost of migratory European barn swallows, estimated to contain up to 20 million\n" +
                        "        birds at times and reputed to be the largest wintering roost site of swallows in Africa.\n" +
                        "        The Afi Mountain has been identified as an IBA\n" +
                        "        (Important Bird Area) for Nigeria. It is also a significant and widely recognized spot\n" +
                        "        in Africa to watch the migration of large swallows. This indeed is a location for those\n" +
                        "        seeking to experience a whole new world."));
        nature.add(new Location("Obudu Mountain Resort", "Obudu", R.drawable.obudu,
                " Aloft in the clouds, the Obudu Mountain Resort (formerly known as the Obudu Cattle Ranch)\n" +
                        "        is a ranch and resort on the Obudu Plateau in Cross River State, Nigeria.\n" +
                        "        It was developed in 1951 by M. McCaughley,\n" +
                        "        a Scot who first explored the mountain ranges in 1949.\n" +
                        "        Today, the Obudu Montain Resort is one of the most visited location is Nigeria with its\n" +
                        "        awe-inspiring landscapes and breath-taking scenery"));
        nature.add(new Location("Kwa Falls", "Akamkpa", R.drawable.kwa_falls,
                "Kwa falls"));
        return new Category("Nature", nature);
    }

    private Category initializeCat2() {
        List<Location> history = new ArrayList<>();
        history.add(new Location("Old Residency", "Calabar", R.drawable.old_residency,
                "This was originally the residence of the highest ranked\n" +
                        "    British personnel in Calabar. It had been transformed to the residence of the military governors\n" +
                        "    during the military regime in Nigeria.\n" +
                        "        \nHowever, today, it serves a different purpose of a multifaceted museum.\n" +
                        "    "));
        history.add(new Location("Hope Waddell Training Institution", "Calabar", R.drawable.hopewaddell,
                "Established in 1895, this is one of the oldest institutions in the Nigeria.\n" +
                        "        Originally set up as a base for arriving Scottish missionaries, it quickly transformed\n" +
                        "        into an educational and skills acquisition center."));
        history.add(new Location("Slave History Museum", "Calabar", R.drawable.slavehistorymuseum1,
                "Located in the Marina Resort along the Calabar harbour,\n" +
                        "    the Slave History Museum shows explicitly, the travails of Nigeria slaves who were sold\n" +
                        "    through the Calabar sea port."));

        return new Category("Historical", history);
    }

    private Category initializeCat3() {
        List<Location> art = new ArrayList<>();
        art.add(new Location("Ikom Monoliths", "Ikom", R.drawable.monolith,
                "This was originally the residence of the highest ranked\n" +
                        "    British personnel in Calabar. It had been transformed to the residence of the military governors\n" +
                        "    during the military regime in Nigeria.\n" +
                        "        \nHowever, today, it serves a different purpose of a multifaceted museum.\n" +
                        "    ", "Art"));
        art.add(new Location("Art2", "artL2", R.drawable.ic_menu_send, "Art2 \nEstablished in 1895, this is one of the oldest institutions in the Nigeria.\\n\n" +
                "        Originally set up as a base for arriving Scottish missionaries, it quickly transformed\n" +
                "        into an educational and skills acquisition center.", "Historical"));
        art.add(new Location("Art3", "artL3", R.drawable.ic_menu_share, "Art3 \nLocated in the Marina Resort along the Calabar harbour,\n" +
                "    the Slave History Museum shows explicitly, the travails of Nigeria slaves who were sold\n" +
                "    through the Calabar sea port.", "Historical"));
        return new Category("Art", art);
    }

    private Category initializeCat4() {
        List<Location> festivals = new ArrayList<>();
        festivals.add(new Location("Leboku Festival", "Ugep", R.drawable.leboku,
                " Leboku is the annual New Yam Festival of the Yakurr people.\\n\n" +
                        "        The Leboku New Yam festival is peculiar to the core Yakạạ speaking communities of Idomi,\n" +
                        "        Ugep, Ekori, Mkpani and Nko and the international version is celebrated in Ugep once in a year.\n" +
                        "        This is celebrated to honor the earth goddess and the ancestral spirits of the land in Ugep,\n" +
                        "        one of the five settlements of Yakurr.\\n\n" +
                        "        The three-week festival is the culmination of many events: the beginning of the yam harvest,\n" +
                        "        a time to appease the gods and ancestors, a public parade of engaged maidens, a commemoration\n" +
                        "        of events that led to the migration from the Yakurr ancestral home to the present site,\n" +
                        "        and a period of holiday in the Yakurr traditional calendar (mid-August through mid-September).\n" +
                        "        The Yakurr calendar runs from August to July. During the Leboku, people keep away from intense\n" +
                        "        farming activities and exchange visits with their families. The Leboku is also meant to usher in peace,\n" +
                        "        good health and prosperity."));
        festivals.add(new Location("Calabar Carnival", "Calabar", R.drawable.calabar_festival,
                "The Calabar Carnival tagged \"Africa's Biggest Street Party\", is one of the highlights of the\n" +
                        "        Cross River State Christmas festival which begins every 1 December and lasts until 31 December.\n" +
                        "        The festival was created as part of the vision of making the Cross River State, Nigeria,\n" +
                        "        the number one tourist destination for Nigerians and tourists all over the world.\n" +
                        "        This event which usually holds between December 26th and 28th has boosted the cultural mosaic\n" +
                        "        of Nigeria people while entertaining millions of spectators\n" +
                        "        within and outside the State, and boosting industry for all stakeholders."));
        festivals.add(new Location("Ekpe Festival", "Calabar", R.drawable.ekpe_masquerade1,
                "Ekpe, also known as Ekpo (Ibibio: Leopard), is a secret society flourishing chiefly among\n" +
                        "        the Efiks of the Cross River State, the Oron, of Akwa Ibom State, Nigeria, Arochukwu\n" +
                        "         and some parts of Abia State, as well as in the diaspora, such as in Cuba and Brazil.\n" +
                        "        The society is still active at the beginning of the 21st century, however, now it plays only a ceremonial role.\n" +
                        "        There are two distinct but related societies, the primary one in the Cross River, Arochukwu,\n" +
                        "        Akwa Ibom areas, and the secondary one among the Southern and Eastern Igbo groups.\n" +
                        "        It is general belief amongst the Efik native tribe, although hardly ever substantiated,\n" +
                        "        that the members of the Ekpe society invented the Nsibidi.\n" +
                        "        The Ekpe festival is an annual event that usually holds on the last Saturday of the\n" +
                        "        year in Calabar. It attracts displays from the different Ekpe societies from around the world."));

        return new Category("Festivals", festivals);
    }

    private Category initializeCat5() {
        List<Location> leisure = new ArrayList<>();
        leisure.add(new Location("Tinapa Resort", "Calabar", R.drawable.tinapa,
                " Situated on the outskirts of Calabar, Tinapa is an integrated Business and Leisure\n" +
                        "        promising the best of both worlds.\n" +
                        "        The resort boasts of World class conference centres as well strings of shops and malls\n" +
                        "        for those with an eye for business.\\n\n" +
                        "        Also, it possesses a 2km beach front, a 5-star hotel, 4 Standard sized studios, an arcade park\n" +
                        "        as well as a water park; which has a 200ft slide, for those just looking to unwind.\n" +
                        "        The resort is also equipped with a light rail network to facilitate movement around its environs.\n" +
                        "        Indeed, Tinapa really takes on the Herculean task of balancing work and play in its stride.\n" +
                        "   "));
        leisure.add(new Location("Marina Resort", "Calabar", R.drawable.marina,
                "This is one of Calabar’s major tourist destinations.\n" +
                        "        It is a huge and expansive resort with amazing multi-purpose facilities as well as\n" +
                        "        unforgettable moments at place such as the Slave History Museum, a cinema house, table\n" +
                        "        tennis court, hotel, night club, a carousel for the children, walkway and open restaurants\n" +
                        "        where patrons can sit, relax and eat – with breathtaking views of the Calabar river.\n" +
                        "        The Tortuga island is a stunning sit-in or sit-out location within the resort\n" +
                        "        where you can grab a seat, recline and place an order while you take in the river view as\n" +
                        "        well as the alluring smell of the long rows of trimmed flower hedges.\n" +
                        "        Taking a boat cruise on the Calabar river is a fun activity to look forward.\n" +
                        "        The beautiful cruise boat takes you round the Marina waters.\n" +
                        "        At the other end of the river, you’ll see a small house which is built on the\n" +
                        "        site where Mary Slessor’s former house was situated."));
        leisure.add(new Location("Obudu Resort", "Obudu", R.drawable.obudu_huts,
                "Obudu hill and highlands"));

        return new Category("Leisure Resorts", leisure);
    }

    //Art attraction initialisation
    private void initializeArtLocations() {
    }

    //Get Locations
    public List<Location> getLocations() {
        return mLocations;
    }

    //Get Attraction Categories
    public List<Category> getCategories() {
        return mCategories;
    }
}


