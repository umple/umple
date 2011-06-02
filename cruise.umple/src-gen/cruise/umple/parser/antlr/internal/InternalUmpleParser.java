package cruise.umple.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import cruise.umple.services.UmpleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmpleParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_RUBY_FUNCTION", "RULE_DEF", "RULE_END", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "';'", "'glossary'", "'{'", "'}'", "'generate'", "'Java'", "'Php'", "'Ruby'", "'use'", "'namespace'", "'external'", "'class'", "'isA'", "','", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'interface'", "'association'", "'associationClass'", "'->'", "'--'", "'<-'", "'><'", "'self'", "'..'", "'*'", "'singleton'", "'before'", "'after'", "'autounique'", "'unique'", "'[]'", "'='", "'Date'", "'Time'", "'Double'", "'Integer'", "'integer'", "'Boolean'", "'String'", "'string'", "'key'", "'depend'", "'.*'", "'statemachine'", "'as'", "'conc'", "'concurrent'", "'|'", "'afterEvery'", "'('", "')'", "'wait'", "'/'", "'entry'", "'exit'", "'do'", "'['", "']'", "'position'", "'position.association'", "'trace'", "'Trace'", "'tracecase'", "'cflow'", "'()'", "'>'", "'<'", "'=='", "'>='", "'<='", "'TraceUsing'", "'+='", "'-='", "'?'", "'||'", "'&&'", "'!='", "'+'", "'-'", "'%'", "'++'", "'~'", "'!'", "'true'", "'TRUE'", "'false'", "'FALSE'", "'static'", "'public'", "'private'", "'protected'", "'void'", "'if'", "'else'", "'for'", "'while'", "'return'", "'break'", "'try'", "'catch'", "'function'", "'.'", "'immutable'", "'settable'", "'internal'", "'defaulted'", "'const'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_RUBY_FUNCTION=7;
    public static final int RULE_END=9;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_INT=6;
    public static final int RULE_DEF=8;
    public static final int RULE_WS=12;
    public static final int RULE_SL_COMMENT=11;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=10;

        public InternalUmpleParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g"; }



     	private UmpleGrammarAccess grammarAccess;
     	
        public InternalUmpleParser(TokenStream input, IAstFactory factory, UmpleGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("cruise/umple/parser/antlr/internal/InternalUmple.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "UmpleModel";	
       	}
       	
       	@Override
       	protected UmpleGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleUmpleModel
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:78:1: entryRuleUmpleModel returns [EObject current=null] : iv_ruleUmpleModel= ruleUmpleModel EOF ;
    public final EObject entryRuleUmpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleModel = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:79:2: (iv_ruleUmpleModel= ruleUmpleModel EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:80:2: iv_ruleUmpleModel= ruleUmpleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleModel_in_entryRuleUmpleModel75);
            iv_ruleUmpleModel=ruleUmpleModel();
            _fsp--;

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
    // $ANTLR end entryRuleUmpleModel


    // $ANTLR start ruleUmpleModel
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:87:1: ruleUmpleModel returns [EObject current=null] : ( ( (lv_namespace_0_0= ruleNamespace ) )? ( (lv_glossary_1_0= ruleGlossary ) )? ( (lv_generate__2_0= ruleGenerate ) )? ( (lv_traceMechanism_3_0= ruleTraceMechanism ) )? ( ( (lv_uses_4_0= ruleUseStatement ) ) | ( (lv_umpleElements_5_0= ruleUmpleElement ) ) | ( (lv_associations_6_0= ruleUmpleAssociation ) ) | ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) ) | ( (lv_statemachines_8_0= ruleStateMachineDefinition ) ) )* ) ;
    public final EObject ruleUmpleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_namespace_0_0 = null;

        EObject lv_glossary_1_0 = null;

        EObject lv_generate__2_0 = null;

        EObject lv_traceMechanism_3_0 = null;

        AntlrDatatypeRuleToken lv_uses_4_0 = null;

        EObject lv_umpleElements_5_0 = null;

        EObject lv_associations_6_0 = null;

        EObject lv_associationClasses_7_0 = null;

        EObject lv_statemachines_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:92:6: ( ( ( (lv_namespace_0_0= ruleNamespace ) )? ( (lv_glossary_1_0= ruleGlossary ) )? ( (lv_generate__2_0= ruleGenerate ) )? ( (lv_traceMechanism_3_0= ruleTraceMechanism ) )? ( ( (lv_uses_4_0= ruleUseStatement ) ) | ( (lv_umpleElements_5_0= ruleUmpleElement ) ) | ( (lv_associations_6_0= ruleUmpleAssociation ) ) | ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) ) | ( (lv_statemachines_8_0= ruleStateMachineDefinition ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:93:1: ( ( (lv_namespace_0_0= ruleNamespace ) )? ( (lv_glossary_1_0= ruleGlossary ) )? ( (lv_generate__2_0= ruleGenerate ) )? ( (lv_traceMechanism_3_0= ruleTraceMechanism ) )? ( ( (lv_uses_4_0= ruleUseStatement ) ) | ( (lv_umpleElements_5_0= ruleUmpleElement ) ) | ( (lv_associations_6_0= ruleUmpleAssociation ) ) | ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) ) | ( (lv_statemachines_8_0= ruleStateMachineDefinition ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:93:1: ( ( (lv_namespace_0_0= ruleNamespace ) )? ( (lv_glossary_1_0= ruleGlossary ) )? ( (lv_generate__2_0= ruleGenerate ) )? ( (lv_traceMechanism_3_0= ruleTraceMechanism ) )? ( ( (lv_uses_4_0= ruleUseStatement ) ) | ( (lv_umpleElements_5_0= ruleUmpleElement ) ) | ( (lv_associations_6_0= ruleUmpleAssociation ) ) | ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) ) | ( (lv_statemachines_8_0= ruleStateMachineDefinition ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:93:2: ( (lv_namespace_0_0= ruleNamespace ) )? ( (lv_glossary_1_0= ruleGlossary ) )? ( (lv_generate__2_0= ruleGenerate ) )? ( (lv_traceMechanism_3_0= ruleTraceMechanism ) )? ( ( (lv_uses_4_0= ruleUseStatement ) ) | ( (lv_umpleElements_5_0= ruleUmpleElement ) ) | ( (lv_associations_6_0= ruleUmpleAssociation ) ) | ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) ) | ( (lv_statemachines_8_0= ruleStateMachineDefinition ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:93:2: ( (lv_namespace_0_0= ruleNamespace ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==24) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:94:1: (lv_namespace_0_0= ruleNamespace )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:94:1: (lv_namespace_0_0= ruleNamespace )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:95:3: lv_namespace_0_0= ruleNamespace
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getNamespaceNamespaceParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNamespace_in_ruleUmpleModel131);
                    lv_namespace_0_0=ruleNamespace();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"namespace",
                    	        		lv_namespace_0_0, 
                    	        		"Namespace", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:117:3: ( (lv_glossary_1_0= ruleGlossary ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:118:1: (lv_glossary_1_0= ruleGlossary )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:118:1: (lv_glossary_1_0= ruleGlossary )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:119:3: lv_glossary_1_0= ruleGlossary
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getGlossaryGlossaryParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGlossary_in_ruleUmpleModel153);
                    lv_glossary_1_0=ruleGlossary();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"glossary",
                    	        		lv_glossary_1_0, 
                    	        		"Glossary", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:141:3: ( (lv_generate__2_0= ruleGenerate ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:142:1: (lv_generate__2_0= ruleGenerate )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:142:1: (lv_generate__2_0= ruleGenerate )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:143:3: lv_generate__2_0= ruleGenerate
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getGenerate_GenerateParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGenerate_in_ruleUmpleModel175);
                    lv_generate__2_0=ruleGenerate();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"generate_",
                    	        		lv_generate__2_0, 
                    	        		"Generate", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:165:3: ( (lv_traceMechanism_3_0= ruleTraceMechanism ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==92) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:166:1: (lv_traceMechanism_3_0= ruleTraceMechanism )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:166:1: (lv_traceMechanism_3_0= ruleTraceMechanism )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:167:3: lv_traceMechanism_3_0= ruleTraceMechanism
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getTraceMechanismTraceMechanismParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTraceMechanism_in_ruleUmpleModel197);
                    lv_traceMechanism_3_0=ruleTraceMechanism();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"traceMechanism",
                    	        		lv_traceMechanism_3_0, 
                    	        		"TraceMechanism", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:189:3: ( ( (lv_uses_4_0= ruleUseStatement ) ) | ( (lv_umpleElements_5_0= ruleUmpleElement ) ) | ( (lv_associations_6_0= ruleUmpleAssociation ) ) | ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) ) | ( (lv_statemachines_8_0= ruleStateMachineDefinition ) ) )*
            loop5:
            do {
                int alt5=6;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    alt5=1;
                    }
                    break;
                case RULE_STRING:
                case 25:
                case 26:
                case 37:
                    {
                    alt5=2;
                    }
                    break;
                case 38:
                    {
                    alt5=3;
                    }
                    break;
                case 39:
                    {
                    alt5=4;
                    }
                    break;
                case 65:
                    {
                    alt5=5;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:189:4: ( (lv_uses_4_0= ruleUseStatement ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:189:4: ( (lv_uses_4_0= ruleUseStatement ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:190:1: (lv_uses_4_0= ruleUseStatement )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:190:1: (lv_uses_4_0= ruleUseStatement )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:191:3: lv_uses_4_0= ruleUseStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getUsesUseStatementParserRuleCall_4_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUseStatement_in_ruleUmpleModel220);
            	    lv_uses_4_0=ruleUseStatement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"uses",
            	    	        		lv_uses_4_0, 
            	    	        		"UseStatement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:214:6: ( (lv_umpleElements_5_0= ruleUmpleElement ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:214:6: ( (lv_umpleElements_5_0= ruleUmpleElement ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:215:1: (lv_umpleElements_5_0= ruleUmpleElement )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:215:1: (lv_umpleElements_5_0= ruleUmpleElement )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:216:3: lv_umpleElements_5_0= ruleUmpleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getUmpleElementsUmpleElementParserRuleCall_4_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUmpleElement_in_ruleUmpleModel247);
            	    lv_umpleElements_5_0=ruleUmpleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"umpleElements",
            	    	        		lv_umpleElements_5_0, 
            	    	        		"UmpleElement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:239:6: ( (lv_associations_6_0= ruleUmpleAssociation ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:239:6: ( (lv_associations_6_0= ruleUmpleAssociation ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:240:1: (lv_associations_6_0= ruleUmpleAssociation )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:240:1: (lv_associations_6_0= ruleUmpleAssociation )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:241:3: lv_associations_6_0= ruleUmpleAssociation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getAssociationsUmpleAssociationParserRuleCall_4_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUmpleAssociation_in_ruleUmpleModel274);
            	    lv_associations_6_0=ruleUmpleAssociation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"associations",
            	    	        		lv_associations_6_0, 
            	    	        		"UmpleAssociation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:264:6: ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:264:6: ( (lv_associationClasses_7_0= ruleUmpleAssociationClass ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:265:1: (lv_associationClasses_7_0= ruleUmpleAssociationClass )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:265:1: (lv_associationClasses_7_0= ruleUmpleAssociationClass )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:266:3: lv_associationClasses_7_0= ruleUmpleAssociationClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getAssociationClassesUmpleAssociationClassParserRuleCall_4_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUmpleAssociationClass_in_ruleUmpleModel301);
            	    lv_associationClasses_7_0=ruleUmpleAssociationClass();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"associationClasses",
            	    	        		lv_associationClasses_7_0, 
            	    	        		"UmpleAssociationClass", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:289:6: ( (lv_statemachines_8_0= ruleStateMachineDefinition ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:289:6: ( (lv_statemachines_8_0= ruleStateMachineDefinition ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:290:1: (lv_statemachines_8_0= ruleStateMachineDefinition )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:290:1: (lv_statemachines_8_0= ruleStateMachineDefinition )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:291:3: lv_statemachines_8_0= ruleStateMachineDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleModelAccess().getStatemachinesStateMachineDefinitionParserRuleCall_4_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStateMachineDefinition_in_ruleUmpleModel328);
            	    lv_statemachines_8_0=ruleStateMachineDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"statemachines",
            	    	        		lv_statemachines_8_0, 
            	    	        		"StateMachineDefinition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleModel


    // $ANTLR start entryRuleUmpleElement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:321:1: entryRuleUmpleElement returns [EObject current=null] : iv_ruleUmpleElement= ruleUmpleElement EOF ;
    public final EObject entryRuleUmpleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleElement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:322:2: (iv_ruleUmpleElement= ruleUmpleElement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:323:2: iv_ruleUmpleElement= ruleUmpleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleElement_in_entryRuleUmpleElement366);
            iv_ruleUmpleElement=ruleUmpleElement();
            _fsp--;

             current =iv_ruleUmpleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleElement376); 

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
    // $ANTLR end entryRuleUmpleElement


    // $ANTLR start ruleUmpleElement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:330:1: ruleUmpleElement returns [EObject current=null] : (this_UmpleClass_0= ruleUmpleClass | this_UmpleInterface_1= ruleUmpleInterface ) ;
    public final EObject ruleUmpleElement() throws RecognitionException {
        EObject current = null;

        EObject this_UmpleClass_0 = null;

        EObject this_UmpleInterface_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:335:6: ( (this_UmpleClass_0= ruleUmpleClass | this_UmpleInterface_1= ruleUmpleInterface ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:336:1: (this_UmpleClass_0= ruleUmpleClass | this_UmpleInterface_1= ruleUmpleInterface )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:336:1: (this_UmpleClass_0= ruleUmpleClass | this_UmpleInterface_1= ruleUmpleInterface )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING||(LA6_0>=25 && LA6_0<=26)) ) {
                alt6=1;
            }
            else if ( (LA6_0==37) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("336:1: (this_UmpleClass_0= ruleUmpleClass | this_UmpleInterface_1= ruleUmpleInterface )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:337:5: this_UmpleClass_0= ruleUmpleClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUmpleElementAccess().getUmpleClassParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUmpleClass_in_ruleUmpleElement423);
                    this_UmpleClass_0=ruleUmpleClass();
                    _fsp--;

                     
                            current = this_UmpleClass_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:347:5: this_UmpleInterface_1= ruleUmpleInterface
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUmpleElementAccess().getUmpleInterfaceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUmpleInterface_in_ruleUmpleElement450);
                    this_UmpleInterface_1=ruleUmpleInterface();
                    _fsp--;

                     
                            current = this_UmpleInterface_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleElement


    // $ANTLR start entryRuleWord
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:363:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:364:2: (iv_ruleWord= ruleWord EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:365:2: iv_ruleWord= ruleWord EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWordRule(), currentNode); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord485);
            iv_ruleWord=ruleWord();
            _fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord495); 

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
    // $ANTLR end entryRuleWord


    // $ANTLR start ruleWord
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:372:1: ruleWord returns [EObject current=null] : ( ( (lv_singular_0_0= RULE_STRING ) ) ':' ( (lv_plural_2_0= RULE_STRING ) ) ';' ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_singular_0_0=null;
        Token lv_plural_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:377:6: ( ( ( (lv_singular_0_0= RULE_STRING ) ) ':' ( (lv_plural_2_0= RULE_STRING ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:378:1: ( ( (lv_singular_0_0= RULE_STRING ) ) ':' ( (lv_plural_2_0= RULE_STRING ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:378:1: ( ( (lv_singular_0_0= RULE_STRING ) ) ':' ( (lv_plural_2_0= RULE_STRING ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:378:2: ( (lv_singular_0_0= RULE_STRING ) ) ':' ( (lv_plural_2_0= RULE_STRING ) ) ';'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:378:2: ( (lv_singular_0_0= RULE_STRING ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:379:1: (lv_singular_0_0= RULE_STRING )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:379:1: (lv_singular_0_0= RULE_STRING )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:380:3: lv_singular_0_0= RULE_STRING
            {
            lv_singular_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWord537); 

            			createLeafNode(grammarAccess.getWordAccess().getSingularSTRINGTerminalRuleCall_0_0(), "singular"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWordRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"singular",
            	        		lv_singular_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleWord552); 

                    createLeafNode(grammarAccess.getWordAccess().getColonKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:406:1: ( (lv_plural_2_0= RULE_STRING ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:407:1: (lv_plural_2_0= RULE_STRING )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:407:1: (lv_plural_2_0= RULE_STRING )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:408:3: lv_plural_2_0= RULE_STRING
            {
            lv_plural_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWord569); 

            			createLeafNode(grammarAccess.getWordAccess().getPluralSTRINGTerminalRuleCall_2_0(), "plural"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWordRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"plural",
            	        		lv_plural_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleWord584); 

                    createLeafNode(grammarAccess.getWordAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleWord


    // $ANTLR start entryRuleGlossary
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:442:1: entryRuleGlossary returns [EObject current=null] : iv_ruleGlossary= ruleGlossary EOF ;
    public final EObject entryRuleGlossary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlossary = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:443:2: (iv_ruleGlossary= ruleGlossary EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:444:2: iv_ruleGlossary= ruleGlossary EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGlossaryRule(), currentNode); 
            pushFollow(FOLLOW_ruleGlossary_in_entryRuleGlossary620);
            iv_ruleGlossary=ruleGlossary();
            _fsp--;

             current =iv_ruleGlossary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGlossary630); 

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
    // $ANTLR end entryRuleGlossary


    // $ANTLR start ruleGlossary
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:451:1: ruleGlossary returns [EObject current=null] : ( () 'glossary' '{' ( (lv_words_3_0= ruleWord ) )* '}' ) ;
    public final EObject ruleGlossary() throws RecognitionException {
        EObject current = null;

        EObject lv_words_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:456:6: ( ( () 'glossary' '{' ( (lv_words_3_0= ruleWord ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:457:1: ( () 'glossary' '{' ( (lv_words_3_0= ruleWord ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:457:1: ( () 'glossary' '{' ( (lv_words_3_0= ruleWord ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:457:2: () 'glossary' '{' ( (lv_words_3_0= ruleWord ) )* '}'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:457:2: ()
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:458:5: 
            {
             
                    temp=factory.create(grammarAccess.getGlossaryAccess().getGlossaryAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getGlossaryAccess().getGlossaryAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,16,FOLLOW_16_in_ruleGlossary674); 

                    createLeafNode(grammarAccess.getGlossaryAccess().getGlossaryKeyword_1(), null); 
                
            match(input,17,FOLLOW_17_in_ruleGlossary684); 

                    createLeafNode(grammarAccess.getGlossaryAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:476:1: ( (lv_words_3_0= ruleWord ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_STRING) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:477:1: (lv_words_3_0= ruleWord )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:477:1: (lv_words_3_0= ruleWord )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:478:3: lv_words_3_0= ruleWord
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGlossaryAccess().getWordsWordParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleWord_in_ruleGlossary705);
            	    lv_words_3_0=ruleWord();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGlossaryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"words",
            	    	        		lv_words_3_0, 
            	    	        		"Word", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleGlossary716); 

                    createLeafNode(grammarAccess.getGlossaryAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGlossary


    // $ANTLR start entryRuleGenerate
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:512:1: entryRuleGenerate returns [EObject current=null] : iv_ruleGenerate= ruleGenerate EOF ;
    public final EObject entryRuleGenerate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerate = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:513:2: (iv_ruleGenerate= ruleGenerate EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:514:2: iv_ruleGenerate= ruleGenerate EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGenerateRule(), currentNode); 
            pushFollow(FOLLOW_ruleGenerate_in_entryRuleGenerate752);
            iv_ruleGenerate=ruleGenerate();
            _fsp--;

             current =iv_ruleGenerate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGenerate762); 

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
    // $ANTLR end entryRuleGenerate


    // $ANTLR start ruleGenerate
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:521:1: ruleGenerate returns [EObject current=null] : ( 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) ';' ) ;
    public final EObject ruleGenerate() throws RecognitionException {
        EObject current = null;

        Token lv_java_1_0=null;
        Token lv_Php_2_0=null;
        Token lv_Ruby_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:526:6: ( ( 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:527:1: ( 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:527:1: ( 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:527:3: 'generate' ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) ) ';'
            {
            match(input,19,FOLLOW_19_in_ruleGenerate797); 

                    createLeafNode(grammarAccess.getGenerateAccess().getGenerateKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:531:1: ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt8=1;
                }
                break;
            case 21:
                {
                alt8=2;
                }
                break;
            case 22:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("531:1: ( ( (lv_java_1_0= 'Java' ) ) | ( (lv_Php_2_0= 'Php' ) ) | ( (lv_Ruby_3_0= 'Ruby' ) ) )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:531:2: ( (lv_java_1_0= 'Java' ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:531:2: ( (lv_java_1_0= 'Java' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:532:1: (lv_java_1_0= 'Java' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:532:1: (lv_java_1_0= 'Java' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:533:3: lv_java_1_0= 'Java'
                    {
                    lv_java_1_0=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleGenerate816); 

                            createLeafNode(grammarAccess.getGenerateAccess().getJavaJavaKeyword_1_0_0(), "java"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGenerateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "java", true, "Java", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:553:6: ( (lv_Php_2_0= 'Php' ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:553:6: ( (lv_Php_2_0= 'Php' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:554:1: (lv_Php_2_0= 'Php' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:554:1: (lv_Php_2_0= 'Php' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:555:3: lv_Php_2_0= 'Php'
                    {
                    lv_Php_2_0=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleGenerate853); 

                            createLeafNode(grammarAccess.getGenerateAccess().getPhpPhpKeyword_1_1_0(), "Php"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGenerateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "Php", true, "Php", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:575:6: ( (lv_Ruby_3_0= 'Ruby' ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:575:6: ( (lv_Ruby_3_0= 'Ruby' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:576:1: (lv_Ruby_3_0= 'Ruby' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:576:1: (lv_Ruby_3_0= 'Ruby' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:577:3: lv_Ruby_3_0= 'Ruby'
                    {
                    lv_Ruby_3_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleGenerate890); 

                            createLeafNode(grammarAccess.getGenerateAccess().getRubyRubyKeyword_1_2_0(), "Ruby"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGenerateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "Ruby", lv_Ruby_3_0, "Ruby", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleGenerate914); 

                    createLeafNode(grammarAccess.getGenerateAccess().getSemicolonKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGenerate


    // $ANTLR start entryRuleUseStatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:608:1: entryRuleUseStatement returns [String current=null] : iv_ruleUseStatement= ruleUseStatement EOF ;
    public final String entryRuleUseStatement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUseStatement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:609:2: (iv_ruleUseStatement= ruleUseStatement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:610:2: iv_ruleUseStatement= ruleUseStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUseStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleUseStatement_in_entryRuleUseStatement951);
            iv_ruleUseStatement=ruleUseStatement();
            _fsp--;

             current =iv_ruleUseStatement.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUseStatement962); 

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
    // $ANTLR end entryRuleUseStatement


    // $ANTLR start ruleUseStatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:617:1: ruleUseStatement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'use' this_fileID_1= rulefileID kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleUseStatement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_fileID_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:622:6: ( (kw= 'use' this_fileID_1= rulefileID kw= ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:623:1: (kw= 'use' this_fileID_1= rulefileID kw= ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:623:1: (kw= 'use' this_fileID_1= rulefileID kw= ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:624:2: kw= 'use' this_fileID_1= rulefileID kw= ';'
            {
            kw=(Token)input.LT(1);
            match(input,23,FOLLOW_23_in_ruleUseStatement1000); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getUseStatementAccess().getUseKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getUseStatementAccess().getFileIDParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_rulefileID_in_ruleUseStatement1022);
            this_fileID_1=rulefileID();
            _fsp--;


            		current.merge(this_fileID_1);
                
             
                    currentNode = currentNode.getParent();
                
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleUseStatement1040); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getUseStatementAccess().getSemicolonKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUseStatement


    // $ANTLR start entryRuleNamespace
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:654:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:655:2: (iv_ruleNamespace= ruleNamespace EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:656:2: iv_ruleNamespace= ruleNamespace EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamespaceRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace1080);
            iv_ruleNamespace=ruleNamespace();
            _fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace1090); 

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
    // $ANTLR end entryRuleNamespace


    // $ANTLR start ruleNamespace
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:663:1: ruleNamespace returns [EObject current=null] : ( 'namespace' ( (lv_value_1_0= rulefileID ) ) ';' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:668:6: ( ( 'namespace' ( (lv_value_1_0= rulefileID ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:669:1: ( 'namespace' ( (lv_value_1_0= rulefileID ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:669:1: ( 'namespace' ( (lv_value_1_0= rulefileID ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:669:3: 'namespace' ( (lv_value_1_0= rulefileID ) ) ';'
            {
            match(input,24,FOLLOW_24_in_ruleNamespace1125); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getNamespaceKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:673:1: ( (lv_value_1_0= rulefileID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:674:1: (lv_value_1_0= rulefileID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:674:1: (lv_value_1_0= rulefileID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:675:3: lv_value_1_0= rulefileID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getValueFileIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulefileID_in_ruleNamespace1146);
            lv_value_1_0=rulefileID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"fileID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleNamespace1156); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getSemicolonKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamespace


    // $ANTLR start entryRuleUmpleClass
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:709:1: entryRuleUmpleClass returns [EObject current=null] : iv_ruleUmpleClass= ruleUmpleClass EOF ;
    public final EObject entryRuleUmpleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleClass = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:710:2: (iv_ruleUmpleClass= ruleUmpleClass EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:711:2: iv_ruleUmpleClass= ruleUmpleClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleClass_in_entryRuleUmpleClass1192);
            iv_ruleUmpleClass=ruleUmpleClass();
            _fsp--;

             current =iv_ruleUmpleClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleClass1202); 

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
    // $ANTLR end entryRuleUmpleClass


    // $ANTLR start ruleUmpleClass
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:718:1: ruleUmpleClass returns [EObject current=null] : ( () ( (lv_packageName_1_0= RULE_STRING ) )? ( (lv_external_2_0= 'external' ) )? 'class' ( (lv_name_4_0= RULE_ID ) ) '{' ( (lv_singleton_6_0= ruleSingleton ) )? ( (lv_key_7_0= ruleKey ) )? ( (lv_codeInjection_8_0= ruleCodeInjection ) )? ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_attributes_14_0= ruleUmpleAttribute ) ) | ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) ) | ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) ) | ( (lv_depends_17_0= ruleDepend ) ) | ( (lv_positions_18_0= rulePosition ) ) | ( (lv_stateMachines_19_0= ruleStateMachine ) ) | ( (lv_traceDirectives_20_0= ruleTraceDirective ) ) | ( (lv_traceCases_21_0= ruleTraceCase ) ) )* ( (lv_externalLanguage_22_0= ruleExternalLanguage ) )? '}' ) ;
    public final EObject ruleUmpleClass() throws RecognitionException {
        EObject current = null;

        Token lv_packageName_1_0=null;
        Token lv_external_2_0=null;
        Token lv_name_4_0=null;
        EObject lv_singleton_6_0 = null;

        EObject lv_key_7_0 = null;

        EObject lv_codeInjection_8_0 = null;

        EObject lv_attributes_14_0 = null;

        EObject lv_symmetricReflexiveAssociations_15_0 = null;

        EObject lv_inlineAssociations_16_0 = null;

        EObject lv_depends_17_0 = null;

        EObject lv_positions_18_0 = null;

        EObject lv_stateMachines_19_0 = null;

        EObject lv_traceDirectives_20_0 = null;

        EObject lv_traceCases_21_0 = null;

        EObject lv_externalLanguage_22_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:723:6: ( ( () ( (lv_packageName_1_0= RULE_STRING ) )? ( (lv_external_2_0= 'external' ) )? 'class' ( (lv_name_4_0= RULE_ID ) ) '{' ( (lv_singleton_6_0= ruleSingleton ) )? ( (lv_key_7_0= ruleKey ) )? ( (lv_codeInjection_8_0= ruleCodeInjection ) )? ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_attributes_14_0= ruleUmpleAttribute ) ) | ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) ) | ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) ) | ( (lv_depends_17_0= ruleDepend ) ) | ( (lv_positions_18_0= rulePosition ) ) | ( (lv_stateMachines_19_0= ruleStateMachine ) ) | ( (lv_traceDirectives_20_0= ruleTraceDirective ) ) | ( (lv_traceCases_21_0= ruleTraceCase ) ) )* ( (lv_externalLanguage_22_0= ruleExternalLanguage ) )? '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:724:1: ( () ( (lv_packageName_1_0= RULE_STRING ) )? ( (lv_external_2_0= 'external' ) )? 'class' ( (lv_name_4_0= RULE_ID ) ) '{' ( (lv_singleton_6_0= ruleSingleton ) )? ( (lv_key_7_0= ruleKey ) )? ( (lv_codeInjection_8_0= ruleCodeInjection ) )? ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_attributes_14_0= ruleUmpleAttribute ) ) | ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) ) | ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) ) | ( (lv_depends_17_0= ruleDepend ) ) | ( (lv_positions_18_0= rulePosition ) ) | ( (lv_stateMachines_19_0= ruleStateMachine ) ) | ( (lv_traceDirectives_20_0= ruleTraceDirective ) ) | ( (lv_traceCases_21_0= ruleTraceCase ) ) )* ( (lv_externalLanguage_22_0= ruleExternalLanguage ) )? '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:724:1: ( () ( (lv_packageName_1_0= RULE_STRING ) )? ( (lv_external_2_0= 'external' ) )? 'class' ( (lv_name_4_0= RULE_ID ) ) '{' ( (lv_singleton_6_0= ruleSingleton ) )? ( (lv_key_7_0= ruleKey ) )? ( (lv_codeInjection_8_0= ruleCodeInjection ) )? ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_attributes_14_0= ruleUmpleAttribute ) ) | ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) ) | ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) ) | ( (lv_depends_17_0= ruleDepend ) ) | ( (lv_positions_18_0= rulePosition ) ) | ( (lv_stateMachines_19_0= ruleStateMachine ) ) | ( (lv_traceDirectives_20_0= ruleTraceDirective ) ) | ( (lv_traceCases_21_0= ruleTraceCase ) ) )* ( (lv_externalLanguage_22_0= ruleExternalLanguage ) )? '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:724:2: () ( (lv_packageName_1_0= RULE_STRING ) )? ( (lv_external_2_0= 'external' ) )? 'class' ( (lv_name_4_0= RULE_ID ) ) '{' ( (lv_singleton_6_0= ruleSingleton ) )? ( (lv_key_7_0= ruleKey ) )? ( (lv_codeInjection_8_0= ruleCodeInjection ) )? ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_attributes_14_0= ruleUmpleAttribute ) ) | ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) ) | ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) ) | ( (lv_depends_17_0= ruleDepend ) ) | ( (lv_positions_18_0= rulePosition ) ) | ( (lv_stateMachines_19_0= ruleStateMachine ) ) | ( (lv_traceDirectives_20_0= ruleTraceDirective ) ) | ( (lv_traceCases_21_0= ruleTraceCase ) ) )* ( (lv_externalLanguage_22_0= ruleExternalLanguage ) )? '}'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:724:2: ()
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:725:5: 
            {
             
                    temp=factory.create(grammarAccess.getUmpleClassAccess().getUmpleClassAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUmpleClassAccess().getUmpleClassAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:735:2: ( (lv_packageName_1_0= RULE_STRING ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:736:1: (lv_packageName_1_0= RULE_STRING )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:736:1: (lv_packageName_1_0= RULE_STRING )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:737:3: lv_packageName_1_0= RULE_STRING
                    {
                    lv_packageName_1_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUmpleClass1253); 

                    			createLeafNode(grammarAccess.getUmpleClassAccess().getPackageNameSTRINGTerminalRuleCall_1_0(), "packageName"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"packageName",
                    	        		lv_packageName_1_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:759:3: ( (lv_external_2_0= 'external' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:760:1: (lv_external_2_0= 'external' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:760:1: (lv_external_2_0= 'external' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:761:3: lv_external_2_0= 'external'
                    {
                    lv_external_2_0=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_ruleUmpleClass1277); 

                            createLeafNode(grammarAccess.getUmpleClassAccess().getExternalExternalKeyword_2_0(), "external"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "external", true, "external", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_ruleUmpleClass1301); 

                    createLeafNode(grammarAccess.getUmpleClassAccess().getClassKeyword_3(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:784:1: ( (lv_name_4_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:785:1: (lv_name_4_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:785:1: (lv_name_4_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:786:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleClass1318); 

            			createLeafNode(grammarAccess.getUmpleClassAccess().getNameIDTerminalRuleCall_4_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_4_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleUmpleClass1333); 

                    createLeafNode(grammarAccess.getUmpleClassAccess().getLeftCurlyBracketKeyword_5(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:812:1: ( (lv_singleton_6_0= ruleSingleton ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==47) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:813:1: (lv_singleton_6_0= ruleSingleton )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:813:1: (lv_singleton_6_0= ruleSingleton )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:814:3: lv_singleton_6_0= ruleSingleton
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getSingletonSingletonParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSingleton_in_ruleUmpleClass1354);
                    lv_singleton_6_0=ruleSingleton();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"singleton",
                    	        		true, 
                    	        		"Singleton", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:836:3: ( (lv_key_7_0= ruleKey ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==62) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:837:1: (lv_key_7_0= ruleKey )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:837:1: (lv_key_7_0= ruleKey )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:838:3: lv_key_7_0= ruleKey
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getKeyKeyParserRuleCall_7_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKey_in_ruleUmpleClass1376);
                    lv_key_7_0=ruleKey();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"key",
                    	        		lv_key_7_0, 
                    	        		"Key", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:860:3: ( (lv_codeInjection_8_0= ruleCodeInjection ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=48 && LA13_0<=49)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:861:1: (lv_codeInjection_8_0= ruleCodeInjection )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:861:1: (lv_codeInjection_8_0= ruleCodeInjection )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:862:3: lv_codeInjection_8_0= ruleCodeInjection
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getCodeInjectionCodeInjectionParserRuleCall_8_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCodeInjection_in_ruleUmpleClass1398);
                    lv_codeInjection_8_0=ruleCodeInjection();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"codeInjection",
                    	        		lv_codeInjection_8_0, 
                    	        		"CodeInjection", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:884:3: ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:884:5: 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';'
                    {
                    match(input,27,FOLLOW_27_in_ruleUmpleClass1410); 

                            createLeafNode(grammarAccess.getUmpleClassAccess().getIsAKeyword_9_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:888:1: ( ( RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:889:1: ( RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:889:1: ( RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:890:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleClass1428); 

                    		createLeafNode(grammarAccess.getUmpleClassAccess().getExtendsClassUmpleElementCrossReference_9_1_0(), "extendsClass"); 
                    	

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:902:2: ( ',' ( ( RULE_ID ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==28) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:902:4: ',' ( ( RULE_ID ) )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleUmpleClass1439); 

                    	            createLeafNode(grammarAccess.getUmpleClassAccess().getCommaKeyword_9_2_0(), null); 
                    	        
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:906:1: ( ( RULE_ID ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:907:1: ( RULE_ID )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:907:1: ( RULE_ID )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:908:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleClass1457); 

                    	    		createLeafNode(grammarAccess.getUmpleClassAccess().getExtendsClassUmpleElementCrossReference_9_2_1_0(), "extendsClass"); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match(input,15,FOLLOW_15_in_ruleUmpleClass1469); 

                            createLeafNode(grammarAccess.getUmpleClassAccess().getSemicolonKeyword_9_3(), null); 
                        

                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:924:3: ( ( (lv_attributes_14_0= ruleUmpleAttribute ) ) | ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) ) | ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) ) | ( (lv_depends_17_0= ruleDepend ) ) | ( (lv_positions_18_0= rulePosition ) ) | ( (lv_stateMachines_19_0= ruleStateMachine ) ) | ( (lv_traceDirectives_20_0= ruleTraceDirective ) ) | ( (lv_traceCases_21_0= ruleTraceCase ) ) )*
            loop16:
            do {
                int alt16=9;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:924:4: ( (lv_attributes_14_0= ruleUmpleAttribute ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:924:4: ( (lv_attributes_14_0= ruleUmpleAttribute ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:925:1: (lv_attributes_14_0= ruleUmpleAttribute )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:925:1: (lv_attributes_14_0= ruleUmpleAttribute )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:926:3: lv_attributes_14_0= ruleUmpleAttribute
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getAttributesUmpleAttributeParserRuleCall_10_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUmpleAttribute_in_ruleUmpleClass1493);
            	    lv_attributes_14_0=ruleUmpleAttribute();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"attributes",
            	    	        		lv_attributes_14_0, 
            	    	        		"UmpleAttribute", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:949:6: ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:949:6: ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:950:1: (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:950:1: (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:951:3: lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getSymmetricReflexiveAssociationsSymmetricReflexiveAssociationParserRuleCall_10_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleUmpleClass1520);
            	    lv_symmetricReflexiveAssociations_15_0=ruleSymmetricReflexiveAssociation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"symmetricReflexiveAssociations",
            	    	        		lv_symmetricReflexiveAssociations_15_0, 
            	    	        		"SymmetricReflexiveAssociation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:974:6: ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:974:6: ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:975:1: (lv_inlineAssociations_16_0= ruleInlineAssociation )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:975:1: (lv_inlineAssociations_16_0= ruleInlineAssociation )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:976:3: lv_inlineAssociations_16_0= ruleInlineAssociation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getInlineAssociationsInlineAssociationParserRuleCall_10_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleInlineAssociation_in_ruleUmpleClass1547);
            	    lv_inlineAssociations_16_0=ruleInlineAssociation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"inlineAssociations",
            	    	        		lv_inlineAssociations_16_0, 
            	    	        		"InlineAssociation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:999:6: ( (lv_depends_17_0= ruleDepend ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:999:6: ( (lv_depends_17_0= ruleDepend ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1000:1: (lv_depends_17_0= ruleDepend )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1000:1: (lv_depends_17_0= ruleDepend )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1001:3: lv_depends_17_0= ruleDepend
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getDependsDependParserRuleCall_10_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDepend_in_ruleUmpleClass1574);
            	    lv_depends_17_0=ruleDepend();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"depends",
            	    	        		lv_depends_17_0, 
            	    	        		"Depend", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1024:6: ( (lv_positions_18_0= rulePosition ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1024:6: ( (lv_positions_18_0= rulePosition ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1025:1: (lv_positions_18_0= rulePosition )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1025:1: (lv_positions_18_0= rulePosition )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1026:3: lv_positions_18_0= rulePosition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getPositionsPositionParserRuleCall_10_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulePosition_in_ruleUmpleClass1601);
            	    lv_positions_18_0=rulePosition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"positions",
            	    	        		lv_positions_18_0, 
            	    	        		"Position", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1049:6: ( (lv_stateMachines_19_0= ruleStateMachine ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1049:6: ( (lv_stateMachines_19_0= ruleStateMachine ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1050:1: (lv_stateMachines_19_0= ruleStateMachine )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1050:1: (lv_stateMachines_19_0= ruleStateMachine )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1051:3: lv_stateMachines_19_0= ruleStateMachine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getStateMachinesStateMachineParserRuleCall_10_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStateMachine_in_ruleUmpleClass1628);
            	    lv_stateMachines_19_0=ruleStateMachine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"stateMachines",
            	    	        		lv_stateMachines_19_0, 
            	    	        		"StateMachine", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1074:6: ( (lv_traceDirectives_20_0= ruleTraceDirective ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1074:6: ( (lv_traceDirectives_20_0= ruleTraceDirective ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1075:1: (lv_traceDirectives_20_0= ruleTraceDirective )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1075:1: (lv_traceDirectives_20_0= ruleTraceDirective )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1076:3: lv_traceDirectives_20_0= ruleTraceDirective
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getTraceDirectivesTraceDirectiveParserRuleCall_10_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTraceDirective_in_ruleUmpleClass1655);
            	    lv_traceDirectives_20_0=ruleTraceDirective();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"traceDirectives",
            	    	        		lv_traceDirectives_20_0, 
            	    	        		"TraceDirective", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1099:6: ( (lv_traceCases_21_0= ruleTraceCase ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1099:6: ( (lv_traceCases_21_0= ruleTraceCase ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1100:1: (lv_traceCases_21_0= ruleTraceCase )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1100:1: (lv_traceCases_21_0= ruleTraceCase )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1101:3: lv_traceCases_21_0= ruleTraceCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getTraceCasesTraceCaseParserRuleCall_10_7_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTraceCase_in_ruleUmpleClass1682);
            	    lv_traceCases_21_0=ruleTraceCase();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"traceCases",
            	    	        		lv_traceCases_21_0, 
            	    	        		"TraceCase", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1123:4: ( (lv_externalLanguage_22_0= ruleExternalLanguage ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=109 && LA17_0<=112)) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_RUBY_FUNCTION||LA17_0==18) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1124:1: (lv_externalLanguage_22_0= ruleExternalLanguage )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1124:1: (lv_externalLanguage_22_0= ruleExternalLanguage )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1125:3: lv_externalLanguage_22_0= ruleExternalLanguage
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleClassAccess().getExternalLanguageExternalLanguageParserRuleCall_11_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExternalLanguage_in_ruleUmpleClass1705);
                    lv_externalLanguage_22_0=ruleExternalLanguage();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleClassRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"externalLanguage",
                    	        		lv_externalLanguage_22_0, 
                    	        		"ExternalLanguage", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleUmpleClass1716); 

                    createLeafNode(grammarAccess.getUmpleClassAccess().getRightCurlyBracketKeyword_12(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleClass


    // $ANTLR start entryRuleExternalLanguage
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1159:1: entryRuleExternalLanguage returns [EObject current=null] : iv_ruleExternalLanguage= ruleExternalLanguage EOF ;
    public final EObject entryRuleExternalLanguage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalLanguage = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1160:2: (iv_ruleExternalLanguage= ruleExternalLanguage EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1161:2: iv_ruleExternalLanguage= ruleExternalLanguage EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExternalLanguageRule(), currentNode); 
            pushFollow(FOLLOW_ruleExternalLanguage_in_entryRuleExternalLanguage1752);
            iv_ruleExternalLanguage=ruleExternalLanguage();
            _fsp--;

             current =iv_ruleExternalLanguage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalLanguage1762); 

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
    // $ANTLR end entryRuleExternalLanguage


    // $ANTLR start ruleExternalLanguage
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1168:1: ruleExternalLanguage returns [EObject current=null] : ( ( (lv_functions_0_0= rulefunctionDefinition ) )* | ( (lv_rubyFunctions_1_0= rulerubyFunction ) )* | ( (lv_phpFunctions_2_0= rulephpFunction ) )* ) ;
    public final EObject ruleExternalLanguage() throws RecognitionException {
        EObject current = null;

        EObject lv_functions_0_0 = null;

        AntlrDatatypeRuleToken lv_rubyFunctions_1_0 = null;

        EObject lv_phpFunctions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1173:6: ( ( ( (lv_functions_0_0= rulefunctionDefinition ) )* | ( (lv_rubyFunctions_1_0= rulerubyFunction ) )* | ( (lv_phpFunctions_2_0= rulephpFunction ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1174:1: ( ( (lv_functions_0_0= rulefunctionDefinition ) )* | ( (lv_rubyFunctions_1_0= rulerubyFunction ) )* | ( (lv_phpFunctions_2_0= rulephpFunction ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1174:1: ( ( (lv_functions_0_0= rulefunctionDefinition ) )* | ( (lv_rubyFunctions_1_0= rulerubyFunction ) )* | ( (lv_phpFunctions_2_0= rulephpFunction ) )* )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 109:
            case 111:
            case 112:
                {
                alt21=1;
                }
                break;
            case 110:
                {
                int LA21_2 = input.LA(2);

                if ( (LA21_2==122) ) {
                    alt21=3;
                }
                else if ( (LA21_2==RULE_ID||LA21_2==29||LA21_2==33||LA21_2==36||(LA21_2>=54 && LA21_2<=61)||LA21_2==113) ) {
                    alt21=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1174:1: ( ( (lv_functions_0_0= rulefunctionDefinition ) )* | ( (lv_rubyFunctions_1_0= rulerubyFunction ) )* | ( (lv_phpFunctions_2_0= rulephpFunction ) )* )", 21, 2, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                alt21=1;
                }
                break;
            case EOF:
                {
                alt21=1;
                }
                break;
            case RULE_RUBY_FUNCTION:
                {
                alt21=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1174:1: ( ( (lv_functions_0_0= rulefunctionDefinition ) )* | ( (lv_rubyFunctions_1_0= rulerubyFunction ) )* | ( (lv_phpFunctions_2_0= rulephpFunction ) )* )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1174:2: ( (lv_functions_0_0= rulefunctionDefinition ) )*
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1174:2: ( (lv_functions_0_0= rulefunctionDefinition ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=109 && LA18_0<=112)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1175:1: (lv_functions_0_0= rulefunctionDefinition )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1175:1: (lv_functions_0_0= rulefunctionDefinition )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1176:3: lv_functions_0_0= rulefunctionDefinition
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getExternalLanguageAccess().getFunctionsFunctionDefinitionParserRuleCall_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulefunctionDefinition_in_ruleExternalLanguage1808);
                    	    lv_functions_0_0=rulefunctionDefinition();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getExternalLanguageRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"functions",
                    	    	        		lv_functions_0_0, 
                    	    	        		"functionDefinition", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1199:6: ( (lv_rubyFunctions_1_0= rulerubyFunction ) )*
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1199:6: ( (lv_rubyFunctions_1_0= rulerubyFunction ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_RUBY_FUNCTION) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1200:1: (lv_rubyFunctions_1_0= rulerubyFunction )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1200:1: (lv_rubyFunctions_1_0= rulerubyFunction )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1201:3: lv_rubyFunctions_1_0= rulerubyFunction
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getExternalLanguageAccess().getRubyFunctionsRubyFunctionParserRuleCall_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulerubyFunction_in_ruleExternalLanguage1836);
                    	    lv_rubyFunctions_1_0=rulerubyFunction();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getExternalLanguageRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rubyFunctions",
                    	    	        		lv_rubyFunctions_1_0, 
                    	    	        		"rubyFunction", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1224:6: ( (lv_phpFunctions_2_0= rulephpFunction ) )*
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1224:6: ( (lv_phpFunctions_2_0= rulephpFunction ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==110) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1225:1: (lv_phpFunctions_2_0= rulephpFunction )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1225:1: (lv_phpFunctions_2_0= rulephpFunction )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1226:3: lv_phpFunctions_2_0= rulephpFunction
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getExternalLanguageAccess().getPhpFunctionsPhpFunctionParserRuleCall_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulephpFunction_in_ruleExternalLanguage1864);
                    	    lv_phpFunctions_2_0=rulephpFunction();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getExternalLanguageRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"phpFunctions",
                    	    	        		lv_phpFunctions_2_0, 
                    	    	        		"phpFunction", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExternalLanguage


    // $ANTLR start entryRulePrimitiveType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1256:1: entryRulePrimitiveType returns [String current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final String entryRulePrimitiveType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveType = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1257:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1258:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1902);
            iv_rulePrimitiveType=rulePrimitiveType();
            _fsp--;

             current =iv_rulePrimitiveType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveType1913); 

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
    // $ANTLR end entryRulePrimitiveType


    // $ANTLR start rulePrimitiveType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1265:1: rulePrimitiveType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'boolean' | kw= 'char' | kw= 'byte' | kw= 'short' | kw= 'int' | kw= 'long' | kw= 'float' | kw= 'double' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1270:6: ( (kw= 'boolean' | kw= 'char' | kw= 'byte' | kw= 'short' | kw= 'int' | kw= 'long' | kw= 'float' | kw= 'double' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1271:1: (kw= 'boolean' | kw= 'char' | kw= 'byte' | kw= 'short' | kw= 'int' | kw= 'long' | kw= 'float' | kw= 'double' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1271:1: (kw= 'boolean' | kw= 'char' | kw= 'byte' | kw= 'short' | kw= 'int' | kw= 'long' | kw= 'float' | kw= 'double' )
            int alt22=8;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt22=1;
                }
                break;
            case 30:
                {
                alt22=2;
                }
                break;
            case 31:
                {
                alt22=3;
                }
                break;
            case 32:
                {
                alt22=4;
                }
                break;
            case 33:
                {
                alt22=5;
                }
                break;
            case 34:
                {
                alt22=6;
                }
                break;
            case 35:
                {
                alt22=7;
                }
                break;
            case 36:
                {
                alt22=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1271:1: (kw= 'boolean' | kw= 'char' | kw= 'byte' | kw= 'short' | kw= 'int' | kw= 'long' | kw= 'float' | kw= 'double' )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1272:2: kw= 'boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_rulePrimitiveType1951); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1279:2: kw= 'char'
                    {
                    kw=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_rulePrimitiveType1970); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1286:2: kw= 'byte'
                    {
                    kw=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_rulePrimitiveType1989); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1293:2: kw= 'short'
                    {
                    kw=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_rulePrimitiveType2008); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1300:2: kw= 'int'
                    {
                    kw=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_rulePrimitiveType2027); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_4(), null); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1307:2: kw= 'long'
                    {
                    kw=(Token)input.LT(1);
                    match(input,34,FOLLOW_34_in_rulePrimitiveType2046); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1314:2: kw= 'float'
                    {
                    kw=(Token)input.LT(1);
                    match(input,35,FOLLOW_35_in_rulePrimitiveType2065); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_6(), null); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1321:2: kw= 'double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_rulePrimitiveType2084); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_7(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePrimitiveType


    // $ANTLR start entryRuleUmpleInterface
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1334:1: entryRuleUmpleInterface returns [EObject current=null] : iv_ruleUmpleInterface= ruleUmpleInterface EOF ;
    public final EObject entryRuleUmpleInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleInterface = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1335:2: (iv_ruleUmpleInterface= ruleUmpleInterface EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1336:2: iv_ruleUmpleInterface= ruleUmpleInterface EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleInterfaceRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleInterface_in_entryRuleUmpleInterface2124);
            iv_ruleUmpleInterface=ruleUmpleInterface();
            _fsp--;

             current =iv_ruleUmpleInterface; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleInterface2134); 

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
    // $ANTLR end entryRuleUmpleInterface


    // $ANTLR start ruleUmpleInterface
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1343:1: ruleUmpleInterface returns [EObject current=null] : ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( ( (lv_extraCode_4_0= rulefunctionDeclaration ) ) ';' )? '}' ) ;
    public final EObject ruleUmpleInterface() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_depends_3_0 = null;

        EObject lv_extraCode_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1348:6: ( ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( ( (lv_extraCode_4_0= rulefunctionDeclaration ) ) ';' )? '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1349:1: ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( ( (lv_extraCode_4_0= rulefunctionDeclaration ) ) ';' )? '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1349:1: ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( ( (lv_extraCode_4_0= rulefunctionDeclaration ) ) ';' )? '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1349:3: 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( ( (lv_extraCode_4_0= rulefunctionDeclaration ) ) ';' )? '}'
            {
            match(input,37,FOLLOW_37_in_ruleUmpleInterface2169); 

                    createLeafNode(grammarAccess.getUmpleInterfaceAccess().getInterfaceKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1353:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1354:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1354:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1355:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleInterface2186); 

            			createLeafNode(grammarAccess.getUmpleInterfaceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUmpleInterfaceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleUmpleInterface2201); 

                    createLeafNode(grammarAccess.getUmpleInterfaceAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1381:1: ( (lv_depends_3_0= ruleDepend ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==63) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1382:1: (lv_depends_3_0= ruleDepend )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1382:1: (lv_depends_3_0= ruleDepend )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1383:3: lv_depends_3_0= ruleDepend
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleInterfaceAccess().getDependsDependParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDepend_in_ruleUmpleInterface2222);
            	    lv_depends_3_0=ruleDepend();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleInterfaceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"depends",
            	    	        		lv_depends_3_0, 
            	    	        		"Depend", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1405:3: ( ( (lv_extraCode_4_0= rulefunctionDeclaration ) ) ';' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=109 && LA24_0<=112)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1405:4: ( (lv_extraCode_4_0= rulefunctionDeclaration ) ) ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1405:4: ( (lv_extraCode_4_0= rulefunctionDeclaration ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1406:1: (lv_extraCode_4_0= rulefunctionDeclaration )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1406:1: (lv_extraCode_4_0= rulefunctionDeclaration )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1407:3: lv_extraCode_4_0= rulefunctionDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleInterfaceAccess().getExtraCodeFunctionDeclarationParserRuleCall_4_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulefunctionDeclaration_in_ruleUmpleInterface2245);
                    lv_extraCode_4_0=rulefunctionDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleInterfaceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"extraCode",
                    	        		lv_extraCode_4_0, 
                    	        		"functionDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleUmpleInterface2255); 

                            createLeafNode(grammarAccess.getUmpleInterfaceAccess().getSemicolonKeyword_4_1(), null); 
                        

                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleUmpleInterface2267); 

                    createLeafNode(grammarAccess.getUmpleInterfaceAccess().getRightCurlyBracketKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleInterface


    // $ANTLR start entryRuleUmpleAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1445:1: entryRuleUmpleAssociation returns [EObject current=null] : iv_ruleUmpleAssociation= ruleUmpleAssociation EOF ;
    public final EObject entryRuleUmpleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1446:2: (iv_ruleUmpleAssociation= ruleUmpleAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1447:2: iv_ruleUmpleAssociation= ruleUmpleAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAssociation_in_entryRuleUmpleAssociation2303);
            iv_ruleUmpleAssociation=ruleUmpleAssociation();
            _fsp--;

             current =iv_ruleUmpleAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAssociation2313); 

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
    // $ANTLR end entryRuleUmpleAssociation


    // $ANTLR start ruleUmpleAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1454:1: ruleUmpleAssociation returns [EObject current=null] : ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' ) ;
    public final EObject ruleUmpleAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_associations_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1459:6: ( ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1460:1: ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1460:1: ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1460:3: 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}'
            {
            match(input,38,FOLLOW_38_in_ruleUmpleAssociation2348); 

                    createLeafNode(grammarAccess.getUmpleAssociationAccess().getAssociationKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1464:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1465:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1465:1: (lv_name_1_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1466:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleAssociation2365); 

                    			createLeafNode(grammarAccess.getUmpleAssociationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleAssociationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,17,FOLLOW_17_in_ruleUmpleAssociation2381); 

                    createLeafNode(grammarAccess.getUmpleAssociationAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1492:1: ( (lv_associations_3_0= ruleAssociation ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1493:1: (lv_associations_3_0= ruleAssociation )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1493:1: (lv_associations_3_0= ruleAssociation )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1494:3: lv_associations_3_0= ruleAssociation
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUmpleAssociationAccess().getAssociationsAssociationParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssociation_in_ruleUmpleAssociation2402);
            lv_associations_3_0=ruleAssociation();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUmpleAssociationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"associations",
            	        		lv_associations_3_0, 
            	        		"Association", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleUmpleAssociation2412); 

                    createLeafNode(grammarAccess.getUmpleAssociationAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleAssociation


    // $ANTLR start entryRuleUmpleAssociationClass
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1528:1: entryRuleUmpleAssociationClass returns [EObject current=null] : iv_ruleUmpleAssociationClass= ruleUmpleAssociationClass EOF ;
    public final EObject entryRuleUmpleAssociationClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleAssociationClass = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1529:2: (iv_ruleUmpleAssociationClass= ruleUmpleAssociationClass EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1530:2: iv_ruleUmpleAssociationClass= ruleUmpleAssociationClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAssociationClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAssociationClass_in_entryRuleUmpleAssociationClass2448);
            iv_ruleUmpleAssociationClass=ruleUmpleAssociationClass();
            _fsp--;

             current =iv_ruleUmpleAssociationClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAssociationClass2458); 

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
    // $ANTLR end entryRuleUmpleAssociationClass


    // $ANTLR start ruleUmpleAssociationClass
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1537:1: ruleUmpleAssociationClass returns [EObject current=null] : ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' ) ;
    public final EObject ruleUmpleAssociationClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_associationClassContents_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1542:6: ( ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1543:1: ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1543:1: ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1543:3: 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}'
            {
            match(input,39,FOLLOW_39_in_ruleUmpleAssociationClass2493); 

                    createLeafNode(grammarAccess.getUmpleAssociationClassAccess().getAssociationClassKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1547:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1548:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1548:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1549:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleAssociationClass2510); 

            			createLeafNode(grammarAccess.getUmpleAssociationClassAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUmpleAssociationClassRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleUmpleAssociationClass2525); 

                    createLeafNode(grammarAccess.getUmpleAssociationClassAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1575:1: ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_INT)||(LA26_0>=25 && LA26_0<=26)||LA26_0==29||LA26_0==33||LA26_0==36||LA26_0==46||(LA26_0>=50 && LA26_0<=51)||(LA26_0>=54 && LA26_0<=61)||LA26_0==63||(LA26_0>=124 && LA26_0<=128)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1576:1: (lv_associationClassContents_3_0= ruleassociationClassContent )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1576:1: (lv_associationClassContents_3_0= ruleassociationClassContent )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1577:3: lv_associationClassContents_3_0= ruleassociationClassContent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleAssociationClassAccess().getAssociationClassContentsAssociationClassContentParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleassociationClassContent_in_ruleUmpleAssociationClass2546);
            	    lv_associationClassContents_3_0=ruleassociationClassContent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getUmpleAssociationClassRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"associationClassContents",
            	    	        		lv_associationClassContents_3_0, 
            	    	        		"associationClassContent", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleUmpleAssociationClass2557); 

                    createLeafNode(grammarAccess.getUmpleAssociationClassAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleAssociationClass


    // $ANTLR start entryRuleassociationClassContent
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1611:1: entryRuleassociationClassContent returns [EObject current=null] : iv_ruleassociationClassContent= ruleassociationClassContent EOF ;
    public final EObject entryRuleassociationClassContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleassociationClassContent = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1612:2: (iv_ruleassociationClassContent= ruleassociationClassContent EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1613:2: iv_ruleassociationClassContent= ruleassociationClassContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociationClassContentRule(), currentNode); 
            pushFollow(FOLLOW_ruleassociationClassContent_in_entryRuleassociationClassContent2593);
            iv_ruleassociationClassContent=ruleassociationClassContent();
            _fsp--;

             current =iv_ruleassociationClassContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleassociationClassContent2603); 

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
    // $ANTLR end entryRuleassociationClassContent


    // $ANTLR start ruleassociationClassContent
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1620:1: ruleassociationClassContent returns [EObject current=null] : (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation ) ;
    public final EObject ruleassociationClassContent() throws RecognitionException {
        EObject current = null;

        EObject this_UmpleClass_0 = null;

        EObject this_Depend_1 = null;

        EObject this_singleAssociationEnd_2 = null;

        EObject this_StateMachine_3 = null;

        EObject this_UmpleAttribute_4 = null;

        EObject this_InlineAssociation_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1625:6: ( (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1626:1: (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1626:1: (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation )
            int alt27=6;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1627:5: this_UmpleClass_0= ruleUmpleClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getUmpleClassParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUmpleClass_in_ruleassociationClassContent2650);
                    this_UmpleClass_0=ruleUmpleClass();
                    _fsp--;

                     
                            current = this_UmpleClass_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1637:5: this_Depend_1= ruleDepend
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getDependParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDepend_in_ruleassociationClassContent2677);
                    this_Depend_1=ruleDepend();
                    _fsp--;

                     
                            current = this_Depend_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1647:5: this_singleAssociationEnd_2= rulesingleAssociationEnd
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getSingleAssociationEndParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_rulesingleAssociationEnd_in_ruleassociationClassContent2704);
                    this_singleAssociationEnd_2=rulesingleAssociationEnd();
                    _fsp--;

                     
                            current = this_singleAssociationEnd_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1657:5: this_StateMachine_3= ruleStateMachine
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getStateMachineParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStateMachine_in_ruleassociationClassContent2731);
                    this_StateMachine_3=ruleStateMachine();
                    _fsp--;

                     
                            current = this_StateMachine_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1667:5: this_UmpleAttribute_4= ruleUmpleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getUmpleAttributeParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUmpleAttribute_in_ruleassociationClassContent2758);
                    this_UmpleAttribute_4=ruleUmpleAttribute();
                    _fsp--;

                     
                            current = this_UmpleAttribute_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1677:5: this_InlineAssociation_5= ruleInlineAssociation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getInlineAssociationParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInlineAssociation_in_ruleassociationClassContent2785);
                    this_InlineAssociation_5=ruleInlineAssociation();
                    _fsp--;

                     
                            current = this_InlineAssociation_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleassociationClassContent


    // $ANTLR start entryRuleAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1693:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1694:2: (iv_ruleAssociation= ruleAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1695:2: iv_ruleAssociation= ruleAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssociation_in_entryRuleAssociation2820);
            iv_ruleAssociation=ruleAssociation();
            _fsp--;

             current =iv_ruleAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociation2830); 

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
    // $ANTLR end entryRuleAssociation


    // $ANTLR start ruleAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1702:1: ruleAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' ) ;
    public final EObject ruleAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_type1_1_0=null;
        Token lv_rolename1_2_0=null;
        Token lv_type2_8_0=null;
        Token lv_rolename2_9_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1707:6: ( ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1708:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1708:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1709:5: rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation2871);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1716:1: ( (lv_type1_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1717:1: (lv_type1_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1717:1: (lv_type1_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1718:3: lv_type1_1_0= RULE_ID
            {
            lv_type1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2887); 

            			createLeafNode(grammarAccess.getAssociationAccess().getType1IDTerminalRuleCall_1_0(), "type1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssociationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type1",
            	        		lv_type1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1740:2: ( (lv_rolename1_2_0= RULE_ID ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1741:1: (lv_rolename1_2_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1741:1: (lv_rolename1_2_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1742:3: lv_rolename1_2_0= RULE_ID
                    {
                    lv_rolename1_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2909); 

                    			createLeafNode(grammarAccess.getAssociationAccess().getRolename1IDTerminalRuleCall_2_0(), "rolename1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssociationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rolename1",
                    	        		lv_rolename1_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1764:3: ( '->' | '--' | '<-' | '><' )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt29=1;
                }
                break;
            case 41:
                {
                alt29=2;
                }
                break;
            case 42:
                {
                alt29=3;
                }
                break;
            case 43:
                {
                alt29=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1764:3: ( '->' | '--' | '<-' | '><' )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1764:5: '->'
                    {
                    match(input,40,FOLLOW_40_in_ruleAssociation2926); 

                            createLeafNode(grammarAccess.getAssociationAccess().getHyphenMinusGreaterThanSignKeyword_3_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1769:7: '--'
                    {
                    match(input,41,FOLLOW_41_in_ruleAssociation2942); 

                            createLeafNode(grammarAccess.getAssociationAccess().getHyphenMinusHyphenMinusKeyword_3_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1774:7: '<-'
                    {
                    match(input,42,FOLLOW_42_in_ruleAssociation2958); 

                            createLeafNode(grammarAccess.getAssociationAccess().getLessThanSignHyphenMinusKeyword_3_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1779:7: '><'
                    {
                    match(input,43,FOLLOW_43_in_ruleAssociation2974); 

                            createLeafNode(grammarAccess.getAssociationAccess().getGreaterThanSignLessThanSignKeyword_3_3(), null); 
                        

                    }
                    break;

            }

             
                    currentNode=createCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_4(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation2991);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1791:1: ( (lv_type2_8_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1792:1: (lv_type2_8_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1792:1: (lv_type2_8_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1793:3: lv_type2_8_0= RULE_ID
            {
            lv_type2_8_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation3007); 

            			createLeafNode(grammarAccess.getAssociationAccess().getType2IDTerminalRuleCall_5_0(), "type2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssociationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type2",
            	        		lv_type2_8_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1815:2: ( (lv_rolename2_9_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1816:1: (lv_rolename2_9_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1816:1: (lv_rolename2_9_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1817:3: lv_rolename2_9_0= RULE_ID
                    {
                    lv_rolename2_9_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation3029); 

                    			createLeafNode(grammarAccess.getAssociationAccess().getRolename2IDTerminalRuleCall_6_0(), "rolename2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssociationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rolename2",
                    	        		lv_rolename2_9_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleAssociation3045); 

                    createLeafNode(grammarAccess.getAssociationAccess().getSemicolonKeyword_7(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssociation


    // $ANTLR start entryRuleSymmetricReflexiveAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1851:1: entryRuleSymmetricReflexiveAssociation returns [EObject current=null] : iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF ;
    public final EObject entryRuleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymmetricReflexiveAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1852:2: (iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1853:2: iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSymmetricReflexiveAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation3081);
            iv_ruleSymmetricReflexiveAssociation=ruleSymmetricReflexiveAssociation();
            _fsp--;

             current =iv_ruleSymmetricReflexiveAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation3091); 

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
    // $ANTLR end entryRuleSymmetricReflexiveAssociation


    // $ANTLR start ruleSymmetricReflexiveAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1860:1: ruleSymmetricReflexiveAssociation returns [EObject current=null] : ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_rolename_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1865:6: ( ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1866:1: ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1866:1: ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1867:5: rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation3132);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            match(input,44,FOLLOW_44_in_ruleSymmetricReflexiveAssociation3141); 

                    createLeafNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getSelfKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1878:1: ( (lv_rolename_2_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1879:1: (lv_rolename_2_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1879:1: (lv_rolename_2_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1880:3: lv_rolename_2_0= RULE_ID
            {
            lv_rolename_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation3158); 

            			createLeafNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getRolenameIDTerminalRuleCall_2_0(), "rolename"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSymmetricReflexiveAssociationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"rolename",
            	        		lv_rolename_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleSymmetricReflexiveAssociation3173); 

                    createLeafNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSymmetricReflexiveAssociation


    // $ANTLR start entryRuleInlineAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1914:1: entryRuleInlineAssociation returns [EObject current=null] : iv_ruleInlineAssociation= ruleInlineAssociation EOF ;
    public final EObject entryRuleInlineAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1915:2: (iv_ruleInlineAssociation= ruleInlineAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1916:2: iv_ruleInlineAssociation= ruleInlineAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInlineAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation3209);
            iv_ruleInlineAssociation=ruleInlineAssociation();
            _fsp--;

             current =iv_ruleInlineAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineAssociation3219); 

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
    // $ANTLR end entryRuleInlineAssociation


    // $ANTLR start ruleInlineAssociation
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1923:1: ruleInlineAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' ) ;
    public final EObject ruleInlineAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_rolename1_1_0=null;
        Token lv_type_7_0=null;
        Token lv_rolename2_8_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1928:6: ( ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1929:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1929:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1930:5: rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation3260);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1937:1: ( (lv_rolename1_1_0= RULE_ID ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1938:1: (lv_rolename1_1_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1938:1: (lv_rolename1_1_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1939:3: lv_rolename1_1_0= RULE_ID
                    {
                    lv_rolename1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3276); 

                    			createLeafNode(grammarAccess.getInlineAssociationAccess().getRolename1IDTerminalRuleCall_1_0(), "rolename1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInlineAssociationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rolename1",
                    	        		lv_rolename1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1961:3: ( '->' | '--' | '<-' | '><' )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt32=1;
                }
                break;
            case 41:
                {
                alt32=2;
                }
                break;
            case 42:
                {
                alt32=3;
                }
                break;
            case 43:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1961:3: ( '->' | '--' | '<-' | '><' )", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1961:5: '->'
                    {
                    match(input,40,FOLLOW_40_in_ruleInlineAssociation3293); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getHyphenMinusGreaterThanSignKeyword_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1966:7: '--'
                    {
                    match(input,41,FOLLOW_41_in_ruleInlineAssociation3309); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getHyphenMinusHyphenMinusKeyword_2_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1971:7: '<-'
                    {
                    match(input,42,FOLLOW_42_in_ruleInlineAssociation3325); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getLessThanSignHyphenMinusKeyword_2_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1976:7: '><'
                    {
                    match(input,43,FOLLOW_43_in_ruleInlineAssociation3341); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getGreaterThanSignLessThanSignKeyword_2_3(), null); 
                        

                    }
                    break;

            }

             
                    currentNode=createCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_3(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation3358);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1988:1: ( (lv_type_7_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1989:1: (lv_type_7_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1989:1: (lv_type_7_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1990:3: lv_type_7_0= RULE_ID
            {
            lv_type_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3374); 

            			createLeafNode(grammarAccess.getInlineAssociationAccess().getTypeIDTerminalRuleCall_4_0(), "type"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInlineAssociationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2012:2: ( (lv_rolename2_8_0= RULE_ID ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2013:1: (lv_rolename2_8_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2013:1: (lv_rolename2_8_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2014:3: lv_rolename2_8_0= RULE_ID
                    {
                    lv_rolename2_8_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3396); 

                    			createLeafNode(grammarAccess.getInlineAssociationAccess().getRolename2IDTerminalRuleCall_5_0(), "rolename2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInlineAssociationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rolename2",
                    	        		lv_rolename2_8_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleInlineAssociation3412); 

                    createLeafNode(grammarAccess.getInlineAssociationAccess().getSemicolonKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleInlineAssociation


    // $ANTLR start entryRulesingleAssociationEnd
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2048:1: entryRulesingleAssociationEnd returns [EObject current=null] : iv_rulesingleAssociationEnd= rulesingleAssociationEnd EOF ;
    public final EObject entryRulesingleAssociationEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesingleAssociationEnd = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2049:2: (iv_rulesingleAssociationEnd= rulesingleAssociationEnd EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2050:2: iv_rulesingleAssociationEnd= rulesingleAssociationEnd EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleAssociationEndRule(), currentNode); 
            pushFollow(FOLLOW_rulesingleAssociationEnd_in_entryRulesingleAssociationEnd3448);
            iv_rulesingleAssociationEnd=rulesingleAssociationEnd();
            _fsp--;

             current =iv_rulesingleAssociationEnd; 
            match(input,EOF,FOLLOW_EOF_in_entryRulesingleAssociationEnd3458); 

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
    // $ANTLR end entryRulesingleAssociationEnd


    // $ANTLR start rulesingleAssociationEnd
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2057:1: rulesingleAssociationEnd returns [EObject current=null] : ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' ) ;
    public final EObject rulesingleAssociationEnd() throws RecognitionException {
        EObject current = null;

        Token lv_rolename_2_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2062:6: ( ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2063:1: ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2063:1: ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2064:5: rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getSingleAssociationEndAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_rulesingleAssociationEnd3499);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2071:1: ( (lv_type_1_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2072:1: (lv_type_1_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2072:1: (lv_type_1_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2073:3: lv_type_1_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSingleAssociationEndAccess().getTypeExtendedIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulesingleAssociationEnd3519);
            lv_type_1_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSingleAssociationEndRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_1_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2095:2: ( (lv_rolename_2_0= RULE_ID ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2096:1: (lv_rolename_2_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2096:1: (lv_rolename_2_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2097:3: lv_rolename_2_0= RULE_ID
                    {
                    lv_rolename_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rulesingleAssociationEnd3536); 

                    			createLeafNode(grammarAccess.getSingleAssociationEndAccess().getRolenameIDTerminalRuleCall_2_0(), "rolename"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSingleAssociationEndRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rolename",
                    	        		lv_rolename_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_rulesingleAssociationEnd3552); 

                    createLeafNode(grammarAccess.getSingleAssociationEndAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulesingleAssociationEnd


    // $ANTLR start entryRulemultiplicity
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2131:1: entryRulemultiplicity returns [String current=null] : iv_rulemultiplicity= rulemultiplicity EOF ;
    public final String entryRulemultiplicity() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulemultiplicity = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2132:2: (iv_rulemultiplicity= rulemultiplicity EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2133:2: iv_rulemultiplicity= rulemultiplicity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicityRule(), currentNode); 
            pushFollow(FOLLOW_rulemultiplicity_in_entryRulemultiplicity3589);
            iv_rulemultiplicity=rulemultiplicity();
            _fsp--;

             current =iv_rulemultiplicity.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicity3600); 

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
    // $ANTLR end entryRulemultiplicity


    // $ANTLR start rulemultiplicity
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2140:1: rulemultiplicity returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) ;
    public final AntlrDatatypeRuleToken rulemultiplicity() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_bound_0 = null;

        AntlrDatatypeRuleToken this_bound_1 = null;

        AntlrDatatypeRuleToken this_bound_3 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2145:6: ( (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2146:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2146:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==45) ) {
                    alt35=2;
                }
                else if ( (LA35_1==EOF||LA35_1==RULE_ID||(LA35_1>=40 && LA35_1<=44)) ) {
                    alt35=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("2146:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )", 35, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA35_0==46) ) {
                int LA35_2 = input.LA(2);

                if ( (LA35_2==45) ) {
                    alt35=2;
                }
                else if ( (LA35_2==EOF||LA35_2==RULE_ID||(LA35_2>=40 && LA35_2<=44)) ) {
                    alt35=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("2146:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )", 35, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2146:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2147:5: this_bound_0= rulebound
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity3647);
                    this_bound_0=rulebound();
                    _fsp--;


                    		current.merge(this_bound_0);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2158:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2158:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2159:5: this_bound_1= rulebound kw= '..' this_bound_3= rulebound
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity3681);
                    this_bound_1=rulebound();
                    _fsp--;


                    		current.merge(this_bound_1);
                        
                     
                            currentNode = currentNode.getParent();
                        
                    kw=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_rulemultiplicity3699); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getMultiplicityAccess().getFullStopFullStopKeyword_1_1(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_2(), currentNode); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity3721);
                    this_bound_3=rulebound();
                    _fsp--;


                    		current.merge(this_bound_3);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulemultiplicity


    // $ANTLR start entryRulebound
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2194:1: entryRulebound returns [String current=null] : iv_rulebound= rulebound EOF ;
    public final String entryRulebound() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulebound = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2195:2: (iv_rulebound= rulebound EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2196:2: iv_rulebound= rulebound EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBoundRule(), currentNode); 
            pushFollow(FOLLOW_rulebound_in_entryRulebound3768);
            iv_rulebound=rulebound();
            _fsp--;

             current =iv_rulebound.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulebound3779); 

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
    // $ANTLR end entryRulebound


    // $ANTLR start rulebound
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2203:1: rulebound returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken rulebound() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2208:6: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2209:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2209:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_INT) ) {
                alt36=1;
            }
            else if ( (LA36_0==46) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2209:1: (this_INT_0= RULE_INT | kw= '*' )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2209:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rulebound3819); 

                    		current.merge(this_INT_0);
                        
                     
                        createLeafNode(grammarAccess.getBoundAccess().getINTTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2218:2: kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_rulebound3843); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getBoundAccess().getAsteriskKeyword_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulebound


    // $ANTLR start entryRuleSingleton
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2231:1: entryRuleSingleton returns [EObject current=null] : iv_ruleSingleton= ruleSingleton EOF ;
    public final EObject entryRuleSingleton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleton = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2232:2: (iv_ruleSingleton= ruleSingleton EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2233:2: iv_ruleSingleton= ruleSingleton EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingletonRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleton_in_entryRuleSingleton3883);
            iv_ruleSingleton=ruleSingleton();
            _fsp--;

             current =iv_ruleSingleton; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleton3893); 

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
    // $ANTLR end entryRuleSingleton


    // $ANTLR start ruleSingleton
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2240:1: ruleSingleton returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) ) ';' ) ;
    public final EObject ruleSingleton() throws RecognitionException {
        EObject current = null;

        Token lv_singleton_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2245:6: ( ( ( (lv_singleton_0_0= 'singleton' ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2246:1: ( ( (lv_singleton_0_0= 'singleton' ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2246:1: ( ( (lv_singleton_0_0= 'singleton' ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2246:2: ( (lv_singleton_0_0= 'singleton' ) ) ';'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2246:2: ( (lv_singleton_0_0= 'singleton' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2247:1: (lv_singleton_0_0= 'singleton' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2247:1: (lv_singleton_0_0= 'singleton' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2248:3: lv_singleton_0_0= 'singleton'
            {
            lv_singleton_0_0=(Token)input.LT(1);
            match(input,47,FOLLOW_47_in_ruleSingleton3936); 

                    createLeafNode(grammarAccess.getSingletonAccess().getSingletonSingletonKeyword_0_0(), "singleton"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSingletonRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "singleton", true, "singleton", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleSingleton3959); 

                    createLeafNode(grammarAccess.getSingletonAccess().getSemicolonKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSingleton


    // $ANTLR start entryRuleCodeInjection
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2279:1: entryRuleCodeInjection returns [EObject current=null] : iv_ruleCodeInjection= ruleCodeInjection EOF ;
    public final EObject entryRuleCodeInjection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeInjection = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2280:2: (iv_ruleCodeInjection= ruleCodeInjection EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2281:2: iv_ruleCodeInjection= ruleCodeInjection EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCodeInjectionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection3995);
            iv_ruleCodeInjection=ruleCodeInjection();
            _fsp--;

             current =iv_ruleCodeInjection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodeInjection4005); 

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
    // $ANTLR end entryRuleCodeInjection


    // $ANTLR start ruleCodeInjection
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2288:1: ruleCodeInjection returns [EObject current=null] : ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) ) ;
    public final EObject ruleCodeInjection() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_code_2_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_code_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2293:6: ( ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2294:1: ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2294:1: ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==48) ) {
                alt37=1;
            }
            else if ( (LA37_0==49) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2294:1: ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2294:2: ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2294:2: ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2294:4: 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) )
                    {
                    match(input,48,FOLLOW_48_in_ruleCodeInjection4041); 

                            createLeafNode(grammarAccess.getCodeInjectionAccess().getBeforeKeyword_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2298:1: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2299:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2299:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2300:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection4062);
                    lv_name_1_0=ruleextendedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCodeInjectionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"extendedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2322:2: ( (lv_code_2_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2323:1: (lv_code_2_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2323:1: (lv_code_2_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2324:3: lv_code_2_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getCodeBlockParserRuleCall_0_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_ruleCodeInjection4083);
                    lv_code_2_0=ruleblock();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCodeInjectionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"code",
                    	        		lv_code_2_0, 
                    	        		"block", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2347:6: ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2347:6: ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2347:8: 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleCodeInjection4101); 

                            createLeafNode(grammarAccess.getCodeInjectionAccess().getAfterKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2351:1: ( (lv_name_4_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2352:1: (lv_name_4_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2352:1: (lv_name_4_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2353:3: lv_name_4_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection4122);
                    lv_name_4_0=ruleextendedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCodeInjectionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_4_0, 
                    	        		"extendedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2375:2: ( (lv_code_5_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2376:1: (lv_code_5_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2376:1: (lv_code_5_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2377:3: lv_code_5_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getCodeBlockParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_ruleCodeInjection4143);
                    lv_code_5_0=ruleblock();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCodeInjectionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"code",
                    	        		lv_code_5_0, 
                    	        		"block", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCodeInjection


    // $ANTLR start entryRuleUmpleAttribute
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2407:1: entryRuleUmpleAttribute returns [EObject current=null] : iv_ruleUmpleAttribute= ruleUmpleAttribute EOF ;
    public final EObject entryRuleUmpleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleAttribute = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2408:2: (iv_ruleUmpleAttribute= ruleUmpleAttribute EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2409:2: iv_ruleUmpleAttribute= ruleUmpleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAttribute_in_entryRuleUmpleAttribute4180);
            iv_ruleUmpleAttribute=ruleUmpleAttribute();
            _fsp--;

             current =iv_ruleUmpleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAttribute4190); 

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
    // $ANTLR end entryRuleUmpleAttribute


    // $ANTLR start ruleUmpleAttribute
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2416:1: ruleUmpleAttribute returns [EObject current=null] : ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) ) ;
    public final EObject ruleUmpleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_autounique_0_0=null;
        Token lv_unique_3_0=null;
        Token lv_list_6_0=null;
        Token lv_list_8_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_modifier_4_0 = null;

        AntlrDatatypeRuleToken lv_type_5_0 = null;

        AntlrDatatypeRuleToken lv_name_9_0 = null;

        AntlrDatatypeRuleToken lv_value_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2421:6: ( ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2422:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2422:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==50) ) {
                alt44=1;
            }
            else if ( (LA44_0==RULE_ID||LA44_0==29||LA44_0==33||LA44_0==36||LA44_0==51||(LA44_0>=54 && LA44_0<=61)||(LA44_0>=124 && LA44_0<=128)) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2422:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2422:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2422:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2422:3: ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2422:3: ( (lv_autounique_0_0= 'autounique' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2423:1: (lv_autounique_0_0= 'autounique' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2423:1: (lv_autounique_0_0= 'autounique' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2424:3: lv_autounique_0_0= 'autounique'
                    {
                    lv_autounique_0_0=(Token)input.LT(1);
                    match(input,50,FOLLOW_50_in_ruleUmpleAttribute4234); 

                            createLeafNode(grammarAccess.getUmpleAttributeAccess().getAutouniqueAutouniqueKeyword_0_0_0(), "autounique"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "autounique", true, "autounique", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2443:2: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2444:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2444:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2445:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getNameExtendedIDParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleUmpleAttribute4268);
                    lv_name_1_0=ruleextendedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_0, 
                    	        		"extendedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleUmpleAttribute4278); 

                            createLeafNode(grammarAccess.getUmpleAttributeAccess().getSemicolonKeyword_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2472:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2472:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2472:7: ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2472:7: ( (lv_unique_3_0= 'unique' ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==51) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2473:1: (lv_unique_3_0= 'unique' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2473:1: (lv_unique_3_0= 'unique' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2474:3: lv_unique_3_0= 'unique'
                            {
                            lv_unique_3_0=(Token)input.LT(1);
                            match(input,51,FOLLOW_51_in_ruleUmpleAttribute4304); 

                                    createLeafNode(grammarAccess.getUmpleAttributeAccess().getUniqueUniqueKeyword_1_0_0(), "unique"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "unique", true, "unique", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2493:3: ( (lv_modifier_4_0= ruleModifier ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=124 && LA39_0<=128)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2494:1: (lv_modifier_4_0= ruleModifier )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2494:1: (lv_modifier_4_0= ruleModifier )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2495:3: lv_modifier_4_0= ruleModifier
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getModifierModifierEnumRuleCall_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleModifier_in_ruleUmpleAttribute4339);
                            lv_modifier_4_0=ruleModifier();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"modifier",
                            	        		lv_modifier_4_0, 
                            	        		"Modifier", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2517:3: ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )?
                    int alt42=3;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==29||LA42_0==33||LA42_0==36||(LA42_0>=54 && LA42_0<=61)) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==RULE_ID) ) {
                        int LA42_2 = input.LA(2);

                        if ( (LA42_2==RULE_ID||LA42_2==52) ) {
                            alt42=2;
                        }
                    }
                    switch (alt42) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2517:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2517:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2517:5: ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )?
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2517:5: ( (lv_type_5_0= ruleUmpleAttributeType ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2518:1: (lv_type_5_0= ruleUmpleAttributeType )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2518:1: (lv_type_5_0= ruleUmpleAttributeType )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2519:3: lv_type_5_0= ruleUmpleAttributeType
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getTypeUmpleAttributeTypeParserRuleCall_1_2_0_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUmpleAttributeType_in_ruleUmpleAttribute4363);
                            lv_type_5_0=ruleUmpleAttributeType();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"type",
                            	        		lv_type_5_0, 
                            	        		"UmpleAttributeType", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2541:2: ( (lv_list_6_0= '[]' ) )?
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==52) ) {
                                alt40=1;
                            }
                            switch (alt40) {
                                case 1 :
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2542:1: (lv_list_6_0= '[]' )
                                    {
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2542:1: (lv_list_6_0= '[]' )
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2543:3: lv_list_6_0= '[]'
                                    {
                                    lv_list_6_0=(Token)input.LT(1);
                                    match(input,52,FOLLOW_52_in_ruleUmpleAttribute4381); 

                                            createLeafNode(grammarAccess.getUmpleAttributeAccess().getListLeftSquareBracketRightSquareBracketKeyword_1_2_0_1_0(), "list"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "list", true, "[]", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2563:6: ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2563:6: ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2563:7: ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )?
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2563:7: ( ( RULE_ID ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2564:1: ( RULE_ID )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2564:1: ( RULE_ID )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2565:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleAttribute4421); 

                            		createLeafNode(grammarAccess.getUmpleAttributeAccess().getObjectUmpleClassCrossReference_1_2_1_0_0(), "object"); 
                            	

                            }


                            }

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2577:2: ( (lv_list_8_0= '[]' ) )?
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( (LA41_0==52) ) {
                                alt41=1;
                            }
                            switch (alt41) {
                                case 1 :
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2578:1: (lv_list_8_0= '[]' )
                                    {
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2578:1: (lv_list_8_0= '[]' )
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2579:3: lv_list_8_0= '[]'
                                    {
                                    lv_list_8_0=(Token)input.LT(1);
                                    match(input,52,FOLLOW_52_in_ruleUmpleAttribute4439); 

                                            createLeafNode(grammarAccess.getUmpleAttributeAccess().getListLeftSquareBracketRightSquareBracketKeyword_1_2_1_1_0(), "list"); 
                                        

                                    	        if (current==null) {
                                    	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                    	        
                                    	        try {
                                    	       		set(current, "list", true, "[]", lastConsumedNode);
                                    	        } catch (ValueConverterException vce) {
                                    				handleValueConverterException(vce);
                                    	        }
                                    	    

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2598:6: ( (lv_name_9_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2599:1: (lv_name_9_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2599:1: (lv_name_9_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2600:3: lv_name_9_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getNameExtendedIDParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleUmpleAttribute4477);
                    lv_name_9_0=ruleextendedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_9_0, 
                    	        		"extendedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2622:2: ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==53) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2622:4: '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            {
                            match(input,53,FOLLOW_53_in_ruleUmpleAttribute4488); 

                                    createLeafNode(grammarAccess.getUmpleAttributeAccess().getEqualsSignKeyword_1_4_0(), null); 
                                
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2626:1: ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2627:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2627:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2628:3: lv_value_11_0= ruleUmplePrimitiveType
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getValueUmplePrimitiveTypeParserRuleCall_1_4_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_ruleUmpleAttribute4509);
                            lv_value_11_0=ruleUmplePrimitiveType();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_11_0, 
                            	        		"UmplePrimitiveType", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    match(input,15,FOLLOW_15_in_ruleUmpleAttribute4521); 

                            createLeafNode(grammarAccess.getUmpleAttributeAccess().getSemicolonKeyword_1_5(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleAttribute


    // $ANTLR start entryRuleUmplePrimitiveType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2662:1: entryRuleUmplePrimitiveType returns [String current=null] : iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF ;
    public final String entryRuleUmplePrimitiveType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmplePrimitiveType = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2663:2: (iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2664:2: iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmplePrimitiveTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType4559);
            iv_ruleUmplePrimitiveType=ruleUmplePrimitiveType();
            _fsp--;

             current =iv_ruleUmplePrimitiveType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmplePrimitiveType4570); 

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
    // $ANTLR end entryRuleUmplePrimitiveType


    // $ANTLR start ruleUmplePrimitiveType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2671:1: ruleUmplePrimitiveType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleUmplePrimitiveType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_STRING_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2676:6: ( (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2677:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2677:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_INT) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_STRING) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2677:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2677:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUmplePrimitiveType4610); 

                    		current.merge(this_INT_0);
                        
                     
                        createLeafNode(grammarAccess.getUmplePrimitiveTypeAccess().getINTTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2685:10: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType4636); 

                    		current.merge(this_STRING_1);
                        
                     
                        createLeafNode(grammarAccess.getUmplePrimitiveTypeAccess().getSTRINGTerminalRuleCall_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmplePrimitiveType


    // $ANTLR start entryRuleUmpleAttributeType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2700:1: entryRuleUmpleAttributeType returns [String current=null] : iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF ;
    public final String entryRuleUmpleAttributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmpleAttributeType = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2701:2: (iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2702:2: iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAttributeTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType4682);
            iv_ruleUmpleAttributeType=ruleUmpleAttributeType();
            _fsp--;

             current =iv_ruleUmpleAttributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAttributeType4693); 

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
    // $ANTLR end entryRuleUmpleAttributeType


    // $ANTLR start ruleUmpleAttributeType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2709:1: ruleUmpleAttributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleUmpleAttributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2714:6: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2715:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2715:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt46=11;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt46=1;
                }
                break;
            case 55:
                {
                alt46=2;
                }
                break;
            case 56:
                {
                alt46=3;
                }
                break;
            case 36:
                {
                alt46=4;
                }
                break;
            case 57:
                {
                alt46=5;
                }
                break;
            case 58:
                {
                alt46=6;
                }
                break;
            case 33:
                {
                alt46=7;
                }
                break;
            case 59:
                {
                alt46=8;
                }
                break;
            case 29:
                {
                alt46=9;
                }
                break;
            case 60:
                {
                alt46=10;
                }
                break;
            case 61:
                {
                alt46=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2715:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2716:2: kw= 'Date'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleUmpleAttributeType4731); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getDateKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2723:2: kw= 'Time'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleUmpleAttributeType4750); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getTimeKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2730:2: kw= 'Double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleUmpleAttributeType4769); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2737:2: kw= 'double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_ruleUmpleAttributeType4788); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2744:2: kw= 'Integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_ruleUmpleAttributeType4807); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_4(), null); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2751:2: kw= 'integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,58,FOLLOW_58_in_ruleUmpleAttributeType4826); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2758:2: kw= 'int'
                    {
                    kw=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleUmpleAttributeType4845); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getIntKeyword_6(), null); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2765:2: kw= 'Boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,59,FOLLOW_59_in_ruleUmpleAttributeType4864); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_7(), null); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2772:2: kw= 'boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleUmpleAttributeType4883); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_8(), null); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2779:2: kw= 'String'
                    {
                    kw=(Token)input.LT(1);
                    match(input,60,FOLLOW_60_in_ruleUmpleAttributeType4902); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getStringKeyword_9(), null); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2786:2: kw= 'string'
                    {
                    kw=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_ruleUmpleAttributeType4921); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getStringKeyword_10(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUmpleAttributeType


    // $ANTLR start entryRuleKey
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2799:1: entryRuleKey returns [EObject current=null] : iv_ruleKey= ruleKey EOF ;
    public final EObject entryRuleKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKey = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2800:2: (iv_ruleKey= ruleKey EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2801:2: iv_ruleKey= ruleKey EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeyRule(), currentNode); 
            pushFollow(FOLLOW_ruleKey_in_entryRuleKey4961);
            iv_ruleKey=ruleKey();
            _fsp--;

             current =iv_ruleKey; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKey4971); 

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
    // $ANTLR end entryRuleKey


    // $ANTLR start ruleKey
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2808:1: ruleKey returns [EObject current=null] : ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' ) ;
    public final EObject ruleKey() throws RecognitionException {
        EObject current = null;

        Token lv_keys_3_0=null;
        Token lv_keys_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2813:6: ( ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2814:1: ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2814:1: ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2814:3: 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}'
            {
            match(input,62,FOLLOW_62_in_ruleKey5006); 

                    createLeafNode(grammarAccess.getKeyAccess().getKeyKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2818:1: ()
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2819:5: 
            {
             
                    temp=factory.create(grammarAccess.getKeyAccess().getKeyAction_1().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getKeyAccess().getKeyAction_1(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,17,FOLLOW_17_in_ruleKey5025); 

                    createLeafNode(grammarAccess.getKeyAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2833:1: ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2833:2: ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2833:2: ( (lv_keys_3_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2834:1: (lv_keys_3_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2834:1: (lv_keys_3_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2835:3: lv_keys_3_0= RULE_ID
                    {
                    lv_keys_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKey5043); 

                    			createLeafNode(grammarAccess.getKeyAccess().getKeysIDTerminalRuleCall_3_0_0(), "keys"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getKeyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"keys",
                    	        		lv_keys_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2857:2: ( ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==28) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2857:4: ',' ( (lv_keys_5_0= RULE_ID ) )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleKey5059); 

                    	            createLeafNode(grammarAccess.getKeyAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2861:1: ( (lv_keys_5_0= RULE_ID ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2862:1: (lv_keys_5_0= RULE_ID )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2862:1: (lv_keys_5_0= RULE_ID )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2863:3: lv_keys_5_0= RULE_ID
                    	    {
                    	    lv_keys_5_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKey5076); 

                    	    			createLeafNode(grammarAccess.getKeyAccess().getKeysIDTerminalRuleCall_3_1_1_0(), "keys"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getKeyRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"keys",
                    	    	        		lv_keys_5_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleKey5095); 

                    createLeafNode(grammarAccess.getKeyAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKey


    // $ANTLR start entryRuleDepend
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2897:1: entryRuleDepend returns [EObject current=null] : iv_ruleDepend= ruleDepend EOF ;
    public final EObject entryRuleDepend() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDepend = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2898:2: (iv_ruleDepend= ruleDepend EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2899:2: iv_ruleDepend= ruleDepend EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDependRule(), currentNode); 
            pushFollow(FOLLOW_ruleDepend_in_entryRuleDepend5131);
            iv_ruleDepend=ruleDepend();
            _fsp--;

             current =iv_ruleDepend; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDepend5141); 

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
    // $ANTLR end entryRuleDepend


    // $ANTLR start ruleDepend
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2906:1: ruleDepend returns [EObject current=null] : ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' ) ;
    public final EObject ruleDepend() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2911:6: ( ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2912:1: ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2912:1: ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2912:3: 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';'
            {
            match(input,63,FOLLOW_63_in_ruleDepend5176); 

                    createLeafNode(grammarAccess.getDependAccess().getDependKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2916:1: ( (lv_name_1_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2917:1: (lv_name_1_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2917:1: (lv_name_1_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2918:3: lv_name_1_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDependAccess().getNameExtendedIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleDepend5197);
            lv_name_1_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDependRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2940:2: ( '.*' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==64) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2940:4: '.*'
                    {
                    match(input,64,FOLLOW_64_in_ruleDepend5208); 

                            createLeafNode(grammarAccess.getDependAccess().getFullStopAsteriskKeyword_2(), null); 
                        

                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleDepend5220); 

                    createLeafNode(grammarAccess.getDependAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDepend


    // $ANTLR start entryRuleStateMachineDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2956:1: entryRuleStateMachineDefinition returns [EObject current=null] : iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF ;
    public final EObject entryRuleStateMachineDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachineDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2957:2: (iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2958:2: iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateMachineDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateMachineDefinition_in_entryRuleStateMachineDefinition5256);
            iv_ruleStateMachineDefinition=ruleStateMachineDefinition();
            _fsp--;

             current =iv_ruleStateMachineDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachineDefinition5266); 

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
    // $ANTLR end entryRuleStateMachineDefinition


    // $ANTLR start ruleStateMachineDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2965:1: ruleStateMachineDefinition returns [EObject current=null] : ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' ) ;
    public final EObject ruleStateMachineDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_states_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2970:6: ( ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2971:1: ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2971:1: ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2971:3: 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}'
            {
            match(input,65,FOLLOW_65_in_ruleStateMachineDefinition5301); 

                    createLeafNode(grammarAccess.getStateMachineDefinitionAccess().getStatemachineKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2975:1: ( (lv_name_1_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2976:1: (lv_name_1_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2976:1: (lv_name_1_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2977:3: lv_name_1_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStateMachineDefinitionAccess().getNameExtendedIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleStateMachineDefinition5322);
            lv_name_1_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStateMachineDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleStateMachineDefinition5332); 

                    createLeafNode(grammarAccess.getStateMachineDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3003:1: ( (lv_states_3_0= ruleState ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID||(LA50_0>=67 && LA50_0<=69)||(LA50_0>=82 && LA50_0<=83)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3004:1: (lv_states_3_0= ruleState )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3004:1: (lv_states_3_0= ruleState )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3005:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineDefinitionAccess().getStatesStateParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachineDefinition5353);
            	    lv_states_3_0=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateMachineDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"states",
            	    	        		lv_states_3_0, 
            	    	        		"State", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleStateMachineDefinition5364); 

                    createLeafNode(grammarAccess.getStateMachineDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateMachineDefinition


    // $ANTLR start entryRuleStateMachine
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3039:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3040:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3041:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine5400);
            iv_ruleStateMachine=ruleStateMachine();
            _fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine5410); 

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
    // $ANTLR end entryRuleStateMachine


    // $ANTLR start ruleStateMachine
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3048:1: ruleStateMachine returns [EObject current=null] : (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject this_ENUM_0 = null;

        EObject this_InlineStateMachine_1 = null;

        EObject this_ReferencedStateMachine_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3053:6: ( (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3054:1: (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3054:1: (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )
            int alt51=3;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3055:5: this_ENUM_0= ruleENUM
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getENUMParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleENUM_in_ruleStateMachine5457);
                    this_ENUM_0=ruleENUM();
                    _fsp--;

                     
                            current = this_ENUM_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3065:5: this_InlineStateMachine_1= ruleInlineStateMachine
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getInlineStateMachineParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInlineStateMachine_in_ruleStateMachine5484);
                    this_InlineStateMachine_1=ruleInlineStateMachine();
                    _fsp--;

                     
                            current = this_InlineStateMachine_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3075:5: this_ReferencedStateMachine_2= ruleReferencedStateMachine
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getReferencedStateMachineParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedStateMachine_in_ruleStateMachine5511);
                    this_ReferencedStateMachine_2=ruleReferencedStateMachine();
                    _fsp--;

                     
                            current = this_ReferencedStateMachine_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateMachine


    // $ANTLR start entryRuleInlineStateMachine
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3091:1: entryRuleInlineStateMachine returns [EObject current=null] : iv_ruleInlineStateMachine= ruleInlineStateMachine EOF ;
    public final EObject entryRuleInlineStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineStateMachine = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3092:2: (iv_ruleInlineStateMachine= ruleInlineStateMachine EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3093:2: iv_ruleInlineStateMachine= ruleInlineStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInlineStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleInlineStateMachine_in_entryRuleInlineStateMachine5546);
            iv_ruleInlineStateMachine=ruleInlineStateMachine();
            _fsp--;

             current =iv_ruleInlineStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineStateMachine5556); 

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
    // $ANTLR end entryRuleInlineStateMachine


    // $ANTLR start ruleInlineStateMachine
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3100:1: ruleInlineStateMachine returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' ) ;
    public final EObject ruleInlineStateMachine() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_states_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3105:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3106:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3106:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3106:2: ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3106:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3107:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3107:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3108:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInlineStateMachineAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleInlineStateMachine5602);
            lv_name_0_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInlineStateMachineRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleInlineStateMachine5612); 

                    createLeafNode(grammarAccess.getInlineStateMachineAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3134:1: ( (lv_states_2_0= ruleState ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID||(LA52_0>=67 && LA52_0<=69)||(LA52_0>=82 && LA52_0<=83)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3135:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3135:1: (lv_states_2_0= ruleState )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3136:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getInlineStateMachineAccess().getStatesStateParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleInlineStateMachine5633);
            	    lv_states_2_0=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getInlineStateMachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"states",
            	    	        		lv_states_2_0, 
            	    	        		"State", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleInlineStateMachine5644); 

                    createLeafNode(grammarAccess.getInlineStateMachineAccess().getRightCurlyBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleInlineStateMachine


    // $ANTLR start entryRuleReferencedStateMachine
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3170:1: entryRuleReferencedStateMachine returns [EObject current=null] : iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF ;
    public final EObject entryRuleReferencedStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedStateMachine = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3171:2: (iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3172:2: iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedStateMachine_in_entryRuleReferencedStateMachine5680);
            iv_ruleReferencedStateMachine=ruleReferencedStateMachine();
            _fsp--;

             current =iv_ruleReferencedStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedStateMachine5690); 

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
    // $ANTLR end entryRuleReferencedStateMachine


    // $ANTLR start ruleReferencedStateMachine
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3179:1: ruleReferencedStateMachine returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' ) ;
    public final EObject ruleReferencedStateMachine() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3184:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:1: ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:1: ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:2: ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3185:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3186:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3186:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3187:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getReferencedStateMachineAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleReferencedStateMachine5736);
            lv_name_0_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedStateMachineRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,66,FOLLOW_66_in_ruleReferencedStateMachine5746); 

                    createLeafNode(grammarAccess.getReferencedStateMachineAccess().getAsKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3213:1: ( ( RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3214:1: ( RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3214:1: ( RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3215:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedStateMachineRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedStateMachine5764); 

            		createLeafNode(grammarAccess.getReferencedStateMachineAccess().getMachineStateMachineDefinitionCrossReference_2_0(), "machine"); 
            	

            }


            }

            match(input,15,FOLLOW_15_in_ruleReferencedStateMachine5774); 

                    createLeafNode(grammarAccess.getReferencedStateMachineAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleReferencedStateMachine


    // $ANTLR start entryRuleENUM
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3239:1: entryRuleENUM returns [EObject current=null] : iv_ruleENUM= ruleENUM EOF ;
    public final EObject entryRuleENUM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleENUM = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3240:2: (iv_ruleENUM= ruleENUM EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3241:2: iv_ruleENUM= ruleENUM EOF
            {
             currentNode = createCompositeNode(grammarAccess.getENUMRule(), currentNode); 
            pushFollow(FOLLOW_ruleENUM_in_entryRuleENUM5810);
            iv_ruleENUM=ruleENUM();
            _fsp--;

             current =iv_ruleENUM; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleENUM5820); 

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
    // $ANTLR end entryRuleENUM


    // $ANTLR start ruleENUM
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3248:1: ruleENUM returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' ) ;
    public final EObject ruleENUM() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_state1_2_0 = null;

        AntlrDatatypeRuleToken lv_states_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3253:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3254:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3254:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3254:2: ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3254:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3255:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3255:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3256:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getENUMAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleENUM5866);
            lv_name_0_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getENUMRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleENUM5876); 

                    createLeafNode(grammarAccess.getENUMAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3282:1: ( (lv_state1_2_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3283:1: (lv_state1_2_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3283:1: (lv_state1_2_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3284:3: lv_state1_2_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getENUMAccess().getState1ExtendedIDParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleENUM5897);
            lv_state1_2_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getENUMRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"state1",
            	        		lv_state1_2_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3306:2: ( ',' ( (lv_states_4_0= ruleextendedID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==28) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3306:4: ',' ( (lv_states_4_0= ruleextendedID ) )
            	    {
            	    match(input,28,FOLLOW_28_in_ruleENUM5908); 

            	            createLeafNode(grammarAccess.getENUMAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3310:1: ( (lv_states_4_0= ruleextendedID ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3311:1: (lv_states_4_0= ruleextendedID )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3311:1: (lv_states_4_0= ruleextendedID )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3312:3: lv_states_4_0= ruleextendedID
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getENUMAccess().getStatesExtendedIDParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleextendedID_in_ruleENUM5929);
            	    lv_states_4_0=ruleextendedID();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getENUMRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"states",
            	    	        		lv_states_4_0, 
            	    	        		"extendedID", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleENUM5941); 

                    createLeafNode(grammarAccess.getENUMAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleENUM


    // $ANTLR start entryRuleState
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3346:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3347:2: (iv_ruleState= ruleState EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3348:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState5977);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState5987); 

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
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3355:1: ruleState returns [EObject current=null] : ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject lv_stateTraceDirective_0_0 = null;

        AntlrDatatypeRuleToken lv_stateName_4_0 = null;

        EObject lv_states_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3360:6: ( ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3361:1: ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3361:1: ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=82 && LA59_0<=83)) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_ID||(LA59_0>=67 && LA59_0<=69)) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3361:1: ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3361:2: ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3361:2: ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3362:1: (lv_stateTraceDirective_0_0= ruleTraceDirective )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3362:1: (lv_stateTraceDirective_0_0= ruleTraceDirective )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3363:3: lv_stateTraceDirective_0_0= ruleTraceDirective
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateTraceDirectiveTraceDirectiveParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTraceDirective_in_ruleState6033);
                    lv_stateTraceDirective_0_0=ruleTraceDirective();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"stateTraceDirective",
                    	        		lv_stateTraceDirective_0_0, 
                    	        		"TraceDirective", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3386:6: ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3386:6: ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3386:7: ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3386:7: ( 'conc' )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==67) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3386:9: 'conc'
                            {
                            match(input,67,FOLLOW_67_in_ruleState6051); 

                                    createLeafNode(grammarAccess.getStateAccess().getConcKeyword_1_0(), null); 
                                

                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3390:3: ( 'concurrent' )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==68) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3390:5: 'concurrent'
                            {
                            match(input,68,FOLLOW_68_in_ruleState6064); 

                                    createLeafNode(grammarAccess.getStateAccess().getConcurrentKeyword_1_1(), null); 
                                

                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3394:3: ( '|' )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==69) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3394:5: '|'
                            {
                            match(input,69,FOLLOW_69_in_ruleState6077); 

                                    createLeafNode(grammarAccess.getStateAccess().getVerticalLineKeyword_1_2(), null); 
                                

                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3398:3: ( (lv_stateName_4_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3399:1: (lv_stateName_4_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3399:1: (lv_stateName_4_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3400:3: lv_stateName_4_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateNameExtendedIDParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleState6100);
                    lv_stateName_4_0=ruleextendedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stateName",
                    	        		lv_stateName_4_0, 
                    	        		"extendedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,17,FOLLOW_17_in_ruleState6110); 

                            createLeafNode(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_1_4(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:1: ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_INT)||LA58_0==41||LA58_0==46||(LA58_0>=67 && LA58_0<=71)||LA58_0==73||(LA58_0>=75 && LA58_0<=78)||(LA58_0>=82 && LA58_0<=83)||(LA58_0>=99 && LA58_0<=100)||(LA58_0>=102 && LA58_0<=108)) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:2: ( '*' )? ( (lv_states_7_0= ruleStateEntity ) )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:2: ( '*' )?
                    	    int alt57=2;
                    	    int LA57_0 = input.LA(1);

                    	    if ( (LA57_0==46) ) {
                    	        alt57=1;
                    	    }
                    	    switch (alt57) {
                    	        case 1 :
                    	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:4: '*'
                    	            {
                    	            match(input,46,FOLLOW_46_in_ruleState6122); 

                    	                    createLeafNode(grammarAccess.getStateAccess().getAsteriskKeyword_1_5_0(), null); 
                    	                

                    	            }
                    	            break;

                    	    }

                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3430:3: ( (lv_states_7_0= ruleStateEntity ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3431:1: (lv_states_7_0= ruleStateEntity )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3431:1: (lv_states_7_0= ruleStateEntity )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3432:3: lv_states_7_0= ruleStateEntity
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStatesStateEntityParserRuleCall_1_5_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleStateEntity_in_ruleState6145);
                    	    lv_states_7_0=ruleStateEntity();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"states",
                    	    	        		lv_states_7_0, 
                    	    	        		"StateEntity", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    match(input,18,FOLLOW_18_in_ruleState6157); 

                            createLeafNode(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_1_6(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleState


    // $ANTLR start entryRuleStateEntity
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3466:1: entryRuleStateEntity returns [EObject current=null] : iv_ruleStateEntity= ruleStateEntity EOF ;
    public final EObject entryRuleStateEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateEntity = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3467:2: (iv_ruleStateEntity= ruleStateEntity EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3468:2: iv_ruleStateEntity= ruleStateEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateEntityRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateEntity_in_entryRuleStateEntity6194);
            iv_ruleStateEntity=ruleStateEntity();
            _fsp--;

             current =iv_ruleStateEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateEntity6204); 

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
    // $ANTLR end entryRuleStateEntity


    // $ANTLR start ruleStateEntity
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3475:1: ruleStateEntity returns [EObject current=null] : (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) ) ;
    public final EObject ruleStateEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Transition_0 = null;

        EObject this_EntryOrExitAction_1 = null;

        EObject this_Activity_2 = null;

        EObject this_State_6 = null;

        EObject lv_expression_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3480:6: ( (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3481:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3481:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) )
            int alt61=5;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3482:5: this_Transition_0= ruleTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getTransitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTransition_in_ruleStateEntity6251);
                    this_Transition_0=ruleTransition();
                    _fsp--;

                     
                            current = this_Transition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3492:5: this_EntryOrExitAction_1= ruleEntryOrExitAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getEntryOrExitActionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntryOrExitAction_in_ruleStateEntity6278);
                    this_EntryOrExitAction_1=ruleEntryOrExitAction();
                    _fsp--;

                     
                            current = this_EntryOrExitAction_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3501:6: (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3501:6: (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3502:5: this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getActivityParserRuleCall_2_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActivity_in_ruleStateEntity6306);
                    this_Activity_2=ruleActivity();
                    _fsp--;

                     
                            current = this_Activity_2; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3510:1: ( '->' ruleextendedID ';' )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==40) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3510:3: '->' ruleextendedID ';'
                            {
                            match(input,40,FOLLOW_40_in_ruleStateEntity6316); 

                                    createLeafNode(grammarAccess.getStateEntityAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0(), null); 
                                
                             
                                    currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getExtendedIDParserRuleCall_2_1_1(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleextendedID_in_ruleStateEntity6332);
                            ruleextendedID();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                
                            match(input,15,FOLLOW_15_in_ruleStateEntity6341); 

                                    createLeafNode(grammarAccess.getStateEntityAccess().getSemicolonKeyword_2_1_2(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3528:5: this_State_6= ruleState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getStateParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateEntity6372);
                    this_State_6=ruleState();
                    _fsp--;

                     
                            current = this_State_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3537:6: ( ( (lv_expression_7_0= ruleexpression ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3537:6: ( ( (lv_expression_7_0= ruleexpression ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3537:7: ( (lv_expression_7_0= ruleexpression ) ) ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3537:7: ( (lv_expression_7_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3538:1: (lv_expression_7_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3538:1: (lv_expression_7_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3539:3: lv_expression_7_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getExpressionExpressionParserRuleCall_4_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleStateEntity6399);
                    lv_expression_7_0=ruleexpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateEntityRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_7_0, 
                    	        		"expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleStateEntity6409); 

                            createLeafNode(grammarAccess.getStateEntityAccess().getSemicolonKeyword_4_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateEntity


    // $ANTLR start entryRuleTransition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3573:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3574:2: (iv_ruleTransition= ruleTransition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3575:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition6446);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition6456); 

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
    // $ANTLR end entryRuleTransition


    // $ANTLR start ruleTransition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3582:1: ruleTransition returns [EObject current=null] : ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        EObject this_Guard_0 = null;

        EObject lv_events_1_0 = null;

        EObject lv_a_3_0 = null;

        AntlrDatatypeRuleToken lv_stateName_4_0 = null;

        EObject this_EventDefinition_6 = null;

        EObject lv_g_7_0 = null;

        EObject lv_a_9_0 = null;

        AntlrDatatypeRuleToken lv_stateName_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3587:6: ( ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3588:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3588:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==78) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_ID||LA65_0==70||LA65_0==73) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3588:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) )", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3588:2: (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3588:2: (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3589:5: this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';'
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getGuardParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGuard_in_ruleTransition6504);
                    this_Guard_0=ruleGuard();
                    _fsp--;

                     
                            current = this_Guard_0; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3597:1: ( (lv_events_1_0= ruleEventDefinition ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3598:1: (lv_events_1_0= ruleEventDefinition )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3598:1: (lv_events_1_0= ruleEventDefinition )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3599:3: lv_events_1_0= ruleEventDefinition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getEventsEventDefinitionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleTransition6524);
                    lv_events_1_0=ruleEventDefinition();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"events",
                    	        		lv_events_1_0, 
                    	        		"EventDefinition", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,40,FOLLOW_40_in_ruleTransition6534); 

                            createLeafNode(grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3625:1: ( (lv_a_3_0= ruleAction ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==74) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3626:1: (lv_a_3_0= ruleAction )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3626:1: (lv_a_3_0= ruleAction )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3627:3: lv_a_3_0= ruleAction
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getAActionParserRuleCall_0_3_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAction_in_ruleTransition6555);
                            lv_a_3_0=ruleAction();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"a",
                            	        		lv_a_3_0, 
                            	        		"Action", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3649:3: ( (lv_stateName_4_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3650:1: (lv_stateName_4_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3650:1: (lv_stateName_4_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3651:3: lv_stateName_4_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getStateNameExtendedIDParserRuleCall_0_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleTransition6577);
                    lv_stateName_4_0=ruleextendedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stateName",
                    	        		lv_stateName_4_0, 
                    	        		"extendedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleTransition6587); 

                            createLeafNode(grammarAccess.getTransitionAccess().getSemicolonKeyword_0_5(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3678:6: (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3678:6: (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3679:5: this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';'
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getEventDefinitionParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleTransition6617);
                    this_EventDefinition_6=ruleEventDefinition();
                    _fsp--;

                     
                            current = this_EventDefinition_6; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3687:1: ( (lv_g_7_0= ruleGuard ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==78) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3688:1: (lv_g_7_0= ruleGuard )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3688:1: (lv_g_7_0= ruleGuard )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3689:3: lv_g_7_0= ruleGuard
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getGGuardParserRuleCall_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleGuard_in_ruleTransition6637);
                            lv_g_7_0=ruleGuard();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"g",
                            	        		lv_g_7_0, 
                            	        		"Guard", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,40,FOLLOW_40_in_ruleTransition6648); 

                            createLeafNode(grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_1_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3715:1: ( (lv_a_9_0= ruleAction ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==74) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3716:1: (lv_a_9_0= ruleAction )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3716:1: (lv_a_9_0= ruleAction )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3717:3: lv_a_9_0= ruleAction
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getAActionParserRuleCall_1_3_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAction_in_ruleTransition6669);
                            lv_a_9_0=ruleAction();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"a",
                            	        		lv_a_9_0, 
                            	        		"Action", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3739:3: ( (lv_stateName_10_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3740:1: (lv_stateName_10_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3740:1: (lv_stateName_10_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3741:3: lv_stateName_10_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getStateNameExtendedIDParserRuleCall_1_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleTransition6691);
                    lv_stateName_10_0=ruleextendedID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stateName",
                    	        		lv_stateName_10_0, 
                    	        		"extendedID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleTransition6701); 

                            createLeafNode(grammarAccess.getTransitionAccess().getSemicolonKeyword_1_5(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTransition


    // $ANTLR start entryRuleEventDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3775:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3776:2: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3777:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition6738);
            iv_ruleEventDefinition=ruleEventDefinition();
            _fsp--;

             current =iv_ruleEventDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDefinition6748); 

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
    // $ANTLR end entryRuleEventDefinition


    // $ANTLR start ruleEventDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3784:1: ruleEventDefinition returns [EObject current=null] : ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_eventID_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3789:6: ( ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3790:1: ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3790:1: ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt66=1;
                }
                break;
            case 73:
                {
                alt66=2;
                }
                break;
            case RULE_ID:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3790:1: ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) )", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3790:2: ( () ruleTimedEvent )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3790:2: ( () ruleTimedEvent )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3790:3: () ruleTimedEvent
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3790:3: ()
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3791:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getEventDefinitionAccess().getEventDefinitionAction_0_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getEventDefinitionAccess().getEventDefinitionAction_0_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                     
                            currentNode=createCompositeNode(grammarAccess.getEventDefinitionAccess().getTimedEventParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimedEvent_in_ruleEventDefinition6799);
                    ruleTimedEvent();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3810:6: ( () ruleWaitEvent )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3810:6: ( () ruleWaitEvent )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3810:7: () ruleWaitEvent
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3810:7: ()
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3811:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getEventDefinitionAccess().getEventDefinitionAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getEventDefinitionAccess().getEventDefinitionAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                     
                            currentNode=createCompositeNode(grammarAccess.getEventDefinitionAccess().getWaitEventParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWaitEvent_in_ruleEventDefinition6831);
                    ruleWaitEvent();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:6: ( (lv_eventID_4_0= RULE_ID ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:6: ( (lv_eventID_4_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3831:1: (lv_eventID_4_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3831:1: (lv_eventID_4_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3832:3: lv_eventID_4_0= RULE_ID
                    {
                    lv_eventID_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDefinition6854); 

                    			createLeafNode(grammarAccess.getEventDefinitionAccess().getEventIDIDTerminalRuleCall_2_0(), "eventID"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEventDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"eventID",
                    	        		lv_eventID_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEventDefinition


    // $ANTLR start entryRuleTimedEvent
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3862:1: entryRuleTimedEvent returns [String current=null] : iv_ruleTimedEvent= ruleTimedEvent EOF ;
    public final String entryRuleTimedEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimedEvent = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3863:2: (iv_ruleTimedEvent= ruleTimedEvent EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3864:2: iv_ruleTimedEvent= ruleTimedEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimedEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimedEvent_in_entryRuleTimedEvent6896);
            iv_ruleTimedEvent=ruleTimedEvent();
            _fsp--;

             current =iv_ruleTimedEvent.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimedEvent6907); 

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
    // $ANTLR end entryRuleTimedEvent


    // $ANTLR start ruleTimedEvent
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3871:1: ruleTimedEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleTimedEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3876:6: ( (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3877:1: (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3877:1: (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3878:2: kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,70,FOLLOW_70_in_ruleTimedEvent6945); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getTimedEventAccess().getAfterEveryKeyword_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,71,FOLLOW_71_in_ruleTimedEvent6958); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getTimedEventAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3889:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_INT) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_ID) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3889:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3889:6: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimedEvent6974); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getTimedEventAccess().getINTTerminalRuleCall_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3897:10: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTimedEvent7000); 

                    		current.merge(this_ID_3);
                        
                     
                        createLeafNode(grammarAccess.getTimedEventAccess().getIDTerminalRuleCall_2_1(), null); 
                        

                    }
                    break;

            }

            kw=(Token)input.LT(1);
            match(input,72,FOLLOW_72_in_ruleTimedEvent7019); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getTimedEventAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTimedEvent


    // $ANTLR start entryRuleWaitEvent
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3918:1: entryRuleWaitEvent returns [String current=null] : iv_ruleWaitEvent= ruleWaitEvent EOF ;
    public final String entryRuleWaitEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWaitEvent = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3919:2: (iv_ruleWaitEvent= ruleWaitEvent EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3920:2: iv_ruleWaitEvent= ruleWaitEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWaitEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleWaitEvent_in_entryRuleWaitEvent7060);
            iv_ruleWaitEvent=ruleWaitEvent();
            _fsp--;

             current =iv_ruleWaitEvent.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWaitEvent7071); 

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
    // $ANTLR end entryRuleWaitEvent


    // $ANTLR start ruleWaitEvent
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3927:1: ruleWaitEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleWaitEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3932:6: ( (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3933:1: (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3933:1: (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3934:2: kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,73,FOLLOW_73_in_ruleWaitEvent7109); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getWaitEventAccess().getWaitKeyword_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,71,FOLLOW_71_in_ruleWaitEvent7122); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getWaitEventAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3945:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_INT) ) {
                alt68=1;
            }
            else if ( (LA68_0==RULE_ID) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3945:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3945:6: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleWaitEvent7138); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getWaitEventAccess().getINTTerminalRuleCall_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3953:10: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWaitEvent7164); 

                    		current.merge(this_ID_3);
                        
                     
                        createLeafNode(grammarAccess.getWaitEventAccess().getIDTerminalRuleCall_2_1(), null); 
                        

                    }
                    break;

            }

            kw=(Token)input.LT(1);
            match(input,72,FOLLOW_72_in_ruleWaitEvent7183); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getWaitEventAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleWaitEvent


    // $ANTLR start entryRuleAction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3974:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3975:2: (iv_ruleAction= ruleAction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3976:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction7223);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction7233); 

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
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3983:1: ruleAction returns [EObject current=null] : ( '/' ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject lv_code_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3988:6: ( ( '/' ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3989:1: ( '/' ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3989:1: ( '/' ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3989:3: '/' ( (lv_code_1_0= ruleblock ) )
            {
            match(input,74,FOLLOW_74_in_ruleAction7268); 

                    createLeafNode(grammarAccess.getActionAccess().getSolidusKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3993:1: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3994:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3994:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3995:3: lv_code_1_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getCodeBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleAction7289);
            lv_code_1_0=ruleblock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"code",
            	        		lv_code_1_0, 
            	        		"block", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleEntryOrExitAction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4025:1: entryRuleEntryOrExitAction returns [EObject current=null] : iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF ;
    public final EObject entryRuleEntryOrExitAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryOrExitAction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4026:2: (iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4027:2: iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryOrExitActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryOrExitAction_in_entryRuleEntryOrExitAction7325);
            iv_ruleEntryOrExitAction=ruleEntryOrExitAction();
            _fsp--;

             current =iv_ruleEntryOrExitAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryOrExitAction7335); 

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
    // $ANTLR end entryRuleEntryOrExitAction


    // $ANTLR start ruleEntryOrExitAction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4034:1: ruleEntryOrExitAction returns [EObject current=null] : ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) ) ;
    public final EObject ruleEntryOrExitAction() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        EObject lv_code_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4039:6: ( ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4040:1: ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4040:1: ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4040:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4040:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==75) ) {
                alt69=1;
            }
            else if ( (LA69_0==76) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4040:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) )", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4040:3: ( (lv_type_0_0= 'entry' ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4040:3: ( (lv_type_0_0= 'entry' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4041:1: (lv_type_0_0= 'entry' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4041:1: (lv_type_0_0= 'entry' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4042:3: lv_type_0_0= 'entry'
                    {
                    lv_type_0_0=(Token)input.LT(1);
                    match(input,75,FOLLOW_75_in_ruleEntryOrExitAction7379); 

                            createLeafNode(grammarAccess.getEntryOrExitActionAccess().getTypeEntryKeyword_0_0_0(), "type"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEntryOrExitActionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_0_0, "entry", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4062:6: ( (lv_type_1_0= 'exit' ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4062:6: ( (lv_type_1_0= 'exit' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4063:1: (lv_type_1_0= 'exit' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4063:1: (lv_type_1_0= 'exit' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4064:3: lv_type_1_0= 'exit'
                    {
                    lv_type_1_0=(Token)input.LT(1);
                    match(input,76,FOLLOW_76_in_ruleEntryOrExitAction7416); 

                            createLeafNode(grammarAccess.getEntryOrExitActionAccess().getTypeExitKeyword_0_1_0(), "type"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEntryOrExitActionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_1_0, "exit", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,74,FOLLOW_74_in_ruleEntryOrExitAction7440); 

                    createLeafNode(grammarAccess.getEntryOrExitActionAccess().getSolidusKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4087:1: ( (lv_code_3_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4088:1: (lv_code_3_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4088:1: (lv_code_3_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4089:3: lv_code_3_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEntryOrExitActionAccess().getCodeBlockParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleEntryOrExitAction7461);
            lv_code_3_0=ruleblock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntryOrExitActionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"code",
            	        		lv_code_3_0, 
            	        		"block", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEntryOrExitAction


    // $ANTLR start entryRuleActivity
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4119:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
    public final EObject entryRuleActivity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivity = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4120:2: (iv_ruleActivity= ruleActivity EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4121:2: iv_ruleActivity= ruleActivity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActivityRule(), currentNode); 
            pushFollow(FOLLOW_ruleActivity_in_entryRuleActivity7497);
            iv_ruleActivity=ruleActivity();
            _fsp--;

             current =iv_ruleActivity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivity7507); 

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
    // $ANTLR end entryRuleActivity


    // $ANTLR start ruleActivity
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4128:1: ruleActivity returns [EObject current=null] : ( 'do' ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject ruleActivity() throws RecognitionException {
        EObject current = null;

        EObject lv_code_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4133:6: ( ( 'do' ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4134:1: ( 'do' ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4134:1: ( 'do' ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4134:3: 'do' ( (lv_code_1_0= ruleblock ) )
            {
            match(input,77,FOLLOW_77_in_ruleActivity7542); 

                    createLeafNode(grammarAccess.getActivityAccess().getDoKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4138:1: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4139:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4139:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4140:3: lv_code_1_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActivityAccess().getCodeBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleActivity7563);
            lv_code_1_0=ruleblock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActivityRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"code",
            	        		lv_code_1_0, 
            	        		"block", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleActivity


    // $ANTLR start entryRuleGuard
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4170:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4171:2: (iv_ruleGuard= ruleGuard EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4172:2: iv_ruleGuard= ruleGuard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard7599);
            iv_ruleGuard=ruleGuard();
            _fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard7609); 

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
    // $ANTLR end entryRuleGuard


    // $ANTLR start ruleGuard
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4179:1: ruleGuard returns [EObject current=null] : ( '[' this_GuardCode_1= ruleGuardCode ']' ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        EObject this_GuardCode_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4184:6: ( ( '[' this_GuardCode_1= ruleGuardCode ']' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4185:1: ( '[' this_GuardCode_1= ruleGuardCode ']' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4185:1: ( '[' this_GuardCode_1= ruleGuardCode ']' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4185:3: '[' this_GuardCode_1= ruleGuardCode ']'
            {
            match(input,78,FOLLOW_78_in_ruleGuard7644); 

                    createLeafNode(grammarAccess.getGuardAccess().getLeftSquareBracketKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getGuardAccess().getGuardCodeParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleGuardCode_in_ruleGuard7666);
            this_GuardCode_1=ruleGuardCode();
            _fsp--;

             
                    current = this_GuardCode_1; 
                    currentNode = currentNode.getParent();
                
            match(input,79,FOLLOW_79_in_ruleGuard7675); 

                    createLeafNode(grammarAccess.getGuardAccess().getRightSquareBracketKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGuard


    // $ANTLR start entryRuleGuardCode
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4210:1: entryRuleGuardCode returns [EObject current=null] : iv_ruleGuardCode= ruleGuardCode EOF ;
    public final EObject entryRuleGuardCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardCode = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4211:2: (iv_ruleGuardCode= ruleGuardCode EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4212:2: iv_ruleGuardCode= ruleGuardCode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardCodeRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuardCode_in_entryRuleGuardCode7711);
            iv_ruleGuardCode=ruleGuardCode();
            _fsp--;

             current =iv_ruleGuardCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardCode7721); 

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
    // $ANTLR end entryRuleGuardCode


    // $ANTLR start ruleGuardCode
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4219:1: ruleGuardCode returns [EObject current=null] : ( (lv_nativeExpression_0_0= ruleblock ) ) ;
    public final EObject ruleGuardCode() throws RecognitionException {
        EObject current = null;

        EObject lv_nativeExpression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4224:6: ( ( (lv_nativeExpression_0_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4225:1: ( (lv_nativeExpression_0_0= ruleblock ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4225:1: ( (lv_nativeExpression_0_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4226:1: (lv_nativeExpression_0_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4226:1: (lv_nativeExpression_0_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4227:3: lv_nativeExpression_0_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGuardCodeAccess().getNativeExpressionBlockParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleGuardCode7766);
            lv_nativeExpression_0_0=ruleblock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGuardCodeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"nativeExpression",
            	        		lv_nativeExpression_0_0, 
            	        		"block", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGuardCode


    // $ANTLR start entryRulePosition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4257:1: entryRulePosition returns [EObject current=null] : iv_rulePosition= rulePosition EOF ;
    public final EObject entryRulePosition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePosition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4258:2: (iv_rulePosition= rulePosition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4259:2: iv_rulePosition= rulePosition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPositionRule(), currentNode); 
            pushFollow(FOLLOW_rulePosition_in_entryRulePosition7801);
            iv_rulePosition=rulePosition();
            _fsp--;

             current =iv_rulePosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePosition7811); 

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
    // $ANTLR end entryRulePosition


    // $ANTLR start rulePosition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4266:1: rulePosition returns [EObject current=null] : ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) ) ;
    public final EObject rulePosition() throws RecognitionException {
        EObject current = null;

        EObject lv_a_0_0 = null;

        EObject lv_c_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4271:6: ( ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4272:1: ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4272:1: ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==81) ) {
                alt70=1;
            }
            else if ( (LA70_0==80) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4272:1: ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) )", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4272:2: ( (lv_a_0_0= ruleAssociationPosition ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4272:2: ( (lv_a_0_0= ruleAssociationPosition ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4273:1: (lv_a_0_0= ruleAssociationPosition )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4273:1: (lv_a_0_0= ruleAssociationPosition )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4274:3: lv_a_0_0= ruleAssociationPosition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPositionAccess().getAAssociationPositionParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAssociationPosition_in_rulePosition7857);
                    lv_a_0_0=ruleAssociationPosition();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPositionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"a",
                    	        		lv_a_0_0, 
                    	        		"AssociationPosition", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4297:6: ( (lv_c_1_0= ruleClassPosition ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4297:6: ( (lv_c_1_0= ruleClassPosition ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4298:1: (lv_c_1_0= ruleClassPosition )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4298:1: (lv_c_1_0= ruleClassPosition )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4299:3: lv_c_1_0= ruleClassPosition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPositionAccess().getCClassPositionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleClassPosition_in_rulePosition7884);
                    lv_c_1_0=ruleClassPosition();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPositionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"c",
                    	        		lv_c_1_0, 
                    	        		"ClassPosition", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePosition


    // $ANTLR start entryRuleClassPosition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4329:1: entryRuleClassPosition returns [EObject current=null] : iv_ruleClassPosition= ruleClassPosition EOF ;
    public final EObject entryRuleClassPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassPosition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4330:2: (iv_ruleClassPosition= ruleClassPosition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4331:2: iv_ruleClassPosition= ruleClassPosition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getClassPositionRule(), currentNode); 
            pushFollow(FOLLOW_ruleClassPosition_in_entryRuleClassPosition7920);
            iv_ruleClassPosition=ruleClassPosition();
            _fsp--;

             current =iv_ruleClassPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassPosition7930); 

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
    // $ANTLR end entryRuleClassPosition


    // $ANTLR start ruleClassPosition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4338:1: ruleClassPosition returns [EObject current=null] : ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' ) ;
    public final EObject ruleClassPosition() throws RecognitionException {
        EObject current = null;

        Token lv_x_1_0=null;
        Token lv_y_2_0=null;
        Token lv_width_3_0=null;
        Token lv_height_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4343:6: ( ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4344:1: ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4344:1: ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4344:3: 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';'
            {
            match(input,80,FOLLOW_80_in_ruleClassPosition7965); 

                    createLeafNode(grammarAccess.getClassPositionAccess().getPositionKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4348:1: ( (lv_x_1_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4349:1: (lv_x_1_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4349:1: (lv_x_1_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4350:3: lv_x_1_0= RULE_INT
            {
            lv_x_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition7982); 

            			createLeafNode(grammarAccess.getClassPositionAccess().getXINTTerminalRuleCall_1_0(), "x"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getClassPositionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"x",
            	        		lv_x_1_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4372:2: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4373:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4373:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4374:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition8004); 

            			createLeafNode(grammarAccess.getClassPositionAccess().getYINTTerminalRuleCall_2_0(), "y"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getClassPositionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"y",
            	        		lv_y_2_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4396:2: ( (lv_width_3_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4397:1: (lv_width_3_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4397:1: (lv_width_3_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4398:3: lv_width_3_0= RULE_INT
            {
            lv_width_3_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition8026); 

            			createLeafNode(grammarAccess.getClassPositionAccess().getWidthINTTerminalRuleCall_3_0(), "width"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getClassPositionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"width",
            	        		lv_width_3_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4420:2: ( (lv_height_4_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4421:1: (lv_height_4_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4421:1: (lv_height_4_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4422:3: lv_height_4_0= RULE_INT
            {
            lv_height_4_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition8048); 

            			createLeafNode(grammarAccess.getClassPositionAccess().getHeightINTTerminalRuleCall_4_0(), "height"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getClassPositionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"height",
            	        		lv_height_4_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleClassPosition8063); 

                    createLeafNode(grammarAccess.getClassPositionAccess().getSemicolonKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleClassPosition


    // $ANTLR start entryRuleAssociationPosition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4456:1: entryRuleAssociationPosition returns [EObject current=null] : iv_ruleAssociationPosition= ruleAssociationPosition EOF ;
    public final EObject entryRuleAssociationPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationPosition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4457:2: (iv_ruleAssociationPosition= ruleAssociationPosition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4458:2: iv_ruleAssociationPosition= ruleAssociationPosition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociationPositionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition8099);
            iv_ruleAssociationPosition=ruleAssociationPosition();
            _fsp--;

             current =iv_ruleAssociationPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationPosition8109); 

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
    // $ANTLR end entryRuleAssociationPosition


    // $ANTLR start ruleAssociationPosition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4465:1: ruleAssociationPosition returns [EObject current=null] : ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' ) ;
    public final EObject ruleAssociationPosition() throws RecognitionException {
        EObject current = null;

        Token lv_index_1_0=null;
        EObject lv_c1_2_0 = null;

        EObject lv_c2_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4470:6: ( ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4471:1: ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4471:1: ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4471:3: 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';'
            {
            match(input,81,FOLLOW_81_in_ruleAssociationPosition8144); 

                    createLeafNode(grammarAccess.getAssociationPositionAccess().getPositionAssociationKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4475:1: ( (lv_index_1_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4476:1: (lv_index_1_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4476:1: (lv_index_1_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4477:3: lv_index_1_0= RULE_INT
            {
            lv_index_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssociationPosition8161); 

            			createLeafNode(grammarAccess.getAssociationPositionAccess().getIndexINTTerminalRuleCall_1_0(), "index"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssociationPositionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"index",
            	        		lv_index_1_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4499:2: ( (lv_c1_2_0= ruleCoordinate ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4500:1: (lv_c1_2_0= ruleCoordinate )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4500:1: (lv_c1_2_0= ruleCoordinate )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4501:3: lv_c1_2_0= ruleCoordinate
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssociationPositionAccess().getC1CoordinateParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition8187);
            lv_c1_2_0=ruleCoordinate();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssociationPositionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"c1",
            	        		lv_c1_2_0, 
            	        		"Coordinate", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4523:2: ( (lv_c2_3_0= ruleCoordinate ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4524:1: (lv_c2_3_0= ruleCoordinate )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4524:1: (lv_c2_3_0= ruleCoordinate )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4525:3: lv_c2_3_0= ruleCoordinate
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssociationPositionAccess().getC2CoordinateParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition8208);
            lv_c2_3_0=ruleCoordinate();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssociationPositionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"c2",
            	        		lv_c2_3_0, 
            	        		"Coordinate", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleAssociationPosition8218); 

                    createLeafNode(grammarAccess.getAssociationPositionAccess().getSemicolonKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssociationPosition


    // $ANTLR start entryRuleCoordinate
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4559:1: entryRuleCoordinate returns [EObject current=null] : iv_ruleCoordinate= ruleCoordinate EOF ;
    public final EObject entryRuleCoordinate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinate = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4560:2: (iv_ruleCoordinate= ruleCoordinate EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4561:2: iv_ruleCoordinate= ruleCoordinate EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCoordinateRule(), currentNode); 
            pushFollow(FOLLOW_ruleCoordinate_in_entryRuleCoordinate8254);
            iv_ruleCoordinate=ruleCoordinate();
            _fsp--;

             current =iv_ruleCoordinate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinate8264); 

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
    // $ANTLR end entryRuleCoordinate


    // $ANTLR start ruleCoordinate
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4568:1: ruleCoordinate returns [EObject current=null] : ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) ) ;
    public final EObject ruleCoordinate() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token lv_y_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4573:6: ( ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4574:1: ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4574:1: ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4574:2: ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4574:2: ( (lv_x_0_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4575:1: (lv_x_0_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4575:1: (lv_x_0_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4576:3: lv_x_0_0= RULE_INT
            {
            lv_x_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate8306); 

            			createLeafNode(grammarAccess.getCoordinateAccess().getXINTTerminalRuleCall_0_0(), "x"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCoordinateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"x",
            	        		lv_x_0_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,28,FOLLOW_28_in_ruleCoordinate8321); 

                    createLeafNode(grammarAccess.getCoordinateAccess().getCommaKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4602:1: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4603:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4603:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4604:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate8338); 

            			createLeafNode(grammarAccess.getCoordinateAccess().getYINTTerminalRuleCall_2_0(), "y"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCoordinateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"y",
            	        		lv_y_2_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCoordinate


    // $ANTLR start entryRuleTraceDirective
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4634:1: entryRuleTraceDirective returns [EObject current=null] : iv_ruleTraceDirective= ruleTraceDirective EOF ;
    public final EObject entryRuleTraceDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTraceDirective = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4635:2: (iv_ruleTraceDirective= ruleTraceDirective EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4636:2: iv_ruleTraceDirective= ruleTraceDirective EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTraceDirectiveRule(), currentNode); 
            pushFollow(FOLLOW_ruleTraceDirective_in_entryRuleTraceDirective8379);
            iv_ruleTraceDirective=ruleTraceDirective();
            _fsp--;

             current =iv_ruleTraceDirective; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTraceDirective8389); 

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
    // $ANTLR end entryRuleTraceDirective


    // $ANTLR start ruleTraceDirective
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4643:1: ruleTraceDirective returns [EObject current=null] : ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? ) ;
    public final EObject ruleTraceDirective() throws RecognitionException {
        EObject current = null;

        Token lv_traceStart_0_1=null;
        Token lv_traceStart_0_2=null;
        Token lv_elementPattern_3_0=null;
        EObject lv_modelElement_1_0 = null;

        EObject lv_conditionRHS_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4648:6: ( ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4649:1: ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4649:1: ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4649:2: ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4649:2: ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4650:1: ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4650:1: ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4651:1: (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4651:1: (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==82) ) {
                alt71=1;
            }
            else if ( (LA71_0==83) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4651:1: (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' )", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4652:3: lv_traceStart_0_1= 'trace'
                    {
                    lv_traceStart_0_1=(Token)input.LT(1);
                    match(input,82,FOLLOW_82_in_ruleTraceDirective8434); 

                            createLeafNode(grammarAccess.getTraceDirectiveAccess().getTraceStartTraceKeyword_0_0_0(), "traceStart"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTraceDirectiveRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "traceStart", lv_traceStart_0_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4670:8: lv_traceStart_0_2= 'Trace'
                    {
                    lv_traceStart_0_2=(Token)input.LT(1);
                    match(input,83,FOLLOW_83_in_ruleTraceDirective8463); 

                            createLeafNode(grammarAccess.getTraceDirectiveAccess().getTraceStartTraceKeyword_0_0_1(), "traceStart"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTraceDirectiveRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "traceStart", lv_traceStart_0_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4691:2: ( (lv_modelElement_1_0= ruleModelElement ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4692:1: (lv_modelElement_1_0= ruleModelElement )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4692:1: (lv_modelElement_1_0= ruleModelElement )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4693:3: lv_modelElement_1_0= ruleModelElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTraceDirectiveAccess().getModelElementModelElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModelElement_in_ruleTraceDirective8500);
            lv_modelElement_1_0=ruleModelElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTraceDirectiveRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"modelElement",
            	        		lv_modelElement_1_0, 
            	        		"ModelElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4715:2: ( (lv_conditionRHS_2_0= ruleConditionRHS ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=87 && LA72_0<=91)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4716:1: (lv_conditionRHS_2_0= ruleConditionRHS )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4716:1: (lv_conditionRHS_2_0= ruleConditionRHS )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4717:3: lv_conditionRHS_2_0= ruleConditionRHS
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTraceDirectiveAccess().getConditionRHSConditionRHSParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleConditionRHS_in_ruleTraceDirective8521);
                    lv_conditionRHS_2_0=ruleConditionRHS();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTraceDirectiveRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"conditionRHS",
                    	        		lv_conditionRHS_2_0, 
                    	        		"ConditionRHS", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4739:3: ( (lv_elementPattern_3_0= '*' ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==46) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4740:1: (lv_elementPattern_3_0= '*' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4740:1: (lv_elementPattern_3_0= '*' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4741:3: lv_elementPattern_3_0= '*'
                    {
                    lv_elementPattern_3_0=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_ruleTraceDirective8540); 

                            createLeafNode(grammarAccess.getTraceDirectiveAccess().getElementPatternAsteriskKeyword_3_0(), "elementPattern"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTraceDirectiveRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "elementPattern", lv_elementPattern_3_0, "*", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTraceDirective


    // $ANTLR start entryRuleTraceCase
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4768:1: entryRuleTraceCase returns [EObject current=null] : iv_ruleTraceCase= ruleTraceCase EOF ;
    public final EObject entryRuleTraceCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTraceCase = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4769:2: (iv_ruleTraceCase= ruleTraceCase EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4770:2: iv_ruleTraceCase= ruleTraceCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTraceCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleTraceCase_in_entryRuleTraceCase8590);
            iv_ruleTraceCase=ruleTraceCase();
            _fsp--;

             current =iv_ruleTraceCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTraceCase8600); 

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
    // $ANTLR end entryRuleTraceCase


    // $ANTLR start ruleTraceCase
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4777:1: ruleTraceCase returns [EObject current=null] : ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' ) ;
    public final EObject ruleTraceCase() throws RecognitionException {
        EObject current = null;

        Token lv_traceCaseName_1_0=null;
        EObject lv_traceDirective_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4782:6: ( ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4783:1: ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4783:1: ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4783:3: 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}'
            {
            match(input,84,FOLLOW_84_in_ruleTraceCase8635); 

                    createLeafNode(grammarAccess.getTraceCaseAccess().getTracecaseKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4787:1: ( (lv_traceCaseName_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4788:1: (lv_traceCaseName_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4788:1: (lv_traceCaseName_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4789:3: lv_traceCaseName_1_0= RULE_ID
            {
            lv_traceCaseName_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTraceCase8652); 

            			createLeafNode(grammarAccess.getTraceCaseAccess().getTraceCaseNameIDTerminalRuleCall_1_0(), "traceCaseName"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTraceCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"traceCaseName",
            	        		lv_traceCaseName_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleTraceCase8667); 

                    createLeafNode(grammarAccess.getTraceCaseAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4815:1: ( (lv_traceDirective_3_0= ruleTraceDirective ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=82 && LA74_0<=83)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4816:1: (lv_traceDirective_3_0= ruleTraceDirective )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4816:1: (lv_traceDirective_3_0= ruleTraceDirective )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4817:3: lv_traceDirective_3_0= ruleTraceDirective
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTraceCaseAccess().getTraceDirectiveTraceDirectiveParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTraceDirective_in_ruleTraceCase8688);
            	    lv_traceDirective_3_0=ruleTraceDirective();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTraceCaseRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"traceDirective",
            	    	        		lv_traceDirective_3_0, 
            	    	        		"TraceDirective", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleTraceCase8699); 

                    createLeafNode(grammarAccess.getTraceCaseAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTraceCase


    // $ANTLR start entryRuleCompoundTraceCondition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4855:1: entryRuleCompoundTraceCondition returns [EObject current=null] : iv_ruleCompoundTraceCondition= ruleCompoundTraceCondition EOF ;
    public final EObject entryRuleCompoundTraceCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundTraceCondition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4856:2: (iv_ruleCompoundTraceCondition= ruleCompoundTraceCondition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4857:2: iv_ruleCompoundTraceCondition= ruleCompoundTraceCondition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCompoundTraceConditionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCompoundTraceCondition_in_entryRuleCompoundTraceCondition8739);
            iv_ruleCompoundTraceCondition=ruleCompoundTraceCondition();
            _fsp--;

             current =iv_ruleCompoundTraceCondition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompoundTraceCondition8749); 

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
    // $ANTLR end entryRuleCompoundTraceCondition


    // $ANTLR start ruleCompoundTraceCondition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4864:1: ruleCompoundTraceCondition returns [EObject current=null] : ( (lv_operand_0_0= RULE_STRING ) ) ;
    public final EObject ruleCompoundTraceCondition() throws RecognitionException {
        EObject current = null;

        Token lv_operand_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4869:6: ( ( (lv_operand_0_0= RULE_STRING ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4870:1: ( (lv_operand_0_0= RULE_STRING ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4870:1: ( (lv_operand_0_0= RULE_STRING ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4871:1: (lv_operand_0_0= RULE_STRING )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4871:1: (lv_operand_0_0= RULE_STRING )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4872:3: lv_operand_0_0= RULE_STRING
            {
            lv_operand_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCompoundTraceCondition8790); 

            			createLeafNode(grammarAccess.getCompoundTraceConditionAccess().getOperandSTRINGTerminalRuleCall_0(), "operand"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCompoundTraceConditionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCompoundTraceCondition


    // $ANTLR start entryRuleSimpleTraceCondition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4902:1: entryRuleSimpleTraceCondition returns [EObject current=null] : iv_ruleSimpleTraceCondition= ruleSimpleTraceCondition EOF ;
    public final EObject entryRuleSimpleTraceCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTraceCondition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4903:2: (iv_ruleSimpleTraceCondition= ruleSimpleTraceCondition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4904:2: iv_ruleSimpleTraceCondition= ruleSimpleTraceCondition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleTraceConditionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleTraceCondition_in_entryRuleSimpleTraceCondition8830);
            iv_ruleSimpleTraceCondition=ruleSimpleTraceCondition();
            _fsp--;

             current =iv_ruleSimpleTraceCondition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleTraceCondition8840); 

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
    // $ANTLR end entryRuleSimpleTraceCondition


    // $ANTLR start ruleSimpleTraceCondition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4911:1: ruleSimpleTraceCondition returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) ) ;
    public final EObject ruleSimpleTraceCondition() throws RecognitionException {
        EObject current = null;

        EObject lv_lhs_0_0 = null;

        EObject lv_conditionRHS_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4916:6: ( ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4917:1: ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4917:1: ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4917:2: ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4917:2: ( (lv_lhs_0_0= ruleModelElement ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4918:1: (lv_lhs_0_0= ruleModelElement )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4918:1: (lv_lhs_0_0= ruleModelElement )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4919:3: lv_lhs_0_0= ruleModelElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSimpleTraceConditionAccess().getLhsModelElementParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModelElement_in_ruleSimpleTraceCondition8886);
            lv_lhs_0_0=ruleModelElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleTraceConditionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"lhs",
            	        		lv_lhs_0_0, 
            	        		"ModelElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4941:2: ( (lv_conditionRHS_1_0= ruleConditionRHS ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4942:1: (lv_conditionRHS_1_0= ruleConditionRHS )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4942:1: (lv_conditionRHS_1_0= ruleConditionRHS )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4943:3: lv_conditionRHS_1_0= ruleConditionRHS
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSimpleTraceConditionAccess().getConditionRHSConditionRHSParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionRHS_in_ruleSimpleTraceCondition8907);
            lv_conditionRHS_1_0=ruleConditionRHS();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleTraceConditionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"conditionRHS",
            	        		lv_conditionRHS_1_0, 
            	        		"ConditionRHS", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSimpleTraceCondition


    // $ANTLR start entryRuleConditionRHS
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4973:1: entryRuleConditionRHS returns [EObject current=null] : iv_ruleConditionRHS= ruleConditionRHS EOF ;
    public final EObject entryRuleConditionRHS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionRHS = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4974:2: (iv_ruleConditionRHS= ruleConditionRHS EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4975:2: iv_ruleConditionRHS= ruleConditionRHS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionRHSRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionRHS_in_entryRuleConditionRHS8943);
            iv_ruleConditionRHS=ruleConditionRHS();
            _fsp--;

             current =iv_ruleConditionRHS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionRHS8953); 

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
    // $ANTLR end entryRuleConditionRHS


    // $ANTLR start ruleConditionRHS
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4982:1: ruleConditionRHS returns [EObject current=null] : ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) ) ;
    public final EObject ruleConditionRHS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operand_0_0 = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4987:6: ( ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4988:1: ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4988:1: ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4988:2: ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4988:2: ( (lv_operand_0_0= ruleComparisonOperator ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4989:1: (lv_operand_0_0= ruleComparisonOperator )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4989:1: (lv_operand_0_0= ruleComparisonOperator )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4990:3: lv_operand_0_0= ruleComparisonOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionRHSAccess().getOperandComparisonOperatorParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleComparisonOperator_in_ruleConditionRHS8999);
            lv_operand_0_0=ruleComparisonOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionRHSRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_0_0, 
            	        		"ComparisonOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5012:2: ( (lv_value_1_0= rulePrimitiveType ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5013:1: (lv_value_1_0= rulePrimitiveType )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5013:1: (lv_value_1_0= rulePrimitiveType )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5014:3: lv_value_1_0= rulePrimitiveType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionRHSAccess().getValuePrimitiveTypeParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimitiveType_in_ruleConditionRHS9020);
            lv_value_1_0=rulePrimitiveType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionRHSRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"PrimitiveType", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleConditionRHS


    // $ANTLR start entryRuleModelElement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5044:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5045:2: (iv_ruleModelElement= ruleModelElement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5046:2: iv_ruleModelElement= ruleModelElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelElement_in_entryRuleModelElement9056);
            iv_ruleModelElement=ruleModelElement();
            _fsp--;

             current =iv_ruleModelElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElement9066); 

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
    // $ANTLR end entryRuleModelElement


    // $ANTLR start ruleModelElement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5053:1: ruleModelElement returns [EObject current=null] : ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token lv_executeOnEntry_0_0=null;
        Token lv_executeOnExit_1_0=null;
        Token lv_cflow_2_0=null;
        Token lv_aMethod_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5058:6: ( ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=75 && LA76_0<=76)||LA76_0==85) ) {
                alt76=1;
            }
            else if ( (LA76_0==RULE_ID) ) {
                int LA76_2 = input.LA(2);

                if ( (LA76_2==86) ) {
                    alt76=1;
                }
                else if ( (LA76_2==EOF||(LA76_2>=RULE_STRING && LA76_2<=RULE_RUBY_FUNCTION)||LA76_2==18||LA76_2==29||LA76_2==33||LA76_2==36||LA76_2==41||LA76_2==46||(LA76_2>=50 && LA76_2<=51)||(LA76_2>=54 && LA76_2<=61)||LA76_2==63||(LA76_2>=67 && LA76_2<=71)||LA76_2==73||(LA76_2>=75 && LA76_2<=78)||(LA76_2>=80 && LA76_2<=84)||(LA76_2>=87 && LA76_2<=91)||(LA76_2>=99 && LA76_2<=100)||(LA76_2>=102 && LA76_2<=112)||(LA76_2>=124 && LA76_2<=128)) ) {
                    alt76=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("5059:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )", 76, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5059:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:2: ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:2: ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:3: ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:3: ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )?
                    int alt75=4;
                    switch ( input.LA(1) ) {
                        case 75:
                            {
                            alt75=1;
                            }
                            break;
                        case 76:
                            {
                            alt75=2;
                            }
                            break;
                        case 85:
                            {
                            alt75=3;
                            }
                            break;
                    }

                    switch (alt75) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:4: ( (lv_executeOnEntry_0_0= 'entry' ) )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5059:4: ( (lv_executeOnEntry_0_0= 'entry' ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5060:1: (lv_executeOnEntry_0_0= 'entry' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5060:1: (lv_executeOnEntry_0_0= 'entry' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5061:3: lv_executeOnEntry_0_0= 'entry'
                            {
                            lv_executeOnEntry_0_0=(Token)input.LT(1);
                            match(input,75,FOLLOW_75_in_ruleModelElement9111); 

                                    createLeafNode(grammarAccess.getModelElementAccess().getExecuteOnEntryEntryKeyword_0_0_0_0(), "executeOnEntry"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "executeOnEntry", true, "entry", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5081:6: ( (lv_executeOnExit_1_0= 'exit' ) )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5081:6: ( (lv_executeOnExit_1_0= 'exit' ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5082:1: (lv_executeOnExit_1_0= 'exit' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5082:1: (lv_executeOnExit_1_0= 'exit' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5083:3: lv_executeOnExit_1_0= 'exit'
                            {
                            lv_executeOnExit_1_0=(Token)input.LT(1);
                            match(input,76,FOLLOW_76_in_ruleModelElement9148); 

                                    createLeafNode(grammarAccess.getModelElementAccess().getExecuteOnExitExitKeyword_0_0_1_0(), "executeOnExit"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "executeOnExit", true, "exit", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5103:6: ( (lv_cflow_2_0= 'cflow' ) )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5103:6: ( (lv_cflow_2_0= 'cflow' ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5104:1: (lv_cflow_2_0= 'cflow' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5104:1: (lv_cflow_2_0= 'cflow' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5105:3: lv_cflow_2_0= 'cflow'
                            {
                            lv_cflow_2_0=(Token)input.LT(1);
                            match(input,85,FOLLOW_85_in_ruleModelElement9185); 

                                    createLeafNode(grammarAccess.getModelElementAccess().getCflowCflowKeyword_0_0_2_0(), "cflow"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "cflow", true, "cflow", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5124:4: ( (lv_aMethod_3_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5125:1: (lv_aMethod_3_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5125:1: (lv_aMethod_3_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5126:3: lv_aMethod_3_0= RULE_ID
                    {
                    lv_aMethod_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement9217); 

                    			createLeafNode(grammarAccess.getModelElementAccess().getAMethodIDTerminalRuleCall_0_1_0(), "aMethod"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"aMethod",
                    	        		lv_aMethod_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,86,FOLLOW_86_in_ruleModelElement9232); 

                            createLeafNode(grammarAccess.getModelElementAccess().getLeftParenthesisRightParenthesisKeyword_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5153:6: ( ( RULE_ID ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5153:6: ( ( RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5154:1: ( RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5154:1: ( RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5155:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement9257); 

                    		createLeafNode(grammarAccess.getModelElementAccess().getAttributeUmpleAttributeCrossReference_1_0(), "attribute"); 
                    	

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModelElement


    // $ANTLR start entryRuleComparisonOperator
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5175:1: entryRuleComparisonOperator returns [String current=null] : iv_ruleComparisonOperator= ruleComparisonOperator EOF ;
    public final String entryRuleComparisonOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComparisonOperator = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5176:2: (iv_ruleComparisonOperator= ruleComparisonOperator EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5177:2: iv_ruleComparisonOperator= ruleComparisonOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComparisonOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleComparisonOperator_in_entryRuleComparisonOperator9294);
            iv_ruleComparisonOperator=ruleComparisonOperator();
            _fsp--;

             current =iv_ruleComparisonOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparisonOperator9305); 

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
    // $ANTLR end entryRuleComparisonOperator


    // $ANTLR start ruleComparisonOperator
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5184:1: ruleComparisonOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleComparisonOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5189:6: ( (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5190:1: (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5190:1: (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' )
            int alt77=5;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt77=1;
                }
                break;
            case 88:
                {
                alt77=2;
                }
                break;
            case 89:
                {
                alt77=3;
                }
                break;
            case 90:
                {
                alt77=4;
                }
                break;
            case 91:
                {
                alt77=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5190:1: (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' )", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5191:2: kw= '>'
                    {
                    kw=(Token)input.LT(1);
                    match(input,87,FOLLOW_87_in_ruleComparisonOperator9343); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5198:2: kw= '<'
                    {
                    kw=(Token)input.LT(1);
                    match(input,88,FOLLOW_88_in_ruleComparisonOperator9362); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getLessThanSignKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5205:2: kw= '=='
                    {
                    kw=(Token)input.LT(1);
                    match(input,89,FOLLOW_89_in_ruleComparisonOperator9381); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getEqualsSignEqualsSignKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5212:2: kw= '>='
                    {
                    kw=(Token)input.LT(1);
                    match(input,90,FOLLOW_90_in_ruleComparisonOperator9400); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignEqualsSignKeyword_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5219:2: kw= '<='
                    {
                    kw=(Token)input.LT(1);
                    match(input,91,FOLLOW_91_in_ruleComparisonOperator9419); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getLessThanSignEqualsSignKeyword_4(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComparisonOperator


    // $ANTLR start entryRuleTraceMechanism
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5232:1: entryRuleTraceMechanism returns [EObject current=null] : iv_ruleTraceMechanism= ruleTraceMechanism EOF ;
    public final EObject entryRuleTraceMechanism() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTraceMechanism = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5233:2: (iv_ruleTraceMechanism= ruleTraceMechanism EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5234:2: iv_ruleTraceMechanism= ruleTraceMechanism EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTraceMechanismRule(), currentNode); 
            pushFollow(FOLLOW_ruleTraceMechanism_in_entryRuleTraceMechanism9459);
            iv_ruleTraceMechanism=ruleTraceMechanism();
            _fsp--;

             current =iv_ruleTraceMechanism; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTraceMechanism9469); 

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
    // $ANTLR end entryRuleTraceMechanism


    // $ANTLR start ruleTraceMechanism
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5241:1: ruleTraceMechanism returns [EObject current=null] : ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleTraceMechanism() throws RecognitionException {
        EObject current = null;

        Token lv_traceMechanism_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5246:6: ( ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5247:1: ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5247:1: ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5247:3: 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';'
            {
            match(input,92,FOLLOW_92_in_ruleTraceMechanism9504); 

                    createLeafNode(grammarAccess.getTraceMechanismAccess().getTraceUsingKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5251:1: ( (lv_traceMechanism_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5252:1: (lv_traceMechanism_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5252:1: (lv_traceMechanism_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5253:3: lv_traceMechanism_1_0= RULE_ID
            {
            lv_traceMechanism_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTraceMechanism9521); 

            			createLeafNode(grammarAccess.getTraceMechanismAccess().getTraceMechanismIDTerminalRuleCall_1_0(), "traceMechanism"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTraceMechanismRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"traceMechanism",
            	        		lv_traceMechanism_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleTraceMechanism9536); 

                    createLeafNode(grammarAccess.getTraceMechanismAccess().getSemicolonKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTraceMechanism


    // $ANTLR start entryRuleblock
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5287:1: entryRuleblock returns [EObject current=null] : iv_ruleblock= ruleblock EOF ;
    public final EObject entryRuleblock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblock = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5288:2: (iv_ruleblock= ruleblock EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5289:2: iv_ruleblock= ruleblock EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBlockRule(), currentNode); 
            pushFollow(FOLLOW_ruleblock_in_entryRuleblock9572);
            iv_ruleblock=ruleblock();
            _fsp--;

             current =iv_ruleblock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblock9582); 

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
    // $ANTLR end entryRuleblock


    // $ANTLR start ruleblock
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5296:1: ruleblock returns [EObject current=null] : ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' ) ;
    public final EObject ruleblock() throws RecognitionException {
        EObject current = null;

        EObject lv_blocks_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5301:6: ( ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5302:1: ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5302:1: ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5302:3: '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}'
            {
            match(input,17,FOLLOW_17_in_ruleblock9617); 

                    createLeafNode(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5306:1: ( (lv_blocks_1_0= ruleblockStatement ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( ((LA78_0>=RULE_STRING && LA78_0<=RULE_INT)||LA78_0==15||LA78_0==17||LA78_0==29||LA78_0==33||LA78_0==36||LA78_0==41||(LA78_0>=54 && LA78_0<=61)||LA78_0==71||(LA78_0>=99 && LA78_0<=100)||(LA78_0>=102 && LA78_0<=108)||LA78_0==114||(LA78_0>=116 && LA78_0<=120)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5307:1: (lv_blocks_1_0= ruleblockStatement )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5307:1: (lv_blocks_1_0= ruleblockStatement )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5308:3: lv_blocks_1_0= ruleblockStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBlockAccess().getBlocksBlockStatementParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleblockStatement_in_ruleblock9638);
            	    lv_blocks_1_0=ruleblockStatement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBlockRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"blocks",
            	    	        		lv_blocks_1_0, 
            	    	        		"blockStatement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleblock9649); 

                    createLeafNode(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleblock


    // $ANTLR start entryRuleparExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5342:1: entryRuleparExpression returns [EObject current=null] : iv_ruleparExpression= ruleparExpression EOF ;
    public final EObject entryRuleparExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleparExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5343:2: (iv_ruleparExpression= ruleparExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5344:2: iv_ruleparExpression= ruleparExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleparExpression_in_entryRuleparExpression9685);
            iv_ruleparExpression=ruleparExpression();
            _fsp--;

             current =iv_ruleparExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleparExpression9695); 

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
    // $ANTLR end entryRuleparExpression


    // $ANTLR start ruleparExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5351:1: ruleparExpression returns [EObject current=null] : ( '(' this_expression_1= ruleexpression ')' ) ;
    public final EObject ruleparExpression() throws RecognitionException {
        EObject current = null;

        EObject this_expression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5356:6: ( ( '(' this_expression_1= ruleexpression ')' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5357:1: ( '(' this_expression_1= ruleexpression ')' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5357:1: ( '(' this_expression_1= ruleexpression ')' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5357:3: '(' this_expression_1= ruleexpression ')'
            {
            match(input,71,FOLLOW_71_in_ruleparExpression9730); 

                    createLeafNode(grammarAccess.getParExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParExpressionAccess().getExpressionParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleexpression_in_ruleparExpression9752);
            this_expression_1=ruleexpression();
            _fsp--;

             
                    current = this_expression_1; 
                    currentNode = currentNode.getParent();
                
            match(input,72,FOLLOW_72_in_ruleparExpression9761); 

                    createLeafNode(grammarAccess.getParExpressionAccess().getRightParenthesisKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleparExpression


    // $ANTLR start entryRuleassignmentOperator
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5382:1: entryRuleassignmentOperator returns [String current=null] : iv_ruleassignmentOperator= ruleassignmentOperator EOF ;
    public final String entryRuleassignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleassignmentOperator = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5383:2: (iv_ruleassignmentOperator= ruleassignmentOperator EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5384:2: iv_ruleassignmentOperator= ruleassignmentOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator9798);
            iv_ruleassignmentOperator=ruleassignmentOperator();
            _fsp--;

             current =iv_ruleassignmentOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleassignmentOperator9809); 

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
    // $ANTLR end entryRuleassignmentOperator


    // $ANTLR start ruleassignmentOperator
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5391:1: ruleassignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' | kw= '-=' ) ;
    public final AntlrDatatypeRuleToken ruleassignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5396:6: ( (kw= '=' | kw= '+=' | kw= '-=' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5397:1: (kw= '=' | kw= '+=' | kw= '-=' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5397:1: (kw= '=' | kw= '+=' | kw= '-=' )
            int alt79=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt79=1;
                }
                break;
            case 93:
                {
                alt79=2;
                }
                break;
            case 94:
                {
                alt79=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5397:1: (kw= '=' | kw= '+=' | kw= '-=' )", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5398:2: kw= '='
                    {
                    kw=(Token)input.LT(1);
                    match(input,53,FOLLOW_53_in_ruleassignmentOperator9847); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5405:2: kw= '+='
                    {
                    kw=(Token)input.LT(1);
                    match(input,93,FOLLOW_93_in_ruleassignmentOperator9866); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5412:2: kw= '-='
                    {
                    kw=(Token)input.LT(1);
                    match(input,94,FOLLOW_94_in_ruleassignmentOperator9885); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getHyphenMinusEqualsSignKeyword_2(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleassignmentOperator


    // $ANTLR start entryRuleexpressionList
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5425:1: entryRuleexpressionList returns [EObject current=null] : iv_ruleexpressionList= ruleexpressionList EOF ;
    public final EObject entryRuleexpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpressionList = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5426:2: (iv_ruleexpressionList= ruleexpressionList EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5427:2: iv_ruleexpressionList= ruleexpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleexpressionList_in_entryRuleexpressionList9925);
            iv_ruleexpressionList=ruleexpressionList();
            _fsp--;

             current =iv_ruleexpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpressionList9935); 

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
    // $ANTLR end entryRuleexpressionList


    // $ANTLR start ruleexpressionList
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5434:1: ruleexpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) ;
    public final EObject ruleexpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5439:6: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5440:1: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5440:1: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5440:2: ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5440:2: ( (lv_expressions_0_0= ruleexpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5441:1: (lv_expressions_0_0= ruleexpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5441:1: (lv_expressions_0_0= ruleexpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5442:3: lv_expressions_0_0= ruleexpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList9981);
            lv_expressions_0_0=ruleexpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionListRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressions",
            	        		lv_expressions_0_0, 
            	        		"expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5464:2: ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==28) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5464:4: ',' ( (lv_expressions_2_0= ruleexpression ) )
            	    {
            	    match(input,28,FOLLOW_28_in_ruleexpressionList9992); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5468:1: ( (lv_expressions_2_0= ruleexpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5469:1: (lv_expressions_2_0= ruleexpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5469:1: (lv_expressions_2_0= ruleexpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5470:3: lv_expressions_2_0= ruleexpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList10013);
            	    lv_expressions_2_0=ruleexpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getExpressionListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressions",
            	    	        		lv_expressions_2_0, 
            	    	        		"expression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleexpressionList


    // $ANTLR start entryRuleexpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5500:1: entryRuleexpression returns [EObject current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final EObject entryRuleexpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5501:2: (iv_ruleexpression= ruleexpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5502:2: iv_ruleexpression= ruleexpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleexpression_in_entryRuleexpression10051);
            iv_ruleexpression=ruleexpression();
            _fsp--;

             current =iv_ruleexpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpression10061); 

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
    // $ANTLR end entryRuleexpression


    // $ANTLR start ruleexpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5509:1: ruleexpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) ;
    public final EObject ruleexpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5514:6: ( ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5515:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5515:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5515:2: ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5515:2: ( (lv_expression1_0_0= ruleconditionalExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5516:1: (lv_expression1_0_0= ruleconditionalExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5516:1: (lv_expression1_0_0= ruleconditionalExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5517:3: lv_expression1_0_0= ruleconditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpression1ConditionalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleconditionalExpression_in_ruleexpression10107);
            lv_expression1_0_0=ruleconditionalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"conditionalExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5539:2: ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            int alt81=2;
            switch ( input.LA(1) ) {
                case 53:
                    {
                    alt81=1;
                    }
                    break;
                case 93:
                    {
                    alt81=1;
                    }
                    break;
                case 94:
                    {
                    alt81=1;
                    }
                    break;
            }

            switch (alt81) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5540:5: ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) )
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAssignmentOperatorParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleassignmentOperator_in_ruleexpression10124);
                    ruleassignmentOperator();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5547:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5548:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5548:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5549:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleexpression10144);
                    lv_expression2_2_0=ruleexpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression2",
                    	        		lv_expression2_2_0, 
                    	        		"expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleexpression


    // $ANTLR start entryRuleconditionalExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5579:1: entryRuleconditionalExpression returns [EObject current=null] : iv_ruleconditionalExpression= ruleconditionalExpression EOF ;
    public final EObject entryRuleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5580:2: (iv_ruleconditionalExpression= ruleconditionalExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5581:2: iv_ruleconditionalExpression= ruleconditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression10182);
            iv_ruleconditionalExpression=ruleconditionalExpression();
            _fsp--;

             current =iv_ruleconditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalExpression10192); 

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
    // $ANTLR end entryRuleconditionalExpression


    // $ANTLR start ruleconditionalExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5588:1: ruleconditionalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) ;
    public final EObject ruleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;

        EObject lv_expression3_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5593:6: ( ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5594:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5594:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5594:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5594:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5595:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5595:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5596:3: lv_expression1_0_0= ruleconditionalOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression1ConditionalOrExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression10238);
            lv_expression1_0_0=ruleconditionalOrExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"conditionalOrExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5618:2: ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==95) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5618:4: '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) )
                    {
                    match(input,95,FOLLOW_95_in_ruleconditionalExpression10249); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5622:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5623:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5623:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5624:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression10270);
                    lv_expression2_2_0=ruleexpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression2",
                    	        		lv_expression2_2_0, 
                    	        		"expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,14,FOLLOW_14_in_ruleconditionalExpression10280); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5650:1: ( (lv_expression3_4_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5651:1: (lv_expression3_4_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5651:1: (lv_expression3_4_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5652:3: lv_expression3_4_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression3ExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression10301);
                    lv_expression3_4_0=ruleexpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression3",
                    	        		lv_expression3_4_0, 
                    	        		"expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleconditionalExpression


    // $ANTLR start entryRuleconditionalOrExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5682:1: entryRuleconditionalOrExpression returns [EObject current=null] : iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF ;
    public final EObject entryRuleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalOrExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5683:2: (iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5684:2: iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression10339);
            iv_ruleconditionalOrExpression=ruleconditionalOrExpression();
            _fsp--;

             current =iv_ruleconditionalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalOrExpression10349); 

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
    // $ANTLR end entryRuleconditionalOrExpression


    // $ANTLR start ruleconditionalOrExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5691:1: ruleconditionalOrExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) ;
    public final EObject ruleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5696:6: ( ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5697:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5697:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5697:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5697:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5698:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5698:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5699:3: lv_expression1_0_0= ruleconditionalAndExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpression1ConditionalAndExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10395);
            lv_expression1_0_0=ruleconditionalAndExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalOrExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"conditionalAndExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5721:2: ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==96) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5721:4: '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    {
            	    match(input,96,FOLLOW_96_in_ruleconditionalOrExpression10406); 

            	            createLeafNode(grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5725:1: ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5726:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5726:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5727:3: lv_expressionRest_2_0= ruleconditionalAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpressionRestConditionalAndExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10427);
            	    lv_expressionRest_2_0=ruleconditionalAndExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getConditionalOrExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionRest",
            	    	        		lv_expressionRest_2_0, 
            	    	        		"conditionalAndExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleconditionalOrExpression


    // $ANTLR start entryRuleconditionalAndExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5757:1: entryRuleconditionalAndExpression returns [EObject current=null] : iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF ;
    public final EObject entryRuleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalAndExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5758:2: (iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5759:2: iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression10465);
            iv_ruleconditionalAndExpression=ruleconditionalAndExpression();
            _fsp--;

             current =iv_ruleconditionalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalAndExpression10475); 

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
    // $ANTLR end entryRuleconditionalAndExpression


    // $ANTLR start ruleconditionalAndExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5766:1: ruleconditionalAndExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) ;
    public final EObject ruleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5771:6: ( ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5772:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5772:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5772:2: ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5772:2: ( (lv_expression1_0_0= ruleequalityExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5773:1: (lv_expression1_0_0= ruleequalityExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5773:1: (lv_expression1_0_0= ruleequalityExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5774:3: lv_expression1_0_0= ruleequalityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpression1EqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10521);
            lv_expression1_0_0=ruleequalityExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalAndExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"equalityExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5796:2: ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==97) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5796:4: '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    {
            	    match(input,97,FOLLOW_97_in_ruleconditionalAndExpression10532); 

            	            createLeafNode(grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5800:1: ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5801:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5801:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5802:3: lv_expressionRest_2_0= ruleequalityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpressionRestEqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10553);
            	    lv_expressionRest_2_0=ruleequalityExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getConditionalAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionRest",
            	    	        		lv_expressionRest_2_0, 
            	    	        		"equalityExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleconditionalAndExpression


    // $ANTLR start entryRuleequalityExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5832:1: entryRuleequalityExpression returns [EObject current=null] : iv_ruleequalityExpression= ruleequalityExpression EOF ;
    public final EObject entryRuleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5833:2: (iv_ruleequalityExpression= ruleequalityExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5834:2: iv_ruleequalityExpression= ruleequalityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression10591);
            iv_ruleequalityExpression=ruleequalityExpression();
            _fsp--;

             current =iv_ruleequalityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleequalityExpression10601); 

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
    // $ANTLR end entryRuleequalityExpression


    // $ANTLR start ruleequalityExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5841:1: ruleequalityExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) ;
    public final EObject ruleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5846:6: ( ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5847:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5847:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5847:2: ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5847:2: ( (lv_expression1_0_0= rulerelationalExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5848:1: (lv_expression1_0_0= rulerelationalExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5848:1: (lv_expression1_0_0= rulerelationalExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5849:3: lv_expression1_0_0= rulerelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpression1RelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression10647);
            lv_expression1_0_0=rulerelationalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"relationalExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5871:2: ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==89||LA86_0==98) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5871:3: ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5871:3: ( '==' | '!=' )
            	    int alt85=2;
            	    int LA85_0 = input.LA(1);

            	    if ( (LA85_0==89) ) {
            	        alt85=1;
            	    }
            	    else if ( (LA85_0==98) ) {
            	        alt85=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("5871:3: ( '==' | '!=' )", 85, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt85) {
            	        case 1 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5871:5: '=='
            	            {
            	            match(input,89,FOLLOW_89_in_ruleequalityExpression10659); 

            	                    createLeafNode(grammarAccess.getEqualityExpressionAccess().getEqualsSignEqualsSignKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5876:7: '!='
            	            {
            	            match(input,98,FOLLOW_98_in_ruleequalityExpression10675); 

            	                    createLeafNode(grammarAccess.getEqualityExpressionAccess().getExclamationMarkEqualsSignKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5880:2: ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5881:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5881:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5882:3: lv_expressionRest_3_0= rulerelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpressionRestRelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression10697);
            	    lv_expressionRest_3_0=rulerelationalExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionRest",
            	    	        		lv_expressionRest_3_0, 
            	    	        		"relationalExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleequalityExpression


    // $ANTLR start entryRulerelationalExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5912:1: entryRulerelationalExpression returns [EObject current=null] : iv_rulerelationalExpression= rulerelationalExpression EOF ;
    public final EObject entryRulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5913:2: (iv_rulerelationalExpression= rulerelationalExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5914:2: iv_rulerelationalExpression= rulerelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression10735);
            iv_rulerelationalExpression=rulerelationalExpression();
            _fsp--;

             current =iv_rulerelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalExpression10745); 

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
    // $ANTLR end entryRulerelationalExpression


    // $ANTLR start rulerelationalExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:1: rulerelationalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) ;
    public final EObject rulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5926:6: ( ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5927:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5927:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5927:2: ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5927:2: ( (lv_expression1_0_0= ruleadditiveExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5928:1: (lv_expression1_0_0= ruleadditiveExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5928:1: (lv_expression1_0_0= ruleadditiveExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5929:3: lv_expression1_0_0= ruleadditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpression1AdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10791);
            lv_expression1_0_0=ruleadditiveExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"additiveExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5951:2: ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( ((LA87_0>=87 && LA87_0<=88)||(LA87_0>=90 && LA87_0<=91)) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5952:5: rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRelationalOpParserRuleCall_1_0(), currentNode); 
            	        
            	    pushFollow(FOLLOW_rulerelationalOp_in_rulerelationalExpression10808);
            	    rulerelationalOp();
            	    _fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5959:1: ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5960:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5960:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5961:3: lv_expressionRest_2_0= ruleadditiveExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpressionRestAdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10828);
            	    lv_expressionRest_2_0=ruleadditiveExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionRest",
            	    	        		lv_expressionRest_2_0, 
            	    	        		"additiveExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulerelationalExpression


    // $ANTLR start entryRulerelationalOp
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5991:1: entryRulerelationalOp returns [String current=null] : iv_rulerelationalOp= rulerelationalOp EOF ;
    public final String entryRulerelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerelationalOp = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5992:2: (iv_rulerelationalOp= rulerelationalOp EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5993:2: iv_rulerelationalOp= rulerelationalOp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalOpRule(), currentNode); 
            pushFollow(FOLLOW_rulerelationalOp_in_entryRulerelationalOp10867);
            iv_rulerelationalOp=rulerelationalOp();
            _fsp--;

             current =iv_rulerelationalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalOp10878); 

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
    // $ANTLR end entryRulerelationalOp


    // $ANTLR start rulerelationalOp
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6000:1: rulerelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken rulerelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6005:6: ( (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6006:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6006:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            int alt88=4;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt88=1;
                }
                break;
            case 88:
                {
                alt88=2;
                }
                break;
            case 90:
                {
                alt88=3;
                }
                break;
            case 87:
                {
                alt88=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6006:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6007:2: kw= '<='
                    {
                    kw=(Token)input.LT(1);
                    match(input,91,FOLLOW_91_in_rulerelationalOp10916); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6014:2: kw= '<'
                    {
                    kw=(Token)input.LT(1);
                    match(input,88,FOLLOW_88_in_rulerelationalOp10935); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6021:2: kw= '>='
                    {
                    kw=(Token)input.LT(1);
                    match(input,90,FOLLOW_90_in_rulerelationalOp10954); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6028:2: kw= '>'
                    {
                    kw=(Token)input.LT(1);
                    match(input,87,FOLLOW_87_in_rulerelationalOp10973); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_3(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulerelationalOp


    // $ANTLR start entryRuleadditiveExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6041:1: entryRuleadditiveExpression returns [EObject current=null] : iv_ruleadditiveExpression= ruleadditiveExpression EOF ;
    public final EObject entryRuleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6042:2: (iv_ruleadditiveExpression= ruleadditiveExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6043:2: iv_ruleadditiveExpression= ruleadditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression11013);
            iv_ruleadditiveExpression=ruleadditiveExpression();
            _fsp--;

             current =iv_ruleadditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleadditiveExpression11023); 

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
    // $ANTLR end entryRuleadditiveExpression


    // $ANTLR start ruleadditiveExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6050:1: ruleadditiveExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) ;
    public final EObject ruleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6055:6: ( ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6056:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6056:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6056:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6056:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6057:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6057:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6058:3: lv_expression1_0_0= rulemultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpression1MultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11069);
            lv_expression1_0_0=rulemultiplicativeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"multiplicativeExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6080:2: ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( ((LA90_0>=99 && LA90_0<=100)) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6080:3: ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6080:3: ( '+' | '-' )
            	    int alt89=2;
            	    int LA89_0 = input.LA(1);

            	    if ( (LA89_0==99) ) {
            	        alt89=1;
            	    }
            	    else if ( (LA89_0==100) ) {
            	        alt89=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("6080:3: ( '+' | '-' )", 89, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt89) {
            	        case 1 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6080:5: '+'
            	            {
            	            match(input,99,FOLLOW_99_in_ruleadditiveExpression11081); 

            	                    createLeafNode(grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6085:7: '-'
            	            {
            	            match(input,100,FOLLOW_100_in_ruleadditiveExpression11097); 

            	                    createLeafNode(grammarAccess.getAdditiveExpressionAccess().getHyphenMinusKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6089:2: ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6090:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6090:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6091:3: lv_expressionRest_3_0= rulemultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpressionRestMultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11119);
            	    lv_expressionRest_3_0=rulemultiplicativeExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionRest",
            	    	        		lv_expressionRest_3_0, 
            	    	        		"multiplicativeExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleadditiveExpression


    // $ANTLR start entryRulemultiplicativeExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6121:1: entryRulemultiplicativeExpression returns [EObject current=null] : iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF ;
    public final EObject entryRulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6122:2: (iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6123:2: iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression11157);
            iv_rulemultiplicativeExpression=rulemultiplicativeExpression();
            _fsp--;

             current =iv_rulemultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicativeExpression11167); 

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
    // $ANTLR end entryRulemultiplicativeExpression


    // $ANTLR start rulemultiplicativeExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6130:1: rulemultiplicativeExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) ;
    public final EObject rulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6135:6: ( ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6136:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6136:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6136:2: ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6136:2: ( (lv_expression1_0_0= ruleunaryExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6137:1: (lv_expression1_0_0= ruleunaryExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6137:1: (lv_expression1_0_0= ruleunaryExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6138:3: lv_expression1_0_0= ruleunaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpression1UnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11213);
            lv_expression1_0_0=ruleunaryExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression1",
            	        		lv_expression1_0_0, 
            	        		"unaryExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6160:2: ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==46||LA92_0==74||LA92_0==101) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6160:3: ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6160:3: ( '*' | '/' | '%' )
            	    int alt91=3;
            	    switch ( input.LA(1) ) {
            	    case 46:
            	        {
            	        alt91=1;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt91=2;
            	        }
            	        break;
            	    case 101:
            	        {
            	        alt91=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("6160:3: ( '*' | '/' | '%' )", 91, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt91) {
            	        case 1 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6160:5: '*'
            	            {
            	            match(input,46,FOLLOW_46_in_rulemultiplicativeExpression11225); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6165:7: '/'
            	            {
            	            match(input,74,FOLLOW_74_in_rulemultiplicativeExpression11241); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;
            	        case 3 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6170:7: '%'
            	            {
            	            match(input,101,FOLLOW_101_in_rulemultiplicativeExpression11257); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_0_2(), null); 
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6174:2: ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6175:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6175:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6176:3: lv_expressionRest_4_0= ruleunaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpressionRestUnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11279);
            	    lv_expressionRest_4_0=ruleunaryExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionRest",
            	    	        		lv_expressionRest_4_0, 
            	    	        		"unaryExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulemultiplicativeExpression


    // $ANTLR start entryRuleunaryExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6206:1: entryRuleunaryExpression returns [EObject current=null] : iv_ruleunaryExpression= ruleunaryExpression EOF ;
    public final EObject entryRuleunaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6207:2: (iv_ruleunaryExpression= ruleunaryExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6208:2: iv_ruleunaryExpression= ruleunaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression11317);
            iv_ruleunaryExpression=ruleunaryExpression();
            _fsp--;

             current =iv_ruleunaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpression11327); 

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
    // $ANTLR end entryRuleunaryExpression


    // $ANTLR start ruleunaryExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6215:1: ruleunaryExpression returns [EObject current=null] : ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) ;
    public final EObject ruleunaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp1_1_0 = null;

        EObject lv_exp1_3_0 = null;

        EObject lv_exp1_5_0 = null;

        EObject lv_exp1_7_0 = null;

        EObject lv_exp2_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6220:6: ( ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6221:1: ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6221:1: ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            int alt93=5;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt93=1;
                }
                break;
            case 100:
                {
                alt93=2;
                }
                break;
            case 102:
                {
                alt93=3;
                }
                break;
            case 41:
                {
                alt93=4;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 71:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                {
                alt93=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6221:1: ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6221:2: ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6221:2: ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6221:4: '+' ( (lv_exp1_1_0= ruleunaryExpression ) )
                    {
                    match(input,99,FOLLOW_99_in_ruleunaryExpression11363); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getPlusSignKeyword_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6225:1: ( (lv_exp1_1_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6226:1: (lv_exp1_1_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6226:1: (lv_exp1_1_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6227:3: lv_exp1_1_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11384);
                    lv_exp1_1_0=ruleunaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exp1",
                    	        		lv_exp1_1_0, 
                    	        		"unaryExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6250:6: ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6250:6: ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6250:8: '-' ( (lv_exp1_3_0= ruleunaryExpression ) )
                    {
                    match(input,100,FOLLOW_100_in_ruleunaryExpression11402); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getHyphenMinusKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6254:1: ( (lv_exp1_3_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6255:1: (lv_exp1_3_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6255:1: (lv_exp1_3_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6256:3: lv_exp1_3_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11423);
                    lv_exp1_3_0=ruleunaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exp1",
                    	        		lv_exp1_3_0, 
                    	        		"unaryExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6279:6: ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6279:6: ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6279:8: '++' ( (lv_exp1_5_0= ruleunaryExpression ) )
                    {
                    match(input,102,FOLLOW_102_in_ruleunaryExpression11441); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getPlusSignPlusSignKeyword_2_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6283:1: ( (lv_exp1_5_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6284:1: (lv_exp1_5_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6284:1: (lv_exp1_5_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6285:3: lv_exp1_5_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11462);
                    lv_exp1_5_0=ruleunaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exp1",
                    	        		lv_exp1_5_0, 
                    	        		"unaryExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6308:6: ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6308:6: ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6308:8: '--' ( (lv_exp1_7_0= ruleunaryExpression ) )
                    {
                    match(input,41,FOLLOW_41_in_ruleunaryExpression11480); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getHyphenMinusHyphenMinusKeyword_3_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6312:1: ( (lv_exp1_7_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6313:1: (lv_exp1_7_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6313:1: (lv_exp1_7_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6314:3: lv_exp1_7_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11501);
                    lv_exp1_7_0=ruleunaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exp1",
                    	        		lv_exp1_7_0, 
                    	        		"unaryExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6337:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6337:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6338:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6338:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6339:3: lv_exp2_8_0= ruleunaryExpressionNotPlusMinus
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp2UnaryExpressionNotPlusMinusParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression11529);
                    lv_exp2_8_0=ruleunaryExpressionNotPlusMinus();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exp2",
                    	        		lv_exp2_8_0, 
                    	        		"unaryExpressionNotPlusMinus", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleunaryExpression


    // $ANTLR start entryRuleunaryExpressionNotPlusMinus
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6369:1: entryRuleunaryExpressionNotPlusMinus returns [EObject current=null] : iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF ;
    public final EObject entryRuleunaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpressionNotPlusMinus = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6370:2: (iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6371:2: iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusRule(), currentNode); 
            pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus11565);
            iv_ruleunaryExpressionNotPlusMinus=ruleunaryExpressionNotPlusMinus();
            _fsp--;

             current =iv_ruleunaryExpressionNotPlusMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus11575); 

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
    // $ANTLR end entryRuleunaryExpressionNotPlusMinus


    // $ANTLR start ruleunaryExpressionNotPlusMinus
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6378:1: ruleunaryExpressionNotPlusMinus returns [EObject current=null] : ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) ) ;
    public final EObject ruleunaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject this_unaryExpression_1 = null;

        EObject this_unaryExpression_3 = null;

        EObject this_primary_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6383:6: ( ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6384:1: ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6384:1: ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) )
            int alt95=3;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt95=1;
                }
                break;
            case 104:
                {
                alt95=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 71:
            case 105:
            case 106:
            case 107:
            case 108:
                {
                alt95=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6384:1: ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) )", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6384:2: ( '~' this_unaryExpression_1= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6384:2: ( '~' this_unaryExpression_1= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6384:4: '~' this_unaryExpression_1= ruleunaryExpression
                    {
                    match(input,103,FOLLOW_103_in_ruleunaryExpressionNotPlusMinus11611); 

                            createLeafNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getTildeKeyword_0_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11633);
                    this_unaryExpression_1=ruleunaryExpression();
                    _fsp--;

                     
                            current = this_unaryExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6398:6: ( '!' this_unaryExpression_3= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6398:6: ( '!' this_unaryExpression_3= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6398:8: '!' this_unaryExpression_3= ruleunaryExpression
                    {
                    match(input,104,FOLLOW_104_in_ruleunaryExpressionNotPlusMinus11650); 

                            createLeafNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getExclamationMarkKeyword_1_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11672);
                    this_unaryExpression_3=ruleunaryExpression();
                    _fsp--;

                     
                            current = this_unaryExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6412:6: (this_primary_4= ruleprimary ( '++' | '--' )? )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6412:6: (this_primary_4= ruleprimary ( '++' | '--' )? )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6413:5: this_primary_4= ruleprimary ( '++' | '--' )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPrimaryParserRuleCall_2_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus11701);
                    this_primary_4=ruleprimary();
                    _fsp--;

                     
                            current = this_primary_4; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6421:1: ( '++' | '--' )?
                    int alt94=3;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==102) ) {
                        alt94=1;
                    }
                    else if ( (LA94_0==41) ) {
                        alt94=2;
                    }
                    switch (alt94) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6421:3: '++'
                            {
                            match(input,102,FOLLOW_102_in_ruleunaryExpressionNotPlusMinus11711); 

                                    createLeafNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPlusSignPlusSignKeyword_2_1_0(), null); 
                                

                            }
                            break;
                        case 2 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6426:7: '--'
                            {
                            match(input,41,FOLLOW_41_in_ruleunaryExpressionNotPlusMinus11727); 

                                    createLeafNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getHyphenMinusHyphenMinusKeyword_2_1_1(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleunaryExpressionNotPlusMinus


    // $ANTLR start entryRuleprimary
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6438:1: entryRuleprimary returns [EObject current=null] : iv_ruleprimary= ruleprimary EOF ;
    public final EObject entryRuleprimary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimary = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6439:2: (iv_ruleprimary= ruleprimary EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6440:2: iv_ruleprimary= ruleprimary EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryRule(), currentNode); 
            pushFollow(FOLLOW_ruleprimary_in_entryRuleprimary11766);
            iv_ruleprimary=ruleprimary();
            _fsp--;

             current =iv_ruleprimary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimary11776); 

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
    // $ANTLR end entryRuleprimary


    // $ANTLR start ruleprimary
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6447:1: ruleprimary returns [EObject current=null] : (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) ;
    public final EObject ruleprimary() throws RecognitionException {
        EObject current = null;

        EObject this_parExpression_0 = null;

        EObject this_literal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6452:6: ( (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6453:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6453:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==71) ) {
                alt96=1;
            }
            else if ( ((LA96_0>=RULE_STRING && LA96_0<=RULE_INT)||(LA96_0>=105 && LA96_0<=108)) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6453:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6454:5: this_parExpression_0= ruleparExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryAccess().getParExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleparExpression_in_ruleprimary11823);
                    this_parExpression_0=ruleparExpression();
                    _fsp--;

                     
                            current = this_parExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6464:5: this_literal_1= ruleliteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleliteral_in_ruleprimary11850);
                    this_literal_1=ruleliteral();
                    _fsp--;

                     
                            current = this_literal_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleprimary


    // $ANTLR start entryRuleliteral
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6480:1: entryRuleliteral returns [EObject current=null] : iv_ruleliteral= ruleliteral EOF ;
    public final EObject entryRuleliteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleliteral = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6481:2: (iv_ruleliteral= ruleliteral EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6482:2: iv_ruleliteral= ruleliteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleliteral_in_entryRuleliteral11885);
            iv_ruleliteral=ruleliteral();
            _fsp--;

             current =iv_ruleliteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleliteral11895); 

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
    // $ANTLR end entryRuleliteral


    // $ANTLR start ruleliteral
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6489:1: ruleliteral returns [EObject current=null] : ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' ) ;
    public final EObject ruleliteral() throws RecognitionException {
        EObject current = null;

        EObject this_javaFunctionCall_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6494:6: ( ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6495:1: ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6495:1: ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' )
            int alt97=9;
            alt97 = dfa97.predict(input);
            switch (alt97) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6495:2: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleliteral11929); 
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6501:5: ruleDOUBLE
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDOUBLEParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDOUBLE_in_ruleliteral11950);
                    ruleDOUBLE();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6509:6: RULE_STRING
                    {
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleliteral11964); 
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6515:5: ruleextendedID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getExtendedIDParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleliteral11985);
                    ruleextendedID();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6524:5: this_javaFunctionCall_4= rulejavaFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getJavaFunctionCallParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_rulejavaFunctionCall_in_ruleliteral12012);
                    this_javaFunctionCall_4=rulejavaFunctionCall();
                    _fsp--;

                     
                            current = this_javaFunctionCall_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6533:7: 'true'
                    {
                    match(input,105,FOLLOW_105_in_ruleliteral12027); 

                            createLeafNode(grammarAccess.getLiteralAccess().getTrueKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6538:7: 'TRUE'
                    {
                    match(input,106,FOLLOW_106_in_ruleliteral12043); 

                            createLeafNode(grammarAccess.getLiteralAccess().getTRUEKeyword_6(), null); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6543:7: 'false'
                    {
                    match(input,107,FOLLOW_107_in_ruleliteral12059); 

                            createLeafNode(grammarAccess.getLiteralAccess().getFalseKeyword_7(), null); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6548:7: 'FALSE'
                    {
                    match(input,108,FOLLOW_108_in_ruleliteral12075); 

                            createLeafNode(grammarAccess.getLiteralAccess().getFALSEKeyword_8(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleliteral


    // $ANTLR start entryRulefunctionDeclaration
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6562:1: entryRulefunctionDeclaration returns [EObject current=null] : iv_rulefunctionDeclaration= rulefunctionDeclaration EOF ;
    public final EObject entryRulefunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefunctionDeclaration = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6563:2: (iv_rulefunctionDeclaration= rulefunctionDeclaration EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6564:2: iv_rulefunctionDeclaration= rulefunctionDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_rulefunctionDeclaration_in_entryRulefunctionDeclaration12113);
            iv_rulefunctionDeclaration=rulefunctionDeclaration();
            _fsp--;

             current =iv_rulefunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulefunctionDeclaration12123); 

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
    // $ANTLR end entryRulefunctionDeclaration


    // $ANTLR start rulefunctionDeclaration
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6571:1: rulefunctionDeclaration returns [EObject current=null] : ( (lv_java_0_0= rulejavaFunctionDeclaration ) ) ;
    public final EObject rulefunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_java_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6576:6: ( ( (lv_java_0_0= rulejavaFunctionDeclaration ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6577:1: ( (lv_java_0_0= rulejavaFunctionDeclaration ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6577:1: ( (lv_java_0_0= rulejavaFunctionDeclaration ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6578:1: (lv_java_0_0= rulejavaFunctionDeclaration )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6578:1: (lv_java_0_0= rulejavaFunctionDeclaration )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6579:3: lv_java_0_0= rulejavaFunctionDeclaration
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDeclarationAccess().getJavaJavaFunctionDeclarationParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_rulefunctionDeclaration12168);
            lv_java_0_0=rulejavaFunctionDeclaration();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"java",
            	        		lv_java_0_0, 
            	        		"javaFunctionDeclaration", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulefunctionDeclaration


    // $ANTLR start entryRulefunctionDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6609:1: entryRulefunctionDefinition returns [EObject current=null] : iv_rulefunctionDefinition= rulefunctionDefinition EOF ;
    public final EObject entryRulefunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefunctionDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6610:2: (iv_rulefunctionDefinition= rulefunctionDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6611:2: iv_rulefunctionDefinition= rulefunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_rulefunctionDefinition_in_entryRulefunctionDefinition12203);
            iv_rulefunctionDefinition=rulefunctionDefinition();
            _fsp--;

             current =iv_rulefunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulefunctionDefinition12213); 

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
    // $ANTLR end entryRulefunctionDefinition


    // $ANTLR start rulefunctionDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6618:1: rulefunctionDefinition returns [EObject current=null] : ( (lv_java_0_0= rulejavaFunctionDefinition ) ) ;
    public final EObject rulefunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_java_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6623:6: ( ( (lv_java_0_0= rulejavaFunctionDefinition ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6624:1: ( (lv_java_0_0= rulejavaFunctionDefinition ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6624:1: ( (lv_java_0_0= rulejavaFunctionDefinition ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6625:1: (lv_java_0_0= rulejavaFunctionDefinition )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6625:1: (lv_java_0_0= rulejavaFunctionDefinition )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6626:3: lv_java_0_0= rulejavaFunctionDefinition
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getJavaJavaFunctionDefinitionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDefinition_in_rulefunctionDefinition12258);
            lv_java_0_0=rulejavaFunctionDefinition();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"java",
            	        		lv_java_0_0, 
            	        		"javaFunctionDefinition", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulefunctionDefinition


    // $ANTLR start entryRulejavaFunctionDeclaration
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6656:1: entryRulejavaFunctionDeclaration returns [EObject current=null] : iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF ;
    public final EObject entryRulejavaFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDeclaration = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6657:2: (iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6658:2: iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaFunctionDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration12293);
            iv_rulejavaFunctionDeclaration=rulejavaFunctionDeclaration();
            _fsp--;

             current =iv_rulejavaFunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDeclaration12303); 

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
    // $ANTLR end entryRulejavaFunctionDeclaration


    // $ANTLR start rulejavaFunctionDeclaration
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6665:1: rulejavaFunctionDeclaration returns [EObject current=null] : ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) ) ;
    public final EObject rulejavaFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_referenceType_6_0=null;
        Token lv_name_7_0=null;
        AntlrDatatypeRuleToken lv_returnType_4_0 = null;

        AntlrDatatypeRuleToken lv_argList_9_0 = null;

        AntlrDatatypeRuleToken lv_argListID_10_0 = null;

        AntlrDatatypeRuleToken lv_argList_12_0 = null;

        AntlrDatatypeRuleToken lv_argListID_13_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6670:6: ( ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6671:1: ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6671:1: ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6671:2: ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6671:2: ( 'static' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==109) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6671:4: 'static'
                    {
                    match(input,109,FOLLOW_109_in_rulejavaFunctionDeclaration12339); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getStaticKeyword_0(), null); 
                        

                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6675:3: ( 'public' | 'private' | 'protected' )
            int alt99=3;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt99=1;
                }
                break;
            case 111:
                {
                alt99=2;
                }
                break;
            case 112:
                {
                alt99=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6675:3: ( 'public' | 'private' | 'protected' )", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6675:5: 'public'
                    {
                    match(input,110,FOLLOW_110_in_rulejavaFunctionDeclaration12352); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getPublicKeyword_1_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6680:7: 'private'
                    {
                    match(input,111,FOLLOW_111_in_rulejavaFunctionDeclaration12368); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getPrivateKeyword_1_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6685:7: 'protected'
                    {
                    match(input,112,FOLLOW_112_in_rulejavaFunctionDeclaration12384); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getProtectedKeyword_1_2(), null); 
                        

                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6689:2: ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) )
            int alt100=3;
            switch ( input.LA(1) ) {
            case 29:
            case 33:
            case 36:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                {
                alt100=1;
                }
                break;
            case 113:
                {
                alt100=2;
                }
                break;
            case RULE_ID:
                {
                alt100=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6689:2: ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) )", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6689:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6689:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6690:1: (lv_returnType_4_0= ruleattributeType )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6690:1: (lv_returnType_4_0= ruleattributeType )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6691:3: lv_returnType_4_0= ruleattributeType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getReturnTypeAttributeTypeParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12407);
                    lv_returnType_4_0=ruleattributeType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getJavaFunctionDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"returnType",
                    	        		lv_returnType_4_0, 
                    	        		"attributeType", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6714:7: 'void'
                    {
                    match(input,113,FOLLOW_113_in_rulejavaFunctionDeclaration12423); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getVoidKeyword_2_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6719:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6719:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6720:1: (lv_referenceType_6_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6720:1: (lv_referenceType_6_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6721:3: lv_referenceType_6_0= RULE_ID
                    {
                    lv_referenceType_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12446); 

                    			createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getReferenceTypeIDTerminalRuleCall_2_2_0(), "referenceType"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getJavaFunctionDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"referenceType",
                    	        		lv_referenceType_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6743:3: ( (lv_name_7_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6744:1: (lv_name_7_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6744:1: (lv_name_7_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6745:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12469); 

            			createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaFunctionDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6767:2: ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==71) ) {
                alt103=1;
            }
            else if ( (LA103_0==86) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6767:2: ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' )", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6767:3: ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6767:3: ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6767:5: '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')'
                    {
                    match(input,71,FOLLOW_71_in_rulejavaFunctionDeclaration12486); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisKeyword_4_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6771:1: ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )?
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==29||LA102_0==33||LA102_0==36||(LA102_0>=54 && LA102_0<=61)) ) {
                        alt102=1;
                    }
                    switch (alt102) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6771:2: ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6771:2: ( (lv_argList_9_0= ruleattributeType ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6772:1: (lv_argList_9_0= ruleattributeType )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6772:1: (lv_argList_9_0= ruleattributeType )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6773:3: lv_argList_9_0= ruleattributeType
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12508);
                            lv_argList_9_0=ruleattributeType();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getJavaFunctionDeclarationRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"argList",
                            	        		lv_argList_9_0, 
                            	        		"attributeType", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6795:2: ( (lv_argListID_10_0= ruleextendedID ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6796:1: (lv_argListID_10_0= ruleextendedID )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6796:1: (lv_argListID_10_0= ruleextendedID )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6797:3: lv_argListID_10_0= ruleextendedID
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12529);
                            lv_argListID_10_0=ruleextendedID();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getJavaFunctionDeclarationRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"argListID",
                            	        		lv_argListID_10_0, 
                            	        		"extendedID", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6819:2: ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            loop101:
                            do {
                                int alt101=2;
                                int LA101_0 = input.LA(1);

                                if ( (LA101_0==28) ) {
                                    alt101=1;
                                }


                                switch (alt101) {
                            	case 1 :
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6819:4: ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) )
                            	    {
                            	    match(input,28,FOLLOW_28_in_rulejavaFunctionDeclaration12540); 

                            	            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getCommaKeyword_4_0_1_2_0(), null); 
                            	        
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6823:1: ( (lv_argList_12_0= ruleattributeType ) )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6824:1: (lv_argList_12_0= ruleattributeType )
                            	    {
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6824:1: (lv_argList_12_0= ruleattributeType )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6825:3: lv_argList_12_0= ruleattributeType
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_2_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12561);
                            	    lv_argList_12_0=ruleattributeType();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getJavaFunctionDeclarationRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"argList",
                            	    	        		lv_argList_12_0, 
                            	    	        		"attributeType", 
                            	    	        		currentNode);
                            	    	        } catch (ValueConverterException vce) {
                            	    				handleValueConverterException(vce);
                            	    	        }
                            	    	        currentNode = currentNode.getParent();
                            	    	    

                            	    }


                            	    }

                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6847:2: ( (lv_argListID_13_0= ruleextendedID ) )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6848:1: (lv_argListID_13_0= ruleextendedID )
                            	    {
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6848:1: (lv_argListID_13_0= ruleextendedID )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6849:3: lv_argListID_13_0= ruleextendedID
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_2_2_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12582);
                            	    lv_argListID_13_0=ruleextendedID();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getJavaFunctionDeclarationRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"argListID",
                            	    	        		lv_argListID_13_0, 
                            	    	        		"extendedID", 
                            	    	        		currentNode);
                            	    	        } catch (ValueConverterException vce) {
                            	    				handleValueConverterException(vce);
                            	    	        }
                            	    	        currentNode = currentNode.getParent();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop101;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,72,FOLLOW_72_in_rulejavaFunctionDeclaration12596); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getRightParenthesisKeyword_4_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6876:7: '()'
                    {
                    match(input,86,FOLLOW_86_in_rulejavaFunctionDeclaration12613); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisRightParenthesisKeyword_4_1(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulejavaFunctionDeclaration


    // $ANTLR start entryRulejavaFunctionDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6888:1: entryRulejavaFunctionDefinition returns [EObject current=null] : iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF ;
    public final EObject entryRulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6889:2: (iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6890:2: iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition12650);
            iv_rulejavaFunctionDefinition=rulejavaFunctionDefinition();
            _fsp--;

             current =iv_rulejavaFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDefinition12660); 

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
    // $ANTLR end entryRulejavaFunctionDefinition


    // $ANTLR start rulejavaFunctionDefinition
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6897:1: rulejavaFunctionDefinition returns [EObject current=null] : ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject rulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_decl_0_0 = null;

        EObject lv_code_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6902:6: ( ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6903:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6903:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6903:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6903:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6904:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6904:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6905:3: lv_decl_0_0= rulejavaFunctionDeclaration
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getDeclJavaFunctionDeclarationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition12706);
            lv_decl_0_0=rulejavaFunctionDeclaration();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"decl",
            	        		lv_decl_0_0, 
            	        		"javaFunctionDeclaration", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6927:2: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6928:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6928:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6929:3: lv_code_1_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getCodeBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_rulejavaFunctionDefinition12727);
            lv_code_1_0=ruleblock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"code",
            	        		lv_code_1_0, 
            	        		"block", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulejavaFunctionDefinition


    // $ANTLR start entryRulejavaFunctionCall
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6959:1: entryRulejavaFunctionCall returns [EObject current=null] : iv_rulejavaFunctionCall= rulejavaFunctionCall EOF ;
    public final EObject entryRulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionCall = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6960:2: (iv_rulejavaFunctionCall= rulejavaFunctionCall EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6961:2: iv_rulejavaFunctionCall= rulejavaFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall12763);
            iv_rulejavaFunctionCall=rulejavaFunctionCall();
            _fsp--;

             current =iv_rulejavaFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionCall12773); 

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
    // $ANTLR end entryRulejavaFunctionCall


    // $ANTLR start rulejavaFunctionCall
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6968:1: rulejavaFunctionCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) ) ;
    public final EObject rulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_args_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6973:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6974:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6974:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6974:2: ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6974:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6975:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6975:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6976:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionCallAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionCall12819);
            lv_name_0_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJavaFunctionCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6998:2: ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==71) ) {
                alt105=1;
            }
            else if ( (LA105_0==86) ) {
                alt105=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6998:2: ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' )", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6998:3: ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6998:3: ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6998:5: '(' ( (lv_args_2_0= ruleexpressionList ) )? ')'
                    {
                    match(input,71,FOLLOW_71_in_rulejavaFunctionCall12831); 

                            createLeafNode(grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisKeyword_1_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7002:1: ( (lv_args_2_0= ruleexpressionList ) )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( ((LA104_0>=RULE_STRING && LA104_0<=RULE_INT)||LA104_0==41||LA104_0==71||(LA104_0>=99 && LA104_0<=100)||(LA104_0>=102 && LA104_0<=108)) ) {
                        alt104=1;
                    }
                    switch (alt104) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7003:1: (lv_args_2_0= ruleexpressionList )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7003:1: (lv_args_2_0= ruleexpressionList )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7004:3: lv_args_2_0= ruleexpressionList
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionCallAccess().getArgsExpressionListParserRuleCall_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleexpressionList_in_rulejavaFunctionCall12852);
                            lv_args_2_0=ruleexpressionList();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getJavaFunctionCallRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"args",
                            	        		lv_args_2_0, 
                            	        		"expressionList", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,72,FOLLOW_72_in_rulejavaFunctionCall12863); 

                            createLeafNode(grammarAccess.getJavaFunctionCallAccess().getRightParenthesisKeyword_1_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7031:7: '()'
                    {
                    match(input,86,FOLLOW_86_in_rulejavaFunctionCall12880); 

                            createLeafNode(grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisRightParenthesisKeyword_1_1(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulejavaFunctionCall


    // $ANTLR start entryRuleblockStatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7043:1: entryRuleblockStatement returns [EObject current=null] : iv_ruleblockStatement= ruleblockStatement EOF ;
    public final EObject entryRuleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblockStatement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7044:2: (iv_ruleblockStatement= ruleblockStatement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7045:2: iv_ruleblockStatement= ruleblockStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBlockStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleblockStatement_in_entryRuleblockStatement12917);
            iv_ruleblockStatement=ruleblockStatement();
            _fsp--;

             current =iv_ruleblockStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblockStatement12927); 

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
    // $ANTLR end entryRuleblockStatement


    // $ANTLR start ruleblockStatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7052:1: ruleblockStatement returns [EObject current=null] : (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) ;
    public final EObject ruleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject this_statement_0 = null;

        EObject this_localVariableDeclarationStatement_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7057:6: ( (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7058:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7058:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( ((LA106_0>=RULE_STRING && LA106_0<=RULE_INT)||LA106_0==15||LA106_0==17||LA106_0==41||LA106_0==71||(LA106_0>=99 && LA106_0<=100)||(LA106_0>=102 && LA106_0<=108)||LA106_0==114||(LA106_0>=116 && LA106_0<=120)) ) {
                alt106=1;
            }
            else if ( (LA106_0==29||LA106_0==33||LA106_0==36||(LA106_0>=54 && LA106_0<=61)) ) {
                alt106=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("7058:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7059:5: this_statement_0= rulestatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBlockStatementAccess().getStatementParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulestatement_in_ruleblockStatement12974);
                    this_statement_0=rulestatement();
                    _fsp--;

                     
                            current = this_statement_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7069:5: this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBlockStatementAccess().getLocalVariableDeclarationStatementParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement13001);
                    this_localVariableDeclarationStatement_1=rulelocalVariableDeclarationStatement();
                    _fsp--;

                     
                            current = this_localVariableDeclarationStatement_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleblockStatement


    // $ANTLR start entryRulelocalVariableDeclarationStatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7085:1: entryRulelocalVariableDeclarationStatement returns [EObject current=null] : iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF ;
    public final EObject entryRulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclarationStatement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7086:2: (iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7087:2: iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLocalVariableDeclarationStatementRule(), currentNode); 
            pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement13036);
            iv_rulelocalVariableDeclarationStatement=rulelocalVariableDeclarationStatement();
            _fsp--;

             current =iv_rulelocalVariableDeclarationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement13046); 

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
    // $ANTLR end entryRulelocalVariableDeclarationStatement


    // $ANTLR start rulelocalVariableDeclarationStatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7094:1: rulelocalVariableDeclarationStatement returns [EObject current=null] : (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' ) ;
    public final EObject rulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject this_localVariableDeclaration_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7099:6: ( (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7100:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7100:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7101:5: this_localVariableDeclaration_0= rulelocalVariableDeclaration ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLocalVariableDeclarationStatementAccess().getLocalVariableDeclarationParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement13093);
            this_localVariableDeclaration_0=rulelocalVariableDeclaration();
            _fsp--;

             
                    current = this_localVariableDeclaration_0; 
                    currentNode = currentNode.getParent();
                
            match(input,15,FOLLOW_15_in_rulelocalVariableDeclarationStatement13102); 

                    createLeafNode(grammarAccess.getLocalVariableDeclarationStatementAccess().getSemicolonKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulelocalVariableDeclarationStatement


    // $ANTLR start entryRulelocalVariableDeclaration
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7121:1: entryRulelocalVariableDeclaration returns [EObject current=null] : iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF ;
    public final EObject entryRulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclaration = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7122:2: (iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7123:2: iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLocalVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration13138);
            iv_rulelocalVariableDeclaration=rulelocalVariableDeclaration();
            _fsp--;

             current =iv_rulelocalVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclaration13148); 

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
    // $ANTLR end entryRulelocalVariableDeclaration


    // $ANTLR start rulelocalVariableDeclaration
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7130:1: rulelocalVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) ;
    public final EObject rulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_dec_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7135:6: ( ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7136:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7136:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7136:2: ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7136:2: ( (lv_type_0_0= ruleattributeType ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7137:1: (lv_type_0_0= ruleattributeType )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7137:1: (lv_type_0_0= ruleattributeType )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7138:3: lv_type_0_0= ruleattributeType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getTypeAttributeTypeParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration13194);
            lv_type_0_0=ruleattributeType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLocalVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_0_0, 
            	        		"attributeType", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7160:2: ( (lv_dec_1_0= rulevariableDeclarators ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7161:1: (lv_dec_1_0= rulevariableDeclarators )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7161:1: (lv_dec_1_0= rulevariableDeclarators )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7162:3: lv_dec_1_0= rulevariableDeclarators
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getDecVariableDeclaratorsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration13215);
            lv_dec_1_0=rulevariableDeclarators();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLocalVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"dec",
            	        		lv_dec_1_0, 
            	        		"variableDeclarators", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulelocalVariableDeclaration


    // $ANTLR start entryRulevariableDeclarators
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7192:1: entryRulevariableDeclarators returns [EObject current=null] : iv_rulevariableDeclarators= rulevariableDeclarators EOF ;
    public final EObject entryRulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarators = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7193:2: (iv_rulevariableDeclarators= rulevariableDeclarators EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7194:2: iv_rulevariableDeclarators= rulevariableDeclarators EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclaratorsRule(), currentNode); 
            pushFollow(FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators13251);
            iv_rulevariableDeclarators=rulevariableDeclarators();
            _fsp--;

             current =iv_rulevariableDeclarators; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarators13261); 

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
    // $ANTLR end entryRulevariableDeclarators


    // $ANTLR start rulevariableDeclarators
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7201:1: rulevariableDeclarators returns [EObject current=null] : ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) ;
    public final EObject rulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        EObject lv_vd_0_0 = null;

        EObject lv_vd_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7206:6: ( ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7207:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7207:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7207:2: ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7207:2: ( (lv_vd_0_0= rulevariableDeclarator ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7208:1: (lv_vd_0_0= rulevariableDeclarator )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7208:1: (lv_vd_0_0= rulevariableDeclarator )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7209:3: lv_vd_0_0= rulevariableDeclarator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13307);
            lv_vd_0_0=rulevariableDeclarator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclaratorsRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"vd",
            	        		lv_vd_0_0, 
            	        		"variableDeclarator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7231:2: ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==28) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7231:4: ',' ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    {
            	    match(input,28,FOLLOW_28_in_rulevariableDeclarators13318); 

            	            createLeafNode(grammarAccess.getVariableDeclaratorsAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7235:1: ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7236:1: (lv_vd_2_0= rulevariableDeclarator )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7236:1: (lv_vd_2_0= rulevariableDeclarator )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7237:3: lv_vd_2_0= rulevariableDeclarator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13339);
            	    lv_vd_2_0=rulevariableDeclarator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getVariableDeclaratorsRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"vd",
            	    	        		lv_vd_2_0, 
            	    	        		"variableDeclarator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulevariableDeclarators


    // $ANTLR start entryRulevariableDeclarator
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7267:1: entryRulevariableDeclarator returns [EObject current=null] : iv_rulevariableDeclarator= rulevariableDeclarator EOF ;
    public final EObject entryRulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarator = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7268:2: (iv_rulevariableDeclarator= rulevariableDeclarator EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7269:2: iv_rulevariableDeclarator= rulevariableDeclarator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclaratorRule(), currentNode); 
            pushFollow(FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator13377);
            iv_rulevariableDeclarator=rulevariableDeclarator();
            _fsp--;

             current =iv_rulevariableDeclarator; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarator13387); 

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
    // $ANTLR end entryRulevariableDeclarator


    // $ANTLR start rulevariableDeclarator
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7276:1: rulevariableDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) ;
    public final EObject rulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7281:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7282:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7282:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7282:2: ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7282:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7283:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7283:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7284:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulevariableDeclarator13433);
            lv_name_0_0=ruleextendedID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclaratorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"extendedID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7306:2: ( '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==53) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7306:4: '=' ( (lv_exp_2_0= ruleexpression ) )
                    {
                    match(input,53,FOLLOW_53_in_rulevariableDeclarator13444); 

                            createLeafNode(grammarAccess.getVariableDeclaratorAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7310:1: ( (lv_exp_2_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7311:1: (lv_exp_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7311:1: (lv_exp_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7312:3: lv_exp_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorAccess().getExpExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_rulevariableDeclarator13465);
                    lv_exp_2_0=ruleexpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclaratorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exp",
                    	        		lv_exp_2_0, 
                    	        		"expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulevariableDeclarator


    // $ANTLR start entryRulestatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7342:1: entryRulestatement returns [EObject current=null] : iv_rulestatement= rulestatement EOF ;
    public final EObject entryRulestatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestatement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7343:2: (iv_rulestatement= rulestatement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7344:2: iv_rulestatement= rulestatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_rulestatement_in_entryRulestatement13503);
            iv_rulestatement=rulestatement();
            _fsp--;

             current =iv_rulestatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulestatement13513); 

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
    // $ANTLR end entryRulestatement


    // $ANTLR start rulestatement
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7351:1: rulestatement returns [EObject current=null] : (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) ) ;
    public final EObject rulestatement() throws RecognitionException {
        EObject current = null;

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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7356:6: ( (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7357:1: (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7357:1: (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )
            int alt111=9;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt111=1;
                }
                break;
            case 114:
                {
                alt111=2;
                }
                break;
            case 116:
                {
                alt111=3;
                }
                break;
            case 117:
                {
                alt111=4;
                }
                break;
            case 118:
                {
                alt111=5;
                }
                break;
            case 15:
                {
                alt111=6;
                }
                break;
            case 119:
                {
                alt111=7;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 41:
            case 71:
            case 99:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                {
                alt111=8;
                }
                break;
            case 120:
                {
                alt111=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("7357:1: (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7358:5: this_block_0= ruleblock
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleblock_in_rulestatement13560);
                    this_block_0=ruleblock();
                    _fsp--;

                     
                            current = this_block_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7367:6: ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7367:6: ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7367:8: 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )?
                    {
                    match(input,114,FOLLOW_114_in_rulestatement13576); 

                            createLeafNode(grammarAccess.getStatementAccess().getIfKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7371:1: ( (lv_condition_2_0= ruleparExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7372:1: (lv_condition_2_0= ruleparExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7372:1: (lv_condition_2_0= ruleparExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7373:3: lv_condition_2_0= ruleparExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getConditionParExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleparExpression_in_rulestatement13597);
                    lv_condition_2_0=ruleparExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"condition",
                    	        		lv_condition_2_0, 
                    	        		"parExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7395:2: ( (lv_state1_3_0= rulestatement ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7396:1: (lv_state1_3_0= rulestatement )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7396:1: (lv_state1_3_0= rulestatement )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7397:3: lv_state1_3_0= rulestatement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getState1StatementParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement13618);
                    lv_state1_3_0=rulestatement();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"state1",
                    	        		lv_state1_3_0, 
                    	        		"statement", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7419:2: ( 'else' ( (lv_state2_5_0= rulestatement ) ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==115) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7419:4: 'else' ( (lv_state2_5_0= rulestatement ) )
                            {
                            match(input,115,FOLLOW_115_in_rulestatement13629); 

                                    createLeafNode(grammarAccess.getStatementAccess().getElseKeyword_1_3_0(), null); 
                                
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7423:1: ( (lv_state2_5_0= rulestatement ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7424:1: (lv_state2_5_0= rulestatement )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7424:1: (lv_state2_5_0= rulestatement )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7425:3: lv_state2_5_0= rulestatement
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getState2StatementParserRuleCall_1_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_rulestatement_in_rulestatement13650);
                            lv_state2_5_0=rulestatement();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"state2",
                            	        		lv_state2_5_0, 
                            	        		"statement", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7448:6: ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7448:6: ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7448:8: 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) )
                    {
                    match(input,116,FOLLOW_116_in_rulestatement13670); 

                            createLeafNode(grammarAccess.getStatementAccess().getForKeyword_2_0(), null); 
                        
                    match(input,71,FOLLOW_71_in_rulestatement13680); 

                            createLeafNode(grammarAccess.getStatementAccess().getLeftParenthesisKeyword_2_1(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7456:1: ( (lv_control_8_0= ruleforControl ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7457:1: (lv_control_8_0= ruleforControl )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7457:1: (lv_control_8_0= ruleforControl )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7458:3: lv_control_8_0= ruleforControl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getControlForControlParserRuleCall_2_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleforControl_in_rulestatement13701);
                    lv_control_8_0=ruleforControl();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"control",
                    	        		lv_control_8_0, 
                    	        		"forControl", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,72,FOLLOW_72_in_rulestatement13711); 

                            createLeafNode(grammarAccess.getStatementAccess().getRightParenthesisKeyword_2_3(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7484:1: ( (lv_state_10_0= rulestatement ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7485:1: (lv_state_10_0= rulestatement )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7485:1: (lv_state_10_0= rulestatement )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7486:3: lv_state_10_0= rulestatement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getStateStatementParserRuleCall_2_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement13732);
                    lv_state_10_0=rulestatement();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"state",
                    	        		lv_state_10_0, 
                    	        		"statement", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7509:6: ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7509:6: ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7509:8: 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) )
                    {
                    match(input,117,FOLLOW_117_in_rulestatement13750); 

                            createLeafNode(grammarAccess.getStatementAccess().getWhileKeyword_3_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7513:1: ( (lv_condition_12_0= ruleparExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7514:1: (lv_condition_12_0= ruleparExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7514:1: (lv_condition_12_0= ruleparExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7515:3: lv_condition_12_0= ruleparExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getConditionParExpressionParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleparExpression_in_rulestatement13771);
                    lv_condition_12_0=ruleparExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"condition",
                    	        		lv_condition_12_0, 
                    	        		"parExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7537:2: ( (lv_state_13_0= rulestatement ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7538:1: (lv_state_13_0= rulestatement )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7538:1: (lv_state_13_0= rulestatement )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7539:3: lv_state_13_0= rulestatement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getStateStatementParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement13792);
                    lv_state_13_0=rulestatement();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"state",
                    	        		lv_state_13_0, 
                    	        		"statement", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7562:6: ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7562:6: ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7562:8: 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';'
                    {
                    match(input,118,FOLLOW_118_in_rulestatement13810); 

                            createLeafNode(grammarAccess.getStatementAccess().getReturnKeyword_4_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7566:1: ( (lv_retVal_15_0= ruleexpression ) )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( ((LA110_0>=RULE_STRING && LA110_0<=RULE_INT)||LA110_0==41||LA110_0==71||(LA110_0>=99 && LA110_0<=100)||(LA110_0>=102 && LA110_0<=108)) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7567:1: (lv_retVal_15_0= ruleexpression )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7567:1: (lv_retVal_15_0= ruleexpression )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7568:3: lv_retVal_15_0= ruleexpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getRetValExpressionParserRuleCall_4_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleexpression_in_rulestatement13831);
                            lv_retVal_15_0=ruleexpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"retVal",
                            	        		lv_retVal_15_0, 
                            	        		"expression", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,15,FOLLOW_15_in_rulestatement13842); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_4_2(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7595:7: ';'
                    {
                    match(input,15,FOLLOW_15_in_rulestatement13859); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7600:6: ( 'break' ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7600:6: ( 'break' ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7600:8: 'break' ';'
                    {
                    match(input,119,FOLLOW_119_in_rulestatement13876); 

                            createLeafNode(grammarAccess.getStatementAccess().getBreakKeyword_6_0(), null); 
                        
                    match(input,15,FOLLOW_15_in_rulestatement13886); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_6_1(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7609:6: (this_expression_20= ruleexpression ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7609:6: (this_expression_20= ruleexpression ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7610:5: this_expression_20= ruleexpression ';'
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getExpressionParserRuleCall_7_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleexpression_in_rulestatement13916);
                    this_expression_20=ruleexpression();
                    _fsp--;

                     
                            current = this_expression_20; 
                            currentNode = currentNode.getParent();
                        
                    match(input,15,FOLLOW_15_in_rulestatement13925); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_7_1(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7623:6: ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7623:6: ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7623:8: 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) )
                    {
                    match(input,120,FOLLOW_120_in_rulestatement13943); 

                            createLeafNode(grammarAccess.getStatementAccess().getTryKeyword_8_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7627:1: ( (lv_tryBlock_23_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7628:1: (lv_tryBlock_23_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7628:1: (lv_tryBlock_23_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7629:3: lv_tryBlock_23_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getTryBlockBlockParserRuleCall_8_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_rulestatement13964);
                    lv_tryBlock_23_0=ruleblock();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"tryBlock",
                    	        		lv_tryBlock_23_0, 
                    	        		"block", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,121,FOLLOW_121_in_rulestatement13974); 

                            createLeafNode(grammarAccess.getStatementAccess().getCatchKeyword_8_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7655:1: ( (lv_catchBlock_25_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7656:1: (lv_catchBlock_25_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7656:1: (lv_catchBlock_25_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7657:3: lv_catchBlock_25_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getCatchBlockBlockParserRuleCall_8_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_rulestatement13995);
                    lv_catchBlock_25_0=ruleblock();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"catchBlock",
                    	        		lv_catchBlock_25_0, 
                    	        		"block", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulestatement


    // $ANTLR start entryRuleforControl
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7687:1: entryRuleforControl returns [EObject current=null] : iv_ruleforControl= ruleforControl EOF ;
    public final EObject entryRuleforControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforControl = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7688:2: (iv_ruleforControl= ruleforControl EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7689:2: iv_ruleforControl= ruleforControl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForControlRule(), currentNode); 
            pushFollow(FOLLOW_ruleforControl_in_entryRuleforControl14032);
            iv_ruleforControl=ruleforControl();
            _fsp--;

             current =iv_ruleforControl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforControl14042); 

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
    // $ANTLR end entryRuleforControl


    // $ANTLR start ruleforControl
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7696:1: ruleforControl returns [EObject current=null] : ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? ) ;
    public final EObject ruleforControl() throws RecognitionException {
        EObject current = null;

        EObject lv_init_0_0 = null;

        EObject lv_condition_2_0 = null;

        EObject lv_update_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7701:6: ( ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7702:1: ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7702:1: ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7702:2: ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7702:2: ( (lv_init_0_0= ruleforInit ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( ((LA112_0>=RULE_STRING && LA112_0<=RULE_INT)||LA112_0==29||LA112_0==33||LA112_0==36||LA112_0==41||(LA112_0>=54 && LA112_0<=61)||LA112_0==71||(LA112_0>=99 && LA112_0<=100)||(LA112_0>=102 && LA112_0<=108)) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7703:1: (lv_init_0_0= ruleforInit )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7703:1: (lv_init_0_0= ruleforInit )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7704:3: lv_init_0_0= ruleforInit
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForControlAccess().getInitForInitParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleforInit_in_ruleforControl14088);
                    lv_init_0_0=ruleforInit();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getForControlRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"init",
                    	        		lv_init_0_0, 
                    	        		"forInit", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleforControl14099); 

                    createLeafNode(grammarAccess.getForControlAccess().getSemicolonKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7730:1: ( (lv_condition_2_0= ruleexpression ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( ((LA113_0>=RULE_STRING && LA113_0<=RULE_INT)||LA113_0==41||LA113_0==71||(LA113_0>=99 && LA113_0<=100)||(LA113_0>=102 && LA113_0<=108)) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7731:1: (lv_condition_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7731:1: (lv_condition_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7732:3: lv_condition_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForControlAccess().getConditionExpressionParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforControl14120);
                    lv_condition_2_0=ruleexpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getForControlRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"condition",
                    	        		lv_condition_2_0, 
                    	        		"expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleforControl14131); 

                    createLeafNode(grammarAccess.getForControlAccess().getSemicolonKeyword_3(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7758:1: ( (lv_update_4_0= ruleforUpdate ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( ((LA114_0>=RULE_STRING && LA114_0<=RULE_INT)||LA114_0==41||LA114_0==71||(LA114_0>=99 && LA114_0<=100)||(LA114_0>=102 && LA114_0<=108)) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7759:1: (lv_update_4_0= ruleforUpdate )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7759:1: (lv_update_4_0= ruleforUpdate )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7760:3: lv_update_4_0= ruleforUpdate
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForControlAccess().getUpdateForUpdateParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleforUpdate_in_ruleforControl14152);
                    lv_update_4_0=ruleforUpdate();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getForControlRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"update",
                    	        		lv_update_4_0, 
                    	        		"forUpdate", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleforControl


    // $ANTLR start entryRuleforInit
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7790:1: entryRuleforInit returns [EObject current=null] : iv_ruleforInit= ruleforInit EOF ;
    public final EObject entryRuleforInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforInit = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7791:2: (iv_ruleforInit= ruleforInit EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7792:2: iv_ruleforInit= ruleforInit EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForInitRule(), currentNode); 
            pushFollow(FOLLOW_ruleforInit_in_entryRuleforInit14189);
            iv_ruleforInit=ruleforInit();
            _fsp--;

             current =iv_ruleforInit; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforInit14199); 

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
    // $ANTLR end entryRuleforInit


    // $ANTLR start ruleforInit
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7799:1: ruleforInit returns [EObject current=null] : ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) ;
    public final EObject ruleforInit() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;

        EObject this_localVariableDeclaration_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7804:6: ( ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7805:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7805:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( ((LA116_0>=RULE_STRING && LA116_0<=RULE_INT)||LA116_0==41||LA116_0==71||(LA116_0>=99 && LA116_0<=100)||(LA116_0>=102 && LA116_0<=108)) ) {
                alt116=1;
            }
            else if ( (LA116_0==29||LA116_0==33||LA116_0==36||(LA116_0>=54 && LA116_0<=61)) ) {
                alt116=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("7805:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )", 116, 0, input);

                throw nvae;
            }
            switch (alt116) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7805:2: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7805:2: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7805:3: ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7805:3: ( (lv_expressions_0_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7806:1: (lv_expressions_0_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7806:1: (lv_expressions_0_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7807:3: lv_expressions_0_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforInit14246);
                    lv_expressions_0_0=ruleexpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getForInitRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"expressions",
                    	        		lv_expressions_0_0, 
                    	        		"expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7829:2: ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==28) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7829:4: ',' ( (lv_expressions_2_0= ruleexpression ) )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleforInit14257); 

                    	            createLeafNode(grammarAccess.getForInitAccess().getCommaKeyword_0_1_0(), null); 
                    	        
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7833:1: ( (lv_expressions_2_0= ruleexpression ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7834:1: (lv_expressions_2_0= ruleexpression )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7834:1: (lv_expressions_2_0= ruleexpression )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7835:3: lv_expressions_2_0= ruleexpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleexpression_in_ruleforInit14278);
                    	    lv_expressions_2_0=ruleexpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getForInitRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"expressions",
                    	    	        		lv_expressions_2_0, 
                    	    	        		"expression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop115;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7859:5: this_localVariableDeclaration_3= rulelocalVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getForInitAccess().getLocalVariableDeclarationParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclaration_in_ruleforInit14309);
                    this_localVariableDeclaration_3=rulelocalVariableDeclaration();
                    _fsp--;

                     
                            current = this_localVariableDeclaration_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleforInit


    // $ANTLR start entryRuleforUpdate
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7875:1: entryRuleforUpdate returns [EObject current=null] : iv_ruleforUpdate= ruleforUpdate EOF ;
    public final EObject entryRuleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforUpdate = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7876:2: (iv_ruleforUpdate= ruleforUpdate EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7877:2: iv_ruleforUpdate= ruleforUpdate EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForUpdateRule(), currentNode); 
            pushFollow(FOLLOW_ruleforUpdate_in_entryRuleforUpdate14344);
            iv_ruleforUpdate=ruleforUpdate();
            _fsp--;

             current =iv_ruleforUpdate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforUpdate14354); 

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
    // $ANTLR end entryRuleforUpdate


    // $ANTLR start ruleforUpdate
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7884:1: ruleforUpdate returns [EObject current=null] : this_expressionList_0= ruleexpressionList ;
    public final EObject ruleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject this_expressionList_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7889:6: (this_expressionList_0= ruleexpressionList )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7891:5: this_expressionList_0= ruleexpressionList
            {
             
                    currentNode=createCompositeNode(grammarAccess.getForUpdateAccess().getExpressionListParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleexpressionList_in_ruleforUpdate14400);
            this_expressionList_0=ruleexpressionList();
            _fsp--;

             
                    current = this_expressionList_0; 
                    currentNode = currentNode.getParent();
                

            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleforUpdate


    // $ANTLR start entryRuleattributeType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7907:1: entryRuleattributeType returns [String current=null] : iv_ruleattributeType= ruleattributeType EOF ;
    public final String entryRuleattributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleattributeType = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7908:2: (iv_ruleattributeType= ruleattributeType EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7909:2: iv_ruleattributeType= ruleattributeType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleattributeType_in_entryRuleattributeType14435);
            iv_ruleattributeType=ruleattributeType();
            _fsp--;

             current =iv_ruleattributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleattributeType14446); 

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
    // $ANTLR end entryRuleattributeType


    // $ANTLR start ruleattributeType
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7916:1: ruleattributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleattributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7921:6: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7922:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7922:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt117=11;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt117=1;
                }
                break;
            case 55:
                {
                alt117=2;
                }
                break;
            case 56:
                {
                alt117=3;
                }
                break;
            case 36:
                {
                alt117=4;
                }
                break;
            case 57:
                {
                alt117=5;
                }
                break;
            case 58:
                {
                alt117=6;
                }
                break;
            case 33:
                {
                alt117=7;
                }
                break;
            case 59:
                {
                alt117=8;
                }
                break;
            case 29:
                {
                alt117=9;
                }
                break;
            case 60:
                {
                alt117=10;
                }
                break;
            case 61:
                {
                alt117=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("7922:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7923:2: kw= 'Date'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleattributeType14484); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getDateKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7930:2: kw= 'Time'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleattributeType14503); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getTimeKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7937:2: kw= 'Double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleattributeType14522); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getDoubleKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7944:2: kw= 'double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_ruleattributeType14541); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getDoubleKeyword_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7951:2: kw= 'Integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_ruleattributeType14560); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getIntegerKeyword_4(), null); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7958:2: kw= 'integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,58,FOLLOW_58_in_ruleattributeType14579); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getIntegerKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7965:2: kw= 'int'
                    {
                    kw=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleattributeType14598); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getIntKeyword_6(), null); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7972:2: kw= 'Boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,59,FOLLOW_59_in_ruleattributeType14617); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getBooleanKeyword_7(), null); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7979:2: kw= 'boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleattributeType14636); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getBooleanKeyword_8(), null); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7986:2: kw= 'String'
                    {
                    kw=(Token)input.LT(1);
                    match(input,60,FOLLOW_60_in_ruleattributeType14655); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getStringKeyword_9(), null); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7993:2: kw= 'string'
                    {
                    kw=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_ruleattributeType14674); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getStringKeyword_10(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleattributeType


    // $ANTLR start entryRulephpFunction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8006:1: entryRulephpFunction returns [EObject current=null] : iv_rulephpFunction= rulephpFunction EOF ;
    public final EObject entryRulephpFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulephpFunction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8007:2: (iv_rulephpFunction= rulephpFunction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8008:2: iv_rulephpFunction= rulephpFunction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPhpFunctionRule(), currentNode); 
            pushFollow(FOLLOW_rulephpFunction_in_entryRulephpFunction14714);
            iv_rulephpFunction=rulephpFunction();
            _fsp--;

             current =iv_rulephpFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRulephpFunction14724); 

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
    // $ANTLR end entryRulephpFunction


    // $ANTLR start rulephpFunction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8015:1: rulephpFunction returns [EObject current=null] : ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) ) ;
    public final EObject rulephpFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8020:6: ( ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8021:1: ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8021:1: ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8021:3: 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) )
            {
            match(input,110,FOLLOW_110_in_rulephpFunction14759); 

                    createLeafNode(grammarAccess.getPhpFunctionAccess().getPublicKeyword_0(), null); 
                
            match(input,122,FOLLOW_122_in_rulephpFunction14769); 

                    createLeafNode(grammarAccess.getPhpFunctionAccess().getFunctionKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8029:1: ( (lv_name_2_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8030:1: (lv_name_2_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8030:1: (lv_name_2_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8031:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulephpFunction14786); 

            			createLeafNode(grammarAccess.getPhpFunctionAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPhpFunctionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8053:2: ( ( RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8054:1: ( RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8054:1: ( RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8055:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPhpFunctionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulephpFunction14809); 

            		createLeafNode(grammarAccess.getPhpFunctionAccess().getCodeblockPhpBlockCrossReference_3_0(), "codeblock"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulephpFunction


    // $ANTLR start entryRulerubyFunction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8077:1: entryRulerubyFunction returns [String current=null] : iv_rulerubyFunction= rulerubyFunction EOF ;
    public final String entryRulerubyFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerubyFunction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8078:2: (iv_rulerubyFunction= rulerubyFunction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8079:2: iv_rulerubyFunction= rulerubyFunction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRubyFunctionRule(), currentNode); 
            pushFollow(FOLLOW_rulerubyFunction_in_entryRulerubyFunction14848);
            iv_rulerubyFunction=rulerubyFunction();
            _fsp--;

             current =iv_rulerubyFunction.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerubyFunction14859); 

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
    // $ANTLR end entryRulerubyFunction


    // $ANTLR start rulerubyFunction
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8086:1: rulerubyFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_RUBY_FUNCTION_0= RULE_RUBY_FUNCTION ;
    public final AntlrDatatypeRuleToken rulerubyFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RUBY_FUNCTION_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8091:6: (this_RUBY_FUNCTION_0= RULE_RUBY_FUNCTION )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8092:5: this_RUBY_FUNCTION_0= RULE_RUBY_FUNCTION
            {
            this_RUBY_FUNCTION_0=(Token)input.LT(1);
            match(input,RULE_RUBY_FUNCTION,FOLLOW_RULE_RUBY_FUNCTION_in_rulerubyFunction14898); 

            		current.merge(this_RUBY_FUNCTION_0);
                
             
                createLeafNode(grammarAccess.getRubyFunctionAccess().getRUBY_FUNCTIONTerminalRuleCall(), null); 
                

            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulerubyFunction


    // $ANTLR start entryRuleextendedID
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8107:1: entryRuleextendedID returns [String current=null] : iv_ruleextendedID= ruleextendedID EOF ;
    public final String entryRuleextendedID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleextendedID = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8108:2: (iv_ruleextendedID= ruleextendedID EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8109:2: iv_ruleextendedID= ruleextendedID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExtendedIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleextendedID_in_entryRuleextendedID14943);
            iv_ruleextendedID=ruleextendedID();
            _fsp--;

             current =iv_ruleextendedID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleextendedID14954); 

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
    // $ANTLR end entryRuleextendedID


    // $ANTLR start ruleextendedID
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8116:1: ruleextendedID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleextendedID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8121:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8122:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8122:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8122:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID14994); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8129:1: (kw= '.' this_ID_2= RULE_ID )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==123) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8130:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,123,FOLLOW_123_in_ruleextendedID15013); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getExtendedIDAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID15028); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleextendedID


    // $ANTLR start entryRuleDOUBLE
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8150:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8151:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8152:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDOUBLERule(), currentNode); 
            pushFollow(FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE15076);
            iv_ruleDOUBLE=ruleDOUBLE();
            _fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOUBLE15087); 

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
    // $ANTLR end entryRuleDOUBLE


    // $ANTLR start ruleDOUBLE
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8159:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8164:6: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8165:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8165:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8165:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE15127); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,123,FOLLOW_123_in_ruleDOUBLE15145); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1(), null); 
                
            this_INT_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE15160); 

            		current.merge(this_INT_2);
                
             
                createLeafNode(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDOUBLE


    // $ANTLR start entryRulefileID
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8193:1: entryRulefileID returns [String current=null] : iv_rulefileID= rulefileID EOF ;
    public final String entryRulefileID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulefileID = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8194:2: (iv_rulefileID= rulefileID EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8195:2: iv_rulefileID= rulefileID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFileIDRule(), currentNode); 
            pushFollow(FOLLOW_rulefileID_in_entryRulefileID15206);
            iv_rulefileID=rulefileID();
            _fsp--;

             current =iv_rulefileID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulefileID15217); 

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
    // $ANTLR end entryRulefileID


    // $ANTLR start rulefileID
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8202:1: rulefileID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* ) ;
    public final AntlrDatatypeRuleToken rulefileID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CHARS_0 = null;

        AntlrDatatypeRuleToken this_CHARS_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8207:6: ( (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8208:1: (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8208:1: (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8209:5: this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getFileIDAccess().getCHARSParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCHARS_in_rulefileID15264);
            this_CHARS_0=ruleCHARS();
            _fsp--;


            		current.merge(this_CHARS_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8219:1: (this_CHARS_1= ruleCHARS )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( ((LA119_0>=RULE_ID && LA119_0<=RULE_INT)) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8220:5: this_CHARS_1= ruleCHARS
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getFileIDAccess().getCHARSParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleCHARS_in_rulefileID15292);
            	    this_CHARS_1=ruleCHARS();
            	    _fsp--;


            	    		current.merge(this_CHARS_1);
            	        
            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulefileID


    // $ANTLR start entryRuleCHARS
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8238:1: entryRuleCHARS returns [String current=null] : iv_ruleCHARS= ruleCHARS EOF ;
    public final String entryRuleCHARS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCHARS = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8239:2: (iv_ruleCHARS= ruleCHARS EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8240:2: iv_ruleCHARS= ruleCHARS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCHARSRule(), currentNode); 
            pushFollow(FOLLOW_ruleCHARS_in_entryRuleCHARS15340);
            iv_ruleCHARS=ruleCHARS();
            _fsp--;

             current =iv_ruleCHARS.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCHARS15351); 

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
    // $ANTLR end entryRuleCHARS


    // $ANTLR start ruleCHARS
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8247:1: ruleCHARS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleCHARS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_extendedID_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8252:6: ( (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8253:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8253:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==RULE_ID) ) {
                alt120=1;
            }
            else if ( (LA120_0==RULE_INT) ) {
                alt120=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("8253:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )", 120, 0, input);

                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8254:5: this_extendedID_0= ruleextendedID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCHARSAccess().getExtendedIDParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCHARS15398);
                    this_extendedID_0=ruleextendedID();
                    _fsp--;


                    		current.merge(this_extendedID_0);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8265:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCHARS15424); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getCHARSAccess().getINTTerminalRuleCall_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCHARS


    // $ANTLR start ruleModifier
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8280:1: ruleModifier returns [Enumerator current=null] : ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) ) ;
    public final Enumerator ruleModifier() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8284:6: ( ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8285:1: ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8285:1: ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) )
            int alt121=5;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt121=1;
                }
                break;
            case 125:
                {
                alt121=2;
                }
                break;
            case 126:
                {
                alt121=3;
                }
                break;
            case 127:
                {
                alt121=4;
                }
                break;
            case 128:
                {
                alt121=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("8285:1: ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) )", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8285:2: ( 'immutable' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8285:2: ( 'immutable' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8285:4: 'immutable'
                    {
                    match(input,124,FOLLOW_124_in_ruleModifier15481); 

                            current = grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8291:6: ( 'settable' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8291:6: ( 'settable' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8291:8: 'settable'
                    {
                    match(input,125,FOLLOW_125_in_ruleModifier15496); 

                            current = grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8297:6: ( 'internal' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8297:6: ( 'internal' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8297:8: 'internal'
                    {
                    match(input,126,FOLLOW_126_in_ruleModifier15511); 

                            current = grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8303:6: ( 'defaulted' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8303:6: ( 'defaulted' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8303:8: 'defaulted'
                    {
                    match(input,127,FOLLOW_127_in_ruleModifier15526); 

                            current = grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8309:6: ( 'const' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8309:6: ( 'const' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8309:8: 'const'
                    {
                    match(input,128,FOLLOW_128_in_ruleModifier15541); 

                            current = grammarAccess.getModifierAccess().getCONSTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getCONSTEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModifier


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA97 dfa97 = new DFA97(this);
    static final String DFA16_eotS =
        "\22\uffff";
    static final String DFA16_eofS =
        "\22\uffff";
    static final String DFA16_minS =
        "\1\5\2\uffff\3\5\4\uffff\1\5\1\uffff\1\6\2\uffff\1\17\2\5";
    static final String DFA16_maxS =
        "\1\u0080\2\uffff\1\173\2\55\4\uffff\1\5\1\uffff\1\56\2\uffff\1\173"+
        "\2\54";
    static final String DFA16_acceptS =
        "\1\uffff\1\11\1\1\3\uffff\1\4\1\5\1\7\1\10\1\uffff\1\6\1\uffff\1"+
        "\2\1\3\3\uffff";
    static final String DFA16_specialS =
        "\22\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\3\1\4\1\1\12\uffff\1\1\12\uffff\1\2\3\uffff\1\2\2\uffff\1"+
            "\2\11\uffff\1\5\3\uffff\2\2\2\uffff\10\2\1\uffff\1\6\20\uffff"+
            "\2\7\2\10\1\11\30\uffff\4\1\13\uffff\5\2",
            "",
            "",
            "\1\2\11\uffff\1\2\1\uffff\1\13\42\uffff\2\2\14\uffff\1\13\70"+
            "\uffff\1\12",
            "\1\16\42\uffff\4\16\1\15\1\14",
            "\1\16\42\uffff\4\16\1\15\1\14",
            "",
            "",
            "",
            "",
            "\1\17",
            "",
            "\1\20\47\uffff\1\21",
            "",
            "",
            "\1\2\1\uffff\1\13\43\uffff\1\2\14\uffff\1\13\70\uffff\1\12",
            "\1\16\42\uffff\4\16\1\15",
            "\1\16\42\uffff\4\16\1\15"
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()* loopback of 924:3: ( ( (lv_attributes_14_0= ruleUmpleAttribute ) ) | ( (lv_symmetricReflexiveAssociations_15_0= ruleSymmetricReflexiveAssociation ) ) | ( (lv_inlineAssociations_16_0= ruleInlineAssociation ) ) | ( (lv_depends_17_0= ruleDepend ) ) | ( (lv_positions_18_0= rulePosition ) ) | ( (lv_stateMachines_19_0= ruleStateMachine ) ) | ( (lv_traceDirectives_20_0= ruleTraceDirective ) ) | ( (lv_traceCases_21_0= ruleTraceCase ) ) )*";
        }
    }
    static final String DFA27_eotS =
        "\20\uffff";
    static final String DFA27_eofS =
        "\20\uffff";
    static final String DFA27_minS =
        "\1\4\2\uffff\3\5\1\uffff\1\5\1\uffff\1\6\1\5\2\uffff\2\5\1\17";
    static final String DFA27_maxS =
        "\1\u0080\2\uffff\2\55\1\173\1\uffff\1\173\1\uffff\1\56\1\5\2\uffff"+
        "\2\53\1\173";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\5\1\uffff\1\6\2\uffff\1\4\1\3\3\uffff";
    static final String DFA27_specialS =
        "\20\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\1\5\1\3\22\uffff\2\1\2\uffff\1\6\3\uffff\1\6\2\uffff\1"+
            "\6\11\uffff\1\4\3\uffff\2\6\2\uffff\10\6\1\uffff\1\2\74\uffff"+
            "\5\6",
            "",
            "",
            "\1\7\42\uffff\4\10\1\uffff\1\11",
            "\1\7\42\uffff\4\10\1\uffff\1\11",
            "\1\6\11\uffff\1\6\1\uffff\1\13\42\uffff\2\6\14\uffff\1\13\70"+
            "\uffff\1\12",
            "",
            "\1\14\11\uffff\1\14\30\uffff\4\10\117\uffff\1\14",
            "",
            "\1\15\47\uffff\1\16",
            "\1\17",
            "",
            "",
            "\1\7\42\uffff\4\10",
            "\1\7\42\uffff\4\10",
            "\1\6\1\uffff\1\13\43\uffff\1\6\14\uffff\1\13\70\uffff\1\12"
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1626:1: (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation )";
        }
    }
    static final String DFA51_eotS =
        "\13\uffff";
    static final String DFA51_eofS =
        "\13\uffff";
    static final String DFA51_minS =
        "\1\5\1\21\2\5\1\uffff\1\21\1\uffff\1\21\1\5\1\uffff\1\21";
    static final String DFA51_maxS =
        "\1\5\1\173\1\5\1\123\1\uffff\1\173\1\uffff\1\173\1\5\1\uffff\1\173";
    static final String DFA51_acceptS =
        "\4\uffff\1\3\1\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA51_specialS =
        "\13\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\1",
            "\1\3\60\uffff\1\4\70\uffff\1\2",
            "\1\5",
            "\1\7\14\uffff\1\6\60\uffff\3\6\14\uffff\2\6",
            "",
            "\1\3\60\uffff\1\4\70\uffff\1\2",
            "",
            "\1\6\1\11\11\uffff\1\11\136\uffff\1\10",
            "\1\12",
            "",
            "\1\6\1\11\11\uffff\1\11\136\uffff\1\10"
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "3054:1: (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )";
        }
    }
    static final String DFA61_eotS =
        "\11\uffff";
    static final String DFA61_eofS =
        "\11\uffff";
    static final String DFA61_minS =
        "\1\4\1\uffff\1\17\4\uffff\1\5\1\17";
    static final String DFA61_maxS =
        "\1\154\1\uffff\1\173\4\uffff\1\5\1\173";
    static final String DFA61_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\2\uffff";
    static final String DFA61_specialS =
        "\11\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\6\1\2\1\6\42\uffff\1\6\31\uffff\3\5\1\1\1\6\1\uffff\1\1\1"+
            "\uffff\2\3\1\4\1\1\3\uffff\2\5\17\uffff\2\6\1\uffff\7\6",
            "",
            "\1\6\1\uffff\1\5\26\uffff\1\1\1\6\4\uffff\1\6\6\uffff\1\6\21"+
            "\uffff\1\6\2\uffff\1\6\3\uffff\1\1\7\uffff\6\6\1\uffff\12\6"+
            "\24\uffff\1\7",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\6\1\uffff\1\5\27\uffff\1\6\4\uffff\1\6\6\uffff\1\6\21\uffff"+
            "\1\6\2\uffff\1\6\13\uffff\6\6\1\uffff\12\6\24\uffff\1\7"
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "3481:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) )";
        }
    }
    static final String DFA97_eotS =
        "\16\uffff";
    static final String DFA97_eofS =
        "\1\uffff\1\11\1\uffff\1\13\11\uffff\1\13";
    static final String DFA97_minS =
        "\1\4\1\16\1\uffff\1\16\6\uffff\1\5\2\uffff\1\16";
    static final String DFA97_maxS =
        "\1\154\1\173\1\uffff\1\173\6\uffff\1\5\2\uffff\1\173";
    static final String DFA97_acceptS =
        "\2\uffff\1\3\1\uffff\1\6\1\7\1\10\1\11\1\2\1\1\1\uffff\1\4\1\5\1"+
        "\uffff";
    static final String DFA97_specialS =
        "\16\uffff}>";
    static final String[] DFA97_transitionS = {
            "\1\2\1\3\1\1\142\uffff\1\4\1\5\1\6\1\7",
            "\2\11\14\uffff\1\11\14\uffff\1\11\4\uffff\1\11\6\uffff\1\11"+
            "\22\uffff\1\11\1\uffff\1\11\14\uffff\5\11\1\uffff\12\11\24\uffff"+
            "\1\10",
            "",
            "\2\13\14\uffff\1\13\14\uffff\1\13\4\uffff\1\13\6\uffff\1\13"+
            "\21\uffff\1\14\1\13\1\uffff\1\13\13\uffff\1\14\5\13\1\uffff"+
            "\12\13\24\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "",
            "",
            "\2\13\14\uffff\1\13\14\uffff\1\13\4\uffff\1\13\6\uffff\1\13"+
            "\21\uffff\1\14\1\13\1\uffff\1\13\13\uffff\1\14\5\13\1\uffff"+
            "\12\13\24\uffff\1\12"
    };

    static final short[] DFA97_eot = DFA.unpackEncodedString(DFA97_eotS);
    static final short[] DFA97_eof = DFA.unpackEncodedString(DFA97_eofS);
    static final char[] DFA97_min = DFA.unpackEncodedStringToUnsignedChars(DFA97_minS);
    static final char[] DFA97_max = DFA.unpackEncodedStringToUnsignedChars(DFA97_maxS);
    static final short[] DFA97_accept = DFA.unpackEncodedString(DFA97_acceptS);
    static final short[] DFA97_special = DFA.unpackEncodedString(DFA97_specialS);
    static final short[][] DFA97_transition;

    static {
        int numStates = DFA97_transitionS.length;
        DFA97_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA97_transition[i] = DFA.unpackEncodedString(DFA97_transitionS[i]);
        }
    }

    class DFA97 extends DFA {

        public DFA97(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 97;
            this.eot = DFA97_eot;
            this.eof = DFA97_eof;
            this.min = DFA97_min;
            this.max = DFA97_max;
            this.accept = DFA97_accept;
            this.special = DFA97_special;
            this.transition = DFA97_transition;
        }
        public String getDescription() {
            return "6495:1: ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' )";
        }
    }
 

    public static final BitSet FOLLOW_ruleUmpleModel_in_entryRuleUmpleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleUmpleModel131 = new BitSet(new long[]{0x000000E006890012L,0x0000000010000002L});
    public static final BitSet FOLLOW_ruleGlossary_in_ruleUmpleModel153 = new BitSet(new long[]{0x000000E006880012L,0x0000000010000002L});
    public static final BitSet FOLLOW_ruleGenerate_in_ruleUmpleModel175 = new BitSet(new long[]{0x000000E006800012L,0x0000000010000002L});
    public static final BitSet FOLLOW_ruleTraceMechanism_in_ruleUmpleModel197 = new BitSet(new long[]{0x000000E006800012L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUseStatement_in_ruleUmpleModel220 = new BitSet(new long[]{0x000000E006800012L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleElement_in_ruleUmpleModel247 = new BitSet(new long[]{0x000000E006800012L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAssociation_in_ruleUmpleModel274 = new BitSet(new long[]{0x000000E006800012L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAssociationClass_in_ruleUmpleModel301 = new BitSet(new long[]{0x000000E006800012L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachineDefinition_in_ruleUmpleModel328 = new BitSet(new long[]{0x000000E006800012L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleElement_in_entryRuleUmpleElement366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleElement376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleClass_in_ruleUmpleElement423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleInterface_in_ruleUmpleElement450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWord537 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleWord552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWord569 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleWord584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlossary_in_entryRuleGlossary620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlossary630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleGlossary674 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGlossary684 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleWord_in_ruleGlossary705 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleGlossary716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGenerate_in_entryRuleGenerate752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGenerate762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleGenerate797 = new BitSet(new long[]{0x0000000000700000L});
    public static final BitSet FOLLOW_20_in_ruleGenerate816 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_21_in_ruleGenerate853 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_22_in_ruleGenerate890 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGenerate914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUseStatement_in_entryRuleUseStatement951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUseStatement962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleUseStatement1000 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rulefileID_in_ruleUseStatement1022 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUseStatement1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleNamespace1125 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rulefileID_in_ruleNamespace1146 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNamespace1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleClass_in_entryRuleUmpleClass1192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleClass1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUmpleClass1253 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleUmpleClass1277 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleUmpleClass1301 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleClass1318 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleUmpleClass1333 = new BitSet(new long[]{0xFFCFC012280400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSingleton_in_ruleUmpleClass1354 = new BitSet(new long[]{0xFFCF4012280400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleKey_in_ruleUmpleClass1376 = new BitSet(new long[]{0xBFCF4012280400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleCodeInjection_in_ruleUmpleClass1398 = new BitSet(new long[]{0xBFCC4012280400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_27_in_ruleUmpleClass1410 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleClass1428 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_28_in_ruleUmpleClass1439 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleClass1457 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleClass1469 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleUmpleAttribute_in_ruleUmpleClass1493 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_ruleUmpleClass1520 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_ruleUmpleClass1547 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleUmpleClass1574 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rulePosition_in_ruleUmpleClass1601 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleUmpleClass1628 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleTraceDirective_in_ruleUmpleClass1655 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleTraceCase_in_ruleUmpleClass1682 = new BitSet(new long[]{0xBFCC4012200400E0L,0xF001E000001F0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleExternalLanguage_in_ruleUmpleClass1705 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUmpleClass1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalLanguage_in_entryRuleExternalLanguage1752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalLanguage1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulefunctionDefinition_in_ruleExternalLanguage1808 = new BitSet(new long[]{0x0000000000000002L,0x0001E00000000000L});
    public static final BitSet FOLLOW_rulerubyFunction_in_ruleExternalLanguage1836 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rulephpFunction_in_ruleExternalLanguage1864 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveType1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePrimitiveType1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePrimitiveType1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rulePrimitiveType1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rulePrimitiveType2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulePrimitiveType2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rulePrimitiveType2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rulePrimitiveType2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rulePrimitiveType2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleInterface_in_entryRuleUmpleInterface2124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleInterface2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleUmpleInterface2169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleInterface2186 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleUmpleInterface2201 = new BitSet(new long[]{0x8000000000040000L,0x0001E00000000000L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleUmpleInterface2222 = new BitSet(new long[]{0x8000000000040000L,0x0001E00000000000L});
    public static final BitSet FOLLOW_rulefunctionDeclaration_in_ruleUmpleInterface2245 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleInterface2255 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUmpleInterface2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAssociation_in_entryRuleUmpleAssociation2303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAssociation2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleUmpleAssociation2348 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleAssociation2365 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleUmpleAssociation2381 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_ruleAssociation_in_ruleUmpleAssociation2402 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUmpleAssociation2412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAssociationClass_in_entryRuleUmpleAssociationClass2448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAssociationClass2458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUmpleAssociationClass2493 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleAssociationClass2510 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleUmpleAssociationClass2525 = new BitSet(new long[]{0xBFCC401226040070L,0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleassociationClassContent_in_ruleUmpleAssociationClass2546 = new BitSet(new long[]{0xBFCC401226040070L,0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_18_in_ruleUmpleAssociationClass2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleassociationClassContent_in_entryRuleassociationClassContent2593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleassociationClassContent2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleClass_in_ruleassociationClassContent2650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleassociationClassContent2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesingleAssociationEnd_in_ruleassociationClassContent2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleassociationClassContent2731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttribute_in_ruleassociationClassContent2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_ruleassociationClassContent2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociation_in_entryRuleAssociation2820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociation2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation2871 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2887 = new BitSet(new long[]{0x00000F0000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2909 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_40_in_ruleAssociation2926 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_41_in_ruleAssociation2942 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_42_in_ruleAssociation2958 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_43_in_ruleAssociation2974 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation2991 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation3007 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation3029 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssociation3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation3081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation3091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation3132 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleSymmetricReflexiveAssociation3141 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation3158 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSymmetricReflexiveAssociation3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation3209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineAssociation3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation3260 = new BitSet(new long[]{0x00000F0000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3276 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_40_in_ruleInlineAssociation3293 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_41_in_ruleInlineAssociation3309 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_42_in_ruleInlineAssociation3325 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_43_in_ruleInlineAssociation3341 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation3358 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3374 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3396 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInlineAssociation3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesingleAssociationEnd_in_entryRulesingleAssociationEnd3448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulesingleAssociationEnd3458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_rulesingleAssociationEnd3499 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulesingleAssociationEnd3519 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulesingleAssociationEnd3536 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulesingleAssociationEnd3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_entryRulemultiplicity3589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicity3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity3681 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_rulemultiplicity3699 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_entryRulebound3768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulebound3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulebound3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rulebound3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleton_in_entryRuleSingleton3883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleton3893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSingleton3936 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSingleton3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection3995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodeInjection4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleCodeInjection4041 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection4062 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleCodeInjection4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleCodeInjection4101 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection4122 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleCodeInjection4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttribute_in_entryRuleUmpleAttribute4180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAttribute4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleUmpleAttribute4234 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleUmpleAttribute4268 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleAttribute4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUmpleAttribute4304 = new BitSet(new long[]{0x3FC0001220000020L,0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleModifier_in_ruleUmpleAttribute4339 = new BitSet(new long[]{0x3FC0001220000020L});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_ruleUmpleAttribute4363 = new BitSet(new long[]{0x0010000000000020L});
    public static final BitSet FOLLOW_52_in_ruleUmpleAttribute4381 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleAttribute4421 = new BitSet(new long[]{0x0010000000000020L});
    public static final BitSet FOLLOW_52_in_ruleUmpleAttribute4439 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleUmpleAttribute4477 = new BitSet(new long[]{0x0020000000008000L});
    public static final BitSet FOLLOW_53_in_ruleUmpleAttribute4488 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_ruleUmpleAttribute4509 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleAttribute4521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType4559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmplePrimitiveType4570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUmplePrimitiveType4610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType4636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType4682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAttributeType4693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUmpleAttributeType4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUmpleAttributeType4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleUmpleAttributeType4769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUmpleAttributeType4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleUmpleAttributeType4807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUmpleAttributeType4826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleUmpleAttributeType4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUmpleAttributeType4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleUmpleAttributeType4883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUmpleAttributeType4902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUmpleAttributeType4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKey_in_entryRuleKey4961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKey4971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleKey5006 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKey5025 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKey5043 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleKey5059 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKey5076 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_ruleKey5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_entryRuleDepend5131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDepend5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleDepend5176 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleDepend5197 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleDepend5208 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDepend5220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachineDefinition_in_entryRuleStateMachineDefinition5256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachineDefinition5266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleStateMachineDefinition5301 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleStateMachineDefinition5322 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStateMachineDefinition5332 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachineDefinition5353 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_18_in_ruleStateMachineDefinition5364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine5400 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine5410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleENUM_in_ruleStateMachine5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStateMachine_in_ruleStateMachine5484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedStateMachine_in_ruleStateMachine5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStateMachine_in_entryRuleInlineStateMachine5546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineStateMachine5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleInlineStateMachine5602 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInlineStateMachine5612 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_ruleState_in_ruleInlineStateMachine5633 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_18_in_ruleInlineStateMachine5644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedStateMachine_in_entryRuleReferencedStateMachine5680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedStateMachine5690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleReferencedStateMachine5736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleReferencedStateMachine5746 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedStateMachine5764 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleReferencedStateMachine5774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleENUM_in_entryRuleENUM5810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleENUM5820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleENUM5866 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleENUM5876 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleENUM5897 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleENUM5908 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleENUM5929 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_ruleENUM5941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState5977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState5987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceDirective_in_ruleState6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleState6051 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_ruleState6064 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleState6077 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleState6100 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState6110 = new BitSet(new long[]{0x0000420000040070L,0x00001FD8000C7AF8L});
    public static final BitSet FOLLOW_46_in_ruleState6122 = new BitSet(new long[]{0x0000020000000070L,0x00001FD8000C7AF8L});
    public static final BitSet FOLLOW_ruleStateEntity_in_ruleState6145 = new BitSet(new long[]{0x0000420000040070L,0x00001FD8000C7AF8L});
    public static final BitSet FOLLOW_18_in_ruleState6157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateEntity_in_entryRuleStateEntity6194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateEntity6204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateEntity6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryOrExitAction_in_ruleStateEntity6278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivity_in_ruleStateEntity6306 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleStateEntity6316 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleStateEntity6332 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStateEntity6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateEntity6372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleStateEntity6399 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStateEntity6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition6446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition6456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTransition6504 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000240L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleTransition6524 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleTransition6534 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransition6555 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleTransition6577 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransition6587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleTransition6617 = new BitSet(new long[]{0x0000010000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTransition6637 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleTransition6648 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransition6669 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleTransition6691 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransition6701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition6738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition6748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedEvent_in_ruleEventDefinition6799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWaitEvent_in_ruleEventDefinition6831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDefinition6854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedEvent_in_entryRuleTimedEvent6896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimedEvent6907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleTimedEvent6945 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleTimedEvent6958 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimedEvent6974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTimedEvent7000 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleTimedEvent7019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWaitEvent_in_entryRuleWaitEvent7060 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWaitEvent7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleWaitEvent7109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleWaitEvent7122 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleWaitEvent7138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWaitEvent7164 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleWaitEvent7183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction7223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction7233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleAction7268 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleAction7289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryOrExitAction_in_entryRuleEntryOrExitAction7325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryOrExitAction7335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleEntryOrExitAction7379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_76_in_ruleEntryOrExitAction7416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleEntryOrExitAction7440 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleEntryOrExitAction7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivity_in_entryRuleActivity7497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivity7507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleActivity7542 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleActivity7563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard7599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard7609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleGuard7644 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleGuardCode_in_ruleGuard7666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleGuard7675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardCode_in_entryRuleGuardCode7711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardCode7721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_ruleGuardCode7766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_entryRulePosition7801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePosition7811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_rulePosition7857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassPosition_in_rulePosition7884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassPosition_in_entryRuleClassPosition7920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassPosition7930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleClassPosition7965 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition7982 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition8004 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition8026 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition8048 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleClassPosition8063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition8099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationPosition8109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleAssociationPosition8144 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssociationPosition8161 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition8187 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition8208 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssociationPosition8218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinate_in_entryRuleCoordinate8254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinate8264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate8306 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleCoordinate8321 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate8338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceDirective_in_entryRuleTraceDirective8379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTraceDirective8389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleTraceDirective8434 = new BitSet(new long[]{0x0000000000000020L,0x0000000000201800L});
    public static final BitSet FOLLOW_83_in_ruleTraceDirective8463 = new BitSet(new long[]{0x0000000000000020L,0x0000000000201800L});
    public static final BitSet FOLLOW_ruleModelElement_in_ruleTraceDirective8500 = new BitSet(new long[]{0x0000400000000002L,0x000000000F800000L});
    public static final BitSet FOLLOW_ruleConditionRHS_in_ruleTraceDirective8521 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleTraceDirective8540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceCase_in_entryRuleTraceCase8590 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTraceCase8600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleTraceCase8635 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTraceCase8652 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTraceCase8667 = new BitSet(new long[]{0x0000000000040000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_ruleTraceDirective_in_ruleTraceCase8688 = new BitSet(new long[]{0x0000000000040000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleTraceCase8699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundTraceCondition_in_entryRuleCompoundTraceCondition8739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompoundTraceCondition8749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCompoundTraceCondition8790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTraceCondition_in_entryRuleSimpleTraceCondition8830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTraceCondition8840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElement_in_ruleSimpleTraceCondition8886 = new BitSet(new long[]{0x0000000000000000L,0x000000000F800000L});
    public static final BitSet FOLLOW_ruleConditionRHS_in_ruleSimpleTraceCondition8907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionRHS_in_entryRuleConditionRHS8943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionRHS8953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonOperator_in_ruleConditionRHS8999 = new BitSet(new long[]{0x0000001FE0000000L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleConditionRHS9020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement9056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElement9066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleModelElement9111 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_76_in_ruleModelElement9148 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_85_in_ruleModelElement9185 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement9217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleModelElement9232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement9257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonOperator_in_entryRuleComparisonOperator9294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparisonOperator9305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleComparisonOperator9343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleComparisonOperator9362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleComparisonOperator9381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleComparisonOperator9400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleComparisonOperator9419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceMechanism_in_entryRuleTraceMechanism9459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTraceMechanism9469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleTraceMechanism9504 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTraceMechanism9521 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTraceMechanism9536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_entryRuleblock9572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblock9582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleblock9617 = new BitSet(new long[]{0x3FC0021220068070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_ruleblockStatement_in_ruleblock9638 = new BitSet(new long[]{0x3FC0021220068070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_18_in_ruleblock9649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_entryRuleparExpression9685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleparExpression9695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleparExpression9730 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleparExpression9752 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleparExpression9761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator9798 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleassignmentOperator9809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleassignmentOperator9847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleassignmentOperator9866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleassignmentOperator9885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_entryRuleexpressionList9925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpressionList9935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList9981 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleexpressionList9992 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList10013 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleexpression_in_entryRuleexpression10051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpression10061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_ruleexpression10107 = new BitSet(new long[]{0x0020000000000002L,0x0000000060000000L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_ruleexpression10124 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpression10144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression10182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalExpression10192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression10238 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleconditionalExpression10249 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression10270 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleconditionalExpression10280 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression10301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression10339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalOrExpression10349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10395 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_ruleconditionalOrExpression10406 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10427 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression10465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalAndExpression10475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10521 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ruleconditionalAndExpression10532 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10553 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression10591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleequalityExpression10601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression10647 = new BitSet(new long[]{0x0000000000000002L,0x0000000402000000L});
    public static final BitSet FOLLOW_89_in_ruleequalityExpression10659 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_98_in_ruleequalityExpression10675 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression10697 = new BitSet(new long[]{0x0000000000000002L,0x0000000402000000L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression10735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalExpression10745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10791 = new BitSet(new long[]{0x0000000000000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_rulerelationalOp_in_rulerelationalExpression10808 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10828 = new BitSet(new long[]{0x0000000000000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_rulerelationalOp_in_entryRulerelationalOp10867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalOp10878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rulerelationalOp10916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_rulerelationalOp10935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rulerelationalOp10954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_rulerelationalOp10973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression11013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleadditiveExpression11023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11069 = new BitSet(new long[]{0x0000000000000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_99_in_ruleadditiveExpression11081 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_100_in_ruleadditiveExpression11097 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11119 = new BitSet(new long[]{0x0000000000000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression11157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicativeExpression11167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11213 = new BitSet(new long[]{0x0000400000000002L,0x0000002000000400L});
    public static final BitSet FOLLOW_46_in_rulemultiplicativeExpression11225 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_74_in_rulemultiplicativeExpression11241 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_101_in_rulemultiplicativeExpression11257 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11279 = new BitSet(new long[]{0x0000400000000002L,0x0000002000000400L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression11317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpression11327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleunaryExpression11363 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleunaryExpression11402 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleunaryExpression11441 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleunaryExpression11480 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression11529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus11565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus11575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleunaryExpressionNotPlusMinus11611 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleunaryExpressionNotPlusMinus11650 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus11701 = new BitSet(new long[]{0x0000020000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_ruleunaryExpressionNotPlusMinus11711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleunaryExpressionNotPlusMinus11727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_entryRuleprimary11766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimary11776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_ruleprimary11823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_ruleprimary11850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_entryRuleliteral11885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleliteral11895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleliteral11929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleliteral11950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleliteral11964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleliteral11985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_ruleliteral12012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleliteral12027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleliteral12043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleliteral12059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleliteral12075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulefunctionDeclaration_in_entryRulefunctionDeclaration12113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulefunctionDeclaration12123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_rulefunctionDeclaration12168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulefunctionDefinition_in_entryRulefunctionDefinition12203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulefunctionDefinition12213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDefinition_in_rulefunctionDefinition12258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration12293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDeclaration12303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_rulejavaFunctionDeclaration12339 = new BitSet(new long[]{0x0000000000000000L,0x0001C00000000000L});
    public static final BitSet FOLLOW_110_in_rulejavaFunctionDeclaration12352 = new BitSet(new long[]{0x3FC0001220000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_111_in_rulejavaFunctionDeclaration12368 = new BitSet(new long[]{0x3FC0001220000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_112_in_rulejavaFunctionDeclaration12384 = new BitSet(new long[]{0x3FC0001220000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12407 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_113_in_rulejavaFunctionDeclaration12423 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12446 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12469 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400080L});
    public static final BitSet FOLLOW_71_in_rulejavaFunctionDeclaration12486 = new BitSet(new long[]{0x3FC0001220000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12508 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12529 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_28_in_rulejavaFunctionDeclaration12540 = new BitSet(new long[]{0x3FC0001220000000L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12561 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12582 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rulejavaFunctionDeclaration12596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rulejavaFunctionDeclaration12613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition12650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDefinition12660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition12706 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_rulejavaFunctionDefinition12727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall12763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionCall12773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionCall12819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400080L});
    public static final BitSet FOLLOW_71_in_rulejavaFunctionCall12831 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000180L});
    public static final BitSet FOLLOW_ruleexpressionList_in_rulejavaFunctionCall12852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rulejavaFunctionCall12863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rulejavaFunctionCall12880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblockStatement_in_entryRuleblockStatement12917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblockStatement12927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_ruleblockStatement12974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement13001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement13036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement13046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement13093 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulelocalVariableDeclarationStatement13102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration13138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclaration13148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration13194 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration13215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators13251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarators13261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13307 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_rulevariableDeclarators13318 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13339 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator13377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarator13387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulevariableDeclarator13433 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_rulevariableDeclarator13444 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_rulevariableDeclarator13465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_entryRulestatement13503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulestatement13513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement13560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_rulestatement13576 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleparExpression_in_rulestatement13597 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13618 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_rulestatement13629 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_rulestatement13670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_rulestatement13680 = new BitSet(new long[]{0x3FC0021220008070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleforControl_in_rulestatement13701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rulestatement13711 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_rulestatement13750 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleparExpression_in_rulestatement13771 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_rulestatement13810 = new BitSet(new long[]{0x0000020000008070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_rulestatement13831 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulestatement13842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rulestatement13859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_rulestatement13876 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulestatement13886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_rulestatement13916 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulestatement13925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_rulestatement13943 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement13964 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_rulestatement13974 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement13995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforControl_in_entryRuleforControl14032 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforControl14042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_ruleforControl14088 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleforControl14099 = new BitSet(new long[]{0x0000020000008070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforControl14120 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleforControl14131 = new BitSet(new long[]{0x0000020000000072L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleforUpdate_in_ruleforControl14152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_entryRuleforInit14189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforInit14199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit14246 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleforInit14257 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit14278 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_ruleforInit14309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforUpdate_in_entryRuleforUpdate14344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforUpdate14354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_ruleforUpdate14400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_entryRuleattributeType14435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleattributeType14446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleattributeType14484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleattributeType14503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleattributeType14522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleattributeType14541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleattributeType14560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleattributeType14579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleattributeType14598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleattributeType14617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleattributeType14636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleattributeType14655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleattributeType14674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulephpFunction_in_entryRulephpFunction14714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulephpFunction14724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_rulephpFunction14759 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_rulephpFunction14769 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulephpFunction14786 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulephpFunction14809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerubyFunction_in_entryRulerubyFunction14848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerubyFunction14859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RUBY_FUNCTION_in_rulerubyFunction14898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_entryRuleextendedID14943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleextendedID14954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID14994 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_ruleextendedID15013 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID15028 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE15076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE15087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE15127 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_ruleDOUBLE15145 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE15160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulefileID_in_entryRulefileID15206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulefileID15217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCHARS_in_rulefileID15264 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_ruleCHARS_in_rulefileID15292 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_ruleCHARS_in_entryRuleCHARS15340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCHARS15351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCHARS15398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCHARS15424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleModifier15481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleModifier15496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleModifier15511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleModifier15526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_ruleModifier15541 = new BitSet(new long[]{0x0000000000000002L});

}