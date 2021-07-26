package cruise.associations.specializations;
import org.junit.*;


public class Testspecializations {

    @Test
    public void checkForMaximumWheelForBicycle(){ //Vehicle Bicycle Unicycle Wheel
        Vehicle v1 = new Vehicle();
        Bicycle b1 = new Bicycle();
        Unicycle u1=new Unicycle();

        Wheel w1 = new Wheel();
        Wheel w2 = new Wheel();
        Wheel w3 = new Wheel();
        Wheel w4 = new Wheel();
        Wheel w5 = new Wheel();
        Wheel w6 = new Wheel();
        Wheel w7 = new Wheel();

        v1.addWheel(w1);
        v1.addWheel(w2);
        v1.addWheel(w3);
        u1.addWheel(w4);
        b1.addWheel(w5);
        b1.addWheel(w6);

        Assert.assertEquals(3, v1.numberOfWheel());
        Assert.assertEquals(1, u1.numberOfWheel());
        Assert.assertEquals(2, b1.numberOfWheel());
        Assert.assertFalse(b1.addWheel(w7));
        //Delete
    }

    @Test
    public void checkMaxSsForAaa() { //Aaa Aa Sss Ss 
        Aaa aAaa = new Aaa();
        Aa aAa = new Aa();
        Sss aSss = new Sss();
        Ss aSs=new Ss();
                
        aAa.addS(new Ss());
        aAaa.addS(new Ss());
        aAaa.addS(new Ss());

        for(int i=1; i<=3; i++){
            aSss.addA(new Aa());
        }
        for(int i=1; i<=5; i++){
            aSs.addA(new Aa());
        }

        Assert.assertTrue(aAa.addS(new Ss()));
        Assert.assertFalse(aAa.addS(new Ss()));
        Assert.assertEquals(3, aSss.numberOfA());
        Assert.assertEquals(5, aSs.numberOfA());

    }

    @Test
    public void checkMaxAazForBbz(){ //Aaz Az Bbz Bz
        Bbz abbz=new Bbz();
        Aaz aaaz1=new Aaz();
        Aaz aaaz2=new Aaz();
        Aaz aaaz3=new Aaz();
        Aaz aaaz4=new Aaz();
        Aaz aaaz5=new Aaz();

        abbz.addA(aaaz1);
        abbz.addA(aaaz2);
        abbz.addA(aaaz3);
        abbz.addA(aaaz4);

        Assert.assertFalse(abbz.addA(aaaz1));
        Assert.assertFalse(abbz.addA(aaaz5));
        Assert.assertEquals(4, abbz.numberOfA());

    }

    @Test
    public void checkMaxVffforEvv(){ //Evv Ev vff vf
        Evv aevv=new Evv();
        Vff avff1=new Vff();
        Vff avff2=new Vff();
        Vff avff3=new Vff();
        Vff avff4=new Vff();
        Vff avff5=new Vff();
        Vff avff6=new Vff();

        aevv.addVf(avff1);
        aevv.addVf(avff2);
        aevv.addVf(avff3);
        aevv.addVf(avff4);
        aevv.addVf(avff5);

        Assert.assertFalse(aevv.addVf(avff1));
        Assert.assertFalse(aevv.addVf(avff1));
        Assert.assertEquals(5, aevv.numberOfVf());

    }

    @Test
    public void checkMinOfDdinFf(){ //Ddd Dd Fff Ff
        Fff afff= new Fff();
        Ddd addd1=new Ddd();
        Ddd addd2=new Ddd();
        Ddd addd3=new Ddd();
        Ddd addd4=new Ddd();

        afff.addD(addd1);
        afff.addD(addd2);
        afff.addD(addd3);

        Assert.assertTrue(afff.removeD(addd1));
        Assert.assertFalse(afff.removeD(addd2));
        Assert.assertEquals(2, afff.numberOfD());
    }

    @Test
    public void checkAlterationInPine() {//Pine Dilleniidae Alteration
        Pine apine = new Pine();
        Alteration anAlteration = new Alteration();
        

        apine.addAlt(anAlteration);
        for(int i=1; i<=2; i++){
            apine.addAlt(new Alteration());
        }
        Assert.assertFalse(apine.addAlt(new Alteration()));
        Assert.assertFalse(apine.removeAlt(anAlteration));
        
        anAlteration.addDill(apine);
        anAlteration.addDill(new Pine());
        Assert.assertFalse(anAlteration.addDill(new Pine()));
        Assert.assertTrue(anAlteration.addDill(new Dilleniidae()));
        Assert.assertFalse(anAlteration.addDill(new Dilleniidae()));
        
    }

    @Test
    public void checkMaxFruitInSpatula(){//Apple Snapple Spatula

        Spatula aSpatula = new Spatula();
        Apple aApple=new Apple();
        Snapple aSnapple = new Snapple();
        Snapple aSnapple2 = new Snapple();
        Snapple aSnapple3 = new Snapple();
        aApple.addSpat(new Spatula());
        aSnapple2.addSpat(new Spatula());
        aSnapple3.addSpat(new Spatula());
        aSnapple.addSpat(new Spatula());
        aSnapple.addSpat(new Spatula());
        Snapple[] aSnapplearray={aSnapple, aSnapple2};
        aSpatula.setFruit_Snapple(aSnapplearray);

        Assert.assertFalse(aSnapple.addSpat(new Spatula()));
        Assert.assertFalse(aSpatula.removeFruit(aSnapple2));
        aSpatula.addFruit(aSnapple2);
        Assert.assertFalse(aSpatula.addFruit(aSnapple3));
        Assert.assertTrue(aSpatula.addFruit(aApple));

    }

    @Test
    public void checkMaxLegs() {
        Animal anAnimal = new Animal();
        Rhino aRhino = new Rhino();
        
        Leg aleg = new Leg(aRhino);
        Leg aleg1 = new Leg(aRhino);
        Leg aleg2 = new Leg(aRhino);
        Leg aleg3 = new Leg(aRhino);
        Leg aleg4 = new Leg(anAnimal);
    
        Assert.assertEquals(1, anAnimal.numberOfLegs());
        Assert.assertTrue(aRhino.isNumberOfLegsValid_Leg());
        Assert.assertFalse(aRhino.removeLeg(aleg1));
        Assert.assertTrue(aRhino.isNumberOfLegsValid_Leg()); 
    }   

    @Test
    public void checkMaxZaa(){ //Zaa Za Aqq Aq
        Zaa aZaa = new Zaa();
        Aqq aAqq=new Aqq();
        Aqq aAqq1=new Aqq();
        Aqq aAqq2=new Aqq();
        Aqq aAqq3=new Aqq();
        Aqq aAqq4=new Aqq();

        aZaa.addAq(aAqq);
        aZaa.addAq(aAqq1);
        aZaa.addAq(aAqq2);
        aZaa.addAq(aAqq3);
        Assert.assertFalse(aZaa.addAq(aAqq4));

    }

    @Test 
    public void checkMaxBbbAndVvv(){//Vvv Vvv BbbBb
        Bbb aBbb=new Bbb();
        Bb aBb=new Bb();
        Vvv aVvv=new Vvv();
        Vv aVv=new Vv();

        for(int i=1; i<=3; i++){
            aBbb.addV(new Vv());
        }
        for(int i=1; i<=5; i++){
            aBb.addV(new Vv());
        }
        for(int i=1; i<=3; i++){
            aVvv.addB(new Bb());
        }
        for(int i=1; i<=5; i++){
            aVv.addB(new Bb());
        }

        Assert.assertEquals(3, aBbb.numberOfV());
        Assert.assertEquals(5, aBb.numberOfV());
        Assert.assertEquals(3, aVvv.numberOfB());
        Assert.assertEquals(5, aVv.numberOfB());

    }

    @Test
    public void checkMaxFatAndBig(){
        Whale whale = new Whale();
        Whale whale1 = new Whale();
        Whale whale2 = new Whale();

        Blubber ablubber = new Blubber();
        whale.addFat(ablubber);
        for (int i=0; i<9; i++){
            whale.addFat(new Blubber());
        }
        Assert.assertTrue(whale.isNumberOfFatValid_Blubber());
        Assert.assertFalse(whale.addFat(new Blubber()));
        Assert.assertFalse(whale.removeFat(ablubber));
    }

    @Test
    public void checkMaxElephantAndZebra(){//Big Elephant elephant zebra
        BigElephant abigElephant = new BigElephant();
        Zebra aZebra = new Zebra();
        
        abigElephant.addPoodle(aZebra);
        abigElephant.addPoodle(new Zebra());
        aZebra.addBob(abigElephant);
        for (int i=1; i<=3; i++){
            aZebra.addBob(new BigElephant());
        }

        Assert.assertFalse(abigElephant.addPoodle(new Zebra()));
        Assert.assertEquals(2, abigElephant.numberOfPoodle());
        Assert.assertFalse(aZebra.addBob(new BigElephant()));
        Assert.assertEquals(4, aZebra.numberOfBob());

    }

    @Test
    public void checkMaxHoots(){//birch tree owl
        Birch aBirch=new Birch();
        Tree aTree=new Tree();
        Owl anOwl=new Owl();

        for (int i=1; i<=3; i++){
            aBirch.addHoot(new Owl());
        }
        
        for (int i=1; i<=5; i++){
            aTree.addHoot(new Owl());
        }

        Assert.assertFalse(aBirch.addHoot(anOwl));
        Assert.assertEquals(3, aBirch.numberOfHoots());
        Assert.assertFalse(aTree.addHoot(anOwl));
        Assert.assertEquals(5, aTree.numberOfHoots());

    }

    @Test
    public void checkMaxBnInVbb(){//Vbb vb bn
        Vbb aVbb=new Vbb();
        Bn aBn=new Bn();
        aBn.addVb(aVbb);
        Bn aBn1=new Bn();
        aBn1.addVb(aVbb);
        Bn aBn2=new Bn();
        aBn2.addVb(aVbb);
        Bn aBn3=new Bn();
        aBn3.addVb(aVbb);
        
        Bn aBn4=new Bn();
        aBn4.addVb(aVbb);
        
        
        aVbb.addBn(aBn);
        aVbb.addBn(aBn1);
        aVbb.addBn(aBn2);
        aVbb.addBn(aBn3);
        

        Assert.assertTrue(aVbb.isNumberOfBnValid_Bn());
        Assert.assertFalse(aVbb.addBn(aBn4));
        aVbb.removeBn(aBn);
        aVbb.removeBn(aBn1);
        Assert.assertFalse(aVbb.removeBn(aBn2));

    }

    @Test
    public void checkGbrules(){//gb tg by byy
        Gb aGb=new Gb();
        Gb aGb1=new Gb();
        Gb aGb2=new Gb();
        Gb aGb3=new Gb();
        Gb aGb4=new Gb();
        Gb aGb5=new Gb();
        Gb aGb6=new Gb();
        Gb aGb7=new Gb();
        Gb aGb8=new Gb();
        Gb[] aGbarray= {aGb, aGb1, aGb2, aGb3, aGb4, aGb5, aGb6, aGb7, aGb8};
        Tg aTg=new Tg(aGbarray);
        By aBy=new By();
        Byy aByy=new Byy();

        for(int i=1; i<=4; i++){
            aTg.addGb(new Gb());
        }
        Assert.assertFalse(aTg.addGb(new Gb()));
        aTg.removeGb(aGb);
        aTg.removeGb(aGb2);
        aTg.removeGb(aGb3);
        aTg.removeGb(aGb4);
        aTg.removeGb(aGb5);
        aTg.removeGb(aGb6);
        aTg.removeGb(aGb7);
        Assert.assertFalse(aTg.removeGb(aGb8));
        Assert.assertTrue(aTg.isNumberOfGbValid());

    }

    @Test
    public void checkCccRules(){//Ccc cc xx xxx
        Ccc aCcc=new Ccc();
        Cc aCc=new Cc();
        Xxx aXxx=new Xxx();
        Xx aXx=new Xx();

        for (int i=1; i<=3; i++){
            aCcc.addX(new Xx());
        }
        for (int i=1; i<=5; i++){
            aCc.addX(new Xx());
        }
        for(int i=1; i<=3; i++){
            aXxx.addC(new Cc());
        }
        for(int i=1; i<=5; i++){
            aXx.addC(new Cc());
        }
        Assert.assertEquals(3, aCcc.numberOfX());
        Assert.assertEquals(5, aCc.numberOfX());
        Assert.assertEquals(3, aXxx.numberOfC());
        Assert.assertEquals(5, aXx.numberOfC());

    }

    @Test
    public void checkRulesCdd(){//Cdd cd Dee De
        Cd aCdd=new Cdd();
        Cdd aCdd2=new Cdd();
        Cdd aCdd3=new Cdd();
        Cdd aCdd4=new Cdd();
        Cdd aCdd5=new Cdd();
        Cd aCd=new Cd();
        Dee aDee=new Dee();
        De aDe=new De();

        for(int i=1; i<=3;i++){
            aCdd.addDe(new De());
        }
        for(int i=1; i<=5;i++){
            aCd.addDe(new De());
        }

        aCdd2.addDe(aDee);
        aCdd3.addDe(aDee);

        Assert.assertEquals(5, aCd.numberOfDe());
        Assert.assertEquals(3, aCdd.numberOfDe());
        Assert.assertEquals(2, aDee.numberOfCd());
        Assert.assertFalse(aDee.removeCd(aCdd2));
        aCdd4.addDe(aDee);
        Assert.assertFalse(aDee.addCd(aCdd4));
    }

    @Test
    public void checkCrRules(){//crr cr rf
        Crr aCrr=new Crr();
        Cr aCr=new Cr();
        Rf aRf=new Rf();

        aCrr.addRf(aRf);
        for(int i=1; i<=3; i++){
            aCrr.addRf(new Rf());
        }
        Assert.assertFalse(aCrr.addRf(new Rf()));
    }
    @Test
    public void checkXccRules(){//xcc xc cvv
        Xc aXc=new Xc();
        Xcc aXcc=new Xcc();
        Cvv aCvv=new Cvv();
        Cvv aCvv2=new Cvv();
        Cvv aCvv3=new Cvv();

        for (int i=1; i<=8; i++){
            aXc.addCvv(new Cvv());
        }
        Assert.assertEquals(8, aXc.numberOfCvv());

        aXcc.addCvv(aCvv);
        aXcc.addCvv(aCvv2);
        aXcc.addCvv(aCvv3);

        for(int i=1; i<=4; i++){
            aXcc.addCvv(new Cvv());
        }
        Assert.assertTrue(aXcc.isNumberOfCvvValid_Cvv());
        Assert.assertFalse(aXcc.addCvv(new Cvv()));
        aXcc.removeCvv(aCvv);
        aXcc.removeCvv(aCvv2);
        Assert.assertFalse(aXcc.removeCvv(aCvv3));

    }

    @Test
    public void checkEdRules(){//edd ed dc
        Edd aEdd=new Edd();
        Ed aEd=new Ed();
        
        for(int i=1; i<=3; i++){
            aEd.addDc(new Dc());
        }
        for(int i=1; i<=4; i++){
            aEdd.addDc(new Dc());
        }
        Assert.assertEquals(3, aEd.numberOfDc());
        Assert.assertEquals(4, aEdd.numberOfDc());
    }

    @Test
    public void checkDffRules(){//dff df fg
        Dff aDff=new Dff();
        Df aDf=new Df();

        for(int i=1; i<=3; i++){
            aDff.addFg(new Fg());
        }
        for(int i=1; i<=4; i++){
            aDf.addFg(new Fg());
        }
        Assert.assertEquals(3, aDff.numberOfFg());
        Assert.assertEquals(4, aDf.numberOfFg());
    }

    @Test
    public void checkDrummerRule(){//Drummer Drama spam spammer
        Drummer aDrummer=new Drummer();
        Drummer aDrummer2=new Drummer();
        Drummer aDrummer3=new Drummer();
        Drummer aDrummer4=new Drummer();
        Drummer aDrummer5=new Drummer();
        Drama aDrama=new Drama();
        Spam aSpam=new Spam();
        Spammer aSpammer=new Spammer();
        Spammer aSpammer2=new Spammer();
        Spammer aSpammer3=new Spammer();
        Spammer aSpammer4=new Spammer();
        Spammer aSpammer5=new Spammer();

        aDrummer.addSpam(aSpammer);
        aDrummer2.addSpam(aSpammer);
        aDrummer3.addSpam(aSpammer);
        aDrummer4.addSpam(aSpammer);

        
        Assert.assertTrue(aDrummer.setSpam(new Spammer()));
        Assert.assertFalse(aDrummer.setSpam(aSpammer));
        Assert.assertTrue(aSpammer.isNumberOfDramaValid_Drummer());
        Assert.assertFalse(aSpammer.removeDrama(aDrummer2));
    }

    @Test
    public void checkEeeRules(){//Eee ee rrr rr
        Eee aEee=new Eee();
        Eee aEee2=new Eee();
        Ee aEe=new Ee();
        Rrr aRrr=new Rrr();
        Rr aRr=new Rr();

        for(int i=1; i<=5; i++){
            aRr.addE(new Ee());
        }

        Assert.assertTrue(aRrr.addE(aEee));
        Assert.assertTrue(aRrr.addE(aEee2));
        Assert.assertFalse(aRr.addE(new Ee()));
        Assert.assertFalse(aRrr.addE(new Eee()));
        Assert.assertFalse(aRrr.removeE(aEee2));
        Assert.assertFalse(aEee.setR(aRrr));
        Assert.assertFalse(aEe.setR(aRr));

    }

    @Test 
    public void checkErr(){//err er rtt rt
        Rtt aRtt=new Rtt();
        Rtt aRtt2=new Rtt();
        Rtt aRtt3=new Rtt();
        Err aErr=new Err();

        aRtt.addEr(aErr);
        aRtt2.addEr(aErr);
        aRtt3.addEr(aErr);
        Assert.assertEquals(3, aErr.numberOfRt());
        Assert.assertFalse(aErr.removeRt(aRtt3));
    }

    @Test 
    public void checkFrr(){//frr fr rbb rb
        Rbb aRbb=new Rbb();
        Rb aRb=new Rb();
        Frr aFrr=new Frr(aRbb);
        Fr aFr=new Fr();

        for(int i=1; i<=2; i++){
            aFrr.addRb(new Rbb());
        }
        for(int i=1; i<=4; i++){
            aFr.addRb(new Rbb());
        }
        for(int i=1; i<=2; i++){
            aRbb.addFr(new Fr());
        }
        for(int i=1; i<=4; i++){
            aRb.addFr(new Fr());
        }
        Assert.assertEquals(2, aRbb.numberOfFr());
        Assert.assertEquals(4, aRb.numberOfFr());
        Assert.assertEquals(2, aFrr.numberOfRb());
        Assert.assertEquals(4, aFr.numberOfRb());
    }

    @Test
    public void checkFv(){//fvv fv vt
        Fvv aFvv=new Fvv();
        Fv aFv=new Fv();

        for(int i=1; i<=3; i++){
            aFvv.addVt(new Vt());
        }
        Assert.assertFalse(aFvv.addVt(new Vt()));
    }

    @Test 
    public void checkGg(){//ggg gg hhh hh
        Hhh aHhh=new Hhh();
        Hh aHh=new Hh();
        Ggg aGgg=new Ggg();
        Ggg aGgg2=new Ggg();
        aGgg2.addH(aHhh);
        Ggg aGgg3=new Ggg();
        aGgg3.addH(aHhh);
        Ggg aGgg4=new Ggg();
        aGgg4.addH(aHhh);
        Ggg aGgg5=new Ggg();
        aGgg5.addH(aHhh);
        Ggg aGgg6=new Ggg();
        aGgg6.addH(aHhh);
        Gg aGg=new Gg();
        

        for(int i=1; i<=5; i++){
            aGg.addH(new Hhh());
        }
        for(int i=1; i<=3; i++){
            aGgg.addH(new Hhh());
        }

        Assert.assertFalse(aGg.addH(new Hhh()));
        Assert.assertTrue(aGgg.addH(new Hhh()));
        aHhh.setG(new Ggg[]{aGgg2, aGgg3, aGgg4, aGgg5, aGgg6});
        Assert.assertEquals(5, aHhh.numberOfG());
        Assert.assertFalse(aHhh.setG(new Ggg[]{new Ggg(), new Ggg(), new Ggg(), new Ggg(), new Ggg(), new Ggg()}));
    }

    @Test
    public void checkGh(){//ghh gh 
        Gh aGh=new Gh();
        Ghh aGhh=new Ghh();
        Fg aFg=new Fg();
        Fg aFg2=new Fg();
        Fg aFg3=new Fg();

        for (int i=1; i<=2; i++){
            aGh.addFg(new Fg());
        }
        aGhh.addFg(aFg);
        aGhh.addFg(aFg2);
        aGhh.addFg(aFg3);

        for(int i=1; i<=3; i++){
            aGhh.addFg(new Fg());
        }

        Assert.assertFalse(aGhh.addFg(new Fg()));
        Assert.assertEquals(2, aGh.numberOfFg());
        Assert.assertEquals(6, aGhh.numberOfFg());

        aGhh.removeFg(aFg2);
        aGhh.removeFg(aFg3);

        Assert.assertFalse(aGhh.removeFg(aFg3));
    }

    @Test
    public void checkHnn(){//nu hnn hn
        Nu aNu=new Nu();
        Hn aHn=new Hn();
        Hnn aHnn=new Hnn();
        Hnn aHnn2=new Hnn();
        Hnn aHnn3=new Hnn();
        Hnn aHnn4=new Hnn();
        Hnn aHnn5=new Hnn();

        for(int i=1; i<=3; i++){
            aNu.addHn(new Hnn());
        }
        for(int i=1; i<=2; i++){
            aHn.addNu(new Nu());
        }
        for(int i=1; i<=4; i++){
            aHnn.addNu(new Nu());
        }
        aNu.addHn(aHnn);
        aNu.addHn(aHnn2);
        aNu.addHn(aHnn3);
        aNu.addHn(aHnn4);
        aNu.addHn(aHnn5);

        Assert.assertFalse(aNu.addHn(new Hnn()));
        Assert.assertEquals(2, aHn.numberOfNu());
        Assert.assertEquals(4, aHnn.numberOfNu());

        aNu.removeHn(aHnn2);
        aNu.removeHn(aHnn3);
        aNu.removeHn(aHnn4);
        aNu.removeHn(aHnn5);

        Assert.assertFalse(aNu.removeHn(aHnn));
        
    }

    @Test 
    public void checkiii(){//uuu uu iii ii
        Iii aIii=new Iii();
        Ii aIi=new Ii();
        Uu aUu=new Uu();
        Uuu aUuu=new Uuu();

        for(int i=1; i<=3; i++){
            aIii.addU(new Uuu());
        }
        for(int i=1; i<=5; i++){
            aIi.addU(new Uuu());
        }
        for(int i=1; i<=4; i++){
            aUu.addI(new Iii());
        }
        aUuu.addI(new Iii());
        aUuu.addI(aIii);

        Assert.assertFalse(aIii.addU(new Uuu()));
        Assert.assertFalse(aIi.addU(new Uuu()));
        Assert.assertFalse(aUu.addI(new Iii()));
        Assert.assertTrue(aUuu.isNumberOfIValid_Iii());

    }

    @Test 
    public void checkIk(){//ik mii mi
        Mii aMii=new Mii();
        Mi aMi=new Mi();
        Ik aIk=new Ik();

        for(int i=1; i<=3; i++){
            aMii.addIk(new Ik());
        }
        for(int i=1; i<=5; i++){
            aMi.addIk(new Ik());
        }
        for(int i=1; i<=6; i++){
            aIk.addMi(new Mii());
        }

        Assert.assertEquals(3, aMii.numberOfIk());
        Assert.assertEquals(5, aMi.numberOfIk());
        Assert.assertFalse(aIk.addMi(new Mii()));

    }

    @Test
    public void checkIoo(){//ioo io uii ui
        Ioo aIoo=new Ioo();
        Io aIo=new Io();
        Uii aUii=new Uii();
        Ui aUi=new Ui();

        for(int i=1; i<=2; i++){
            aIoo.addUi(new Ui());
        }
        for(int i=1; i<=4; i++){
            aIo.addUi(new Ui());
        }
        for(int i=1; i<=2; i++){
            aUii.addIo(new Io());
        }
        for(int i=1; i<=4; i++){
            aUi.addIo(new Io());
        }

        Assert.assertEquals(2, aIoo.numberOfUi());
        Assert.assertEquals(4, aIo.numberOfUi());
        Assert.assertEquals(2, aUii.numberOfIo());
        Assert.assertEquals(4, aUi.numberOfIo());

    }
    
    @Test
    public void checkIssue1238a(){//issue 1238a b and c
        Issue1238aA aIssue1238aA=new Issue1238aA();
        Issue1238aB aIssue1238aB=new Issue1238aB();
        Issue1238aC aIssue1238aC=new Issue1238aC(new Issue1238aA());
        Issue1238aC aIssue1238aC2=new Issue1238aC(new Issue1238aA());
        
        Issue1238aC aaC = aIssue1238aB.addCsth();
        Issue1238aC aaC2 = aIssue1238aB.addCsth();
 
        for(int i=1; i<=3; i++){
            aIssue1238aA.addCsth();
        }

        Assert.assertNull(aIssue1238aA.addCsth());
        Assert.assertFalse(aIssue1238aB.addCsth(aIssue1238aC2));
        aIssue1238aB.removeCsth(aaC);
        Assert.assertFalse(aIssue1238aB.removeCsth(aaC2));
        Assert.assertFalse(aIssue1238aC.setSth(aIssue1238aA));

    }

    @Test 
    public void checkIssue1238b(){//issue1238b
        Issue1238bA aIssue1238bA=new Issue1238bA();
        Issue1238bB aIssue1238bB=new Issue1238bB();
        Issue1238bC aIssue1238bC=new Issue1238bC(new Issue1238bA());
        Issue1238bC aIssue1238bC2=new Issue1238bC(new Issue1238bA());

        for(int i=1; i<=3; i++){
            aIssue1238bA.addIssue1238bC();
        }
        Issue1238bC abC= aIssue1238bB.addIssue1238bC();
        Issue1238bC abC2= aIssue1238bB.addIssue1238bC();

        Assert.assertNull(aIssue1238bA.addIssue1238bC());
        Assert.assertFalse(aIssue1238bB.addIssue1238bC(aIssue1238bC2));
        aIssue1238bB.removeIssue1238bC(abC);
        Assert.assertFalse(aIssue1238bB.removeIssue1238bC(abC2));
        Assert.assertFalse(aIssue1238bC.setSth(aIssue1238bA));
    }

    @Test 
    public void checkjjj(){//jjj jj kkk kk
        Jjj aJjj=new Jjj();
        Jj aJj=new Jj();
        Kkk aKkk=new Kkk();
        Kk aKk=new Kk();
        
        for(int i=1; i<=6; i++){
            aJjj.addK(new Kkk());
            aJj.addK(new Kkk());
        }

        for(int i=1; i<=3; i++){
            aKkk.addJ(new Jjj());
        }
        for(int i=1; i<=4; i++){
            aKk.addJ(new Jjj());
        }

        Assert.assertFalse(aJjj.addK(new Kkk()));
        Assert.assertTrue(aJj.addK(new Kkk()));
        Assert.assertEquals(3, aKkk.numberOfJ());
        Assert.assertEquals(4, aKk.numberOfJ());
    }

    @Test 
    public void checkJkk(){//jkk jk kl
        Jkk aJkk=new Jkk();
        Jk aJk=new Jk();
        Kl aKl=new Kl();
        
        Assert.assertFalse(aKl.addJk(aJkk));
    }

    @Test
    public void checkJm(){//jm uj ujj
        Jm aJm=new Jm();
        Ujj aUjj=new Ujj();
        Uj aUj=new Uj();

        for(int i=1; i<=5; i++){
            aUj.addJm(new Jm());
        }
        for(int i=1; i<=3; i++){
            aUjj.addJm(new Jm());
        }
        aJm.addUj(aUjj);
        for(int i=1; i<=4; i++){
            aJm.addUj(new Ujj());
        }

        Assert.assertEquals(5, aUj.numberOfJm());
        Assert.assertEquals(3, aUjj.numberOfJm());
        Assert.assertFalse(aJm.removeUj(aUjj));
    }
    
    @Test 
    public void checkKoo(){//koo ko oll ol
        Oll aOll=new Oll();
        Ol aOl=new Ol();
        Koo aKoo=new Koo();
        Ko aKo=new Ko();

        for(int i=1; i<=3; i++){
            aOll.addKo(new Ko());
        }
        for(int i=1; i<=5; i++){
            aOl.addKo(new Ko());
        }
        for(int i=1; i<=3; i++){
            aKoo.addOl(new Ol());
        }
        for(int i=1; i<=5; i++){
            aKo.addOl(new Ol());
        }

        Assert.assertEquals(3, aOll.numberOfKo());
        Assert.assertEquals(5, aOl.numberOfKo());
        Assert.assertEquals(3, aKoo.numberOfOl());
        Assert.assertEquals(5, aKo.numberOfOl());

    }

    @Test
    public void checklll(){//lll ll kkk kk
        Kkk aKkk=new Kkk();
        Kk aKk=new Kk();
        Lll aLll=new Lll();
        Ll aLl=new Ll();

        aKkk.addL(aLll);
        aKkk.addL(aLl);

        Assert.assertTrue(aLl.removeK(aKkk));
        Assert.assertFalse(aLll.removeK(aKk));

    }
    
    @Test 
    public void checklp(){// lp lpp pq pqq
        Pqq aPqq=new Pqq();
        Pq aPq=new Pq();
        Lpp aLpp=new Lpp();
        Lp aLp=new Lp();

        for(int i=1; i<=3; i++){
            aPqq.addLp(new Lp());
        }
        for(int i=1; i<=5; i++){
            aPq.addLp(new Lp());
        }
        for(int i=1; i<=3; i++){
           aLpp.addPq(new Pq());
        }
        for(int i=1; i<=5; i++){
            aLp.addPq(new Pq());
        }

        Assert.assertEquals(3, aPqq.numberOfLp());
        Assert.assertEquals(5, aPq.numberOfLp());
        Assert.assertEquals(3, aLpp.numberOfPq());
        Assert.assertEquals(5, aLp.numberOfPq());
    }

    @Test 
    public void checkLz(){//lzz lz zx
        Lzz aLzz=new Lzz();
        Lz aLz=new Lz();

        for(int i=1; i<=3; i++){
            aLzz.addZx(new Zx());
        }
        for(int i=1; i<=5; i++){
            aLz.addZx(new Zx());
        }

        Assert.assertEquals(3, aLzz.numberOfZx());
        Assert.assertEquals(5, aLz.numberOfZx());

    }

    @Test 
    public void checkMii(){//mii mi nnn nn
        Nnn aNnn=new Nnn();
        Nn aNn=new Nn();
        Mmm aMmm=new Mmm();
        Mm aMm=new Mm();

        for(int i=1; i<=3; i++){
            aNnn.addM(new Mm());
        }
        for(int i=1; i<=5; i++){
            aNn.addM(new Mm());
        }
        for(int i=1; i<=3; i++){
            aMmm.addN(new Nn());
        }
        for(int i=1; i<=5; i++){
            aMm.addN(new Nn());
        }

        Assert.assertEquals(3, aNnn.numberOfM());
        Assert.assertEquals(5, aNn.numberOfM());
        Assert.assertEquals(3, aMmm.numberOfN());
        Assert.assertEquals(5, aMm.numberOfN());
    }

    @Test 
    public void checkMoon(){//moon moon2 sun sun2
        Moon2 aMoon2=new Moon2();
        Moon aMoon=new Moon();
        Sun aSun=new Sun();
        Sun2 aSun2=new Sun2();

        for(int i=1; i<=10; i++){
            aMoon.addSun(new Sun());
        }
        for(int i=1; i<=3; i++){
            aMoon2.addSun(new Sun());
        }
        for(int i=1; i<=4; i++){
            aSun.addMoon(new Moon());
        }
        for(int i=1; i<=2; i++){
            aSun2.addMoon(new Moon());
        }

        Assert.assertFalse(aMoon.addSun(new Sun()));
        Assert.assertTrue(aMoon2.addSun(new Sun()));
        Assert.assertFalse(aSun.addMoon(new Moon()));
        Assert.assertTrue(aSun2.addMoon(new Moon()));

    }

    @Test 
    public void checkNm(){//nmm nm mq
       Nm aNmm=new Nmm();
       Nm aNm=new Nm();
       Mq aMq=new Mq();
       
       Assert.assertFalse(aMq.addNm(aNmm));

    }

    @Test 
    public void checkooo(){//ooo oo pp ppp
        Ppp aPpp=new Ppp();
        Ppp aPpp2=new Ppp();
        Ppp aPpp3=new Ppp();
        
        Pp aPp=new Pp();
        Pp aPp2=new Pp();
        Pp aPp3=new Pp();
        
        Ooo aOoo=new Ooo(new Pp[]{aPpp2});
        Oo aOo=new Oo(new Pp[]{aPp2});

        for(int i=1; i<=3; i++){
            Ppp[] tempPpArray={new Ppp()};
            aPpp.addO(new Oo(tempPpArray));
        }
        for(int i=1; i<=5; i++){
            Ppp[] tempPpArray={new Ppp()};
            aPp.addO(new Oo(tempPpArray));
        }
       
        aOoo.addP(aPpp3);
        

        aOo.addP(aPp3);
    

        Assert.assertEquals(3, aPpp.numberOfO());
        Assert.assertEquals(5, aPp.numberOfO());
        Assert.assertFalse(aOoo.removeP(aPpp3));
        aOo.removeP(aPp2);
        Assert.assertFalse(aOo.removeP(aPp3));
        aOoo.addP(new Ppp());
        aOoo.addP(new Ppp());

        for(int i=1; i<=4; i++){
            aOo.addP(new Pp());
        }
  
        Assert.assertFalse(aOoo.addP(new Ppp()));
        Assert.assertFalse(aOo.addP(new Pp()));
    }

    @Test 
    public void checkopp(){//op opp pa paa
        Opp aOpp=new Opp();
        Op aOp=new Op();
        Pa aPa=new Pa();
        Paa aPaa=new Paa();

        for(int i=1; i<=3; i++){
            aOpp.addPa(new Pa());
        }
        for(int i=1; i<=5; i++){
            aOp.addPa(new Pa());
        }
        for(int i=1; i<=3; i++){
            aPaa.addOp(new Op());
        }
        for(int i=1; i<=5; i++){
            aPa.addOp(new Op());
        }

        Assert.assertEquals(3, aOpp.numberOfPa());
        Assert.assertEquals(5, aOp.numberOfPa());
        Assert.assertEquals(3, aPaa.numberOfOp());
        Assert.assertEquals(5, aPa.numberOfOp());
    }

    @Test 
    public void checkqa(){//az aaz qa qaa
        Qaa aQaa=new Qaa();
        Qa aQa=new Qa();
        Az aAz=new Az();
        Az aAz2=new Az();

        aQaa.addAz(aAz);
        aQa.addAz(aAz2);
        for(int i=1; i<=3; i++){
            aQaa.addAz(new Az());
        }
        for(int i=1; i<=4; i++){
            aQa.addAz(new Az());
        }

        Assert.assertFalse(aQaa.removeAz(aAz));
        Assert.assertTrue(aQa.removeAz(aAz2));
    }

    @Test 
    public void checkqq(){//qqq qq ww
        Qqq aQqq=new Qqq();
        Qqq aQqq2=new Qqq();
        Qq aQq=new Qq();
        Qq aQq2=new Qq();
        Ww aWw=new Ww();
        Ww aWw2=new Ww();

        aWw.addQ(aQqq);
        aWw.addQ(aQqq2);

        for(int i=1; i<=5; i++){
            aWw2.addQ(new Qq());
        }

        Assert.assertFalse(aWw.addQ(new Qqq()));
        Assert.assertFalse(aWw.removeQ(aQq2));
        Assert.assertFalse(aWw2.addQ(new Qq()));
        Assert.assertFalse(aQqq.setW(aWw2));
        Assert.assertTrue(aQq.setW(aWw));

    }

    @Test 
    public void checkqw(){// qww qw wee we
        Qww aQww=new Qww();
        Qw aQw=new Qw();
        Wee aWee=new Wee();
        We aWe=new We();

        for(int i=1; i<=6;i++){
            aWee.addQw(new Qww());
            aWe.addQw(new Qw());
        }
        for(int i=1; i<=3; i++){
            aQww.addWe(new Wee());
        }
        for(int i=1; i<=5; i++){
            aQw.addWe(new We());
        }

        Assert.assertEquals(5, aQw.numberOfWe());
        Assert.assertEquals(3, aQww.numberOfWe());
        Assert.assertFalse(aWee.addQw(new Qww()));
        Assert.assertTrue(aWe.addQw(new Qww()));
    }

    @Test 
    public void checkqx(){// qxx qx xsxx xsx
        Qxx aQxx=new Qxx();
        Qx aQx=new Qx();
        Xssx aXssx=new Xssx();
        Xsx aXsx=new Xsx();

        for(int i=1; i<=3; i++){
          aQxx.addXsx(new Xsx());   
        }
        for(int i=1; i<=5; i++){
            aQx.addXsx(new Xsx());   
        }
        for(int i=1; i<=3; i++){
            aXssx.addQx(new Qx());
        }
        for(int i=1; i<=5; i++){
            aXsx.addQx(new Qx());
        }

        Assert.assertEquals(3, aQxx.numberOfXsx());
        Assert.assertEquals(5, aQx.numberOfXsx());
        Assert.assertEquals(3, aXssx.numberOfQx());
        Assert.assertEquals(5, aXsx.numberOfQx());
    }

    @Test 
    public void checkRepent(){
        Repent aRepent=new Repent();
        Repenter aRepenter=new Repenter();
        Serendipity aSerendipity=new Serendipity();

        Assert.assertTrue(aRepent.setSeren(aSerendipity));
        Assert.assertTrue(aSerendipity.setRep(aRepent));
        Assert.assertTrue(aSerendipity.setRep(aRepenter));
        Assert.assertTrue(aRepenter.setSeren(aSerendipity));
    }

    @Test
    public void checkRepent1(){
        Repent1 aRepent1=new Repent1();
        Repenter1 aRepenter1=new Repenter1();
        Serendipity1 aSerendipity1=new Serendipity1();
        Serendipity2 aSerendipity2=new Serendipity2();
        
        Assert.assertTrue(aRepent1.setSeren(aSerendipity1));
        Assert.assertTrue(aSerendipity1.setRep(aRepent1));
        Assert.assertTrue(aSerendipity1.setRep(aRepenter1));
        Assert.assertTrue(aRepenter1.setSeren(aSerendipity1));
        Assert.assertTrue(aRepenter1.setSeren(aSerendipity2));

    }

    @Test 
    public void checksass(){//sass sassy sdd sd
        Sassy aSassy=new Sassy();
        Sass aSass=new Sass();
        Sdd aSdd=new Sdd();
        Sd aSd=new Sd();

        for(int i=1; i<=3; i++){
            aSassy.addSd(new Sd());
            aSass.addSd(new Sd());
        }
        for(int i=1; i<=5; i++){
            aSdd.addSass(new Sass());
        }
        for(int i=1; i<=3; i++){
            aSd.addSass(new Sass());
        }

        Assert.assertEquals(5, aSdd.numberOfSass());
        Assert.assertEquals(3, aSd.numberOfSass());
        Assert.assertFalse(aSassy.addSd(new Sd()));
        Assert.assertTrue(aSass.addSd(new Sd()));
        Assert.assertTrue(aSassy.addSd(new Sdd()));
        Assert.assertFalse(aSassy.addSd(new Sdd()));
    }

    @Test 
    public void checkSupp(){//subab supap suppa subba
        Subab aSubab=new Subab();
        Subab aSubab2=new Subab();
        Supap aSupap=new Supap();
        Supap aSupap2=new Supap();
        Subba aSubba=new Subba();
        Subba aSubba2=new Subba();
        Suppa aSuppa=new Suppa();
        Suppa aSuppa2=new Suppa();

        aSubba.addSupap(aSubab);
        aSubba.addSupap(aSubab2);

        Assert.assertFalse(aSubba.removeSupap(aSubab2));
        aSubba.addSupap(new Subab());
        Assert.assertFalse(aSubba.addSupap(new Subab()));

        aSubab.addSuppa(aSubba);
        for(int i=1; i<=9; i++){
            aSubab.addSuppa(new Subba());
        }

        Assert.assertFalse(aSubab.removeSuppa(aSubba));
        for(int i=1; i<=5; i++){
            aSubab.addSuppa(new Subba());
        }
        Assert.assertFalse(aSubab.addSuppa(new Subba()));
    }

    @Test 
    public void checksw(){//sww sw wcc wc
        Wcc aWcc=new Wcc();
        Wc aWc=new Wc();
        Sww aSww=new Sww();
        Sw aSw=new Sw();

        for(int i=1; i<=3; i++){
            aWcc.addSw(new Sww());
            aWc.addSw(new Sw());
        }
        for(int i=1; i<=4; i++){
            aSww.addWc(new Wcc());
            aSw.addWc(new Wc());
        }
        Assert.assertTrue(aWc.addSw(new Sw()));
        Assert.assertFalse(aWcc.addSw(new Sww()));
        Assert.assertTrue(aSw.addWc(new Wc()));
        Assert.assertFalse(aSww.addWc(new Wcc()));
    }

    @Test 
    public void checktt(){//tt ttt yyy yy
        Ttt aTtt=new Ttt();
        Ttt aTtt2=new Ttt();
        Ttt aTtt3=new Ttt();
        Tt aTt=new Tt();
        Yyy aYyy=new Yyy();
        Yy aYy=new Yy();

        aTtt.addY(aYyy);
        aTtt.addY(new Yyy());
        aTtt.addY(new Yyy());

        for(int i=1; i<=4; i++){
            aTt.addY(new Yy());
        }
        for(int i=1; i<=5; i++){
            aYy.addT(new Tt());
        }

        aYyy.addT(aTtt);
        aYyy.addT(aTtt2);        
        Assert.assertFalse(aYyy.removeT(aTtt2));
        aYyy.addT(new Ttt());
        Assert.assertFalse(aYyy.addT(new Ttt()));

        Assert.assertFalse(aTtt.addY(new Yyy()));
        Assert.assertFalse(aTtt.removeY(aYyy));
        Assert.assertFalse(aTt.addY(new Yyy()));
        Assert.assertFalse(aYy.addT(new Tt()));

    }

    @Test
    public void checkTy(){//tyy ty yuu yu
        Tyy aTyy=new Tyy();
        Ty aTy=new Ty();
        Yuu aYuu=new Yuu();
        Yuu aYuu2=new Yuu();
        Yuu aYuu3=new Yuu();
        Yuu aYuu4=new Yuu();
        Yuu aYuu5=new Yuu();
        Yuu aYuu6=new Yuu();
        Yuu aYuu7=new Yuu();
        Yu aYu=new Yu();

        for(int i=1; i<=3; i++){
            aYuu.addTy(new Tyy());
        }
        for(int i=1; i<=5; i++){
            aYu.addTy(new Tyy());
        }

        aYuu2.addTy(aTyy);
        aYuu3.addTy(aTyy);
        aYuu4.addTy(aTyy);
        aYuu2.addTy(aTy);
        aYuu3.addTy(aTy);
        aYuu4.addTy(aTy);

        Assert.assertFalse(aTyy.removeYu(aYuu2));
        Assert.assertTrue(aTy.removeYu(aYuu2));

        aYuu5.addTy(aTyy);
        aYuu6.addTy(aTyy);
        aYuu7.addTy(new Tyy());

        Assert.assertFalse(aTyy.addYu(aYuu7));
    }

    @Test 
    public void checkWs(){
        Zww aZww=new Zww();
        Zw aZw=new Zw();
        Ws aWs=new Ws();
        aWs.addZw(new Zww());
        Ws aWs2=new Ws();
        aWs2.addZw(new Zww());
        Ws aWs3=new Ws();
        aWs3.addZw(new Zww());
        
        aZww.addW(aWs);
        aZww.addW(aWs2);
        aZww.addW(aWs3);

        Assert.assertFalse(aZww.removeW(aWs));

    }
    
}
