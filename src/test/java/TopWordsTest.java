import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TopWordsTest {

    @Test
    public void top3Test() {
        assertEquals(Arrays.asList("e", "d", "a"),    TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
        assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
        assertEquals(Arrays.asList("won't", "wont"),  TopWords.top3("  //wont won't won't "));
        assertEquals(Arrays.asList("e"),              TopWords.top3("  , e   .. "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  ...  "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  '  "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  '''  "));
        assertEquals(Arrays.asList("tqst'qas", "ahmjssddd", "dpsgoiubn"),
                TopWords.top3("JL' DpSgoiuBn tqsT'qaS apbEkj?rCmaFiiR-apbEkj.JL'!Dzfd apbEkj:rCmaFiiR?Dzfd!LZtIPfn MUVRgztDkM/AHmJSSDDD,apbEkj:JL' apbEkj MUVRgztDkM DpSgoiuBn tqsT'qaS MUVRgztDkM tqsT'qaS AHmJSSDDD MUVRgztDkM apbEkj!MUVRgztDkM,raPa'Zh tqsT'qaS,AHmJSSDDD_LZtIPfn,JL';rCmaFiiR;tqsT'qaS.MUVRgztDkM AHmJSSDDD/MUVRgztDkM Dzfd hqRuqtdy tqsT'qaS apbEkj rCmaFiiR/LZtIPfn/DpSgoiuBn/JL'-MUVRgztDkM Dzfd AHmJSSDDD:LZtIPfn tqsT'qaS raPa'Zh_DpSgoiuBn/rCmaFiiR-AHmJSSDDD AHmJSSDDD AHmJSSDDD.apbEkj;rCmaFiiR rCmaFiiR,tqsT'qaS DpSgoiuBn:rCmaFiiR apbEkj-apbEkj?JL',MUVRgztDkM DpSgoiuBn.tqsT'qaS/DpSgoiuBn MUVRgztDkM,Dzfd,AHmJSSDDD Dzfd AHmJSSDDD rCmaFiiR/DpSgoiuBn,tqsT'qaS Dzfd/tqsT'qaS tqsT'qaS.Dzfd:apbEkj,tqsT'qaS MUVRgztDkM MUVRgztDkM AHmJSSDDD:DpSgoiuBn Dzfd MUVRgztDkM AHmJSSDDD tqsT'qaS AHmJSSDDD MUVRgztDkM.MUVRgztDkM tqsT'qaS,Dzfd?hqRuqtdy MUVRgztDkM raPa'Zh DpSgoiuBn-Dzfd;rCmaFiiR-Dzfd tqsT'qaS-MUVRgztDkM DpSgoiuBn:apbEkj:DpSgoiuBn_JL';AHmJSSDDD Dzfd?hqRuqtdy:JL'-Dzfd DpSgoiuBn JL'!DpSgoiuBn:rCmaFiiR;tqsT'qaS MUVRgztDkM?DpSgoiuBn rCmaFiiR MUVRgztDkM-JL' Dzfd tqsT'qaS.rCmaFiiR Dzfd-Dzfd AHmJSSDDD MUVRgztDkM Dzfd.AHmJSSDDD?apbEkj Dzfd.AHmJSSDDD JL' tqsT'qaS-DpSgoiuBn Dzfd.rCmaFiiR.MUVRgztDkM,DpSgoiuBn JL' DpSgoiuBn AHmJSSDDD hqRuqtdy LZtIPfn MUVRgztDkM_JL';apbEkj-MUVRgztDkM;DpSgoiuBn DpSgoiuBn?DpSgoiuBn-tqsT'qaS Dzfd,AHmJSSDDD,MUVRgztDkM,MUVRgztDkM Dzfd DpSgoiuBn/apbEkj MUVRgztDkM;apbEkj JL' DpSgoiuBn:tqsT'qaS tqsT'qaS:AHmJSSDDD Dzfd.DpSgoiuBn AHmJSSDDD rCmaFiiR/rCmaFiiR!hqRuqtdy DpSgoiuBn DpSgoiuBn;JL'/apbEkj Dzfd tqsT'qaS JL';AHmJSSDDD!tqsT'qaS!tqsT'qaS rCmaFiiR AHmJSSDDD apbEkj tqsT'qaS tqsT'qaS;Dzfd Dzfd AHmJSSDDD?Dzfd JL':DpSgoiuBn.DpSgoiuBn:tqsT'qaS AHmJSSDDD apbEkj rCmaFiiR?apbEkj-raPa'Zh,tqsT'qaS_hqRuqtdy JL'/AHmJSSDDD JL' Dzfd.hqRuqtdy rCmaFiiR rCmaFiiR raPa'Zh AHmJSSDDD/rCmaFiiR AHmJSSDDD_AHmJSSDDD rCmaFiiR;AHmJSSDDD tqsT'qaS-MUVRgztDkM.hqRuqtdy/apbEkj"));
        assertEquals(Arrays.asList("a", "of", "on"),  TopWords.top3(Stream
                .of("In a village of La Mancha, the name of which I have no desire to call to",
                        "mind, there lived not long since one of those gentlemen that keep a lance",
                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                        "coursing. An olla of rather more beef than mutton, a salad on most",
                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                        "on Sundays, made away with three-quarters of his income.")
                .collect(Collectors.joining("\n")) ));
    }

    @Test
    public void top4Test() {
        assertEquals(Arrays.asList("e", "d", "a"),    TopWords.top4("a a a  b  c c  d d d d  e e e e e"));
        assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top4("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
        assertEquals(Arrays.asList("won't", "wont"),  TopWords.top4("  //wont won't won't "));
        assertEquals(Arrays.asList("e"),              TopWords.top4("  , e   .. "));
        assertEquals(Arrays.asList(),                 TopWords.top4("  ...  "));
        assertEquals(Arrays.asList(),                 TopWords.top4("  '  "));
        assertEquals(Arrays.asList(),                 TopWords.top4("  '''  "));
        assertEquals(Arrays.asList("tqst'qas", "ahmjssddd", "dpsgoiubn"),
                TopWords.top4("JL' DpSgoiuBn tqsT'qaS apbEkj?rCmaFiiR-apbEkj.JL'!Dzfd apbEkj:rCmaFiiR?Dzfd!LZtIPfn MUVRgztDkM/AHmJSSDDD,apbEkj:JL' apbEkj MUVRgztDkM DpSgoiuBn tqsT'qaS MUVRgztDkM tqsT'qaS AHmJSSDDD MUVRgztDkM apbEkj!MUVRgztDkM,raPa'Zh tqsT'qaS,AHmJSSDDD_LZtIPfn,JL';rCmaFiiR;tqsT'qaS.MUVRgztDkM AHmJSSDDD/MUVRgztDkM Dzfd hqRuqtdy tqsT'qaS apbEkj rCmaFiiR/LZtIPfn/DpSgoiuBn/JL'-MUVRgztDkM Dzfd AHmJSSDDD:LZtIPfn tqsT'qaS raPa'Zh_DpSgoiuBn/rCmaFiiR-AHmJSSDDD AHmJSSDDD AHmJSSDDD.apbEkj;rCmaFiiR rCmaFiiR,tqsT'qaS DpSgoiuBn:rCmaFiiR apbEkj-apbEkj?JL',MUVRgztDkM DpSgoiuBn.tqsT'qaS/DpSgoiuBn MUVRgztDkM,Dzfd,AHmJSSDDD Dzfd AHmJSSDDD rCmaFiiR/DpSgoiuBn,tqsT'qaS Dzfd/tqsT'qaS tqsT'qaS.Dzfd:apbEkj,tqsT'qaS MUVRgztDkM MUVRgztDkM AHmJSSDDD:DpSgoiuBn Dzfd MUVRgztDkM AHmJSSDDD tqsT'qaS AHmJSSDDD MUVRgztDkM.MUVRgztDkM tqsT'qaS,Dzfd?hqRuqtdy MUVRgztDkM raPa'Zh DpSgoiuBn-Dzfd;rCmaFiiR-Dzfd tqsT'qaS-MUVRgztDkM DpSgoiuBn:apbEkj:DpSgoiuBn_JL';AHmJSSDDD Dzfd?hqRuqtdy:JL'-Dzfd DpSgoiuBn JL'!DpSgoiuBn:rCmaFiiR;tqsT'qaS MUVRgztDkM?DpSgoiuBn rCmaFiiR MUVRgztDkM-JL' Dzfd tqsT'qaS.rCmaFiiR Dzfd-Dzfd AHmJSSDDD MUVRgztDkM Dzfd.AHmJSSDDD?apbEkj Dzfd.AHmJSSDDD JL' tqsT'qaS-DpSgoiuBn Dzfd.rCmaFiiR.MUVRgztDkM,DpSgoiuBn JL' DpSgoiuBn AHmJSSDDD hqRuqtdy LZtIPfn MUVRgztDkM_JL';apbEkj-MUVRgztDkM;DpSgoiuBn DpSgoiuBn?DpSgoiuBn-tqsT'qaS Dzfd,AHmJSSDDD,MUVRgztDkM,MUVRgztDkM Dzfd DpSgoiuBn/apbEkj MUVRgztDkM;apbEkj JL' DpSgoiuBn:tqsT'qaS tqsT'qaS:AHmJSSDDD Dzfd.DpSgoiuBn AHmJSSDDD rCmaFiiR/rCmaFiiR!hqRuqtdy DpSgoiuBn DpSgoiuBn;JL'/apbEkj Dzfd tqsT'qaS JL';AHmJSSDDD!tqsT'qaS!tqsT'qaS rCmaFiiR AHmJSSDDD apbEkj tqsT'qaS tqsT'qaS;Dzfd Dzfd AHmJSSDDD?Dzfd JL':DpSgoiuBn.DpSgoiuBn:tqsT'qaS AHmJSSDDD apbEkj rCmaFiiR?apbEkj-raPa'Zh,tqsT'qaS_hqRuqtdy JL'/AHmJSSDDD JL' Dzfd.hqRuqtdy rCmaFiiR rCmaFiiR raPa'Zh AHmJSSDDD/rCmaFiiR AHmJSSDDD_AHmJSSDDD rCmaFiiR;AHmJSSDDD tqsT'qaS-MUVRgztDkM.hqRuqtdy/apbEkj"));
        assertEquals(Arrays.asList("a", "of", "on"),  TopWords.top3(Stream
                .of("In a village of La Mancha, the name of which I have no desire to call to",
                        "mind, there lived not long since one of those gentlemen that keep a lance",
                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                        "coursing. An olla of rather more beef than mutton, a salad on most",
                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                        "on Sundays, made away with three-quarters of his income.")
                .collect(Collectors.joining("\n")) ));
    }
}