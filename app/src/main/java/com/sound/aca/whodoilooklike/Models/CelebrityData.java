package com.sound.aca.whodoilooklike.Models;

import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CelebrityData {


    public static Celebrity[] populateData(){
        List<Celebrity> list = new ArrayList<>();
      String jsonString = "[\n" +
              "   {\n" +
              "      \"name\": \"rihanna\",\n" +
              "      \"noseRation\": 0.7924579929,\n" +
              "      \"ratio36\": 0.424032213,\n" +
              "      \"ratio46\": 0.4805943893,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"angelina_jolie\",\n" +
              "      \"noseRation\": 0.7626847442,\n" +
              "      \"ratio36\": 0.4178582126,\n" +
              "      \"ratio46\": 0.488818359,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"oprah_ winfrey\",\n" +
              "      \"noseRation\": 0.490268525,\n" +
              "      \"ratio36\": 0.3684044609,\n" +
              "      \"ratio46\": 0.4795917038,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"chrissy_teigen\",\n" +
              "      \"noseRation\": 0.3127728686,\n" +
              "      \"ratio36\": 0.3945962205,\n" +
              "      \"ratio46\": 0.4580875607,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"justin_timberlake\",\n" +
              "      \"noseRation\": 0.4598680515,\n" +
              "      \"ratio36\": 0.359131105,\n" +
              "      \"ratio46\": 0.406152494,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"selena_gomez\",\n" +
              "      \"noseRation\": 0.5350043683,\n" +
              "      \"ratio36\": 0.386936199,\n" +
              "      \"ratio46\": 0.4462454431,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"ariana_grande\",\n" +
              "      \"noseRation\": 0.5065198925,\n" +
              "      \"ratio36\": 0.4124608763,\n" +
              "      \"ratio46\": 0.4259269767,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"justin_bieber\",\n" +
              "      \"noseRation\": 0.742897956,\n" +
              "      \"ratio36\": 0.436635975,\n" +
              "      \"ratio46\": 0.447281148,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"demi_lovato\",\n" +
              "      \"noseRation\": 0.6019439907,\n" +
              "      \"ratio36\": 0.3509484246,\n" +
              "      \"ratio46\": 0.4487785097,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kanye_west\",\n" +
              "      \"noseRation\": 0.972452404,\n" +
              "      \"ratio36\": 0.421379004,\n" +
              "      \"ratio46\": 0.4348005731,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"beyonce\",\n" +
              "      \"noseRation\": 0.7148371625,\n" +
              "      \"ratio36\": 0.3663872726,\n" +
              "      \"ratio46\": 0.4607835164,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"katy_perry\",\n" +
              "      \"noseRation\": 0.5262995691,\n" +
              "      \"ratio36\": 0.4195736895,\n" +
              "      \"ratio46\": 0.4939510944,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"cardi_b\",\n" +
              "      \"noseRation\": 0.2540339329,\n" +
              "      \"ratio36\": 0.4197904256,\n" +
              "      \"ratio46\": 0.4055156229,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kylie\",\n" +
              "      \"noseRation\": 0.4720903314,\n" +
              "      \"ratio36\": 0.406628698,\n" +
              "      \"ratio46\": 0.46392992,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"rock\",\n" +
              "      \"noseRation\": 0.3614605209,\n" +
              "      \"ratio36\": 0.3868633317,\n" +
              "      \"ratio46\": 0.415768723,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"taylor_swift\",\n" +
              "      \"noseRation\": 0.2953727653,\n" +
              "      \"ratio36\": 0.4167669892,\n" +
              "      \"ratio46\": 0.4400352884,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kim\",\n" +
              "      \"noseRation\": 0.2483710239,\n" +
              "      \"ratio36\": 0.41361946,\n" +
              "      \"ratio46\": 0.470377701,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"lady_gaga\",\n" +
              "      \"noseRation\": 0.6887538756,\n" +
              "      \"ratio36\": 0.4105725222,\n" +
              "      \"ratio46\": 0.4346582416,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"ronaldo\",\n" +
              "      \"noseRation\": 0.7620045704,\n" +
              "      \"ratio36\": 0.3801408302,\n" +
              "      \"ratio46\": 0.4810411289,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"neymar\",\n" +
              "      \"noseRation\": 0.8413116661,\n" +
              "      \"ratio36\": 0.4047312341,\n" +
              "      \"ratio46\": 0.4137976511,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"messi\",\n" +
              "      \"noseRation\": 0.2780570003,\n" +
              "      \"ratio36\": 0.3514321129,\n" +
              "      \"ratio46\": 0.4015233937,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"zlatan_ibrahimovic\",\n" +
              "      \"noseRation\": 0.4097901516,\n" +
              "      \"ratio36\": 0.4137008952,\n" +
              "      \"ratio46\": 0.422240751,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"pogba\",\n" +
              "      \"noseRation\": 0.1741655894,\n" +
              "      \"ratio36\": 0.4431379778,\n" +
              "      \"ratio46\": 0.4944920165,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"lebron\",\n" +
              "      \"noseRation\": 0.2422143206,\n" +
              "      \"ratio36\": 0.3524766109,\n" +
              "      \"ratio46\": 0.4536997289,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jordan\",\n" +
              "      \"noseRation\": 0.2779127589,\n" +
              "      \"ratio36\": 0.4142690271,\n" +
              "      \"ratio46\": 0.4343532506,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kobe\",\n" +
              "      \"noseRation\": 1.015654913,\n" +
              "      \"ratio36\": 0.3755944853,\n" +
              "      \"ratio46\": 0.4402927304,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"curry\",\n" +
              "      \"noseRation\": 0.1582025187,\n" +
              "      \"ratio36\": 0.3700842078,\n" +
              "      \"ratio46\": 0.4303084402,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"durant\",\n" +
              "      \"noseRation\": 0.9299525347,\n" +
              "      \"ratio36\": 0.394036228,\n" +
              "      \"ratio46\": 0.4705484812,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"drake\",\n" +
              "      \"noseRation\": 0.6541912041,\n" +
              "      \"ratio36\": 0.4050600065,\n" +
              "      \"ratio46\": 0.4742330008,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"obama\",\n" +
              "      \"noseRation\": 0.5713733834,\n" +
              "      \"ratio36\": 0.4138375732,\n" +
              "      \"ratio46\": 0.4381689625,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"trupm\",\n" +
              "      \"noseRation\": 0.3545175926,\n" +
              "      \"ratio36\": 0.4065965886,\n" +
              "      \"ratio46\": 0.4360893449,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"johny_depp\",\n" +
              "      \"noseRation\": 0.782917489,\n" +
              "      \"ratio36\": 0.3982837785,\n" +
              "      \"ratio46\": 0.395319349,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"david_beckham\",\n" +
              "      \"noseRation\": 0.7352958425,\n" +
              "      \"ratio36\": 0.3932544538,\n" +
              "      \"ratio46\": 0.4475968637,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jenifer_lopez\",\n" +
              "      \"noseRation\": 0.5282345102,\n" +
              "      \"ratio36\": 0.4267743924,\n" +
              "      \"ratio46\": 0.4820573386,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"brad_pitt\",\n" +
              "      \"noseRation\": 0.8647114692,\n" +
              "      \"ratio36\": 0.4192423403,\n" +
              "      \"ratio46\": 0.4279506998,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kevin_hart\",\n" +
              "      \"noseRation\": 0.2760133231,\n" +
              "      \"ratio36\": 0.4189130717,\n" +
              "      \"ratio46\": 0.4676045056,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"eminem\",\n" +
              "      \"noseRation\": 0.2355923325,\n" +
              "      \"ratio36\": 0.4203966762,\n" +
              "      \"ratio46\": 0.4474151231,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"vin_disel\",\n" +
              "      \"noseRation\": 0.6868007195,\n" +
              "      \"ratio36\": 0.4218085145,\n" +
              "      \"ratio46\": 0.4376794055,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"marilyn_monroe\",\n" +
              "      \"noseRation\": 0.4073393914,\n" +
              "      \"ratio36\": 0.3342300084,\n" +
              "      \"ratio46\": 0.438766986,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"lincoln\",\n" +
              "      \"noseRation\": 0.4675050727,\n" +
              "      \"ratio36\": 0.3848004394,\n" +
              "      \"ratio46\": 0.4044728097,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kennedy\",\n" +
              "      \"noseRation\": 1.072485645,\n" +
              "      \"ratio36\": 0.3904414756,\n" +
              "      \"ratio46\": 0.4151206857,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"luther_king\",\n" +
              "      \"noseRation\": 0.9117483056,\n" +
              "      \"ratio36\": 0.4121417692,\n" +
              "      \"ratio46\": 0.482826447,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"nelson_mandela\",\n" +
              "      \"noseRation\": 0.8751446458,\n" +
              "      \"ratio36\": 0.3984166515,\n" +
              "      \"ratio46\": 0.4849939218,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"queen_elizabeth\",\n" +
              "      \"noseRation\": 0.2751492143,\n" +
              "      \"ratio36\": 0.408863268,\n" +
              "      \"ratio46\": 0.4219283549,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"bill_gates\",\n" +
              "      \"noseRation\": 0.9501172848,\n" +
              "      \"ratio36\": 0.3807096698,\n" +
              "      \"ratio46\": 0.4323293343,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"columbus\",\n" +
              "      \"noseRation\": 0.2072445668,\n" +
              "      \"ratio36\": 0.41689621,\n" +
              "      \"ratio46\": 0.4637195787,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"elvis_presley\",\n" +
              "      \"noseRation\": 0.6284315366,\n" +
              "      \"ratio36\": 0.4234696459,\n" +
              "      \"ratio46\": 0.4943733271,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"albert_einstein\",\n" +
              "      \"noseRation\": 0.680004614,\n" +
              "      \"ratio36\": 0.3826673844,\n" +
              "      \"ratio46\": 0.4631374509,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"mozzart\",\n" +
              "      \"noseRation\": 0.5836228937,\n" +
              "      \"ratio36\": 0.3738507428,\n" +
              "      \"ratio46\": 0.386768853,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"beethoven\",\n" +
              "      \"noseRation\": 0.4509994955,\n" +
              "      \"ratio36\": 0.4329982357,\n" +
              "      \"ratio46\": 0.4333591955,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"walt_disney\",\n" +
              "      \"noseRation\": 0.4190506643,\n" +
              "      \"ratio36\": 0.381351065,\n" +
              "      \"ratio46\": 0.4329224318,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"george_bush\",\n" +
              "      \"noseRation\": 0.5200324767,\n" +
              "      \"ratio36\": 0.4302629152,\n" +
              "      \"ratio46\": 0.3793292321,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"michael_jackson\",\n" +
              "      \"noseRation\": 0.7711755851,\n" +
              "      \"ratio36\": 0.3586398295,\n" +
              "      \"ratio46\": 0.495404708,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"madonna\",\n" +
              "      \"noseRation\": 0.2870940853,\n" +
              "      \"ratio36\": 0.3766011737,\n" +
              "      \"ratio46\": 0.4589347751,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"steve_jobs\",\n" +
              "      \"noseRation\": 0.2435689462,\n" +
              "      \"ratio36\": 0.4193852537,\n" +
              "      \"ratio46\": 0.4496745707,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"roger_federer\",\n" +
              "      \"noseRation\": 0.6912914054,\n" +
              "      \"ratio36\": 0.4059857131,\n" +
              "      \"ratio46\": 0.4228765182,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"novak\",\n" +
              "      \"noseRation\": 0.4519741894,\n" +
              "      \"ratio36\": 0.3804688178,\n" +
              "      \"ratio46\": 0.3931045909,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"bolt\",\n" +
              "      \"noseRation\": 0.8285189465,\n" +
              "      \"ratio36\": 0.4107780012,\n" +
              "      \"ratio46\": 0.4658057262,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"stephen_hawking\",\n" +
              "      \"noseRation\": 0.8468057925,\n" +
              "      \"ratio36\": 0.4230765603,\n" +
              "      \"ratio46\": 0.4214447081,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"shakira\",\n" +
              "      \"noseRation\": 0.8292646794,\n" +
              "      \"ratio36\": 0.3975220482,\n" +
              "      \"ratio46\": 0.4653839409,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"tom_cruise\",\n" +
              "      \"noseRation\": 0.8058721089,\n" +
              "      \"ratio36\": 0.3768299619,\n" +
              "      \"ratio46\": 0.4407788511,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"ellen\",\n" +
              "      \"noseRation\": 0.6396981487,\n" +
              "      \"ratio36\": 0.3851847412,\n" +
              "      \"ratio46\": 0.4617906477,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"tyra_banks\",\n" +
              "      \"noseRation\": 0.6067519433,\n" +
              "      \"ratio36\": 0.3992474325,\n" +
              "      \"ratio46\": 0.4918998403,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"mel_b\",\n" +
              "      \"noseRation\": 0.2781731874,\n" +
              "      \"ratio36\": 0.4116816435,\n" +
              "      \"ratio46\": 0.4450986542,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"sofia_vergara\",\n" +
              "      \"noseRation\": 0.2578617889,\n" +
              "      \"ratio36\": 0.3809915253,\n" +
              "      \"ratio46\": 0.4446270052,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jennifer_aniston\",\n" +
              "      \"noseRation\": 0.3576634606,\n" +
              "      \"ratio36\": 0.3669424781,\n" +
              "      \"ratio46\": 0.4151850113,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"emma_stone\",\n" +
              "      \"noseRation\": 0.7792633448,\n" +
              "      \"ratio36\": 0.3614388258,\n" +
              "      \"ratio46\": 0.4451724832,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"scarlett_johansson\",\n" +
              "      \"noseRation\": 0.8803007133,\n" +
              "      \"ratio36\": 0.379026088,\n" +
              "      \"ratio46\": 0.4650569124,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"emma_watson\",\n" +
              "      \"noseRation\": 0.807544599,\n" +
              "      \"ratio36\": 0.3839006174,\n" +
              "      \"ratio46\": 0.4431922694,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"chirs_brown\",\n" +
              "      \"noseRation\": 0.3755486203,\n" +
              "      \"ratio36\": 0.3960898203,\n" +
              "      \"ratio46\": 0.406148123,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"will_smith\",\n" +
              "      \"noseRation\": 0.3185068818,\n" +
              "      \"ratio36\": 0.3729440815,\n" +
              "      \"ratio46\": 0.4596018757,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"leonardo_dicaprio\",\n" +
              "      \"noseRation\": 0.8931792762,\n" +
              "      \"ratio36\": 0.3459044043,\n" +
              "      \"ratio46\": 0.4301343256,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"alyson_hannigan\",\n" +
              "      \"noseRation\": 0.4602608566,\n" +
              "      \"ratio36\": 0.3808829442,\n" +
              "      \"ratio46\": 0.4454333019,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"morgan_freeman\",\n" +
              "      \"noseRation\": 0.6768199586,\n" +
              "      \"ratio36\": 0.4385642963,\n" +
              "      \"ratio46\": 0.4538177235,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"robert_de_niro\",\n" +
              "      \"noseRation\": 0.7859690784,\n" +
              "      \"ratio36\": 0.3899261758,\n" +
              "      \"ratio46\": 0.4343731924,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"matt_damon\",\n" +
              "      \"noseRation\": 0.793720693,\n" +
              "      \"ratio36\": 0.386138802,\n" +
              "      \"ratio46\": 0.4461509077,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"samuel_l_jackson\",\n" +
              "      \"noseRation\": 1.170502922,\n" +
              "      \"ratio36\": 0.3666097321,\n" +
              "      \"ratio46\": 0.4806831829,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"george_clooney\",\n" +
              "      \"noseRation\": 0.8922946425,\n" +
              "      \"ratio36\": 0.4035228645,\n" +
              "      \"ratio46\": 0.4590776165,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"liam_leeson\",\n" +
              "      \"noseRation\": 0.7237289259,\n" +
              "      \"ratio36\": 0.3808285276,\n" +
              "      \"ratio46\": 0.4240183686,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"denzel_washington\",\n" +
              "      \"noseRation\": 0.8936585936,\n" +
              "      \"ratio36\": 0.402110991,\n" +
              "      \"ratio46\": 0.4772506815,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"tiger_woods\",\n" +
              "      \"noseRation\": 0.2607835748,\n" +
              "      \"ratio36\": 0.4103391626,\n" +
              "      \"ratio46\": 0.4466782281,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"serena_williams\",\n" +
              "      \"noseRation\": 0.3268886217,\n" +
              "      \"ratio36\": 0.4582575985,\n" +
              "      \"ratio46\": 0.4687210772,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"nadal\",\n" +
              "      \"noseRation\": 0.5711440259,\n" +
              "      \"ratio36\": 0.4325394824,\n" +
              "      \"ratio46\": 0.4684635332,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"mc_gregor\",\n" +
              "      \"noseRation\": 0.8922946425,\n" +
              "      \"ratio36\": 0.4035228645,\n" +
              "      \"ratio46\": 0.4590776165,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"curtis_jackson\",\n" +
              "      \"noseRation\": 0.5380465499,\n" +
              "      \"ratio36\": 0.4108570544,\n" +
              "      \"ratio46\": 0.4453157701,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"khaled\",\n" +
              "      \"noseRation\": 0.4356940062,\n" +
              "      \"ratio36\": 0.4117187676,\n" +
              "      \"ratio46\": 0.4357910412,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"arnold\",\n" +
              "      \"noseRation\": 0.5993275616,\n" +
              "      \"ratio36\": 0.412333664,\n" +
              "      \"ratio46\": 0.4352755359,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"matt_damon\",\n" +
              "      \"noseRation\": 0.793720693,\n" +
              "      \"ratio36\": 0.386138802,\n" +
              "      \"ratio46\": 0.4461509077,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"ashton_kutcher\",\n" +
              "      \"noseRation\": 0.7965591168,\n" +
              "      \"ratio36\": 0.3798370129,\n" +
              "      \"ratio46\": 0.4383212435,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"julia_roberts\",\n" +
              "      \"noseRation\": 0.6003998247,\n" +
              "      \"ratio36\": 0.3908607458,\n" +
              "      \"ratio46\": 0.4701869765,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"mel_gibson\",\n" +
              "      \"noseRation\": 0.8786063235,\n" +
              "      \"ratio36\": 0.375136037,\n" +
              "      \"ratio46\": 0.4450530337,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"keanu_reeves\",\n" +
              "      \"noseRation\": 0.3578161998,\n" +
              "      \"ratio36\": 0.4306973287,\n" +
              "      \"ratio46\": 0.4793990483,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jim_carrey\",\n" +
              "      \"noseRation\": 0.9555394359,\n" +
              "      \"ratio36\": 0.3770964627,\n" +
              "      \"ratio46\": 0.429144561,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"nicolas_cage\",\n" +
              "      \"noseRation\": 0.3042440273,\n" +
              "      \"ratio36\": 0.406090464,\n" +
              "      \"ratio46\": 0.43926563,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"charles_chaplin\",\n" +
              "      \"noseRation\": 0.5733980484,\n" +
              "      \"ratio36\": 0.4196456808,\n" +
              "      \"ratio46\": 0.4873971413,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"eddie_murphy\",\n" +
              "      \"noseRation\": 0.8137581248,\n" +
              "      \"ratio36\": 0.4315855341,\n" +
              "      \"ratio46\": 0.5073532963,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"antonio_banderas\",\n" +
              "      \"noseRation\": 0.7762042254,\n" +
              "      \"ratio36\": 0.4166658398,\n" +
              "      \"ratio46\": 0.4671937119,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"sandra_bullock\",\n" +
              "      \"noseRation\": 0.854310091,\n" +
              "      \"ratio36\": 0.4167536461,\n" +
              "      \"ratio46\": 0.4847787324,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"pirs_brosnan\",\n" +
              "      \"noseRation\": 0.4413455289,\n" +
              "      \"ratio36\": 0.4210766124,\n" +
              "      \"ratio46\": 0.4260047664,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"daniel_craig\",\n" +
              "      \"noseRation\": 0.840928467,\n" +
              "      \"ratio36\": 0.387868844,\n" +
              "      \"ratio46\": 0.4316462251,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"chris_pratt\",\n" +
              "      \"noseRation\": 0.2746401064,\n" +
              "      \"ratio36\": 0.3977319887,\n" +
              "      \"ratio46\": 0.4362549235,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"ryan_reynolds\",\n" +
              "      \"noseRation\": 0.7043794396,\n" +
              "      \"ratio36\": 0.4098890557,\n" +
              "      \"ratio46\": 0.4155106648,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"robert_downey_jr\",\n" +
              "      \"noseRation\": 0.6487020494,\n" +
              "      \"ratio36\": 0.4149778798,\n" +
              "      \"ratio46\": 0.4385946489,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"benedict_cumberbatch\",\n" +
              "      \"noseRation\": 0.3281014774,\n" +
              "      \"ratio36\": 0.4250787497,\n" +
              "      \"ratio46\": 0.465084241,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"gal_gadot\",\n" +
              "      \"noseRation\": 0.686383601,\n" +
              "      \"ratio36\": 0.4198547318,\n" +
              "      \"ratio46\": 0.4258119261,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"mila_kunis\",\n" +
              "      \"noseRation\": 0.7407961838,\n" +
              "      \"ratio36\": 0.3748721263,\n" +
              "      \"ratio46\": 0.4882479055,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jennifer_lawrence\",\n" +
              "      \"noseRation\": 0.657138305,\n" +
              "      \"ratio36\": 0.4016263549,\n" +
              "      \"ratio46\": 0.4377465963,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"natalie_portman\",\n" +
              "      \"noseRation\": 0.5750002238,\n" +
              "      \"ratio36\": 0.4163559628,\n" +
              "      \"ratio46\": 0.4761171275,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kate_upton\",\n" +
              "      \"noseRation\": 0.6619290851,\n" +
              "      \"ratio36\": 0.4091213175,\n" +
              "      \"ratio46\": 0.4894888484,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"cara_delevingne\",\n" +
              "      \"noseRation\": 0.6696848397,\n" +
              "      \"ratio36\": 0.4193587852,\n" +
              "      \"ratio46\": 0.4447891148,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"megan_fox\",\n" +
              "      \"noseRation\": 0.7690435402,\n" +
              "      \"ratio36\": 0.4149847818,\n" +
              "      \"ratio46\": 0.4593771267,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"amanda_seyfried\",\n" +
              "      \"noseRation\": 0.7630318534,\n" +
              "      \"ratio36\": 0.3566856666,\n" +
              "      \"ratio46\": 0.4782849785,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"olivia_wilde\",\n" +
              "      \"noseRation\": 0.8614956345,\n" +
              "      \"ratio36\": 0.3647414639,\n" +
              "      \"ratio46\": 0.4733465218,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"adriana_lima\",\n" +
              "      \"noseRation\": 0.6708309538,\n" +
              "      \"ratio36\": 0.4151287313,\n" +
              "      \"ratio46\": 0.4777012559,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"penelope_cruz\",\n" +
              "      \"noseRation\": 0.9638197457,\n" +
              "      \"ratio36\": 0.3674508181,\n" +
              "      \"ratio46\": 0.4572546406,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"leira_knightley\",\n" +
              "      \"noseRation\": 0.4259638071,\n" +
              "      \"ratio36\": 0.4034582937,\n" +
              "      \"ratio46\": 0.457980154,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"candice_swanepoel\",\n" +
              "      \"noseRation\": 0.591394627,\n" +
              "      \"ratio36\": 0.4301249156,\n" +
              "      \"ratio46\": 0.4987970306,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"minka_kelly\",\n" +
              "      \"noseRation\": 0.6785377438,\n" +
              "      \"ratio36\": 0.3370048792,\n" +
              "      \"ratio46\": 0.4527916151,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"dua_lipa\",\n" +
              "      \"noseRation\": 0.7119399258,\n" +
              "      \"ratio36\": 0.4179376037,\n" +
              "      \"ratio46\": 0.465844985,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kendall_jenner\",\n" +
              "      \"noseRation\": 0.7245209696,\n" +
              "      \"ratio36\": 0.394828476,\n" +
              "      \"ratio46\": 0.4585377685,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"eva_mendes\",\n" +
              "      \"noseRation\": 0.590771034,\n" +
              "      \"ratio36\": 0.3877619684,\n" +
              "      \"ratio46\": 0.4675654715,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"monica_bellucci\",\n" +
              "      \"noseRation\": 0.7186213075,\n" +
              "      \"ratio36\": 0.4165823122,\n" +
              "      \"ratio46\": 0.4640006852,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kaley_cuoco\",\n" +
              "      \"noseRation\": 0.8537785202,\n" +
              "      \"ratio36\": 0.3910153119,\n" +
              "      \"ratio46\": 0.4579302161,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"halle_berry\",\n" +
              "      \"noseRation\": 0.6736199647,\n" +
              "      \"ratio36\": 0.4005830632,\n" +
              "      \"ratio46\": 0.4590815261,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"eva_longoria\",\n" +
              "      \"noseRation\": 0.6604850188,\n" +
              "      \"ratio36\": 0.363935582,\n" +
              "      \"ratio46\": 0.4796780573,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"ashley_benson\",\n" +
              "      \"noseRation\": 0.7711205263,\n" +
              "      \"ratio36\": 0.3928086701,\n" +
              "      \"ratio46\": 0.4729379793,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"lucy_hale\",\n" +
              "      \"noseRation\": 0.7926664655,\n" +
              "      \"ratio36\": 0.3824438476,\n" +
              "      \"ratio46\": 0.4525970926,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"kristen_bell\",\n" +
              "      \"noseRation\": 0.8071702118,\n" +
              "      \"ratio36\": 0.3594316794,\n" +
              "      \"ratio46\": 0.4310199364,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"heidi_klum\",\n" +
              "      \"noseRation\": 0.5262206252,\n" +
              "      \"ratio36\": 0.3820436284,\n" +
              "      \"ratio46\": 0.4469940974,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"anna_sophia_robb\",\n" +
              "      \"noseRation\": 0.3030825487,\n" +
              "      \"ratio36\": 0.3784349173,\n" +
              "      \"ratio46\": 0.4399987765,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"peyton_list\",\n" +
              "      \"noseRation\": 0.7665486976,\n" +
              "      \"ratio36\": 0.3598017246,\n" +
              "      \"ratio46\": 0.4474090718,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"olivia_holt\",\n" +
              "      \"noseRation\": 0.4427640683,\n" +
              "      \"ratio36\": 0.3927881366,\n" +
              "      \"ratio46\": 0.4627508297,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"aishwarya_rai_bachchan\",\n" +
              "      \"noseRation\": 0.3386640146,\n" +
              "      \"ratio36\": 0.3919362837,\n" +
              "      \"ratio46\": 0.48978202,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"madison_beer\",\n" +
              "      \"noseRation\": 0.246719761,\n" +
              "      \"ratio36\": 0.4135118248,\n" +
              "      \"ratio46\": 0.4684758877,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"nicki_minaj\",\n" +
              "      \"noseRation\": 0.2757112048,\n" +
              "      \"ratio36\": 0.4087723696,\n" +
              "      \"ratio46\": 0.4531779272,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jessica_chastain\",\n" +
              "      \"noseRation\": 0.7507502668,\n" +
              "      \"ratio36\": 0.4031587626,\n" +
              "      \"ratio46\": 0.4626010614,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"iggy_azalea\",\n" +
              "      \"noseRation\": 0.4494640612,\n" +
              "      \"ratio36\": 0.410285499,\n" +
              "      \"ratio46\": 0.4457449316,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"zendaya\",\n" +
              "      \"noseRation\": 0.7818324933,\n" +
              "      \"ratio36\": 0.4031674365,\n" +
              "      \"ratio46\": 0.4545954119,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"zara_larsson\",\n" +
              "      \"noseRation\": 0.5295712217,\n" +
              "      \"ratio36\": 0.4270718747,\n" +
              "      \"ratio46\": 0.4677800042,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"rachel_levin\",\n" +
              "      \"noseRation\": 0.2060379007,\n" +
              "      \"ratio36\": 0.4064073769,\n" +
              "      \"ratio46\": 0.4172000529,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"bethany_mota\",\n" +
              "      \"noseRation\": 0.4041428613,\n" +
              "      \"ratio36\": 0.3482520064,\n" +
              "      \"ratio46\": 0.4710343912,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"piewdipi\",\n" +
              "      \"noseRation\": 0.8975452076,\n" +
              "      \"ratio36\": 0.3973440863,\n" +
              "      \"ratio46\": 0.4505897164,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"logan_paul\",\n" +
              "      \"noseRation\": 0.2882809739,\n" +
              "      \"ratio36\": 0.4128801583,\n" +
              "      \"ratio46\": 0.4805443913,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jake_paul\",\n" +
              "      \"noseRation\": 0.5289741929,\n" +
              "      \"ratio36\": 0.4270554841,\n" +
              "      \"ratio46\": 0.4657056353,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"ninja\",\n" +
              "      \"noseRation\": 0.9268780976,\n" +
              "      \"ratio36\": 0.3723601295,\n" +
              "      \"ratio46\": 0.4544592521,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"gordon_ramsay\",\n" +
              "      \"noseRation\": 0.6882687739,\n" +
              "      \"ratio36\": 0.3859159686,\n" +
              "      \"ratio46\": 0.4334949984,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"mr_beast\",\n" +
              "      \"noseRation\": 1.03943392,\n" +
              "      \"ratio36\": 0.3764642381,\n" +
              "      \"ratio46\": 0.4330599462,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"casey_neistat\",\n" +
              "      \"noseRation\": 0.3580536743,\n" +
              "      \"ratio36\": 0.3948930639,\n" +
              "      \"ratio46\": 0.4693774997,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"john_travolta\",\n" +
              "      \"noseRation\": 0.8247819469,\n" +
              "      \"ratio36\": 0.3915151374,\n" +
              "      \"ratio46\": 0.407819393,\n" +
              "      \"fOrM\": \"male \"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jason_statham\",\n" +
              "      \"noseRation\": 0.7689015171,\n" +
              "      \"ratio36\": 0.4191364253,\n" +
              "      \"ratio46\": 0.4207131405,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"wesley_snipes\",\n" +
              "      \"noseRation\": 0.2041901311,\n" +
              "      \"ratio36\": 0.4232183793,\n" +
              "      \"ratio46\": 0.4700920653,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jackie_chan\",\n" +
              "      \"noseRation\": 0.8349929226,\n" +
              "      \"ratio36\": 0.378253915,\n" +
              "      \"ratio46\": 0.4192946382,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"sylvester_stallone\",\n" +
              "      \"noseRation\": 0.7707275747,\n" +
              "      \"ratio36\": 0.4216860488,\n" +
              "      \"ratio46\": 0.4228083489,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"christian_bale\",\n" +
              "      \"noseRation\": 0.743718787,\n" +
              "      \"ratio36\": 0.385850852,\n" +
              "      \"ratio46\": 0.4182882054,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jet_li\",\n" +
              "      \"noseRation\": 0.8066826774,\n" +
              "      \"ratio36\": 0.4074519593,\n" +
              "      \"ratio46\": 0.4320876444,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"jamie_foxx\",\n" +
              "      \"noseRation\": 0.517489416,\n" +
              "      \"ratio36\": 0.3841129541,\n" +
              "      \"ratio46\": 0.4823677259,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"channing_tatum\",\n" +
              "      \"noseRation\": 0.542778096,\n" +
              "      \"ratio36\": 0.4011476015,\n" +
              "      \"ratio46\": 0.4038044451,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"paul_walker\",\n" +
              "      \"noseRation\": 0.6950957398,\n" +
              "      \"ratio36\": 0.4207710993,\n" +
              "      \"ratio46\": 0.4256656457,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"wentworth_miller\",\n" +
              "      \"noseRation\": 0.7418300912,\n" +
              "      \"ratio36\": 0.3728752167,\n" +
              "      \"ratio46\": 0.4355635499,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"zac_efron\",\n" +
              "      \"noseRation\": 0.3692526459,\n" +
              "      \"ratio36\": 0.4166005323,\n" +
              "      \"ratio46\": 0.4043172351,\n" +
              "      \"fOrM\": \"male\"\n" +
              "   },\n" +
              "   {\n" +
              "      \"name\": \"bella_thorne\",\n" +
              "      \"noseRation\": 0.7458372717,\n" +
              "      \"ratio36\": 0.4317061297,\n" +
              "      \"ratio46\": 0.4566200646,\n" +
              "      \"fOrM\": \"female\"\n" +
              "   }\n" +
              "]";
      ObjectMapper mapper = new ObjectMapper();
      try {
           list = mapper.readValue(jsonString, new TypeReference<List<Celebrity>>(){});
          Log.d("mojTag", "populateData: "+list.size());
      } catch (IOException e) {
          e.printStackTrace();
      }
      return  list.toArray(new Celebrity[list.size()]);
  }
}
