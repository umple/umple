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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_DEF", "RULE_END", "RULE_RUBY_FUNCTION", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'glossary'", "'{'", "'}'", "':'", "';'", "'generate'", "'Java'", "'Php'", "'Ruby'", "'use'", "'namespace'", "'class'", "'external'", "'interface'", "'association'", "'depend'", "'.*'", "'->'", "'--'", "'<-'", "'><'", "'self'", "'associationClass'", "'isA'", "','", "'singleton'", "'key'", "'before'", "'after'", "'autounique'", "'unique'", "'[]'", "'='", "'position'", "'position.association'", "'Date'", "'Time'", "'Double'", "'double'", "'Integer'", "'integer'", "'int'", "'Boolean'", "'boolean'", "'String'", "'string'", "'..'", "'*'", "'('", "')'", "'+='", "'-='", "'?'", "'||'", "'&&'", "'=='", "'!='", "'<='", "'<'", "'>='", "'>'", "'+'", "'-'", "'/'", "'%'", "'++'", "'~'", "'!'", "'true'", "'TRUE'", "'false'", "'FALSE'", "'static'", "'public'", "'private'", "'protected'", "'void'", "'()'", "'if'", "'else'", "'for'", "'while'", "'return'", "'break'", "'try'", "'catch'", "'.'", "'immutable'", "'settable'", "'internal'", "'defaulted'", "'const'"
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
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int RULE_RUBY_FUNCTION=9;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
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
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_STRING=4;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int RULE_END=8;
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
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int RULE_INT=6;
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
    public static final int RULE_SL_COMMENT=11;
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
    public static final int RULE_DEF=7;
    public static final int RULE_WS=12;

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

                if ( (LA1_0==14||LA1_0==19||(LA1_0>=23 && LA1_0<=28)||LA1_0==36) ) {
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
            case 24:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 19:
                {
                alt2=3;
                }
                break;
            case 23:
                {
                alt2=4;
                }
                break;
            case 25:
            case 26:
            case 27:
            case 28:
            case 36:
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleGlossary422); 

                	newLeafNode(otherlv_1, grammarAccess.getGlossaryAccess().getGlossaryKeyword_1());
                
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleGlossary434); 

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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleGlossary468); 

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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleWord573); 

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

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleWord607); 

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
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleGenerate690); 

                	newLeafNode(otherlv_0, grammarAccess.getGenerateAccess().getGenerateKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:316:1: ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt4=1;
                }
                break;
            case 21:
                {
                alt4=2;
                }
                break;
            case 22:
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
                    lv_java_1_0=(Token)match(input,20,FOLLOW_20_in_ruleGenerate709); 

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
                    lv_Php_2_0=(Token)match(input,21,FOLLOW_21_in_ruleGenerate746); 

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
                    lv_Ruby_3_0=(Token)match(input,22,FOLLOW_22_in_ruleGenerate783); 

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

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleGenerate809); 

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
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleUseStatement892); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleUseStatement926); 

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
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleNamespace1009); 

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

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleNamespace1043); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:478:1: ruleEntity returns [EObject current=null] : (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_ClassDefinition_0 = null;

        EObject this_InterfaceDefinition_1 = null;

        EObject this_ExternalDefinition_2 = null;

        EObject this_AssociationDefinition_3 = null;

        EObject this_AssociationClassDefinition_4 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:481:28: ( (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:482:1: (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:482:1: (this_ClassDefinition_0= ruleClassDefinition | this_InterfaceDefinition_1= ruleInterfaceDefinition | this_ExternalDefinition_2= ruleExternalDefinition | this_AssociationDefinition_3= ruleAssociationDefinition | this_AssociationClassDefinition_4= ruleAssociationClassDefinition )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt5=1;
                }
                break;
            case 27:
                {
                alt5=2;
                }
                break;
            case 26:
                {
                alt5=3;
                }
                break;
            case 28:
                {
                alt5=4;
                }
                break;
            case 36:
                {
                alt5=5;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:539:1: entryRuleClassDefinition returns [EObject current=null] : iv_ruleClassDefinition= ruleClassDefinition EOF ;
    public final EObject entryRuleClassDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:540:2: (iv_ruleClassDefinition= ruleClassDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:541:2: iv_ruleClassDefinition= ruleClassDefinition EOF
            {
             newCompositeNode(grammarAccess.getClassDefinitionRule()); 
            pushFollow(FOLLOW_ruleClassDefinition_in_entryRuleClassDefinition1279);
            iv_ruleClassDefinition=ruleClassDefinition();

            state._fsp--;

             current =iv_ruleClassDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassDefinition1289); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:548:1: ruleClassDefinition returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) ;
    public final EObject ruleClassDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_classContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:551:28: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:552:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:552:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:552:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleClassDefinition1326); 

                	newLeafNode(otherlv_0, grammarAccess.getClassDefinitionAccess().getClassKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:556:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:557:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:557:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:558:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDefinition1343); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleClassDefinition1360); 

                	newLeafNode(otherlv_2, grammarAccess.getClassDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:578:1: ( (lv_classContent_3_0= ruleClassContent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_INT)||LA6_0==29||LA6_0==37||(LA6_0>=39 && LA6_0<=44)||(LA6_0>=47 && LA6_0<=59)||LA6_0==61||(LA6_0>=101 && LA6_0<=105)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:579:1: (lv_classContent_3_0= ruleClassContent )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:579:1: (lv_classContent_3_0= ruleClassContent )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:580:3: lv_classContent_3_0= ruleClassContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassDefinitionAccess().getClassContentClassContentParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClassContent_in_ruleClassDefinition1381);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleClassDefinition1394); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:608:1: entryRuleExternalDefinition returns [EObject current=null] : iv_ruleExternalDefinition= ruleExternalDefinition EOF ;
    public final EObject entryRuleExternalDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:609:2: (iv_ruleExternalDefinition= ruleExternalDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:610:2: iv_ruleExternalDefinition= ruleExternalDefinition EOF
            {
             newCompositeNode(grammarAccess.getExternalDefinitionRule()); 
            pushFollow(FOLLOW_ruleExternalDefinition_in_entryRuleExternalDefinition1430);
            iv_ruleExternalDefinition=ruleExternalDefinition();

            state._fsp--;

             current =iv_ruleExternalDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDefinition1440); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:617:1: ruleExternalDefinition returns [EObject current=null] : (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) ;
    public final EObject ruleExternalDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_classContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:620:28: ( (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:621:1: (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:621:1: (otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:621:3: otherlv_0= 'external' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_classContent_3_0= ruleClassContent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleExternalDefinition1477); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalDefinitionAccess().getExternalKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:625:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:626:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:626:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:627:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalDefinition1494); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleExternalDefinition1511); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:647:1: ( (lv_classContent_3_0= ruleClassContent ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||LA7_0==29||LA7_0==37||(LA7_0>=39 && LA7_0<=44)||(LA7_0>=47 && LA7_0<=59)||LA7_0==61||(LA7_0>=101 && LA7_0<=105)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:648:1: (lv_classContent_3_0= ruleClassContent )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:648:1: (lv_classContent_3_0= ruleClassContent )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:649:3: lv_classContent_3_0= ruleClassContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExternalDefinitionAccess().getClassContentClassContentParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClassContent_in_ruleExternalDefinition1532);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleExternalDefinition1545); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:677:1: entryRuleInterfaceDefinition returns [EObject current=null] : iv_ruleInterfaceDefinition= ruleInterfaceDefinition EOF ;
    public final EObject entryRuleInterfaceDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:678:2: (iv_ruleInterfaceDefinition= ruleInterfaceDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:679:2: iv_ruleInterfaceDefinition= ruleInterfaceDefinition EOF
            {
             newCompositeNode(grammarAccess.getInterfaceDefinitionRule()); 
            pushFollow(FOLLOW_ruleInterfaceDefinition_in_entryRuleInterfaceDefinition1581);
            iv_ruleInterfaceDefinition=ruleInterfaceDefinition();

            state._fsp--;

             current =iv_ruleInterfaceDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceDefinition1591); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:686:1: ruleInterfaceDefinition returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' ) ;
    public final EObject ruleInterfaceDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_depend_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:689:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:690:1: (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:690:1: (otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:690:3: otherlv_0= 'interface' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_depend_3_0= ruleDepend ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleInterfaceDefinition1628); 

                	newLeafNode(otherlv_0, grammarAccess.getInterfaceDefinitionAccess().getInterfaceKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:694:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:695:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:695:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:696:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterfaceDefinition1645); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleInterfaceDefinition1662); 

                	newLeafNode(otherlv_2, grammarAccess.getInterfaceDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:716:1: ( (lv_depend_3_0= ruleDepend ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:717:1: (lv_depend_3_0= ruleDepend )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:717:1: (lv_depend_3_0= ruleDepend )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:718:3: lv_depend_3_0= ruleDepend
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInterfaceDefinitionAccess().getDependDependParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDepend_in_ruleInterfaceDefinition1683);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleInterfaceDefinition1696); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:746:1: entryRuleAssociationDefinition returns [EObject current=null] : iv_ruleAssociationDefinition= ruleAssociationDefinition EOF ;
    public final EObject entryRuleAssociationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:747:2: (iv_ruleAssociationDefinition= ruleAssociationDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:748:2: iv_ruleAssociationDefinition= ruleAssociationDefinition EOF
            {
             newCompositeNode(grammarAccess.getAssociationDefinitionRule()); 
            pushFollow(FOLLOW_ruleAssociationDefinition_in_entryRuleAssociationDefinition1732);
            iv_ruleAssociationDefinition=ruleAssociationDefinition();

            state._fsp--;

             current =iv_ruleAssociationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationDefinition1742); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:755:1: ruleAssociationDefinition returns [EObject current=null] : (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' ) ;
    public final EObject ruleAssociationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_association_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:758:28: ( (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:759:1: (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:759:1: (otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:759:3: otherlv_0= 'association' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_association_3_0= ruleAssociation ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleAssociationDefinition1779); 

                	newLeafNode(otherlv_0, grammarAccess.getAssociationDefinitionAccess().getAssociationKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:763:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:764:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:764:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:765:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociationDefinition1796); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleAssociationDefinition1813); 

                	newLeafNode(otherlv_2, grammarAccess.getAssociationDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:785:1: ( (lv_association_3_0= ruleAssociation ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_INT||LA9_0==61) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:786:1: (lv_association_3_0= ruleAssociation )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:786:1: (lv_association_3_0= ruleAssociation )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:787:3: lv_association_3_0= ruleAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssociationDefinitionAccess().getAssociationAssociationParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssociation_in_ruleAssociationDefinition1834);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleAssociationDefinition1847); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:815:1: entryRuleClassContent returns [EObject current=null] : iv_ruleClassContent= ruleClassContent EOF ;
    public final EObject entryRuleClassContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassContent = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:816:2: (iv_ruleClassContent= ruleClassContent EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:817:2: iv_ruleClassContent= ruleClassContent EOF
            {
             newCompositeNode(grammarAccess.getClassContentRule()); 
            pushFollow(FOLLOW_ruleClassContent_in_entryRuleClassContent1883);
            iv_ruleClassContent=ruleClassContent();

            state._fsp--;

             current =iv_ruleClassContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassContent1893); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:824:1: ruleClassContent returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation ) ;
    public final EObject ruleClassContent() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Position_1 = null;

        EObject this_SoftwarePattern_2 = null;

        EObject this_Depend_3 = null;

        EObject this_SymmetricReflexiveAssociation_4 = null;

        EObject this_InlineAssociation_5 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:827:28: ( (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:828:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:828:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation )
            int alt10=6;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:829:5: this_Attribute_0= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleClassContent1940);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:839:5: this_Position_1= rulePosition
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getPositionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePosition_in_ruleClassContent1967);
                    this_Position_1=rulePosition();

                    state._fsp--;

                     
                            current = this_Position_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:849:5: this_SoftwarePattern_2= ruleSoftwarePattern
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getSoftwarePatternParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSoftwarePattern_in_ruleClassContent1994);
                    this_SoftwarePattern_2=ruleSoftwarePattern();

                    state._fsp--;

                     
                            current = this_SoftwarePattern_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:859:5: this_Depend_3= ruleDepend
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getDependParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDepend_in_ruleClassContent2021);
                    this_Depend_3=ruleDepend();

                    state._fsp--;

                     
                            current = this_Depend_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:869:5: this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getSymmetricReflexiveAssociationParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleClassContent2048);
                    this_SymmetricReflexiveAssociation_4=ruleSymmetricReflexiveAssociation();

                    state._fsp--;

                     
                            current = this_SymmetricReflexiveAssociation_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:879:5: this_InlineAssociation_5= ruleInlineAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getClassContentAccess().getInlineAssociationParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleInlineAssociation_in_ruleClassContent2075);
                    this_InlineAssociation_5=ruleInlineAssociation();

                    state._fsp--;

                     
                            current = this_InlineAssociation_5; 
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:895:1: entryRuleAssociationClassContent returns [EObject current=null] : iv_ruleAssociationClassContent= ruleAssociationClassContent EOF ;
    public final EObject entryRuleAssociationClassContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationClassContent = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:896:2: (iv_ruleAssociationClassContent= ruleAssociationClassContent EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:897:2: iv_ruleAssociationClassContent= ruleAssociationClassContent EOF
            {
             newCompositeNode(grammarAccess.getAssociationClassContentRule()); 
            pushFollow(FOLLOW_ruleAssociationClassContent_in_entryRuleAssociationClassContent2110);
            iv_ruleAssociationClassContent=ruleAssociationClassContent();

            state._fsp--;

             current =iv_ruleAssociationClassContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationClassContent2120); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:904:1: ruleAssociationClassContent returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation ) ;
    public final EObject ruleAssociationClassContent() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Position_1 = null;

        EObject this_SoftwarePattern_2 = null;

        EObject this_Depend_3 = null;

        EObject this_SymmetricReflexiveAssociation_4 = null;

        EObject this_InlineAssociation_5 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:907:28: ( (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:908:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:908:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation )
            int alt11=6;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:909:5: this_Attribute_0= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getAttributeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleAssociationClassContent2167);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:919:5: this_Position_1= rulePosition
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getPositionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePosition_in_ruleAssociationClassContent2194);
                    this_Position_1=rulePosition();

                    state._fsp--;

                     
                            current = this_Position_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:929:5: this_SoftwarePattern_2= ruleSoftwarePattern
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getSoftwarePatternParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSoftwarePattern_in_ruleAssociationClassContent2221);
                    this_SoftwarePattern_2=ruleSoftwarePattern();

                    state._fsp--;

                     
                            current = this_SoftwarePattern_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:939:5: this_Depend_3= ruleDepend
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getDependParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDepend_in_ruleAssociationClassContent2248);
                    this_Depend_3=ruleDepend();

                    state._fsp--;

                     
                            current = this_Depend_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:949:5: this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getSymmetricReflexiveAssociationParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleAssociationClassContent2275);
                    this_SymmetricReflexiveAssociation_4=ruleSymmetricReflexiveAssociation();

                    state._fsp--;

                     
                            current = this_SymmetricReflexiveAssociation_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:959:5: this_InlineAssociation_5= ruleInlineAssociation
                    {
                     
                            newCompositeNode(grammarAccess.getAssociationClassContentAccess().getInlineAssociationParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleInlineAssociation_in_ruleAssociationClassContent2302);
                    this_InlineAssociation_5=ruleInlineAssociation();

                    state._fsp--;

                     
                            current = this_InlineAssociation_5; 
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:975:1: entryRuleDepend returns [EObject current=null] : iv_ruleDepend= ruleDepend EOF ;
    public final EObject entryRuleDepend() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDepend = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:976:2: (iv_ruleDepend= ruleDepend EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:977:2: iv_ruleDepend= ruleDepend EOF
            {
             newCompositeNode(grammarAccess.getDependRule()); 
            pushFollow(FOLLOW_ruleDepend_in_entryRuleDepend2337);
            iv_ruleDepend=ruleDepend();

            state._fsp--;

             current =iv_ruleDepend; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDepend2347); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:984:1: ruleDepend returns [EObject current=null] : (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' ) ;
    public final EObject ruleDepend() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:987:28: ( (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:988:1: (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:988:1: (otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:988:3: otherlv_0= 'depend' ( (lv_name_1_0= ruleextendedID ) ) (otherlv_2= '.*' )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleDepend2384); 

                	newLeafNode(otherlv_0, grammarAccess.getDependAccess().getDependKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:992:1: ( (lv_name_1_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:993:1: (lv_name_1_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:993:1: (lv_name_1_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:994:3: lv_name_1_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getDependAccess().getNameExtendedIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleDepend2405);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1010:2: (otherlv_2= '.*' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1010:4: otherlv_2= '.*'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleDepend2418); 

                        	newLeafNode(otherlv_2, grammarAccess.getDependAccess().getFullStopAsteriskKeyword_2());
                        

                    }
                    break;

            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleDepend2432); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1026:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1027:2: (iv_ruleAssociation= ruleAssociation EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1028:2: iv_ruleAssociation= ruleAssociation EOF
            {
             newCompositeNode(grammarAccess.getAssociationRule()); 
            pushFollow(FOLLOW_ruleAssociation_in_entryRuleAssociation2468);
            iv_ruleAssociation=ruleAssociation();

            state._fsp--;

             current =iv_ruleAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociation2478); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1035:1: ruleAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1038:28: ( ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1039:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1039:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1040:5: rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? otherlv_10= ';'
            {
             
                    newCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation2519);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1047:1: ( (lv_type1_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1048:1: (lv_type1_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1048:1: (lv_type1_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1049:3: lv_type1_1_0= RULE_ID
            {
            lv_type1_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2535); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1065:2: ( (lv_rolename1_2_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1066:1: (lv_rolename1_2_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1066:1: (lv_rolename1_2_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1067:3: lv_rolename1_2_0= RULE_ID
                    {
                    lv_rolename1_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2557); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1083:3: (otherlv_3= '->' | otherlv_4= '--' | otherlv_5= '<-' | otherlv_6= '><' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt14=1;
                }
                break;
            case 32:
                {
                alt14=2;
                }
                break;
            case 33:
                {
                alt14=3;
                }
                break;
            case 34:
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1083:5: otherlv_3= '->'
                    {
                    otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleAssociation2576); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssociationAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1088:7: otherlv_4= '--'
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleAssociation2594); 

                        	newLeafNode(otherlv_4, grammarAccess.getAssociationAccess().getHyphenMinusHyphenMinusKeyword_3_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1093:7: otherlv_5= '<-'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleAssociation2612); 

                        	newLeafNode(otherlv_5, grammarAccess.getAssociationAccess().getLessThanSignHyphenMinusKeyword_3_2());
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1098:7: otherlv_6= '><'
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleAssociation2630); 

                        	newLeafNode(otherlv_6, grammarAccess.getAssociationAccess().getGreaterThanSignLessThanSignKeyword_3_3());
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_4()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation2647);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1110:1: ( (lv_type2_8_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1111:1: (lv_type2_8_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1111:1: (lv_type2_8_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1112:3: lv_type2_8_0= RULE_ID
            {
            lv_type2_8_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2663); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1128:2: ( (lv_rolename2_9_0= RULE_ID ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1129:1: (lv_rolename2_9_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1129:1: (lv_rolename2_9_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1130:3: lv_rolename2_9_0= RULE_ID
                    {
                    lv_rolename2_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2685); 

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

            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleAssociation2703); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1158:1: entryRuleSymmetricReflexiveAssociation returns [EObject current=null] : iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF ;
    public final EObject entryRuleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymmetricReflexiveAssociation = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1159:2: (iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1160:2: iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF
            {
             newCompositeNode(grammarAccess.getSymmetricReflexiveAssociationRule()); 
            pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation2739);
            iv_ruleSymmetricReflexiveAssociation=ruleSymmetricReflexiveAssociation();

            state._fsp--;

             current =iv_ruleSymmetricReflexiveAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation2749); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1167:1: ruleSymmetricReflexiveAssociation returns [EObject current=null] : ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_rolename_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1170:28: ( ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1171:1: ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1171:1: ( rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1172:5: rulemultiplicity otherlv_1= 'self' ( (lv_rolename_2_0= RULE_ID ) ) otherlv_3= ';'
            {
             
                    newCompositeNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getMultiplicityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation2790);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleSymmetricReflexiveAssociation2801); 

                	newLeafNode(otherlv_1, grammarAccess.getSymmetricReflexiveAssociationAccess().getSelfKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1183:1: ( (lv_rolename_2_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1184:1: (lv_rolename_2_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1184:1: (lv_rolename_2_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1185:3: lv_rolename_2_0= RULE_ID
            {
            lv_rolename_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation2818); 

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

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleSymmetricReflexiveAssociation2835); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1213:1: entryRuleInlineAssociation returns [EObject current=null] : iv_ruleInlineAssociation= ruleInlineAssociation EOF ;
    public final EObject entryRuleInlineAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineAssociation = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1214:2: (iv_ruleInlineAssociation= ruleInlineAssociation EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1215:2: iv_ruleInlineAssociation= ruleInlineAssociation EOF
            {
             newCompositeNode(grammarAccess.getInlineAssociationRule()); 
            pushFollow(FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation2871);
            iv_ruleInlineAssociation=ruleInlineAssociation();

            state._fsp--;

             current =iv_ruleInlineAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineAssociation2881); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1222:1: ruleInlineAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1225:28: ( ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1226:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1226:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1227:5: rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? otherlv_9= ';'
            {
             
                    newCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation2922);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1234:1: ( (lv_rolename1_1_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1235:1: (lv_rolename1_1_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1235:1: (lv_rolename1_1_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1236:3: lv_rolename1_1_0= RULE_ID
                    {
                    lv_rolename1_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation2938); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1252:3: (otherlv_2= '->' | otherlv_3= '--' | otherlv_4= '<-' | otherlv_5= '><' )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt17=1;
                }
                break;
            case 32:
                {
                alt17=2;
                }
                break;
            case 33:
                {
                alt17=3;
                }
                break;
            case 34:
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1252:5: otherlv_2= '->'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleInlineAssociation2957); 

                        	newLeafNode(otherlv_2, grammarAccess.getInlineAssociationAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1257:7: otherlv_3= '--'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleInlineAssociation2975); 

                        	newLeafNode(otherlv_3, grammarAccess.getInlineAssociationAccess().getHyphenMinusHyphenMinusKeyword_2_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1262:7: otherlv_4= '<-'
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleInlineAssociation2993); 

                        	newLeafNode(otherlv_4, grammarAccess.getInlineAssociationAccess().getLessThanSignHyphenMinusKeyword_2_2());
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1267:7: otherlv_5= '><'
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleInlineAssociation3011); 

                        	newLeafNode(otherlv_5, grammarAccess.getInlineAssociationAccess().getGreaterThanSignLessThanSignKeyword_2_3());
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_3()); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation3028);
            rulemultiplicity();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1279:1: ( (lv_type_7_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1280:1: (lv_type_7_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1280:1: (lv_type_7_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1281:3: lv_type_7_0= RULE_ID
            {
            lv_type_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3044); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1297:2: ( (lv_rolename2_8_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1298:1: (lv_rolename2_8_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1298:1: (lv_rolename2_8_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1299:3: lv_rolename2_8_0= RULE_ID
                    {
                    lv_rolename2_8_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3066); 

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

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_ruleInlineAssociation3084); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1329:1: entryRuleAssociationClassDefinition returns [EObject current=null] : iv_ruleAssociationClassDefinition= ruleAssociationClassDefinition EOF ;
    public final EObject entryRuleAssociationClassDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationClassDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1330:2: (iv_ruleAssociationClassDefinition= ruleAssociationClassDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1331:2: iv_ruleAssociationClassDefinition= ruleAssociationClassDefinition EOF
            {
             newCompositeNode(grammarAccess.getAssociationClassDefinitionRule()); 
            pushFollow(FOLLOW_ruleAssociationClassDefinition_in_entryRuleAssociationClassDefinition3122);
            iv_ruleAssociationClassDefinition=ruleAssociationClassDefinition();

            state._fsp--;

             current =iv_ruleAssociationClassDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationClassDefinition3132); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1338:1: ruleAssociationClassDefinition returns [EObject current=null] : (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' ) ;
    public final EObject ruleAssociationClassDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_associationClassContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1341:28: ( (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1342:1: (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1342:1: (otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1342:3: otherlv_0= 'associationClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleAssociationClassDefinition3169); 

                	newLeafNode(otherlv_0, grammarAccess.getAssociationClassDefinitionAccess().getAssociationClassKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1346:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1347:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1347:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1348:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociationClassDefinition3186); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleAssociationClassDefinition3203); 

                	newLeafNode(otherlv_2, grammarAccess.getAssociationClassDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1368:1: ( (lv_associationClassContent_3_0= ruleAssociationClassContent ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_INT)||LA19_0==29||LA19_0==37||(LA19_0>=39 && LA19_0<=44)||(LA19_0>=47 && LA19_0<=59)||LA19_0==61||(LA19_0>=101 && LA19_0<=105)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1369:1: (lv_associationClassContent_3_0= ruleAssociationClassContent )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1369:1: (lv_associationClassContent_3_0= ruleAssociationClassContent )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1370:3: lv_associationClassContent_3_0= ruleAssociationClassContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssociationClassDefinitionAccess().getAssociationClassContentAssociationClassContentParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssociationClassContent_in_ruleAssociationClassDefinition3224);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleAssociationClassDefinition3237); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1398:1: entryRuleSoftwarePattern returns [EObject current=null] : iv_ruleSoftwarePattern= ruleSoftwarePattern EOF ;
    public final EObject entryRuleSoftwarePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftwarePattern = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1399:2: (iv_ruleSoftwarePattern= ruleSoftwarePattern EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1400:2: iv_ruleSoftwarePattern= ruleSoftwarePattern EOF
            {
             newCompositeNode(grammarAccess.getSoftwarePatternRule()); 
            pushFollow(FOLLOW_ruleSoftwarePattern_in_entryRuleSoftwarePattern3273);
            iv_ruleSoftwarePattern=ruleSoftwarePattern();

            state._fsp--;

             current =iv_ruleSoftwarePattern; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSoftwarePattern3283); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1407:1: ruleSoftwarePattern returns [EObject current=null] : (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection ) ;
    public final EObject ruleSoftwarePattern() throws RecognitionException {
        EObject current = null;

        EObject this_isA_0 = null;

        EObject this_Singleton_1 = null;

        EObject this_KeyDefinition_2 = null;

        EObject this_CodeInjection_3 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1410:28: ( (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1411:1: (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1411:1: (this_isA_0= ruleisA | this_Singleton_1= ruleSingleton | this_KeyDefinition_2= ruleKeyDefinition | this_CodeInjection_3= ruleCodeInjection )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt20=1;
                }
                break;
            case 39:
                {
                alt20=2;
                }
                break;
            case 40:
                {
                alt20=3;
                }
                break;
            case 41:
            case 42:
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1412:5: this_isA_0= ruleisA
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getIsAParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleisA_in_ruleSoftwarePattern3330);
                    this_isA_0=ruleisA();

                    state._fsp--;

                     
                            current = this_isA_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1422:5: this_Singleton_1= ruleSingleton
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getSingletonParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSingleton_in_ruleSoftwarePattern3357);
                    this_Singleton_1=ruleSingleton();

                    state._fsp--;

                     
                            current = this_Singleton_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1432:5: this_KeyDefinition_2= ruleKeyDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getKeyDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleKeyDefinition_in_ruleSoftwarePattern3384);
                    this_KeyDefinition_2=ruleKeyDefinition();

                    state._fsp--;

                     
                            current = this_KeyDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1442:5: this_CodeInjection_3= ruleCodeInjection
                    {
                     
                            newCompositeNode(grammarAccess.getSoftwarePatternAccess().getCodeInjectionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCodeInjection_in_ruleSoftwarePattern3411);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1458:1: entryRuleisA returns [EObject current=null] : iv_ruleisA= ruleisA EOF ;
    public final EObject entryRuleisA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleisA = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1459:2: (iv_ruleisA= ruleisA EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1460:2: iv_ruleisA= ruleisA EOF
            {
             newCompositeNode(grammarAccess.getIsARule()); 
            pushFollow(FOLLOW_ruleisA_in_entryRuleisA3446);
            iv_ruleisA=ruleisA();

            state._fsp--;

             current =iv_ruleisA; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleisA3456); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1467:1: ruleisA returns [EObject current=null] : (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleisA() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1470:28: ( (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1471:1: (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1471:1: (otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1471:3: otherlv_0= 'isA' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleisA3493); 

                	newLeafNode(otherlv_0, grammarAccess.getIsAAccess().getIsAKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1475:1: ( (otherlv_1= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1476:1: (otherlv_1= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1476:1: (otherlv_1= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1477:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getIsARule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleisA3513); 

            		newLeafNode(otherlv_1, grammarAccess.getIsAAccess().getExtendsClassUmpleElementCrossReference_1_0()); 
            	

            }


            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1488:2: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==38) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1488:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleisA3526); 

            	        	newLeafNode(otherlv_2, grammarAccess.getIsAAccess().getCommaKeyword_2_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1492:1: ( (otherlv_3= RULE_ID ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1493:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1493:1: (otherlv_3= RULE_ID )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1494:3: otherlv_3= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getIsARule());
            	    	        }
            	            
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleisA3546); 

            	    		newLeafNode(otherlv_3, grammarAccess.getIsAAccess().getExtendsClassUmpleElementCrossReference_2_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleisA3560); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1517:1: entryRuleSingleton returns [EObject current=null] : iv_ruleSingleton= ruleSingleton EOF ;
    public final EObject entryRuleSingleton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleton = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1518:2: (iv_ruleSingleton= ruleSingleton EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1519:2: iv_ruleSingleton= ruleSingleton EOF
            {
             newCompositeNode(grammarAccess.getSingletonRule()); 
            pushFollow(FOLLOW_ruleSingleton_in_entryRuleSingleton3596);
            iv_ruleSingleton=ruleSingleton();

            state._fsp--;

             current =iv_ruleSingleton; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleton3606); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1526:1: ruleSingleton returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' ) ;
    public final EObject ruleSingleton() throws RecognitionException {
        EObject current = null;

        Token lv_singleton_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1529:28: ( ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1530:1: ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1530:1: ( ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1530:2: ( (lv_singleton_0_0= 'singleton' ) ) otherlv_1= ';'
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1530:2: ( (lv_singleton_0_0= 'singleton' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1531:1: (lv_singleton_0_0= 'singleton' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1531:1: (lv_singleton_0_0= 'singleton' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1532:3: lv_singleton_0_0= 'singleton'
            {
            lv_singleton_0_0=(Token)match(input,39,FOLLOW_39_in_ruleSingleton3649); 

                    newLeafNode(lv_singleton_0_0, grammarAccess.getSingletonAccess().getSingletonSingletonKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSingletonRule());
            	        }
                   		setWithLastConsumed(current, "singleton", true, "singleton");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSingleton3674); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1557:1: entryRuleKeyDefinition returns [EObject current=null] : iv_ruleKeyDefinition= ruleKeyDefinition EOF ;
    public final EObject entryRuleKeyDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1558:2: (iv_ruleKeyDefinition= ruleKeyDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1559:2: iv_ruleKeyDefinition= ruleKeyDefinition EOF
            {
             newCompositeNode(grammarAccess.getKeyDefinitionRule()); 
            pushFollow(FOLLOW_ruleKeyDefinition_in_entryRuleKeyDefinition3710);
            iv_ruleKeyDefinition=ruleKeyDefinition();

            state._fsp--;

             current =iv_ruleKeyDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyDefinition3720); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1566:1: ruleKeyDefinition returns [EObject current=null] : (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1569:28: ( (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1570:1: (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1570:1: (otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1570:3: otherlv_0= 'key' () otherlv_2= '{' ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleKeyDefinition3757); 

                	newLeafNode(otherlv_0, grammarAccess.getKeyDefinitionAccess().getKeyKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1574:1: ()
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1575:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getKeyDefinitionAccess().getKeyAction_1(),
                        current);
                

            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleKeyDefinition3778); 

                	newLeafNode(otherlv_2, grammarAccess.getKeyDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1584:1: ( ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1584:2: ( (lv_keys_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1584:2: ( (lv_keys_3_0= RULE_ID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1585:1: (lv_keys_3_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1585:1: (lv_keys_3_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1586:3: lv_keys_3_0= RULE_ID
                    {
                    lv_keys_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyDefinition3796); 

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

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1602:2: (otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==38) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1602:4: otherlv_4= ',' ( (lv_keys_5_0= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleKeyDefinition3814); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getKeyDefinitionAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1606:1: ( (lv_keys_5_0= RULE_ID ) )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1607:1: (lv_keys_5_0= RULE_ID )
                    	    {
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1607:1: (lv_keys_5_0= RULE_ID )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1608:3: lv_keys_5_0= RULE_ID
                    	    {
                    	    lv_keys_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyDefinition3831); 

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

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleKeyDefinition3852); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1636:1: entryRuleCodeInjection returns [EObject current=null] : iv_ruleCodeInjection= ruleCodeInjection EOF ;
    public final EObject entryRuleCodeInjection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeInjection = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1637:2: (iv_ruleCodeInjection= ruleCodeInjection EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1638:2: iv_ruleCodeInjection= ruleCodeInjection EOF
            {
             newCompositeNode(grammarAccess.getCodeInjectionRule()); 
            pushFollow(FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection3888);
            iv_ruleCodeInjection=ruleCodeInjection();

            state._fsp--;

             current =iv_ruleCodeInjection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodeInjection3898); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1645:1: ruleCodeInjection returns [EObject current=null] : ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1648:28: ( ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1649:1: ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1649:1: ( (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) ) | (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==41) ) {
                alt24=1;
            }
            else if ( (LA24_0==42) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1649:2: (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1649:2: (otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1649:4: otherlv_0= 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleCodeInjection3936); 

                        	newLeafNode(otherlv_0, grammarAccess.getCodeInjectionAccess().getBeforeKeyword_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1653:1: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1654:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1654:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1655:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection3957);
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

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1671:2: ( (lv_code_2_0= RULE_STRING ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1672:1: (lv_code_2_0= RULE_STRING )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1672:1: (lv_code_2_0= RULE_STRING )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1673:3: lv_code_2_0= RULE_STRING
                    {
                    lv_code_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodeInjection3974); 

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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1690:6: (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1690:6: (otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1690:8: otherlv_3= 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleCodeInjection3999); 

                        	newLeafNode(otherlv_3, grammarAccess.getCodeInjectionAccess().getAfterKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1694:1: ( (lv_name_4_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1695:1: (lv_name_4_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1695:1: (lv_name_4_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1696:3: lv_name_4_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection4020);
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

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1712:2: ( (lv_code_5_0= RULE_STRING ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1713:1: (lv_code_5_0= RULE_STRING )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1713:1: (lv_code_5_0= RULE_STRING )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1714:3: lv_code_5_0= RULE_STRING
                    {
                    lv_code_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodeInjection4037); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1738:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1739:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1740:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute4079);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute4089); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1747:1: ruleAttribute returns [EObject current=null] : ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1750:28: ( ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1751:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1751:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_ID||LA31_0==44||(LA31_0>=49 && LA31_0<=59)||(LA31_0>=101 && LA31_0<=105)) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1751:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1751:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1751:3: ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) otherlv_2= ';'
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1751:3: ( (lv_autounique_0_0= 'autounique' ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1752:1: (lv_autounique_0_0= 'autounique' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1752:1: (lv_autounique_0_0= 'autounique' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1753:3: lv_autounique_0_0= 'autounique'
                    {
                    lv_autounique_0_0=(Token)match(input,43,FOLLOW_43_in_ruleAttribute4133); 

                            newLeafNode(lv_autounique_0_0, grammarAccess.getAttributeAccess().getAutouniqueAutouniqueKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "autounique", true, "autounique");
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1766:2: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1767:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1767:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1768:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getNameExtendedIDParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleAttribute4167);
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

                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleAttribute4179); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getSemicolonKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1789:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1789:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1789:7: ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? otherlv_12= ';'
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1789:7: ( (lv_unique_3_0= 'unique' ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==44) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1790:1: (lv_unique_3_0= 'unique' )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1790:1: (lv_unique_3_0= 'unique' )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1791:3: lv_unique_3_0= 'unique'
                            {
                            lv_unique_3_0=(Token)match(input,44,FOLLOW_44_in_ruleAttribute4205); 

                                    newLeafNode(lv_unique_3_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAttributeRule());
                            	        }
                                   		setWithLastConsumed(current, "unique", true, "unique");
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1804:3: ( (lv_modifier_4_0= ruleModifier ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=101 && LA26_0<=105)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1805:1: (lv_modifier_4_0= ruleModifier )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1805:1: (lv_modifier_4_0= ruleModifier )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1806:3: lv_modifier_4_0= ruleModifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getModifierModifierEnumRuleCall_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleModifier_in_ruleAttribute4240);
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

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1822:3: ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )?
                    int alt29=3;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=49 && LA29_0<=59)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_ID) ) {
                        int LA29_2 = input.LA(2);

                        if ( (LA29_2==RULE_ID||LA29_2==45) ) {
                            alt29=2;
                        }
                    }
                    switch (alt29) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1822:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1822:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1822:5: ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )?
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1822:5: ( (lv_type_5_0= ruleUmpleAttributeType ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1823:1: (lv_type_5_0= ruleUmpleAttributeType )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1823:1: (lv_type_5_0= ruleUmpleAttributeType )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1824:3: lv_type_5_0= ruleUmpleAttributeType
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getTypeUmpleAttributeTypeParserRuleCall_1_2_0_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUmpleAttributeType_in_ruleAttribute4264);
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

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1840:2: ( (lv_list_6_0= '[]' ) )?
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0==45) ) {
                                alt27=1;
                            }
                            switch (alt27) {
                                case 1 :
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1841:1: (lv_list_6_0= '[]' )
                                    {
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1841:1: (lv_list_6_0= '[]' )
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1842:3: lv_list_6_0= '[]'
                                    {
                                    lv_list_6_0=(Token)match(input,45,FOLLOW_45_in_ruleAttribute4282); 

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
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1856:6: ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1856:6: ( ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1856:7: ( (otherlv_7= RULE_ID ) ) ( (lv_list_8_0= '[]' ) )?
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1856:7: ( (otherlv_7= RULE_ID ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1857:1: (otherlv_7= RULE_ID )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1857:1: (otherlv_7= RULE_ID )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1858:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getAttributeRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute4324); 

                            		newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getObjectClassDefinitionCrossReference_1_2_1_0_0()); 
                            	

                            }


                            }

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1869:2: ( (lv_list_8_0= '[]' ) )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==45) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1870:1: (lv_list_8_0= '[]' )
                                    {
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1870:1: (lv_list_8_0= '[]' )
                                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1871:3: lv_list_8_0= '[]'
                                    {
                                    lv_list_8_0=(Token)match(input,45,FOLLOW_45_in_ruleAttribute4342); 

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

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1884:6: ( (lv_name_9_0= ruleextendedID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1885:1: (lv_name_9_0= ruleextendedID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1885:1: (lv_name_9_0= ruleextendedID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1886:3: lv_name_9_0= ruleextendedID
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getNameExtendedIDParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleAttribute4380);
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

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1902:2: (otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==46) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1902:4: otherlv_10= '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            {
                            otherlv_10=(Token)match(input,46,FOLLOW_46_in_ruleAttribute4393); 

                                	newLeafNode(otherlv_10, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1_4_0());
                                
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1906:1: ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1907:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1907:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1908:3: lv_value_11_0= ruleUmplePrimitiveType
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getValueUmplePrimitiveTypeParserRuleCall_1_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_ruleAttribute4414);
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

                    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleAttribute4428); 

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


    // $ANTLR start "entryRulePosition"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1936:1: entryRulePosition returns [EObject current=null] : iv_rulePosition= rulePosition EOF ;
    public final EObject entryRulePosition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePosition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1937:2: (iv_rulePosition= rulePosition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1938:2: iv_rulePosition= rulePosition EOF
            {
             newCompositeNode(grammarAccess.getPositionRule()); 
            pushFollow(FOLLOW_rulePosition_in_entryRulePosition4465);
            iv_rulePosition=rulePosition();

            state._fsp--;

             current =iv_rulePosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePosition4475); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1945:1: rulePosition returns [EObject current=null] : (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition ) ;
    public final EObject rulePosition() throws RecognitionException {
        EObject current = null;

        EObject this_AssociationPosition_0 = null;

        EObject this_ElementPosition_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1948:28: ( (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1949:1: (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1949:1: (this_AssociationPosition_0= ruleAssociationPosition | this_ElementPosition_1= ruleElementPosition )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==48) ) {
                alt32=1;
            }
            else if ( (LA32_0==47) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1950:5: this_AssociationPosition_0= ruleAssociationPosition
                    {
                     
                            newCompositeNode(grammarAccess.getPositionAccess().getAssociationPositionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAssociationPosition_in_rulePosition4522);
                    this_AssociationPosition_0=ruleAssociationPosition();

                    state._fsp--;

                     
                            current = this_AssociationPosition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1960:5: this_ElementPosition_1= ruleElementPosition
                    {
                     
                            newCompositeNode(grammarAccess.getPositionAccess().getElementPositionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleElementPosition_in_rulePosition4549);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1976:1: entryRuleElementPosition returns [EObject current=null] : iv_ruleElementPosition= ruleElementPosition EOF ;
    public final EObject entryRuleElementPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementPosition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1977:2: (iv_ruleElementPosition= ruleElementPosition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1978:2: iv_ruleElementPosition= ruleElementPosition EOF
            {
             newCompositeNode(grammarAccess.getElementPositionRule()); 
            pushFollow(FOLLOW_ruleElementPosition_in_entryRuleElementPosition4584);
            iv_ruleElementPosition=ruleElementPosition();

            state._fsp--;

             current =iv_ruleElementPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementPosition4594); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1985:1: ruleElementPosition returns [EObject current=null] : (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1988:28: ( (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1989:1: (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1989:1: (otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1989:3: otherlv_0= 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleElementPosition4631); 

                	newLeafNode(otherlv_0, grammarAccess.getElementPositionAccess().getPositionKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1993:1: ( (lv_x_1_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1994:1: (lv_x_1_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1994:1: (lv_x_1_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1995:3: lv_x_1_0= RULE_INT
            {
            lv_x_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition4648); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2011:2: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2012:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2012:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2013:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition4670); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2029:2: ( (lv_width_3_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2030:1: (lv_width_3_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2030:1: (lv_width_3_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2031:3: lv_width_3_0= RULE_INT
            {
            lv_width_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition4692); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2047:2: ( (lv_height_4_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2048:1: (lv_height_4_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2048:1: (lv_height_4_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2049:3: lv_height_4_0= RULE_INT
            {
            lv_height_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleElementPosition4714); 

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

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleElementPosition4731); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2077:1: entryRuleAssociationPosition returns [EObject current=null] : iv_ruleAssociationPosition= ruleAssociationPosition EOF ;
    public final EObject entryRuleAssociationPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationPosition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2078:2: (iv_ruleAssociationPosition= ruleAssociationPosition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2079:2: iv_ruleAssociationPosition= ruleAssociationPosition EOF
            {
             newCompositeNode(grammarAccess.getAssociationPositionRule()); 
            pushFollow(FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition4767);
            iv_ruleAssociationPosition=ruleAssociationPosition();

            state._fsp--;

             current =iv_ruleAssociationPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationPosition4777); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2086:1: ruleAssociationPosition returns [EObject current=null] : (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' ) ;
    public final EObject ruleAssociationPosition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        EObject lv_c1_2_0 = null;

        EObject lv_c2_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2089:28: ( (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2090:1: (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2090:1: (otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2090:3: otherlv_0= 'position.association' ( (lv_name_1_0= RULE_ID ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleAssociationPosition4814); 

                	newLeafNode(otherlv_0, grammarAccess.getAssociationPositionAccess().getPositionAssociationKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2094:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2095:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2095:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2096:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociationPosition4831); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2112:2: ( (lv_c1_2_0= ruleCoordinate ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2113:1: (lv_c1_2_0= ruleCoordinate )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2113:1: (lv_c1_2_0= ruleCoordinate )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2114:3: lv_c1_2_0= ruleCoordinate
            {
             
            	        newCompositeNode(grammarAccess.getAssociationPositionAccess().getC1CoordinateParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition4857);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2130:2: ( (lv_c2_3_0= ruleCoordinate ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2131:1: (lv_c2_3_0= ruleCoordinate )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2131:1: (lv_c2_3_0= ruleCoordinate )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2132:3: lv_c2_3_0= ruleCoordinate
            {
             
            	        newCompositeNode(grammarAccess.getAssociationPositionAccess().getC2CoordinateParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition4878);
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

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleAssociationPosition4890); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2160:1: entryRuleCoordinate returns [EObject current=null] : iv_ruleCoordinate= ruleCoordinate EOF ;
    public final EObject entryRuleCoordinate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinate = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2161:2: (iv_ruleCoordinate= ruleCoordinate EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2162:2: iv_ruleCoordinate= ruleCoordinate EOF
            {
             newCompositeNode(grammarAccess.getCoordinateRule()); 
            pushFollow(FOLLOW_ruleCoordinate_in_entryRuleCoordinate4926);
            iv_ruleCoordinate=ruleCoordinate();

            state._fsp--;

             current =iv_ruleCoordinate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinate4936); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2169:1: ruleCoordinate returns [EObject current=null] : ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) ) ;
    public final EObject ruleCoordinate() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token otherlv_1=null;
        Token lv_y_2_0=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2172:28: ( ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2173:1: ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2173:1: ( ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2173:2: ( (lv_x_0_0= RULE_INT ) ) otherlv_1= ',' ( (lv_y_2_0= RULE_INT ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2173:2: ( (lv_x_0_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2174:1: (lv_x_0_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2174:1: (lv_x_0_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2175:3: lv_x_0_0= RULE_INT
            {
            lv_x_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate4978); 

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

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleCoordinate4995); 

                	newLeafNode(otherlv_1, grammarAccess.getCoordinateAccess().getCommaKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2195:1: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2196:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2196:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2197:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate5012); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2221:1: entryRuleUmpleAttributeType returns [String current=null] : iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF ;
    public final String entryRuleUmpleAttributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmpleAttributeType = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2222:2: (iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2223:2: iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getUmpleAttributeTypeRule()); 
            pushFollow(FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType5054);
            iv_ruleUmpleAttributeType=ruleUmpleAttributeType();

            state._fsp--;

             current =iv_ruleUmpleAttributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAttributeType5065); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2230:1: ruleUmpleAttributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleUmpleAttributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2233:28: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2234:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2234:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt33=11;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt33=1;
                }
                break;
            case 50:
                {
                alt33=2;
                }
                break;
            case 51:
                {
                alt33=3;
                }
                break;
            case 52:
                {
                alt33=4;
                }
                break;
            case 53:
                {
                alt33=5;
                }
                break;
            case 54:
                {
                alt33=6;
                }
                break;
            case 55:
                {
                alt33=7;
                }
                break;
            case 56:
                {
                alt33=8;
                }
                break;
            case 57:
                {
                alt33=9;
                }
                break;
            case 58:
                {
                alt33=10;
                }
                break;
            case 59:
                {
                alt33=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2235:2: kw= 'Date'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleUmpleAttributeType5103); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getDateKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2242:2: kw= 'Time'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleUmpleAttributeType5122); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getTimeKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2249:2: kw= 'Double'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleUmpleAttributeType5141); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2256:2: kw= 'double'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleUmpleAttributeType5160); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2263:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleUmpleAttributeType5179); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2270:2: kw= 'integer'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleUmpleAttributeType5198); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2277:2: kw= 'int'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleUmpleAttributeType5217); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getIntKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2284:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleUmpleAttributeType5236); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2291:2: kw= 'boolean'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleUmpleAttributeType5255); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2298:2: kw= 'String'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleUmpleAttributeType5274); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUmpleAttributeTypeAccess().getStringKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2305:2: kw= 'string'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleUmpleAttributeType5293); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2318:1: entryRuleUmplePrimitiveType returns [String current=null] : iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF ;
    public final String entryRuleUmplePrimitiveType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmplePrimitiveType = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2319:2: (iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2320:2: iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getUmplePrimitiveTypeRule()); 
            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType5334);
            iv_ruleUmplePrimitiveType=ruleUmplePrimitiveType();

            state._fsp--;

             current =iv_ruleUmplePrimitiveType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmplePrimitiveType5345); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2327:1: ruleUmplePrimitiveType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleUmplePrimitiveType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_STRING_1=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2330:28: ( (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2331:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2331:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INT) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_STRING) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2331:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUmplePrimitiveType5385); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getUmplePrimitiveTypeAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2339:10: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType5411); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2354:1: entryRulemultiplicity returns [String current=null] : iv_rulemultiplicity= rulemultiplicity EOF ;
    public final String entryRulemultiplicity() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulemultiplicity = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2355:2: (iv_rulemultiplicity= rulemultiplicity EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2356:2: iv_rulemultiplicity= rulemultiplicity EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRule()); 
            pushFollow(FOLLOW_rulemultiplicity_in_entryRulemultiplicity5457);
            iv_rulemultiplicity=rulemultiplicity();

            state._fsp--;

             current =iv_rulemultiplicity.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicity5468); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2363:1: rulemultiplicity returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) ;
    public final AntlrDatatypeRuleToken rulemultiplicity() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_bound_0 = null;

        AntlrDatatypeRuleToken this_bound_1 = null;

        AntlrDatatypeRuleToken this_bound_3 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2366:28: ( (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2367:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2367:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==EOF||LA35_1==RULE_ID||(LA35_1>=31 && LA35_1<=35)) ) {
                    alt35=1;
                }
                else if ( (LA35_1==60) ) {
                    alt35=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA35_0==61) ) {
                int LA35_2 = input.LA(2);

                if ( (LA35_2==60) ) {
                    alt35=2;
                }
                else if ( (LA35_2==EOF||LA35_2==RULE_ID||(LA35_2>=31 && LA35_2<=35)) ) {
                    alt35=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2368:5: this_bound_0= rulebound
                    {
                     
                            newCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity5515);
                    this_bound_0=rulebound();

                    state._fsp--;


                    		current.merge(this_bound_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2379:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2379:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2380:5: this_bound_1= rulebound kw= '..' this_bound_3= rulebound
                    {
                     
                            newCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity5549);
                    this_bound_1=rulebound();

                    state._fsp--;


                    		current.merge(this_bound_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    kw=(Token)match(input,60,FOLLOW_60_in_rulemultiplicity5567); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMultiplicityAccess().getFullStopFullStopKeyword_1_1()); 
                        
                     
                            newCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_2()); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity5589);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2415:1: entryRulebound returns [String current=null] : iv_rulebound= rulebound EOF ;
    public final String entryRulebound() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulebound = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2416:2: (iv_rulebound= rulebound EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2417:2: iv_rulebound= rulebound EOF
            {
             newCompositeNode(grammarAccess.getBoundRule()); 
            pushFollow(FOLLOW_rulebound_in_entryRulebound5636);
            iv_rulebound=rulebound();

            state._fsp--;

             current =iv_rulebound.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulebound5647); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2424:1: rulebound returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken rulebound() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2427:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2428:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2428:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_INT) ) {
                alt36=1;
            }
            else if ( (LA36_0==61) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2428:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulebound5687); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getBoundAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2437:2: kw= '*'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_rulebound5711); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2452:1: entryRuleblock returns [EObject current=null] : iv_ruleblock= ruleblock EOF ;
    public final EObject entryRuleblock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblock = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2453:2: (iv_ruleblock= ruleblock EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2454:2: iv_ruleblock= ruleblock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleblock_in_entryRuleblock5753);
            iv_ruleblock=ruleblock();

            state._fsp--;

             current =iv_ruleblock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblock5763); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2461:1: ruleblock returns [EObject current=null] : (otherlv_0= '{' ( (lv_blocks_1_0= ruleblockStatement ) )* otherlv_2= '}' ) ;
    public final EObject ruleblock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_blocks_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2464:28: ( (otherlv_0= '{' ( (lv_blocks_1_0= ruleblockStatement ) )* otherlv_2= '}' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2465:1: (otherlv_0= '{' ( (lv_blocks_1_0= ruleblockStatement ) )* otherlv_2= '}' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2465:1: (otherlv_0= '{' ( (lv_blocks_1_0= ruleblockStatement ) )* otherlv_2= '}' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2465:3: otherlv_0= '{' ( (lv_blocks_1_0= ruleblockStatement ) )* otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleblock5800); 

                	newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2469:1: ( (lv_blocks_1_0= ruleblockStatement ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_INT)||LA37_0==15||LA37_0==18||LA37_0==32||(LA37_0>=49 && LA37_0<=59)||LA37_0==62||(LA37_0>=75 && LA37_0<=76)||(LA37_0>=79 && LA37_0<=85)||LA37_0==92||(LA37_0>=94 && LA37_0<=98)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2470:1: (lv_blocks_1_0= ruleblockStatement )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2470:1: (lv_blocks_1_0= ruleblockStatement )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2471:3: lv_blocks_1_0= ruleblockStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getBlocksBlockStatementParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleblockStatement_in_ruleblock5821);
            	    lv_blocks_1_0=ruleblockStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"blocks",
            	            		lv_blocks_1_0, 
            	            		"blockStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleblock5834); 

                	newLeafNode(otherlv_2, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2());
                

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2499:1: entryRuleparExpression returns [EObject current=null] : iv_ruleparExpression= ruleparExpression EOF ;
    public final EObject entryRuleparExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleparExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2500:2: (iv_ruleparExpression= ruleparExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2501:2: iv_ruleparExpression= ruleparExpression EOF
            {
             newCompositeNode(grammarAccess.getParExpressionRule()); 
            pushFollow(FOLLOW_ruleparExpression_in_entryRuleparExpression5870);
            iv_ruleparExpression=ruleparExpression();

            state._fsp--;

             current =iv_ruleparExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleparExpression5880); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2508:1: ruleparExpression returns [EObject current=null] : (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' ) ;
    public final EObject ruleparExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_expression_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2511:28: ( (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2512:1: (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2512:1: (otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2512:3: otherlv_0= '(' this_expression_1= ruleexpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleparExpression5917); 

                	newLeafNode(otherlv_0, grammarAccess.getParExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParExpressionAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleexpression_in_ruleparExpression5939);
            this_expression_1=ruleexpression();

            state._fsp--;

             
                    current = this_expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleparExpression5950); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2537:1: entryRuleassignmentOperator returns [String current=null] : iv_ruleassignmentOperator= ruleassignmentOperator EOF ;
    public final String entryRuleassignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleassignmentOperator = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2538:2: (iv_ruleassignmentOperator= ruleassignmentOperator EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2539:2: iv_ruleassignmentOperator= ruleassignmentOperator EOF
            {
             newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            pushFollow(FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator5987);
            iv_ruleassignmentOperator=ruleassignmentOperator();

            state._fsp--;

             current =iv_ruleassignmentOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleassignmentOperator5998); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2546:1: ruleassignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' | kw= '-=' ) ;
    public final AntlrDatatypeRuleToken ruleassignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2549:28: ( (kw= '=' | kw= '+=' | kw= '-=' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2550:1: (kw= '=' | kw= '+=' | kw= '-=' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2550:1: (kw= '=' | kw= '+=' | kw= '-=' )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt38=1;
                }
                break;
            case 64:
                {
                alt38=2;
                }
                break;
            case 65:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2551:2: kw= '='
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleassignmentOperator6036); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2558:2: kw= '+='
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleassignmentOperator6055); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2565:2: kw= '-='
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleassignmentOperator6074); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2578:1: entryRuleexpressionList returns [EObject current=null] : iv_ruleexpressionList= ruleexpressionList EOF ;
    public final EObject entryRuleexpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpressionList = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2579:2: (iv_ruleexpressionList= ruleexpressionList EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2580:2: iv_ruleexpressionList= ruleexpressionList EOF
            {
             newCompositeNode(grammarAccess.getExpressionListRule()); 
            pushFollow(FOLLOW_ruleexpressionList_in_entryRuleexpressionList6114);
            iv_ruleexpressionList=ruleexpressionList();

            state._fsp--;

             current =iv_ruleexpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpressionList6124); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2587:1: ruleexpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) ;
    public final EObject ruleexpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2590:28: ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2591:1: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2591:1: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2591:2: ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2591:2: ( (lv_expressions_0_0= ruleexpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2592:1: (lv_expressions_0_0= ruleexpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2592:1: (lv_expressions_0_0= ruleexpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2593:3: lv_expressions_0_0= ruleexpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList6170);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2609:2: (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==38) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2609:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleexpressionList6183); 

            	        	newLeafNode(otherlv_1, grammarAccess.getExpressionListAccess().getCommaKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2613:1: ( (lv_expressions_2_0= ruleexpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2614:1: (lv_expressions_2_0= ruleexpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2614:1: (lv_expressions_2_0= ruleexpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2615:3: lv_expressions_2_0= ruleexpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList6204);
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
            	    break loop39;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2639:1: entryRuleexpression returns [EObject current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final EObject entryRuleexpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2640:2: (iv_ruleexpression= ruleexpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2641:2: iv_ruleexpression= ruleexpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleexpression_in_entryRuleexpression6242);
            iv_ruleexpression=ruleexpression();

            state._fsp--;

             current =iv_ruleexpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpression6252); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2648:1: ruleexpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) ;
    public final EObject ruleexpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2651:28: ( ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2652:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2652:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2652:2: ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2652:2: ( (lv_expression1_0_0= ruleconditionalExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2653:1: (lv_expression1_0_0= ruleconditionalExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2653:1: (lv_expression1_0_0= ruleconditionalExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2654:3: lv_expression1_0_0= ruleconditionalExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getExpression1ConditionalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleconditionalExpression_in_ruleexpression6298);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2670:2: ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            int alt40=2;
            switch ( input.LA(1) ) {
                case 46:
                    {
                    alt40=1;
                    }
                    break;
                case 64:
                    {
                    alt40=1;
                    }
                    break;
                case 65:
                    {
                    alt40=1;
                    }
                    break;
            }

            switch (alt40) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2671:5: ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) )
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentOperatorParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleassignmentOperator_in_ruleexpression6315);
                    ruleassignmentOperator();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2678:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2679:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2679:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2680:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleexpression6335);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2704:1: entryRuleconditionalExpression returns [EObject current=null] : iv_ruleconditionalExpression= ruleconditionalExpression EOF ;
    public final EObject entryRuleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2705:2: (iv_ruleconditionalExpression= ruleconditionalExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2706:2: iv_ruleconditionalExpression= ruleconditionalExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression6373);
            iv_ruleconditionalExpression=ruleconditionalExpression();

            state._fsp--;

             current =iv_ruleconditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalExpression6383); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2713:1: ruleconditionalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) ;
    public final EObject ruleconditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;

        EObject lv_expression3_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2716:28: ( ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2718:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2718:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2719:3: lv_expression1_0_0= ruleconditionalOrExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression1ConditionalOrExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression6429);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2735:2: (otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==66) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2735:4: otherlv_1= '?' ( (lv_expression2_2_0= ruleexpression ) ) otherlv_3= ':' ( (lv_expression3_4_0= ruleexpression ) )
                    {
                    otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleconditionalExpression6442); 

                        	newLeafNode(otherlv_1, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2739:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2740:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2740:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2741:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression6463);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleconditionalExpression6475); 

                        	newLeafNode(otherlv_3, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2761:1: ( (lv_expression3_4_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2762:1: (lv_expression3_4_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2762:1: (lv_expression3_4_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2763:3: lv_expression3_4_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression3ExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression6496);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2787:1: entryRuleconditionalOrExpression returns [EObject current=null] : iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF ;
    public final EObject entryRuleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalOrExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2788:2: (iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2789:2: iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalOrExpressionRule()); 
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression6534);
            iv_ruleconditionalOrExpression=ruleconditionalOrExpression();

            state._fsp--;

             current =iv_ruleconditionalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalOrExpression6544); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2796:1: ruleconditionalOrExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) ;
    public final EObject ruleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2799:28: ( ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2800:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2800:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2800:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2800:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2801:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2801:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2802:3: lv_expression1_0_0= ruleconditionalAndExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpression1ConditionalAndExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression6590);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2818:2: (otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==67) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2818:4: otherlv_1= '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,67,FOLLOW_67_in_ruleconditionalOrExpression6603); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2822:1: ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2823:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2823:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2824:3: lv_expressionRest_2_0= ruleconditionalAndExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpressionRestConditionalAndExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression6624);
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
            	    break loop42;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2848:1: entryRuleconditionalAndExpression returns [EObject current=null] : iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF ;
    public final EObject entryRuleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalAndExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2849:2: (iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2850:2: iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalAndExpressionRule()); 
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression6662);
            iv_ruleconditionalAndExpression=ruleconditionalAndExpression();

            state._fsp--;

             current =iv_ruleconditionalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalAndExpression6672); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2857:1: ruleconditionalAndExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) ;
    public final EObject ruleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2860:28: ( ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2861:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2861:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2861:2: ( (lv_expression1_0_0= ruleequalityExpression ) ) (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2861:2: ( (lv_expression1_0_0= ruleequalityExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2862:1: (lv_expression1_0_0= ruleequalityExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2862:1: (lv_expression1_0_0= ruleequalityExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:3: lv_expression1_0_0= ruleequalityExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpression1EqualityExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression6718);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2879:2: (otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==68) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2879:4: otherlv_1= '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleconditionalAndExpression6731); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2883:1: ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2884:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2884:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2885:3: lv_expressionRest_2_0= ruleequalityExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpressionRestEqualityExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression6752);
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
            	    break loop43;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2909:1: entryRuleequalityExpression returns [EObject current=null] : iv_ruleequalityExpression= ruleequalityExpression EOF ;
    public final EObject entryRuleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2910:2: (iv_ruleequalityExpression= ruleequalityExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2911:2: iv_ruleequalityExpression= ruleequalityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression6790);
            iv_ruleequalityExpression=ruleequalityExpression();

            state._fsp--;

             current =iv_ruleequalityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleequalityExpression6800); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2918:1: ruleequalityExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) ;
    public final EObject ruleequalityExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2921:28: ( ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2922:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2922:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2922:2: ( (lv_expression1_0_0= rulerelationalExpression ) ) ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2922:2: ( (lv_expression1_0_0= rulerelationalExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2923:1: (lv_expression1_0_0= rulerelationalExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2923:1: (lv_expression1_0_0= rulerelationalExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2924:3: lv_expression1_0_0= rulerelationalExpression
            {
             
            	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpression1RelationalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression6846);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2940:2: ( (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=69 && LA45_0<=70)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2940:3: (otherlv_1= '==' | otherlv_2= '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2940:3: (otherlv_1= '==' | otherlv_2= '!=' )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==69) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==70) ) {
            	        alt44=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2940:5: otherlv_1= '=='
            	            {
            	            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleequalityExpression6860); 

            	                	newLeafNode(otherlv_1, grammarAccess.getEqualityExpressionAccess().getEqualsSignEqualsSignKeyword_1_0_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2945:7: otherlv_2= '!='
            	            {
            	            otherlv_2=(Token)match(input,70,FOLLOW_70_in_ruleequalityExpression6878); 

            	                	newLeafNode(otherlv_2, grammarAccess.getEqualityExpressionAccess().getExclamationMarkEqualsSignKeyword_1_0_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2949:2: ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2950:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2950:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2951:3: lv_expressionRest_3_0= rulerelationalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpressionRestRelationalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression6900);
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
            	    break loop45;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2975:1: entryRulerelationalExpression returns [EObject current=null] : iv_rulerelationalExpression= rulerelationalExpression EOF ;
    public final EObject entryRulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2976:2: (iv_rulerelationalExpression= rulerelationalExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2977:2: iv_rulerelationalExpression= rulerelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression6938);
            iv_rulerelationalExpression=rulerelationalExpression();

            state._fsp--;

             current =iv_rulerelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalExpression6948); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2984:1: rulerelationalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) ;
    public final EObject rulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2987:28: ( ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2988:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2988:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2988:2: ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2988:2: ( (lv_expression1_0_0= ruleadditiveExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2989:1: (lv_expression1_0_0= ruleadditiveExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2989:1: (lv_expression1_0_0= ruleadditiveExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2990:3: lv_expression1_0_0= ruleadditiveExpression
            {
             
            	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpression1AdditiveExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression6994);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3006:2: ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=71 && LA46_0<=74)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3007:5: rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRelationalOpParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_rulerelationalOp_in_rulerelationalExpression7011);
            	    rulerelationalOp();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3014:1: ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3015:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3015:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3016:3: lv_expressionRest_2_0= ruleadditiveExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpressionRestAdditiveExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression7031);
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
            	    break loop46;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3040:1: entryRulerelationalOp returns [String current=null] : iv_rulerelationalOp= rulerelationalOp EOF ;
    public final String entryRulerelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerelationalOp = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3041:2: (iv_rulerelationalOp= rulerelationalOp EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3042:2: iv_rulerelationalOp= rulerelationalOp EOF
            {
             newCompositeNode(grammarAccess.getRelationalOpRule()); 
            pushFollow(FOLLOW_rulerelationalOp_in_entryRulerelationalOp7070);
            iv_rulerelationalOp=rulerelationalOp();

            state._fsp--;

             current =iv_rulerelationalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalOp7081); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3049:1: rulerelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken rulerelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3052:28: ( (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3053:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3053:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt47=1;
                }
                break;
            case 72:
                {
                alt47=2;
                }
                break;
            case 73:
                {
                alt47=3;
                }
                break;
            case 74:
                {
                alt47=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3054:2: kw= '<='
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_rulerelationalOp7119); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3061:2: kw= '<'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_rulerelationalOp7138); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3068:2: kw= '>='
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_rulerelationalOp7157); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3075:2: kw= '>'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_rulerelationalOp7176); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3088:1: entryRuleadditiveExpression returns [EObject current=null] : iv_ruleadditiveExpression= ruleadditiveExpression EOF ;
    public final EObject entryRuleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3089:2: (iv_ruleadditiveExpression= ruleadditiveExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3090:2: iv_ruleadditiveExpression= ruleadditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression7216);
            iv_ruleadditiveExpression=ruleadditiveExpression();

            state._fsp--;

             current =iv_ruleadditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleadditiveExpression7226); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3097:1: ruleadditiveExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) ;
    public final EObject ruleadditiveExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3100:28: ( ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3101:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3101:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3101:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3101:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3102:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3102:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3103:3: lv_expression1_0_0= rulemultiplicativeExpression
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpression1MultiplicativeExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression7272);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3119:2: ( (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=75 && LA49_0<=76)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3119:3: (otherlv_1= '+' | otherlv_2= '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3119:3: (otherlv_1= '+' | otherlv_2= '-' )
            	    int alt48=2;
            	    int LA48_0 = input.LA(1);

            	    if ( (LA48_0==75) ) {
            	        alt48=1;
            	    }
            	    else if ( (LA48_0==76) ) {
            	        alt48=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 48, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt48) {
            	        case 1 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3119:5: otherlv_1= '+'
            	            {
            	            otherlv_1=(Token)match(input,75,FOLLOW_75_in_ruleadditiveExpression7286); 

            	                	newLeafNode(otherlv_1, grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_0_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3124:7: otherlv_2= '-'
            	            {
            	            otherlv_2=(Token)match(input,76,FOLLOW_76_in_ruleadditiveExpression7304); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditiveExpressionAccess().getHyphenMinusKeyword_1_0_1());
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3128:2: ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3129:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3129:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3130:3: lv_expressionRest_3_0= rulemultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpressionRestMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression7326);
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
            	    break loop49;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3154:1: entryRulemultiplicativeExpression returns [EObject current=null] : iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF ;
    public final EObject entryRulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3155:2: (iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3156:2: iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression7364);
            iv_rulemultiplicativeExpression=rulemultiplicativeExpression();

            state._fsp--;

             current =iv_rulemultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicativeExpression7374); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3163:1: rulemultiplicativeExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) ;
    public final EObject rulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3166:28: ( ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3167:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3167:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3167:2: ( (lv_expression1_0_0= ruleunaryExpression ) ) ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3167:2: ( (lv_expression1_0_0= ruleunaryExpression ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3168:1: (lv_expression1_0_0= ruleunaryExpression )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3168:1: (lv_expression1_0_0= ruleunaryExpression )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3169:3: lv_expression1_0_0= ruleunaryExpression
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpression1UnaryExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression7420);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:2: ( (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==61||(LA51_0>=77 && LA51_0<=78)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:3: (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:3: (otherlv_1= '*' | otherlv_2= '/' | otherlv_3= '%' )
            	    int alt50=3;
            	    switch ( input.LA(1) ) {
            	    case 61:
            	        {
            	        alt50=1;
            	        }
            	        break;
            	    case 77:
            	        {
            	        alt50=2;
            	        }
            	        break;
            	    case 78:
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
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:5: otherlv_1= '*'
            	            {
            	            otherlv_1=(Token)match(input,61,FOLLOW_61_in_rulemultiplicativeExpression7434); 

            	                	newLeafNode(otherlv_1, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_0());
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3190:7: otherlv_2= '/'
            	            {
            	            otherlv_2=(Token)match(input,77,FOLLOW_77_in_rulemultiplicativeExpression7452); 

            	                	newLeafNode(otherlv_2, grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_0_1());
            	                

            	            }
            	            break;
            	        case 3 :
            	            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3195:7: otherlv_3= '%'
            	            {
            	            otherlv_3=(Token)match(input,78,FOLLOW_78_in_rulemultiplicativeExpression7470); 

            	                	newLeafNode(otherlv_3, grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_0_2());
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3199:2: ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3200:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3200:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3201:3: lv_expressionRest_4_0= ruleunaryExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpressionRestUnaryExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression7492);
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
    // $ANTLR end "rulemultiplicativeExpression"


    // $ANTLR start "entryRuleunaryExpression"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3225:1: entryRuleunaryExpression returns [EObject current=null] : iv_ruleunaryExpression= ruleunaryExpression EOF ;
    public final EObject entryRuleunaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpression = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3226:2: (iv_ruleunaryExpression= ruleunaryExpression EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3227:2: iv_ruleunaryExpression= ruleunaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression7530);
            iv_ruleunaryExpression=ruleunaryExpression();

            state._fsp--;

             current =iv_ruleunaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpression7540); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3234:1: ruleunaryExpression returns [EObject current=null] : ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3237:28: ( ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3238:1: ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3238:1: ( (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            int alt52=5;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt52=1;
                }
                break;
            case 76:
                {
                alt52=2;
                }
                break;
            case 79:
                {
                alt52=3;
                }
                break;
            case 32:
                {
                alt52=4;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 62:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
                {
                alt52=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3238:2: (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3238:2: (otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3238:4: otherlv_0= '+' ( (lv_exp1_1_0= ruleunaryExpression ) )
                    {
                    otherlv_0=(Token)match(input,75,FOLLOW_75_in_ruleunaryExpression7578); 

                        	newLeafNode(otherlv_0, grammarAccess.getUnaryExpressionAccess().getPlusSignKeyword_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3242:1: ( (lv_exp1_1_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3243:1: (lv_exp1_1_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3243:1: (lv_exp1_1_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3244:3: lv_exp1_1_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression7599);
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3261:6: (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3261:6: (otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3261:8: otherlv_2= '-' ( (lv_exp1_3_0= ruleunaryExpression ) )
                    {
                    otherlv_2=(Token)match(input,76,FOLLOW_76_in_ruleunaryExpression7619); 

                        	newLeafNode(otherlv_2, grammarAccess.getUnaryExpressionAccess().getHyphenMinusKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3265:1: ( (lv_exp1_3_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3266:1: (lv_exp1_3_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3266:1: (lv_exp1_3_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3267:3: lv_exp1_3_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression7640);
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3284:6: (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3284:6: (otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3284:8: otherlv_4= '++' ( (lv_exp1_5_0= ruleunaryExpression ) )
                    {
                    otherlv_4=(Token)match(input,79,FOLLOW_79_in_ruleunaryExpression7660); 

                        	newLeafNode(otherlv_4, grammarAccess.getUnaryExpressionAccess().getPlusSignPlusSignKeyword_2_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3288:1: ( (lv_exp1_5_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3289:1: (lv_exp1_5_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3289:1: (lv_exp1_5_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3290:3: lv_exp1_5_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression7681);
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3307:6: (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3307:6: (otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3307:8: otherlv_6= '--' ( (lv_exp1_7_0= ruleunaryExpression ) )
                    {
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleunaryExpression7701); 

                        	newLeafNode(otherlv_6, grammarAccess.getUnaryExpressionAccess().getHyphenMinusHyphenMinusKeyword_3_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3311:1: ( (lv_exp1_7_0= ruleunaryExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3312:1: (lv_exp1_7_0= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3312:1: (lv_exp1_7_0= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3313:3: lv_exp1_7_0= ruleunaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression7722);
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3330:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3330:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3331:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3331:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3332:3: lv_exp2_8_0= ruleunaryExpressionNotPlusMinus
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp2UnaryExpressionNotPlusMinusParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression7750);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3356:1: entryRuleunaryExpressionNotPlusMinus returns [EObject current=null] : iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF ;
    public final EObject entryRuleunaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpressionNotPlusMinus = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3357:2: (iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3358:2: iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusRule()); 
            pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus7786);
            iv_ruleunaryExpressionNotPlusMinus=ruleunaryExpressionNotPlusMinus();

            state._fsp--;

             current =iv_ruleunaryExpressionNotPlusMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus7796); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3365:1: ruleunaryExpressionNotPlusMinus returns [EObject current=null] : ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3368:28: ( ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3369:1: ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3369:1: ( (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression ) | (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? ) )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt54=1;
                }
                break;
            case 81:
                {
                alt54=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 62:
            case 82:
            case 83:
            case 84:
            case 85:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3369:2: (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3369:2: (otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3369:4: otherlv_0= '~' this_unaryExpression_1= ruleunaryExpression
                    {
                    otherlv_0=(Token)match(input,80,FOLLOW_80_in_ruleunaryExpressionNotPlusMinus7834); 

                        	newLeafNode(otherlv_0, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getTildeKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus7856);
                    this_unaryExpression_1=ruleunaryExpression();

                    state._fsp--;

                     
                            current = this_unaryExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3383:6: (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3383:6: (otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3383:8: otherlv_2= '!' this_unaryExpression_3= ruleunaryExpression
                    {
                    otherlv_2=(Token)match(input,81,FOLLOW_81_in_ruleunaryExpressionNotPlusMinus7875); 

                        	newLeafNode(otherlv_2, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getExclamationMarkKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus7897);
                    this_unaryExpression_3=ruleunaryExpression();

                    state._fsp--;

                     
                            current = this_unaryExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3397:6: (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3397:6: (this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )? )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3398:5: this_primary_4= ruleprimary (otherlv_5= '++' | otherlv_6= '--' )?
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPrimaryParserRuleCall_2_0()); 
                        
                    pushFollow(FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus7926);
                    this_primary_4=ruleprimary();

                    state._fsp--;

                     
                            current = this_primary_4; 
                            afterParserOrEnumRuleCall();
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3406:1: (otherlv_5= '++' | otherlv_6= '--' )?
                    int alt53=3;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==79) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==32) ) {
                        alt53=2;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3406:3: otherlv_5= '++'
                            {
                            otherlv_5=(Token)match(input,79,FOLLOW_79_in_ruleunaryExpressionNotPlusMinus7938); 

                                	newLeafNode(otherlv_5, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPlusSignPlusSignKeyword_2_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3411:7: otherlv_6= '--'
                            {
                            otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleunaryExpressionNotPlusMinus7956); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3423:1: entryRuleprimary returns [EObject current=null] : iv_ruleprimary= ruleprimary EOF ;
    public final EObject entryRuleprimary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimary = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3424:2: (iv_ruleprimary= ruleprimary EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3425:2: iv_ruleprimary= ruleprimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_ruleprimary_in_entryRuleprimary7995);
            iv_ruleprimary=ruleprimary();

            state._fsp--;

             current =iv_ruleprimary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimary8005); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3432:1: ruleprimary returns [EObject current=null] : (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) ;
    public final EObject ruleprimary() throws RecognitionException {
        EObject current = null;

        EObject this_parExpression_0 = null;

        EObject this_literal_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3435:28: ( (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3436:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3436:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==62) ) {
                alt55=1;
            }
            else if ( ((LA55_0>=RULE_STRING && LA55_0<=RULE_INT)||(LA55_0>=82 && LA55_0<=85)) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3437:5: this_parExpression_0= ruleparExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getParExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleparExpression_in_ruleprimary8052);
                    this_parExpression_0=ruleparExpression();

                    state._fsp--;

                     
                            current = this_parExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3447:5: this_literal_1= ruleliteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleliteral_in_ruleprimary8079);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3463:1: entryRuleliteral returns [EObject current=null] : iv_ruleliteral= ruleliteral EOF ;
    public final EObject entryRuleliteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleliteral = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3464:2: (iv_ruleliteral= ruleliteral EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3465:2: iv_ruleliteral= ruleliteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleliteral_in_entryRuleliteral8114);
            iv_ruleliteral=ruleliteral();

            state._fsp--;

             current =iv_ruleliteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleliteral8124); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3472:1: ruleliteral returns [EObject current=null] : (this_INT_0= RULE_INT | ruleDOUBLE | this_STRING_2= RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | otherlv_5= 'true' | otherlv_6= 'TRUE' | otherlv_7= 'false' | otherlv_8= 'FALSE' ) ;
    public final EObject ruleliteral() throws RecognitionException {
        EObject current = null;

        Token this_INT_0=null;
        Token this_STRING_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject this_javaFunctionCall_4 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3475:28: ( (this_INT_0= RULE_INT | ruleDOUBLE | this_STRING_2= RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | otherlv_5= 'true' | otherlv_6= 'TRUE' | otherlv_7= 'false' | otherlv_8= 'FALSE' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3476:1: (this_INT_0= RULE_INT | ruleDOUBLE | this_STRING_2= RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | otherlv_5= 'true' | otherlv_6= 'TRUE' | otherlv_7= 'false' | otherlv_8= 'FALSE' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3476:1: (this_INT_0= RULE_INT | ruleDOUBLE | this_STRING_2= RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | otherlv_5= 'true' | otherlv_6= 'TRUE' | otherlv_7= 'false' | otherlv_8= 'FALSE' )
            int alt56=9;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3476:2: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleliteral8160); 
                     
                        newLeafNode(this_INT_0, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3482:5: ruleDOUBLE
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDOUBLEParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDOUBLE_in_ruleliteral8181);
                    ruleDOUBLE();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3490:6: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleliteral8197); 
                     
                        newLeafNode(this_STRING_2, grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3496:5: ruleextendedID
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getExtendedIDParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleliteral8218);
                    ruleextendedID();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3505:5: this_javaFunctionCall_4= rulejavaFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getJavaFunctionCallParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_rulejavaFunctionCall_in_ruleliteral8245);
                    this_javaFunctionCall_4=rulejavaFunctionCall();

                    state._fsp--;

                     
                            current = this_javaFunctionCall_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3514:7: otherlv_5= 'true'
                    {
                    otherlv_5=(Token)match(input,82,FOLLOW_82_in_ruleliteral8262); 

                        	newLeafNode(otherlv_5, grammarAccess.getLiteralAccess().getTrueKeyword_5());
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3519:7: otherlv_6= 'TRUE'
                    {
                    otherlv_6=(Token)match(input,83,FOLLOW_83_in_ruleliteral8280); 

                        	newLeafNode(otherlv_6, grammarAccess.getLiteralAccess().getTRUEKeyword_6());
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3524:7: otherlv_7= 'false'
                    {
                    otherlv_7=(Token)match(input,84,FOLLOW_84_in_ruleliteral8298); 

                        	newLeafNode(otherlv_7, grammarAccess.getLiteralAccess().getFalseKeyword_7());
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3529:7: otherlv_8= 'FALSE'
                    {
                    otherlv_8=(Token)match(input,85,FOLLOW_85_in_ruleliteral8316); 

                        	newLeafNode(otherlv_8, grammarAccess.getLiteralAccess().getFALSEKeyword_8());
                        

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3547:1: entryRulejavaFunctionDeclaration returns [EObject current=null] : iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF ;
    public final EObject entryRulejavaFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDeclaration = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3548:2: (iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3549:2: iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getJavaFunctionDeclarationRule()); 
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration8358);
            iv_rulejavaFunctionDeclaration=rulejavaFunctionDeclaration();

            state._fsp--;

             current =iv_rulejavaFunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDeclaration8368); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3556:1: rulejavaFunctionDeclaration returns [EObject current=null] : ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) ) ;
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
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3559:28: ( ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3560:1: ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3560:1: ( (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3560:2: (otherlv_0= 'static' )? (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3560:2: (otherlv_0= 'static' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==86) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3560:4: otherlv_0= 'static'
                    {
                    otherlv_0=(Token)match(input,86,FOLLOW_86_in_rulejavaFunctionDeclaration8406); 

                        	newLeafNode(otherlv_0, grammarAccess.getJavaFunctionDeclarationAccess().getStaticKeyword_0());
                        

                    }
                    break;

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3564:3: (otherlv_1= 'public' | otherlv_2= 'private' | otherlv_3= 'protected' )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt58=1;
                }
                break;
            case 88:
                {
                alt58=2;
                }
                break;
            case 89:
                {
                alt58=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3564:5: otherlv_1= 'public'
                    {
                    otherlv_1=(Token)match(input,87,FOLLOW_87_in_rulejavaFunctionDeclaration8421); 

                        	newLeafNode(otherlv_1, grammarAccess.getJavaFunctionDeclarationAccess().getPublicKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3569:7: otherlv_2= 'private'
                    {
                    otherlv_2=(Token)match(input,88,FOLLOW_88_in_rulejavaFunctionDeclaration8439); 

                        	newLeafNode(otherlv_2, grammarAccess.getJavaFunctionDeclarationAccess().getPrivateKeyword_1_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3574:7: otherlv_3= 'protected'
                    {
                    otherlv_3=(Token)match(input,89,FOLLOW_89_in_rulejavaFunctionDeclaration8457); 

                        	newLeafNode(otherlv_3, grammarAccess.getJavaFunctionDeclarationAccess().getProtectedKeyword_1_2());
                        

                    }
                    break;

            }

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3578:2: ( ( (lv_returnType_4_0= ruleattributeType ) ) | otherlv_5= 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                {
                alt59=1;
                }
                break;
            case 90:
                {
                alt59=2;
                }
                break;
            case RULE_ID:
                {
                alt59=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3578:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3578:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3579:1: (lv_returnType_4_0= ruleattributeType )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3579:1: (lv_returnType_4_0= ruleattributeType )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3580:3: lv_returnType_4_0= ruleattributeType
                    {
                     
                    	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getReturnTypeAttributeTypeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration8480);
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
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3597:7: otherlv_5= 'void'
                    {
                    otherlv_5=(Token)match(input,90,FOLLOW_90_in_rulejavaFunctionDeclaration8498); 

                        	newLeafNode(otherlv_5, grammarAccess.getJavaFunctionDeclarationAccess().getVoidKeyword_2_1());
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3602:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3602:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3603:1: (lv_referenceType_6_0= RULE_ID )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3603:1: (lv_referenceType_6_0= RULE_ID )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3604:3: lv_referenceType_6_0= RULE_ID
                    {
                    lv_referenceType_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration8521); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3620:3: ( (lv_name_7_0= RULE_ID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3621:1: (lv_name_7_0= RULE_ID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3621:1: (lv_name_7_0= RULE_ID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3622:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration8544); 

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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3638:2: ( (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' ) | otherlv_15= '()' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==62) ) {
                alt62=1;
            }
            else if ( (LA62_0==91) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3638:3: (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3638:3: (otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3638:5: otherlv_8= '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,62,FOLLOW_62_in_rulejavaFunctionDeclaration8563); 

                        	newLeafNode(otherlv_8, grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisKeyword_4_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3642:1: ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( ((LA61_0>=49 && LA61_0<=59)) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3642:2: ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3642:2: ( (lv_argList_9_0= ruleattributeType ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3643:1: (lv_argList_9_0= ruleattributeType )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3643:1: (lv_argList_9_0= ruleattributeType )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3644:3: lv_argList_9_0= ruleattributeType
                            {
                             
                            	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration8585);
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

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3660:2: ( (lv_argListID_10_0= ruleextendedID ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3661:1: (lv_argListID_10_0= ruleextendedID )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3661:1: (lv_argListID_10_0= ruleextendedID )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3662:3: lv_argListID_10_0= ruleextendedID
                            {
                             
                            	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration8606);
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

                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3678:2: (otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            loop60:
                            do {
                                int alt60=2;
                                int LA60_0 = input.LA(1);

                                if ( (LA60_0==38) ) {
                                    alt60=1;
                                }


                                switch (alt60) {
                            	case 1 :
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3678:4: otherlv_11= ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) )
                            	    {
                            	    otherlv_11=(Token)match(input,38,FOLLOW_38_in_rulejavaFunctionDeclaration8619); 

                            	        	newLeafNode(otherlv_11, grammarAccess.getJavaFunctionDeclarationAccess().getCommaKeyword_4_0_1_2_0());
                            	        
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3682:1: ( (lv_argList_12_0= ruleattributeType ) )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3683:1: (lv_argList_12_0= ruleattributeType )
                            	    {
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3683:1: (lv_argList_12_0= ruleattributeType )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3684:3: lv_argList_12_0= ruleattributeType
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration8640);
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

                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3700:2: ( (lv_argListID_13_0= ruleextendedID ) )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3701:1: (lv_argListID_13_0= ruleextendedID )
                            	    {
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3701:1: (lv_argListID_13_0= ruleextendedID )
                            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3702:3: lv_argListID_13_0= ruleextendedID
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_2_2_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration8661);
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
                            	    break loop60;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,63,FOLLOW_63_in_rulejavaFunctionDeclaration8677); 

                        	newLeafNode(otherlv_14, grammarAccess.getJavaFunctionDeclarationAccess().getRightParenthesisKeyword_4_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3723:7: otherlv_15= '()'
                    {
                    otherlv_15=(Token)match(input,91,FOLLOW_91_in_rulejavaFunctionDeclaration8696); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3735:1: entryRulejavaFunctionDefinition returns [EObject current=null] : iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF ;
    public final EObject entryRulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDefinition = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3736:2: (iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3737:2: iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF
            {
             newCompositeNode(grammarAccess.getJavaFunctionDefinitionRule()); 
            pushFollow(FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition8733);
            iv_rulejavaFunctionDefinition=rulejavaFunctionDefinition();

            state._fsp--;

             current =iv_rulejavaFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDefinition8743); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3744:1: rulejavaFunctionDefinition returns [EObject current=null] : ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject rulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_decl_0_0 = null;

        EObject lv_code_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3747:28: ( ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3748:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3748:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3748:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3748:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3749:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3749:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3750:3: lv_decl_0_0= rulejavaFunctionDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getDeclJavaFunctionDeclarationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition8789);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3766:2: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3767:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3767:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3768:3: lv_code_1_0= ruleblock
            {
             
            	        newCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getCodeBlockParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleblock_in_rulejavaFunctionDefinition8810);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3792:1: entryRulejavaFunctionCall returns [EObject current=null] : iv_rulejavaFunctionCall= rulejavaFunctionCall EOF ;
    public final EObject entryRulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionCall = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3793:2: (iv_rulejavaFunctionCall= rulejavaFunctionCall EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3794:2: iv_rulejavaFunctionCall= rulejavaFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getJavaFunctionCallRule()); 
            pushFollow(FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall8846);
            iv_rulejavaFunctionCall=rulejavaFunctionCall();

            state._fsp--;

             current =iv_rulejavaFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionCall8856); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3801:1: rulejavaFunctionCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) ) ;
    public final EObject rulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_args_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3804:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3805:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3805:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3805:2: ( (lv_name_0_0= ruleextendedID ) ) ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3805:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3806:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3806:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3807:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getJavaFunctionCallAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionCall8902);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3823:2: ( (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' ) | otherlv_4= '()' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==62) ) {
                alt64=1;
            }
            else if ( (LA64_0==91) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3823:3: (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3823:3: (otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3823:5: otherlv_1= '(' ( (lv_args_2_0= ruleexpressionList ) )? otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,62,FOLLOW_62_in_rulejavaFunctionCall8916); 

                        	newLeafNode(otherlv_1, grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisKeyword_1_0_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3827:1: ( (lv_args_2_0= ruleexpressionList ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( ((LA63_0>=RULE_STRING && LA63_0<=RULE_INT)||LA63_0==32||LA63_0==62||(LA63_0>=75 && LA63_0<=76)||(LA63_0>=79 && LA63_0<=85)) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3828:1: (lv_args_2_0= ruleexpressionList )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3828:1: (lv_args_2_0= ruleexpressionList )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3829:3: lv_args_2_0= ruleexpressionList
                            {
                             
                            	        newCompositeNode(grammarAccess.getJavaFunctionCallAccess().getArgsExpressionListParserRuleCall_1_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleexpressionList_in_rulejavaFunctionCall8937);
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

                    otherlv_3=(Token)match(input,63,FOLLOW_63_in_rulejavaFunctionCall8950); 

                        	newLeafNode(otherlv_3, grammarAccess.getJavaFunctionCallAccess().getRightParenthesisKeyword_1_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3850:7: otherlv_4= '()'
                    {
                    otherlv_4=(Token)match(input,91,FOLLOW_91_in_rulejavaFunctionCall8969); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3862:1: entryRuleblockStatement returns [EObject current=null] : iv_ruleblockStatement= ruleblockStatement EOF ;
    public final EObject entryRuleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblockStatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3863:2: (iv_ruleblockStatement= ruleblockStatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3864:2: iv_ruleblockStatement= ruleblockStatement EOF
            {
             newCompositeNode(grammarAccess.getBlockStatementRule()); 
            pushFollow(FOLLOW_ruleblockStatement_in_entryRuleblockStatement9006);
            iv_ruleblockStatement=ruleblockStatement();

            state._fsp--;

             current =iv_ruleblockStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblockStatement9016); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3871:1: ruleblockStatement returns [EObject current=null] : (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) ;
    public final EObject ruleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject this_statement_0 = null;

        EObject this_localVariableDeclarationStatement_1 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3874:28: ( (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3875:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3875:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_STRING && LA65_0<=RULE_INT)||LA65_0==15||LA65_0==18||LA65_0==32||LA65_0==62||(LA65_0>=75 && LA65_0<=76)||(LA65_0>=79 && LA65_0<=85)||LA65_0==92||(LA65_0>=94 && LA65_0<=98)) ) {
                alt65=1;
            }
            else if ( ((LA65_0>=49 && LA65_0<=59)) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3876:5: this_statement_0= rulestatement
                    {
                     
                            newCompositeNode(grammarAccess.getBlockStatementAccess().getStatementParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulestatement_in_ruleblockStatement9063);
                    this_statement_0=rulestatement();

                    state._fsp--;

                     
                            current = this_statement_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3886:5: this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement
                    {
                     
                            newCompositeNode(grammarAccess.getBlockStatementAccess().getLocalVariableDeclarationStatementParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement9090);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3902:1: entryRulelocalVariableDeclarationStatement returns [EObject current=null] : iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF ;
    public final EObject entryRulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclarationStatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3903:2: (iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3904:2: iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF
            {
             newCompositeNode(grammarAccess.getLocalVariableDeclarationStatementRule()); 
            pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement9125);
            iv_rulelocalVariableDeclarationStatement=rulelocalVariableDeclarationStatement();

            state._fsp--;

             current =iv_rulelocalVariableDeclarationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement9135); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3911:1: rulelocalVariableDeclarationStatement returns [EObject current=null] : (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' ) ;
    public final EObject rulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_localVariableDeclaration_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3914:28: ( (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3915:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3915:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';' )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3916:5: this_localVariableDeclaration_0= rulelocalVariableDeclaration otherlv_1= ';'
            {
             
                    newCompositeNode(grammarAccess.getLocalVariableDeclarationStatementAccess().getLocalVariableDeclarationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement9182);
            this_localVariableDeclaration_0=rulelocalVariableDeclaration();

            state._fsp--;

             
                    current = this_localVariableDeclaration_0; 
                    afterParserOrEnumRuleCall();
                
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulelocalVariableDeclarationStatement9193); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3936:1: entryRulelocalVariableDeclaration returns [EObject current=null] : iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF ;
    public final EObject entryRulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclaration = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3937:2: (iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3938:2: iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getLocalVariableDeclarationRule()); 
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration9229);
            iv_rulelocalVariableDeclaration=rulelocalVariableDeclaration();

            state._fsp--;

             current =iv_rulelocalVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclaration9239); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3945:1: rulelocalVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) ;
    public final EObject rulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_dec_1_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3948:28: ( ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3949:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3949:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3949:2: ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3949:2: ( (lv_type_0_0= ruleattributeType ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3950:1: (lv_type_0_0= ruleattributeType )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3950:1: (lv_type_0_0= ruleattributeType )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3951:3: lv_type_0_0= ruleattributeType
            {
             
            	        newCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getTypeAttributeTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration9285);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3967:2: ( (lv_dec_1_0= rulevariableDeclarators ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3968:1: (lv_dec_1_0= rulevariableDeclarators )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3968:1: (lv_dec_1_0= rulevariableDeclarators )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3969:3: lv_dec_1_0= rulevariableDeclarators
            {
             
            	        newCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getDecVariableDeclaratorsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration9306);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3993:1: entryRulevariableDeclarators returns [EObject current=null] : iv_rulevariableDeclarators= rulevariableDeclarators EOF ;
    public final EObject entryRulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarators = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3994:2: (iv_rulevariableDeclarators= rulevariableDeclarators EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3995:2: iv_rulevariableDeclarators= rulevariableDeclarators EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclaratorsRule()); 
            pushFollow(FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators9342);
            iv_rulevariableDeclarators=rulevariableDeclarators();

            state._fsp--;

             current =iv_rulevariableDeclarators; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarators9352); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4002:1: rulevariableDeclarators returns [EObject current=null] : ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) ;
    public final EObject rulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vd_0_0 = null;

        EObject lv_vd_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4005:28: ( ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4006:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4006:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4006:2: ( (lv_vd_0_0= rulevariableDeclarator ) ) (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4006:2: ( (lv_vd_0_0= rulevariableDeclarator ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4007:1: (lv_vd_0_0= rulevariableDeclarator )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4007:1: (lv_vd_0_0= rulevariableDeclarator )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4008:3: lv_vd_0_0= rulevariableDeclarator
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators9398);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4024:2: (otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==38) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4024:4: otherlv_1= ',' ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_38_in_rulevariableDeclarators9411); 

            	        	newLeafNode(otherlv_1, grammarAccess.getVariableDeclaratorsAccess().getCommaKeyword_1_0());
            	        
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4028:1: ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4029:1: (lv_vd_2_0= rulevariableDeclarator )
            	    {
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4029:1: (lv_vd_2_0= rulevariableDeclarator )
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4030:3: lv_vd_2_0= rulevariableDeclarator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators9432);
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
            	    break loop66;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4054:1: entryRulevariableDeclarator returns [EObject current=null] : iv_rulevariableDeclarator= rulevariableDeclarator EOF ;
    public final EObject entryRulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarator = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4055:2: (iv_rulevariableDeclarator= rulevariableDeclarator EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4056:2: iv_rulevariableDeclarator= rulevariableDeclarator EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclaratorRule()); 
            pushFollow(FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator9470);
            iv_rulevariableDeclarator=rulevariableDeclarator();

            state._fsp--;

             current =iv_rulevariableDeclarator; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarator9480); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4063:1: rulevariableDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) ;
    public final EObject rulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4066:28: ( ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4067:1: ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4067:1: ( ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4067:2: ( (lv_name_0_0= ruleextendedID ) ) (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4067:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4068:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4068:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4069:3: lv_name_0_0= ruleextendedID
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclaratorAccess().getNameExtendedIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulevariableDeclarator9526);
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

            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4085:2: (otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==46) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4085:4: otherlv_1= '=' ( (lv_exp_2_0= ruleexpression ) )
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_46_in_rulevariableDeclarator9539); 

                        	newLeafNode(otherlv_1, grammarAccess.getVariableDeclaratorAccess().getEqualsSignKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4089:1: ( (lv_exp_2_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4090:1: (lv_exp_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4090:1: (lv_exp_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4091:3: lv_exp_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclaratorAccess().getExpExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_rulevariableDeclarator9560);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4115:1: entryRulestatement returns [EObject current=null] : iv_rulestatement= rulestatement EOF ;
    public final EObject entryRulestatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestatement = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4116:2: (iv_rulestatement= rulestatement EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4117:2: iv_rulestatement= rulestatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_rulestatement_in_entryRulestatement9598);
            iv_rulestatement=rulestatement();

            state._fsp--;

             current =iv_rulestatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulestatement9608); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4124:1: rulestatement returns [EObject current=null] : (this_block_0= ruleblock | (otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | (otherlv_6= 'for' otherlv_7= '(' ( (lv_control_8_0= ruleforControl ) ) otherlv_9= ')' ( (lv_state_10_0= rulestatement ) ) ) | (otherlv_11= 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | (otherlv_14= 'return' ( (lv_retVal_15_0= ruleexpression ) )? otherlv_16= ';' ) | otherlv_17= ';' | (otherlv_18= 'break' otherlv_19= ';' ) | (this_expression_20= ruleexpression otherlv_21= ';' ) | (otherlv_22= 'try' ( (lv_tryBlock_23_0= ruleblock ) ) otherlv_24= 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) ) ;
    public final EObject rulestatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        EObject this_block_0 = null;

        EObject lv_condition_2_0 = null;

        EObject lv_state1_3_0 = null;

        EObject lv_state2_5_0 = null;

        EObject lv_control_8_0 = null;

        EObject lv_state_10_0 = null;

        EObject lv_condition_12_0 = null;

        EObject lv_state_13_0 = null;

        EObject lv_retVal_15_0 = null;

        EObject this_expression_20 = null;

        EObject lv_tryBlock_23_0 = null;

        EObject lv_catchBlock_25_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4127:28: ( (this_block_0= ruleblock | (otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | (otherlv_6= 'for' otherlv_7= '(' ( (lv_control_8_0= ruleforControl ) ) otherlv_9= ')' ( (lv_state_10_0= rulestatement ) ) ) | (otherlv_11= 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | (otherlv_14= 'return' ( (lv_retVal_15_0= ruleexpression ) )? otherlv_16= ';' ) | otherlv_17= ';' | (otherlv_18= 'break' otherlv_19= ';' ) | (this_expression_20= ruleexpression otherlv_21= ';' ) | (otherlv_22= 'try' ( (lv_tryBlock_23_0= ruleblock ) ) otherlv_24= 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4128:1: (this_block_0= ruleblock | (otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | (otherlv_6= 'for' otherlv_7= '(' ( (lv_control_8_0= ruleforControl ) ) otherlv_9= ')' ( (lv_state_10_0= rulestatement ) ) ) | (otherlv_11= 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | (otherlv_14= 'return' ( (lv_retVal_15_0= ruleexpression ) )? otherlv_16= ';' ) | otherlv_17= ';' | (otherlv_18= 'break' otherlv_19= ';' ) | (this_expression_20= ruleexpression otherlv_21= ';' ) | (otherlv_22= 'try' ( (lv_tryBlock_23_0= ruleblock ) ) otherlv_24= 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4128:1: (this_block_0= ruleblock | (otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | (otherlv_6= 'for' otherlv_7= '(' ( (lv_control_8_0= ruleforControl ) ) otherlv_9= ')' ( (lv_state_10_0= rulestatement ) ) ) | (otherlv_11= 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | (otherlv_14= 'return' ( (lv_retVal_15_0= ruleexpression ) )? otherlv_16= ';' ) | otherlv_17= ';' | (otherlv_18= 'break' otherlv_19= ';' ) | (this_expression_20= ruleexpression otherlv_21= ';' ) | (otherlv_22= 'try' ( (lv_tryBlock_23_0= ruleblock ) ) otherlv_24= 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )
            int alt70=9;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt70=1;
                }
                break;
            case 92:
                {
                alt70=2;
                }
                break;
            case 94:
                {
                alt70=3;
                }
                break;
            case 95:
                {
                alt70=4;
                }
                break;
            case 96:
                {
                alt70=5;
                }
                break;
            case 18:
                {
                alt70=6;
                }
                break;
            case 97:
                {
                alt70=7;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 32:
            case 62:
            case 75:
            case 76:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
                {
                alt70=8;
                }
                break;
            case 98:
                {
                alt70=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4129:5: this_block_0= ruleblock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleblock_in_rulestatement9655);
                    this_block_0=ruleblock();

                    state._fsp--;

                     
                            current = this_block_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4138:6: (otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4138:6: (otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4138:8: otherlv_1= 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )?
                    {
                    otherlv_1=(Token)match(input,92,FOLLOW_92_in_rulestatement9673); 

                        	newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getIfKeyword_1_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4142:1: ( (lv_condition_2_0= ruleparExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4143:1: (lv_condition_2_0= ruleparExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4143:1: (lv_condition_2_0= ruleparExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4144:3: lv_condition_2_0= ruleparExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getConditionParExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleparExpression_in_rulestatement9694);
                    lv_condition_2_0=ruleparExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_2_0, 
                            		"parExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4160:2: ( (lv_state1_3_0= rulestatement ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4161:1: (lv_state1_3_0= rulestatement )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4161:1: (lv_state1_3_0= rulestatement )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4162:3: lv_state1_3_0= rulestatement
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getState1StatementParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement9715);
                    lv_state1_3_0=rulestatement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"state1",
                            		lv_state1_3_0, 
                            		"statement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4178:2: (otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==93) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4178:4: otherlv_4= 'else' ( (lv_state2_5_0= rulestatement ) )
                            {
                            otherlv_4=(Token)match(input,93,FOLLOW_93_in_rulestatement9728); 

                                	newLeafNode(otherlv_4, grammarAccess.getStatementAccess().getElseKeyword_1_3_0());
                                
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4182:1: ( (lv_state2_5_0= rulestatement ) )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4183:1: (lv_state2_5_0= rulestatement )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4183:1: (lv_state2_5_0= rulestatement )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4184:3: lv_state2_5_0= rulestatement
                            {
                             
                            	        newCompositeNode(grammarAccess.getStatementAccess().getState2StatementParserRuleCall_1_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_rulestatement_in_rulestatement9749);
                            lv_state2_5_0=rulestatement();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getStatementRule());
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
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4201:6: (otherlv_6= 'for' otherlv_7= '(' ( (lv_control_8_0= ruleforControl ) ) otherlv_9= ')' ( (lv_state_10_0= rulestatement ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4201:6: (otherlv_6= 'for' otherlv_7= '(' ( (lv_control_8_0= ruleforControl ) ) otherlv_9= ')' ( (lv_state_10_0= rulestatement ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4201:8: otherlv_6= 'for' otherlv_7= '(' ( (lv_control_8_0= ruleforControl ) ) otherlv_9= ')' ( (lv_state_10_0= rulestatement ) )
                    {
                    otherlv_6=(Token)match(input,94,FOLLOW_94_in_rulestatement9771); 

                        	newLeafNode(otherlv_6, grammarAccess.getStatementAccess().getForKeyword_2_0());
                        
                    otherlv_7=(Token)match(input,62,FOLLOW_62_in_rulestatement9783); 

                        	newLeafNode(otherlv_7, grammarAccess.getStatementAccess().getLeftParenthesisKeyword_2_1());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4209:1: ( (lv_control_8_0= ruleforControl ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4210:1: (lv_control_8_0= ruleforControl )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4210:1: (lv_control_8_0= ruleforControl )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4211:3: lv_control_8_0= ruleforControl
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getControlForControlParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleforControl_in_rulestatement9804);
                    lv_control_8_0=ruleforControl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"control",
                            		lv_control_8_0, 
                            		"forControl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,63,FOLLOW_63_in_rulestatement9816); 

                        	newLeafNode(otherlv_9, grammarAccess.getStatementAccess().getRightParenthesisKeyword_2_3());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4231:1: ( (lv_state_10_0= rulestatement ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4232:1: (lv_state_10_0= rulestatement )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4232:1: (lv_state_10_0= rulestatement )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4233:3: lv_state_10_0= rulestatement
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getStateStatementParserRuleCall_2_4_0()); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement9837);
                    lv_state_10_0=rulestatement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"state",
                            		lv_state_10_0, 
                            		"statement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4250:6: (otherlv_11= 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4250:6: (otherlv_11= 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4250:8: otherlv_11= 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) )
                    {
                    otherlv_11=(Token)match(input,95,FOLLOW_95_in_rulestatement9857); 

                        	newLeafNode(otherlv_11, grammarAccess.getStatementAccess().getWhileKeyword_3_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4254:1: ( (lv_condition_12_0= ruleparExpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4255:1: (lv_condition_12_0= ruleparExpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4255:1: (lv_condition_12_0= ruleparExpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4256:3: lv_condition_12_0= ruleparExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getConditionParExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleparExpression_in_rulestatement9878);
                    lv_condition_12_0=ruleparExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_12_0, 
                            		"parExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4272:2: ( (lv_state_13_0= rulestatement ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4273:1: (lv_state_13_0= rulestatement )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4273:1: (lv_state_13_0= rulestatement )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4274:3: lv_state_13_0= rulestatement
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getStateStatementParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement9899);
                    lv_state_13_0=rulestatement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"state",
                            		lv_state_13_0, 
                            		"statement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4291:6: (otherlv_14= 'return' ( (lv_retVal_15_0= ruleexpression ) )? otherlv_16= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4291:6: (otherlv_14= 'return' ( (lv_retVal_15_0= ruleexpression ) )? otherlv_16= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4291:8: otherlv_14= 'return' ( (lv_retVal_15_0= ruleexpression ) )? otherlv_16= ';'
                    {
                    otherlv_14=(Token)match(input,96,FOLLOW_96_in_rulestatement9919); 

                        	newLeafNode(otherlv_14, grammarAccess.getStatementAccess().getReturnKeyword_4_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4295:1: ( (lv_retVal_15_0= ruleexpression ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_INT)||LA69_0==32||LA69_0==62||(LA69_0>=75 && LA69_0<=76)||(LA69_0>=79 && LA69_0<=85)) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4296:1: (lv_retVal_15_0= ruleexpression )
                            {
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4296:1: (lv_retVal_15_0= ruleexpression )
                            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4297:3: lv_retVal_15_0= ruleexpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getStatementAccess().getRetValExpressionParserRuleCall_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleexpression_in_rulestatement9940);
                            lv_retVal_15_0=ruleexpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getStatementRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"retVal",
                                    		lv_retVal_15_0, 
                                    		"expression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,18,FOLLOW_18_in_rulestatement9953); 

                        	newLeafNode(otherlv_16, grammarAccess.getStatementAccess().getSemicolonKeyword_4_2());
                        

                    }


                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4318:7: otherlv_17= ';'
                    {
                    otherlv_17=(Token)match(input,18,FOLLOW_18_in_rulestatement9972); 

                        	newLeafNode(otherlv_17, grammarAccess.getStatementAccess().getSemicolonKeyword_5());
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4323:6: (otherlv_18= 'break' otherlv_19= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4323:6: (otherlv_18= 'break' otherlv_19= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4323:8: otherlv_18= 'break' otherlv_19= ';'
                    {
                    otherlv_18=(Token)match(input,97,FOLLOW_97_in_rulestatement9991); 

                        	newLeafNode(otherlv_18, grammarAccess.getStatementAccess().getBreakKeyword_6_0());
                        
                    otherlv_19=(Token)match(input,18,FOLLOW_18_in_rulestatement10003); 

                        	newLeafNode(otherlv_19, grammarAccess.getStatementAccess().getSemicolonKeyword_6_1());
                        

                    }


                    }
                    break;
                case 8 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4332:6: (this_expression_20= ruleexpression otherlv_21= ';' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4332:6: (this_expression_20= ruleexpression otherlv_21= ';' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4333:5: this_expression_20= ruleexpression otherlv_21= ';'
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getExpressionParserRuleCall_7_0()); 
                        
                    pushFollow(FOLLOW_ruleexpression_in_rulestatement10033);
                    this_expression_20=ruleexpression();

                    state._fsp--;

                     
                            current = this_expression_20; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_21=(Token)match(input,18,FOLLOW_18_in_rulestatement10044); 

                        	newLeafNode(otherlv_21, grammarAccess.getStatementAccess().getSemicolonKeyword_7_1());
                        

                    }


                    }
                    break;
                case 9 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4346:6: (otherlv_22= 'try' ( (lv_tryBlock_23_0= ruleblock ) ) otherlv_24= 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4346:6: (otherlv_22= 'try' ( (lv_tryBlock_23_0= ruleblock ) ) otherlv_24= 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4346:8: otherlv_22= 'try' ( (lv_tryBlock_23_0= ruleblock ) ) otherlv_24= 'catch' ( (lv_catchBlock_25_0= ruleblock ) )
                    {
                    otherlv_22=(Token)match(input,98,FOLLOW_98_in_rulestatement10064); 

                        	newLeafNode(otherlv_22, grammarAccess.getStatementAccess().getTryKeyword_8_0());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4350:1: ( (lv_tryBlock_23_0= ruleblock ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4351:1: (lv_tryBlock_23_0= ruleblock )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4351:1: (lv_tryBlock_23_0= ruleblock )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4352:3: lv_tryBlock_23_0= ruleblock
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getTryBlockBlockParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_rulestatement10085);
                    lv_tryBlock_23_0=ruleblock();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"tryBlock",
                            		lv_tryBlock_23_0, 
                            		"block");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_24=(Token)match(input,99,FOLLOW_99_in_rulestatement10097); 

                        	newLeafNode(otherlv_24, grammarAccess.getStatementAccess().getCatchKeyword_8_2());
                        
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4372:1: ( (lv_catchBlock_25_0= ruleblock ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4373:1: (lv_catchBlock_25_0= ruleblock )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4373:1: (lv_catchBlock_25_0= ruleblock )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4374:3: lv_catchBlock_25_0= ruleblock
                    {
                     
                    	        newCompositeNode(grammarAccess.getStatementAccess().getCatchBlockBlockParserRuleCall_8_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_rulestatement10118);
                    lv_catchBlock_25_0=ruleblock();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"catchBlock",
                            		lv_catchBlock_25_0, 
                            		"block");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "rulestatement"


    // $ANTLR start "entryRuleforControl"
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4398:1: entryRuleforControl returns [EObject current=null] : iv_ruleforControl= ruleforControl EOF ;
    public final EObject entryRuleforControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforControl = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4399:2: (iv_ruleforControl= ruleforControl EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4400:2: iv_ruleforControl= ruleforControl EOF
            {
             newCompositeNode(grammarAccess.getForControlRule()); 
            pushFollow(FOLLOW_ruleforControl_in_entryRuleforControl10155);
            iv_ruleforControl=ruleforControl();

            state._fsp--;

             current =iv_ruleforControl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforControl10165); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4407:1: ruleforControl returns [EObject current=null] : ( ( (lv_init_0_0= ruleforInit ) )? otherlv_1= ';' ( (lv_condition_2_0= ruleexpression ) )? otherlv_3= ';' ( (lv_update_4_0= ruleforUpdate ) )? ) ;
    public final EObject ruleforControl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_init_0_0 = null;

        EObject lv_condition_2_0 = null;

        EObject lv_update_4_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4410:28: ( ( ( (lv_init_0_0= ruleforInit ) )? otherlv_1= ';' ( (lv_condition_2_0= ruleexpression ) )? otherlv_3= ';' ( (lv_update_4_0= ruleforUpdate ) )? ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4411:1: ( ( (lv_init_0_0= ruleforInit ) )? otherlv_1= ';' ( (lv_condition_2_0= ruleexpression ) )? otherlv_3= ';' ( (lv_update_4_0= ruleforUpdate ) )? )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4411:1: ( ( (lv_init_0_0= ruleforInit ) )? otherlv_1= ';' ( (lv_condition_2_0= ruleexpression ) )? otherlv_3= ';' ( (lv_update_4_0= ruleforUpdate ) )? )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4411:2: ( (lv_init_0_0= ruleforInit ) )? otherlv_1= ';' ( (lv_condition_2_0= ruleexpression ) )? otherlv_3= ';' ( (lv_update_4_0= ruleforUpdate ) )?
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4411:2: ( (lv_init_0_0= ruleforInit ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_STRING && LA71_0<=RULE_INT)||LA71_0==32||(LA71_0>=49 && LA71_0<=59)||LA71_0==62||(LA71_0>=75 && LA71_0<=76)||(LA71_0>=79 && LA71_0<=85)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4412:1: (lv_init_0_0= ruleforInit )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4412:1: (lv_init_0_0= ruleforInit )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4413:3: lv_init_0_0= ruleforInit
                    {
                     
                    	        newCompositeNode(grammarAccess.getForControlAccess().getInitForInitParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleforInit_in_ruleforControl10211);
                    lv_init_0_0=ruleforInit();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForControlRule());
                    	        }
                           		set(
                           			current, 
                           			"init",
                            		lv_init_0_0, 
                            		"forInit");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleforControl10224); 

                	newLeafNode(otherlv_1, grammarAccess.getForControlAccess().getSemicolonKeyword_1());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4433:1: ( (lv_condition_2_0= ruleexpression ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_STRING && LA72_0<=RULE_INT)||LA72_0==32||LA72_0==62||(LA72_0>=75 && LA72_0<=76)||(LA72_0>=79 && LA72_0<=85)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4434:1: (lv_condition_2_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4434:1: (lv_condition_2_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4435:3: lv_condition_2_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getForControlAccess().getConditionExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforControl10245);
                    lv_condition_2_0=ruleexpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForControlRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_2_0, 
                            		"expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleforControl10258); 

                	newLeafNode(otherlv_3, grammarAccess.getForControlAccess().getSemicolonKeyword_3());
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4455:1: ( (lv_update_4_0= ruleforUpdate ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_STRING && LA73_0<=RULE_INT)||LA73_0==32||LA73_0==62||(LA73_0>=75 && LA73_0<=76)||(LA73_0>=79 && LA73_0<=85)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4456:1: (lv_update_4_0= ruleforUpdate )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4456:1: (lv_update_4_0= ruleforUpdate )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4457:3: lv_update_4_0= ruleforUpdate
                    {
                     
                    	        newCompositeNode(grammarAccess.getForControlAccess().getUpdateForUpdateParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleforUpdate_in_ruleforControl10279);
                    lv_update_4_0=ruleforUpdate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForControlRule());
                    	        }
                           		set(
                           			current, 
                           			"update",
                            		lv_update_4_0, 
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4481:1: entryRuleforInit returns [EObject current=null] : iv_ruleforInit= ruleforInit EOF ;
    public final EObject entryRuleforInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforInit = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4482:2: (iv_ruleforInit= ruleforInit EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4483:2: iv_ruleforInit= ruleforInit EOF
            {
             newCompositeNode(grammarAccess.getForInitRule()); 
            pushFollow(FOLLOW_ruleforInit_in_entryRuleforInit10316);
            iv_ruleforInit=ruleforInit();

            state._fsp--;

             current =iv_ruleforInit; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforInit10326); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4490:1: ruleforInit returns [EObject current=null] : ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) ;
    public final EObject ruleforInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;

        EObject this_localVariableDeclaration_3 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4493:28: ( ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4494:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4494:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_STRING && LA75_0<=RULE_INT)||LA75_0==32||LA75_0==62||(LA75_0>=75 && LA75_0<=76)||(LA75_0>=79 && LA75_0<=85)) ) {
                alt75=1;
            }
            else if ( ((LA75_0>=49 && LA75_0<=59)) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4494:2: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4494:2: ( ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4494:3: ( (lv_expressions_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4494:3: ( (lv_expressions_0_0= ruleexpression ) )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4495:1: (lv_expressions_0_0= ruleexpression )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4495:1: (lv_expressions_0_0= ruleexpression )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4496:3: lv_expressions_0_0= ruleexpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforInit10373);
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

                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4512:2: (otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==38) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4512:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleexpression ) )
                    	    {
                    	    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleforInit10386); 

                    	        	newLeafNode(otherlv_1, grammarAccess.getForInitAccess().getCommaKeyword_0_1_0());
                    	        
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4516:1: ( (lv_expressions_2_0= ruleexpression ) )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4517:1: (lv_expressions_2_0= ruleexpression )
                    	    {
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4517:1: (lv_expressions_2_0= ruleexpression )
                    	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4518:3: lv_expressions_2_0= ruleexpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleexpression_in_ruleforInit10407);
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
                    	    break loop74;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4536:5: this_localVariableDeclaration_3= rulelocalVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getForInitAccess().getLocalVariableDeclarationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclaration_in_ruleforInit10438);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4552:1: entryRuleforUpdate returns [EObject current=null] : iv_ruleforUpdate= ruleforUpdate EOF ;
    public final EObject entryRuleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforUpdate = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4553:2: (iv_ruleforUpdate= ruleforUpdate EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4554:2: iv_ruleforUpdate= ruleforUpdate EOF
            {
             newCompositeNode(grammarAccess.getForUpdateRule()); 
            pushFollow(FOLLOW_ruleforUpdate_in_entryRuleforUpdate10473);
            iv_ruleforUpdate=ruleforUpdate();

            state._fsp--;

             current =iv_ruleforUpdate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforUpdate10483); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4561:1: ruleforUpdate returns [EObject current=null] : this_expressionList_0= ruleexpressionList ;
    public final EObject ruleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject this_expressionList_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4564:28: (this_expressionList_0= ruleexpressionList )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4566:5: this_expressionList_0= ruleexpressionList
            {
             
                    newCompositeNode(grammarAccess.getForUpdateAccess().getExpressionListParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleexpressionList_in_ruleforUpdate10529);
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4582:1: entryRuleattributeType returns [String current=null] : iv_ruleattributeType= ruleattributeType EOF ;
    public final String entryRuleattributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleattributeType = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4583:2: (iv_ruleattributeType= ruleattributeType EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4584:2: iv_ruleattributeType= ruleattributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FOLLOW_ruleattributeType_in_entryRuleattributeType10564);
            iv_ruleattributeType=ruleattributeType();

            state._fsp--;

             current =iv_ruleattributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleattributeType10575); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4591:1: ruleattributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleattributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4594:28: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4595:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4595:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt76=11;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt76=1;
                }
                break;
            case 50:
                {
                alt76=2;
                }
                break;
            case 51:
                {
                alt76=3;
                }
                break;
            case 52:
                {
                alt76=4;
                }
                break;
            case 53:
                {
                alt76=5;
                }
                break;
            case 54:
                {
                alt76=6;
                }
                break;
            case 55:
                {
                alt76=7;
                }
                break;
            case 56:
                {
                alt76=8;
                }
                break;
            case 57:
                {
                alt76=9;
                }
                break;
            case 58:
                {
                alt76=10;
                }
                break;
            case 59:
                {
                alt76=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4596:2: kw= 'Date'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleattributeType10613); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getDateKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4603:2: kw= 'Time'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleattributeType10632); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getTimeKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4610:2: kw= 'Double'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleattributeType10651); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getDoubleKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4617:2: kw= 'double'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleattributeType10670); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getDoubleKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4624:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleattributeType10689); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getIntegerKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4631:2: kw= 'integer'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleattributeType10708); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getIntegerKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4638:2: kw= 'int'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleattributeType10727); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getIntKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4645:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleattributeType10746); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getBooleanKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4652:2: kw= 'boolean'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleattributeType10765); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getBooleanKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4659:2: kw= 'String'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleattributeType10784); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAttributeTypeAccess().getStringKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4666:2: kw= 'string'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleattributeType10803); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4685:1: entryRuleextendedID returns [String current=null] : iv_ruleextendedID= ruleextendedID EOF ;
    public final String entryRuleextendedID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleextendedID = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4686:2: (iv_ruleextendedID= ruleextendedID EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4687:2: iv_ruleextendedID= ruleextendedID EOF
            {
             newCompositeNode(grammarAccess.getExtendedIDRule()); 
            pushFollow(FOLLOW_ruleextendedID_in_entryRuleextendedID10850);
            iv_ruleextendedID=ruleextendedID();

            state._fsp--;

             current =iv_ruleextendedID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleextendedID10861); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4694:1: ruleextendedID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleextendedID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4697:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4698:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4698:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4698:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID10901); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_0()); 
                
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4705:1: (kw= '.' this_ID_2= RULE_ID )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==100) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4706:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,100,FOLLOW_100_in_ruleextendedID10920); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getExtendedIDAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID10935); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop77;
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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4726:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4727:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4728:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             newCompositeNode(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE10983);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOUBLE10994); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4735:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4738:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4739:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4739:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4739:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE11034); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
                
            kw=(Token)match(input,100,FOLLOW_100_in_ruleDOUBLE11052); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE11067); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4769:1: entryRuleCHARS returns [String current=null] : iv_ruleCHARS= ruleCHARS EOF ;
    public final String entryRuleCHARS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCHARS = null;


        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4770:2: (iv_ruleCHARS= ruleCHARS EOF )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4771:2: iv_ruleCHARS= ruleCHARS EOF
            {
             newCompositeNode(grammarAccess.getCHARSRule()); 
            pushFollow(FOLLOW_ruleCHARS_in_entryRuleCHARS11115);
            iv_ruleCHARS=ruleCHARS();

            state._fsp--;

             current =iv_ruleCHARS.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCHARS11126); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4778:1: ruleCHARS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleCHARS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_extendedID_0 = null;


         enterRule(); 
            
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4781:28: ( (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4782:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4782:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_INT) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4783:5: this_extendedID_0= ruleextendedID
                    {
                     
                            newCompositeNode(grammarAccess.getCHARSAccess().getExtendedIDParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCHARS11173);
                    this_extendedID_0=ruleextendedID();

                    state._fsp--;


                    		current.merge(this_extendedID_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4794:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCHARS11199); 

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
    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4809:1: ruleModifier returns [Enumerator current=null] : ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) ) ;
    public final Enumerator ruleModifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4811:28: ( ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) ) )
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4812:1: ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) )
            {
            // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4812:1: ( (enumLiteral_0= 'immutable' ) | (enumLiteral_1= 'settable' ) | (enumLiteral_2= 'internal' ) | (enumLiteral_3= 'defaulted' ) | (enumLiteral_4= 'const' ) )
            int alt79=5;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt79=1;
                }
                break;
            case 102:
                {
                alt79=2;
                }
                break;
            case 103:
                {
                alt79=3;
                }
                break;
            case 104:
                {
                alt79=4;
                }
                break;
            case 105:
                {
                alt79=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4812:2: (enumLiteral_0= 'immutable' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4812:2: (enumLiteral_0= 'immutable' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4812:4: enumLiteral_0= 'immutable'
                    {
                    enumLiteral_0=(Token)match(input,101,FOLLOW_101_in_ruleModifier11258); 

                            current = grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4818:6: (enumLiteral_1= 'settable' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4818:6: (enumLiteral_1= 'settable' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4818:8: enumLiteral_1= 'settable'
                    {
                    enumLiteral_1=(Token)match(input,102,FOLLOW_102_in_ruleModifier11275); 

                            current = grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4824:6: (enumLiteral_2= 'internal' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4824:6: (enumLiteral_2= 'internal' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4824:8: enumLiteral_2= 'internal'
                    {
                    enumLiteral_2=(Token)match(input,103,FOLLOW_103_in_ruleModifier11292); 

                            current = grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4830:6: (enumLiteral_3= 'defaulted' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4830:6: (enumLiteral_3= 'defaulted' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4830:8: enumLiteral_3= 'defaulted'
                    {
                    enumLiteral_3=(Token)match(input,104,FOLLOW_104_in_ruleModifier11309); 

                            current = grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4836:6: (enumLiteral_4= 'const' )
                    {
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4836:6: (enumLiteral_4= 'const' )
                    // ../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4836:8: enumLiteral_4= 'const'
                    {
                    enumLiteral_4=(Token)match(input,105,FOLLOW_105_in_ruleModifier11326); 

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
    protected DFA56 dfa56 = new DFA56(this);
    static final String DFA10_eotS =
        "\14\uffff";
    static final String DFA10_eofS =
        "\14\uffff";
    static final String DFA10_minS =
        "\1\5\4\uffff\2\5\1\6\2\uffff\2\5";
    static final String DFA10_maxS =
        "\1\151\4\uffff\2\74\1\75\2\uffff\2\43";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\6\1\5\2\uffff";
    static final String DFA10_specialS =
        "\14\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\5\26\uffff\1\4\7\uffff\1\3\1\uffff\4\3\2\1\2\uffff\2"+
            "\2\13\1\1\uffff\1\6\47\uffff\5\1",
            "",
            "",
            "",
            "",
            "\1\10\31\uffff\4\10\1\11\30\uffff\1\7",
            "\1\10\31\uffff\4\10\1\11\30\uffff\1\7",
            "\1\12\66\uffff\1\13",
            "",
            "",
            "\1\10\31\uffff\4\10\1\11",
            "\1\10\31\uffff\4\10\1\11"
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
            return "828:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation )";
        }
    }
    static final String DFA11_eotS =
        "\14\uffff";
    static final String DFA11_eofS =
        "\14\uffff";
    static final String DFA11_minS =
        "\1\5\4\uffff\2\5\1\6\2\uffff\2\5";
    static final String DFA11_maxS =
        "\1\151\4\uffff\2\74\1\75\2\uffff\2\43";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\5\1\6\2\uffff";
    static final String DFA11_specialS =
        "\14\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\1\5\26\uffff\1\4\7\uffff\1\3\1\uffff\4\3\2\1\2\uffff\2"+
            "\2\13\1\1\uffff\1\6\47\uffff\5\1",
            "",
            "",
            "",
            "",
            "\1\11\31\uffff\4\11\1\10\30\uffff\1\7",
            "\1\11\31\uffff\4\11\1\10\30\uffff\1\7",
            "\1\12\66\uffff\1\13",
            "",
            "",
            "\1\11\31\uffff\4\11\1\10",
            "\1\11\31\uffff\4\11\1\10"
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
            return "908:1: (this_Attribute_0= ruleAttribute | this_Position_1= rulePosition | this_SoftwarePattern_2= ruleSoftwarePattern | this_Depend_3= ruleDepend | this_SymmetricReflexiveAssociation_4= ruleSymmetricReflexiveAssociation | this_InlineAssociation_5= ruleInlineAssociation )";
        }
    }
    static final String DFA56_eotS =
        "\16\uffff";
    static final String DFA56_eofS =
        "\1\uffff\1\11\1\uffff\1\13\11\uffff\1\13";
    static final String DFA56_minS =
        "\1\4\1\21\1\uffff\1\21\6\uffff\1\5\2\uffff\1\21";
    static final String DFA56_maxS =
        "\1\125\1\144\1\uffff\1\144\6\uffff\1\5\2\uffff\1\144";
    static final String DFA56_acceptS =
        "\2\uffff\1\3\1\uffff\1\6\1\7\1\10\1\11\1\2\1\1\1\uffff\1\4\1\5"+
        "\1\uffff";
    static final String DFA56_specialS =
        "\16\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\2\1\3\1\1\113\uffff\1\4\1\5\1\6\1\7",
            "\2\11\15\uffff\1\11\5\uffff\1\11\7\uffff\1\11\16\uffff\1\11"+
            "\1\uffff\21\11\24\uffff\1\10",
            "",
            "\2\13\15\uffff\1\13\5\uffff\1\13\7\uffff\1\13\16\uffff\1\13"+
            "\1\14\21\13\13\uffff\1\14\10\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "",
            "",
            "\2\13\15\uffff\1\13\5\uffff\1\13\7\uffff\1\13\16\uffff\1\13"+
            "\1\14\21\13\13\uffff\1\14\10\uffff\1\12"
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "3476:1: (this_INT_0= RULE_INT | ruleDOUBLE | this_STRING_2= RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | otherlv_5= 'true' | otherlv_6= 'TRUE' | otherlv_7= 'false' | otherlv_8= 'FALSE' )";
        }
    }
 

    public static final BitSet FOLLOW_ruleUmpleModel_in_entryRuleUmpleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_ruleUmpleModel130 = new BitSet(new long[]{0x000000101F884002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleAbstractElement223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlossary_in_ruleAbstractElement250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGenerate_in_ruleAbstractElement277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUseStatement_in_ruleAbstractElement304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleAbstractElement331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlossary_in_entryRuleGlossary366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlossary376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleGlossary422 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGlossary434 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_ruleWord_in_ruleGlossary455 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_ruleGlossary468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWord556 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleWord573 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWord590 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleWord607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGenerate_in_entryRuleGenerate643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGenerate653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleGenerate690 = new BitSet(new long[]{0x0000000000700000L});
    public static final BitSet FOLLOW_20_in_ruleGenerate709 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_21_in_ruleGenerate746 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_22_in_ruleGenerate783 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleGenerate809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUseStatement_in_entryRuleUseStatement845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUseStatement855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleUseStatement892 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUseStatement909 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUseStatement926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleNamespace1009 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamespace1026 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleNamespace1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassDefinition_in_ruleEntity1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceDefinition_in_ruleEntity1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDefinition_in_ruleEntity1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationDefinition_in_ruleEntity1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationClassDefinition_in_ruleEntity1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassDefinition_in_entryRuleClassDefinition1279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassDefinition1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleClassDefinition1326 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDefinition1343 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleClassDefinition1360 = new BitSet(new long[]{0x2FFF9FA020010060L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleClassContent_in_ruleClassDefinition1381 = new BitSet(new long[]{0x2FFF9FA020010060L,0x000003E000000000L});
    public static final BitSet FOLLOW_16_in_ruleClassDefinition1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDefinition_in_entryRuleExternalDefinition1430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDefinition1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleExternalDefinition1477 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalDefinition1494 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExternalDefinition1511 = new BitSet(new long[]{0x2FFF9FA020010060L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleClassContent_in_ruleExternalDefinition1532 = new BitSet(new long[]{0x2FFF9FA020010060L,0x000003E000000000L});
    public static final BitSet FOLLOW_16_in_ruleExternalDefinition1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceDefinition_in_entryRuleInterfaceDefinition1581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceDefinition1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleInterfaceDefinition1628 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterfaceDefinition1645 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInterfaceDefinition1662 = new BitSet(new long[]{0x0000000020010000L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleInterfaceDefinition1683 = new BitSet(new long[]{0x0000000020010000L});
    public static final BitSet FOLLOW_16_in_ruleInterfaceDefinition1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationDefinition_in_entryRuleAssociationDefinition1732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationDefinition1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAssociationDefinition1779 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociationDefinition1796 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssociationDefinition1813 = new BitSet(new long[]{0x2000000000010040L});
    public static final BitSet FOLLOW_ruleAssociation_in_ruleAssociationDefinition1834 = new BitSet(new long[]{0x2000000000010040L});
    public static final BitSet FOLLOW_16_in_ruleAssociationDefinition1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassContent_in_entryRuleClassContent1883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassContent1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleClassContent1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_ruleClassContent1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwarePattern_in_ruleClassContent1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleClassContent2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleClassContent2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_ruleClassContent2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationClassContent_in_entryRuleAssociationClassContent2110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationClassContent2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleAssociationClassContent2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_ruleAssociationClassContent2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwarePattern_in_ruleAssociationClassContent2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleAssociationClassContent2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleAssociationClassContent2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_ruleAssociationClassContent2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_entryRuleDepend2337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDepend2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDepend2384 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleDepend2405 = new BitSet(new long[]{0x0000000040040000L});
    public static final BitSet FOLLOW_30_in_ruleDepend2418 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDepend2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociation_in_entryRuleAssociation2468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociation2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation2519 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2535 = new BitSet(new long[]{0x0000000780000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2557 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_31_in_ruleAssociation2576 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_32_in_ruleAssociation2594 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_33_in_ruleAssociation2612 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_34_in_ruleAssociation2630 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation2647 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2663 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2685 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssociation2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation2739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation2790 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleSymmetricReflexiveAssociation2801 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation2818 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSymmetricReflexiveAssociation2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation2871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineAssociation2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation2922 = new BitSet(new long[]{0x0000000780000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation2938 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_31_in_ruleInlineAssociation2957 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_32_in_ruleInlineAssociation2975 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_33_in_ruleInlineAssociation2993 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_34_in_ruleInlineAssociation3011 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation3028 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3044 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3066 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleInlineAssociation3084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationClassDefinition_in_entryRuleAssociationClassDefinition3122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationClassDefinition3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAssociationClassDefinition3169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociationClassDefinition3186 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssociationClassDefinition3203 = new BitSet(new long[]{0x2FFF9FA020010060L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleAssociationClassContent_in_ruleAssociationClassDefinition3224 = new BitSet(new long[]{0x2FFF9FA020010060L,0x000003E000000000L});
    public static final BitSet FOLLOW_16_in_ruleAssociationClassDefinition3237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSoftwarePattern_in_entryRuleSoftwarePattern3273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSoftwarePattern3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleisA_in_ruleSoftwarePattern3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleton_in_ruleSoftwarePattern3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyDefinition_in_ruleSoftwarePattern3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeInjection_in_ruleSoftwarePattern3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleisA_in_entryRuleisA3446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleisA3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleisA3493 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleisA3513 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_38_in_ruleisA3526 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleisA3546 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_18_in_ruleisA3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleton_in_entryRuleSingleton3596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleton3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleSingleton3649 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSingleton3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyDefinition_in_entryRuleKeyDefinition3710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyDefinition3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleKeyDefinition3757 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKeyDefinition3778 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyDefinition3796 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleKeyDefinition3814 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyDefinition3831 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleKeyDefinition3852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection3888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodeInjection3898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleCodeInjection3936 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection3957 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodeInjection3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCodeInjection3999 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection4020 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodeInjection4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute4079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleAttribute4133 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleAttribute4167 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAttribute4179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleAttribute4205 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleModifier_in_ruleAttribute4240 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_ruleAttribute4264 = new BitSet(new long[]{0x0FFE380000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_45_in_ruleAttribute4282 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute4324 = new BitSet(new long[]{0x0FFE380000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_45_in_ruleAttribute4342 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleAttribute4380 = new BitSet(new long[]{0x0000400000040000L});
    public static final BitSet FOLLOW_46_in_ruleAttribute4393 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_ruleAttribute4414 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAttribute4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_entryRulePosition4465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePosition4475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_rulePosition4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementPosition_in_rulePosition4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementPosition_in_entryRuleElementPosition4584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementPosition4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleElementPosition4631 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition4648 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition4670 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition4692 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleElementPosition4714 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleElementPosition4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition4767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationPosition4777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAssociationPosition4814 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociationPosition4831 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition4857 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition4878 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssociationPosition4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinate_in_entryRuleCoordinate4926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinate4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate4978 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleCoordinate4995 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate5012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType5054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAttributeType5065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleUmpleAttributeType5103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleUmpleAttributeType5122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUmpleAttributeType5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleUmpleAttributeType5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleUmpleAttributeType5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUmpleAttributeType5198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUmpleAttributeType5217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleUmpleAttributeType5236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleUmpleAttributeType5255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUmpleAttributeType5274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUmpleAttributeType5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType5334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmplePrimitiveType5345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUmplePrimitiveType5385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType5411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_entryRulemultiplicity5457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicity5468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity5549 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_rulemultiplicity5567 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity5589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_entryRulebound5636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulebound5647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulebound5687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rulebound5711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_entryRuleblock5753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblock5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleblock5800 = new BitSet(new long[]{0x4FFE180100058070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_ruleblockStatement_in_ruleblock5821 = new BitSet(new long[]{0x4FFE180100058070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_16_in_ruleblock5834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_entryRuleparExpression5870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleparExpression5880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleparExpression5917 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleparExpression5939 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleparExpression5950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator5987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleassignmentOperator5998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleassignmentOperator6036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleassignmentOperator6055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleassignmentOperator6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_entryRuleexpressionList6114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpressionList6124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList6170 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleexpressionList6183 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList6204 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_entryRuleexpression6242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpression6252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_ruleexpression6298 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_ruleexpression6315 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpression6335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression6373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalExpression6383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression6429 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleconditionalExpression6442 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression6463 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleconditionalExpression6475 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression6496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression6534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalOrExpression6544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression6590 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleconditionalOrExpression6603 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression6624 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression6662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalAndExpression6672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression6718 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleconditionalAndExpression6731 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression6752 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression6790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleequalityExpression6800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression6846 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_69_in_ruleequalityExpression6860 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_70_in_ruleequalityExpression6878 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression6900 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression6938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalExpression6948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression6994 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000780L});
    public static final BitSet FOLLOW_rulerelationalOp_in_rulerelationalExpression7011 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression7031 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000780L});
    public static final BitSet FOLLOW_rulerelationalOp_in_entryRulerelationalOp7070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalOp7081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_rulerelationalOp7119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_rulerelationalOp7138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rulerelationalOp7157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_rulerelationalOp7176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression7216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleadditiveExpression7226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression7272 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_75_in_ruleadditiveExpression7286 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_76_in_ruleadditiveExpression7304 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression7326 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression7364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicativeExpression7374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression7420 = new BitSet(new long[]{0x2000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_61_in_rulemultiplicativeExpression7434 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_77_in_rulemultiplicativeExpression7452 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_78_in_rulemultiplicativeExpression7470 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression7492 = new BitSet(new long[]{0x2000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression7530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpression7540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleunaryExpression7578 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression7599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleunaryExpression7619 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression7640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleunaryExpression7660 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression7681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleunaryExpression7701 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression7722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression7750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus7786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus7796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleunaryExpressionNotPlusMinus7834 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus7856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleunaryExpressionNotPlusMinus7875 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus7897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus7926 = new BitSet(new long[]{0x0000000100000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleunaryExpressionNotPlusMinus7938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleunaryExpressionNotPlusMinus7956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_entryRuleprimary7995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimary8005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_ruleprimary8052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_ruleprimary8079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_entryRuleliteral8114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleliteral8124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleliteral8160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleliteral8181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleliteral8197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleliteral8218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_ruleliteral8245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleliteral8262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleliteral8280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleliteral8298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleliteral8316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration8358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDeclaration8368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rulejavaFunctionDeclaration8406 = new BitSet(new long[]{0x0000000000000000L,0x0000000003800000L});
    public static final BitSet FOLLOW_87_in_rulejavaFunctionDeclaration8421 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D43F9800L});
    public static final BitSet FOLLOW_88_in_rulejavaFunctionDeclaration8439 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D43F9800L});
    public static final BitSet FOLLOW_89_in_rulejavaFunctionDeclaration8457 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D43F9800L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration8480 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_90_in_rulejavaFunctionDeclaration8498 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration8521 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration8544 = new BitSet(new long[]{0x4000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_62_in_rulejavaFunctionDeclaration8563 = new BitSet(new long[]{0xCFFE180100048070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration8585 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration8606 = new BitSet(new long[]{0x8000004000000000L});
    public static final BitSet FOLLOW_38_in_rulejavaFunctionDeclaration8619 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration8640 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration8661 = new BitSet(new long[]{0x8000004000000000L});
    public static final BitSet FOLLOW_63_in_rulejavaFunctionDeclaration8677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rulejavaFunctionDeclaration8696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition8733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDefinition8743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition8789 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleblock_in_rulejavaFunctionDefinition8810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall8846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionCall8856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionCall8902 = new BitSet(new long[]{0x4000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_62_in_rulejavaFunctionCall8916 = new BitSet(new long[]{0xCFFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpressionList_in_rulejavaFunctionCall8937 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_rulejavaFunctionCall8950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rulejavaFunctionCall8969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblockStatement_in_entryRuleblockStatement9006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblockStatement9016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_ruleblockStatement9063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement9090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement9125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement9135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement9182 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulelocalVariableDeclarationStatement9193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration9229 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclaration9239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration9285 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration9306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators9342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarators9352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators9398 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_rulevariableDeclarators9411 = new BitSet(new long[]{0x0FFE180000000020L,0x000003E000000000L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators9432 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator9470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarator9480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulevariableDeclarator9526 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_rulevariableDeclarator9539 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_rulevariableDeclarator9560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_entryRulestatement9598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulestatement9608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement9655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_rulestatement9673 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ruleparExpression_in_rulestatement9694 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement9715 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_rulestatement9728 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement9749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_rulestatement9771 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_rulestatement9783 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_ruleforControl_in_rulestatement9804 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_rulestatement9816 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement9837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_rulestatement9857 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ruleparExpression_in_rulestatement9878 = new BitSet(new long[]{0x4FFE180100048070L,0x000003E7D03F9800L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement9899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_rulestatement9919 = new BitSet(new long[]{0x4FFE180100040070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_rulestatement9940 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulestatement9953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulestatement9972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_rulestatement9991 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulestatement10003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_rulestatement10033 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulestatement10044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_rulestatement10064 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement10085 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_rulestatement10097 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement10118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforControl_in_entryRuleforControl10155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforControl10165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_ruleforControl10211 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleforControl10224 = new BitSet(new long[]{0x4FFE180100040070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforControl10245 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleforControl10258 = new BitSet(new long[]{0x4FFE180100000072L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleforUpdate_in_ruleforControl10279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_entryRuleforInit10316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforInit10326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit10373 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleforInit10386 = new BitSet(new long[]{0x4FFE180100000070L,0x000003E0003F9800L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit10407 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_ruleforInit10438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforUpdate_in_entryRuleforUpdate10473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforUpdate10483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_ruleforUpdate10529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_entryRuleattributeType10564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleattributeType10575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleattributeType10613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleattributeType10632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleattributeType10651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleattributeType10670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleattributeType10689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleattributeType10708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleattributeType10727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleattributeType10746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleattributeType10765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleattributeType10784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleattributeType10803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_entryRuleextendedID10850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleextendedID10861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID10901 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_ruleextendedID10920 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID10935 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE10983 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE10994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE11034 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_ruleDOUBLE11052 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE11067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCHARS_in_entryRuleCHARS11115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCHARS11126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCHARS11173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCHARS11199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleModifier11258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleModifier11275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleModifier11292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleModifier11309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleModifier11326 = new BitSet(new long[]{0x0000000000000002L});

}