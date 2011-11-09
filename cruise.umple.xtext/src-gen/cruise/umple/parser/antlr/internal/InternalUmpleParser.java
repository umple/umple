package cruise.umple.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import cruise.umple.services.UmpleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmpleParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_TRUE", "RULE_FALSE", "RULE_DEF", "RULE_END", "RULE_RUBY_FUNCTION", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'glossary'", "'{'", "'}'", "':'", "';'", "'generate'", "'Java'", "'Php'", "'Ruby'", "'use'", "'namespace'", "'class'", "'external'", "'interface'", "'association'", "'depend'", "'.*'", "'->'", "'--'", "'<-'", "'><'", "'self'", "'associationClass'", "'isA'", "','", "'singleton'", "'key'", "'before'", "'after'", "'autounique'", "'unique'", "'[]'", "'='", "'statemachine'", "'as'", "'*'", "'afterEvery'", "'('", "')'", "'wait'", "'/'", "'entry'", "'exit'", "'do'", "'['", "']'", "'position'", "'position.association'", "'Date'", "'Time'", "'Double'", "'double'", "'Integer'", "'integer'", "'int'", "'Boolean'", "'boolean'", "'String'", "'string'", "'..'", "'+='", "'-='", "'?'", "'||'", "'&&'", "'=='", "'!='", "'<='", "'<'", "'>='", "'>'", "'+'", "'-'", "'%'", "'++'", "'~'", "'!'", "'static'", "'public'", "'private'", "'protected'", "'void'", "'()'", "'break'", "'if'", "'else'", "'for'", "'while'", "'return'", "'try'", "'catch'", "'.'", "'immutable'", "'settable'", "'internal'", "'defaulted'", "'const'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int RULE_RUBY_FUNCTION=11;
    public static final int T__16=16;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_STRING=4;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int RULE_END=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int RULE_FALSE=8;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__59=59;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=6;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=13;
    public static final int RULE_TRUE=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_DEF=9;
    public static final int RULE_WS=14;

    // delegates
    // delegators


        public InternalUmpleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmpleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmpleParser.tokenNames; }
    public String getGrammarFileName() { return "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g"; }



     	private UmpleGrammarAccess grammarAccess;
     	
        public InternalUmpleParser(TokenStream input, UmpleGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "UmpleModel";	
       	}
       	
       	@Override
       	protected UmpleGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleUmpleModel"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:68:1: entryRuleUmpleModel returns [EObject current=null] : iv_ruleUmpleModel= ruleUmpleModel EOF ;
    public final EObject entryRuleUmpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleModel = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:69:2: (iv_ruleUmpleModel= ruleUmpleModel EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:70:2: iv_ruleUmpleModel= ruleUmpleModel EOF
            {
             newCompositeNode(grammarAccess.getUmpleModelRule()); 
            pushFollow(FOLLOW_ruleUmpleModel_in_entryRuleUmpleModel75);
            iv_ruleUmpleModel=ruleUmpleModel();

            state._fsp--;

             current =iv_ruleUmpleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUmpleModel"


    // $ANTLR start "ruleUmpleModel"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:77:1: ruleUmpleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleUmpleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:80:28: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:81:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:81:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16||LA1_0==21||(LA1_0>=25 && LA1_0<=30)||LA1_0==38||LA1_0==49) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:82:1: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:82:1: (lv_elements_0_0= ruleAbstractElement )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:83:3: lv_elements_0_0= ruleAbstractElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUmpleModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractElement_in_ruleUmpleModel130);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUmpleModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"AbstractElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUmpleModel"


    // $ANTLR start "entryRuleAbstractElement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:107:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:108:2: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:109:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractElement176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:116:1: ruleAbstractElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Glossary_1= ruleGlossary | this_Generate_2= ruleGenerate | this_UseStatement_3= ruleUseStatement | this_Entity_4= ruleEntity ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Glossary_1 = null;

        EObject this_Generate_2 = null;

        EObject this_UseStatement_3 = null;

        EObject this_Entity_4 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:119:28: ( (this_Namespace_0= ruleNamespace | this_Glossary_1= ruleGlossary | this_Generate_2= ruleGenerate | this_UseStatement_3= ruleUseStatement | this_Entity_4= ruleEntity ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:120:1: (this_Namespace_0= ruleNamespace | this_Glossary_1= ruleGlossary | this_Generate_2= ruleGenerate | this_UseStatement_3= ruleUseStatement | this_Entity_4= ruleEntity )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:120:1: (this_Namespace_0= ruleNamespace | this_Glossary_1= ruleGlossary | this_Generate_2= ruleGenerate | this_UseStatement_3= ruleUseStatement | this_Entity_4= ruleEntity )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case 21:
                {
                alt2=3;
                }
                break;
            case 25:
                {
                alt2=4;
                }
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 49:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:121:5: this_Namespace_0= ruleNamespace
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getNamespaceParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNamespace_in_ruleAbstractElement223);
                    this_Namespace_0=ruleNamespace();

                    state._fsp--;

                     
                            current = this_Namespace_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:131:5: this_Glossary_1= ruleGlossary
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getGlossaryParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleGlossary_in_ruleAbstractElement250);
                    this_Glossary_1=ruleGlossary();

                    state._fsp--;

                     
                            current = this_Glossary_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:141:5: this_Generate_2= ruleGenerate
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getGenerateParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleGenerate_in_ruleAbstractElement277);
                    this_Generate_2=ruleGenerate();

                    state._fsp--;

                     
                            current = this_Generate_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:151:5: this_UseStatement_3= ruleUseStatement
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getUseStatementParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleUseStatement_in_ruleAbstractElement304);
                    this_UseStatement_3=ruleUseStatement();

                    state._fsp--;

                     
                            current = this_UseStatement_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:161:5: this_Entity_4= ruleEntity
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getEntityParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleAbstractElement331);
                    this_Entity_4=ruleEntity();

                    state._fsp--;

                     
                            current = this_Entity_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleGlossary"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:177:1: entryRuleGlossary returns [EObject current=null] : iv_ruleGlossary= ruleGlossary EOF ;
    public final EObject entryRuleGlossary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlossary = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:178:2: (iv_ruleGlossary= ruleGlossary EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:179:2: iv_ruleGlossary= ruleGlossary EOF
            {
             newCompositeNode(grammarAccess.getGlossaryRule()); 
            pushFollow(FOLLOW_ruleGlossary_in_entryRuleGlossary366);
            iv_ruleGlossary=ruleGlossary();

            state._fsp--;

             current =iv_ruleGlossary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGlossary376); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlossary"


    // $ANTLR start "ruleGlossary"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:186:1: ruleGlossary returns [EObject current=null] : ( () otherlv_1= 'glossary' otherlv_2= '{' ( (lv_words_3_0= ruleWord ) )* otherlv_4= '}' ) ;
    public final EObject ruleGlossary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_words_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:189:28: ( ( () otherlv_1= 'glossary' otherlv_2= '{' ( (lv_words_3_0= ruleWord ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:190:1: ( () otherlv_1= 'glossary' otherlv_2= '{' ( (lv_words_3_0= ruleWord ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:190:1: ( () otherlv_1= 'glossary' otherlv_2= '{' ( (lv_words_3_0= ruleWord ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:190:2: () otherlv_1= 'glossary' otherlv_2= '{' ( (lv_words_3_0= ruleWord ) )* otherlv_4= '}'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:190:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:191:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGlossaryAccess().getGlossaryAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleGlossary422); 

                	newLeafNode(otherlv_1, grammarAccess.getGlossaryAccess().getGlossaryKeyword_1());
                
            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleGlossary434); 

                	newLeafNode(otherlv_2, grammarAccess.getGlossaryAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:204:1: ( (lv_words_3_0= ruleWord ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:205:1: (lv_words_3_0= ruleWord )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:205:1: (lv_words_3_0= ruleWord )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:206:3: lv_words_3_0= ruleWord
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGlossaryAccess().getWordsWordParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleWord_in_ruleGlossary455);
            	    lv_words_3_0=ruleWord();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGlossaryRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"words",
            	            		lv_words_3_0, 
            	            		"Word");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleGlossary468); 

                	newLeafNode(otherlv_4, grammarAccess.getGlossaryAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlossary"


    // $ANTLR start "entryRuleWord"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:234:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:235:2: (iv_ruleWord= ruleWord EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:236:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord504);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord514); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:243:1: ruleWord returns [EObject current=null] : ( ( (lv_singular_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_plural_2_0= RULE_STRING ) ) otherlv_3= ';' ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_singular_0_0=null;
        Token otherlv_1=null;
        Token lv_plural_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:246:28: ( ( ( (lv_singular_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_plural_2_0= RULE_STRING ) ) otherlv_3= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:247:1: ( ( (lv_singular_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_plural_2_0= RULE_STRING ) ) otherlv_3= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:247:1: ( ( (lv_singular_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_plural_2_0= RULE_STRING ) ) otherlv_3= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:247:2: ( (lv_singular_0_0= RULE_STRING ) ) otherlv_1= ':' ( (lv_plural_2_0= RULE_STRING ) ) otherlv_3= ';'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:247:2: ( (lv_singular_0_0= RULE_STRING ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:248:1: (lv_singular_0_0= RULE_STRING )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:248:1: (lv_singular_0_0= RULE_STRING )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:249:3: lv_singular_0_0= RULE_STRING
            {
            lv_singular_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWord556); 

            			newLeafNode(lv_singular_0_0, grammarAccess.getWordAccess().getSingularSTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWordRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"singular",
                    		lv_singular_0_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleWord573); 

                	newLeafNode(otherlv_1, grammarAccess.getWordAccess().getColonKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:269:1: ( (lv_plural_2_0= RULE_STRING ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:270:1: (lv_plural_2_0= RULE_STRING )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:270:1: (lv_plural_2_0= RULE_STRING )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:271:3: lv_plural_2_0= RULE_STRING
            {
            lv_plural_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWord590); 

            			newLeafNode(lv_plural_2_0, grammarAccess.getWordAccess().getPluralSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWordRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"plural",
                    		lv_plural_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleWord607); 

                	newLeafNode(otherlv_3, grammarAccess.getWordAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWord"


    // $ANTLR start "entryRuleGenerate"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:299:1: entryRuleGenerate returns [EObject current=null] : iv_ruleGenerate= ruleGenerate EOF ;
    public final EObject entryRuleGenerate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerate = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:300:2: (iv_ruleGenerate= ruleGenerate EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:301:2: iv_ruleGenerate= ruleGenerate EOF
            {
             newCompositeNode(grammarAccess.getGenerateRule()); 
            pushFollow(FOLLOW_ruleGenerate_in_entryRuleGenerate643);
            iv_ruleGenerate=ruleGenerate();

            state._fsp--;

             current =iv_ruleGenerate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGenerate653); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerate"


    // $ANTLR start "ruleGenerate"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:308:1: ruleGenerate returns [EObject current=null] : (otherlv_0= 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) otherlv_4= ';' ) ;
    public final EObject ruleGenerate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_java_1_0=null;
        Token lv_Php_2_0=null;
        Token lv_Ruby_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:311:28: ( (otherlv_0= 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) otherlv_4= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:312:1: (otherlv_0= 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) otherlv_4= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:312:1: (otherlv_0= 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) otherlv_4= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:312:3: otherlv_0= 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleGenerate690); 

                	newLeafNode(otherlv_0, grammarAccess.getGenerateAccess().getGenerateKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:316:1: ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt4=1;
                }
                break;
            case 23:
                {
                alt4=2;
                }
                break;
            case 24:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:316:2: ( (lv_java_1_0= 'Java' ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:316:2: ( (lv_java_1_0= 'Java' ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:317:1: (lv_java_1_0= 'Java' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:317:1: (lv_java_1_0= 'Java' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:318:3: lv_java_1_0= 'Java'
                    {
                    lv_java_1_0=(Token)match(input,22,FOLLOW_22_in_ruleGenerate709); 

                            newLeafNode(lv_java_1_0, grammarAccess.getGenerateAccess().getJavaJavaKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGenerateRule());
                    	        }
                           		setWithLastConsumed(current, "java", true, "Java");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:332:6: ( (lv_Php_2_0= 'Php' ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:332:6: ( (lv_Php_2_0= 'Php' ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:333:1: (lv_Php_2_0= 'Php' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:333:1: (lv_Php_2_0= 'Php' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:334:3: lv_Php_2_0= 'Php'
                    {
                    lv_Php_2_0=(Token)match(input,23,FOLLOW_23_in_ruleGenerate746); 

                            newLeafNode(lv_Php_2_0, grammarAccess.getGenerateAccess().getPhpPhpKeyword_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGenerateRule());
                    	        }
                           		setWithLastConsumed(current, "Php", true, "Php");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:348:6: ( (lv_Ruby_3_0= 'Ruby' ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:348:6: ( (lv_Ruby_3_0= 'Ruby' ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:349:1: (lv_Ruby_3_0= 'Ruby' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:349:1: (lv_Ruby_3_0= 'Ruby' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:350:3: lv_Ruby_3_0= 'Ruby'
                    {
                    lv_Ruby_3_0=(Token)match(input,24,FOLLOW_24_in_ruleGenerate783); 

                            newLeafNode(lv_Ruby_3_0, grammarAccess.getGenerateAccess().getRubyRubyKeyword_1_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGenerateRule());
                    	        }
                           		setWithLastConsumed(current, "Ruby", lv_Ruby_3_0, "Ruby");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleGenerate809); 

                	newLeafNode(otherlv_4, grammarAccess.getGenerateAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerate"


    // $ANTLR start "entryRuleUseStatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:375:1: entryRuleUseStatement returns [EObject current=null] : iv_ruleUseStatement= ruleUseStatement EOF ;
    public final EObject entryRuleUseStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseStatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:376:2: (iv_ruleUseStatement= ruleUseStatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:377:2: iv_ruleUseStatement= ruleUseStatement EOF
            {
             newCompositeNode(grammarAccess.getUseStatementRule()); 
            pushFollow(FOLLOW_ruleUseStatement_in_entryRuleUseStatement845);
            iv_ruleUseStatement=ruleUseStatement();

            state._fsp--;

             current =iv_ruleUseStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUseStatement855); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUseStatement"


    // $ANTLR start "ruleUseStatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:384:1: ruleUseStatement returns [EObject current=null] : (otherlv_0= 'use' ( (lv_file_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleUseStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_file_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:387:28: ( (otherlv_0= 'use' ( (lv_file_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:388:1: (otherlv_0= 'use' ( (lv_file_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:388:1: (otherlv_0= 'use' ( (lv_file_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:388:3: otherlv_0= 'use' ( (lv_file_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleUseStatement892); 

                	newLeafNode(otherlv_0, grammarAccess.getUseStatementAccess().getUseKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:392:1: ( (lv_file_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:393:1: (lv_file_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:393:1: (lv_file_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:394:3: lv_file_1_0= RULE_ID
            {
            lv_file_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUseStatement909); 

            			newLeafNode(lv_file_1_0, grammarAccess.getUseStatementAccess().getFileIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUseStatementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"file",
                    		lv_file_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleUseStatement926); 

                	newLeafNode(otherlv_2, grammarAccess.getUseStatementAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUseStatement"


    // $ANTLR start "entryRuleNamespace"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:422:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:423:2: (iv_ruleNamespace= ruleNamespace EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:424:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace962);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace972); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:431:1: ruleNamespace returns [EObject current=null] : (otherlv_0= 'namespace' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:434:28: ( (otherlv_0= 'namespace' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:435:1: (otherlv_0= 'namespace' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:435:1: (otherlv_0= 'namespace' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:435:3: otherlv_0= 'namespace' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleNamespace1009); 

                	newLeafNode(otherlv_0, grammarAccess.getNamespaceAccess().getNamespaceKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:439:1: ( (lv_value_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:440:1: (lv_value_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:440:1: (lv_value_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:441:3: lv_value_1_0= RULE_ID
            {
            lv_value_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamespace1026); 

            			newLeafNode(lv_value_1_0, grammarAccess.getNamespaceAccess().getValueIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNamespaceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleNamespace1043); 

                	newLeafNode(otherlv_2, grammarAccess.getNamespaceAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleEntity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:469:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:470:2: (iv_ruleEntity= ruleEntity EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:471:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity1079);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity1089); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:478:1: ruleEntity returns [EObject current=null] : (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition | this_StateMachineDefinition_5= ruleStateMachineDefinition ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_ClassDefinition_0 = null;

        EObject this_InterfaceDefinition_1 = null;

        EObject this_ExternalDefinition_2 = null;

        EObject this_AssociationDefinition_3 = null;

        EObject this_AssociationClassDefinition_4 = null;

        EObject this_StateMachineDefinition_5 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:481:28: ( (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition | this_StateMachineDefinition_5= ruleStateMachineDefinition ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:482:1: (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition | this_StateMachineDefinition_5= ruleStateMachineDefinition )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:482:1: (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition | this_StateMachineDefinition_5= ruleStateMachineDefinition )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt5=1;
                }
                break;
            case 29:
                {
                alt5=2;
                }
                break;
            case 28:
                {
                alt5=3;
                }
                break;
            case 30:
                {
                alt5=4;
                }
                break;
            case 38:
                {
                alt5=5;
                }
                break;
            case 49:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:483:5: this_ClassDefinition_0= ruleClassDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getClassDefinitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleClassDefinition_in_ruleEntity1136);
                    this_ClassDefinition_0=ruleClassDefinition();

                    state._fsp--;

                     
                            current = this_ClassDefinition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:493:5: this_InterfaceDefinition_1= ruleInterfaceDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getInterfaceDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInterfaceDefinition_in_ruleEntity1163);
                    this_InterfaceDefinition_1=ruleInterfaceDefinition();

                    state._fsp--;

                     
                            current = this_InterfaceDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:503:5: this_ExternalDefinition_2= ruleExternalDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getExternalDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleExternalDefinition_in_ruleEntity1190);
                    this_ExternalDefinition_2=ruleExternalDefinition();

                    state._fsp--;

                     
                            current = this_ExternalDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:513:5: this_AssociationDefinition_3= ruleAssociationDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getAssociationDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleAssociationDefinition_in_ruleEntity1217);
                    this_AssociationDefinition_3=ruleAssociationDefinition();

                    state._fsp--;

                     
                            current = this_AssociationDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:523:5: this_AssociationClassDefinition_4= ruleAssociationClassDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getAssociationClassDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleAssociationClassDefinition_in_ruleEntity1244);
                    this_AssociationClassDefinition_4=ruleAssociationClassDefinition();

                    state._fsp--;

                     
                            current = this_AssociationClassDefinition_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:533:5: this_StateMachineDefinition_5= ruleStateMachineDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getStateMachineDefinitionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleStateMachineDefinition_in_ruleEntity1271);
                    this_StateMachineDefinition_5=ruleStateMachineDefinition();

                    state._fsp--;

                     
                            current = this_StateMachineDefinition_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleClassDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:549:1: entryRuleClassDefinition returns [EObject current=null] : iv_ruleClassDefinition= ruleClassDefinition EOF ;
    public final EObject entryRuleClassDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:550:2: (iv_ruleClassDefinition= ruleClassDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:551:2: iv_ruleClassDefinition= ruleClassDefinition EOF
            {
             newCompositeNode(grammarAccess.getClassDefinitionRule()); 
            pushFollow(FOLLOW_ruleClassDefinition_in_entryRuleClassDefinition1306);
            iv_ruleClassDefinition=ruleClassDefinition();

            state._fsp--;

             current =iv_ruleClassDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassDefinition1316); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassDefinition"


    // $ANTLR start "ruleClassDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:558:1: ruleClassDefinition returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) ;
    public final EObject ruleClassDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_classContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:561:28: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:562:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:562:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:562:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleClassDefinition1353); 

                	newLeafNode(otherlv_0, grammarAccess.getClassDefinitionAccess().getClassKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:566:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:567:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:567:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:568:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDefinition1370); 

            			newLeafNode(lv_name_1_0, grammarAccess.getClassDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleClassDefinition1387); 

                	newLeafNode(otherlv_2, grammarAccess.getClassDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:588:1: ( (lv_classContent_3_0= ruleClassContent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_INT)||LA6_0==31||LA6_0==39||(LA6_0>=41 && LA6_0<=46)||LA6_0==51||(LA6_0>=62 && LA6_0<=74)||(LA6_0>=108 && LA6_0<=112)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:589:1: (lv_classContent_3_0= ruleClassContent )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:589:1: (lv_classContent_3_0= ruleClassContent )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:590:3: lv_classContent_3_0= ruleClassContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassDefinitionAccess().getClassContentClassContentParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClassContent_in_ruleClassDefinition1408);
            	    lv_classContent_3_0=ruleClassContent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"classContent",
            	            		lv_classContent_3_0, 
            	            		"ClassContent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleClassDefinition1421); 

                	newLeafNode(otherlv_4, grammarAccess.getClassDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassDefinition"


    // $ANTLR start "entryRuleExternalDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:618:1: entryRuleExternalDefinition returns [EObject current=null] : iv_ruleExternalDefinition= ruleExternalDefinition EOF ;
    public final EObject entryRuleExternalDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:619:2: (iv_ruleExternalDefinition= ruleExternalDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:620:2: iv_ruleExternalDefinition= ruleExternalDefinition EOF
            {
             newCompositeNode(grammarAccess.getExternalDefinitionRule()); 
            pushFollow(FOLLOW_ruleExternalDefinition_in_entryRuleExternalDefinition1457);
            iv_ruleExternalDefinition=ruleExternalDefinition();

            state._fsp--;

             current =iv_ruleExternalDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDefinition1467); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalDefinition"


    // $ANTLR start "ruleExternalDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:627:1: ruleExternalDefinition returns [EObject current=null] : (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) ;
    public final EObject ruleExternalDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_classContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:630:28: ( (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:631:1: (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:631:1: (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:631:3: otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleExternalDefinition1504); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalDefinitionAccess().getExternalKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:635:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:636:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:636:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:637:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalDefinition1521); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExternalDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleExternalDefinition1538); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:657:1: ( (lv_classContent_3_0= ruleClassContent ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||LA7_0==31||LA7_0==39||(LA7_0>=41 && LA7_0<=46)||LA7_0==51||(LA7_0>=62 && LA7_0<=74)||(LA7_0>=108 && LA7_0<=112)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:658:1: (lv_classContent_3_0= ruleClassContent )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:658:1: (lv_classContent_3_0= ruleClassContent )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:659:3: lv_classContent_3_0= ruleClassContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExternalDefinitionAccess().getClassContentClassContentParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClassContent_in_ruleExternalDefinition1559);
            	    lv_classContent_3_0=ruleClassContent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExternalDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"classContent",
            	            		lv_classContent_3_0, 
            	            		"ClassContent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleExternalDefinition1572); 

                	newLeafNode(otherlv_4, grammarAccess.getExternalDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalDefinition"


    // $ANTLR start "entryRuleInterfaceDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:687:1: entryRuleInterfaceDefinition returns [EObject current=null] : iv_ruleInterfaceDefinition= ruleInterfaceDefinition EOF ;
    public final EObject entryRuleInterfaceDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:688:2: (iv_ruleInterfaceDefinition= ruleInterfaceDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:689:2: iv_ruleInterfaceDefinition= ruleInterfaceDefinition EOF
            {
             newCompositeNode(grammarAccess.getInterfaceDefinitionRule()); 
            pushFollow(FOLLOW_ruleInterfaceDefinition_in_entryRuleInterfaceDefinition1608);
            iv_ruleInterfaceDefinition=ruleInterfaceDefinition();

            state._fsp--;

             current =iv_ruleInterfaceDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceDefinition1618); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterfaceDefinition"


    // $ANTLR start "ruleInterfaceDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:696:1: ruleInterfaceDefinition returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' ) ;
    public final EObject ruleInterfaceDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_depend_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:699:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:700:1: (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:700:1: (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:700:3: otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleInterfaceDefinition1655); 

                	newLeafNode(otherlv_0, grammarAccess.getInterfaceDefinitionAccess().getInterfaceKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:704:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:705:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:705:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:706:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterfaceDefinition1672); 

            			newLeafNode(lv_name_1_0, grammarAccess.getInterfaceDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInterfaceDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleInterfaceDefinition1689); 

                	newLeafNode(otherlv_2, grammarAccess.getInterfaceDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:726:1: ( (lv_depend_3_0= ruleDepend ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==31) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:727:1: (lv_depend_3_0= ruleDepend )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:727:1: (lv_depend_3_0= ruleDepend )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:728:3: lv_depend_3_0= ruleDepend
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInterfaceDefinitionAccess().getDependDependParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDepend_in_ruleInterfaceDefinition1710);
            	    lv_depend_3_0=ruleDepend();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInterfaceDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"depend",
            	            		lv_depend_3_0, 
            	            		"Depend");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleInterfaceDefinition1723); 

                	newLeafNode(otherlv_4, grammarAccess.getInterfaceDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterfaceDefinition"


    // $ANTLR start "entryRuleAssociationDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:756:1: entryRuleAssociationDefinition returns [EObject current=null] : iv_ruleAssociationDefinition= ruleAssociationDefinition EOF ;
    public final EObject entryRuleAssociationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:757:2: (iv_ruleAssociationDefinition= ruleAssociationDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:758:2: iv_ruleAssociationDefinition= ruleAssociationDefinition EOF
            {
             newCompositeNode(grammarAccess.getAssociationDefinitionRule()); 
            pushFollow(FOLLOW_ruleAssociationDefinition_in_entryRuleAssociationDefinition1759);
            iv_ruleAssociationDefinition=ruleAssociationDefinition();

            state._fsp--;

             current =iv_ruleAssociationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationDefinition1769); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssociationDefinition"


    // $ANTLR start "ruleAssociationDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:765:1: ruleAssociationDefinition returns [EObject current=null] : (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' ) ;
    public final EObject ruleAssociationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_association_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:768:28: ( (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:769:1: (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:769:1: (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:769:3: otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleAssociationDefinition1806); 

                	newLeafNode(otherlv_0, grammarAccess.getAssociationDefinitionAccess().getAssociationKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:773:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:774:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:774:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:775:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociationDefinition1823); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAssociationDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociationDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleAssociationDefinition1840); 

                	newLeafNode(otherlv_2, grammarAccess.getAssociationDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:795:1: ( (lv_association_3_0= ruleAssociation ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_INT||LA9_0==51) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:796:1: (lv_association_3_0= ruleAssociation )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:796:1: (lv_association_3_0= ruleAssociation )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:797:3: lv_association_3_0= ruleAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssociationDefinitionAccess().getAssociationAssociationParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssociation_in_ruleAssociationDefinition1861);
            	    lv_association_3_0=ruleAssociation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssociationDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"association",
            	            		lv_association_3_0, 
            	            		"Association");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleAssociationDefinition1874); 

                	newLeafNode(otherlv_4, grammarAccess.getAssociationDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssociationDefinition"


    // $ANTLR start "entryRuleClassContent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:825:1: entryRuleClassContent returns [EObject current=null] : iv_ruleClassContent= ruleClassContent EOF ;
    public final EObject entryRuleClassContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassContent = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:826:2: (iv_ruleClassContent= ruleClassContent EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:827:2: iv_ruleClassContent= ruleClassContent EOF
            {
             newCompositeNode(grammarAccess.getClassContentRule()); 
            pushFollow(FOLLOW_ruleClassContent_in_entryRuleClassContent1910);
            iv_ruleClassContent=ruleClassContent();

            state._fsp--;

             current =iv_ruleClassContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassContent1920); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassContent"


    // $ANTLR start "ruleClassContent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:834:1: ruleClassContent returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine ) ;
    public final EObject ruleClassContent() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Position_1 = null;

        EObject this_SoftwarePattern_2 = null;

        EObject this_Depend_3 = null;

        EObject this_SymmetricReflexiveAssociation_4 = null;

        EObject this_InlineAssociation_5 = null;

        EObject this_StateMachine_6 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:837:28: ( (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:838:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:838:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine )
            int alt10=7;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:839:5: this_Attribute_0= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleClassContent1967);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:849:5: this_Position_1= rulePosition
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getPositionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePosition_in_ruleClassContent1994);
                    this_Position_1=rulePosition();

                    state._fsp--;

                     
                            current = this_Position_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:859:5: this_SoftwarePattern_2= ruleSoftwarePattern
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getSoftwarePatternParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSoftwarePattern_in_ruleClassContent2021);
                    this_SoftwarePattern_2=ruleSoftwarePattern();

                    state._fsp--;

                     
                            current = this_SoftwarePattern_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:869:5: this_Depend_3= ruleDepend
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getDependParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDepend_in_ruleClassContent2048);
                    this_Depend_3=ruleDepend();

                    state._fsp--;

                     
                            current = this_Depend_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:879:5: this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getSymmetricReflexiveAssociationParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleClassContent2075);
                    this_SymmetricReflexiveAssociation_4=ruleSymmetricReflexiveAssociation();

                    state._fsp--;

                     
                            current = this_SymmetricReflexiveAssociation_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:889:5: this_InlineAssociation_5= ruleInlineAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getInlineAssociationParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleInlineAssociation_in_ruleClassContent2102);
                    this_InlineAssociation_5=ruleInlineAssociation();

                    state._fsp--;

                     
                            current = this_InlineAssociation_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:899:5: this_StateMachine_6= ruleStateMachine
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getStateMachineParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleStateMachine_in_ruleClassContent2129);
                    this_StateMachine_6=ruleStateMachine();

                    state._fsp--;

                     
                            current = this_StateMachine_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassContent"


    // $ANTLR start "entryRuleAssociationClassContent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:915:1: entryRuleAssociationClassContent returns [EObject current=null] : iv_ruleAssociationClassContent= ruleAssociationClassContent EOF ;
    public final EObject entryRuleAssociationClassContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationClassContent = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:916:2: (iv_ruleAssociationClassContent= ruleAssociationClassContent EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:917:2: iv_ruleAssociationClassContent= ruleAssociationClassContent EOF
            {
             newCompositeNode(grammarAccess.getAssociationClassContentRule()); 
            pushFollow(FOLLOW_ruleAssociationClassContent_in_entryRuleAssociationClassContent2164);
            iv_ruleAssociationClassContent=ruleAssociationClassContent();

            state._fsp--;

             current =iv_ruleAssociationClassContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationClassContent2174); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssociationClassContent"


    // $ANTLR start "ruleAssociationClassContent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:924:1: ruleAssociationClassContent returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine ) ;
    public final EObject ruleAssociationClassContent() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Position_1 = null;

        EObject this_SoftwarePattern_2 = null;

        EObject this_Depend_3 = null;

        EObject this_SymmetricReflexiveAssociation_4 = null;

        EObject this_InlineAssociation_5 = null;

        EObject this_StateMachine_6 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:927:28: ( (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:928:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:928:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine )
            int alt11=7;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:929:5: this_Attribute_0= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleAssociationClassContent2221);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:939:5: this_Position_1= rulePosition
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getPositionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePosition_in_ruleAssociationClassContent2248);
                    this_Position_1=rulePosition();

                    state._fsp--;

                     
                            current = this_Position_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:949:5: this_SoftwarePattern_2= ruleSoftwarePattern
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getSoftwarePatternParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSoftwarePattern_in_ruleAssociationClassContent2275);
                    this_SoftwarePattern_2=ruleSoftwarePattern();

                    state._fsp--;

                     
                            current = this_SoftwarePattern_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:959:5: this_Depend_3= ruleDepend
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getDependParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDepend_in_ruleAssociationClassContent2302);
                    this_Depend_3=ruleDepend();

                    state._fsp--;

                     
                            current = this_Depend_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:969:5: this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getSymmetricReflexiveAssociationParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleAssociationClassContent2329);
                    this_SymmetricReflexiveAssociation_4=ruleSymmetricReflexiveAssociation();

                    state._fsp--;

                     
                            current = this_SymmetricReflexiveAssociation_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:979:5: this_InlineAssociation_5= ruleInlineAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getInlineAssociationParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleInlineAssociation_in_ruleAssociationClassContent2356);
                    this_InlineAssociation_5=ruleInlineAssociation();

                    state._fsp--;

                     
                            current = this_InlineAssociation_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:989:5: this_StateMachine_6= ruleStateMachine
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getStateMachineParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleStateMachine_in_ruleAssociationClassContent2383);
                    this_StateMachine_6=ruleStateMachine();

                    state._fsp--;

                     
                            current = this_StateMachine_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssociationClassContent"


    // $ANTLR start "entryRuleDepend"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1005:1: entryRuleDepend returns [EObject current=null] : iv_ruleDepend= ruleDepend EOF ;
    public final EObject entryRuleDepend() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDepend = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1006:2: (iv_ruleDepend= ruleDepend EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1007:2: iv_ruleDepend= ruleDepend EOF
            {
             newCompositeNode(grammarAccess.getDependRule()); 
            pushFollow(FOLLOW_ruleDepend_in_entryRuleDepend2418);
            iv_ruleDepend=ruleDepend();

            state._fsp--;

             current =iv_ruleDepend; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDepend2428); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDepend"


    // $ANTLR start "ruleDepend"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1014:1: ruleDepend returns [EObject current=null] : (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' ) ;
    public final EObject ruleDepend() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1017:28: ( (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1018:1: (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1018:1: (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1018:3: otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleDepend2465); 

                	newLeafNode(otherlv_0, grammarAccess.getDependAccess().getDependKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1022:1: ( (lv_name_1_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1023:1: (lv_name_1_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1023:1: (lv_name_1_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1024:3: lv_name_1_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getDependAccess().getNameExtendedIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleDepend2486);
            lv_name_1_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDependRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1040:2: (otherlv_2= '.*' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1040:4: otherlv_2= '.*'
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleDepend2499); 

                        	newLeafNode(otherlv_2, grammarAccess.getDependAccess().getFullStopAsteriskKeyword_2());
                        

                    }
                    break;

            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleDepend2513); 

                	newLeafNode(otherlv_3, grammarAccess.getDependAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDepend"


    // $ANTLR start "entryRuleAssociation"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1056:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1057:2: (iv_ruleAssociation= ruleAssociation EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1058:2: iv_ruleAssociation= ruleAssociation EOF
            {
             newCompositeNode(grammarAccess.getAssociationRule()); 
            pushFollow(FOLLOW_ruleAssociation_in_entryRuleAssociation2549);
            iv_ruleAssociation=ruleAssociation();

            state._fsp--;

             current =iv_ruleAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociation2559); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssociation"


    // $ANTLR start "ruleAssociation"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1065:1: ruleAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' ) ;
    public final EObject ruleAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_type1_1_0=null;
        Token lv_rolename1_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_type2_8_0=null;
        Token lv_rolename2_9_0=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1068:28: ( ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1069:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1069:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1070:5: rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';'
            {
             
                    newCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation2600);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1077:1: ( (lv_type1_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1078:1: (lv_type1_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1078:1: (lv_type1_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1079:3: lv_type1_1_0= RULE_ID
            {
            lv_type1_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2616); 

            			newLeafNode(lv_type1_1_0, grammarAccess.getAssociationAccess().getType1IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type1",
                    		lv_type1_1_0, 
                    		"ID");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1095:2: ( (lv_rolename1_2_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1096:1: (lv_rolename1_2_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1096:1: (lv_rolename1_2_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1097:3: lv_rolename1_2_0= RULE_ID
                    {
                    lv_rolename1_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2638); 

                    			newLeafNode(lv_rolename1_2_0, grammarAccess.getAssociationAccess().getRolename1IDTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssociationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"rolename1",
                            		lv_rolename1_2_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1113:3: (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt14=1;
                }
                break;
            case 34:
                {
                alt14=2;
                }
                break;
            case 35:
                {
                alt14=3;
                }
                break;
            case 36:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1113:5: otherlv_3= '->'
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAssociation2657); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssociationAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1118:7: otherlv_4= '--'
                    {
                    otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleAssociation2675); 

                        	newLeafNode(otherlv_4, grammarAccess.getAssociationAccess().getHyphenMinusHyphenMinusKeyword_3_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1123:7: otherlv_5= '<-'
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleAssociation2693); 

                        	newLeafNode(otherlv_5, grammarAccess.getAssociationAccess().getLessThanSignHyphenMinusKeyword_3_2());
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1128:7: otherlv_6= '><'
                    {
                    otherlv_6=(Token)match(input,36,FOLLOW_36_in_ruleAssociation2711); 

                        	newLeafNode(otherlv_6, grammarAccess.getAssociationAccess().getGreaterThanSignLessThanSignKeyword_3_3());
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_4()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation2728);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1140:1: ( (lv_type2_8_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1141:1: (lv_type2_8_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1141:1: (lv_type2_8_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1142:3: lv_type2_8_0= RULE_ID
            {
            lv_type2_8_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2744); 

            			newLeafNode(lv_type2_8_0, grammarAccess.getAssociationAccess().getType2IDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type2",
                    		lv_type2_8_0, 
                    		"ID");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1158:2: ( (lv_rolename2_9_0= RULE_ID ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1159:1: (lv_rolename2_9_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1159:1: (lv_rolename2_9_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1160:3: lv_rolename2_9_0= RULE_ID
                    {
                    lv_rolename2_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2766); 

                    			newLeafNode(lv_rolename2_9_0, grammarAccess.getAssociationAccess().getRolename2IDTerminalRuleCall_6_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssociationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"rolename2",
                            		lv_rolename2_9_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleAssociation2784); 

                	newLeafNode(otherlv_10, grammarAccess.getAssociationAccess().getSemicolonKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssociation"


    // $ANTLR start "entryRuleSymmetricReflexiveAssociation"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1188:1: entryRuleSymmetricReflexiveAssociation returns [EObject current=null] : iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF ;
    public final EObject entryRuleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymmetricReflexiveAssociation = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1189:2: (iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1190:2: iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF
            {
             newCompositeNode(grammarAccess.getSymmetricReflexiveAssociationRule()); 
            pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation2820);
            iv_ruleSymmetricReflexiveAssociation=ruleSymmetricReflexiveAssociation();

            state._fsp--;

             current =iv_ruleSymmetricReflexiveAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation2830); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSymmetricReflexiveAssociation"


    // $ANTLR start "ruleSymmetricReflexiveAssociation"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1197:1: ruleSymmetricReflexiveAssociation returns [EObject current=null] : ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_rolename_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1200:28: ( ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1201:1: ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1201:1: ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1202:5: rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';'
            {
             
                    newCompositeNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getMultiplicityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation2871);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleSymmetricReflexiveAssociation2882); 

                	newLeafNode(otherlv_1, grammarAccess.getSymmetricReflexiveAssociationAccess().getSelfKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1213:1: ( (lv_rolename_2_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1214:1: (lv_rolename_2_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1214:1: (lv_rolename_2_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1215:3: lv_rolename_2_0= RULE_ID
            {
            lv_rolename_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation2899); 

            			newLeafNode(lv_rolename_2_0, grammarAccess.getSymmetricReflexiveAssociationAccess().getRolenameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSymmetricReflexiveAssociationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"rolename",
                    		lv_rolename_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleSymmetricReflexiveAssociation2916); 

                	newLeafNode(otherlv_3, grammarAccess.getSymmetricReflexiveAssociationAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSymmetricReflexiveAssociation"


    // $ANTLR start "entryRuleInlineAssociation"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1243:1: entryRuleInlineAssociation returns [EObject current=null] : iv_ruleInlineAssociation= ruleInlineAssociation EOF ;
    public final EObject entryRuleInlineAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineAssociation = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1244:2: (iv_ruleInlineAssociation= ruleInlineAssociation EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1245:2: iv_ruleInlineAssociation= ruleInlineAssociation EOF
            {
             newCompositeNode(grammarAccess.getInlineAssociationRule()); 
            pushFollow(FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation2952);
            iv_ruleInlineAssociation=ruleInlineAssociation();

            state._fsp--;

             current =iv_ruleInlineAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineAssociation2962); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInlineAssociation"


    // $ANTLR start "ruleInlineAssociation"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1252:1: ruleInlineAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' ) ;
    public final EObject ruleInlineAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_rolename1_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_type_7_0=null;
        Token lv_rolename2_8_0=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1255:28: ( ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1256:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1256:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1257:5: rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';'
            {
             
                    newCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation3003);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1264:1: ( (lv_rolename1_1_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1265:1: (lv_rolename1_1_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1265:1: (lv_rolename1_1_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1266:3: lv_rolename1_1_0= RULE_ID
                    {
                    lv_rolename1_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3019); 

                    			newLeafNode(lv_rolename1_1_0, grammarAccess.getInlineAssociationAccess().getRolename1IDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInlineAssociationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"rolename1",
                            		lv_rolename1_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1282:3: (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt17=1;
                }
                break;
            case 34:
                {
                alt17=2;
                }
                break;
            case 35:
                {
                alt17=3;
                }
                break;
            case 36:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1282:5: otherlv_2= '->'
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleInlineAssociation3038); 

                        	newLeafNode(otherlv_2, grammarAccess.getInlineAssociationAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1287:7: otherlv_3= '--'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleInlineAssociation3056); 

                        	newLeafNode(otherlv_3, grammarAccess.getInlineAssociationAccess().getHyphenMinusHyphenMinusKeyword_2_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1292:7: otherlv_4= '<-'
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleInlineAssociation3074); 

                        	newLeafNode(otherlv_4, grammarAccess.getInlineAssociationAccess().getLessThanSignHyphenMinusKeyword_2_2());
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1297:7: otherlv_5= '><'
                    {
                    otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleInlineAssociation3092); 

                        	newLeafNode(otherlv_5, grammarAccess.getInlineAssociationAccess().getGreaterThanSignLessThanSignKeyword_2_3());
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_3()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation3109);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1309:1: ( (lv_type_7_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1310:1: (lv_type_7_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1310:1: (lv_type_7_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1311:3: lv_type_7_0= RULE_ID
            {
            lv_type_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3125); 

            			newLeafNode(lv_type_7_0, grammarAccess.getInlineAssociationAccess().getTypeIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInlineAssociationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"type",
                    		lv_type_7_0, 
                    		"ID");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1327:2: ( (lv_rolename2_8_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1328:1: (lv_rolename2_8_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1328:1: (lv_rolename2_8_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1329:3: lv_rolename2_8_0= RULE_ID
                    {
                    lv_rolename2_8_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3147); 

                    			newLeafNode(lv_rolename2_8_0, grammarAccess.getInlineAssociationAccess().getRolename2IDTerminalRuleCall_5_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInlineAssociationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"rolename2",
                            		lv_rolename2_8_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleInlineAssociation3165); 

                	newLeafNode(otherlv_9, grammarAccess.getInlineAssociationAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInlineAssociation"


    // $ANTLR start "entryRuleAssociationClassDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1359:1: entryRuleAssociationClassDefinition returns [EObject current=null] : iv_ruleAssociationClassDefinition= ruleAssociationClassDefinition EOF ;
    public final EObject entryRuleAssociationClassDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationClassDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1360:2: (iv_ruleAssociationClassDefinition= ruleAssociationClassDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1361:2: iv_ruleAssociationClassDefinition= ruleAssociationClassDefinition EOF
            {
             newCompositeNode(grammarAccess.getAssociationClassDefinitionRule()); 
            pushFollow(FOLLOW_ruleAssociationClassDefinition_in_entryRuleAssociationClassDefinition3203);
            iv_ruleAssociationClassDefinition=ruleAssociationClassDefinition();

            state._fsp--;

             current =iv_ruleAssociationClassDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationClassDefinition3213); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssociationClassDefinition"


    // $ANTLR start "ruleAssociationClassDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1368:1: ruleAssociationClassDefinition returns [EObject current=null] : (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' ) ;
    public final EObject ruleAssociationClassDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_associationClassContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1371:28: ( (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1372:1: (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1372:1: (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1372:3: otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleAssociationClassDefinition3250); 

                	newLeafNode(otherlv_0, grammarAccess.getAssociationClassDefinitionAccess().getAssociationClassKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1376:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1377:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1377:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1378:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociationClassDefinition3267); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAssociationClassDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociationClassDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleAssociationClassDefinition3284); 

                	newLeafNode(otherlv_2, grammarAccess.getAssociationClassDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1398:1: ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_INT)||LA19_0==31||LA19_0==39||(LA19_0>=41 && LA19_0<=46)||LA19_0==51||(LA19_0>=62 && LA19_0<=74)||(LA19_0>=108 && LA19_0<=112)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1399:1: (lv_associationClassContent_3_0= ruleAssociationClassContent )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1399:1: (lv_associationClassContent_3_0= ruleAssociationClassContent )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1400:3: lv_associationClassContent_3_0= ruleAssociationClassContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssociationClassDefinitionAccess().getAssociationClassContentAssociationClassContentParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssociationClassContent_in_ruleAssociationClassDefinition3305);
            	    lv_associationClassContent_3_0=ruleAssociationClassContent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssociationClassDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"associationClassContent",
            	            		lv_associationClassContent_3_0, 
            	            		"AssociationClassContent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleAssociationClassDefinition3318); 

                	newLeafNode(otherlv_4, grammarAccess.getAssociationClassDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssociationClassDefinition"


    // $ANTLR start "entryRuleSoftwarePattern"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1428:1: entryRuleSoftwarePattern returns [EObject current=null] : iv_ruleSoftwarePattern= ruleSoftwarePattern EOF ;
    public final EObject entryRuleSoftwarePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftwarePattern = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1429:2: (iv_ruleSoftwarePattern= ruleSoftwarePattern EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1430:2: iv_ruleSoftwarePattern= ruleSoftwarePattern EOF
            {
             newCompositeNode(grammarAccess.getSoftwarePatternRule()); 
            pushFollow(FOLLOW_ruleSoftwarePattern_in_entryRuleSoftwarePattern3354);
            iv_ruleSoftwarePattern=ruleSoftwarePattern();

            state._fsp--;

             current =iv_ruleSoftwarePattern; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSoftwarePattern3364); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoftwarePattern"


    // $ANTLR start "ruleSoftwarePattern"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1437:1: ruleSoftwarePattern returns [EObject current=null] : (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection ) ;
    public final EObject ruleSoftwarePattern() throws RecognitionException {
        EObject current = null;

        EObject this_isA_0 = null;

        EObject this_Singleton_1 = null;

        EObject this_KeyDefinition_2 = null;

        EObject this_CodeInjection_3 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1440:28: ( (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1441:1: (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1441:1: (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt20=1;
                }
                break;
            case 41:
                {
                alt20=2;
                }
                break;
            case 42:
                {
                alt20=3;
                }
                break;
            case 43:
            case 44:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1442:5: this_isA_0= ruleisA
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getIsAParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleisA_in_ruleSoftwarePattern3411);
                    this_isA_0=ruleisA();

                    state._fsp--;

                     
                            current = this_isA_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1452:5: this_Singleton_1= ruleSingleton
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getSingletonParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSingleton_in_ruleSoftwarePattern3438);
                    this_Singleton_1=ruleSingleton();

                    state._fsp--;

                     
                            current = this_Singleton_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1462:5: this_KeyDefinition_2= ruleKeyDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getKeyDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleKeyDefinition_in_ruleSoftwarePattern3465);
                    this_KeyDefinition_2=ruleKeyDefinition();

                    state._fsp--;

                     
                            current = this_KeyDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1472:5: this_CodeInjection_3= ruleCodeInjection
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getCodeInjectionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCodeInjection_in_ruleSoftwarePattern3492);
                    this_CodeInjection_3=ruleCodeInjection();

                    state._fsp--;

                     
                            current = this_CodeInjection_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoftwarePattern"


    // $ANTLR start "entryRuleisA"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1488:1: entryRuleisA returns [EObject current=null] : iv_ruleisA= ruleisA EOF ;
    public final EObject entryRuleisA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleisA = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1489:2: (iv_ruleisA= ruleisA EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1490:2: iv_ruleisA= ruleisA EOF
            {
             newCompositeNode(grammarAccess.getIsARule()); 
            pushFollow(FOLLOW_ruleisA_in_entryRuleisA3527);
            iv_ruleisA=ruleisA();

            state._fsp--;

             current =iv_ruleisA; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleisA3537); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleisA"


    // $ANTLR start "ruleisA"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1497:1: ruleisA returns [EObject current=null] : (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleisA() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1500:28: ( (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1501:1: (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1501:1: (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1501:3: otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleisA3574); 

                	newLeafNode(otherlv_0, grammarAccess.getIsAAccess().getIsAKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1505:1: ( (otherlv_1= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1506:1: (otherlv_1= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1506:1: (otherlv_1= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1507:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getIsARule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleisA3594); 

            		newLeafNode(otherlv_1, grammarAccess.getIsAAccess().getExtendsClassUmpleElementCrossReference_1_0()); 
            	

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1518:2: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==40) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1518:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleisA3607); 

            	        	newLeafNode(otherlv_2, grammarAccess.getIsAAccess().getCommaKeyword_2_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1522:1: ( (otherlv_3= RULE_ID ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1523:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1523:1: (otherlv_3= RULE_ID )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1524:3: otherlv_3= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getIsARule());
            	    	        }
            	            
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleisA3627); 

            	    		newLeafNode(otherlv_3, grammarAccess.getIsAAccess().getExtendsClassUmpleElementCrossReference_2_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleisA3641); 

                	newLeafNode(otherlv_4, grammarAccess.getIsAAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleisA"


    // $ANTLR start "entryRuleSingleton"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1547:1: entryRuleSingleton returns [EObject current=null] : iv_ruleSingleton= ruleSingleton EOF ;
    public final EObject entryRuleSingleton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleton = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1548:2: (iv_ruleSingleton= ruleSingleton EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1549:2: iv_ruleSingleton= ruleSingleton EOF
            {
             newCompositeNode(grammarAccess.getSingletonRule()); 
            pushFollow(FOLLOW_ruleSingleton_in_entryRuleSingleton3677);
            iv_ruleSingleton=ruleSingleton();

            state._fsp--;

             current =iv_ruleSingleton; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleton3687); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleton"


    // $ANTLR start "ruleSingleton"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1556:1: ruleSingleton returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' ) ;
    public final EObject ruleSingleton() throws RecognitionException {
        EObject current = null;

        Token lv_singleton_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1559:28: ( ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1560:1: ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1560:1: ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1560:2: ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1560:2: ( (lv_singleton_0_0= 'singleton' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1561:1: (lv_singleton_0_0= 'singleton' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1561:1: (lv_singleton_0_0= 'singleton' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1562:3: lv_singleton_0_0= 'singleton'
            {
            lv_singleton_0_0=(Token)match(input,41,FOLLOW_41_in_ruleSingleton3730); 

                    newLeafNode(lv_singleton_0_0, grammarAccess.getSingletonAccess().getSingletonSingletonKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSingletonRule());
            	        }
                   		setWithLastConsumed(current, "singleton", true, "singleton");
            	    

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleSingleton3755); 

                	newLeafNode(otherlv_1, grammarAccess.getSingletonAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleton"


    // $ANTLR start "entryRuleKeyDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1587:1: entryRuleKeyDefinition returns [EObject current=null] : iv_ruleKeyDefinition= ruleKeyDefinition EOF ;
    public final EObject entryRuleKeyDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1588:2: (iv_ruleKeyDefinition= ruleKeyDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1589:2: iv_ruleKeyDefinition= ruleKeyDefinition EOF
            {
             newCompositeNode(grammarAccess.getKeyDefinitionRule()); 
            pushFollow(FOLLOW_ruleKeyDefinition_in_entryRuleKeyDefinition3791);
            iv_ruleKeyDefinition=ruleKeyDefinition();

            state._fsp--;

             current =iv_ruleKeyDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyDefinition3801); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyDefinition"


    // $ANTLR start "ruleKeyDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1596:1: ruleKeyDefinition returns [EObject current=null] : (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleKeyDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_keys_3_0=null;
        Token otherlv_4=null;
        Token lv_keys_5_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1599:28: ( (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1600:1: (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1600:1: (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1600:3: otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleKeyDefinition3838); 

                	newLeafNode(otherlv_0, grammarAccess.getKeyDefinitionAccess().getKeyKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1604:1: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1605:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getKeyDefinitionAccess().getKeyAction_1(),
                        current);
                

            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleKeyDefinition3859); 

                	newLeafNode(otherlv_2, grammarAccess.getKeyDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1614:1: ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1614:2: ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1614:2: ( (lv_keys_3_0= RULE_ID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1615:1: (lv_keys_3_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1615:1: (lv_keys_3_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1616:3: lv_keys_3_0= RULE_ID
                    {
                    lv_keys_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyDefinition3877); 

                    			newLeafNode(lv_keys_3_0, grammarAccess.getKeyDefinitionAccess().getKeysIDTerminalRuleCall_3_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeyDefinitionRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"keys",
                            		lv_keys_3_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1632:2: (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==40) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1632:4: otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleKeyDefinition3895); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getKeyDefinitionAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1636:1: ( (lv_keys_5_0= RULE_ID ) )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1637:1: (lv_keys_5_0= RULE_ID )
                    	    {
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1637:1: (lv_keys_5_0= RULE_ID )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1638:3: lv_keys_5_0= RULE_ID
                    	    {
                    	    lv_keys_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyDefinition3912); 

                    	    			newLeafNode(lv_keys_5_0, grammarAccess.getKeyDefinitionAccess().getKeysIDTerminalRuleCall_3_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getKeyDefinitionRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"keys",
                    	            		lv_keys_5_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleKeyDefinition3933); 

                	newLeafNode(otherlv_6, grammarAccess.getKeyDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyDefinition"


    // $ANTLR start "entryRuleCodeInjection"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1666:1: entryRuleCodeInjection returns [EObject current=null] : iv_ruleCodeInjection= ruleCodeInjection EOF ;
    public final EObject entryRuleCodeInjection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeInjection = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1667:2: (iv_ruleCodeInjection= ruleCodeInjection EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1668:2: iv_ruleCodeInjection= ruleCodeInjection EOF
            {
             newCompositeNode(grammarAccess.getCodeInjectionRule()); 
            pushFollow(FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection3969);
            iv_ruleCodeInjection=ruleCodeInjection();

            state._fsp--;

             current =iv_ruleCodeInjection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodeInjection3979); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCodeInjection"


    // $ANTLR start "ruleCodeInjection"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1675:1: ruleCodeInjection returns [EObject current=null] : ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleCodeInjection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_code_2_0=null;
        Token otherlv_3=null;
        Token lv_code_5_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1678:28: ( ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1679:1: ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1679:1: ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==43) ) {
                alt24=1;
            }
            else if ( (LA24_0==44) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1679:2: (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1679:2: (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1679:4: otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleCodeInjection4017); 

                        	newLeafNode(otherlv_0, grammarAccess.getCodeInjectionAccess().getBeforeKeyword_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1683:1: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1684:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1684:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1685:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection4038);
                    lv_name_1_0=ruleextendedID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCodeInjectionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"extendedID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1701:2: ( (lv_code_2_0= RULE_STRING ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1702:1: (lv_code_2_0= RULE_STRING )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1702:1: (lv_code_2_0= RULE_STRING )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1703:3: lv_code_2_0= RULE_STRING
                    {
                    lv_code_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodeInjection4055); 

                    			newLeafNode(lv_code_2_0, grammarAccess.getCodeInjectionAccess().getCodeSTRINGTerminalRuleCall_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCodeInjectionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"code",
                            		lv_code_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1720:6: (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1720:6: (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1720:8: otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleCodeInjection4080); 

                        	newLeafNode(otherlv_3, grammarAccess.getCodeInjectionAccess().getAfterKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1724:1: ( (lv_name_4_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1725:1: (lv_name_4_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1725:1: (lv_name_4_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1726:3: lv_name_4_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection4101);
                    lv_name_4_0=ruleextendedID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCodeInjectionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_4_0, 
                            		"extendedID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1742:2: ( (lv_code_5_0= RULE_STRING ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1743:1: (lv_code_5_0= RULE_STRING )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1743:1: (lv_code_5_0= RULE_STRING )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1744:3: lv_code_5_0= RULE_STRING
                    {
                    lv_code_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodeInjection4118); 

                    			newLeafNode(lv_code_5_0, grammarAccess.getCodeInjectionAccess().getCodeSTRINGTerminalRuleCall_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCodeInjectionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"code",
                            		lv_code_5_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCodeInjection"


    // $ANTLR start "entryRuleAttribute"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1768:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1769:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1770:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute4160);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute4170); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1777:1: ruleAttribute returns [EObject current=null] : ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_autounique_0_0=null;
        Token otherlv_2=null;
        Token lv_unique_3_0=null;
        Token lv_list_6_0=null;
        Token otherlv_7=null;
        Token lv_list_8_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_modifier_4_0 = null;

        AntlrDatatypeRuleToken lv_type_5_0 = null;

        AntlrDatatypeRuleToken lv_name_9_0 = null;

        AntlrDatatypeRuleToken lv_value_11_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1780:28: ( ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==45) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_ID||LA31_0==46||(LA31_0>=64 && LA31_0<=74)||(LA31_0>=108 && LA31_0<=112)) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:3: ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';'
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:3: ( (lv_autounique_0_0= 'autounique' ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1782:1: (lv_autounique_0_0= 'autounique' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1782:1: (lv_autounique_0_0= 'autounique' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1783:3: lv_autounique_0_0= 'autounique'
                    {
                    lv_autounique_0_0=(Token)match(input,45,FOLLOW_45_in_ruleAttribute4214); 

                            newLeafNode(lv_autounique_0_0, grammarAccess.getAttributeAccess().getAutouniqueAutouniqueKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "autounique", true, "autounique");
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1796:2: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1797:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1797:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1798:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getNameExtendedIDParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleAttribute4248);
                    lv_name_1_0=ruleextendedID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"extendedID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleAttribute4260); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getSemicolonKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1819:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1819:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1819:7: ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';'
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1819:7: ( (lv_unique_3_0= 'unique' ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==46) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1820:1: (lv_unique_3_0= 'unique' )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1820:1: (lv_unique_3_0= 'unique' )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1821:3: lv_unique_3_0= 'unique'
                            {
                            lv_unique_3_0=(Token)match(input,46,FOLLOW_46_in_ruleAttribute4286); 

                                    newLeafNode(lv_unique_3_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAttributeRule());
                            	        }
                                   		setWithLastConsumed(current, "unique", true, "unique");
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1834:3: ( (lv_modifier_4_0= ruleModifier ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=108 && LA26_0<=112)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1835:1: (lv_modifier_4_0= ruleModifier )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1835:1: (lv_modifier_4_0= ruleModifier )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1836:3: lv_modifier_4_0= ruleModifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getModifierModifierEnumRuleCall_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleModifier_in_ruleAttribute4321);
                            lv_modifier_4_0=ruleModifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"modifier",
                                    		lv_modifier_4_0, 
                                    		"Modifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1852:3: ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )?
                    int alt29=3;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=64 && LA29_0<=74)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_ID) ) {
                        int LA29_2 = input.LA(2);

                        if ( (LA29_2==RULE_ID||LA29_2==47) ) {
                            alt29=2;
                        }
                    }
                    switch (alt29) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1852:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1852:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1852:5: ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )?
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1852:5: ( (lv_type_5_0= ruleUmpleAttributeType ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1853:1: (lv_type_5_0= ruleUmpleAttributeType )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1853:1: (lv_type_5_0= ruleUmpleAttributeType )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1854:3: lv_type_5_0= ruleUmpleAttributeType
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getTypeUmpleAttributeTypeParserRuleCall_1_2_0_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUmpleAttributeType_in_ruleAttribute4345);
                            lv_type_5_0=ruleUmpleAttributeType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"type",
                                    		lv_type_5_0, 
                                    		"UmpleAttributeType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1870:2: ( (lv_list_6_0= '[]' ) )?
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0==47) ) {
                                alt27=1;
                            }
                            switch (alt27) {
                                case 1 :
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1871:1: (lv_list_6_0= '[]' )
                                    {
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1871:1: (lv_list_6_0= '[]' )
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1872:3: lv_list_6_0= '[]'
                                    {
                                    lv_list_6_0=(Token)match(input,47,FOLLOW_47_in_ruleAttribute4363); 

                                            newLeafNode(lv_list_6_0, grammarAccess.getAttributeAccess().getListLeftSquareBracketRightSquareBracketKeyword_1_2_0_1_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAttributeRule());
                                    	        }
                                           		setWithLastConsumed(current, "list", true, "[]");
                                    	    

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1886:6: ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1886:6: ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1886:7: ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )?
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1886:7: ( (otherlv_7= RULE_ID ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1887:1: (otherlv_7= RULE_ID )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1887:1: (otherlv_7= RULE_ID )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1888:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getAttributeRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute4405); 

                            		newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getObjectClassDefinitionCrossReference_1_2_1_0_0()); 
                            	

                            }


                            }

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1899:2: ( (lv_list_8_0= '[]' ) )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==47) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1900:1: (lv_list_8_0= '[]' )
                                    {
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1900:1: (lv_list_8_0= '[]' )
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1901:3: lv_list_8_0= '[]'
                                    {
                                    lv_list_8_0=(Token)match(input,47,FOLLOW_47_in_ruleAttribute4423); 

                                            newLeafNode(lv_list_8_0, grammarAccess.getAttributeAccess().getListLeftSquareBracketRightSquareBracketKeyword_1_2_1_1_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getAttributeRule());
                                    	        }
                                           		setWithLastConsumed(current, "list", true, "[]");
                                    	    

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1914:6: ( (lv_name_9_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1915:1: (lv_name_9_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1915:1: (lv_name_9_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1916:3: lv_name_9_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getNameExtendedIDParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleAttribute4461);
                    lv_name_9_0=ruleextendedID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_9_0, 
                            		"extendedID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1932:2: (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==48) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1932:4: otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            {
                            otherlv_10=(Token)match(input,48,FOLLOW_48_in_ruleAttribute4474); 

                                	newLeafNode(otherlv_10, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1_4_0());
                                
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1936:1: ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1937:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1937:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1938:3: lv_value_11_0= ruleUmplePrimitiveType
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getValueUmplePrimitiveTypeParserRuleCall_1_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_ruleAttribute4495);
                            lv_value_11_0=ruleUmplePrimitiveType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_11_0, 
                                    		"UmplePrimitiveType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,20,FOLLOW_20_in_ruleAttribute4509); 

                        	newLeafNode(otherlv_12, grammarAccess.getAttributeAccess().getSemicolonKeyword_1_5());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleStateMachineDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1966:1: entryRuleStateMachineDefinition returns [EObject current=null] : iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF ;
    public final EObject entryRuleStateMachineDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachineDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1967:2: (iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1968:2: iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF
            {
             newCompositeNode(grammarAccess.getStateMachineDefinitionRule()); 
            pushFollow(FOLLOW_ruleStateMachineDefinition_in_entryRuleStateMachineDefinition4546);
            iv_ruleStateMachineDefinition=ruleStateMachineDefinition();

            state._fsp--;

             current =iv_ruleStateMachineDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachineDefinition4556); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateMachineDefinition"


    // $ANTLR start "ruleStateMachineDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1975:1: ruleStateMachineDefinition returns [EObject current=null] : (otherlv_0= 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= '{' ( (lv_states_3_0= ruleState ) ) otherlv_4= '}' ) ;
    public final EObject ruleStateMachineDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_states_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1978:28: ( (otherlv_0= 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= '{' ( (lv_states_3_0= ruleState ) ) otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1979:1: (otherlv_0= 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= '{' ( (lv_states_3_0= ruleState ) ) otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1979:1: (otherlv_0= 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= '{' ( (lv_states_3_0= ruleState ) ) otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1979:3: otherlv_0= 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= '{' ( (lv_states_3_0= ruleState ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleStateMachineDefinition4593); 

                	newLeafNode(otherlv_0, grammarAccess.getStateMachineDefinitionAccess().getStatemachineKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1983:1: ( (lv_name_1_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1984:1: (lv_name_1_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1984:1: (lv_name_1_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1985:3: lv_name_1_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getStateMachineDefinitionAccess().getNameExtendedIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleStateMachineDefinition4614);
            lv_name_1_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStateMachineDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleStateMachineDefinition4626); 

                	newLeafNode(otherlv_2, grammarAccess.getStateMachineDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2005:1: ( (lv_states_3_0= ruleState ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2006:1: (lv_states_3_0= ruleState )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2006:1: (lv_states_3_0= ruleState )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2007:3: lv_states_3_0= ruleState
            {
             
            	        newCompositeNode(grammarAccess.getStateMachineDefinitionAccess().getStatesStateParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleState_in_ruleStateMachineDefinition4647);
            lv_states_3_0=ruleState();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStateMachineDefinitionRule());
            	        }
                   		add(
                   			current, 
                   			"states",
                    		lv_states_3_0, 
                    		"State");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleStateMachineDefinition4659); 

                	newLeafNode(otherlv_4, grammarAccess.getStateMachineDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachineDefinition"


    // $ANTLR start "entryRuleStateMachine"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2035:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2036:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2037:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine4695);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine4705); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateMachine"


    // $ANTLR start "ruleStateMachine"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2044:1: ruleStateMachine returns [EObject current=null] : (this_Enum_0= ruleEnum | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject this_Enum_0 = null;

        EObject this_InlineStateMachine_1 = null;

        EObject this_ReferencedStateMachine_2 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2047:28: ( (this_Enum_0= ruleEnum | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2048:1: (this_Enum_0= ruleEnum | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2048:1: (this_Enum_0= ruleEnum | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )
            int alt32=3;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2049:5: this_Enum_0= ruleEnum
                    {
                     
                            newCompositeNode(grammarAccess.getStateMachineAccess().getEnumParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEnum_in_ruleStateMachine4752);
                    this_Enum_0=ruleEnum();

                    state._fsp--;

                     
                            current = this_Enum_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2059:5: this_InlineStateMachine_1= ruleInlineStateMachine
                    {
                     
                            newCompositeNode(grammarAccess.getStateMachineAccess().getInlineStateMachineParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInlineStateMachine_in_ruleStateMachine4779);
                    this_InlineStateMachine_1=ruleInlineStateMachine();

                    state._fsp--;

                     
                            current = this_InlineStateMachine_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2069:5: this_ReferencedStateMachine_2= ruleReferencedStateMachine
                    {
                     
                            newCompositeNode(grammarAccess.getStateMachineAccess().getReferencedStateMachineParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleReferencedStateMachine_in_ruleStateMachine4806);
                    this_ReferencedStateMachine_2=ruleReferencedStateMachine();

                    state._fsp--;

                     
                            current = this_ReferencedStateMachine_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachine"


    // $ANTLR start "entryRuleInlineStateMachine"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2085:1: entryRuleInlineStateMachine returns [EObject current=null] : iv_ruleInlineStateMachine= ruleInlineStateMachine EOF ;
    public final EObject entryRuleInlineStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineStateMachine = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2086:2: (iv_ruleInlineStateMachine= ruleInlineStateMachine EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2087:2: iv_ruleInlineStateMachine= ruleInlineStateMachine EOF
            {
             newCompositeNode(grammarAccess.getInlineStateMachineRule()); 
            pushFollow(FOLLOW_ruleInlineStateMachine_in_entryRuleInlineStateMachine4841);
            iv_ruleInlineStateMachine=ruleInlineStateMachine();

            state._fsp--;

             current =iv_ruleInlineStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineStateMachine4851); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInlineStateMachine"


    // $ANTLR start "ruleInlineStateMachine"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2094:1: ruleInlineStateMachine returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleState ) ) otherlv_3= '}' ) ;
    public final EObject ruleInlineStateMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_states_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2097:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleState ) ) otherlv_3= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2098:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleState ) ) otherlv_3= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2098:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleState ) ) otherlv_3= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2098:2: ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleState ) ) otherlv_3= '}'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2098:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2099:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2099:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2100:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getInlineStateMachineAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleInlineStateMachine4897);
            lv_name_0_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInlineStateMachineRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleInlineStateMachine4909); 

                	newLeafNode(otherlv_1, grammarAccess.getInlineStateMachineAccess().getLeftCurlyBracketKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2120:1: ( (lv_states_2_0= ruleState ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2121:1: (lv_states_2_0= ruleState )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2121:1: (lv_states_2_0= ruleState )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2122:3: lv_states_2_0= ruleState
            {
             
            	        newCompositeNode(grammarAccess.getInlineStateMachineAccess().getStatesStateParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleState_in_ruleInlineStateMachine4930);
            lv_states_2_0=ruleState();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInlineStateMachineRule());
            	        }
                   		add(
                   			current, 
                   			"states",
                    		lv_states_2_0, 
                    		"State");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleInlineStateMachine4942); 

                	newLeafNode(otherlv_3, grammarAccess.getInlineStateMachineAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInlineStateMachine"


    // $ANTLR start "entryRuleReferencedStateMachine"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2150:1: entryRuleReferencedStateMachine returns [EObject current=null] : iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF ;
    public final EObject entryRuleReferencedStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedStateMachine = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2151:2: (iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2152:2: iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF
            {
             newCompositeNode(grammarAccess.getReferencedStateMachineRule()); 
            pushFollow(FOLLOW_ruleReferencedStateMachine_in_entryRuleReferencedStateMachine4978);
            iv_ruleReferencedStateMachine=ruleReferencedStateMachine();

            state._fsp--;

             current =iv_ruleReferencedStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedStateMachine4988); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferencedStateMachine"


    // $ANTLR start "ruleReferencedStateMachine"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2159:1: ruleReferencedStateMachine returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= 'as' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleReferencedStateMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2162:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= 'as' ( (otherlv_2= RULE_ID ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2163:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= 'as' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2163:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= 'as' ( (otherlv_2= RULE_ID ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2163:2: ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= 'as' ( (otherlv_2= RULE_ID ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2163:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2164:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2164:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2165:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getReferencedStateMachineAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleReferencedStateMachine5034);
            lv_name_0_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferencedStateMachineRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleReferencedStateMachine5046); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencedStateMachineAccess().getAsKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2185:1: ( (otherlv_2= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2186:1: (otherlv_2= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2186:1: (otherlv_2= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2187:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencedStateMachineRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedStateMachine5066); 

            		newLeafNode(otherlv_2, grammarAccess.getReferencedStateMachineAccess().getMachineStateMachineDefinitionCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferencedStateMachine"


    // $ANTLR start "entryRuleEnum"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2206:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2207:2: (iv_ruleEnum= ruleEnum EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2208:2: iv_ruleEnum= ruleEnum EOF
            {
             newCompositeNode(grammarAccess.getEnumRule()); 
            pushFollow(FOLLOW_ruleEnum_in_entryRuleEnum5102);
            iv_ruleEnum=ruleEnum();

            state._fsp--;

             current =iv_ruleEnum; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnum5112); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnum"


    // $ANTLR start "ruleEnum"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2215:1: ruleEnum returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleextendedID ) ) (otherlv_3= ',' ( (lv_states_4_0= ruleextendedID ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_states_2_0 = null;

        AntlrDatatypeRuleToken lv_states_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2218:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleextendedID ) ) (otherlv_3= ',' ( (lv_states_4_0= ruleextendedID ) ) )* otherlv_5= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2219:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleextendedID ) ) (otherlv_3= ',' ( (lv_states_4_0= ruleextendedID ) ) )* otherlv_5= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2219:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleextendedID ) ) (otherlv_3= ',' ( (lv_states_4_0= ruleextendedID ) ) )* otherlv_5= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2219:2: ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (lv_states_2_0= ruleextendedID ) ) (otherlv_3= ',' ( (lv_states_4_0= ruleextendedID ) ) )* otherlv_5= '}'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2219:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2220:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2220:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2221:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getEnumAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleEnum5158);
            lv_name_0_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleEnum5170); 

                	newLeafNode(otherlv_1, grammarAccess.getEnumAccess().getLeftCurlyBracketKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2241:1: ( (lv_states_2_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2242:1: (lv_states_2_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2242:1: (lv_states_2_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2243:3: lv_states_2_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getEnumAccess().getStatesExtendedIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleEnum5191);
            lv_states_2_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnumRule());
            	        }
                   		add(
                   			current, 
                   			"states",
                    		lv_states_2_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2259:2: (otherlv_3= ',' ( (lv_states_4_0= ruleextendedID ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==40) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2259:4: otherlv_3= ',' ( (lv_states_4_0= ruleextendedID ) )
            	    {
            	    otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleEnum5204); 

            	        	newLeafNode(otherlv_3, grammarAccess.getEnumAccess().getCommaKeyword_3_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2263:1: ( (lv_states_4_0= ruleextendedID ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2264:1: (lv_states_4_0= ruleextendedID )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2264:1: (lv_states_4_0= ruleextendedID )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2265:3: lv_states_4_0= ruleextendedID
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEnumAccess().getStatesExtendedIDParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleextendedID_in_ruleEnum5225);
            	    lv_states_4_0=ruleextendedID();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEnumRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_4_0, 
            	            		"extendedID");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleEnum5239); 

                	newLeafNode(otherlv_5, grammarAccess.getEnumAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnum"


    // $ANTLR start "entryRuleState"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2293:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2294:2: (iv_ruleState= ruleState EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2295:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState5275);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState5285); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2302:1: ruleState returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (otherlv_2= '*' )? ( (lv_states_3_0= ruleStateEntity ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_states_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2305:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (otherlv_2= '*' )? ( (lv_states_3_0= ruleStateEntity ) ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2306:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (otherlv_2= '*' )? ( (lv_states_3_0= ruleStateEntity ) ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2306:1: ( ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (otherlv_2= '*' )? ( (lv_states_3_0= ruleStateEntity ) ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2306:2: ( (lv_name_0_0= ruleextendedID ) ) otherlv_1= '{' ( (otherlv_2= '*' )? ( (lv_states_3_0= ruleStateEntity ) ) )* otherlv_4= '}'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2306:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2307:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2307:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2308:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getStateAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleState5331);
            lv_name_0_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStateRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleState5343); 

                	newLeafNode(otherlv_1, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2328:1: ( (otherlv_2= '*' )? ( (lv_states_3_0= ruleStateEntity ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_FALSE)||LA35_0==34||(LA35_0>=51 && LA35_0<=53)||LA35_0==55||(LA35_0>=57 && LA35_0<=60)||(LA35_0>=87 && LA35_0<=88)||(LA35_0>=90 && LA35_0<=92)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2328:2: (otherlv_2= '*' )? ( (lv_states_3_0= ruleStateEntity ) )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2328:2: (otherlv_2= '*' )?
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==51) ) {
            	        alt34=1;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2328:4: otherlv_2= '*'
            	            {
            	            otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleState5357); 

            	                	newLeafNode(otherlv_2, grammarAccess.getStateAccess().getAsteriskKeyword_2_0());
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2332:3: ( (lv_states_3_0= ruleStateEntity ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2333:1: (lv_states_3_0= ruleStateEntity )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2333:1: (lv_states_3_0= ruleStateEntity )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2334:3: lv_states_3_0= ruleStateEntity
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateAccess().getStatesStateEntityParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStateEntity_in_ruleState5380);
            	    lv_states_3_0=ruleStateEntity();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_3_0, 
            	            		"StateEntity");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleState5394); 

                	newLeafNode(otherlv_4, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleStateEntity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2362:1: entryRuleStateEntity returns [EObject current=null] : iv_ruleStateEntity= ruleStateEntity EOF ;
    public final EObject entryRuleStateEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateEntity = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2363:2: (iv_ruleStateEntity= ruleStateEntity EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2364:2: iv_ruleStateEntity= ruleStateEntity EOF
            {
             newCompositeNode(grammarAccess.getStateEntityRule()); 
            pushFollow(FOLLOW_ruleStateEntity_in_entryRuleStateEntity5430);
            iv_ruleStateEntity=ruleStateEntity();

            state._fsp--;

             current =iv_ruleStateEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateEntity5440); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateEntity"


    // $ANTLR start "ruleStateEntity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2371:1: ruleStateEntity returns [EObject current=null] : (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )? ) | this_State_6= ruleState | (this_expression_7= ruleexpression otherlv_8= ';' ) ) ;
    public final EObject ruleStateEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject this_Transition_0 = null;

        EObject this_EntryOrExitAction_1 = null;

        EObject this_Activity_2 = null;

        EObject this_State_6 = null;

        EObject this_expression_7 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2374:28: ( (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )? ) | this_State_6= ruleState | (this_expression_7= ruleexpression otherlv_8= ';' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2375:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )? ) | this_State_6= ruleState | (this_expression_7= ruleexpression otherlv_8= ';' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2375:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )? ) | this_State_6= ruleState | (this_expression_7= ruleexpression otherlv_8= ';' ) )
            int alt37=5;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2376:5: this_Transition_0= ruleTransition
                    {
                     
                            newCompositeNode(grammarAccess.getStateEntityAccess().getTransitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTransition_in_ruleStateEntity5487);
                    this_Transition_0=ruleTransition();

                    state._fsp--;

                     
                            current = this_Transition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2386:5: this_EntryOrExitAction_1= ruleEntryOrExitAction
                    {
                     
                            newCompositeNode(grammarAccess.getStateEntityAccess().getEntryOrExitActionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEntryOrExitAction_in_ruleStateEntity5514);
                    this_EntryOrExitAction_1=ruleEntryOrExitAction();

                    state._fsp--;

                     
                            current = this_EntryOrExitAction_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2395:6: (this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )? )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2395:6: (this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )? )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2396:5: this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )?
                    {
                     
                            newCompositeNode(grammarAccess.getStateEntityAccess().getActivityParserRuleCall_2_0()); 
                        
                    pushFollow(FOLLOW_ruleActivity_in_ruleStateEntity5542);
                    this_Activity_2=ruleActivity();

                    state._fsp--;

                     
                            current = this_Activity_2; 
                            afterParserOrEnumRuleCall();
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2404:1: (otherlv_3= '->' ruleextendedID otherlv_5= ';' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==33) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2404:3: otherlv_3= '->' ruleextendedID otherlv_5= ';'
                            {
                            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleStateEntity5554); 

                                	newLeafNode(otherlv_3, grammarAccess.getStateEntityAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0());
                                
                             
                                    newCompositeNode(grammarAccess.getStateEntityAccess().getExtendedIDParserRuleCall_2_1_1()); 
                                
                            pushFollow(FOLLOW_ruleextendedID_in_ruleStateEntity5570);
                            ruleextendedID();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                
                            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleStateEntity5581); 

                                	newLeafNode(otherlv_5, grammarAccess.getStateEntityAccess().getSemicolonKeyword_2_1_2());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2422:5: this_State_6= ruleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateEntityAccess().getStateParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateEntity5612);
                    this_State_6=ruleState();

                    state._fsp--;

                     
                            current = this_State_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2431:6: (this_expression_7= ruleexpression otherlv_8= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2431:6: (this_expression_7= ruleexpression otherlv_8= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2432:5: this_expression_7= ruleexpression otherlv_8= ';'
                    {
                     
                            newCompositeNode(grammarAccess.getStateEntityAccess().getExpressionParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_ruleexpression_in_ruleStateEntity5640);
                    this_expression_7=ruleexpression();

                    state._fsp--;

                     
                            current = this_expression_7; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleStateEntity5651); 

                        	newLeafNode(otherlv_8, grammarAccess.getStateEntityAccess().getSemicolonKeyword_4_1());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateEntity"


    // $ANTLR start "entryRuleTransition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2452:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2453:2: (iv_ruleTransition= ruleTransition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2454:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition5688);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition5698); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2461:1: ruleTransition returns [EObject current=null] : ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) otherlv_2= '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) otherlv_5= ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? otherlv_8= '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) otherlv_11= ';' ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject this_Guard_0 = null;

        EObject lv_events_1_0 = null;

        EObject lv_a_3_0 = null;

        AntlrDatatypeRuleToken lv_stateName_4_0 = null;

        EObject this_EventDefinition_6 = null;

        EObject lv_g_7_0 = null;

        EObject lv_a_9_0 = null;

        AntlrDatatypeRuleToken lv_stateName_10_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2464:28: ( ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) otherlv_2= '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) otherlv_5= ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? otherlv_8= '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) otherlv_11= ';' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2465:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) otherlv_2= '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) otherlv_5= ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? otherlv_8= '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) otherlv_11= ';' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2465:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) otherlv_2= '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) otherlv_5= ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? otherlv_8= '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) otherlv_11= ';' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==60) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_ID||LA41_0==52||LA41_0==55) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2465:2: (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) otherlv_2= '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) otherlv_5= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2465:2: (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) otherlv_2= '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) otherlv_5= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2466:5: this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) otherlv_2= '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) otherlv_5= ';'
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getGuardParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleGuard_in_ruleTransition5746);
                    this_Guard_0=ruleGuard();

                    state._fsp--;

                     
                            current = this_Guard_0; 
                            afterParserOrEnumRuleCall();
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2474:1: ( (lv_events_1_0= ruleEventDefinition ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2475:1: (lv_events_1_0= ruleEventDefinition )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2475:1: (lv_events_1_0= ruleEventDefinition )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2476:3: lv_events_1_0= ruleEventDefinition
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionAccess().getEventsEventDefinitionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleTransition5766);
                    lv_events_1_0=ruleEventDefinition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	        }
                           		add(
                           			current, 
                           			"events",
                            		lv_events_1_0, 
                            		"EventDefinition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleTransition5778); 

                        	newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0_2());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2496:1: ( (lv_a_3_0= ruleAction ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==56) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2497:1: (lv_a_3_0= ruleAction )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2497:1: (lv_a_3_0= ruleAction )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2498:3: lv_a_3_0= ruleAction
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getAActionParserRuleCall_0_3_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAction_in_ruleTransition5799);
                            lv_a_3_0=ruleAction();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"a",
                                    		lv_a_3_0, 
                                    		"Action");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2514:3: ( (lv_stateName_4_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2515:1: (lv_stateName_4_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2515:1: (lv_stateName_4_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2516:3: lv_stateName_4_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionAccess().getStateNameExtendedIDParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleTransition5821);
                    lv_stateName_4_0=ruleextendedID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"stateName",
                            		lv_stateName_4_0, 
                            		"extendedID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleTransition5833); 

                        	newLeafNode(otherlv_5, grammarAccess.getTransitionAccess().getSemicolonKeyword_0_5());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2537:6: (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? otherlv_8= '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) otherlv_11= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2537:6: (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? otherlv_8= '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) otherlv_11= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2538:5: this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? otherlv_8= '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) otherlv_11= ';'
                    {
                     
                            newCompositeNode(grammarAccess.getTransitionAccess().getEventDefinitionParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleTransition5863);
                    this_EventDefinition_6=ruleEventDefinition();

                    state._fsp--;

                     
                            current = this_EventDefinition_6; 
                            afterParserOrEnumRuleCall();
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2546:1: ( (lv_g_7_0= ruleGuard ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==60) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2547:1: (lv_g_7_0= ruleGuard )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2547:1: (lv_g_7_0= ruleGuard )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2548:3: lv_g_7_0= ruleGuard
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getGGuardParserRuleCall_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleGuard_in_ruleTransition5883);
                            lv_g_7_0=ruleGuard();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"g",
                                    		lv_g_7_0, 
                                    		"Guard");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,33,FOLLOW_33_in_ruleTransition5896); 

                        	newLeafNode(otherlv_8, grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_1_2());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2568:1: ( (lv_a_9_0= ruleAction ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==56) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2569:1: (lv_a_9_0= ruleAction )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2569:1: (lv_a_9_0= ruleAction )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2570:3: lv_a_9_0= ruleAction
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getAActionParserRuleCall_1_3_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAction_in_ruleTransition5917);
                            lv_a_9_0=ruleAction();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"a",
                                    		lv_a_9_0, 
                                    		"Action");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2586:3: ( (lv_stateName_10_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2587:1: (lv_stateName_10_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2587:1: (lv_stateName_10_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2588:3: lv_stateName_10_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionAccess().getStateNameExtendedIDParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleTransition5939);
                    lv_stateName_10_0=ruleextendedID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"stateName",
                            		lv_stateName_10_0, 
                            		"extendedID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,20,FOLLOW_20_in_ruleTransition5951); 

                        	newLeafNode(otherlv_11, grammarAccess.getTransitionAccess().getSemicolonKeyword_1_5());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleEventDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2616:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2617:2: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2618:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
             newCompositeNode(grammarAccess.getEventDefinitionRule()); 
            pushFollow(FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition5988);
            iv_ruleEventDefinition=ruleEventDefinition();

            state._fsp--;

             current =iv_ruleEventDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDefinition5998); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventDefinition"


    // $ANTLR start "ruleEventDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2625:1: ruleEventDefinition returns [EObject current=null] : (this_AfterEveryEvent_0= ruleAfterEveryEvent | this_AfterEvent_1= ruleAfterEvent | this_Event_2= ruleEvent ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_AfterEveryEvent_0 = null;

        EObject this_AfterEvent_1 = null;

        EObject this_Event_2 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2628:28: ( (this_AfterEveryEvent_0= ruleAfterEveryEvent | this_AfterEvent_1= ruleAfterEvent | this_Event_2= ruleEvent ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2629:1: (this_AfterEveryEvent_0= ruleAfterEveryEvent | this_AfterEvent_1= ruleAfterEvent | this_Event_2= ruleEvent )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2629:1: (this_AfterEveryEvent_0= ruleAfterEveryEvent | this_AfterEvent_1= ruleAfterEvent | this_Event_2= ruleEvent )
            int alt42=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt42=1;
                }
                break;
            case 55:
                {
                alt42=2;
                }
                break;
            case RULE_ID:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2630:5: this_AfterEveryEvent_0= ruleAfterEveryEvent
                    {
                     
                            newCompositeNode(grammarAccess.getEventDefinitionAccess().getAfterEveryEventParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAfterEveryEvent_in_ruleEventDefinition6045);
                    this_AfterEveryEvent_0=ruleAfterEveryEvent();

                    state._fsp--;

                     
                            current = this_AfterEveryEvent_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2640:5: this_AfterEvent_1= ruleAfterEvent
                    {
                     
                            newCompositeNode(grammarAccess.getEventDefinitionAccess().getAfterEventParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAfterEvent_in_ruleEventDefinition6072);
                    this_AfterEvent_1=ruleAfterEvent();

                    state._fsp--;

                     
                            current = this_AfterEvent_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2650:5: this_Event_2= ruleEvent
                    {
                     
                            newCompositeNode(grammarAccess.getEventDefinitionAccess().getEventParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleEvent_in_ruleEventDefinition6099);
                    this_Event_2=ruleEvent();

                    state._fsp--;

                     
                            current = this_Event_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventDefinition"


    // $ANTLR start "entryRuleEvent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2666:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2667:2: (iv_ruleEvent= ruleEvent EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2668:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent6134);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent6144); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2675:1: ruleEvent returns [EObject current=null] : ( (lv_name_0_0= ruleextendedID ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2678:28: ( ( (lv_name_0_0= ruleextendedID ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2679:1: ( (lv_name_0_0= ruleextendedID ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2679:1: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2680:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2680:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2681:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getEventAccess().getNameExtendedIDParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleEvent6189);
            lv_name_0_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEventRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleAfterEveryEvent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2705:1: entryRuleAfterEveryEvent returns [EObject current=null] : iv_ruleAfterEveryEvent= ruleAfterEveryEvent EOF ;
    public final EObject entryRuleAfterEveryEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfterEveryEvent = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2706:2: (iv_ruleAfterEveryEvent= ruleAfterEveryEvent EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2707:2: iv_ruleAfterEveryEvent= ruleAfterEveryEvent EOF
            {
             newCompositeNode(grammarAccess.getAfterEveryEventRule()); 
            pushFollow(FOLLOW_ruleAfterEveryEvent_in_entryRuleAfterEveryEvent6224);
            iv_ruleAfterEveryEvent=ruleAfterEveryEvent();

            state._fsp--;

             current =iv_ruleAfterEveryEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAfterEveryEvent6234); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAfterEveryEvent"


    // $ANTLR start "ruleAfterEveryEvent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2714:1: ruleAfterEveryEvent returns [EObject current=null] : (otherlv_0= 'afterEvery' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAfterEveryEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:28: ( (otherlv_0= 'afterEvery' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2718:1: (otherlv_0= 'afterEvery' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2718:1: (otherlv_0= 'afterEvery' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2718:3: otherlv_0= 'afterEvery' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleAfterEveryEvent6271); 

                	newLeafNode(otherlv_0, grammarAccess.getAfterEveryEventAccess().getAfterEveryKeyword_0());
                
            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleAfterEveryEvent6283); 

                	newLeafNode(otherlv_1, grammarAccess.getAfterEveryEventAccess().getLeftParenthesisKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2726:1: ( (lv_name_2_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2727:1: (lv_name_2_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2727:1: (lv_name_2_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2728:3: lv_name_2_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getAfterEveryEventAccess().getNameExtendedIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleAfterEveryEvent6304);
            lv_name_2_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAfterEveryEventRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,54,FOLLOW_54_in_ruleAfterEveryEvent6316); 

                	newLeafNode(otherlv_3, grammarAccess.getAfterEveryEventAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAfterEveryEvent"


    // $ANTLR start "entryRuleAfterEvent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2756:1: entryRuleAfterEvent returns [EObject current=null] : iv_ruleAfterEvent= ruleAfterEvent EOF ;
    public final EObject entryRuleAfterEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfterEvent = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2757:2: (iv_ruleAfterEvent= ruleAfterEvent EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2758:2: iv_ruleAfterEvent= ruleAfterEvent EOF
            {
             newCompositeNode(grammarAccess.getAfterEventRule()); 
            pushFollow(FOLLOW_ruleAfterEvent_in_entryRuleAfterEvent6352);
            iv_ruleAfterEvent=ruleAfterEvent();

            state._fsp--;

             current =iv_ruleAfterEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAfterEvent6362); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAfterEvent"


    // $ANTLR start "ruleAfterEvent"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2765:1: ruleAfterEvent returns [EObject current=null] : (otherlv_0= 'wait' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAfterEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2768:28: ( (otherlv_0= 'wait' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2769:1: (otherlv_0= 'wait' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2769:1: (otherlv_0= 'wait' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2769:3: otherlv_0= 'wait' otherlv_1= '(' ( (lv_name_2_0= ruleextendedID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleAfterEvent6399); 

                	newLeafNode(otherlv_0, grammarAccess.getAfterEventAccess().getWaitKeyword_0());
                
            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleAfterEvent6411); 

                	newLeafNode(otherlv_1, grammarAccess.getAfterEventAccess().getLeftParenthesisKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2777:1: ( (lv_name_2_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2778:1: (lv_name_2_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2778:1: (lv_name_2_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2779:3: lv_name_2_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getAfterEventAccess().getNameExtendedIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleAfterEvent6432);
            lv_name_2_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAfterEventRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,54,FOLLOW_54_in_ruleAfterEvent6444); 

                	newLeafNode(otherlv_3, grammarAccess.getAfterEventAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAfterEvent"


    // $ANTLR start "entryRuleAction"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2807:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2808:2: (iv_ruleAction= ruleAction EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2809:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction6480);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction6490); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2816:1: ruleAction returns [EObject current=null] : (otherlv_0= '/' ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_code_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2819:28: ( (otherlv_0= '/' ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2820:1: (otherlv_0= '/' ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2820:1: (otherlv_0= '/' ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2820:3: otherlv_0= '/' ( (lv_code_1_0= ruleblock ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleAction6527); 

                	newLeafNode(otherlv_0, grammarAccess.getActionAccess().getSolidusKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2824:1: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2825:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2825:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2826:3: lv_code_1_0= ruleblock
            {
             
            	        newCompositeNode(grammarAccess.getActionAccess().getCodeBlockParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleAction6548);
            lv_code_1_0=ruleblock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActionRule());
            	        }
                   		set(
                   			current, 
                   			"code",
                    		lv_code_1_0, 
                    		"block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEntryOrExitAction"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2850:1: entryRuleEntryOrExitAction returns [EObject current=null] : iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF ;
    public final EObject entryRuleEntryOrExitAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryOrExitAction = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2851:2: (iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2852:2: iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF
            {
             newCompositeNode(grammarAccess.getEntryOrExitActionRule()); 
            pushFollow(FOLLOW_ruleEntryOrExitAction_in_entryRuleEntryOrExitAction6584);
            iv_ruleEntryOrExitAction=ruleEntryOrExitAction();

            state._fsp--;

             current =iv_ruleEntryOrExitAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryOrExitAction6594); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntryOrExitAction"


    // $ANTLR start "ruleEntryOrExitAction"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2859:1: ruleEntryOrExitAction returns [EObject current=null] : ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) otherlv_2= '/' ( (lv_actionCode_3_0= ruleblock ) ) ) ;
    public final EObject ruleEntryOrExitAction() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token otherlv_2=null;
        EObject lv_actionCode_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2862:28: ( ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) otherlv_2= '/' ( (lv_actionCode_3_0= ruleblock ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:1: ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) otherlv_2= '/' ( (lv_actionCode_3_0= ruleblock ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:1: ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) otherlv_2= '/' ( (lv_actionCode_3_0= ruleblock ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) otherlv_2= '/' ( (lv_actionCode_3_0= ruleblock ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==57) ) {
                alt43=1;
            }
            else if ( (LA43_0==58) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:3: ( (lv_type_0_0= 'entry' ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:3: ( (lv_type_0_0= 'entry' ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2864:1: (lv_type_0_0= 'entry' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2864:1: (lv_type_0_0= 'entry' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2865:3: lv_type_0_0= 'entry'
                    {
                    lv_type_0_0=(Token)match(input,57,FOLLOW_57_in_ruleEntryOrExitAction6638); 

                            newLeafNode(lv_type_0_0, grammarAccess.getEntryOrExitActionAccess().getTypeEntryKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEntryOrExitActionRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_0_0, "entry");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2879:6: ( (lv_type_1_0= 'exit' ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2879:6: ( (lv_type_1_0= 'exit' ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2880:1: (lv_type_1_0= 'exit' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2880:1: (lv_type_1_0= 'exit' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2881:3: lv_type_1_0= 'exit'
                    {
                    lv_type_1_0=(Token)match(input,58,FOLLOW_58_in_ruleEntryOrExitAction6675); 

                            newLeafNode(lv_type_1_0, grammarAccess.getEntryOrExitActionAccess().getTypeExitKeyword_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEntryOrExitActionRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_1_0, "exit");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleEntryOrExitAction6701); 

                	newLeafNode(otherlv_2, grammarAccess.getEntryOrExitActionAccess().getSolidusKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2898:1: ( (lv_actionCode_3_0= ruleblock ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2899:1: (lv_actionCode_3_0= ruleblock )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2899:1: (lv_actionCode_3_0= ruleblock )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2900:3: lv_actionCode_3_0= ruleblock
            {
             
            	        newCompositeNode(grammarAccess.getEntryOrExitActionAccess().getActionCodeBlockParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleEntryOrExitAction6722);
            lv_actionCode_3_0=ruleblock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEntryOrExitActionRule());
            	        }
                   		set(
                   			current, 
                   			"actionCode",
                    		lv_actionCode_3_0, 
                    		"block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntryOrExitAction"


    // $ANTLR start "entryRuleActivity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2924:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
    public final EObject entryRuleActivity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivity = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2925:2: (iv_ruleActivity= ruleActivity EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2926:2: iv_ruleActivity= ruleActivity EOF
            {
             newCompositeNode(grammarAccess.getActivityRule()); 
            pushFollow(FOLLOW_ruleActivity_in_entryRuleActivity6758);
            iv_ruleActivity=ruleActivity();

            state._fsp--;

             current =iv_ruleActivity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivity6768); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActivity"


    // $ANTLR start "ruleActivity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2933:1: ruleActivity returns [EObject current=null] : (otherlv_0= 'do' otherlv_1= '{' ( (lv_code_2_0= ruleblock ) ) otherlv_3= '}' ) ;
    public final EObject ruleActivity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_code_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2936:28: ( (otherlv_0= 'do' otherlv_1= '{' ( (lv_code_2_0= ruleblock ) ) otherlv_3= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2937:1: (otherlv_0= 'do' otherlv_1= '{' ( (lv_code_2_0= ruleblock ) ) otherlv_3= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2937:1: (otherlv_0= 'do' otherlv_1= '{' ( (lv_code_2_0= ruleblock ) ) otherlv_3= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2937:3: otherlv_0= 'do' otherlv_1= '{' ( (lv_code_2_0= ruleblock ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleActivity6805); 

                	newLeafNode(otherlv_0, grammarAccess.getActivityAccess().getDoKeyword_0());
                
            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleActivity6817); 

                	newLeafNode(otherlv_1, grammarAccess.getActivityAccess().getLeftCurlyBracketKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2945:1: ( (lv_code_2_0= ruleblock ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2946:1: (lv_code_2_0= ruleblock )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2946:1: (lv_code_2_0= ruleblock )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2947:3: lv_code_2_0= ruleblock
            {
             
            	        newCompositeNode(grammarAccess.getActivityAccess().getCodeBlockParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleActivity6838);
            lv_code_2_0=ruleblock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getActivityRule());
            	        }
                   		set(
                   			current, 
                   			"code",
                    		lv_code_2_0, 
                    		"block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleActivity6850); 

                	newLeafNode(otherlv_3, grammarAccess.getActivityAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActivity"


    // $ANTLR start "entryRuleGuard"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2975:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2976:2: (iv_ruleGuard= ruleGuard EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2977:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard6886);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard6896); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2984:1: ruleGuard returns [EObject current=null] : (otherlv_0= '[' this_GuardCode_1= ruleGuardCode otherlv_2= ']' ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_GuardCode_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2987:28: ( (otherlv_0= '[' this_GuardCode_1= ruleGuardCode otherlv_2= ']' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2988:1: (otherlv_0= '[' this_GuardCode_1= ruleGuardCode otherlv_2= ']' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2988:1: (otherlv_0= '[' this_GuardCode_1= ruleGuardCode otherlv_2= ']' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2988:3: otherlv_0= '[' this_GuardCode_1= ruleGuardCode otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleGuard6933); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getLeftSquareBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getGuardAccess().getGuardCodeParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleGuardCode_in_ruleGuard6955);
            this_GuardCode_1=ruleGuardCode();

            state._fsp--;

             
                    current = this_GuardCode_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleGuard6966); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleGuardCode"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3013:1: entryRuleGuardCode returns [EObject current=null] : iv_ruleGuardCode= ruleGuardCode EOF ;
    public final EObject entryRuleGuardCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardCode = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3014:2: (iv_ruleGuardCode= ruleGuardCode EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3015:2: iv_ruleGuardCode= ruleGuardCode EOF
            {
             newCompositeNode(grammarAccess.getGuardCodeRule()); 
            pushFollow(FOLLOW_ruleGuardCode_in_entryRuleGuardCode7002);
            iv_ruleGuardCode=ruleGuardCode();

            state._fsp--;

             current =iv_ruleGuardCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardCode7012); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardCode"


    // $ANTLR start "ruleGuardCode"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3022:1: ruleGuardCode returns [EObject current=null] : this_expression_0= ruleexpression ;
    public final EObject ruleGuardCode() throws RecognitionException {
        EObject current = null;

        EObject this_expression_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3025:28: (this_expression_0= ruleexpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3027:5: this_expression_0= ruleexpression
            {
             
                    newCompositeNode(grammarAccess.getGuardCodeAccess().getExpressionParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleexpression_in_ruleGuardCode7058);
            this_expression_0=ruleexpression();

            state._fsp--;

             
                    current = this_expression_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuardCode"


    // $ANTLR start "entryRulePosition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3043:1: entryRulePosition returns [EObject current=null] : iv_rulePosition= rulePosition EOF ;
    public final EObject entryRulePosition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePosition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3044:2: (iv_rulePosition= rulePosition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3045:2: iv_rulePosition= rulePosition EOF
            {
             newCompositeNode(grammarAccess.getPositionRule()); 
            pushFollow(FOLLOW_rulePosition_in_entryRulePosition7092);
            iv_rulePosition=rulePosition();

            state._fsp--;

             current =iv_rulePosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePosition7102); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePosition"


    // $ANTLR start "rulePosition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3052:1: rulePosition returns [EObject current=null] : (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition ) ;
    public final EObject rulePosition() throws RecognitionException {
        EObject current = null;

        EObject this_AssociationPosition_0 = null;

        EObject this_ElementPosition_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3055:28: ( (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3056:1: (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3056:1: (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==63) ) {
                alt44=1;
            }
            else if ( (LA44_0==62) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3057:5: this_AssociationPosition_0= ruleAssociationPosition
                    {
                     
                            newCompositeNode(grammarAccess.getPositionAccess().getAssociationPositionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAssociationPosition_in_rulePosition7149);
                    this_AssociationPosition_0=ruleAssociationPosition();

                    state._fsp--;

                     
                            current = this_AssociationPosition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3067:5: this_ElementPosition_1= ruleElementPosition
                    {
                     
                            newCompositeNode(grammarAccess.getPositionAccess().getElementPositionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleElementPosition_in_rulePosition7176);
                    this_ElementPosition_1=ruleElementPosition();

                    state._fsp--;

                     
                            current = this_ElementPosition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePosition"


    // $ANTLR start "entryRuleElementPosition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3083:1: entryRuleElementPosition returns [EObject current=null] : iv_ruleElementPosition= ruleElementPosition EOF ;
    public final EObject entryRuleElementPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementPosition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3084:2: (iv_ruleElementPosition= ruleElementPosition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3085:2: iv_ruleElementPosition= ruleElementPosition EOF
            {
             newCompositeNode(grammarAccess.getElementPositionRule()); 
            pushFollow(FOLLOW_ruleElementPosition_in_entryRuleElementPosition7211);
            iv_ruleElementPosition=ruleElementPosition();

            state._fsp--;

             current =iv_ruleElementPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementPosition7221); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementPosition"


    // $ANTLR start "ruleElementPosition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3092:1: ruleElementPosition returns [EObject current=null] : (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' ) ;
    public final EObject ruleElementPosition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_x_1_0=null;
        Token lv_y_2_0=null;
        Token lv_width_3_0=null;
        Token lv_height_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3095:28: ( (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3096:1: (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3096:1: (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3096:3: otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleElementPosition7258); 

                	newLeafNode(otherlv_0, grammarAccess.getElementPositionAccess().getPositionKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3100:1: ( (lv_x_1_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3101:1: (lv_x_1_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3101:1: (lv_x_1_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3102:3: lv_x_1_0= RULE_INT
            {
            lv_x_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition7275); 

            			newLeafNode(lv_x_1_0, grammarAccess.getElementPositionAccess().getXINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementPositionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"x",
                    		lv_x_1_0, 
                    		"INT");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3118:2: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3119:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3119:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3120:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition7297); 

            			newLeafNode(lv_y_2_0, grammarAccess.getElementPositionAccess().getYINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementPositionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"y",
                    		lv_y_2_0, 
                    		"INT");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3136:2: ( (lv_width_3_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3137:1: (lv_width_3_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3137:1: (lv_width_3_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3138:3: lv_width_3_0= RULE_INT
            {
            lv_width_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition7319); 

            			newLeafNode(lv_width_3_0, grammarAccess.getElementPositionAccess().getWidthINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementPositionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"width",
                    		lv_width_3_0, 
                    		"INT");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3154:2: ( (lv_height_4_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3155:1: (lv_height_4_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3155:1: (lv_height_4_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3156:3: lv_height_4_0= RULE_INT
            {
            lv_height_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition7341); 

            			newLeafNode(lv_height_4_0, grammarAccess.getElementPositionAccess().getHeightINTTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementPositionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"height",
                    		lv_height_4_0, 
                    		"INT");
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleElementPosition7358); 

                	newLeafNode(otherlv_5, grammarAccess.getElementPositionAccess().getSemicolonKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElementPosition"


    // $ANTLR start "entryRuleAssociationPosition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3184:1: entryRuleAssociationPosition returns [EObject current=null] : iv_ruleAssociationPosition= ruleAssociationPosition EOF ;
    public final EObject entryRuleAssociationPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationPosition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:2: (iv_ruleAssociationPosition= ruleAssociationPosition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3186:2: iv_ruleAssociationPosition= ruleAssociationPosition EOF
            {
             newCompositeNode(grammarAccess.getAssociationPositionRule()); 
            pushFollow(FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition7394);
            iv_ruleAssociationPosition=ruleAssociationPosition();

            state._fsp--;

             current =iv_ruleAssociationPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationPosition7404); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssociationPosition"


    // $ANTLR start "ruleAssociationPosition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3193:1: ruleAssociationPosition returns [EObject current=null] : (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' ) ;
    public final EObject ruleAssociationPosition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        EObject lv_c1_2_0 = null;

        EObject lv_c2_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3196:28: ( (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3197:1: (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3197:1: (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3197:3: otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleAssociationPosition7441); 

                	newLeafNode(otherlv_0, grammarAccess.getAssociationPositionAccess().getPositionAssociationKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3201:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3202:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3202:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3203:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociationPosition7458); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAssociationPositionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssociationPositionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3219:2: ( (lv_c1_2_0= ruleCoordinate ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3220:1: (lv_c1_2_0= ruleCoordinate )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3220:1: (lv_c1_2_0= ruleCoordinate )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3221:3: lv_c1_2_0= ruleCoordinate
            {
             
            	        newCompositeNode(grammarAccess.getAssociationPositionAccess().getC1CoordinateParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition7484);
            lv_c1_2_0=ruleCoordinate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssociationPositionRule());
            	        }
                   		set(
                   			current, 
                   			"c1",
                    		lv_c1_2_0, 
                    		"Coordinate");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3237:2: ( (lv_c2_3_0= ruleCoordinate ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3238:1: (lv_c2_3_0= ruleCoordinate )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3238:1: (lv_c2_3_0= ruleCoordinate )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3239:3: lv_c2_3_0= ruleCoordinate
            {
             
            	        newCompositeNode(grammarAccess.getAssociationPositionAccess().getC2CoordinateParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition7505);
            lv_c2_3_0=ruleCoordinate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssociationPositionRule());
            	        }
                   		set(
                   			current, 
                   			"c2",
                    		lv_c2_3_0, 
                    		"Coordinate");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleAssociationPosition7517); 

                	newLeafNode(otherlv_4, grammarAccess.getAssociationPositionAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssociationPosition"


    // $ANTLR start "entryRuleCoordinate"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3267:1: entryRuleCoordinate returns [EObject current=null] : iv_ruleCoordinate= ruleCoordinate EOF ;
    public final EObject entryRuleCoordinate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinate = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3268:2: (iv_ruleCoordinate= ruleCoordinate EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3269:2: iv_ruleCoordinate= ruleCoordinate EOF
            {
             newCompositeNode(grammarAccess.getCoordinateRule()); 
            pushFollow(FOLLOW_ruleCoordinate_in_entryRuleCoordinate7553);
            iv_ruleCoordinate=ruleCoordinate();

            state._fsp--;

             current =iv_ruleCoordinate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinate7563); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCoordinate"


    // $ANTLR start "ruleCoordinate"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3276:1: ruleCoordinate returns [EObject current=null] : ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) ) ;
    public final EObject ruleCoordinate() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token otherlv_1=null;
        Token lv_y_2_0=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3279:28: ( ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3280:1: ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3280:1: ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3280:2: ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3280:2: ( (lv_x_0_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3281:1: (lv_x_0_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3281:1: (lv_x_0_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3282:3: lv_x_0_0= RULE_INT
            {
            lv_x_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate7605); 

            			newLeafNode(lv_x_0_0, grammarAccess.getCoordinateAccess().getXINTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCoordinateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"x",
                    		lv_x_0_0, 
                    		"INT");
            	    

            }


            }

            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleCoordinate7622); 

                	newLeafNode(otherlv_1, grammarAccess.getCoordinateAccess().getCommaKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3302:1: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3303:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3303:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3304:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate7639); 

            			newLeafNode(lv_y_2_0, grammarAccess.getCoordinateAccess().getYINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCoordinateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"y",
                    		lv_y_2_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCoordinate"


    // $ANTLR start "entryRuleUmpleAttributeType"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3328:1: entryRuleUmpleAttributeType returns [String current=null] : iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF ;
    public final String entryRuleUmpleAttributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmpleAttributeType = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3329:2: (iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3330:2: iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getUmpleAttributeTypeRule()); 
            pushFollow(FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType7681);
            iv_ruleUmpleAttributeType=ruleUmpleAttributeType();

            state._fsp--;

             current =iv_ruleUmpleAttributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAttributeType7692); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUmpleAttributeType"


    // $ANTLR start "ruleUmpleAttributeType"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3337:1: ruleUmpleAttributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleUmpleAttributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3340:28: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3341:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3341:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt45=11;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt45=1;
                }
                break;
            case 65:
                {
                alt45=2;
                }
                break;
            case 66:
                {
                alt45=3;
                }
                break;
            case 67:
                {
                alt45=4;
                }
                break;
            case 68:
                {
                alt45=5;
                }
                break;
            case 69:
                {
                alt45=6;
                }
                break;
            case 70:
                {
                alt45=7;
                }
                break;
            case 71:
                {
                alt45=8;
                }
                break;
            case 72:
                {
                alt45=9;
                }
                break;
            case 73:
                {
                alt45=10;
                }
                break;
            case 74:
                {
                alt45=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3342:2: kw= 'Date'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleUmpleAttributeType7730); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getDateKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3349:2: kw= 'Time'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleUmpleAttributeType7749); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getTimeKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3356:2: kw= 'Double'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleUmpleAttributeType7768); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3363:2: kw= 'double'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleUmpleAttributeType7787); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3370:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleUmpleAttributeType7806); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3377:2: kw= 'integer'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleUmpleAttributeType7825); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3384:2: kw= 'int'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleUmpleAttributeType7844); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getIntKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3391:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleUmpleAttributeType7863); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3398:2: kw= 'boolean'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleUmpleAttributeType7882); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3405:2: kw= 'String'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleUmpleAttributeType7901); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getStringKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3412:2: kw= 'string'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleUmpleAttributeType7920); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getStringKeyword_10()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUmpleAttributeType"


    // $ANTLR start "entryRuleUmplePrimitiveType"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3425:1: entryRuleUmplePrimitiveType returns [String current=null] : iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF ;
    public final String entryRuleUmplePrimitiveType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmplePrimitiveType = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:2: (iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3427:2: iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getUmplePrimitiveTypeRule()); 
            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType7961);
            iv_ruleUmplePrimitiveType=ruleUmplePrimitiveType();

            state._fsp--;

             current =iv_ruleUmplePrimitiveType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmplePrimitiveType7972); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUmplePrimitiveType"


    // $ANTLR start "ruleUmplePrimitiveType"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3434:1: ruleUmplePrimitiveType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleUmplePrimitiveType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_STRING_1=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3437:28: ( (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3438:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3438:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_INT) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_STRING) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3438:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUmplePrimitiveType8012); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getUmplePrimitiveTypeAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3446:10: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType8038); 

                    		current.merge(this_STRING_1);
                        
                     
                        newLeafNode(this_STRING_1, grammarAccess.getUmplePrimitiveTypeAccess().getSTRINGTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUmplePrimitiveType"


    // $ANTLR start "entryRulemultiplicity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3461:1: entryRulemultiplicity returns [String current=null] : iv_rulemultiplicity= rulemultiplicity EOF ;
    public final String entryRulemultiplicity() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulemultiplicity = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3462:2: (iv_rulemultiplicity= rulemultiplicity EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3463:2: iv_rulemultiplicity= rulemultiplicity EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRule()); 
            pushFollow(FOLLOW_rulemultiplicity_in_entryRulemultiplicity8084);
            iv_rulemultiplicity=rulemultiplicity();

            state._fsp--;

             current =iv_rulemultiplicity.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicity8095); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulemultiplicity"


    // $ANTLR start "rulemultiplicity"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3470:1: rulemultiplicity returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) ;
    public final AntlrDatatypeRuleToken rulemultiplicity() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_bound_0 = null;

        AntlrDatatypeRuleToken this_bound_1 = null;

        AntlrDatatypeRuleToken this_bound_3 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3473:28: ( (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3474:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3474:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_INT) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==75) ) {
                    alt47=2;
                }
                else if ( (LA47_1==EOF||LA47_1==RULE_ID||(LA47_1>=33 && LA47_1<=37)) ) {
                    alt47=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA47_0==51) ) {
                int LA47_2 = input.LA(2);

                if ( (LA47_2==EOF||LA47_2==RULE_ID||(LA47_2>=33 && LA47_2<=37)) ) {
                    alt47=1;
                }
                else if ( (LA47_2==75) ) {
                    alt47=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3475:5: this_bound_0= rulebound
                    {
                     
                            newCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity8142);
                    this_bound_0=rulebound();

                    state._fsp--;


                    		current.merge(this_bound_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3486:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3486:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3487:5: this_bound_1= rulebound kw= '..' this_bound_3= rulebound
                    {
                     
                            newCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity8176);
                    this_bound_1=rulebound();

                    state._fsp--;


                    		current.merge(this_bound_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    kw=(Token)match(input,75,FOLLOW_75_in_rulemultiplicity8194); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMultiplicityAccess().getFullStopFullStopKeyword_1_1()); 
                        
                     
                            newCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_2()); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity8216);
                    this_bound_3=rulebound();

                    state._fsp--;


                    		current.merge(this_bound_3);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulemultiplicity"


    // $ANTLR start "entryRulebound"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3522:1: entryRulebound returns [String current=null] : iv_rulebound= rulebound EOF ;
    public final String entryRulebound() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulebound = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3523:2: (iv_rulebound= rulebound EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3524:2: iv_rulebound= rulebound EOF
            {
             newCompositeNode(grammarAccess.getBoundRule()); 
            pushFollow(FOLLOW_rulebound_in_entryRulebound8263);
            iv_rulebound=rulebound();

            state._fsp--;

             current =iv_rulebound.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulebound8274); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebound"


    // $ANTLR start "rulebound"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3531:1: rulebound returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken rulebound() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3534:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3535:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3535:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_INT) ) {
                alt48=1;
            }
            else if ( (LA48_0==51) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3535:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulebound8314); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getBoundAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3544:2: kw= '*'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_rulebound8338); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBoundAccess().getAsteriskKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebound"


    // $ANTLR start "entryRuleblock"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3559:1: entryRuleblock returns [EObject current=null] : iv_ruleblock= ruleblock EOF ;
    public final EObject entryRuleblock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblock = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3560:2: (iv_ruleblock= ruleblock EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3561:2: iv_ruleblock= ruleblock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleblock_in_entryRuleblock8380);
            iv_ruleblock=ruleblock();

            state._fsp--;

             current =iv_ruleblock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblock8390); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleblock"


    // $ANTLR start "ruleblock"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3568:1: ruleblock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_blocks_2_0= ruleblockStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleblock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_blocks_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3571:28: ( ( () otherlv_1= '{' ( (lv_blocks_2_0= ruleblockStatement ) )* otherlv_3= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3572:1: ( () otherlv_1= '{' ( (lv_blocks_2_0= ruleblockStatement ) )* otherlv_3= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3572:1: ( () otherlv_1= '{' ( (lv_blocks_2_0= ruleblockStatement ) )* otherlv_3= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3572:2: () otherlv_1= '{' ( (lv_blocks_2_0= ruleblockStatement ) )* otherlv_3= '}'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3572:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3573:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlockAccess().getBlockAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleblock8436); 

                	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3582:1: ( (lv_blocks_2_0= ruleblockStatement ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_FALSE)||LA49_0==17||LA49_0==20||LA49_0==34||LA49_0==53||(LA49_0>=64 && LA49_0<=74)||(LA49_0>=87 && LA49_0<=88)||(LA49_0>=90 && LA49_0<=92)||(LA49_0>=99 && LA49_0<=100)||(LA49_0>=102 && LA49_0<=105)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3583:1: (lv_blocks_2_0= ruleblockStatement )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3583:1: (lv_blocks_2_0= ruleblockStatement )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3584:3: lv_blocks_2_0= ruleblockStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getBlocksBlockStatementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleblockStatement_in_ruleblock8457);
            	    lv_blocks_2_0=ruleblockStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"blocks",
            	            		lv_blocks_2_0, 
            	            		"blockStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleblock8470); 

                	newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleblock"


    // $ANTLR start "entryRuleparExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3612:1: entryRuleparExpression returns [EObject current=null] : iv_ruleparExpression= ruleparExpression EOF ;
    public final EObject entryRuleparExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleparExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3613:2: (iv_ruleparExpression= ruleparExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3614:2: iv_ruleparExpression= ruleparExpression EOF
            {
             newCompositeNode(grammarAccess.getParExpressionRule()); 
            pushFollow(FOLLOW_ruleparExpression_in_entryRuleparExpression8506);
            iv_ruleparExpression=ruleparExpression();

            state._fsp--;

             current =iv_ruleparExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleparExpression8516); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleparExpression"


    // $ANTLR start "ruleparExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3621:1: ruleparExpression returns [EObject current=null] : (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' ) ;
    public final EObject ruleparExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_expression_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3624:28: ( (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3625:1: (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3625:1: (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3625:3: otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleparExpression8553); 

                	newLeafNode(otherlv_0, grammarAccess.getParExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParExpressionAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleexpression_in_ruleparExpression8575);
            this_expression_1=ruleexpression();

            state._fsp--;

             
                    current = this_expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleparExpression8586); 

                	newLeafNode(otherlv_2, grammarAccess.getParExpressionAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleparExpression"


    // $ANTLR start "entryRuleassignmentOperator"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3650:1: entryRuleassignmentOperator returns [String current=null] : iv_ruleassignmentOperator= ruleassignmentOperator EOF ;
    public final String entryRuleassignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleassignmentOperator = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3651:2: (iv_ruleassignmentOperator= ruleassignmentOperator EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3652:2: iv_ruleassignmentOperator= ruleassignmentOperator EOF
            {
             newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            pushFollow(FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator8623);
            iv_ruleassignmentOperator=ruleassignmentOperator();

            state._fsp--;

             current =iv_ruleassignmentOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleassignmentOperator8634); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleassignmentOperator"


    // $ANTLR start "ruleassignmentOperator"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3659:1: ruleassignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' | kw= '-=' ) ;
    public final AntlrDatatypeRuleToken ruleassignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3662:28: ( (kw= '=' | kw= '+=' | kw= '-=' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3663:1: (kw= '=' | kw= '+=' | kw= '-=' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3663:1: (kw= '=' | kw= '+=' | kw= '-=' )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt50=1;
                }
                break;
            case 76:
                {
                alt50=2;
                }
                break;
            case 77:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3664:2: kw= '='
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleassignmentOperator8672); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3671:2: kw= '+='
                    {
                    kw=(Token)match(input,76,FOLLOW_76_in_ruleassignmentOperator8691); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3678:2: kw= '-='
                    {
                    kw=(Token)match(input,77,FOLLOW_77_in_ruleassignmentOperator8710); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getHyphenMinusEqualsSignKeyword_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleassignmentOperator"


    // $ANTLR start "entryRuleexpressionList"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3691:1: entryRuleexpressionList returns [EObject current=null] : iv_ruleexpressionList= ruleexpressionList EOF ;
    public final EObject entryRuleexpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpressionList = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3692:2: (iv_ruleexpressionList= ruleexpressionList EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3693:2: iv_ruleexpressionList= ruleexpressionList EOF
            {
             newCompositeNode(grammarAccess.getExpressionListRule()); 
            pushFollow(FOLLOW_ruleexpressionList_in_entryRuleexpressionList8750);
            iv_ruleexpressionList=ruleexpressionList();

            state._fsp--;

             current =iv_ruleexpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpressionList8760); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleexpressionList"


    // $ANTLR start "ruleexpressionList"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3700:1: ruleexpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) ;
    public final EObject ruleexpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3703:28: ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3704:1: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3704:1: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3704:2: ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3704:2: ( (lv_expressions_0_0= ruleexpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3705:1: (lv_expressions_0_0= ruleexpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3705:1: (lv_expressions_0_0= ruleexpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3706:3: lv_expressions_0_0= ruleexpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList8806);
            lv_expressions_0_0=ruleexpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
            	        }
                   		add(
                   			current, 
                   			"expressions",
                    		lv_expressions_0_0, 
                    		"expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3722:2: (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==40) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3722:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleexpressionList8819); 

            	        	newLeafNode(otherlv_1, grammarAccess.getExpressionListAccess().getCommaKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3726:1: ( (lv_expressions_2_0= ruleexpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3727:1: (lv_expressions_2_0= ruleexpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3727:1: (lv_expressions_2_0= ruleexpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3728:3: lv_expressions_2_0= ruleexpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList8840);
            	    lv_expressions_2_0=ruleexpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressions",
            	            		lv_expressions_2_0, 
            	            		"expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleexpressionList"


    // $ANTLR start "entryRuleexpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3752:1: entryRuleexpression returns [EObject current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final EObject entryRuleexpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3753:2: (iv_ruleexpression= ruleexpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3754:2: iv_ruleexpression= ruleexpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleexpression_in_entryRuleexpression8878);
            iv_ruleexpression=ruleexpression();

            state._fsp--;

             current =iv_ruleexpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpression8888); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleexpression"


    // $ANTLR start "ruleexpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3761:1: ruleexpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) ;
    public final EObject ruleexpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3764:28: ( ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3765:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3765:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3765:2: ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3765:2: ( (lv_expression1_0_0= ruleconditionalExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3766:1: (lv_expression1_0_0= ruleconditionalExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3766:1: (lv_expression1_0_0= ruleconditionalExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3767:3: lv_expression1_0_0= ruleconditionalExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getExpression1ConditionalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleconditionalExpression_in_ruleexpression8934);
            lv_expression1_0_0=ruleconditionalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"conditionalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3783:2: ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            int alt52=2;
            switch ( input.LA(1) ) {
                case 48:
                    {
                    alt52=1;
                    }
                    break;
                case 76:
                    {
                    alt52=1;
                    }
                    break;
                case 77:
                    {
                    alt52=1;
                    }
                    break;
            }

            switch (alt52) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3784:5: ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) )
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentOperatorParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleassignmentOperator_in_ruleexpression8951);
                    ruleassignmentOperator();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3791:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3792:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3792:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3793:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleexpression8971);
                    lv_expression2_2_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression2",
                            		lv_expression2_2_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleexpression"


    // $ANTLR start "entryRuleconditionalExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3817:1: entryRuleconditionalExpression returns [EObject current=null] : iv_ruleconditionalExpression= ruleconditionalExpression EOF ;
    public final EObject entryRuleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3818:2: (iv_ruleconditionalExpression= ruleconditionalExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3819:2: iv_ruleconditionalExpression= ruleconditionalExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression9009);
            iv_ruleconditionalExpression=ruleconditionalExpression();

            state._fsp--;

             current =iv_ruleconditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalExpression9019); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleconditionalExpression"


    // $ANTLR start "ruleconditionalExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3826:1: ruleconditionalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) ;
    public final EObject ruleconditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;

        EObject lv_expression3_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3829:28: ( ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3831:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3831:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3832:3: lv_expression1_0_0= ruleconditionalOrExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression1ConditionalOrExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression9065);
            lv_expression1_0_0=ruleconditionalOrExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"conditionalOrExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3848:2: (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==78) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3848:4: otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) )
                    {
                    otherlv_1=(Token)match(input,78,FOLLOW_78_in_ruleconditionalExpression9078); 

                        	newLeafNode(otherlv_1, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3852:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3853:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3853:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3854:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression9099);
                    lv_expression2_2_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression2",
                            		lv_expression2_2_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleconditionalExpression9111); 

                        	newLeafNode(otherlv_3, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3874:1: ( (lv_expression3_4_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3875:1: (lv_expression3_4_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3875:1: (lv_expression3_4_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3876:3: lv_expression3_4_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression3ExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression9132);
                    lv_expression3_4_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression3",
                            		lv_expression3_4_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleconditionalExpression"


    // $ANTLR start "entryRuleconditionalOrExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3900:1: entryRuleconditionalOrExpression returns [EObject current=null] : iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF ;
    public final EObject entryRuleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalOrExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3901:2: (iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3902:2: iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalOrExpressionRule()); 
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression9170);
            iv_ruleconditionalOrExpression=ruleconditionalOrExpression();

            state._fsp--;

             current =iv_ruleconditionalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalOrExpression9180); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleconditionalOrExpression"


    // $ANTLR start "ruleconditionalOrExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3909:1: ruleconditionalOrExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) ;
    public final EObject ruleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3912:28: ( ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3913:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3913:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3913:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3913:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3914:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3914:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3915:3: lv_expression1_0_0= ruleconditionalAndExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpression1ConditionalAndExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression9226);
            lv_expression1_0_0=ruleconditionalAndExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"conditionalAndExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3931:2: (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==79) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3931:4: otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,79,FOLLOW_79_in_ruleconditionalOrExpression9239); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3935:1: ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3936:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3936:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3937:3: lv_expressionRest_2_0= ruleconditionalAndExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpressionRestConditionalAndExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression9260);
            	    lv_expressionRest_2_0=ruleconditionalAndExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionRest",
            	            		lv_expressionRest_2_0, 
            	            		"conditionalAndExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleconditionalOrExpression"


    // $ANTLR start "entryRuleconditionalAndExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3961:1: entryRuleconditionalAndExpression returns [EObject current=null] : iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF ;
    public final EObject entryRuleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalAndExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3962:2: (iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3963:2: iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalAndExpressionRule()); 
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression9298);
            iv_ruleconditionalAndExpression=ruleconditionalAndExpression();

            state._fsp--;

             current =iv_ruleconditionalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalAndExpression9308); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleconditionalAndExpression"


    // $ANTLR start "ruleconditionalAndExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3970:1: ruleconditionalAndExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) ;
    public final EObject ruleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3973:28: ( ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3974:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3974:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3974:2: ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3974:2: ( (lv_expression1_0_0= ruleequalityExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3975:1: (lv_expression1_0_0= ruleequalityExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3975:1: (lv_expression1_0_0= ruleequalityExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3976:3: lv_expression1_0_0= ruleequalityExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpression1EqualityExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression9354);
            lv_expression1_0_0=ruleequalityExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"equalityExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3992:2: (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==80) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3992:4: otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,80,FOLLOW_80_in_ruleconditionalAndExpression9367); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3996:1: ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3997:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3997:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3998:3: lv_expressionRest_2_0= ruleequalityExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpressionRestEqualityExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression9388);
            	    lv_expressionRest_2_0=ruleequalityExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionRest",
            	            		lv_expressionRest_2_0, 
            	            		"equalityExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleconditionalAndExpression"


    // $ANTLR start "entryRuleequalityExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4022:1: entryRuleequalityExpression returns [EObject current=null] : iv_ruleequalityExpression= ruleequalityExpression EOF ;
    public final EObject entryRuleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4023:2: (iv_ruleequalityExpression= ruleequalityExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4024:2: iv_ruleequalityExpression= ruleequalityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression9426);
            iv_ruleequalityExpression=ruleequalityExpression();

            state._fsp--;

             current =iv_ruleequalityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleequalityExpression9436); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleequalityExpression"


    // $ANTLR start "ruleequalityExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4031:1: ruleequalityExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) ;
    public final EObject ruleequalityExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4034:28: ( ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4035:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4035:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4035:2: ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4035:2: ( (lv_expression1_0_0= rulerelationalExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4036:1: (lv_expression1_0_0= rulerelationalExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4036:1: (lv_expression1_0_0= rulerelationalExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4037:3: lv_expression1_0_0= rulerelationalExpression
            {
             
            	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpression1RelationalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression9482);
            lv_expression1_0_0=rulerelationalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"relationalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4053:2: ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=81 && LA57_0<=82)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4053:3: (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4053:3: (otherlv_1= '==' | otherlv_2= '!=' )
            	    int alt56=2;
            	    int LA56_0 = input.LA(1);

            	    if ( (LA56_0==81) ) {
            	        alt56=1;
            	    }
            	    else if ( (LA56_0==82) ) {
            	        alt56=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 56, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt56) {
            	        case 1 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4053:5: otherlv_1= '=='
            	            {
            	            otherlv_1=(Token)match(input,81,FOLLOW_81_in_ruleequalityExpression9496); 

            	                	newLeafNode(otherlv_1, grammarAccess.getEqualityExpressionAccess().getEqualsSignEqualsSignKeyword_1_0_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4058:7: otherlv_2= '!='
            	            {
            	            otherlv_2=(Token)match(input,82,FOLLOW_82_in_ruleequalityExpression9514); 

            	                	newLeafNode(otherlv_2, grammarAccess.getEqualityExpressionAccess().getExclamationMarkEqualsSignKeyword_1_0_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4062:2: ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4063:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4063:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4064:3: lv_expressionRest_3_0= rulerelationalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpressionRestRelationalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression9536);
            	    lv_expressionRest_3_0=rulerelationalExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionRest",
            	            		lv_expressionRest_3_0, 
            	            		"relationalExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleequalityExpression"


    // $ANTLR start "entryRulerelationalExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4088:1: entryRulerelationalExpression returns [EObject current=null] : iv_rulerelationalExpression= rulerelationalExpression EOF ;
    public final EObject entryRulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4089:2: (iv_rulerelationalExpression= rulerelationalExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4090:2: iv_rulerelationalExpression= rulerelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression9574);
            iv_rulerelationalExpression=rulerelationalExpression();

            state._fsp--;

             current =iv_rulerelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalExpression9584); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerelationalExpression"


    // $ANTLR start "rulerelationalExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4097:1: rulerelationalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) ;
    public final EObject rulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4100:28: ( ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4101:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4101:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4101:2: ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4101:2: ( (lv_expression1_0_0= ruleadditiveExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4102:1: (lv_expression1_0_0= ruleadditiveExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4102:1: (lv_expression1_0_0= ruleadditiveExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4103:3: lv_expression1_0_0= ruleadditiveExpression
            {
             
            	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpression1AdditiveExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression9630);
            lv_expression1_0_0=ruleadditiveExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"additiveExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4119:2: ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=83 && LA58_0<=86)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4120:5: rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRelationalOpParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_rulerelationalOp_in_rulerelationalExpression9647);
            	    rulerelationalOp();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4127:1: ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4128:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4128:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4129:3: lv_expressionRest_2_0= ruleadditiveExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpressionRestAdditiveExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression9667);
            	    lv_expressionRest_2_0=ruleadditiveExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionRest",
            	            		lv_expressionRest_2_0, 
            	            		"additiveExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerelationalExpression"


    // $ANTLR start "entryRulerelationalOp"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4153:1: entryRulerelationalOp returns [String current=null] : iv_rulerelationalOp= rulerelationalOp EOF ;
    public final String entryRulerelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerelationalOp = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4154:2: (iv_rulerelationalOp= rulerelationalOp EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4155:2: iv_rulerelationalOp= rulerelationalOp EOF
            {
             newCompositeNode(grammarAccess.getRelationalOpRule()); 
            pushFollow(FOLLOW_rulerelationalOp_in_entryRulerelationalOp9706);
            iv_rulerelationalOp=rulerelationalOp();

            state._fsp--;

             current =iv_rulerelationalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalOp9717); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerelationalOp"


    // $ANTLR start "rulerelationalOp"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4162:1: rulerelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken rulerelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4165:28: ( (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4166:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4166:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            int alt59=4;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt59=1;
                }
                break;
            case 84:
                {
                alt59=2;
                }
                break;
            case 85:
                {
                alt59=3;
                }
                break;
            case 86:
                {
                alt59=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4167:2: kw= '<='
                    {
                    kw=(Token)match(input,83,FOLLOW_83_in_rulerelationalOp9755); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4174:2: kw= '<'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_rulerelationalOp9774); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4181:2: kw= '>='
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_rulerelationalOp9793); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4188:2: kw= '>'
                    {
                    kw=(Token)match(input,86,FOLLOW_86_in_rulerelationalOp9812); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_3()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerelationalOp"


    // $ANTLR start "entryRuleadditiveExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4201:1: entryRuleadditiveExpression returns [EObject current=null] : iv_ruleadditiveExpression= ruleadditiveExpression EOF ;
    public final EObject entryRuleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4202:2: (iv_ruleadditiveExpression= ruleadditiveExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4203:2: iv_ruleadditiveExpression= ruleadditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression9852);
            iv_ruleadditiveExpression=ruleadditiveExpression();

            state._fsp--;

             current =iv_ruleadditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleadditiveExpression9862); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleadditiveExpression"


    // $ANTLR start "ruleadditiveExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4210:1: ruleadditiveExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) ;
    public final EObject ruleadditiveExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4213:28: ( ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4214:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4214:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4214:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4214:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4215:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4215:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4216:3: lv_expression1_0_0= rulemultiplicativeExpression
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpression1MultiplicativeExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression9908);
            lv_expression1_0_0=rulemultiplicativeExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"multiplicativeExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4232:2: ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=87 && LA61_0<=88)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4232:3: (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4232:3: (otherlv_1= '+' | otherlv_2= '-' )
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==87) ) {
            	        alt60=1;
            	    }
            	    else if ( (LA60_0==88) ) {
            	        alt60=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 60, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4232:5: otherlv_1= '+'
            	            {
            	            otherlv_1=(Token)match(input,87,FOLLOW_87_in_ruleadditiveExpression9922); 

            	                	newLeafNode(otherlv_1, grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_0_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4237:7: otherlv_2= '-'
            	            {
            	            otherlv_2=(Token)match(input,88,FOLLOW_88_in_ruleadditiveExpression9940); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditiveExpressionAccess().getHyphenMinusKeyword_1_0_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4241:2: ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4242:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4242:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4243:3: lv_expressionRest_3_0= rulemultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpressionRestMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression9962);
            	    lv_expressionRest_3_0=rulemultiplicativeExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionRest",
            	            		lv_expressionRest_3_0, 
            	            		"multiplicativeExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleadditiveExpression"


    // $ANTLR start "entryRulemultiplicativeExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4267:1: entryRulemultiplicativeExpression returns [EObject current=null] : iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF ;
    public final EObject entryRulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4268:2: (iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4269:2: iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression10000);
            iv_rulemultiplicativeExpression=rulemultiplicativeExpression();

            state._fsp--;

             current =iv_rulemultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicativeExpression10010); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulemultiplicativeExpression"


    // $ANTLR start "rulemultiplicativeExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4276:1: rulemultiplicativeExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) ;
    public final EObject rulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4279:28: ( ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4280:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4280:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4280:2: ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4280:2: ( (lv_expression1_0_0= ruleunaryExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4281:1: (lv_expression1_0_0= ruleunaryExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4281:1: (lv_expression1_0_0= ruleunaryExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4282:3: lv_expression1_0_0= ruleunaryExpression
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpression1UnaryExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression10056);
            lv_expression1_0_0=ruleunaryExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expression1",
                    		lv_expression1_0_0, 
                    		"unaryExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4298:2: ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==51||LA63_0==56||LA63_0==89) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4298:3: (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4298:3: (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' )
            	    int alt62=3;
            	    switch ( input.LA(1) ) {
            	    case 51:
            	        {
            	        alt62=1;
            	        }
            	        break;
            	    case 56:
            	        {
            	        alt62=2;
            	        }
            	        break;
            	    case 89:
            	        {
            	        alt62=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 62, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt62) {
            	        case 1 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4298:5: otherlv_1= '*'
            	            {
            	            otherlv_1=(Token)match(input,51,FOLLOW_51_in_rulemultiplicativeExpression10070); 

            	                	newLeafNode(otherlv_1, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4303:7: otherlv_2= '/'
            	            {
            	            otherlv_2=(Token)match(input,56,FOLLOW_56_in_rulemultiplicativeExpression10088); 

            	                	newLeafNode(otherlv_2, grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_0_1());
            	                

            	            }
            	            break;
            	        case 3 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4308:7: otherlv_3= '%'
            	            {
            	            otherlv_3=(Token)match(input,89,FOLLOW_89_in_rulemultiplicativeExpression10106); 

            	                	newLeafNode(otherlv_3, grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_0_2());
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4312:2: ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4313:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4313:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4314:3: lv_expressionRest_4_0= ruleunaryExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpressionRestUnaryExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression10128);
            	    lv_expressionRest_4_0=ruleunaryExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionRest",
            	            		lv_expressionRest_4_0, 
            	            		"unaryExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulemultiplicativeExpression"


    // $ANTLR start "entryRuleunaryExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4338:1: entryRuleunaryExpression returns [EObject current=null] : iv_ruleunaryExpression= ruleunaryExpression EOF ;
    public final EObject entryRuleunaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4339:2: (iv_ruleunaryExpression= ruleunaryExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4340:2: iv_ruleunaryExpression= ruleunaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression10166);
            iv_ruleunaryExpression=ruleunaryExpression();

            state._fsp--;

             current =iv_ruleunaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpression10176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleunaryExpression"


    // $ANTLR start "ruleunaryExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4347:1: ruleunaryExpression returns [EObject current=null] : ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) ;
    public final EObject ruleunaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_exp1_1_0 = null;

        EObject lv_exp1_3_0 = null;

        EObject lv_exp1_5_0 = null;

        EObject lv_exp1_7_0 = null;

        EObject lv_exp2_8_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4350:28: ( ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4351:1: ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4351:1: ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            int alt64=5;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt64=1;
                }
                break;
            case 88:
                {
                alt64=2;
                }
                break;
            case 90:
                {
                alt64=3;
                }
                break;
            case 34:
                {
                alt64=4;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case RULE_TRUE:
            case RULE_FALSE:
            case 53:
            case 91:
            case 92:
                {
                alt64=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4351:2: (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4351:2: (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4351:4: otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) )
                    {
                    otherlv_0=(Token)match(input,87,FOLLOW_87_in_ruleunaryExpression10214); 

                        	newLeafNode(otherlv_0, grammarAccess.getUnaryExpressionAccess().getPlusSignKeyword_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4355:1: ( (lv_exp1_1_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4356:1: (lv_exp1_1_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4356:1: (lv_exp1_1_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4357:3: lv_exp1_1_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression10235);
                    lv_exp1_1_0=ruleunaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exp1",
                            		lv_exp1_1_0, 
                            		"unaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4374:6: (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4374:6: (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4374:8: otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) )
                    {
                    otherlv_2=(Token)match(input,88,FOLLOW_88_in_ruleunaryExpression10255); 

                        	newLeafNode(otherlv_2, grammarAccess.getUnaryExpressionAccess().getHyphenMinusKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4378:1: ( (lv_exp1_3_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4379:1: (lv_exp1_3_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4379:1: (lv_exp1_3_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4380:3: lv_exp1_3_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression10276);
                    lv_exp1_3_0=ruleunaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exp1",
                            		lv_exp1_3_0, 
                            		"unaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4397:6: (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4397:6: (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4397:8: otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) )
                    {
                    otherlv_4=(Token)match(input,90,FOLLOW_90_in_ruleunaryExpression10296); 

                        	newLeafNode(otherlv_4, grammarAccess.getUnaryExpressionAccess().getPlusSignPlusSignKeyword_2_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4401:1: ( (lv_exp1_5_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4402:1: (lv_exp1_5_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4402:1: (lv_exp1_5_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4403:3: lv_exp1_5_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression10317);
                    lv_exp1_5_0=ruleunaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exp1",
                            		lv_exp1_5_0, 
                            		"unaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4420:6: (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4420:6: (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4420:8: otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) )
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleunaryExpression10337); 

                        	newLeafNode(otherlv_6, grammarAccess.getUnaryExpressionAccess().getHyphenMinusHyphenMinusKeyword_3_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4424:1: ( (lv_exp1_7_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4425:1: (lv_exp1_7_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4425:1: (lv_exp1_7_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4426:3: lv_exp1_7_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression10358);
                    lv_exp1_7_0=ruleunaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exp1",
                            		lv_exp1_7_0, 
                            		"unaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4443:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4443:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4444:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4444:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4445:3: lv_exp2_8_0= ruleunaryExpressionNotPlusMinus
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp2UnaryExpressionNotPlusMinusParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression10386);
                    lv_exp2_8_0=ruleunaryExpressionNotPlusMinus();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exp2",
                            		lv_exp2_8_0, 
                            		"unaryExpressionNotPlusMinus");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleunaryExpression"


    // $ANTLR start "entryRuleunaryExpressionNotPlusMinus"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4469:1: entryRuleunaryExpressionNotPlusMinus returns [EObject current=null] : iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF ;
    public final EObject entryRuleunaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpressionNotPlusMinus = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4470:2: (iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4471:2: iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusRule()); 
            pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus10422);
            iv_ruleunaryExpressionNotPlusMinus=ruleunaryExpressionNotPlusMinus();

            state._fsp--;

             current =iv_ruleunaryExpressionNotPlusMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus10432); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleunaryExpressionNotPlusMinus"


    // $ANTLR start "ruleunaryExpressionNotPlusMinus"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4478:1: ruleunaryExpressionNotPlusMinus returns [EObject current=null] : ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) ) ;
    public final EObject ruleunaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject this_unaryExpression_1 = null;

        EObject this_unaryExpression_3 = null;

        EObject this_primary_4 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4481:28: ( ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4482:1: ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4482:1: ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt66=1;
                }
                break;
            case 92:
                {
                alt66=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case RULE_TRUE:
            case RULE_FALSE:
            case 53:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4482:2: (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4482:2: (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4482:4: otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression
                    {
                    otherlv_0=(Token)match(input,91,FOLLOW_91_in_ruleunaryExpressionNotPlusMinus10470); 

                        	newLeafNode(otherlv_0, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getTildeKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus10492);
                    this_unaryExpression_1=ruleunaryExpression();

                    state._fsp--;

                     
                            current = this_unaryExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4496:6: (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4496:6: (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4496:8: otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression
                    {
                    otherlv_2=(Token)match(input,92,FOLLOW_92_in_ruleunaryExpressionNotPlusMinus10511); 

                        	newLeafNode(otherlv_2, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getExclamationMarkKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus10533);
                    this_unaryExpression_3=ruleunaryExpression();

                    state._fsp--;

                     
                            current = this_unaryExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4510:6: (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4510:6: (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4511:5: this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )?
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPrimaryParserRuleCall_2_0()); 
                        
                    pushFollow(FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus10562);
                    this_primary_4=ruleprimary();

                    state._fsp--;

                     
                            current = this_primary_4; 
                            afterParserOrEnumRuleCall();
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4519:1: (otherlv_5= '++' | otherlv_6= '--' )?
                    int alt65=3;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==90) ) {
                        alt65=1;
                    }
                    else if ( (LA65_0==34) ) {
                        alt65=2;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4519:3: otherlv_5= '++'
                            {
                            otherlv_5=(Token)match(input,90,FOLLOW_90_in_ruleunaryExpressionNotPlusMinus10574); 

                                	newLeafNode(otherlv_5, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPlusSignPlusSignKeyword_2_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4524:7: otherlv_6= '--'
                            {
                            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleunaryExpressionNotPlusMinus10592); 

                                	newLeafNode(otherlv_6, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getHyphenMinusHyphenMinusKeyword_2_1_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleunaryExpressionNotPlusMinus"


    // $ANTLR start "entryRuleprimary"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4536:1: entryRuleprimary returns [EObject current=null] : iv_ruleprimary= ruleprimary EOF ;
    public final EObject entryRuleprimary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimary = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4537:2: (iv_ruleprimary= ruleprimary EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4538:2: iv_ruleprimary= ruleprimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_ruleprimary_in_entryRuleprimary10631);
            iv_ruleprimary=ruleprimary();

            state._fsp--;

             current =iv_ruleprimary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimary10641); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleprimary"


    // $ANTLR start "ruleprimary"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4545:1: ruleprimary returns [EObject current=null] : (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) ;
    public final EObject ruleprimary() throws RecognitionException {
        EObject current = null;

        EObject this_parExpression_0 = null;

        EObject this_literal_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4548:28: ( (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4549:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4549:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==53) ) {
                alt67=1;
            }
            else if ( ((LA67_0>=RULE_STRING && LA67_0<=RULE_FALSE)) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4550:5: this_parExpression_0= ruleparExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getParExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleparExpression_in_ruleprimary10688);
                    this_parExpression_0=ruleparExpression();

                    state._fsp--;

                     
                            current = this_parExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4560:5: this_literal_1= ruleliteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleliteral_in_ruleprimary10715);
                    this_literal_1=ruleliteral();

                    state._fsp--;

                     
                            current = this_literal_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleprimary"


    // $ANTLR start "entryRuleliteral"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4576:1: entryRuleliteral returns [EObject current=null] : iv_ruleliteral= ruleliteral EOF ;
    public final EObject entryRuleliteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleliteral = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4577:2: (iv_ruleliteral= ruleliteral EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4578:2: iv_ruleliteral= ruleliteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleliteral_in_entryRuleliteral10750);
            iv_ruleliteral=ruleliteral();

            state._fsp--;

             current =iv_ruleliteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleliteral10760); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleliteral"


    // $ANTLR start "ruleliteral"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4585:1: ruleliteral returns [EObject current=null] : ( ( () this_INT_1= RULE_INT ) | ( () ruleDOUBLE ) | ( () this_STRING_5= RULE_STRING ) | ( () ruleextendedID ) | this_javaFunctionCall_8= rulejavaFunctionCall | ( () this_TRUE_10= RULE_TRUE ) | ( () this_FALSE_12= RULE_FALSE ) ) ;
    public final EObject ruleliteral() throws RecognitionException {
        EObject current = null;

        Token this_INT_1=null;
        Token this_STRING_5=null;
        Token this_TRUE_10=null;
        Token this_FALSE_12=null;
        EObject this_javaFunctionCall_8 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4588:28: ( ( ( () this_INT_1= RULE_INT ) | ( () ruleDOUBLE ) | ( () this_STRING_5= RULE_STRING ) | ( () ruleextendedID ) | this_javaFunctionCall_8= rulejavaFunctionCall | ( () this_TRUE_10= RULE_TRUE ) | ( () this_FALSE_12= RULE_FALSE ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4589:1: ( ( () this_INT_1= RULE_INT ) | ( () ruleDOUBLE ) | ( () this_STRING_5= RULE_STRING ) | ( () ruleextendedID ) | this_javaFunctionCall_8= rulejavaFunctionCall | ( () this_TRUE_10= RULE_TRUE ) | ( () this_FALSE_12= RULE_FALSE ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4589:1: ( ( () this_INT_1= RULE_INT ) | ( () ruleDOUBLE ) | ( () this_STRING_5= RULE_STRING ) | ( () ruleextendedID ) | this_javaFunctionCall_8= rulejavaFunctionCall | ( () this_TRUE_10= RULE_TRUE ) | ( () this_FALSE_12= RULE_FALSE ) )
            int alt68=7;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4589:2: ( () this_INT_1= RULE_INT )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4589:2: ( () this_INT_1= RULE_INT )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4589:3: () this_INT_1= RULE_INT
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4589:3: ()
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4590:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getLiteralAction_0_0(),
                                current);
                        

                    }

                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleliteral10806); 
                     
                        newLeafNode(this_INT_1, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4600:6: ( () ruleDOUBLE )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4600:6: ( () ruleDOUBLE )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4600:7: () ruleDOUBLE
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4600:7: ()
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4601:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getLiteralAction_1_0(),
                                current);
                        

                    }

                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDOUBLEParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleDOUBLE_in_ruleliteral10838);
                    ruleDOUBLE();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4615:6: ( () this_STRING_5= RULE_STRING )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4615:6: ( () this_STRING_5= RULE_STRING )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4615:7: () this_STRING_5= RULE_STRING
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4615:7: ()
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4616:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getLiteralAction_2_0(),
                                current);
                        

                    }

                    this_STRING_5=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleliteral10865); 
                     
                        newLeafNode(this_STRING_5, grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2_1()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4626:6: ( () ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4626:6: ( () ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4626:7: () ruleextendedID
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4626:7: ()
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4627:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getLiteralAction_3_0(),
                                current);
                        

                    }

                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getExtendedIDParserRuleCall_3_1()); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleliteral10897);
                    ruleextendedID();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4642:5: this_javaFunctionCall_8= rulejavaFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getJavaFunctionCallParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_rulejavaFunctionCall_in_ruleliteral10925);
                    this_javaFunctionCall_8=rulejavaFunctionCall();

                    state._fsp--;

                     
                            current = this_javaFunctionCall_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4651:6: ( () this_TRUE_10= RULE_TRUE )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4651:6: ( () this_TRUE_10= RULE_TRUE )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4651:7: () this_TRUE_10= RULE_TRUE
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4651:7: ()
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4652:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getLiteralAction_5_0(),
                                current);
                        

                    }

                    this_TRUE_10=(Token)match(input,RULE_TRUE,FOLLOW_RULE_TRUE_in_ruleliteral10951); 
                     
                        newLeafNode(this_TRUE_10, grammarAccess.getLiteralAccess().getTRUETerminalRuleCall_5_1()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4662:6: ( () this_FALSE_12= RULE_FALSE )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4662:6: ( () this_FALSE_12= RULE_FALSE )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4662:7: () this_FALSE_12= RULE_FALSE
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4662:7: ()
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4663:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getLiteralAction_6_0(),
                                current);
                        

                    }

                    this_FALSE_12=(Token)match(input,RULE_FALSE,FOLLOW_RULE_FALSE_in_ruleliteral10978); 
                     
                        newLeafNode(this_FALSE_12, grammarAccess.getLiteralAccess().getFALSETerminalRuleCall_6_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleliteral"


    // $ANTLR start "entryRulejavaFunctionDeclaration"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4686:1: entryRulejavaFunctionDeclaration returns [EObject current=null] : iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF ;
    public final EObject entryRulejavaFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDeclaration = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4687:2: (iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4688:2: iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getJavaFunctionDeclarationRule()); 
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration11020);
            iv_rulejavaFunctionDeclaration=rulejavaFunctionDeclaration();

            state._fsp--;

             current =iv_rulejavaFunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDeclaration11030); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulejavaFunctionDeclaration"


    // $ANTLR start "rulejavaFunctionDeclaration"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4695:1: rulejavaFunctionDeclaration returns [EObject current=null] : ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) ) ;
    public final EObject rulejavaFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_referenceType_6_0=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_returnType_4_0 = null;

        AntlrDatatypeRuleToken lv_argList_9_0 = null;

        AntlrDatatypeRuleToken lv_argListID_10_0 = null;

        AntlrDatatypeRuleToken lv_argList_12_0 = null;

        AntlrDatatypeRuleToken lv_argListID_13_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4698:28: ( ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4699:1: ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4699:1: ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4699:2: (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4699:2: (otherlv_0= 'static' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==93) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4699:4: otherlv_0= 'static'
                    {
                    otherlv_0=(Token)match(input,93,FOLLOW_93_in_rulejavaFunctionDeclaration11068); 

                        	newLeafNode(otherlv_0, grammarAccess.getJavaFunctionDeclarationAccess().getStaticKeyword_0());
                        

                    }
                    break;

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4703:3: (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' )
            int alt70=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt70=1;
                }
                break;
            case 95:
                {
                alt70=2;
                }
                break;
            case 96:
                {
                alt70=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4703:5: otherlv_1= 'public'
                    {
                    otherlv_1=(Token)match(input,94,FOLLOW_94_in_rulejavaFunctionDeclaration11083); 

                        	newLeafNode(otherlv_1, grammarAccess.getJavaFunctionDeclarationAccess().getPublicKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4708:7: otherlv_2= 'private'
                    {
                    otherlv_2=(Token)match(input,95,FOLLOW_95_in_rulejavaFunctionDeclaration11101); 

                        	newLeafNode(otherlv_2, grammarAccess.getJavaFunctionDeclarationAccess().getPrivateKeyword_1_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4713:7: otherlv_3= 'protected'
                    {
                    otherlv_3=(Token)match(input,96,FOLLOW_96_in_rulejavaFunctionDeclaration11119); 

                        	newLeafNode(otherlv_3, grammarAccess.getJavaFunctionDeclarationAccess().getProtectedKeyword_1_2());
                        

                    }
                    break;

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4717:2: ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt71=1;
                }
                break;
            case 97:
                {
                alt71=2;
                }
                break;
            case RULE_ID:
                {
                alt71=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4717:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4717:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4718:1: (lv_returnType_4_0= ruleattributeType )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4718:1: (lv_returnType_4_0= ruleattributeType )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4719:3: lv_returnType_4_0= ruleattributeType
                    {
                     
                    	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getReturnTypeAttributeTypeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration11142);
                    lv_returnType_4_0=ruleattributeType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getJavaFunctionDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"returnType",
                            		lv_returnType_4_0, 
                            		"attributeType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4736:7: otherlv_5= 'void'
                    {
                    otherlv_5=(Token)match(input,97,FOLLOW_97_in_rulejavaFunctionDeclaration11160); 

                        	newLeafNode(otherlv_5, grammarAccess.getJavaFunctionDeclarationAccess().getVoidKeyword_2_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4741:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4741:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4742:1: (lv_referenceType_6_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4742:1: (lv_referenceType_6_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4743:3: lv_referenceType_6_0= RULE_ID
                    {
                    lv_referenceType_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration11183); 

                    			newLeafNode(lv_referenceType_6_0, grammarAccess.getJavaFunctionDeclarationAccess().getReferenceTypeIDTerminalRuleCall_2_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getJavaFunctionDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"referenceType",
                            		lv_referenceType_6_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4759:3: ( (lv_name_7_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4760:1: (lv_name_7_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4760:1: (lv_name_7_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4761:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration11206); 

            			newLeafNode(lv_name_7_0, grammarAccess.getJavaFunctionDeclarationAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaFunctionDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_7_0, 
                    		"ID");
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4777:2: ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==53) ) {
                alt74=1;
            }
            else if ( (LA74_0==98) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4777:3: (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4777:3: (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4777:5: otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,53,FOLLOW_53_in_rulejavaFunctionDeclaration11225); 

                        	newLeafNode(otherlv_8, grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisKeyword_4_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4781:1: ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( ((LA73_0>=64 && LA73_0<=74)) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4781:2: ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4781:2: ( (lv_argList_9_0= ruleattributeType ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4782:1: (lv_argList_9_0= ruleattributeType )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4782:1: (lv_argList_9_0= ruleattributeType )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4783:3: lv_argList_9_0= ruleattributeType
                            {
                             
                            	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration11247);
                            lv_argList_9_0=ruleattributeType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getJavaFunctionDeclarationRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"argList",
                                    		lv_argList_9_0, 
                                    		"attributeType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4799:2: ( (lv_argListID_10_0= ruleextendedID ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4800:1: (lv_argListID_10_0= ruleextendedID )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4800:1: (lv_argListID_10_0= ruleextendedID )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4801:3: lv_argListID_10_0= ruleextendedID
                            {
                             
                            	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration11268);
                            lv_argListID_10_0=ruleextendedID();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getJavaFunctionDeclarationRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"argListID",
                                    		lv_argListID_10_0, 
                                    		"extendedID");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4817:2: (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            loop72:
                            do {
                                int alt72=2;
                                int LA72_0 = input.LA(1);

                                if ( (LA72_0==40) ) {
                                    alt72=1;
                                }


                                switch (alt72) {
                            	case 1 :
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4817:4: otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) )
                            	    {
                            	    otherlv_11=(Token)match(input,40,FOLLOW_40_in_rulejavaFunctionDeclaration11281); 

                            	        	newLeafNode(otherlv_11, grammarAccess.getJavaFunctionDeclarationAccess().getCommaKeyword_4_0_1_2_0());
                            	        
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4821:1: ( (lv_argList_12_0= ruleattributeType ) )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4822:1: (lv_argList_12_0= ruleattributeType )
                            	    {
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4822:1: (lv_argList_12_0= ruleattributeType )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4823:3: lv_argList_12_0= ruleattributeType
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration11302);
                            	    lv_argList_12_0=ruleattributeType();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getJavaFunctionDeclarationRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"argList",
                            	            		lv_argList_12_0, 
                            	            		"attributeType");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }

                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4839:2: ( (lv_argListID_13_0= ruleextendedID ) )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4840:1: (lv_argListID_13_0= ruleextendedID )
                            	    {
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4840:1: (lv_argListID_13_0= ruleextendedID )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4841:3: lv_argListID_13_0= ruleextendedID
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_2_2_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration11323);
                            	    lv_argListID_13_0=ruleextendedID();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getJavaFunctionDeclarationRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"argListID",
                            	            		lv_argListID_13_0, 
                            	            		"extendedID");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop72;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,54,FOLLOW_54_in_rulejavaFunctionDeclaration11339); 

                        	newLeafNode(otherlv_14, grammarAccess.getJavaFunctionDeclarationAccess().getRightParenthesisKeyword_4_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4862:7: otherlv_15= '()'
                    {
                    otherlv_15=(Token)match(input,98,FOLLOW_98_in_rulejavaFunctionDeclaration11358); 

                        	newLeafNode(otherlv_15, grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisRightParenthesisKeyword_4_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulejavaFunctionDeclaration"


    // $ANTLR start "entryRulejavaFunctionDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4874:1: entryRulejavaFunctionDefinition returns [EObject current=null] : iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF ;
    public final EObject entryRulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4875:2: (iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4876:2: iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF
            {
             newCompositeNode(grammarAccess.getJavaFunctionDefinitionRule()); 
            pushFollow(FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition11395);
            iv_rulejavaFunctionDefinition=rulejavaFunctionDefinition();

            state._fsp--;

             current =iv_rulejavaFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDefinition11405); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulejavaFunctionDefinition"


    // $ANTLR start "rulejavaFunctionDefinition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4883:1: rulejavaFunctionDefinition returns [EObject current=null] : ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject rulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_decl_0_0 = null;

        EObject lv_code_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4886:28: ( ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4887:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4887:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4887:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4887:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4888:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4888:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4889:3: lv_decl_0_0= rulejavaFunctionDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getDeclJavaFunctionDeclarationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition11451);
            lv_decl_0_0=rulejavaFunctionDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJavaFunctionDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"decl",
                    		lv_decl_0_0, 
                    		"javaFunctionDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4905:2: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4906:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4906:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4907:3: lv_code_1_0= ruleblock
            {
             
            	        newCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getCodeBlockParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleblock_in_rulejavaFunctionDefinition11472);
            lv_code_1_0=ruleblock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJavaFunctionDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"code",
                    		lv_code_1_0, 
                    		"block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulejavaFunctionDefinition"


    // $ANTLR start "entryRulejavaFunctionCall"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4931:1: entryRulejavaFunctionCall returns [EObject current=null] : iv_rulejavaFunctionCall= rulejavaFunctionCall EOF ;
    public final EObject entryRulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionCall = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4932:2: (iv_rulejavaFunctionCall= rulejavaFunctionCall EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4933:2: iv_rulejavaFunctionCall= rulejavaFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getJavaFunctionCallRule()); 
            pushFollow(FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall11508);
            iv_rulejavaFunctionCall=rulejavaFunctionCall();

            state._fsp--;

             current =iv_rulejavaFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionCall11518); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulejavaFunctionCall"


    // $ANTLR start "rulejavaFunctionCall"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4940:1: rulejavaFunctionCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) ) ;
    public final EObject rulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_args_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4943:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4944:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4944:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4944:2: ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4944:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4945:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4945:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4946:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getJavaFunctionCallAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionCall11564);
            lv_name_0_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJavaFunctionCallRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4962:2: ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==53) ) {
                alt76=1;
            }
            else if ( (LA76_0==98) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4962:3: (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4962:3: (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4962:5: otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_rulejavaFunctionCall11578); 

                        	newLeafNode(otherlv_1, grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisKeyword_1_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4966:1: ( (lv_args_2_0= ruleexpressionList ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( ((LA75_0>=RULE_STRING && LA75_0<=RULE_FALSE)||LA75_0==34||LA75_0==53||(LA75_0>=87 && LA75_0<=88)||(LA75_0>=90 && LA75_0<=92)) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4967:1: (lv_args_2_0= ruleexpressionList )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4967:1: (lv_args_2_0= ruleexpressionList )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4968:3: lv_args_2_0= ruleexpressionList
                            {
                             
                            	        newCompositeNode(grammarAccess.getJavaFunctionCallAccess().getArgsExpressionListParserRuleCall_1_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleexpressionList_in_rulejavaFunctionCall11599);
                            lv_args_2_0=ruleexpressionList();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getJavaFunctionCallRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"args",
                                    		lv_args_2_0, 
                                    		"expressionList");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,54,FOLLOW_54_in_rulejavaFunctionCall11612); 

                        	newLeafNode(otherlv_3, grammarAccess.getJavaFunctionCallAccess().getRightParenthesisKeyword_1_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4989:7: otherlv_4= '()'
                    {
                    otherlv_4=(Token)match(input,98,FOLLOW_98_in_rulejavaFunctionCall11631); 

                        	newLeafNode(otherlv_4, grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisRightParenthesisKeyword_1_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulejavaFunctionCall"


    // $ANTLR start "entryRuleblockStatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5001:1: entryRuleblockStatement returns [EObject current=null] : iv_ruleblockStatement= ruleblockStatement EOF ;
    public final EObject entryRuleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblockStatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5002:2: (iv_ruleblockStatement= ruleblockStatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5003:2: iv_ruleblockStatement= ruleblockStatement EOF
            {
             newCompositeNode(grammarAccess.getBlockStatementRule()); 
            pushFollow(FOLLOW_ruleblockStatement_in_entryRuleblockStatement11668);
            iv_ruleblockStatement=ruleblockStatement();

            state._fsp--;

             current =iv_ruleblockStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblockStatement11678); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleblockStatement"


    // $ANTLR start "ruleblockStatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5010:1: ruleblockStatement returns [EObject current=null] : (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) ;
    public final EObject ruleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject this_statement_0 = null;

        EObject this_localVariableDeclarationStatement_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5013:28: ( (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5014:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5014:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=RULE_STRING && LA77_0<=RULE_FALSE)||LA77_0==17||LA77_0==20||LA77_0==34||LA77_0==53||(LA77_0>=87 && LA77_0<=88)||(LA77_0>=90 && LA77_0<=92)||(LA77_0>=99 && LA77_0<=100)||(LA77_0>=102 && LA77_0<=105)) ) {
                alt77=1;
            }
            else if ( ((LA77_0>=64 && LA77_0<=74)) ) {
                alt77=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5015:5: this_statement_0= rulestatement
                    {
                     
                            newCompositeNode(grammarAccess.getBlockStatementAccess().getStatementParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulestatement_in_ruleblockStatement11725);
                    this_statement_0=rulestatement();

                    state._fsp--;

                     
                            current = this_statement_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5025:5: this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement
                    {
                     
                            newCompositeNode(grammarAccess.getBlockStatementAccess().getLocalVariableDeclarationStatementParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement11752);
                    this_localVariableDeclarationStatement_1=rulelocalVariableDeclarationStatement();

                    state._fsp--;

                     
                            current = this_localVariableDeclarationStatement_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleblockStatement"


    // $ANTLR start "entryRulelocalVariableDeclarationStatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5041:1: entryRulelocalVariableDeclarationStatement returns [EObject current=null] : iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF ;
    public final EObject entryRulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclarationStatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5042:2: (iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5043:2: iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF
            {
             newCompositeNode(grammarAccess.getLocalVariableDeclarationStatementRule()); 
            pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement11787);
            iv_rulelocalVariableDeclarationStatement=rulelocalVariableDeclarationStatement();

            state._fsp--;

             current =iv_rulelocalVariableDeclarationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement11797); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulelocalVariableDeclarationStatement"


    // $ANTLR start "rulelocalVariableDeclarationStatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5050:1: rulelocalVariableDeclarationStatement returns [EObject current=null] : (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' ) ;
    public final EObject rulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_localVariableDeclaration_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5053:28: ( (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5054:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5054:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5055:5: this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';'
            {
             
                    newCompositeNode(grammarAccess.getLocalVariableDeclarationStatementAccess().getLocalVariableDeclarationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement11844);
            this_localVariableDeclaration_0=rulelocalVariableDeclaration();

            state._fsp--;

             
                    current = this_localVariableDeclaration_0; 
                    afterParserOrEnumRuleCall();
                
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_rulelocalVariableDeclarationStatement11855); 

                	newLeafNode(otherlv_1, grammarAccess.getLocalVariableDeclarationStatementAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulelocalVariableDeclarationStatement"


    // $ANTLR start "entryRulelocalVariableDeclaration"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5075:1: entryRulelocalVariableDeclaration returns [EObject current=null] : iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF ;
    public final EObject entryRulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclaration = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5076:2: (iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5077:2: iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getLocalVariableDeclarationRule()); 
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration11891);
            iv_rulelocalVariableDeclaration=rulelocalVariableDeclaration();

            state._fsp--;

             current =iv_rulelocalVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclaration11901); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulelocalVariableDeclaration"


    // $ANTLR start "rulelocalVariableDeclaration"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5084:1: rulelocalVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) ;
    public final EObject rulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_dec_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5087:28: ( ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5088:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5088:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5088:2: ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5088:2: ( (lv_type_0_0= ruleattributeType ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5089:1: (lv_type_0_0= ruleattributeType )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5089:1: (lv_type_0_0= ruleattributeType )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5090:3: lv_type_0_0= ruleattributeType
            {
             
            	        newCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getTypeAttributeTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration11947);
            lv_type_0_0=ruleattributeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalVariableDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"attributeType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5106:2: ( (lv_dec_1_0= rulevariableDeclarators ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5107:1: (lv_dec_1_0= rulevariableDeclarators )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5107:1: (lv_dec_1_0= rulevariableDeclarators )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5108:3: lv_dec_1_0= rulevariableDeclarators
            {
             
            	        newCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getDecVariableDeclaratorsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration11968);
            lv_dec_1_0=rulevariableDeclarators();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalVariableDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"dec",
                    		lv_dec_1_0, 
                    		"variableDeclarators");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulelocalVariableDeclaration"


    // $ANTLR start "entryRulevariableDeclarators"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5132:1: entryRulevariableDeclarators returns [EObject current=null] : iv_rulevariableDeclarators= rulevariableDeclarators EOF ;
    public final EObject entryRulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarators = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5133:2: (iv_rulevariableDeclarators= rulevariableDeclarators EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5134:2: iv_rulevariableDeclarators= rulevariableDeclarators EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclaratorsRule()); 
            pushFollow(FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators12004);
            iv_rulevariableDeclarators=rulevariableDeclarators();

            state._fsp--;

             current =iv_rulevariableDeclarators; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarators12014); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulevariableDeclarators"


    // $ANTLR start "rulevariableDeclarators"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5141:1: rulevariableDeclarators returns [EObject current=null] : ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) ;
    public final EObject rulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vd_0_0 = null;

        EObject lv_vd_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5144:28: ( ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5145:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5145:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5145:2: ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5145:2: ( (lv_vd_0_0= rulevariableDeclarator ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5146:1: (lv_vd_0_0= rulevariableDeclarator )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5146:1: (lv_vd_0_0= rulevariableDeclarator )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5147:3: lv_vd_0_0= rulevariableDeclarator
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators12060);
            lv_vd_0_0=rulevariableDeclarator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDeclaratorsRule());
            	        }
                   		add(
                   			current, 
                   			"vd",
                    		lv_vd_0_0, 
                    		"variableDeclarator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5163:2: (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==40) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5163:4: otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    {
            	    otherlv_1=(Token)match(input,40,FOLLOW_40_in_rulevariableDeclarators12073); 

            	        	newLeafNode(otherlv_1, grammarAccess.getVariableDeclaratorsAccess().getCommaKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5167:1: ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5168:1: (lv_vd_2_0= rulevariableDeclarator )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5168:1: (lv_vd_2_0= rulevariableDeclarator )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5169:3: lv_vd_2_0= rulevariableDeclarator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators12094);
            	    lv_vd_2_0=rulevariableDeclarator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVariableDeclaratorsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"vd",
            	            		lv_vd_2_0, 
            	            		"variableDeclarator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulevariableDeclarators"


    // $ANTLR start "entryRulevariableDeclarator"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5193:1: entryRulevariableDeclarator returns [EObject current=null] : iv_rulevariableDeclarator= rulevariableDeclarator EOF ;
    public final EObject entryRulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarator = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5194:2: (iv_rulevariableDeclarator= rulevariableDeclarator EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5195:2: iv_rulevariableDeclarator= rulevariableDeclarator EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclaratorRule()); 
            pushFollow(FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator12132);
            iv_rulevariableDeclarator=rulevariableDeclarator();

            state._fsp--;

             current =iv_rulevariableDeclarator; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarator12142); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulevariableDeclarator"


    // $ANTLR start "rulevariableDeclarator"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5202:1: rulevariableDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) ;
    public final EObject rulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5205:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5206:1: ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5206:1: ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5206:2: ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5206:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5207:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5207:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5208:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclaratorAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulevariableDeclarator12188);
            lv_name_0_0=ruleextendedID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDeclaratorRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"extendedID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5224:2: (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==48) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5224:4: otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) )
                    {
                    otherlv_1=(Token)match(input,48,FOLLOW_48_in_rulevariableDeclarator12201); 

                        	newLeafNode(otherlv_1, grammarAccess.getVariableDeclaratorAccess().getEqualsSignKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5228:1: ( (lv_exp_2_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5229:1: (lv_exp_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5229:1: (lv_exp_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5230:3: lv_exp_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclaratorAccess().getExpExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_rulevariableDeclarator12222);
                    lv_exp_2_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDeclaratorRule());
                    	        }
                           		set(
                           			current, 
                           			"exp",
                            		lv_exp_2_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulevariableDeclarator"


    // $ANTLR start "entryRulestatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5254:1: entryRulestatement returns [EObject current=null] : iv_rulestatement= rulestatement EOF ;
    public final EObject entryRulestatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5255:2: (iv_rulestatement= rulestatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5256:2: iv_rulestatement= rulestatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_rulestatement_in_entryRulestatement12260);
            iv_rulestatement=rulestatement();

            state._fsp--;

             current =iv_rulestatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulestatement12270); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestatement"


    // $ANTLR start "rulestatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5263:1: rulestatement returns [EObject current=null] : (this_block_0= ruleblock | this_ifstatement_1= ruleifstatement | this_forstatement_2= ruleforstatement | this_whilestatement_3= rulewhilestatement | this_returnstatement_4= rulereturnstatement | this_endstatement_5= ruleendstatement | this_breakstatement_6= rulebreakstatement | this_expressionstatement_7= ruleexpressionstatement | this_trystatement_8= ruletrystatement ) ;
    public final EObject rulestatement() throws RecognitionException {
        EObject current = null;

        EObject this_block_0 = null;

        EObject this_ifstatement_1 = null;

        EObject this_forstatement_2 = null;

        EObject this_whilestatement_3 = null;

        EObject this_returnstatement_4 = null;

        EObject this_endstatement_5 = null;

        EObject this_breakstatement_6 = null;

        EObject this_expressionstatement_7 = null;

        EObject this_trystatement_8 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5266:28: ( (this_block_0= ruleblock | this_ifstatement_1= ruleifstatement | this_forstatement_2= ruleforstatement | this_whilestatement_3= rulewhilestatement | this_returnstatement_4= rulereturnstatement | this_endstatement_5= ruleendstatement | this_breakstatement_6= rulebreakstatement | this_expressionstatement_7= ruleexpressionstatement | this_trystatement_8= ruletrystatement ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5267:1: (this_block_0= ruleblock | this_ifstatement_1= ruleifstatement | this_forstatement_2= ruleforstatement | this_whilestatement_3= rulewhilestatement | this_returnstatement_4= rulereturnstatement | this_endstatement_5= ruleendstatement | this_breakstatement_6= rulebreakstatement | this_expressionstatement_7= ruleexpressionstatement | this_trystatement_8= ruletrystatement )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5267:1: (this_block_0= ruleblock | this_ifstatement_1= ruleifstatement | this_forstatement_2= ruleforstatement | this_whilestatement_3= rulewhilestatement | this_returnstatement_4= rulereturnstatement | this_endstatement_5= ruleendstatement | this_breakstatement_6= rulebreakstatement | this_expressionstatement_7= ruleexpressionstatement | this_trystatement_8= ruletrystatement )
            int alt80=9;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt80=1;
                }
                break;
            case 100:
                {
                alt80=2;
                }
                break;
            case 102:
                {
                alt80=3;
                }
                break;
            case 103:
                {
                alt80=4;
                }
                break;
            case 104:
                {
                alt80=5;
                }
                break;
            case 20:
                {
                alt80=6;
                }
                break;
            case 99:
                {
                alt80=7;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case RULE_TRUE:
            case RULE_FALSE:
            case 34:
            case 53:
            case 87:
            case 88:
            case 90:
            case 91:
            case 92:
                {
                alt80=8;
                }
                break;
            case 105:
                {
                alt80=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5268:5: this_block_0= ruleblock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleblock_in_rulestatement12317);
                    this_block_0=ruleblock();

                    state._fsp--;

                     
                            current = this_block_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5278:5: this_ifstatement_1= ruleifstatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getIfstatementParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleifstatement_in_rulestatement12344);
                    this_ifstatement_1=ruleifstatement();

                    state._fsp--;

                     
                            current = this_ifstatement_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5288:5: this_forstatement_2= ruleforstatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getForstatementParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleforstatement_in_rulestatement12371);
                    this_forstatement_2=ruleforstatement();

                    state._fsp--;

                     
                            current = this_forstatement_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5298:5: this_whilestatement_3= rulewhilestatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getWhilestatementParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_rulewhilestatement_in_rulestatement12398);
                    this_whilestatement_3=rulewhilestatement();

                    state._fsp--;

                     
                            current = this_whilestatement_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5308:5: this_returnstatement_4= rulereturnstatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getReturnstatementParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_rulereturnstatement_in_rulestatement12425);
                    this_returnstatement_4=rulereturnstatement();

                    state._fsp--;

                     
                            current = this_returnstatement_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5318:5: this_endstatement_5= ruleendstatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getEndstatementParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleendstatement_in_rulestatement12452);
                    this_endstatement_5=ruleendstatement();

                    state._fsp--;

                     
                            current = this_endstatement_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5328:5: this_breakstatement_6= rulebreakstatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBreakstatementParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_rulebreakstatement_in_rulestatement12479);
                    this_breakstatement_6=rulebreakstatement();

                    state._fsp--;

                     
                            current = this_breakstatement_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5338:5: this_expressionstatement_7= ruleexpressionstatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getExpressionstatementParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleexpressionstatement_in_rulestatement12506);
                    this_expressionstatement_7=ruleexpressionstatement();

                    state._fsp--;

                     
                            current = this_expressionstatement_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5348:5: this_trystatement_8= ruletrystatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getTrystatementParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruletrystatement_in_rulestatement12533);
                    this_trystatement_8=ruletrystatement();

                    state._fsp--;

                     
                            current = this_trystatement_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestatement"


    // $ANTLR start "entryRuleendstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5364:1: entryRuleendstatement returns [EObject current=null] : iv_ruleendstatement= ruleendstatement EOF ;
    public final EObject entryRuleendstatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleendstatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5365:2: (iv_ruleendstatement= ruleendstatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5366:2: iv_ruleendstatement= ruleendstatement EOF
            {
             newCompositeNode(grammarAccess.getEndstatementRule()); 
            pushFollow(FOLLOW_ruleendstatement_in_entryRuleendstatement12568);
            iv_ruleendstatement=ruleendstatement();

            state._fsp--;

             current =iv_ruleendstatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleendstatement12578); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleendstatement"


    // $ANTLR start "ruleendstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5373:1: ruleendstatement returns [EObject current=null] : ( () otherlv_1= ';' ) ;
    public final EObject ruleendstatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5376:28: ( ( () otherlv_1= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5377:1: ( () otherlv_1= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5377:1: ( () otherlv_1= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5377:2: () otherlv_1= ';'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5377:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5378:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEndstatementAccess().getEndstatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleendstatement12624); 

                	newLeafNode(otherlv_1, grammarAccess.getEndstatementAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleendstatement"


    // $ANTLR start "entryRulebreakstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5395:1: entryRulebreakstatement returns [EObject current=null] : iv_rulebreakstatement= rulebreakstatement EOF ;
    public final EObject entryRulebreakstatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebreakstatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5396:2: (iv_rulebreakstatement= rulebreakstatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5397:2: iv_rulebreakstatement= rulebreakstatement EOF
            {
             newCompositeNode(grammarAccess.getBreakstatementRule()); 
            pushFollow(FOLLOW_rulebreakstatement_in_entryRulebreakstatement12660);
            iv_rulebreakstatement=rulebreakstatement();

            state._fsp--;

             current =iv_rulebreakstatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulebreakstatement12670); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebreakstatement"


    // $ANTLR start "rulebreakstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5404:1: rulebreakstatement returns [EObject current=null] : ( () otherlv_1= 'break' otherlv_2= ';' ) ;
    public final EObject rulebreakstatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5407:28: ( ( () otherlv_1= 'break' otherlv_2= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5408:1: ( () otherlv_1= 'break' otherlv_2= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5408:1: ( () otherlv_1= 'break' otherlv_2= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5408:2: () otherlv_1= 'break' otherlv_2= ';'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5408:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5409:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBreakstatementAccess().getBreakstatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,99,FOLLOW_99_in_rulebreakstatement12716); 

                	newLeafNode(otherlv_1, grammarAccess.getBreakstatementAccess().getBreakKeyword_1());
                
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_rulebreakstatement12728); 

                	newLeafNode(otherlv_2, grammarAccess.getBreakstatementAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebreakstatement"


    // $ANTLR start "entryRuleifstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5430:1: entryRuleifstatement returns [EObject current=null] : iv_ruleifstatement= ruleifstatement EOF ;
    public final EObject entryRuleifstatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleifstatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5431:2: (iv_ruleifstatement= ruleifstatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5432:2: iv_ruleifstatement= ruleifstatement EOF
            {
             newCompositeNode(grammarAccess.getIfstatementRule()); 
            pushFollow(FOLLOW_ruleifstatement_in_entryRuleifstatement12764);
            iv_ruleifstatement=ruleifstatement();

            state._fsp--;

             current =iv_ruleifstatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleifstatement12774); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleifstatement"


    // $ANTLR start "ruleifstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5439:1: ruleifstatement returns [EObject current=null] : ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) ;
    public final EObject ruleifstatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_condition_2_0 = null;

        EObject lv_state1_3_0 = null;

        EObject lv_state2_5_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5442:28: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5443:1: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5443:1: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5443:2: () otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5443:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5444:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIfstatementAccess().getIfstatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,100,FOLLOW_100_in_ruleifstatement12820); 

                	newLeafNode(otherlv_1, grammarAccess.getIfstatementAccess().getIfKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5453:1: ( (lv_condition_2_0= ruleparExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5454:1: (lv_condition_2_0= ruleparExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5454:1: (lv_condition_2_0= ruleparExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5455:3: lv_condition_2_0= ruleparExpression
            {
             
            	        newCompositeNode(grammarAccess.getIfstatementAccess().getConditionParExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleparExpression_in_ruleifstatement12841);
            lv_condition_2_0=ruleparExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfstatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_2_0, 
                    		"parExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5471:2: ( (lv_state1_3_0= rulestatement ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5472:1: (lv_state1_3_0= rulestatement )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5472:1: (lv_state1_3_0= rulestatement )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5473:3: lv_state1_3_0= rulestatement
            {
             
            	        newCompositeNode(grammarAccess.getIfstatementAccess().getState1StatementParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulestatement_in_ruleifstatement12862);
            lv_state1_3_0=rulestatement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfstatementRule());
            	        }
                   		set(
                   			current, 
                   			"state1",
                    		lv_state1_3_0, 
                    		"statement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5489:2: (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==101) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5489:4: otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) )
                    {
                    otherlv_4=(Token)match(input,101,FOLLOW_101_in_ruleifstatement12875); 

                        	newLeafNode(otherlv_4, grammarAccess.getIfstatementAccess().getElseKeyword_4_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5493:1: ( (lv_state2_5_0= rulestatement ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5494:1: (lv_state2_5_0= rulestatement )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5494:1: (lv_state2_5_0= rulestatement )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5495:3: lv_state2_5_0= rulestatement
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfstatementAccess().getState2StatementParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_ruleifstatement12896);
                    lv_state2_5_0=rulestatement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfstatementRule());
                    	        }
                           		set(
                           			current, 
                           			"state2",
                            		lv_state2_5_0, 
                            		"statement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleifstatement"


    // $ANTLR start "entryRuleforstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5519:1: entryRuleforstatement returns [EObject current=null] : iv_ruleforstatement= ruleforstatement EOF ;
    public final EObject entryRuleforstatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforstatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5520:2: (iv_ruleforstatement= ruleforstatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5521:2: iv_ruleforstatement= ruleforstatement EOF
            {
             newCompositeNode(grammarAccess.getForstatementRule()); 
            pushFollow(FOLLOW_ruleforstatement_in_entryRuleforstatement12934);
            iv_ruleforstatement=ruleforstatement();

            state._fsp--;

             current =iv_ruleforstatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforstatement12944); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleforstatement"


    // $ANTLR start "ruleforstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5528:1: ruleforstatement returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_control_3_0= ruleforControl ) ) otherlv_4= ')' ( (lv_state_5_0= rulestatement ) ) ) ;
    public final EObject ruleforstatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_control_3_0 = null;

        EObject lv_state_5_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5531:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_control_3_0= ruleforControl ) ) otherlv_4= ')' ( (lv_state_5_0= rulestatement ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5532:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_control_3_0= ruleforControl ) ) otherlv_4= ')' ( (lv_state_5_0= rulestatement ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5532:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_control_3_0= ruleforControl ) ) otherlv_4= ')' ( (lv_state_5_0= rulestatement ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5532:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_control_3_0= ruleforControl ) ) otherlv_4= ')' ( (lv_state_5_0= rulestatement ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5532:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5533:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getForstatementAccess().getForstatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,102,FOLLOW_102_in_ruleforstatement12990); 

                	newLeafNode(otherlv_1, grammarAccess.getForstatementAccess().getForKeyword_1());
                
            otherlv_2=(Token)match(input,53,FOLLOW_53_in_ruleforstatement13002); 

                	newLeafNode(otherlv_2, grammarAccess.getForstatementAccess().getLeftParenthesisKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5546:1: ( (lv_control_3_0= ruleforControl ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5547:1: (lv_control_3_0= ruleforControl )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5547:1: (lv_control_3_0= ruleforControl )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5548:3: lv_control_3_0= ruleforControl
            {
             
            	        newCompositeNode(grammarAccess.getForstatementAccess().getControlForControlParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleforControl_in_ruleforstatement13023);
            lv_control_3_0=ruleforControl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForstatementRule());
            	        }
                   		set(
                   			current, 
                   			"control",
                    		lv_control_3_0, 
                    		"forControl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,54,FOLLOW_54_in_ruleforstatement13035); 

                	newLeafNode(otherlv_4, grammarAccess.getForstatementAccess().getRightParenthesisKeyword_4());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5568:1: ( (lv_state_5_0= rulestatement ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5569:1: (lv_state_5_0= rulestatement )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5569:1: (lv_state_5_0= rulestatement )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5570:3: lv_state_5_0= rulestatement
            {
             
            	        newCompositeNode(grammarAccess.getForstatementAccess().getStateStatementParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_rulestatement_in_ruleforstatement13056);
            lv_state_5_0=rulestatement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForstatementRule());
            	        }
                   		set(
                   			current, 
                   			"state",
                    		lv_state_5_0, 
                    		"statement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleforstatement"


    // $ANTLR start "entryRulewhilestatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5594:1: entryRulewhilestatement returns [EObject current=null] : iv_rulewhilestatement= rulewhilestatement EOF ;
    public final EObject entryRulewhilestatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulewhilestatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5595:2: (iv_rulewhilestatement= rulewhilestatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5596:2: iv_rulewhilestatement= rulewhilestatement EOF
            {
             newCompositeNode(grammarAccess.getWhilestatementRule()); 
            pushFollow(FOLLOW_rulewhilestatement_in_entryRulewhilestatement13092);
            iv_rulewhilestatement=rulewhilestatement();

            state._fsp--;

             current =iv_rulewhilestatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulewhilestatement13102); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulewhilestatement"


    // $ANTLR start "rulewhilestatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5603:1: rulewhilestatement returns [EObject current=null] : ( () otherlv_1= 'while' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state_3_0= rulestatement ) ) ) ;
    public final EObject rulewhilestatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_condition_2_0 = null;

        EObject lv_state_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5606:28: ( ( () otherlv_1= 'while' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state_3_0= rulestatement ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5607:1: ( () otherlv_1= 'while' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state_3_0= rulestatement ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5607:1: ( () otherlv_1= 'while' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state_3_0= rulestatement ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5607:2: () otherlv_1= 'while' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state_3_0= rulestatement ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5607:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5608:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWhilestatementAccess().getWhilestatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,103,FOLLOW_103_in_rulewhilestatement13148); 

                	newLeafNode(otherlv_1, grammarAccess.getWhilestatementAccess().getWhileKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5617:1: ( (lv_condition_2_0= ruleparExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5618:1: (lv_condition_2_0= ruleparExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5618:1: (lv_condition_2_0= ruleparExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5619:3: lv_condition_2_0= ruleparExpression
            {
             
            	        newCompositeNode(grammarAccess.getWhilestatementAccess().getConditionParExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleparExpression_in_rulewhilestatement13169);
            lv_condition_2_0=ruleparExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhilestatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_2_0, 
                    		"parExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5635:2: ( (lv_state_3_0= rulestatement ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5636:1: (lv_state_3_0= rulestatement )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5636:1: (lv_state_3_0= rulestatement )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5637:3: lv_state_3_0= rulestatement
            {
             
            	        newCompositeNode(grammarAccess.getWhilestatementAccess().getStateStatementParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulestatement_in_rulewhilestatement13190);
            lv_state_3_0=rulestatement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhilestatementRule());
            	        }
                   		set(
                   			current, 
                   			"state",
                    		lv_state_3_0, 
                    		"statement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulewhilestatement"


    // $ANTLR start "entryRulereturnstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5661:1: entryRulereturnstatement returns [EObject current=null] : iv_rulereturnstatement= rulereturnstatement EOF ;
    public final EObject entryRulereturnstatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulereturnstatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5662:2: (iv_rulereturnstatement= rulereturnstatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5663:2: iv_rulereturnstatement= rulereturnstatement EOF
            {
             newCompositeNode(grammarAccess.getReturnstatementRule()); 
            pushFollow(FOLLOW_rulereturnstatement_in_entryRulereturnstatement13226);
            iv_rulereturnstatement=rulereturnstatement();

            state._fsp--;

             current =iv_rulereturnstatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulereturnstatement13236); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulereturnstatement"


    // $ANTLR start "rulereturnstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5670:1: rulereturnstatement returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_retVal_2_0= ruleexpression ) )? otherlv_3= ';' ) ;
    public final EObject rulereturnstatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_retVal_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5673:28: ( ( () otherlv_1= 'return' ( (lv_retVal_2_0= ruleexpression ) )? otherlv_3= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5674:1: ( () otherlv_1= 'return' ( (lv_retVal_2_0= ruleexpression ) )? otherlv_3= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5674:1: ( () otherlv_1= 'return' ( (lv_retVal_2_0= ruleexpression ) )? otherlv_3= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5674:2: () otherlv_1= 'return' ( (lv_retVal_2_0= ruleexpression ) )? otherlv_3= ';'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5674:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5675:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReturnstatementAccess().getReturnstatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,104,FOLLOW_104_in_rulereturnstatement13282); 

                	newLeafNode(otherlv_1, grammarAccess.getReturnstatementAccess().getReturnKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5684:1: ( (lv_retVal_2_0= ruleexpression ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_FALSE)||LA82_0==34||LA82_0==53||(LA82_0>=87 && LA82_0<=88)||(LA82_0>=90 && LA82_0<=92)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5685:1: (lv_retVal_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5685:1: (lv_retVal_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5686:3: lv_retVal_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getReturnstatementAccess().getRetValExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_rulereturnstatement13303);
                    lv_retVal_2_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReturnstatementRule());
                    	        }
                           		set(
                           			current, 
                           			"retVal",
                            		lv_retVal_2_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_rulereturnstatement13316); 

                	newLeafNode(otherlv_3, grammarAccess.getReturnstatementAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulereturnstatement"


    // $ANTLR start "entryRuleexpressionstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5714:1: entryRuleexpressionstatement returns [EObject current=null] : iv_ruleexpressionstatement= ruleexpressionstatement EOF ;
    public final EObject entryRuleexpressionstatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpressionstatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5715:2: (iv_ruleexpressionstatement= ruleexpressionstatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5716:2: iv_ruleexpressionstatement= ruleexpressionstatement EOF
            {
             newCompositeNode(grammarAccess.getExpressionstatementRule()); 
            pushFollow(FOLLOW_ruleexpressionstatement_in_entryRuleexpressionstatement13352);
            iv_ruleexpressionstatement=ruleexpressionstatement();

            state._fsp--;

             current =iv_ruleexpressionstatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpressionstatement13362); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleexpressionstatement"


    // $ANTLR start "ruleexpressionstatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5723:1: ruleexpressionstatement returns [EObject current=null] : (this_expression_0= ruleexpression otherlv_1= ';' ) ;
    public final EObject ruleexpressionstatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_expression_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5726:28: ( (this_expression_0= ruleexpression otherlv_1= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5727:1: (this_expression_0= ruleexpression otherlv_1= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5727:1: (this_expression_0= ruleexpression otherlv_1= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5728:5: this_expression_0= ruleexpression otherlv_1= ';'
            {
             
                    newCompositeNode(grammarAccess.getExpressionstatementAccess().getExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleexpression_in_ruleexpressionstatement13409);
            this_expression_0=ruleexpression();

            state._fsp--;

             
                    current = this_expression_0; 
                    afterParserOrEnumRuleCall();
                
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleexpressionstatement13420); 

                	newLeafNode(otherlv_1, grammarAccess.getExpressionstatementAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleexpressionstatement"


    // $ANTLR start "entryRuletrystatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5748:1: entryRuletrystatement returns [EObject current=null] : iv_ruletrystatement= ruletrystatement EOF ;
    public final EObject entryRuletrystatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletrystatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5749:2: (iv_ruletrystatement= ruletrystatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5750:2: iv_ruletrystatement= ruletrystatement EOF
            {
             newCompositeNode(grammarAccess.getTrystatementRule()); 
            pushFollow(FOLLOW_ruletrystatement_in_entryRuletrystatement13456);
            iv_ruletrystatement=ruletrystatement();

            state._fsp--;

             current =iv_ruletrystatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuletrystatement13466); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletrystatement"


    // $ANTLR start "ruletrystatement"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5757:1: ruletrystatement returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_tryBlock_2_0= ruleblock ) ) otherlv_3= 'catch' ( (lv_catchBlock_4_0= ruleblock ) ) ) ;
    public final EObject ruletrystatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_tryBlock_2_0 = null;

        EObject lv_catchBlock_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5760:28: ( ( () otherlv_1= 'try' ( (lv_tryBlock_2_0= ruleblock ) ) otherlv_3= 'catch' ( (lv_catchBlock_4_0= ruleblock ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5761:1: ( () otherlv_1= 'try' ( (lv_tryBlock_2_0= ruleblock ) ) otherlv_3= 'catch' ( (lv_catchBlock_4_0= ruleblock ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5761:1: ( () otherlv_1= 'try' ( (lv_tryBlock_2_0= ruleblock ) ) otherlv_3= 'catch' ( (lv_catchBlock_4_0= ruleblock ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5761:2: () otherlv_1= 'try' ( (lv_tryBlock_2_0= ruleblock ) ) otherlv_3= 'catch' ( (lv_catchBlock_4_0= ruleblock ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5761:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5762:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTrystatementAccess().getTrystatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,105,FOLLOW_105_in_ruletrystatement13512); 

                	newLeafNode(otherlv_1, grammarAccess.getTrystatementAccess().getTryKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5771:1: ( (lv_tryBlock_2_0= ruleblock ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5772:1: (lv_tryBlock_2_0= ruleblock )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5772:1: (lv_tryBlock_2_0= ruleblock )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5773:3: lv_tryBlock_2_0= ruleblock
            {
             
            	        newCompositeNode(grammarAccess.getTrystatementAccess().getTryBlockBlockParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruletrystatement13533);
            lv_tryBlock_2_0=ruleblock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrystatementRule());
            	        }
                   		set(
                   			current, 
                   			"tryBlock",
                    		lv_tryBlock_2_0, 
                    		"block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,106,FOLLOW_106_in_ruletrystatement13545); 

                	newLeafNode(otherlv_3, grammarAccess.getTrystatementAccess().getCatchKeyword_3());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5793:1: ( (lv_catchBlock_4_0= ruleblock ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5794:1: (lv_catchBlock_4_0= ruleblock )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5794:1: (lv_catchBlock_4_0= ruleblock )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5795:3: lv_catchBlock_4_0= ruleblock
            {
             
            	        newCompositeNode(grammarAccess.getTrystatementAccess().getCatchBlockBlockParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruletrystatement13566);
            lv_catchBlock_4_0=ruleblock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrystatementRule());
            	        }
                   		set(
                   			current, 
                   			"catchBlock",
                    		lv_catchBlock_4_0, 
                    		"block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletrystatement"


    // $ANTLR start "entryRuleforControl"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5819:1: entryRuleforControl returns [EObject current=null] : iv_ruleforControl= ruleforControl EOF ;
    public final EObject entryRuleforControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforControl = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5820:2: (iv_ruleforControl= ruleforControl EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5821:2: iv_ruleforControl= ruleforControl EOF
            {
             newCompositeNode(grammarAccess.getForControlRule()); 
            pushFollow(FOLLOW_ruleforControl_in_entryRuleforControl13602);
            iv_ruleforControl=ruleforControl();

            state._fsp--;

             current =iv_ruleforControl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforControl13612); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleforControl"


    // $ANTLR start "ruleforControl"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5828:1: ruleforControl returns [EObject current=null] : ( () ( (lv_init_1_0= ruleforInit ) )? otherlv_2= ';' ( (lv_condition_3_0= ruleexpression ) )? otherlv_4= ';' ( (lv_update_5_0= ruleforUpdate ) )? ) ;
    public final EObject ruleforControl() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_init_1_0 = null;

        EObject lv_condition_3_0 = null;

        EObject lv_update_5_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5831:28: ( ( () ( (lv_init_1_0= ruleforInit ) )? otherlv_2= ';' ( (lv_condition_3_0= ruleexpression ) )? otherlv_4= ';' ( (lv_update_5_0= ruleforUpdate ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5832:1: ( () ( (lv_init_1_0= ruleforInit ) )? otherlv_2= ';' ( (lv_condition_3_0= ruleexpression ) )? otherlv_4= ';' ( (lv_update_5_0= ruleforUpdate ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5832:1: ( () ( (lv_init_1_0= ruleforInit ) )? otherlv_2= ';' ( (lv_condition_3_0= ruleexpression ) )? otherlv_4= ';' ( (lv_update_5_0= ruleforUpdate ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5832:2: () ( (lv_init_1_0= ruleforInit ) )? otherlv_2= ';' ( (lv_condition_3_0= ruleexpression ) )? otherlv_4= ';' ( (lv_update_5_0= ruleforUpdate ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5832:2: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5833:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getForControlAccess().getForControlAction_0(),
                        current);
                

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5838:2: ( (lv_init_1_0= ruleforInit ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_STRING && LA83_0<=RULE_FALSE)||LA83_0==34||LA83_0==53||(LA83_0>=64 && LA83_0<=74)||(LA83_0>=87 && LA83_0<=88)||(LA83_0>=90 && LA83_0<=92)) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5839:1: (lv_init_1_0= ruleforInit )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5839:1: (lv_init_1_0= ruleforInit )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5840:3: lv_init_1_0= ruleforInit
                    {
                     
                    	        newCompositeNode(grammarAccess.getForControlAccess().getInitForInitParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleforInit_in_ruleforControl13667);
                    lv_init_1_0=ruleforInit();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForControlRule());
                    	        }
                           		set(
                           			current, 
                           			"init",
                            		lv_init_1_0, 
                            		"forInit");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleforControl13680); 

                	newLeafNode(otherlv_2, grammarAccess.getForControlAccess().getSemicolonKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5860:1: ( (lv_condition_3_0= ruleexpression ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=RULE_STRING && LA84_0<=RULE_FALSE)||LA84_0==34||LA84_0==53||(LA84_0>=87 && LA84_0<=88)||(LA84_0>=90 && LA84_0<=92)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5861:1: (lv_condition_3_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5861:1: (lv_condition_3_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5862:3: lv_condition_3_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getForControlAccess().getConditionExpressionParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforControl13701);
                    lv_condition_3_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForControlRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_3_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleforControl13714); 

                	newLeafNode(otherlv_4, grammarAccess.getForControlAccess().getSemicolonKeyword_4());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5882:1: ( (lv_update_5_0= ruleforUpdate ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( ((LA85_0>=RULE_STRING && LA85_0<=RULE_FALSE)||LA85_0==34||LA85_0==53||(LA85_0>=87 && LA85_0<=88)||(LA85_0>=90 && LA85_0<=92)) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5883:1: (lv_update_5_0= ruleforUpdate )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5883:1: (lv_update_5_0= ruleforUpdate )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5884:3: lv_update_5_0= ruleforUpdate
                    {
                     
                    	        newCompositeNode(grammarAccess.getForControlAccess().getUpdateForUpdateParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleforUpdate_in_ruleforControl13735);
                    lv_update_5_0=ruleforUpdate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForControlRule());
                    	        }
                           		set(
                           			current, 
                           			"update",
                            		lv_update_5_0, 
                            		"forUpdate");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleforControl"


    // $ANTLR start "entryRuleforInit"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5908:1: entryRuleforInit returns [EObject current=null] : iv_ruleforInit= ruleforInit EOF ;
    public final EObject entryRuleforInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforInit = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5909:2: (iv_ruleforInit= ruleforInit EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5910:2: iv_ruleforInit= ruleforInit EOF
            {
             newCompositeNode(grammarAccess.getForInitRule()); 
            pushFollow(FOLLOW_ruleforInit_in_entryRuleforInit13772);
            iv_ruleforInit=ruleforInit();

            state._fsp--;

             current =iv_ruleforInit; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforInit13782); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleforInit"


    // $ANTLR start "ruleforInit"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5917:1: ruleforInit returns [EObject current=null] : ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) ;
    public final EObject ruleforInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;

        EObject this_localVariableDeclaration_3 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5920:28: ( ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( ((LA87_0>=RULE_STRING && LA87_0<=RULE_FALSE)||LA87_0==34||LA87_0==53||(LA87_0>=87 && LA87_0<=88)||(LA87_0>=90 && LA87_0<=92)) ) {
                alt87=1;
            }
            else if ( ((LA87_0>=64 && LA87_0<=74)) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:2: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:2: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:3: ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:3: ( (lv_expressions_0_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5922:1: (lv_expressions_0_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5922:1: (lv_expressions_0_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5923:3: lv_expressions_0_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforInit13829);
                    lv_expressions_0_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForInitRule());
                    	        }
                           		add(
                           			current, 
                           			"expressions",
                            		lv_expressions_0_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5939:2: (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==40) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5939:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) )
                    	    {
                    	    otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleforInit13842); 

                    	        	newLeafNode(otherlv_1, grammarAccess.getForInitAccess().getCommaKeyword_0_1_0());
                    	        
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5943:1: ( (lv_expressions_2_0= ruleexpression ) )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5944:1: (lv_expressions_2_0= ruleexpression )
                    	    {
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5944:1: (lv_expressions_2_0= ruleexpression )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5945:3: lv_expressions_2_0= ruleexpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleexpression_in_ruleforInit13863);
                    	    lv_expressions_2_0=ruleexpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getForInitRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"expressions",
                    	            		lv_expressions_2_0, 
                    	            		"expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop86;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5963:5: this_localVariableDeclaration_3= rulelocalVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getForInitAccess().getLocalVariableDeclarationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclaration_in_ruleforInit13894);
                    this_localVariableDeclaration_3=rulelocalVariableDeclaration();

                    state._fsp--;

                     
                            current = this_localVariableDeclaration_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleforInit"


    // $ANTLR start "entryRuleforUpdate"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5979:1: entryRuleforUpdate returns [EObject current=null] : iv_ruleforUpdate= ruleforUpdate EOF ;
    public final EObject entryRuleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforUpdate = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5980:2: (iv_ruleforUpdate= ruleforUpdate EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5981:2: iv_ruleforUpdate= ruleforUpdate EOF
            {
             newCompositeNode(grammarAccess.getForUpdateRule()); 
            pushFollow(FOLLOW_ruleforUpdate_in_entryRuleforUpdate13929);
            iv_ruleforUpdate=ruleforUpdate();

            state._fsp--;

             current =iv_ruleforUpdate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforUpdate13939); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleforUpdate"


    // $ANTLR start "ruleforUpdate"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5988:1: ruleforUpdate returns [EObject current=null] : this_expressionList_0= ruleexpressionList ;
    public final EObject ruleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject this_expressionList_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5991:28: (this_expressionList_0= ruleexpressionList )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5993:5: this_expressionList_0= ruleexpressionList
            {
             
                    newCompositeNode(grammarAccess.getForUpdateAccess().getExpressionListParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleexpressionList_in_ruleforUpdate13985);
            this_expressionList_0=ruleexpressionList();

            state._fsp--;

             
                    current = this_expressionList_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleforUpdate"


    // $ANTLR start "entryRuleattributeType"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6009:1: entryRuleattributeType returns [String current=null] : iv_ruleattributeType= ruleattributeType EOF ;
    public final String entryRuleattributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleattributeType = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6010:2: (iv_ruleattributeType= ruleattributeType EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6011:2: iv_ruleattributeType= ruleattributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FOLLOW_ruleattributeType_in_entryRuleattributeType14020);
            iv_ruleattributeType=ruleattributeType();

            state._fsp--;

             current =iv_ruleattributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleattributeType14031); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleattributeType"


    // $ANTLR start "ruleattributeType"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6018:1: ruleattributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleattributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6021:28: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6022:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6022:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt88=11;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt88=1;
                }
                break;
            case 65:
                {
                alt88=2;
                }
                break;
            case 66:
                {
                alt88=3;
                }
                break;
            case 67:
                {
                alt88=4;
                }
                break;
            case 68:
                {
                alt88=5;
                }
                break;
            case 69:
                {
                alt88=6;
                }
                break;
            case 70:
                {
                alt88=7;
                }
                break;
            case 71:
                {
                alt88=8;
                }
                break;
            case 72:
                {
                alt88=9;
                }
                break;
            case 73:
                {
                alt88=10;
                }
                break;
            case 74:
                {
                alt88=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6023:2: kw= 'Date'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleattributeType14069); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getDateKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6030:2: kw= 'Time'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleattributeType14088); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getTimeKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6037:2: kw= 'Double'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleattributeType14107); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getDoubleKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6044:2: kw= 'double'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleattributeType14126); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getDoubleKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6051:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleattributeType14145); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getIntegerKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6058:2: kw= 'integer'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleattributeType14164); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getIntegerKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6065:2: kw= 'int'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleattributeType14183); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getIntKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6072:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleattributeType14202); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getBooleanKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6079:2: kw= 'boolean'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleattributeType14221); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getBooleanKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6086:2: kw= 'String'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleattributeType14240); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getStringKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6093:2: kw= 'string'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleattributeType14259); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getStringKeyword_10()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleattributeType"


    // $ANTLR start "entryRuleextendedID"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6112:1: entryRuleextendedID returns [String current=null] : iv_ruleextendedID= ruleextendedID EOF ;
    public final String entryRuleextendedID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleextendedID = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6113:2: (iv_ruleextendedID= ruleextendedID EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6114:2: iv_ruleextendedID= ruleextendedID EOF
            {
             newCompositeNode(grammarAccess.getExtendedIDRule()); 
            pushFollow(FOLLOW_ruleextendedID_in_entryRuleextendedID14306);
            iv_ruleextendedID=ruleextendedID();

            state._fsp--;

             current =iv_ruleextendedID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleextendedID14317); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleextendedID"


    // $ANTLR start "ruleextendedID"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6121:1: ruleextendedID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleextendedID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6124:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6125:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6125:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6125:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID14357); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_0()); 
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6132:1: (kw= '.' this_ID_2= RULE_ID )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==107) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6133:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,107,FOLLOW_107_in_ruleextendedID14376); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getExtendedIDAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID14391); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleextendedID"


    // $ANTLR start "entryRuleDOUBLE"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6153:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6154:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6155:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             newCompositeNode(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE14439);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOUBLE14450); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6162:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6165:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6166:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6166:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6166:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE14490); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
                
            kw=(Token)match(input,107,FOLLOW_107_in_ruleDOUBLE14508); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE14523); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "entryRuleCHARS"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6196:1: entryRuleCHARS returns [String current=null] : iv_ruleCHARS= ruleCHARS EOF ;
    public final String entryRuleCHARS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCHARS = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6197:2: (iv_ruleCHARS= ruleCHARS EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6198:2: iv_ruleCHARS= ruleCHARS EOF
            {
             newCompositeNode(grammarAccess.getCHARSRule()); 
            pushFollow(FOLLOW_ruleCHARS_in_entryRuleCHARS14571);
            iv_ruleCHARS=ruleCHARS();

            state._fsp--;

             current =iv_ruleCHARS.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCHARS14582); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCHARS"


    // $ANTLR start "ruleCHARS"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6205:1: ruleCHARS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleCHARS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_extendedID_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6208:28: ( (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6209:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6209:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ID) ) {
                alt90=1;
            }
            else if ( (LA90_0==RULE_INT) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6210:5: this_extendedID_0= ruleextendedID
                    {
                     
                            newCompositeNode(grammarAccess.getCHARSAccess().getExtendedIDParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCHARS14629);
                    this_extendedID_0=ruleextendedID();

                    state._fsp--;


                    		current.merge(this_extendedID_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6221:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCHARS14655); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getCHARSAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCHARS"


    // $ANTLR start "ruleModifier"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6236:1: ruleModifier returns [Enumerator current=null] : ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) ) ;
    public final Enumerator ruleModifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6238:28: ( ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6239:1: ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6239:1: ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) )
            int alt91=5;
            switch ( input.LA(1) ) {
            case 108:
                {
                alt91=1;
                }
                break;
            case 109:
                {
                alt91=2;
                }
                break;
            case 110:
                {
                alt91=3;
                }
                break;
            case 111:
                {
                alt91=4;
                }
                break;
            case 112:
                {
                alt91=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6239:2: (enumLiteral_0= 'immutable' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6239:2: (enumLiteral_0= 'immutable' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6239:4: enumLiteral_0= 'immutable'
                    {
                    enumLiteral_0=(Token)match(input,108,FOLLOW_108_in_ruleModifier14714); 

                            current = grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6245:6: (enumLiteral_1= 'settable' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6245:6: (enumLiteral_1= 'settable' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6245:8: enumLiteral_1= 'settable'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_109_in_ruleModifier14731); 

                            current = grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6251:6: (enumLiteral_2= 'internal' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6251:6: (enumLiteral_2= 'internal' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6251:8: enumLiteral_2= 'internal'
                    {
                    enumLiteral_2=(Token)match(input,110,FOLLOW_110_in_ruleModifier14748); 

                            current = grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6257:6: (enumLiteral_3= 'defaulted' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6257:6: (enumLiteral_3= 'defaulted' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6257:8: enumLiteral_3= 'defaulted'
                    {
                    enumLiteral_3=(Token)match(input,111,FOLLOW_111_in_ruleModifier14765); 

                            current = grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6263:6: (enumLiteral_4= 'const' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6263:6: (enumLiteral_4= 'const' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6263:8: enumLiteral_4= 'const'
                    {
                    enumLiteral_4=(Token)match(input,112,FOLLOW_112_in_ruleModifier14782); 

                            current = grammarAccess.getModifierAccess().getCONSTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getModifierAccess().getCONSTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifier"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA68 dfa68 = new DFA68(this);
    static final String DFA10_eotS =
        "\20\uffff";
    static final String DFA10_eofS =
        "\20\uffff";
    static final String DFA10_minS =
        "\1\5\1\uffff\1\5\3\uffff\3\5\2\uffff\1\6\1\uffff\1\21\2\5";
    static final String DFA10_maxS =
        "\1\160\1\uffff\1\153\3\uffff\2\113\1\5\2\uffff\1\63\1\uffff\1\153"+
        "\2\45";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\3\uffff\1\7\1\6\1\uffff\1\5\3"+
        "\uffff";
    static final String DFA10_specialS =
        "\20\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\6\30\uffff\1\5\7\uffff\1\4\1\uffff\4\4\2\1\4\uffff\1"+
            "\7\12\uffff\2\3\13\1\41\uffff\5\1",
            "",
            "\1\1\13\uffff\1\11\2\uffff\1\1\32\uffff\2\1\1\uffff\1\11\70"+
            "\uffff\1\10",
            "",
            "",
            "",
            "\1\12\33\uffff\4\12\1\14\45\uffff\1\13",
            "\1\12\33\uffff\4\12\1\14\45\uffff\1\13",
            "\1\15",
            "",
            "",
            "\1\16\54\uffff\1\17",
            "",
            "\1\11\2\uffff\1\1\33\uffff\1\1\1\uffff\1\11\70\uffff\1\10",
            "\1\12\33\uffff\4\12\1\14",
            "\1\12\33\uffff\4\12\1\14"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "838:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine )";
        }
    }
    static final String DFA11_eotS =
        "\20\uffff";
    static final String DFA11_eofS =
        "\20\uffff";
    static final String DFA11_minS =
        "\1\5\1\uffff\1\5\3\uffff\3\5\1\uffff\1\6\2\uffff\1\21\2\5";
    static final String DFA11_maxS =
        "\1\160\1\uffff\1\153\3\uffff\2\113\1\5\1\uffff\1\63\2\uffff\1\153"+
        "\2\45";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\3\uffff\1\7\1\uffff\1\6\1\5\3"+
        "\uffff";
    static final String DFA11_specialS =
        "\20\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\6\30\uffff\1\5\7\uffff\1\4\1\uffff\4\4\2\1\4\uffff\1"+
            "\7\12\uffff\2\3\13\1\41\uffff\5\1",
            "",
            "\1\1\13\uffff\1\11\2\uffff\1\1\32\uffff\2\1\1\uffff\1\11\70"+
            "\uffff\1\10",
            "",
            "",
            "",
            "\1\13\33\uffff\4\13\1\14\45\uffff\1\12",
            "\1\13\33\uffff\4\13\1\14\45\uffff\1\12",
            "\1\15",
            "",
            "\1\16\54\uffff\1\17",
            "",
            "",
            "\1\11\2\uffff\1\1\33\uffff\1\1\1\uffff\1\11\70\uffff\1\10",
            "\1\13\33\uffff\4\13\1\14",
            "\1\13\33\uffff\4\13\1\14"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "928:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation | this_StateMachine_6= ruleStateMachine )";
        }
    }
    static final String DFA32_eotS =
        "\13\uffff";
    static final String DFA32_eofS =
        "\13\uffff";
    static final String DFA32_minS =
        "\1\5\1\21\2\5\1\uffff\2\21\1\5\2\uffff\1\21";
    static final String DFA32_maxS =
        "\1\5\1\153\2\5\1\uffff\2\153\1\5\2\uffff\1\153";
    static final String DFA32_acceptS =
        "\4\uffff\1\3\3\uffff\1\1\1\2\1\uffff";
    static final String DFA32_specialS =
        "\13\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1",
            "\1\3\40\uffff\1\4\70\uffff\1\2",
            "\1\5",
            "\1\6",
            "",
            "\1\3\40\uffff\1\4\70\uffff\1\2",
            "\1\11\1\10\25\uffff\1\10\102\uffff\1\7",
            "\1\12",
            "",
            "",
            "\1\11\1\10\25\uffff\1\10\102\uffff\1\7"
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "2048:1: (this_Enum_0= ruleEnum | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )";
        }
    }
    static final String DFA37_eotS =
        "\11\uffff";
    static final String DFA37_eofS =
        "\11\uffff";
    static final String DFA37_minS =
        "\1\4\1\uffff\1\21\3\uffff\1\5\1\uffff\1\21";
    static final String DFA37_maxS =
        "\1\134\1\uffff\1\153\3\uffff\1\5\1\uffff\1\153";
    static final String DFA37_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\5\1\uffff\1\4\1\uffff";
    static final String DFA37_specialS =
        "\11\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\5\1\2\3\5\31\uffff\1\5\21\uffff\1\1\1\5\1\uffff\1\1\1\uffff"+
            "\2\3\1\4\1\1\32\uffff\2\5\1\uffff\3\5",
            "",
            "\1\7\2\uffff\1\5\14\uffff\1\1\1\5\15\uffff\1\5\2\uffff\1\5"+
            "\1\uffff\1\5\2\uffff\1\5\3\uffff\1\1\17\uffff\17\5\7\uffff\1"+
            "\5\10\uffff\1\6",
            "",
            "",
            "",
            "\1\10",
            "",
            "\1\7\2\uffff\1\5\14\uffff\1\1\1\5\15\uffff\1\5\2\uffff\1\5"+
            "\1\uffff\1\5\2\uffff\1\5\3\uffff\1\1\17\uffff\17\5\7\uffff\1"+
            "\5\10\uffff\1\6"
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "2375:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity (otherlv_3= '->' ruleextendedID otherlv_5= ';' )? ) | this_State_6= ruleState | (this_expression_7= ruleexpression otherlv_8= ';' ) )";
        }
    }
    static final String DFA68_eotS =
        "\14\uffff";
    static final String DFA68_eofS =
        "\1\uffff\1\7\1\uffff\1\12\7\uffff\1\12";
    static final String DFA68_minS =
        "\1\4\1\23\1\uffff\1\23\4\uffff\1\5\2\uffff\1\23";
    static final String DFA68_maxS =
        "\1\10\1\153\1\uffff\1\153\4\uffff\1\5\2\uffff\1\153";
    static final String DFA68_acceptS =
        "\2\uffff\1\3\1\uffff\1\6\1\7\1\2\1\1\1\uffff\1\5\1\4\1\uffff";
    static final String DFA68_specialS =
        "\14\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\2\1\3\1\1\1\4\1\5",
            "\2\7\15\uffff\1\7\5\uffff\1\7\7\uffff\1\7\2\uffff\1\7\2\uffff"+
            "\1\7\1\uffff\1\7\4\uffff\1\7\16\uffff\17\7\20\uffff\1\6",
            "",
            "\2\12\15\uffff\1\12\5\uffff\1\12\7\uffff\1\12\2\uffff\1\12"+
            "\1\uffff\1\11\1\12\1\uffff\1\12\4\uffff\1\12\16\uffff\17\12"+
            "\7\uffff\1\11\10\uffff\1\10",
            "",
            "",
            "",
            "",
            "\1\13",
            "",
            "",
            "\2\12\15\uffff\1\12\5\uffff\1\12\7\uffff\1\12\2\uffff\1\12"+
            "\1\uffff\1\11\1\12\1\uffff\1\12\4\uffff\1\12\16\uffff\17\12"+
            "\7\uffff\1\11\10\uffff\1\10"
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "4589:1: ( ( () this_INT_1= RULE_INT ) | ( () ruleDOUBLE ) | ( () this_STRING_5= RULE_STRING ) | ( () ruleextendedID ) | this_javaFunctionCall_8= rulejavaFunctionCall | ( () this_TRUE_10= RULE_TRUE ) | ( () this_FALSE_12= RULE_FALSE ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleUmpleModel_in_entryRuleUmpleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_ruleUmpleModel130 = new BitSet(new long[]{0x000200407E210002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleAbstractElement223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlossary_in_ruleAbstractElement250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGenerate_in_ruleAbstractElement277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUseStatement_in_ruleAbstractElement304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleAbstractElement331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlossary_in_entryRuleGlossary366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlossary376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleGlossary422 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGlossary434 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleWord_in_ruleGlossary455 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleGlossary468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWord556 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleWord573 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWord590 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleWord607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGenerate_in_entryRuleGenerate643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGenerate653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleGenerate690 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_22_in_ruleGenerate709 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_23_in_ruleGenerate746 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_24_in_ruleGenerate783 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleGenerate809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUseStatement_in_entryRuleUseStatement845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUseStatement855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleUseStatement892 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUseStatement909 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleUseStatement926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleNamespace1009 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamespace1026 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleNamespace1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassDefinition_in_ruleEntity1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceDefinition_in_ruleEntity1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDefinition_in_ruleEntity1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationDefinition_in_ruleEntity1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationClassDefinition_in_ruleEntity1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachineDefinition_in_ruleEntity1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassDefinition_in_entryRuleClassDefinition1306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassDefinition1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleClassDefinition1353 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDefinition1370 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleClassDefinition1387 = new BitSet(new long[]{0xC0087E8080040060L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleClassContent_in_ruleClassDefinition1408 = new BitSet(new long[]{0xC0087E8080040060L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_18_in_ruleClassDefinition1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDefinition_in_entryRuleExternalDefinition1457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDefinition1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleExternalDefinition1504 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalDefinition1521 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleExternalDefinition1538 = new BitSet(new long[]{0xC0087E8080040060L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleClassContent_in_ruleExternalDefinition1559 = new BitSet(new long[]{0xC0087E8080040060L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_18_in_ruleExternalDefinition1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceDefinition_in_entryRuleInterfaceDefinition1608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceDefinition1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleInterfaceDefinition1655 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterfaceDefinition1672 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInterfaceDefinition1689 = new BitSet(new long[]{0x0000000080040000L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleInterfaceDefinition1710 = new BitSet(new long[]{0x0000000080040000L});
    public static final BitSet FOLLOW_18_in_ruleInterfaceDefinition1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationDefinition_in_entryRuleAssociationDefinition1759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationDefinition1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAssociationDefinition1806 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociationDefinition1823 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAssociationDefinition1840 = new BitSet(new long[]{0x0008000000040040L});
    public static final BitSet FOLLOW_ruleAssociation_in_ruleAssociationDefinition1861 = new BitSet(new long[]{0x0008000000040040L});
    public static final BitSet FOLLOW_18_in_ruleAssociationDefinition1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassContent_in_entryRuleClassContent1910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassContent1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleClassContent1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_ruleClassContent1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwarePattern_in_ruleClassContent2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleClassContent2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleClassContent2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_ruleClassContent2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleClassContent2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationClassContent_in_entryRuleAssociationClassContent2164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationClassContent2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleAssociationClassContent2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_ruleAssociationClassContent2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwarePattern_in_ruleAssociationClassContent2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleAssociationClassContent2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleAssociationClassContent2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_ruleAssociationClassContent2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleAssociationClassContent2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_entryRuleDepend2418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDepend2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDepend2465 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleDepend2486 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_32_in_ruleDepend2499 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleDepend2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociation_in_entryRuleAssociation2549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociation2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation2600 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2616 = new BitSet(new long[]{0x0000001E00000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2638 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_33_in_ruleAssociation2657 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_34_in_ruleAssociation2675 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_35_in_ruleAssociation2693 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_36_in_ruleAssociation2711 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation2728 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2744 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2766 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAssociation2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation2820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation2871 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSymmetricReflexiveAssociation2882 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation2899 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSymmetricReflexiveAssociation2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation2952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineAssociation2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation3003 = new BitSet(new long[]{0x0000001E00000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3019 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_33_in_ruleInlineAssociation3038 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_34_in_ruleInlineAssociation3056 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_35_in_ruleInlineAssociation3074 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_36_in_ruleInlineAssociation3092 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation3109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3125 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3147 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleInlineAssociation3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationClassDefinition_in_entryRuleAssociationClassDefinition3203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationClassDefinition3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleAssociationClassDefinition3250 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociationClassDefinition3267 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAssociationClassDefinition3284 = new BitSet(new long[]{0xC0087E8080040060L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleAssociationClassContent_in_ruleAssociationClassDefinition3305 = new BitSet(new long[]{0xC0087E8080040060L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_18_in_ruleAssociationClassDefinition3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwarePattern_in_entryRuleSoftwarePattern3354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSoftwarePattern3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleisA_in_ruleSoftwarePattern3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleton_in_ruleSoftwarePattern3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyDefinition_in_ruleSoftwarePattern3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeInjection_in_ruleSoftwarePattern3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleisA_in_entryRuleisA3527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleisA3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleisA3574 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleisA3594 = new BitSet(new long[]{0x0000010000100000L});
    public static final BitSet FOLLOW_40_in_ruleisA3607 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleisA3627 = new BitSet(new long[]{0x0000010000100000L});
    public static final BitSet FOLLOW_20_in_ruleisA3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleton_in_entryRuleSingleton3677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleton3687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleSingleton3730 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSingleton3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyDefinition_in_entryRuleKeyDefinition3791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyDefinition3801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleKeyDefinition3838 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKeyDefinition3859 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyDefinition3877 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_40_in_ruleKeyDefinition3895 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyDefinition3912 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_18_in_ruleKeyDefinition3933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection3969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodeInjection3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleCodeInjection4017 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection4038 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodeInjection4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleCodeInjection4080 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection4101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodeInjection4118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute4160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleAttribute4214 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleAttribute4248 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAttribute4260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleAttribute4286 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleModifier_in_ruleAttribute4321 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_ruleAttribute4345 = new BitSet(new long[]{0x0000E00000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_47_in_ruleAttribute4363 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute4405 = new BitSet(new long[]{0x0000E00000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_47_in_ruleAttribute4423 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleAttribute4461 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_ruleAttribute4474 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_ruleAttribute4495 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAttribute4509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachineDefinition_in_entryRuleStateMachineDefinition4546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachineDefinition4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleStateMachineDefinition4593 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleStateMachineDefinition4614 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStateMachineDefinition4626 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachineDefinition4647 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleStateMachineDefinition4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine4695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine4705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnum_in_ruleStateMachine4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStateMachine_in_ruleStateMachine4779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedStateMachine_in_ruleStateMachine4806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStateMachine_in_entryRuleInlineStateMachine4841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineStateMachine4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleInlineStateMachine4897 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInlineStateMachine4909 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleState_in_ruleInlineStateMachine4930 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleInlineStateMachine4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedStateMachine_in_entryRuleReferencedStateMachine4978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedStateMachine4988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleReferencedStateMachine5034 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleReferencedStateMachine5046 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedStateMachine5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnum_in_entryRuleEnum5102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnum5112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleEnum5158 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEnum5170 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleEnum5191 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_40_in_ruleEnum5204 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleEnum5225 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_18_in_ruleEnum5239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState5275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState5285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleState5331 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState5343 = new BitSet(new long[]{0x1EB86004000401F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_51_in_ruleState5357 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleStateEntity_in_ruleState5380 = new BitSet(new long[]{0x1EB86004000401F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_18_in_ruleState5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateEntity_in_entryRuleStateEntity5430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateEntity5440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateEntity5487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryOrExitAction_in_ruleStateEntity5514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivity_in_ruleStateEntity5542 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleStateEntity5554 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleStateEntity5570 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleStateEntity5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateEntity5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleStateEntity5640 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleStateEntity5651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition5688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTransition5746 = new BitSet(new long[]{0x1090600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleTransition5766 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleTransition5778 = new BitSet(new long[]{0x0100600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransition5799 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleTransition5821 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTransition5833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleTransition5863 = new BitSet(new long[]{0x1000000200000000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTransition5883 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleTransition5896 = new BitSet(new long[]{0x0100600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransition5917 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleTransition5939 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTransition5951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition5988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition5998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAfterEveryEvent_in_ruleEventDefinition6045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAfterEvent_in_ruleEventDefinition6072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleEventDefinition6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent6134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleEvent6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAfterEveryEvent_in_entryRuleAfterEveryEvent6224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAfterEveryEvent6234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleAfterEveryEvent6271 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleAfterEveryEvent6283 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleAfterEveryEvent6304 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleAfterEveryEvent6316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAfterEvent_in_entryRuleAfterEvent6352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAfterEvent6362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleAfterEvent6399 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleAfterEvent6411 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleAfterEvent6432 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleAfterEvent6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction6480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleAction6527 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleAction6548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryOrExitAction_in_entryRuleEntryOrExitAction6584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryOrExitAction6594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleEntryOrExitAction6638 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_58_in_ruleEntryOrExitAction6675 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleEntryOrExitAction6701 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleEntryOrExitAction6722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivity_in_entryRuleActivity6758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivity6768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleActivity6805 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleActivity6817 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleActivity6838 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleActivity6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard6886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard6896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleGuard6933 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleGuardCode_in_ruleGuard6955 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleGuard6966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardCode_in_entryRuleGuardCode7002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardCode7012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleGuardCode7058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_entryRulePosition7092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePosition7102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_rulePosition7149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementPosition_in_rulePosition7176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementPosition_in_entryRuleElementPosition7211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementPosition7221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleElementPosition7258 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition7275 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition7297 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition7319 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition7341 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleElementPosition7358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition7394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationPosition7404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAssociationPosition7441 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociationPosition7458 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition7484 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition7505 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAssociationPosition7517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinate_in_entryRuleCoordinate7553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinate7563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate7605 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleCoordinate7622 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate7639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType7681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAttributeType7692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleUmpleAttributeType7730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleUmpleAttributeType7749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleUmpleAttributeType7768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleUmpleAttributeType7787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleUmpleAttributeType7806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleUmpleAttributeType7825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleUmpleAttributeType7844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleUmpleAttributeType7863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleUmpleAttributeType7882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleUmpleAttributeType7901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleUmpleAttributeType7920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType7961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmplePrimitiveType7972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUmplePrimitiveType8012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType8038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_entryRulemultiplicity8084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicity8095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity8142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity8176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_rulemultiplicity8194 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity8216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_entryRulebound8263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulebound8274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulebound8314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rulebound8338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_entryRuleblock8380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblock8390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleblock8436 = new BitSet(new long[]{0x1EB86004001601F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_ruleblockStatement_in_ruleblock8457 = new BitSet(new long[]{0x1EB86004001601F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_18_in_ruleblock8470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_entryRuleparExpression8506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleparExpression8516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleparExpression8553 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_ruleparExpression8575 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleparExpression8586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator8623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleassignmentOperator8634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleassignmentOperator8672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleassignmentOperator8691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleassignmentOperator8710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_entryRuleexpressionList8750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpressionList8760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList8806 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleexpressionList8819 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList8840 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_entryRuleexpression8878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpression8888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_ruleexpression8934 = new BitSet(new long[]{0x0001000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_ruleexpression8951 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpression8971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression9009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalExpression9019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression9065 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleconditionalExpression9078 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression9099 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleconditionalExpression9111 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression9132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression9170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalOrExpression9180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression9226 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleconditionalOrExpression9239 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression9260 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression9298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalAndExpression9308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression9354 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleconditionalAndExpression9367 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression9388 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression9426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleequalityExpression9436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression9482 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
    public static final BitSet FOLLOW_81_in_ruleequalityExpression9496 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_82_in_ruleequalityExpression9514 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression9536 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression9574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalExpression9584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression9630 = new BitSet(new long[]{0x0000000000000002L,0x0000000000780000L});
    public static final BitSet FOLLOW_rulerelationalOp_in_rulerelationalExpression9647 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression9667 = new BitSet(new long[]{0x0000000000000002L,0x0000000000780000L});
    public static final BitSet FOLLOW_rulerelationalOp_in_entryRulerelationalOp9706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalOp9717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_rulerelationalOp9755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rulerelationalOp9774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rulerelationalOp9793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rulerelationalOp9812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression9852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleadditiveExpression9862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression9908 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_87_in_ruleadditiveExpression9922 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_88_in_ruleadditiveExpression9940 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression9962 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression10000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicativeExpression10010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression10056 = new BitSet(new long[]{0x0108000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_51_in_rulemultiplicativeExpression10070 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_56_in_rulemultiplicativeExpression10088 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_89_in_rulemultiplicativeExpression10106 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression10128 = new BitSet(new long[]{0x0108000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression10166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpression10176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleunaryExpression10214 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression10235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleunaryExpression10255 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression10276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleunaryExpression10296 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression10317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleunaryExpression10337 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression10358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression10386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus10422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus10432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleunaryExpressionNotPlusMinus10470 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus10492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleunaryExpressionNotPlusMinus10511 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus10533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus10562 = new BitSet(new long[]{0x0000000400000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleunaryExpressionNotPlusMinus10574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleunaryExpressionNotPlusMinus10592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_entryRuleprimary10631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimary10641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_ruleprimary10688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_ruleprimary10715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_entryRuleliteral10750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleliteral10760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleliteral10806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleliteral10838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleliteral10865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleliteral10897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_ruleliteral10925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TRUE_in_ruleliteral10951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FALSE_in_ruleliteral10978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration11020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDeclaration11030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_rulejavaFunctionDeclaration11068 = new BitSet(new long[]{0x0000000000000000L,0x00000001C0000000L});
    public static final BitSet FOLLOW_94_in_rulejavaFunctionDeclaration11083 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3DA1D8007FFL});
    public static final BitSet FOLLOW_95_in_rulejavaFunctionDeclaration11101 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3DA1D8007FFL});
    public static final BitSet FOLLOW_96_in_rulejavaFunctionDeclaration11119 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3DA1D8007FFL});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration11142 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_97_in_rulejavaFunctionDeclaration11160 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration11183 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration11206 = new BitSet(new long[]{0x0020000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_53_in_rulejavaFunctionDeclaration11225 = new BitSet(new long[]{0x1EF86004001201F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration11247 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration11268 = new BitSet(new long[]{0x0040010000000000L});
    public static final BitSet FOLLOW_40_in_rulejavaFunctionDeclaration11281 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration11302 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration11323 = new BitSet(new long[]{0x0040010000000000L});
    public static final BitSet FOLLOW_54_in_rulejavaFunctionDeclaration11339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rulejavaFunctionDeclaration11358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition11395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDefinition11405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition11451 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_rulejavaFunctionDefinition11472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall11508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionCall11518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionCall11564 = new BitSet(new long[]{0x0020000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_53_in_rulejavaFunctionCall11578 = new BitSet(new long[]{0x1EF86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpressionList_in_rulejavaFunctionCall11599 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_rulejavaFunctionCall11612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rulejavaFunctionCall11631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblockStatement_in_entryRuleblockStatement11668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblockStatement11678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_ruleblockStatement11725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement11752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement11787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement11797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement11844 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rulelocalVariableDeclarationStatement11855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration11891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclaration11901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration11947 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration11968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators12004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarators12014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators12060 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_rulevariableDeclarators12073 = new BitSet(new long[]{0x0000600000000020L,0x0001F000000007FFL});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators12094 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator12132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarator12142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulevariableDeclarator12188 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_rulevariableDeclarator12201 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_rulevariableDeclarator12222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_entryRulestatement12260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulestatement12270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement12317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleifstatement_in_rulestatement12344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforstatement_in_rulestatement12371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulewhilestatement_in_rulestatement12398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulereturnstatement_in_rulestatement12425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleendstatement_in_rulestatement12452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebreakstatement_in_rulestatement12479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionstatement_in_rulestatement12506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrystatement_in_rulestatement12533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleendstatement_in_entryRuleendstatement12568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleendstatement12578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleendstatement12624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebreakstatement_in_entryRulebreakstatement12660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulebreakstatement12670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_rulebreakstatement12716 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rulebreakstatement12728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleifstatement_in_entryRuleifstatement12764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleifstatement12774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleifstatement12820 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_ruleparExpression_in_ruleifstatement12841 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_rulestatement_in_ruleifstatement12862 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleifstatement12875 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_rulestatement_in_ruleifstatement12896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforstatement_in_entryRuleforstatement12934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforstatement12944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleforstatement12990 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleforstatement13002 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_ruleforControl_in_ruleforstatement13023 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleforstatement13035 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_rulestatement_in_ruleforstatement13056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulewhilestatement_in_entryRulewhilestatement13092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulewhilestatement13102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_rulewhilestatement13148 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_ruleparExpression_in_rulewhilestatement13169 = new BitSet(new long[]{0x1EB86004001201F0L,0x0001F3D81D8007FFL});
    public static final BitSet FOLLOW_rulestatement_in_rulewhilestatement13190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulereturnstatement_in_entryRulereturnstatement13226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulereturnstatement13236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_rulereturnstatement13282 = new BitSet(new long[]{0x1EB86004001001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_rulereturnstatement13303 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_rulereturnstatement13316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionstatement_in_entryRuleexpressionstatement13352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpressionstatement13362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionstatement13409 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleexpressionstatement13420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrystatement_in_entryRuletrystatement13456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletrystatement13466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruletrystatement13512 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruletrystatement13533 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_ruletrystatement13545 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruletrystatement13566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforControl_in_entryRuleforControl13602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforControl13612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_ruleforControl13667 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleforControl13680 = new BitSet(new long[]{0x1EB86004001001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforControl13701 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleforControl13714 = new BitSet(new long[]{0x1EB86004000001F2L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleforUpdate_in_ruleforControl13735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_entryRuleforInit13772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforInit13782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit13829 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleforInit13842 = new BitSet(new long[]{0x1EB86004000001F0L,0x0001F0001D8007FFL});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit13863 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_ruleforInit13894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforUpdate_in_entryRuleforUpdate13929 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforUpdate13939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_ruleforUpdate13985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_entryRuleattributeType14020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleattributeType14031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleattributeType14069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleattributeType14088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleattributeType14107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleattributeType14126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleattributeType14145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleattributeType14164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleattributeType14183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleattributeType14202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleattributeType14221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleattributeType14240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleattributeType14259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_entryRuleextendedID14306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleextendedID14317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID14357 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_ruleextendedID14376 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID14391 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE14439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE14450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE14490 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_ruleDOUBLE14508 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE14523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCHARS_in_entryRuleCHARS14571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCHARS14582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCHARS14629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCHARS14655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleModifier14714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleModifier14731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleModifier14748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleModifier14765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleModifier14782 = new BitSet(new long[]{0x0000000000000002L});

}