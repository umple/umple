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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1343:1: ruleUmpleInterface returns [EObject current=null] : ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_extraCode_9_0= rulefunctionDeclaration ) ) ';' )? '}' ) ;
    public final EObject ruleUmpleInterface() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_depends_3_0 = null;

        EObject lv_extraCode_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1348:6: ( ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_extraCode_9_0= rulefunctionDeclaration ) ) ';' )? '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1349:1: ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_extraCode_9_0= rulefunctionDeclaration ) ) ';' )? '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1349:1: ( 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_extraCode_9_0= rulefunctionDeclaration ) ) ';' )? '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1349:3: 'interface' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_depends_3_0= ruleDepend ) )* ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )? ( ( (lv_extraCode_9_0= rulefunctionDeclaration ) ) ';' )? '}'
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1405:3: ( 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==27) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1405:5: 'isA' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ';'
                    {
                    match(input,27,FOLLOW_27_in_ruleUmpleInterface2234); 

                            createLeafNode(grammarAccess.getUmpleInterfaceAccess().getIsAKeyword_4_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1409:1: ( ( RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1410:1: ( RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1410:1: ( RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1411:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleInterfaceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleInterface2252); 

                    		createLeafNode(grammarAccess.getUmpleInterfaceAccess().getExtendsInterfaceUmpleInterfaceCrossReference_4_1_0(), "extendsInterface"); 
                    	

                    }


                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1423:2: ( ',' ( ( RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==28) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1423:4: ',' ( ( RULE_ID ) )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleUmpleInterface2263); 

                    	            createLeafNode(grammarAccess.getUmpleInterfaceAccess().getCommaKeyword_4_2_0(), null); 
                    	        
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1427:1: ( ( RULE_ID ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1428:1: ( RULE_ID )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1428:1: ( RULE_ID )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1429:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getUmpleInterfaceRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleInterface2281); 

                    	    		createLeafNode(grammarAccess.getUmpleInterfaceAccess().getExtendsInterfaceUmpleInterfaceCrossReference_4_2_1_0(), "extendsInterface"); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    match(input,15,FOLLOW_15_in_ruleUmpleInterface2293); 

                            createLeafNode(grammarAccess.getUmpleInterfaceAccess().getSemicolonKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1445:3: ( ( (lv_extraCode_9_0= rulefunctionDeclaration ) ) ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=109 && LA26_0<=112)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1445:4: ( (lv_extraCode_9_0= rulefunctionDeclaration ) ) ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1445:4: ( (lv_extraCode_9_0= rulefunctionDeclaration ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1446:1: (lv_extraCode_9_0= rulefunctionDeclaration )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1446:1: (lv_extraCode_9_0= rulefunctionDeclaration )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1447:3: lv_extraCode_9_0= rulefunctionDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleInterfaceAccess().getExtraCodeFunctionDeclarationParserRuleCall_5_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulefunctionDeclaration_in_ruleUmpleInterface2317);
                    lv_extraCode_9_0=rulefunctionDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUmpleInterfaceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"extraCode",
                    	        		lv_extraCode_9_0, 
                    	        		"functionDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleUmpleInterface2327); 

                            createLeafNode(grammarAccess.getUmpleInterfaceAccess().getSemicolonKeyword_5_1(), null); 
                        

                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleUmpleInterface2339); 

                    createLeafNode(grammarAccess.getUmpleInterfaceAccess().getRightCurlyBracketKeyword_6(), null); 
                

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1485:1: entryRuleUmpleAssociation returns [EObject current=null] : iv_ruleUmpleAssociation= ruleUmpleAssociation EOF ;
    public final EObject entryRuleUmpleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1486:2: (iv_ruleUmpleAssociation= ruleUmpleAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1487:2: iv_ruleUmpleAssociation= ruleUmpleAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAssociation_in_entryRuleUmpleAssociation2375);
            iv_ruleUmpleAssociation=ruleUmpleAssociation();
            _fsp--;

             current =iv_ruleUmpleAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAssociation2385); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1494:1: ruleUmpleAssociation returns [EObject current=null] : ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' ) ;
    public final EObject ruleUmpleAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_associations_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1499:6: ( ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1500:1: ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1500:1: ( 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1500:3: 'association' ( (lv_name_1_0= RULE_ID ) )? '{' ( (lv_associations_3_0= ruleAssociation ) ) '}'
            {
            match(input,38,FOLLOW_38_in_ruleUmpleAssociation2420); 

                    createLeafNode(grammarAccess.getUmpleAssociationAccess().getAssociationKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1504:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1505:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1505:1: (lv_name_1_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1506:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleAssociation2437); 

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

            match(input,17,FOLLOW_17_in_ruleUmpleAssociation2453); 

                    createLeafNode(grammarAccess.getUmpleAssociationAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1532:1: ( (lv_associations_3_0= ruleAssociation ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1533:1: (lv_associations_3_0= ruleAssociation )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1533:1: (lv_associations_3_0= ruleAssociation )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1534:3: lv_associations_3_0= ruleAssociation
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUmpleAssociationAccess().getAssociationsAssociationParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssociation_in_ruleUmpleAssociation2474);
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

            match(input,18,FOLLOW_18_in_ruleUmpleAssociation2484); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1568:1: entryRuleUmpleAssociationClass returns [EObject current=null] : iv_ruleUmpleAssociationClass= ruleUmpleAssociationClass EOF ;
    public final EObject entryRuleUmpleAssociationClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleAssociationClass = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1569:2: (iv_ruleUmpleAssociationClass= ruleUmpleAssociationClass EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1570:2: iv_ruleUmpleAssociationClass= ruleUmpleAssociationClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAssociationClassRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAssociationClass_in_entryRuleUmpleAssociationClass2520);
            iv_ruleUmpleAssociationClass=ruleUmpleAssociationClass();
            _fsp--;

             current =iv_ruleUmpleAssociationClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAssociationClass2530); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1577:1: ruleUmpleAssociationClass returns [EObject current=null] : ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' ) ;
    public final EObject ruleUmpleAssociationClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_associationClassContents_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1582:6: ( ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1583:1: ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1583:1: ( 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1583:3: 'associationClass' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )* '}'
            {
            match(input,39,FOLLOW_39_in_ruleUmpleAssociationClass2565); 

                    createLeafNode(grammarAccess.getUmpleAssociationClassAccess().getAssociationClassKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1587:1: ( (lv_name_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1588:1: (lv_name_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1588:1: (lv_name_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1589:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleAssociationClass2582); 

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

            match(input,17,FOLLOW_17_in_ruleUmpleAssociationClass2597); 

                    createLeafNode(grammarAccess.getUmpleAssociationClassAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1615:1: ( (lv_associationClassContents_3_0= ruleassociationClassContent ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_INT)||(LA28_0>=25 && LA28_0<=26)||LA28_0==29||LA28_0==33||LA28_0==36||LA28_0==46||(LA28_0>=50 && LA28_0<=51)||(LA28_0>=54 && LA28_0<=61)||LA28_0==63||(LA28_0>=124 && LA28_0<=128)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1616:1: (lv_associationClassContents_3_0= ruleassociationClassContent )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1616:1: (lv_associationClassContents_3_0= ruleassociationClassContent )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1617:3: lv_associationClassContents_3_0= ruleassociationClassContent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getUmpleAssociationClassAccess().getAssociationClassContentsAssociationClassContentParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleassociationClassContent_in_ruleUmpleAssociationClass2618);
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
            	    break loop28;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleUmpleAssociationClass2629); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1651:1: entryRuleassociationClassContent returns [EObject current=null] : iv_ruleassociationClassContent= ruleassociationClassContent EOF ;
    public final EObject entryRuleassociationClassContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleassociationClassContent = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1652:2: (iv_ruleassociationClassContent= ruleassociationClassContent EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1653:2: iv_ruleassociationClassContent= ruleassociationClassContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociationClassContentRule(), currentNode); 
            pushFollow(FOLLOW_ruleassociationClassContent_in_entryRuleassociationClassContent2665);
            iv_ruleassociationClassContent=ruleassociationClassContent();
            _fsp--;

             current =iv_ruleassociationClassContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleassociationClassContent2675); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1660:1: ruleassociationClassContent returns [EObject current=null] : (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation ) ;
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
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1665:6: ( (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1666:1: (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1666:1: (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation )
            int alt29=6;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1667:5: this_UmpleClass_0= ruleUmpleClass
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getUmpleClassParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUmpleClass_in_ruleassociationClassContent2722);
                    this_UmpleClass_0=ruleUmpleClass();
                    _fsp--;

                     
                            current = this_UmpleClass_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1677:5: this_Depend_1= ruleDepend
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getDependParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDepend_in_ruleassociationClassContent2749);
                    this_Depend_1=ruleDepend();
                    _fsp--;

                     
                            current = this_Depend_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1687:5: this_singleAssociationEnd_2= rulesingleAssociationEnd
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getSingleAssociationEndParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_rulesingleAssociationEnd_in_ruleassociationClassContent2776);
                    this_singleAssociationEnd_2=rulesingleAssociationEnd();
                    _fsp--;

                     
                            current = this_singleAssociationEnd_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1697:5: this_StateMachine_3= ruleStateMachine
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getStateMachineParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStateMachine_in_ruleassociationClassContent2803);
                    this_StateMachine_3=ruleStateMachine();
                    _fsp--;

                     
                            current = this_StateMachine_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1707:5: this_UmpleAttribute_4= ruleUmpleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getUmpleAttributeParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUmpleAttribute_in_ruleassociationClassContent2830);
                    this_UmpleAttribute_4=ruleUmpleAttribute();
                    _fsp--;

                     
                            current = this_UmpleAttribute_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1717:5: this_InlineAssociation_5= ruleInlineAssociation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssociationClassContentAccess().getInlineAssociationParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInlineAssociation_in_ruleassociationClassContent2857);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1733:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1734:2: (iv_ruleAssociation= ruleAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1735:2: iv_ruleAssociation= ruleAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssociation_in_entryRuleAssociation2892);
            iv_ruleAssociation=ruleAssociation();
            _fsp--;

             current =iv_ruleAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociation2902); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1742:1: ruleAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' ) ;
    public final EObject ruleAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_type1_1_0=null;
        Token lv_rolename1_2_0=null;
        Token lv_type2_8_0=null;
        Token lv_rolename2_9_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1747:6: ( ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1748:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1748:1: ( rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1749:5: rulemultiplicity ( (lv_type1_1_0= RULE_ID ) ) ( (lv_rolename1_2_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type2_8_0= RULE_ID ) ) ( (lv_rolename2_9_0= RULE_ID ) )? ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation2943);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1756:1: ( (lv_type1_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1757:1: (lv_type1_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1757:1: (lv_type1_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1758:3: lv_type1_1_0= RULE_ID
            {
            lv_type1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2959); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1780:2: ( (lv_rolename1_2_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:1: (lv_rolename1_2_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1781:1: (lv_rolename1_2_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1782:3: lv_rolename1_2_0= RULE_ID
                    {
                    lv_rolename1_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation2981); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1804:3: ( '->' | '--' | '<-' | '><' )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt31=1;
                }
                break;
            case 41:
                {
                alt31=2;
                }
                break;
            case 42:
                {
                alt31=3;
                }
                break;
            case 43:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1804:3: ( '->' | '--' | '<-' | '><' )", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1804:5: '->'
                    {
                    match(input,40,FOLLOW_40_in_ruleAssociation2998); 

                            createLeafNode(grammarAccess.getAssociationAccess().getHyphenMinusGreaterThanSignKeyword_3_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1809:7: '--'
                    {
                    match(input,41,FOLLOW_41_in_ruleAssociation3014); 

                            createLeafNode(grammarAccess.getAssociationAccess().getHyphenMinusHyphenMinusKeyword_3_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1814:7: '<-'
                    {
                    match(input,42,FOLLOW_42_in_ruleAssociation3030); 

                            createLeafNode(grammarAccess.getAssociationAccess().getLessThanSignHyphenMinusKeyword_3_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1819:7: '><'
                    {
                    match(input,43,FOLLOW_43_in_ruleAssociation3046); 

                            createLeafNode(grammarAccess.getAssociationAccess().getGreaterThanSignLessThanSignKeyword_3_3(), null); 
                        

                    }
                    break;

            }

             
                    currentNode=createCompositeNode(grammarAccess.getAssociationAccess().getMultiplicityParserRuleCall_4(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleAssociation3063);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1831:1: ( (lv_type2_8_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1832:1: (lv_type2_8_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1832:1: (lv_type2_8_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1833:3: lv_type2_8_0= RULE_ID
            {
            lv_type2_8_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation3079); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1855:2: ( (lv_rolename2_9_0= RULE_ID ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1856:1: (lv_rolename2_9_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1856:1: (lv_rolename2_9_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1857:3: lv_rolename2_9_0= RULE_ID
                    {
                    lv_rolename2_9_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssociation3101); 

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

            match(input,15,FOLLOW_15_in_ruleAssociation3117); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1891:1: entryRuleSymmetricReflexiveAssociation returns [EObject current=null] : iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF ;
    public final EObject entryRuleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymmetricReflexiveAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1892:2: (iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1893:2: iv_ruleSymmetricReflexiveAssociation= ruleSymmetricReflexiveAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSymmetricReflexiveAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation3153);
            iv_ruleSymmetricReflexiveAssociation=ruleSymmetricReflexiveAssociation();
            _fsp--;

             current =iv_ruleSymmetricReflexiveAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation3163); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1900:1: ruleSymmetricReflexiveAssociation returns [EObject current=null] : ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleSymmetricReflexiveAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_rolename_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1905:6: ( ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1906:1: ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1906:1: ( rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1907:5: rulemultiplicity 'self' ( (lv_rolename_2_0= RULE_ID ) ) ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation3204);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            match(input,44,FOLLOW_44_in_ruleSymmetricReflexiveAssociation3213); 

                    createLeafNode(grammarAccess.getSymmetricReflexiveAssociationAccess().getSelfKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1918:1: ( (lv_rolename_2_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1919:1: (lv_rolename_2_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1919:1: (lv_rolename_2_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1920:3: lv_rolename_2_0= RULE_ID
            {
            lv_rolename_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation3230); 

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

            match(input,15,FOLLOW_15_in_ruleSymmetricReflexiveAssociation3245); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1954:1: entryRuleInlineAssociation returns [EObject current=null] : iv_ruleInlineAssociation= ruleInlineAssociation EOF ;
    public final EObject entryRuleInlineAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineAssociation = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1955:2: (iv_ruleInlineAssociation= ruleInlineAssociation EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1956:2: iv_ruleInlineAssociation= ruleInlineAssociation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInlineAssociationRule(), currentNode); 
            pushFollow(FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation3281);
            iv_ruleInlineAssociation=ruleInlineAssociation();
            _fsp--;

             current =iv_ruleInlineAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineAssociation3291); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1963:1: ruleInlineAssociation returns [EObject current=null] : ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' ) ;
    public final EObject ruleInlineAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_rolename1_1_0=null;
        Token lv_type_7_0=null;
        Token lv_rolename2_8_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1968:6: ( ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1969:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1969:1: ( rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1970:5: rulemultiplicity ( (lv_rolename1_1_0= RULE_ID ) )? ( '->' | '--' | '<-' | '><' ) rulemultiplicity ( (lv_type_7_0= RULE_ID ) ) ( (lv_rolename2_8_0= RULE_ID ) )? ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation3332);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1977:1: ( (lv_rolename1_1_0= RULE_ID ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1978:1: (lv_rolename1_1_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1978:1: (lv_rolename1_1_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:1979:3: lv_rolename1_1_0= RULE_ID
                    {
                    lv_rolename1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3348); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2001:3: ( '->' | '--' | '<-' | '><' )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt34=1;
                }
                break;
            case 41:
                {
                alt34=2;
                }
                break;
            case 42:
                {
                alt34=3;
                }
                break;
            case 43:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2001:3: ( '->' | '--' | '<-' | '><' )", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2001:5: '->'
                    {
                    match(input,40,FOLLOW_40_in_ruleInlineAssociation3365); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getHyphenMinusGreaterThanSignKeyword_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2006:7: '--'
                    {
                    match(input,41,FOLLOW_41_in_ruleInlineAssociation3381); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getHyphenMinusHyphenMinusKeyword_2_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2011:7: '<-'
                    {
                    match(input,42,FOLLOW_42_in_ruleInlineAssociation3397); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getLessThanSignHyphenMinusKeyword_2_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2016:7: '><'
                    {
                    match(input,43,FOLLOW_43_in_ruleInlineAssociation3413); 

                            createLeafNode(grammarAccess.getInlineAssociationAccess().getGreaterThanSignLessThanSignKeyword_2_3(), null); 
                        

                    }
                    break;

            }

             
                    currentNode=createCompositeNode(grammarAccess.getInlineAssociationAccess().getMultiplicityParserRuleCall_3(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_ruleInlineAssociation3430);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2028:1: ( (lv_type_7_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2029:1: (lv_type_7_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2029:1: (lv_type_7_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2030:3: lv_type_7_0= RULE_ID
            {
            lv_type_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3446); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2052:2: ( (lv_rolename2_8_0= RULE_ID ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2053:1: (lv_rolename2_8_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2053:1: (lv_rolename2_8_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2054:3: lv_rolename2_8_0= RULE_ID
                    {
                    lv_rolename2_8_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineAssociation3468); 

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

            match(input,15,FOLLOW_15_in_ruleInlineAssociation3484); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2088:1: entryRulesingleAssociationEnd returns [EObject current=null] : iv_rulesingleAssociationEnd= rulesingleAssociationEnd EOF ;
    public final EObject entryRulesingleAssociationEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesingleAssociationEnd = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2089:2: (iv_rulesingleAssociationEnd= rulesingleAssociationEnd EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2090:2: iv_rulesingleAssociationEnd= rulesingleAssociationEnd EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingleAssociationEndRule(), currentNode); 
            pushFollow(FOLLOW_rulesingleAssociationEnd_in_entryRulesingleAssociationEnd3520);
            iv_rulesingleAssociationEnd=rulesingleAssociationEnd();
            _fsp--;

             current =iv_rulesingleAssociationEnd; 
            match(input,EOF,FOLLOW_EOF_in_entryRulesingleAssociationEnd3530); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2097:1: rulesingleAssociationEnd returns [EObject current=null] : ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' ) ;
    public final EObject rulesingleAssociationEnd() throws RecognitionException {
        EObject current = null;

        Token lv_rolename_2_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2102:6: ( ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2103:1: ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2103:1: ( rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2104:5: rulemultiplicity ( (lv_type_1_0= ruleextendedID ) ) ( (lv_rolename_2_0= RULE_ID ) )? ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getSingleAssociationEndAccess().getMultiplicityParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulemultiplicity_in_rulesingleAssociationEnd3571);
            rulemultiplicity();
            _fsp--;

             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2111:1: ( (lv_type_1_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2112:1: (lv_type_1_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2112:1: (lv_type_1_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2113:3: lv_type_1_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSingleAssociationEndAccess().getTypeExtendedIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulesingleAssociationEnd3591);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2135:2: ( (lv_rolename_2_0= RULE_ID ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2136:1: (lv_rolename_2_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2136:1: (lv_rolename_2_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2137:3: lv_rolename_2_0= RULE_ID
                    {
                    lv_rolename_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rulesingleAssociationEnd3608); 

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

            match(input,15,FOLLOW_15_in_rulesingleAssociationEnd3624); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2171:1: entryRulemultiplicity returns [String current=null] : iv_rulemultiplicity= rulemultiplicity EOF ;
    public final String entryRulemultiplicity() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulemultiplicity = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2172:2: (iv_rulemultiplicity= rulemultiplicity EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2173:2: iv_rulemultiplicity= rulemultiplicity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicityRule(), currentNode); 
            pushFollow(FOLLOW_rulemultiplicity_in_entryRulemultiplicity3661);
            iv_rulemultiplicity=rulemultiplicity();
            _fsp--;

             current =iv_rulemultiplicity.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicity3672); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2180:1: rulemultiplicity returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) ;
    public final AntlrDatatypeRuleToken rulemultiplicity() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_bound_0 = null;

        AntlrDatatypeRuleToken this_bound_1 = null;

        AntlrDatatypeRuleToken this_bound_3 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2185:6: ( (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2186:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2186:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_INT) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==EOF||LA37_1==RULE_ID||(LA37_1>=40 && LA37_1<=44)) ) {
                    alt37=1;
                }
                else if ( (LA37_1==45) ) {
                    alt37=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("2186:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )", 37, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA37_0==46) ) {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==EOF||LA37_2==RULE_ID||(LA37_2>=40 && LA37_2<=44)) ) {
                    alt37=1;
                }
                else if ( (LA37_2==45) ) {
                    alt37=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("2186:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )", 37, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2186:1: (this_bound_0= rulebound | (this_bound_1= rulebound kw= '..' this_bound_3= rulebound ) )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2187:5: this_bound_0= rulebound
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity3719);
                    this_bound_0=rulebound();
                    _fsp--;


                    		current.merge(this_bound_0);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2198:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2198:6: (this_bound_1= rulebound kw= '..' this_bound_3= rulebound )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2199:5: this_bound_1= rulebound kw= '..' this_bound_3= rulebound
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity3753);
                    this_bound_1=rulebound();
                    _fsp--;


                    		current.merge(this_bound_1);
                        
                     
                            currentNode = currentNode.getParent();
                        
                    kw=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_rulemultiplicity3771); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getMultiplicityAccess().getFullStopFullStopKeyword_1_1(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getMultiplicityAccess().getBoundParserRuleCall_1_2(), currentNode); 
                        
                    pushFollow(FOLLOW_rulebound_in_rulemultiplicity3793);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2234:1: entryRulebound returns [String current=null] : iv_rulebound= rulebound EOF ;
    public final String entryRulebound() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulebound = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2235:2: (iv_rulebound= rulebound EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2236:2: iv_rulebound= rulebound EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBoundRule(), currentNode); 
            pushFollow(FOLLOW_rulebound_in_entryRulebound3840);
            iv_rulebound=rulebound();
            _fsp--;

             current =iv_rulebound.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulebound3851); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2243:1: rulebound returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken rulebound() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2248:6: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2249:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2249:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_INT) ) {
                alt38=1;
            }
            else if ( (LA38_0==46) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2249:1: (this_INT_0= RULE_INT | kw= '*' )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2249:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rulebound3891); 

                    		current.merge(this_INT_0);
                        
                     
                        createLeafNode(grammarAccess.getBoundAccess().getINTTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2258:2: kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_rulebound3915); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2271:1: entryRuleSingleton returns [EObject current=null] : iv_ruleSingleton= ruleSingleton EOF ;
    public final EObject entryRuleSingleton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleton = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2272:2: (iv_ruleSingleton= ruleSingleton EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2273:2: iv_ruleSingleton= ruleSingleton EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSingletonRule(), currentNode); 
            pushFollow(FOLLOW_ruleSingleton_in_entryRuleSingleton3955);
            iv_ruleSingleton=ruleSingleton();
            _fsp--;

             current =iv_ruleSingleton; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingleton3965); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2280:1: ruleSingleton returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) ) ';' ) ;
    public final EObject ruleSingleton() throws RecognitionException {
        EObject current = null;

        Token lv_singleton_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2285:6: ( ( ( (lv_singleton_0_0= 'singleton' ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2286:1: ( ( (lv_singleton_0_0= 'singleton' ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2286:1: ( ( (lv_singleton_0_0= 'singleton' ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2286:2: ( (lv_singleton_0_0= 'singleton' ) ) ';'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2286:2: ( (lv_singleton_0_0= 'singleton' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2287:1: (lv_singleton_0_0= 'singleton' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2287:1: (lv_singleton_0_0= 'singleton' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2288:3: lv_singleton_0_0= 'singleton'
            {
            lv_singleton_0_0=(Token)input.LT(1);
            match(input,47,FOLLOW_47_in_ruleSingleton4008); 

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

            match(input,15,FOLLOW_15_in_ruleSingleton4031); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2319:1: entryRuleCodeInjection returns [EObject current=null] : iv_ruleCodeInjection= ruleCodeInjection EOF ;
    public final EObject entryRuleCodeInjection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodeInjection = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2320:2: (iv_ruleCodeInjection= ruleCodeInjection EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2321:2: iv_ruleCodeInjection= ruleCodeInjection EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCodeInjectionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection4067);
            iv_ruleCodeInjection=ruleCodeInjection();
            _fsp--;

             current =iv_ruleCodeInjection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodeInjection4077); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2328:1: ruleCodeInjection returns [EObject current=null] : ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) ) ;
    public final EObject ruleCodeInjection() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_code_2_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_code_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2333:6: ( ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2334:1: ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2334:1: ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==48) ) {
                alt39=1;
            }
            else if ( (LA39_0==49) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2334:1: ( ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) ) | ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2334:2: ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2334:2: ( 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2334:4: 'before' ( (lv_name_1_0= ruleextendedID ) ) ( (lv_code_2_0= ruleblock ) )
                    {
                    match(input,48,FOLLOW_48_in_ruleCodeInjection4113); 

                            createLeafNode(grammarAccess.getCodeInjectionAccess().getBeforeKeyword_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2338:1: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2339:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2339:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2340:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection4134);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2362:2: ( (lv_code_2_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2363:1: (lv_code_2_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2363:1: (lv_code_2_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2364:3: lv_code_2_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getCodeBlockParserRuleCall_0_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_ruleCodeInjection4155);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2387:6: ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2387:6: ( 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2387:8: 'after' ( (lv_name_4_0= ruleextendedID ) ) ( (lv_code_5_0= ruleblock ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleCodeInjection4173); 

                            createLeafNode(grammarAccess.getCodeInjectionAccess().getAfterKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2391:1: ( (lv_name_4_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2392:1: (lv_name_4_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2392:1: (lv_name_4_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2393:3: lv_name_4_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getNameExtendedIDParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCodeInjection4194);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2415:2: ( (lv_code_5_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2416:1: (lv_code_5_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2416:1: (lv_code_5_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2417:3: lv_code_5_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCodeInjectionAccess().getCodeBlockParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_ruleCodeInjection4215);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2447:1: entryRuleUmpleAttribute returns [EObject current=null] : iv_ruleUmpleAttribute= ruleUmpleAttribute EOF ;
    public final EObject entryRuleUmpleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpleAttribute = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2448:2: (iv_ruleUmpleAttribute= ruleUmpleAttribute EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2449:2: iv_ruleUmpleAttribute= ruleUmpleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAttributeRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAttribute_in_entryRuleUmpleAttribute4252);
            iv_ruleUmpleAttribute=ruleUmpleAttribute();
            _fsp--;

             current =iv_ruleUmpleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAttribute4262); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2456:1: ruleUmpleAttribute returns [EObject current=null] : ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) ) ;
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
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2461:6: ( ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2462:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2462:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==50) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_ID||LA46_0==29||LA46_0==33||LA46_0==36||LA46_0==51||(LA46_0>=54 && LA46_0<=61)||(LA46_0>=124 && LA46_0<=128)) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2462:1: ( ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' ) | ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' ) )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2462:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2462:2: ( ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2462:3: ( (lv_autounique_0_0= 'autounique' ) ) ( (lv_name_1_0= ruleextendedID ) ) ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2462:3: ( (lv_autounique_0_0= 'autounique' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2463:1: (lv_autounique_0_0= 'autounique' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2463:1: (lv_autounique_0_0= 'autounique' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2464:3: lv_autounique_0_0= 'autounique'
                    {
                    lv_autounique_0_0=(Token)input.LT(1);
                    match(input,50,FOLLOW_50_in_ruleUmpleAttribute4306); 

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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2483:2: ( (lv_name_1_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2484:1: (lv_name_1_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2484:1: (lv_name_1_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2485:3: lv_name_1_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getNameExtendedIDParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleUmpleAttribute4340);
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

                    match(input,15,FOLLOW_15_in_ruleUmpleAttribute4350); 

                            createLeafNode(grammarAccess.getUmpleAttributeAccess().getSemicolonKeyword_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2512:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2512:6: ( ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2512:7: ( (lv_unique_3_0= 'unique' ) )? ( (lv_modifier_4_0= ruleModifier ) )? ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )? ( (lv_name_9_0= ruleextendedID ) ) ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )? ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2512:7: ( (lv_unique_3_0= 'unique' ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==51) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2513:1: (lv_unique_3_0= 'unique' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2513:1: (lv_unique_3_0= 'unique' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2514:3: lv_unique_3_0= 'unique'
                            {
                            lv_unique_3_0=(Token)input.LT(1);
                            match(input,51,FOLLOW_51_in_ruleUmpleAttribute4376); 

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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2533:3: ( (lv_modifier_4_0= ruleModifier ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( ((LA41_0>=124 && LA41_0<=128)) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2534:1: (lv_modifier_4_0= ruleModifier )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2534:1: (lv_modifier_4_0= ruleModifier )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2535:3: lv_modifier_4_0= ruleModifier
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getModifierModifierEnumRuleCall_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleModifier_in_ruleUmpleAttribute4411);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2557:3: ( ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? ) | ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? ) )?
                    int alt44=3;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==29||LA44_0==33||LA44_0==36||(LA44_0>=54 && LA44_0<=61)) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==RULE_ID) ) {
                        int LA44_2 = input.LA(2);

                        if ( (LA44_2==RULE_ID||LA44_2==52) ) {
                            alt44=2;
                        }
                    }
                    switch (alt44) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2557:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2557:4: ( ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )? )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2557:5: ( (lv_type_5_0= ruleUmpleAttributeType ) ) ( (lv_list_6_0= '[]' ) )?
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2557:5: ( (lv_type_5_0= ruleUmpleAttributeType ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2558:1: (lv_type_5_0= ruleUmpleAttributeType )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2558:1: (lv_type_5_0= ruleUmpleAttributeType )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2559:3: lv_type_5_0= ruleUmpleAttributeType
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getTypeUmpleAttributeTypeParserRuleCall_1_2_0_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUmpleAttributeType_in_ruleUmpleAttribute4435);
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

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2581:2: ( (lv_list_6_0= '[]' ) )?
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( (LA42_0==52) ) {
                                alt42=1;
                            }
                            switch (alt42) {
                                case 1 :
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2582:1: (lv_list_6_0= '[]' )
                                    {
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2582:1: (lv_list_6_0= '[]' )
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2583:3: lv_list_6_0= '[]'
                                    {
                                    lv_list_6_0=(Token)input.LT(1);
                                    match(input,52,FOLLOW_52_in_ruleUmpleAttribute4453); 

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
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2603:6: ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2603:6: ( ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )? )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2603:7: ( ( RULE_ID ) ) ( (lv_list_8_0= '[]' ) )?
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2603:7: ( ( RULE_ID ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2604:1: ( RULE_ID )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2604:1: ( RULE_ID )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2605:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getUmpleAttributeRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUmpleAttribute4493); 

                            		createLeafNode(grammarAccess.getUmpleAttributeAccess().getObjectUmpleClassCrossReference_1_2_1_0_0(), "object"); 
                            	

                            }


                            }

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2617:2: ( (lv_list_8_0= '[]' ) )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==52) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2618:1: (lv_list_8_0= '[]' )
                                    {
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2618:1: (lv_list_8_0= '[]' )
                                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2619:3: lv_list_8_0= '[]'
                                    {
                                    lv_list_8_0=(Token)input.LT(1);
                                    match(input,52,FOLLOW_52_in_ruleUmpleAttribute4511); 

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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2638:6: ( (lv_name_9_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2639:1: (lv_name_9_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2639:1: (lv_name_9_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2640:3: lv_name_9_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getNameExtendedIDParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleUmpleAttribute4549);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2662:2: ( '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==53) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2662:4: '=' ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            {
                            match(input,53,FOLLOW_53_in_ruleUmpleAttribute4560); 

                                    createLeafNode(grammarAccess.getUmpleAttributeAccess().getEqualsSignKeyword_1_4_0(), null); 
                                
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2666:1: ( (lv_value_11_0= ruleUmplePrimitiveType ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2667:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2667:1: (lv_value_11_0= ruleUmplePrimitiveType )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2668:3: lv_value_11_0= ruleUmplePrimitiveType
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUmpleAttributeAccess().getValueUmplePrimitiveTypeParserRuleCall_1_4_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_ruleUmpleAttribute4581);
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

                    match(input,15,FOLLOW_15_in_ruleUmpleAttribute4593); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2702:1: entryRuleUmplePrimitiveType returns [String current=null] : iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF ;
    public final String entryRuleUmplePrimitiveType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmplePrimitiveType = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2703:2: (iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2704:2: iv_ruleUmplePrimitiveType= ruleUmplePrimitiveType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmplePrimitiveTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType4631);
            iv_ruleUmplePrimitiveType=ruleUmplePrimitiveType();
            _fsp--;

             current =iv_ruleUmplePrimitiveType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmplePrimitiveType4642); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2711:1: ruleUmplePrimitiveType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleUmplePrimitiveType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_STRING_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2716:6: ( (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_INT) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_STRING) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2717:1: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2717:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUmplePrimitiveType4682); 

                    		current.merge(this_INT_0);
                        
                     
                        createLeafNode(grammarAccess.getUmplePrimitiveTypeAccess().getINTTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2725:10: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType4708); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2740:1: entryRuleUmpleAttributeType returns [String current=null] : iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF ;
    public final String entryRuleUmpleAttributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUmpleAttributeType = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2741:2: (iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2742:2: iv_ruleUmpleAttributeType= ruleUmpleAttributeType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUmpleAttributeTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType4754);
            iv_ruleUmpleAttributeType=ruleUmpleAttributeType();
            _fsp--;

             current =iv_ruleUmpleAttributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUmpleAttributeType4765); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2749:1: ruleUmpleAttributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleUmpleAttributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2754:6: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2755:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2755:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt48=11;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt48=1;
                }
                break;
            case 55:
                {
                alt48=2;
                }
                break;
            case 56:
                {
                alt48=3;
                }
                break;
            case 36:
                {
                alt48=4;
                }
                break;
            case 57:
                {
                alt48=5;
                }
                break;
            case 58:
                {
                alt48=6;
                }
                break;
            case 33:
                {
                alt48=7;
                }
                break;
            case 59:
                {
                alt48=8;
                }
                break;
            case 29:
                {
                alt48=9;
                }
                break;
            case 60:
                {
                alt48=10;
                }
                break;
            case 61:
                {
                alt48=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2755:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2756:2: kw= 'Date'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleUmpleAttributeType4803); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getDateKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2763:2: kw= 'Time'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleUmpleAttributeType4822); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getTimeKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2770:2: kw= 'Double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleUmpleAttributeType4841); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2777:2: kw= 'double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_ruleUmpleAttributeType4860); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getDoubleKeyword_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2784:2: kw= 'Integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_ruleUmpleAttributeType4879); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_4(), null); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2791:2: kw= 'integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,58,FOLLOW_58_in_ruleUmpleAttributeType4898); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getIntegerKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2798:2: kw= 'int'
                    {
                    kw=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleUmpleAttributeType4917); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getIntKeyword_6(), null); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2805:2: kw= 'Boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,59,FOLLOW_59_in_ruleUmpleAttributeType4936); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_7(), null); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2812:2: kw= 'boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleUmpleAttributeType4955); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getBooleanKeyword_8(), null); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2819:2: kw= 'String'
                    {
                    kw=(Token)input.LT(1);
                    match(input,60,FOLLOW_60_in_ruleUmpleAttributeType4974); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getUmpleAttributeTypeAccess().getStringKeyword_9(), null); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2826:2: kw= 'string'
                    {
                    kw=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_ruleUmpleAttributeType4993); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2839:1: entryRuleKey returns [EObject current=null] : iv_ruleKey= ruleKey EOF ;
    public final EObject entryRuleKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKey = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2840:2: (iv_ruleKey= ruleKey EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2841:2: iv_ruleKey= ruleKey EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeyRule(), currentNode); 
            pushFollow(FOLLOW_ruleKey_in_entryRuleKey5033);
            iv_ruleKey=ruleKey();
            _fsp--;

             current =iv_ruleKey; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKey5043); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2848:1: ruleKey returns [EObject current=null] : ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' ) ;
    public final EObject ruleKey() throws RecognitionException {
        EObject current = null;

        Token lv_keys_3_0=null;
        Token lv_keys_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2853:6: ( ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2854:1: ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2854:1: ( 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2854:3: 'key' () '{' ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )? '}'
            {
            match(input,62,FOLLOW_62_in_ruleKey5078); 

                    createLeafNode(grammarAccess.getKeyAccess().getKeyKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2858:1: ()
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2859:5: 
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

            match(input,17,FOLLOW_17_in_ruleKey5097); 

                    createLeafNode(grammarAccess.getKeyAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2873:1: ( ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2873:2: ( (lv_keys_3_0= RULE_ID ) ) ( ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2873:2: ( (lv_keys_3_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2874:1: (lv_keys_3_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2874:1: (lv_keys_3_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2875:3: lv_keys_3_0= RULE_ID
                    {
                    lv_keys_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKey5115); 

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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2897:2: ( ',' ( (lv_keys_5_0= RULE_ID ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==28) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2897:4: ',' ( (lv_keys_5_0= RULE_ID ) )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleKey5131); 

                    	            createLeafNode(grammarAccess.getKeyAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2901:1: ( (lv_keys_5_0= RULE_ID ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2902:1: (lv_keys_5_0= RULE_ID )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2902:1: (lv_keys_5_0= RULE_ID )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2903:3: lv_keys_5_0= RULE_ID
                    	    {
                    	    lv_keys_5_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKey5148); 

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
                    	    break loop49;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleKey5167); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2937:1: entryRuleDepend returns [EObject current=null] : iv_ruleDepend= ruleDepend EOF ;
    public final EObject entryRuleDepend() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDepend = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2938:2: (iv_ruleDepend= ruleDepend EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2939:2: iv_ruleDepend= ruleDepend EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDependRule(), currentNode); 
            pushFollow(FOLLOW_ruleDepend_in_entryRuleDepend5203);
            iv_ruleDepend=ruleDepend();
            _fsp--;

             current =iv_ruleDepend; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDepend5213); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2946:1: ruleDepend returns [EObject current=null] : ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' ) ;
    public final EObject ruleDepend() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2951:6: ( ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2952:1: ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2952:1: ( 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2952:3: 'depend' ( (lv_name_1_0= ruleextendedID ) ) ( '.*' )? ';'
            {
            match(input,63,FOLLOW_63_in_ruleDepend5248); 

                    createLeafNode(grammarAccess.getDependAccess().getDependKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2956:1: ( (lv_name_1_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2957:1: (lv_name_1_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2957:1: (lv_name_1_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2958:3: lv_name_1_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDependAccess().getNameExtendedIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleDepend5269);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2980:2: ( '.*' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==64) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2980:4: '.*'
                    {
                    match(input,64,FOLLOW_64_in_ruleDepend5280); 

                            createLeafNode(grammarAccess.getDependAccess().getFullStopAsteriskKeyword_2(), null); 
                        

                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleDepend5292); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2996:1: entryRuleStateMachineDefinition returns [EObject current=null] : iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF ;
    public final EObject entryRuleStateMachineDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachineDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2997:2: (iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:2998:2: iv_ruleStateMachineDefinition= ruleStateMachineDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateMachineDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateMachineDefinition_in_entryRuleStateMachineDefinition5328);
            iv_ruleStateMachineDefinition=ruleStateMachineDefinition();
            _fsp--;

             current =iv_ruleStateMachineDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachineDefinition5338); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3005:1: ruleStateMachineDefinition returns [EObject current=null] : ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' ) ;
    public final EObject ruleStateMachineDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_states_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3010:6: ( ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3011:1: ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3011:1: ( 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3011:3: 'statemachine' ( (lv_name_1_0= ruleextendedID ) ) '{' ( (lv_states_3_0= ruleState ) )* '}'
            {
            match(input,65,FOLLOW_65_in_ruleStateMachineDefinition5373); 

                    createLeafNode(grammarAccess.getStateMachineDefinitionAccess().getStatemachineKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3015:1: ( (lv_name_1_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3016:1: (lv_name_1_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3016:1: (lv_name_1_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3017:3: lv_name_1_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStateMachineDefinitionAccess().getNameExtendedIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleStateMachineDefinition5394);
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

            match(input,17,FOLLOW_17_in_ruleStateMachineDefinition5404); 

                    createLeafNode(grammarAccess.getStateMachineDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3043:1: ( (lv_states_3_0= ruleState ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID||(LA52_0>=67 && LA52_0<=69)||(LA52_0>=82 && LA52_0<=83)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3044:1: (lv_states_3_0= ruleState )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3044:1: (lv_states_3_0= ruleState )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3045:3: lv_states_3_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateMachineDefinitionAccess().getStatesStateParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStateMachineDefinition5425);
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
            	    break loop52;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleStateMachineDefinition5436); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3079:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3080:2: (iv_ruleStateMachine= ruleStateMachine EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3081:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateMachine_in_entryRuleStateMachine5472);
            iv_ruleStateMachine=ruleStateMachine();
            _fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateMachine5482); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3088:1: ruleStateMachine returns [EObject current=null] : (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject this_ENUM_0 = null;

        EObject this_InlineStateMachine_1 = null;

        EObject this_ReferencedStateMachine_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3093:6: ( (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3094:1: (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3094:1: (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )
            int alt53=3;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3095:5: this_ENUM_0= ruleENUM
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getENUMParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleENUM_in_ruleStateMachine5529);
                    this_ENUM_0=ruleENUM();
                    _fsp--;

                     
                            current = this_ENUM_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3105:5: this_InlineStateMachine_1= ruleInlineStateMachine
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getInlineStateMachineParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInlineStateMachine_in_ruleStateMachine5556);
                    this_InlineStateMachine_1=ruleInlineStateMachine();
                    _fsp--;

                     
                            current = this_InlineStateMachine_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3115:5: this_ReferencedStateMachine_2= ruleReferencedStateMachine
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateMachineAccess().getReferencedStateMachineParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedStateMachine_in_ruleStateMachine5583);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3131:1: entryRuleInlineStateMachine returns [EObject current=null] : iv_ruleInlineStateMachine= ruleInlineStateMachine EOF ;
    public final EObject entryRuleInlineStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineStateMachine = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3132:2: (iv_ruleInlineStateMachine= ruleInlineStateMachine EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3133:2: iv_ruleInlineStateMachine= ruleInlineStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInlineStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleInlineStateMachine_in_entryRuleInlineStateMachine5618);
            iv_ruleInlineStateMachine=ruleInlineStateMachine();
            _fsp--;

             current =iv_ruleInlineStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineStateMachine5628); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3140:1: ruleInlineStateMachine returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' ) ;
    public final EObject ruleInlineStateMachine() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_states_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3145:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3146:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3146:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3146:2: ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_states_2_0= ruleState ) )* '}'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3146:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3147:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3147:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3148:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInlineStateMachineAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleInlineStateMachine5674);
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

            match(input,17,FOLLOW_17_in_ruleInlineStateMachine5684); 

                    createLeafNode(grammarAccess.getInlineStateMachineAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3174:1: ( (lv_states_2_0= ruleState ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID||(LA54_0>=67 && LA54_0<=69)||(LA54_0>=82 && LA54_0<=83)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3175:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3175:1: (lv_states_2_0= ruleState )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3176:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getInlineStateMachineAccess().getStatesStateParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleInlineStateMachine5705);
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
            	    break loop54;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleInlineStateMachine5716); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3210:1: entryRuleReferencedStateMachine returns [EObject current=null] : iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF ;
    public final EObject entryRuleReferencedStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedStateMachine = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3211:2: (iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3212:2: iv_ruleReferencedStateMachine= ruleReferencedStateMachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedStateMachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedStateMachine_in_entryRuleReferencedStateMachine5752);
            iv_ruleReferencedStateMachine=ruleReferencedStateMachine();
            _fsp--;

             current =iv_ruleReferencedStateMachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedStateMachine5762); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3219:1: ruleReferencedStateMachine returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' ) ;
    public final EObject ruleReferencedStateMachine() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3224:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3225:1: ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3225:1: ( ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3225:2: ( (lv_name_0_0= ruleextendedID ) ) 'as' ( ( RULE_ID ) ) ';'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3225:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3226:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3226:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3227:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getReferencedStateMachineAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleReferencedStateMachine5808);
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

            match(input,66,FOLLOW_66_in_ruleReferencedStateMachine5818); 

                    createLeafNode(grammarAccess.getReferencedStateMachineAccess().getAsKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3253:1: ( ( RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3254:1: ( RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3254:1: ( RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3255:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedStateMachineRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedStateMachine5836); 

            		createLeafNode(grammarAccess.getReferencedStateMachineAccess().getMachineStateMachineDefinitionCrossReference_2_0(), "machine"); 
            	

            }


            }

            match(input,15,FOLLOW_15_in_ruleReferencedStateMachine5846); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3279:1: entryRuleENUM returns [EObject current=null] : iv_ruleENUM= ruleENUM EOF ;
    public final EObject entryRuleENUM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleENUM = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3280:2: (iv_ruleENUM= ruleENUM EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3281:2: iv_ruleENUM= ruleENUM EOF
            {
             currentNode = createCompositeNode(grammarAccess.getENUMRule(), currentNode); 
            pushFollow(FOLLOW_ruleENUM_in_entryRuleENUM5882);
            iv_ruleENUM=ruleENUM();
            _fsp--;

             current =iv_ruleENUM; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleENUM5892); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3288:1: ruleENUM returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' ) ;
    public final EObject ruleENUM() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_state1_2_0 = null;

        AntlrDatatypeRuleToken lv_states_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3293:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3294:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3294:1: ( ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3294:2: ( (lv_name_0_0= ruleextendedID ) ) '{' ( (lv_state1_2_0= ruleextendedID ) ) ( ',' ( (lv_states_4_0= ruleextendedID ) ) )* '}'
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3294:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3295:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3295:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3296:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getENUMAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleENUM5938);
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

            match(input,17,FOLLOW_17_in_ruleENUM5948); 

                    createLeafNode(grammarAccess.getENUMAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3322:1: ( (lv_state1_2_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3323:1: (lv_state1_2_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3323:1: (lv_state1_2_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3324:3: lv_state1_2_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getENUMAccess().getState1ExtendedIDParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_ruleENUM5969);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3346:2: ( ',' ( (lv_states_4_0= ruleextendedID ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==28) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3346:4: ',' ( (lv_states_4_0= ruleextendedID ) )
            	    {
            	    match(input,28,FOLLOW_28_in_ruleENUM5980); 

            	            createLeafNode(grammarAccess.getENUMAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3350:1: ( (lv_states_4_0= ruleextendedID ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3351:1: (lv_states_4_0= ruleextendedID )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3351:1: (lv_states_4_0= ruleextendedID )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3352:3: lv_states_4_0= ruleextendedID
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getENUMAccess().getStatesExtendedIDParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleextendedID_in_ruleENUM6001);
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
            	    break loop55;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleENUM6013); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3386:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3387:2: (iv_ruleState= ruleState EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3388:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState6049);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState6059); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3395:1: ruleState returns [EObject current=null] : ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject lv_stateTraceDirective_0_0 = null;

        AntlrDatatypeRuleToken lv_stateName_4_0 = null;

        EObject lv_states_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3400:6: ( ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3401:1: ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3401:1: ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=82 && LA61_0<=83)) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ID||(LA61_0>=67 && LA61_0<=69)) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3401:1: ( ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) ) | ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' ) )", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3401:2: ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3401:2: ( (lv_stateTraceDirective_0_0= ruleTraceDirective ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3402:1: (lv_stateTraceDirective_0_0= ruleTraceDirective )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3402:1: (lv_stateTraceDirective_0_0= ruleTraceDirective )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3403:3: lv_stateTraceDirective_0_0= ruleTraceDirective
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateTraceDirectiveTraceDirectiveParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTraceDirective_in_ruleState6105);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:6: ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:6: ( ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:7: ( 'conc' )? ( 'concurrent' )? ( '|' )? ( (lv_stateName_4_0= ruleextendedID ) ) '{' ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )* '}'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:7: ( 'conc' )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==67) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3426:9: 'conc'
                            {
                            match(input,67,FOLLOW_67_in_ruleState6123); 

                                    createLeafNode(grammarAccess.getStateAccess().getConcKeyword_1_0(), null); 
                                

                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3430:3: ( 'concurrent' )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==68) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3430:5: 'concurrent'
                            {
                            match(input,68,FOLLOW_68_in_ruleState6136); 

                                    createLeafNode(grammarAccess.getStateAccess().getConcurrentKeyword_1_1(), null); 
                                

                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3434:3: ( '|' )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==69) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3434:5: '|'
                            {
                            match(input,69,FOLLOW_69_in_ruleState6149); 

                                    createLeafNode(grammarAccess.getStateAccess().getVerticalLineKeyword_1_2(), null); 
                                

                            }
                            break;

                    }

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3438:3: ( (lv_stateName_4_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3439:1: (lv_stateName_4_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3439:1: (lv_stateName_4_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3440:3: lv_stateName_4_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateNameExtendedIDParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleState6172);
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

                    match(input,17,FOLLOW_17_in_ruleState6182); 

                            createLeafNode(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_1_4(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3466:1: ( ( '*' )? ( (lv_states_7_0= ruleStateEntity ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_INT)||LA60_0==41||LA60_0==46||(LA60_0>=67 && LA60_0<=71)||LA60_0==73||(LA60_0>=75 && LA60_0<=78)||(LA60_0>=82 && LA60_0<=83)||(LA60_0>=99 && LA60_0<=100)||(LA60_0>=102 && LA60_0<=108)) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3466:2: ( '*' )? ( (lv_states_7_0= ruleStateEntity ) )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3466:2: ( '*' )?
                    	    int alt59=2;
                    	    int LA59_0 = input.LA(1);

                    	    if ( (LA59_0==46) ) {
                    	        alt59=1;
                    	    }
                    	    switch (alt59) {
                    	        case 1 :
                    	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3466:4: '*'
                    	            {
                    	            match(input,46,FOLLOW_46_in_ruleState6194); 

                    	                    createLeafNode(grammarAccess.getStateAccess().getAsteriskKeyword_1_5_0(), null); 
                    	                

                    	            }
                    	            break;

                    	    }

                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3470:3: ( (lv_states_7_0= ruleStateEntity ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3471:1: (lv_states_7_0= ruleStateEntity )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3471:1: (lv_states_7_0= ruleStateEntity )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3472:3: lv_states_7_0= ruleStateEntity
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStatesStateEntityParserRuleCall_1_5_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleStateEntity_in_ruleState6217);
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
                    	    break loop60;
                        }
                    } while (true);

                    match(input,18,FOLLOW_18_in_ruleState6229); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3506:1: entryRuleStateEntity returns [EObject current=null] : iv_ruleStateEntity= ruleStateEntity EOF ;
    public final EObject entryRuleStateEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateEntity = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3507:2: (iv_ruleStateEntity= ruleStateEntity EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3508:2: iv_ruleStateEntity= ruleStateEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateEntityRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateEntity_in_entryRuleStateEntity6266);
            iv_ruleStateEntity=ruleStateEntity();
            _fsp--;

             current =iv_ruleStateEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateEntity6276); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3515:1: ruleStateEntity returns [EObject current=null] : (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) ) ;
    public final EObject ruleStateEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Transition_0 = null;

        EObject this_EntryOrExitAction_1 = null;

        EObject this_Activity_2 = null;

        EObject this_State_6 = null;

        EObject lv_expression_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3520:6: ( (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3521:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3521:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) )
            int alt63=5;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3522:5: this_Transition_0= ruleTransition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getTransitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTransition_in_ruleStateEntity6323);
                    this_Transition_0=ruleTransition();
                    _fsp--;

                     
                            current = this_Transition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3532:5: this_EntryOrExitAction_1= ruleEntryOrExitAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getEntryOrExitActionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntryOrExitAction_in_ruleStateEntity6350);
                    this_EntryOrExitAction_1=ruleEntryOrExitAction();
                    _fsp--;

                     
                            current = this_EntryOrExitAction_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3541:6: (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3541:6: (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3542:5: this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getActivityParserRuleCall_2_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActivity_in_ruleStateEntity6378);
                    this_Activity_2=ruleActivity();
                    _fsp--;

                     
                            current = this_Activity_2; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3550:1: ( '->' ruleextendedID ';' )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==40) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3550:3: '->' ruleextendedID ';'
                            {
                            match(input,40,FOLLOW_40_in_ruleStateEntity6388); 

                                    createLeafNode(grammarAccess.getStateEntityAccess().getHyphenMinusGreaterThanSignKeyword_2_1_0(), null); 
                                
                             
                                    currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getExtendedIDParserRuleCall_2_1_1(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleextendedID_in_ruleStateEntity6404);
                            ruleextendedID();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                
                            match(input,15,FOLLOW_15_in_ruleStateEntity6413); 

                                    createLeafNode(grammarAccess.getStateEntityAccess().getSemicolonKeyword_2_1_2(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3568:5: this_State_6= ruleState
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getStateParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleState_in_ruleStateEntity6444);
                    this_State_6=ruleState();
                    _fsp--;

                     
                            current = this_State_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3577:6: ( ( (lv_expression_7_0= ruleexpression ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3577:6: ( ( (lv_expression_7_0= ruleexpression ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3577:7: ( (lv_expression_7_0= ruleexpression ) ) ';'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3577:7: ( (lv_expression_7_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3578:1: (lv_expression_7_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3578:1: (lv_expression_7_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3579:3: lv_expression_7_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateEntityAccess().getExpressionExpressionParserRuleCall_4_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleStateEntity6471);
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

                    match(input,15,FOLLOW_15_in_ruleStateEntity6481); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3613:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3614:2: (iv_ruleTransition= ruleTransition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3615:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition6518);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition6528); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3622:1: ruleTransition returns [EObject current=null] : ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) ) ;
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
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3627:6: ( ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3628:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3628:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==78) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_ID||LA67_0==70||LA67_0==73) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3628:1: ( (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' ) | (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' ) )", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3628:2: (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3628:2: (this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3629:5: this_Guard_0= ruleGuard ( (lv_events_1_0= ruleEventDefinition ) ) '->' ( (lv_a_3_0= ruleAction ) )? ( (lv_stateName_4_0= ruleextendedID ) ) ';'
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getGuardParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGuard_in_ruleTransition6576);
                    this_Guard_0=ruleGuard();
                    _fsp--;

                     
                            current = this_Guard_0; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3637:1: ( (lv_events_1_0= ruleEventDefinition ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3638:1: (lv_events_1_0= ruleEventDefinition )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3638:1: (lv_events_1_0= ruleEventDefinition )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3639:3: lv_events_1_0= ruleEventDefinition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getEventsEventDefinitionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleTransition6596);
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

                    match(input,40,FOLLOW_40_in_ruleTransition6606); 

                            createLeafNode(grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3665:1: ( (lv_a_3_0= ruleAction ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==74) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3666:1: (lv_a_3_0= ruleAction )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3666:1: (lv_a_3_0= ruleAction )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3667:3: lv_a_3_0= ruleAction
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getAActionParserRuleCall_0_3_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAction_in_ruleTransition6627);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3689:3: ( (lv_stateName_4_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3690:1: (lv_stateName_4_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3690:1: (lv_stateName_4_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3691:3: lv_stateName_4_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getStateNameExtendedIDParserRuleCall_0_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleTransition6649);
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

                    match(input,15,FOLLOW_15_in_ruleTransition6659); 

                            createLeafNode(grammarAccess.getTransitionAccess().getSemicolonKeyword_0_5(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3718:6: (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3718:6: (this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3719:5: this_EventDefinition_6= ruleEventDefinition ( (lv_g_7_0= ruleGuard ) )? '->' ( (lv_a_9_0= ruleAction ) )? ( (lv_stateName_10_0= ruleextendedID ) ) ';'
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getEventDefinitionParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleTransition6689);
                    this_EventDefinition_6=ruleEventDefinition();
                    _fsp--;

                     
                            current = this_EventDefinition_6; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3727:1: ( (lv_g_7_0= ruleGuard ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==78) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3728:1: (lv_g_7_0= ruleGuard )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3728:1: (lv_g_7_0= ruleGuard )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3729:3: lv_g_7_0= ruleGuard
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getGGuardParserRuleCall_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleGuard_in_ruleTransition6709);
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

                    match(input,40,FOLLOW_40_in_ruleTransition6720); 

                            createLeafNode(grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_1_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3755:1: ( (lv_a_9_0= ruleAction ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==74) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3756:1: (lv_a_9_0= ruleAction )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3756:1: (lv_a_9_0= ruleAction )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3757:3: lv_a_9_0= ruleAction
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getAActionParserRuleCall_1_3_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAction_in_ruleTransition6741);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3779:3: ( (lv_stateName_10_0= ruleextendedID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3780:1: (lv_stateName_10_0= ruleextendedID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3780:1: (lv_stateName_10_0= ruleextendedID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3781:3: lv_stateName_10_0= ruleextendedID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getStateNameExtendedIDParserRuleCall_1_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleextendedID_in_ruleTransition6763);
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

                    match(input,15,FOLLOW_15_in_ruleTransition6773); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3815:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3816:2: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3817:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition6810);
            iv_ruleEventDefinition=ruleEventDefinition();
            _fsp--;

             current =iv_ruleEventDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDefinition6820); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3824:1: ruleEventDefinition returns [EObject current=null] : ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_eventID_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3829:6: ( ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:1: ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:1: ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) )
            int alt68=3;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt68=1;
                }
                break;
            case 73:
                {
                alt68=2;
                }
                break;
            case RULE_ID:
                {
                alt68=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3830:1: ( ( () ruleTimedEvent ) | ( () ruleWaitEvent ) | ( (lv_eventID_4_0= RULE_ID ) ) )", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:2: ( () ruleTimedEvent )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:2: ( () ruleTimedEvent )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:3: () ruleTimedEvent
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3830:3: ()
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3831:5: 
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
                        
                    pushFollow(FOLLOW_ruleTimedEvent_in_ruleEventDefinition6871);
                    ruleTimedEvent();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3850:6: ( () ruleWaitEvent )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3850:6: ( () ruleWaitEvent )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3850:7: () ruleWaitEvent
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3850:7: ()
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3851:5: 
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
                        
                    pushFollow(FOLLOW_ruleWaitEvent_in_ruleEventDefinition6903);
                    ruleWaitEvent();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3870:6: ( (lv_eventID_4_0= RULE_ID ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3870:6: ( (lv_eventID_4_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3871:1: (lv_eventID_4_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3871:1: (lv_eventID_4_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3872:3: lv_eventID_4_0= RULE_ID
                    {
                    lv_eventID_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDefinition6926); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3902:1: entryRuleTimedEvent returns [String current=null] : iv_ruleTimedEvent= ruleTimedEvent EOF ;
    public final String entryRuleTimedEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimedEvent = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3903:2: (iv_ruleTimedEvent= ruleTimedEvent EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3904:2: iv_ruleTimedEvent= ruleTimedEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimedEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimedEvent_in_entryRuleTimedEvent6968);
            iv_ruleTimedEvent=ruleTimedEvent();
            _fsp--;

             current =iv_ruleTimedEvent.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimedEvent6979); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3911:1: ruleTimedEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleTimedEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3916:6: ( (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3917:1: (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3917:1: (kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3918:2: kw= 'afterEvery' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,70,FOLLOW_70_in_ruleTimedEvent7017); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getTimedEventAccess().getAfterEveryKeyword_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,71,FOLLOW_71_in_ruleTimedEvent7030); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getTimedEventAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3929:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_INT) ) {
                alt69=1;
            }
            else if ( (LA69_0==RULE_ID) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3929:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3929:6: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimedEvent7046); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getTimedEventAccess().getINTTerminalRuleCall_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3937:10: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTimedEvent7072); 

                    		current.merge(this_ID_3);
                        
                     
                        createLeafNode(grammarAccess.getTimedEventAccess().getIDTerminalRuleCall_2_1(), null); 
                        

                    }
                    break;

            }

            kw=(Token)input.LT(1);
            match(input,72,FOLLOW_72_in_ruleTimedEvent7091); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3958:1: entryRuleWaitEvent returns [String current=null] : iv_ruleWaitEvent= ruleWaitEvent EOF ;
    public final String entryRuleWaitEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWaitEvent = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3959:2: (iv_ruleWaitEvent= ruleWaitEvent EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3960:2: iv_ruleWaitEvent= ruleWaitEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWaitEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleWaitEvent_in_entryRuleWaitEvent7132);
            iv_ruleWaitEvent=ruleWaitEvent();
            _fsp--;

             current =iv_ruleWaitEvent.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWaitEvent7143); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3967:1: ruleWaitEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleWaitEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3972:6: ( (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3973:1: (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3973:1: (kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3974:2: kw= 'wait' kw= '(' (this_INT_2= RULE_INT | this_ID_3= RULE_ID ) kw= ')'
            {
            kw=(Token)input.LT(1);
            match(input,73,FOLLOW_73_in_ruleWaitEvent7181); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getWaitEventAccess().getWaitKeyword_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,71,FOLLOW_71_in_ruleWaitEvent7194); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getWaitEventAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3985:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_INT) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_ID) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3985:1: (this_INT_2= RULE_INT | this_ID_3= RULE_ID )", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3985:6: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleWaitEvent7210); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getWaitEventAccess().getINTTerminalRuleCall_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:3993:10: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWaitEvent7236); 

                    		current.merge(this_ID_3);
                        
                     
                        createLeafNode(grammarAccess.getWaitEventAccess().getIDTerminalRuleCall_2_1(), null); 
                        

                    }
                    break;

            }

            kw=(Token)input.LT(1);
            match(input,72,FOLLOW_72_in_ruleWaitEvent7255); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4014:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4015:2: (iv_ruleAction= ruleAction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4016:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction7295);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction7305); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4023:1: ruleAction returns [EObject current=null] : ( '/' ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject lv_code_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4028:6: ( ( '/' ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4029:1: ( '/' ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4029:1: ( '/' ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4029:3: '/' ( (lv_code_1_0= ruleblock ) )
            {
            match(input,74,FOLLOW_74_in_ruleAction7340); 

                    createLeafNode(grammarAccess.getActionAccess().getSolidusKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4033:1: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4034:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4034:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4035:3: lv_code_1_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getCodeBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleAction7361);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4065:1: entryRuleEntryOrExitAction returns [EObject current=null] : iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF ;
    public final EObject entryRuleEntryOrExitAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryOrExitAction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4066:2: (iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4067:2: iv_ruleEntryOrExitAction= ruleEntryOrExitAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryOrExitActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryOrExitAction_in_entryRuleEntryOrExitAction7397);
            iv_ruleEntryOrExitAction=ruleEntryOrExitAction();
            _fsp--;

             current =iv_ruleEntryOrExitAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryOrExitAction7407); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4074:1: ruleEntryOrExitAction returns [EObject current=null] : ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) ) ;
    public final EObject ruleEntryOrExitAction() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        EObject lv_code_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4079:6: ( ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4080:1: ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4080:1: ( ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4080:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) ) '/' ( (lv_code_3_0= ruleblock ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4080:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==75) ) {
                alt71=1;
            }
            else if ( (LA71_0==76) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4080:2: ( ( (lv_type_0_0= 'entry' ) ) | ( (lv_type_1_0= 'exit' ) ) )", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4080:3: ( (lv_type_0_0= 'entry' ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4080:3: ( (lv_type_0_0= 'entry' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4081:1: (lv_type_0_0= 'entry' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4081:1: (lv_type_0_0= 'entry' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4082:3: lv_type_0_0= 'entry'
                    {
                    lv_type_0_0=(Token)input.LT(1);
                    match(input,75,FOLLOW_75_in_ruleEntryOrExitAction7451); 

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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4102:6: ( (lv_type_1_0= 'exit' ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4102:6: ( (lv_type_1_0= 'exit' ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4103:1: (lv_type_1_0= 'exit' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4103:1: (lv_type_1_0= 'exit' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4104:3: lv_type_1_0= 'exit'
                    {
                    lv_type_1_0=(Token)input.LT(1);
                    match(input,76,FOLLOW_76_in_ruleEntryOrExitAction7488); 

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

            match(input,74,FOLLOW_74_in_ruleEntryOrExitAction7512); 

                    createLeafNode(grammarAccess.getEntryOrExitActionAccess().getSolidusKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4127:1: ( (lv_code_3_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4128:1: (lv_code_3_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4128:1: (lv_code_3_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4129:3: lv_code_3_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEntryOrExitActionAccess().getCodeBlockParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleEntryOrExitAction7533);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4159:1: entryRuleActivity returns [EObject current=null] : iv_ruleActivity= ruleActivity EOF ;
    public final EObject entryRuleActivity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivity = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4160:2: (iv_ruleActivity= ruleActivity EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4161:2: iv_ruleActivity= ruleActivity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActivityRule(), currentNode); 
            pushFollow(FOLLOW_ruleActivity_in_entryRuleActivity7569);
            iv_ruleActivity=ruleActivity();
            _fsp--;

             current =iv_ruleActivity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivity7579); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4168:1: ruleActivity returns [EObject current=null] : ( 'do' ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject ruleActivity() throws RecognitionException {
        EObject current = null;

        EObject lv_code_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4173:6: ( ( 'do' ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4174:1: ( 'do' ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4174:1: ( 'do' ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4174:3: 'do' ( (lv_code_1_0= ruleblock ) )
            {
            match(input,77,FOLLOW_77_in_ruleActivity7614); 

                    createLeafNode(grammarAccess.getActivityAccess().getDoKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4178:1: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4179:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4179:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4180:3: lv_code_1_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActivityAccess().getCodeBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleActivity7635);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4210:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4211:2: (iv_ruleGuard= ruleGuard EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4212:2: iv_ruleGuard= ruleGuard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard7671);
            iv_ruleGuard=ruleGuard();
            _fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard7681); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4219:1: ruleGuard returns [EObject current=null] : ( '[' this_GuardCode_1= ruleGuardCode ']' ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        EObject this_GuardCode_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4224:6: ( ( '[' this_GuardCode_1= ruleGuardCode ']' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4225:1: ( '[' this_GuardCode_1= ruleGuardCode ']' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4225:1: ( '[' this_GuardCode_1= ruleGuardCode ']' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4225:3: '[' this_GuardCode_1= ruleGuardCode ']'
            {
            match(input,78,FOLLOW_78_in_ruleGuard7716); 

                    createLeafNode(grammarAccess.getGuardAccess().getLeftSquareBracketKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getGuardAccess().getGuardCodeParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleGuardCode_in_ruleGuard7738);
            this_GuardCode_1=ruleGuardCode();
            _fsp--;

             
                    current = this_GuardCode_1; 
                    currentNode = currentNode.getParent();
                
            match(input,79,FOLLOW_79_in_ruleGuard7747); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4250:1: entryRuleGuardCode returns [EObject current=null] : iv_ruleGuardCode= ruleGuardCode EOF ;
    public final EObject entryRuleGuardCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardCode = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4251:2: (iv_ruleGuardCode= ruleGuardCode EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4252:2: iv_ruleGuardCode= ruleGuardCode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardCodeRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuardCode_in_entryRuleGuardCode7783);
            iv_ruleGuardCode=ruleGuardCode();
            _fsp--;

             current =iv_ruleGuardCode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardCode7793); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4259:1: ruleGuardCode returns [EObject current=null] : ( (lv_nativeExpression_0_0= ruleblock ) ) ;
    public final EObject ruleGuardCode() throws RecognitionException {
        EObject current = null;

        EObject lv_nativeExpression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4264:6: ( ( (lv_nativeExpression_0_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4265:1: ( (lv_nativeExpression_0_0= ruleblock ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4265:1: ( (lv_nativeExpression_0_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4266:1: (lv_nativeExpression_0_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4266:1: (lv_nativeExpression_0_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4267:3: lv_nativeExpression_0_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGuardCodeAccess().getNativeExpressionBlockParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_ruleGuardCode7838);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4297:1: entryRulePosition returns [EObject current=null] : iv_rulePosition= rulePosition EOF ;
    public final EObject entryRulePosition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePosition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4298:2: (iv_rulePosition= rulePosition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4299:2: iv_rulePosition= rulePosition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPositionRule(), currentNode); 
            pushFollow(FOLLOW_rulePosition_in_entryRulePosition7873);
            iv_rulePosition=rulePosition();
            _fsp--;

             current =iv_rulePosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePosition7883); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4306:1: rulePosition returns [EObject current=null] : ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) ) ;
    public final EObject rulePosition() throws RecognitionException {
        EObject current = null;

        EObject lv_a_0_0 = null;

        EObject lv_c_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4311:6: ( ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4312:1: ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4312:1: ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==81) ) {
                alt72=1;
            }
            else if ( (LA72_0==80) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4312:1: ( ( (lv_a_0_0= ruleAssociationPosition ) ) | ( (lv_c_1_0= ruleClassPosition ) ) )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4312:2: ( (lv_a_0_0= ruleAssociationPosition ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4312:2: ( (lv_a_0_0= ruleAssociationPosition ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4313:1: (lv_a_0_0= ruleAssociationPosition )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4313:1: (lv_a_0_0= ruleAssociationPosition )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4314:3: lv_a_0_0= ruleAssociationPosition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPositionAccess().getAAssociationPositionParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAssociationPosition_in_rulePosition7929);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4337:6: ( (lv_c_1_0= ruleClassPosition ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4337:6: ( (lv_c_1_0= ruleClassPosition ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4338:1: (lv_c_1_0= ruleClassPosition )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4338:1: (lv_c_1_0= ruleClassPosition )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4339:3: lv_c_1_0= ruleClassPosition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPositionAccess().getCClassPositionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleClassPosition_in_rulePosition7956);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4369:1: entryRuleClassPosition returns [EObject current=null] : iv_ruleClassPosition= ruleClassPosition EOF ;
    public final EObject entryRuleClassPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassPosition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4370:2: (iv_ruleClassPosition= ruleClassPosition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4371:2: iv_ruleClassPosition= ruleClassPosition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getClassPositionRule(), currentNode); 
            pushFollow(FOLLOW_ruleClassPosition_in_entryRuleClassPosition7992);
            iv_ruleClassPosition=ruleClassPosition();
            _fsp--;

             current =iv_ruleClassPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassPosition8002); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4378:1: ruleClassPosition returns [EObject current=null] : ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' ) ;
    public final EObject ruleClassPosition() throws RecognitionException {
        EObject current = null;

        Token lv_x_1_0=null;
        Token lv_y_2_0=null;
        Token lv_width_3_0=null;
        Token lv_height_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4383:6: ( ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4384:1: ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4384:1: ( 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4384:3: 'position' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_width_3_0= RULE_INT ) ) ( (lv_height_4_0= RULE_INT ) ) ';'
            {
            match(input,80,FOLLOW_80_in_ruleClassPosition8037); 

                    createLeafNode(grammarAccess.getClassPositionAccess().getPositionKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4388:1: ( (lv_x_1_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4389:1: (lv_x_1_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4389:1: (lv_x_1_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4390:3: lv_x_1_0= RULE_INT
            {
            lv_x_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition8054); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4412:2: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4413:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4413:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4414:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition8076); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4436:2: ( (lv_width_3_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4437:1: (lv_width_3_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4437:1: (lv_width_3_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4438:3: lv_width_3_0= RULE_INT
            {
            lv_width_3_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition8098); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4460:2: ( (lv_height_4_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4461:1: (lv_height_4_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4461:1: (lv_height_4_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4462:3: lv_height_4_0= RULE_INT
            {
            lv_height_4_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClassPosition8120); 

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

            match(input,15,FOLLOW_15_in_ruleClassPosition8135); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4496:1: entryRuleAssociationPosition returns [EObject current=null] : iv_ruleAssociationPosition= ruleAssociationPosition EOF ;
    public final EObject entryRuleAssociationPosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociationPosition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4497:2: (iv_ruleAssociationPosition= ruleAssociationPosition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4498:2: iv_ruleAssociationPosition= ruleAssociationPosition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssociationPositionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition8171);
            iv_ruleAssociationPosition=ruleAssociationPosition();
            _fsp--;

             current =iv_ruleAssociationPosition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssociationPosition8181); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4505:1: ruleAssociationPosition returns [EObject current=null] : ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' ) ;
    public final EObject ruleAssociationPosition() throws RecognitionException {
        EObject current = null;

        Token lv_index_1_0=null;
        EObject lv_c1_2_0 = null;

        EObject lv_c2_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4510:6: ( ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4511:1: ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4511:1: ( 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4511:3: 'position.association' ( (lv_index_1_0= RULE_INT ) ) ( (lv_c1_2_0= ruleCoordinate ) ) ( (lv_c2_3_0= ruleCoordinate ) ) ';'
            {
            match(input,81,FOLLOW_81_in_ruleAssociationPosition8216); 

                    createLeafNode(grammarAccess.getAssociationPositionAccess().getPositionAssociationKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4515:1: ( (lv_index_1_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4516:1: (lv_index_1_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4516:1: (lv_index_1_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4517:3: lv_index_1_0= RULE_INT
            {
            lv_index_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssociationPosition8233); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4539:2: ( (lv_c1_2_0= ruleCoordinate ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4540:1: (lv_c1_2_0= ruleCoordinate )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4540:1: (lv_c1_2_0= ruleCoordinate )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4541:3: lv_c1_2_0= ruleCoordinate
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssociationPositionAccess().getC1CoordinateParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition8259);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4563:2: ( (lv_c2_3_0= ruleCoordinate ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4564:1: (lv_c2_3_0= ruleCoordinate )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4564:1: (lv_c2_3_0= ruleCoordinate )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4565:3: lv_c2_3_0= ruleCoordinate
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssociationPositionAccess().getC2CoordinateParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleCoordinate_in_ruleAssociationPosition8280);
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

            match(input,15,FOLLOW_15_in_ruleAssociationPosition8290); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4599:1: entryRuleCoordinate returns [EObject current=null] : iv_ruleCoordinate= ruleCoordinate EOF ;
    public final EObject entryRuleCoordinate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinate = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4600:2: (iv_ruleCoordinate= ruleCoordinate EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4601:2: iv_ruleCoordinate= ruleCoordinate EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCoordinateRule(), currentNode); 
            pushFollow(FOLLOW_ruleCoordinate_in_entryRuleCoordinate8326);
            iv_ruleCoordinate=ruleCoordinate();
            _fsp--;

             current =iv_ruleCoordinate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinate8336); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4608:1: ruleCoordinate returns [EObject current=null] : ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) ) ;
    public final EObject ruleCoordinate() throws RecognitionException {
        EObject current = null;

        Token lv_x_0_0=null;
        Token lv_y_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4613:6: ( ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4614:1: ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4614:1: ( ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4614:2: ( (lv_x_0_0= RULE_INT ) ) ',' ( (lv_y_2_0= RULE_INT ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4614:2: ( (lv_x_0_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4615:1: (lv_x_0_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4615:1: (lv_x_0_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4616:3: lv_x_0_0= RULE_INT
            {
            lv_x_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate8378); 

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

            match(input,28,FOLLOW_28_in_ruleCoordinate8393); 

                    createLeafNode(grammarAccess.getCoordinateAccess().getCommaKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4642:1: ( (lv_y_2_0= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4643:1: (lv_y_2_0= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4643:1: (lv_y_2_0= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4644:3: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCoordinate8410); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4674:1: entryRuleTraceDirective returns [EObject current=null] : iv_ruleTraceDirective= ruleTraceDirective EOF ;
    public final EObject entryRuleTraceDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTraceDirective = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4675:2: (iv_ruleTraceDirective= ruleTraceDirective EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4676:2: iv_ruleTraceDirective= ruleTraceDirective EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTraceDirectiveRule(), currentNode); 
            pushFollow(FOLLOW_ruleTraceDirective_in_entryRuleTraceDirective8451);
            iv_ruleTraceDirective=ruleTraceDirective();
            _fsp--;

             current =iv_ruleTraceDirective; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTraceDirective8461); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4683:1: ruleTraceDirective returns [EObject current=null] : ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? ) ;
    public final EObject ruleTraceDirective() throws RecognitionException {
        EObject current = null;

        Token lv_traceStart_0_1=null;
        Token lv_traceStart_0_2=null;
        Token lv_elementPattern_3_0=null;
        EObject lv_modelElement_1_0 = null;

        EObject lv_conditionRHS_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4688:6: ( ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4689:1: ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4689:1: ( ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4689:2: ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) ) ( (lv_modelElement_1_0= ruleModelElement ) ) ( (lv_conditionRHS_2_0= ruleConditionRHS ) )? ( (lv_elementPattern_3_0= '*' ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4689:2: ( ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4690:1: ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4690:1: ( (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4691:1: (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4691:1: (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==82) ) {
                alt73=1;
            }
            else if ( (LA73_0==83) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4691:1: (lv_traceStart_0_1= 'trace' | lv_traceStart_0_2= 'Trace' )", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4692:3: lv_traceStart_0_1= 'trace'
                    {
                    lv_traceStart_0_1=(Token)input.LT(1);
                    match(input,82,FOLLOW_82_in_ruleTraceDirective8506); 

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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4710:8: lv_traceStart_0_2= 'Trace'
                    {
                    lv_traceStart_0_2=(Token)input.LT(1);
                    match(input,83,FOLLOW_83_in_ruleTraceDirective8535); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4731:2: ( (lv_modelElement_1_0= ruleModelElement ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4732:1: (lv_modelElement_1_0= ruleModelElement )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4732:1: (lv_modelElement_1_0= ruleModelElement )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4733:3: lv_modelElement_1_0= ruleModelElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTraceDirectiveAccess().getModelElementModelElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModelElement_in_ruleTraceDirective8572);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4755:2: ( (lv_conditionRHS_2_0= ruleConditionRHS ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=87 && LA74_0<=91)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4756:1: (lv_conditionRHS_2_0= ruleConditionRHS )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4756:1: (lv_conditionRHS_2_0= ruleConditionRHS )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4757:3: lv_conditionRHS_2_0= ruleConditionRHS
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTraceDirectiveAccess().getConditionRHSConditionRHSParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleConditionRHS_in_ruleTraceDirective8593);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4779:3: ( (lv_elementPattern_3_0= '*' ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==46) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4780:1: (lv_elementPattern_3_0= '*' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4780:1: (lv_elementPattern_3_0= '*' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4781:3: lv_elementPattern_3_0= '*'
                    {
                    lv_elementPattern_3_0=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_ruleTraceDirective8612); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4808:1: entryRuleTraceCase returns [EObject current=null] : iv_ruleTraceCase= ruleTraceCase EOF ;
    public final EObject entryRuleTraceCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTraceCase = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4809:2: (iv_ruleTraceCase= ruleTraceCase EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4810:2: iv_ruleTraceCase= ruleTraceCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTraceCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleTraceCase_in_entryRuleTraceCase8662);
            iv_ruleTraceCase=ruleTraceCase();
            _fsp--;

             current =iv_ruleTraceCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTraceCase8672); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4817:1: ruleTraceCase returns [EObject current=null] : ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' ) ;
    public final EObject ruleTraceCase() throws RecognitionException {
        EObject current = null;

        Token lv_traceCaseName_1_0=null;
        EObject lv_traceDirective_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4822:6: ( ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4823:1: ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4823:1: ( 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4823:3: 'tracecase' ( (lv_traceCaseName_1_0= RULE_ID ) ) '{' ( (lv_traceDirective_3_0= ruleTraceDirective ) )* '}'
            {
            match(input,84,FOLLOW_84_in_ruleTraceCase8707); 

                    createLeafNode(grammarAccess.getTraceCaseAccess().getTracecaseKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4827:1: ( (lv_traceCaseName_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4828:1: (lv_traceCaseName_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4828:1: (lv_traceCaseName_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4829:3: lv_traceCaseName_1_0= RULE_ID
            {
            lv_traceCaseName_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTraceCase8724); 

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

            match(input,17,FOLLOW_17_in_ruleTraceCase8739); 

                    createLeafNode(grammarAccess.getTraceCaseAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4855:1: ( (lv_traceDirective_3_0= ruleTraceDirective ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( ((LA76_0>=82 && LA76_0<=83)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4856:1: (lv_traceDirective_3_0= ruleTraceDirective )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4856:1: (lv_traceDirective_3_0= ruleTraceDirective )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4857:3: lv_traceDirective_3_0= ruleTraceDirective
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTraceCaseAccess().getTraceDirectiveTraceDirectiveParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTraceDirective_in_ruleTraceCase8760);
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
            	    break loop76;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleTraceCase8771); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4895:1: entryRuleCompoundTraceCondition returns [EObject current=null] : iv_ruleCompoundTraceCondition= ruleCompoundTraceCondition EOF ;
    public final EObject entryRuleCompoundTraceCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundTraceCondition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4896:2: (iv_ruleCompoundTraceCondition= ruleCompoundTraceCondition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4897:2: iv_ruleCompoundTraceCondition= ruleCompoundTraceCondition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCompoundTraceConditionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCompoundTraceCondition_in_entryRuleCompoundTraceCondition8811);
            iv_ruleCompoundTraceCondition=ruleCompoundTraceCondition();
            _fsp--;

             current =iv_ruleCompoundTraceCondition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompoundTraceCondition8821); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4904:1: ruleCompoundTraceCondition returns [EObject current=null] : ( (lv_operand_0_0= RULE_STRING ) ) ;
    public final EObject ruleCompoundTraceCondition() throws RecognitionException {
        EObject current = null;

        Token lv_operand_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4909:6: ( ( (lv_operand_0_0= RULE_STRING ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4910:1: ( (lv_operand_0_0= RULE_STRING ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4910:1: ( (lv_operand_0_0= RULE_STRING ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4911:1: (lv_operand_0_0= RULE_STRING )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4911:1: (lv_operand_0_0= RULE_STRING )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4912:3: lv_operand_0_0= RULE_STRING
            {
            lv_operand_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCompoundTraceCondition8862); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4942:1: entryRuleSimpleTraceCondition returns [EObject current=null] : iv_ruleSimpleTraceCondition= ruleSimpleTraceCondition EOF ;
    public final EObject entryRuleSimpleTraceCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTraceCondition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4943:2: (iv_ruleSimpleTraceCondition= ruleSimpleTraceCondition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4944:2: iv_ruleSimpleTraceCondition= ruleSimpleTraceCondition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleTraceConditionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleTraceCondition_in_entryRuleSimpleTraceCondition8902);
            iv_ruleSimpleTraceCondition=ruleSimpleTraceCondition();
            _fsp--;

             current =iv_ruleSimpleTraceCondition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleTraceCondition8912); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4951:1: ruleSimpleTraceCondition returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) ) ;
    public final EObject ruleSimpleTraceCondition() throws RecognitionException {
        EObject current = null;

        EObject lv_lhs_0_0 = null;

        EObject lv_conditionRHS_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4956:6: ( ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4957:1: ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4957:1: ( ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4957:2: ( (lv_lhs_0_0= ruleModelElement ) ) ( (lv_conditionRHS_1_0= ruleConditionRHS ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4957:2: ( (lv_lhs_0_0= ruleModelElement ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4958:1: (lv_lhs_0_0= ruleModelElement )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4958:1: (lv_lhs_0_0= ruleModelElement )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4959:3: lv_lhs_0_0= ruleModelElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSimpleTraceConditionAccess().getLhsModelElementParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModelElement_in_ruleSimpleTraceCondition8958);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4981:2: ( (lv_conditionRHS_1_0= ruleConditionRHS ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4982:1: (lv_conditionRHS_1_0= ruleConditionRHS )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4982:1: (lv_conditionRHS_1_0= ruleConditionRHS )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:4983:3: lv_conditionRHS_1_0= ruleConditionRHS
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSimpleTraceConditionAccess().getConditionRHSConditionRHSParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionRHS_in_ruleSimpleTraceCondition8979);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5013:1: entryRuleConditionRHS returns [EObject current=null] : iv_ruleConditionRHS= ruleConditionRHS EOF ;
    public final EObject entryRuleConditionRHS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionRHS = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5014:2: (iv_ruleConditionRHS= ruleConditionRHS EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5015:2: iv_ruleConditionRHS= ruleConditionRHS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionRHSRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionRHS_in_entryRuleConditionRHS9015);
            iv_ruleConditionRHS=ruleConditionRHS();
            _fsp--;

             current =iv_ruleConditionRHS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionRHS9025); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5022:1: ruleConditionRHS returns [EObject current=null] : ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) ) ;
    public final EObject ruleConditionRHS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operand_0_0 = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5027:6: ( ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5028:1: ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5028:1: ( ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5028:2: ( (lv_operand_0_0= ruleComparisonOperator ) ) ( (lv_value_1_0= rulePrimitiveType ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5028:2: ( (lv_operand_0_0= ruleComparisonOperator ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5029:1: (lv_operand_0_0= ruleComparisonOperator )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5029:1: (lv_operand_0_0= ruleComparisonOperator )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5030:3: lv_operand_0_0= ruleComparisonOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionRHSAccess().getOperandComparisonOperatorParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleComparisonOperator_in_ruleConditionRHS9071);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5052:2: ( (lv_value_1_0= rulePrimitiveType ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5053:1: (lv_value_1_0= rulePrimitiveType )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5053:1: (lv_value_1_0= rulePrimitiveType )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5054:3: lv_value_1_0= rulePrimitiveType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionRHSAccess().getValuePrimitiveTypeParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimitiveType_in_ruleConditionRHS9092);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5084:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5085:2: (iv_ruleModelElement= ruleModelElement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5086:2: iv_ruleModelElement= ruleModelElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleModelElement_in_entryRuleModelElement9128);
            iv_ruleModelElement=ruleModelElement();
            _fsp--;

             current =iv_ruleModelElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElement9138); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5093:1: ruleModelElement returns [EObject current=null] : ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token lv_executeOnEntry_0_0=null;
        Token lv_executeOnExit_1_0=null;
        Token lv_cflow_2_0=null;
        Token lv_aMethod_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5098:6: ( ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=75 && LA78_0<=76)||LA78_0==85) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_ID) ) {
                int LA78_2 = input.LA(2);

                if ( (LA78_2==86) ) {
                    alt78=1;
                }
                else if ( (LA78_2==EOF||(LA78_2>=RULE_STRING && LA78_2<=RULE_RUBY_FUNCTION)||LA78_2==18||LA78_2==29||LA78_2==33||LA78_2==36||LA78_2==41||LA78_2==46||(LA78_2>=50 && LA78_2<=51)||(LA78_2>=54 && LA78_2<=61)||LA78_2==63||(LA78_2>=67 && LA78_2<=71)||LA78_2==73||(LA78_2>=75 && LA78_2<=78)||(LA78_2>=80 && LA78_2<=84)||(LA78_2>=87 && LA78_2<=91)||(LA78_2>=99 && LA78_2<=100)||(LA78_2>=102 && LA78_2<=112)||(LA78_2>=124 && LA78_2<=128)) ) {
                    alt78=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("5099:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )", 78, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5099:1: ( ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' ) | ( ( RULE_ID ) ) )", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:2: ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:2: ( ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:3: ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )? ( (lv_aMethod_3_0= RULE_ID ) ) '()'
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:3: ( ( (lv_executeOnEntry_0_0= 'entry' ) ) | ( (lv_executeOnExit_1_0= 'exit' ) ) | ( (lv_cflow_2_0= 'cflow' ) ) )?
                    int alt77=4;
                    switch ( input.LA(1) ) {
                        case 75:
                            {
                            alt77=1;
                            }
                            break;
                        case 76:
                            {
                            alt77=2;
                            }
                            break;
                        case 85:
                            {
                            alt77=3;
                            }
                            break;
                    }

                    switch (alt77) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:4: ( (lv_executeOnEntry_0_0= 'entry' ) )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5099:4: ( (lv_executeOnEntry_0_0= 'entry' ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5100:1: (lv_executeOnEntry_0_0= 'entry' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5100:1: (lv_executeOnEntry_0_0= 'entry' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5101:3: lv_executeOnEntry_0_0= 'entry'
                            {
                            lv_executeOnEntry_0_0=(Token)input.LT(1);
                            match(input,75,FOLLOW_75_in_ruleModelElement9183); 

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
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5121:6: ( (lv_executeOnExit_1_0= 'exit' ) )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5121:6: ( (lv_executeOnExit_1_0= 'exit' ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5122:1: (lv_executeOnExit_1_0= 'exit' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5122:1: (lv_executeOnExit_1_0= 'exit' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5123:3: lv_executeOnExit_1_0= 'exit'
                            {
                            lv_executeOnExit_1_0=(Token)input.LT(1);
                            match(input,76,FOLLOW_76_in_ruleModelElement9220); 

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
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5143:6: ( (lv_cflow_2_0= 'cflow' ) )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5143:6: ( (lv_cflow_2_0= 'cflow' ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5144:1: (lv_cflow_2_0= 'cflow' )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5144:1: (lv_cflow_2_0= 'cflow' )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5145:3: lv_cflow_2_0= 'cflow'
                            {
                            lv_cflow_2_0=(Token)input.LT(1);
                            match(input,85,FOLLOW_85_in_ruleModelElement9257); 

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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5164:4: ( (lv_aMethod_3_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5165:1: (lv_aMethod_3_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5165:1: (lv_aMethod_3_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5166:3: lv_aMethod_3_0= RULE_ID
                    {
                    lv_aMethod_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement9289); 

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

                    match(input,86,FOLLOW_86_in_ruleModelElement9304); 

                            createLeafNode(grammarAccess.getModelElementAccess().getLeftParenthesisRightParenthesisKeyword_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5193:6: ( ( RULE_ID ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5193:6: ( ( RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5194:1: ( RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5194:1: ( RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5195:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement9329); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5215:1: entryRuleComparisonOperator returns [String current=null] : iv_ruleComparisonOperator= ruleComparisonOperator EOF ;
    public final String entryRuleComparisonOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComparisonOperator = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5216:2: (iv_ruleComparisonOperator= ruleComparisonOperator EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5217:2: iv_ruleComparisonOperator= ruleComparisonOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComparisonOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleComparisonOperator_in_entryRuleComparisonOperator9366);
            iv_ruleComparisonOperator=ruleComparisonOperator();
            _fsp--;

             current =iv_ruleComparisonOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparisonOperator9377); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5224:1: ruleComparisonOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleComparisonOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5229:6: ( (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5230:1: (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5230:1: (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' )
            int alt79=5;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt79=1;
                }
                break;
            case 88:
                {
                alt79=2;
                }
                break;
            case 89:
                {
                alt79=3;
                }
                break;
            case 90:
                {
                alt79=4;
                }
                break;
            case 91:
                {
                alt79=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5230:1: (kw= '>' | kw= '<' | kw= '==' | kw= '>=' | kw= '<=' )", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5231:2: kw= '>'
                    {
                    kw=(Token)input.LT(1);
                    match(input,87,FOLLOW_87_in_ruleComparisonOperator9415); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5238:2: kw= '<'
                    {
                    kw=(Token)input.LT(1);
                    match(input,88,FOLLOW_88_in_ruleComparisonOperator9434); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getLessThanSignKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5245:2: kw= '=='
                    {
                    kw=(Token)input.LT(1);
                    match(input,89,FOLLOW_89_in_ruleComparisonOperator9453); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getEqualsSignEqualsSignKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5252:2: kw= '>='
                    {
                    kw=(Token)input.LT(1);
                    match(input,90,FOLLOW_90_in_ruleComparisonOperator9472); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignEqualsSignKeyword_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5259:2: kw= '<='
                    {
                    kw=(Token)input.LT(1);
                    match(input,91,FOLLOW_91_in_ruleComparisonOperator9491); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5272:1: entryRuleTraceMechanism returns [EObject current=null] : iv_ruleTraceMechanism= ruleTraceMechanism EOF ;
    public final EObject entryRuleTraceMechanism() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTraceMechanism = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5273:2: (iv_ruleTraceMechanism= ruleTraceMechanism EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5274:2: iv_ruleTraceMechanism= ruleTraceMechanism EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTraceMechanismRule(), currentNode); 
            pushFollow(FOLLOW_ruleTraceMechanism_in_entryRuleTraceMechanism9531);
            iv_ruleTraceMechanism=ruleTraceMechanism();
            _fsp--;

             current =iv_ruleTraceMechanism; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTraceMechanism9541); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5281:1: ruleTraceMechanism returns [EObject current=null] : ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleTraceMechanism() throws RecognitionException {
        EObject current = null;

        Token lv_traceMechanism_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5286:6: ( ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5287:1: ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5287:1: ( 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5287:3: 'TraceUsing' ( (lv_traceMechanism_1_0= RULE_ID ) ) ';'
            {
            match(input,92,FOLLOW_92_in_ruleTraceMechanism9576); 

                    createLeafNode(grammarAccess.getTraceMechanismAccess().getTraceUsingKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5291:1: ( (lv_traceMechanism_1_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5292:1: (lv_traceMechanism_1_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5292:1: (lv_traceMechanism_1_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5293:3: lv_traceMechanism_1_0= RULE_ID
            {
            lv_traceMechanism_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTraceMechanism9593); 

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

            match(input,15,FOLLOW_15_in_ruleTraceMechanism9608); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5327:1: entryRuleblock returns [EObject current=null] : iv_ruleblock= ruleblock EOF ;
    public final EObject entryRuleblock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblock = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5328:2: (iv_ruleblock= ruleblock EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5329:2: iv_ruleblock= ruleblock EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBlockRule(), currentNode); 
            pushFollow(FOLLOW_ruleblock_in_entryRuleblock9644);
            iv_ruleblock=ruleblock();
            _fsp--;

             current =iv_ruleblock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblock9654); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5336:1: ruleblock returns [EObject current=null] : ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' ) ;
    public final EObject ruleblock() throws RecognitionException {
        EObject current = null;

        EObject lv_blocks_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5341:6: ( ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5342:1: ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5342:1: ( '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5342:3: '{' ( (lv_blocks_1_0= ruleblockStatement ) )* '}'
            {
            match(input,17,FOLLOW_17_in_ruleblock9689); 

                    createLeafNode(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5346:1: ( (lv_blocks_1_0= ruleblockStatement ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_INT)||LA80_0==15||LA80_0==17||LA80_0==29||LA80_0==33||LA80_0==36||LA80_0==41||(LA80_0>=54 && LA80_0<=61)||LA80_0==71||(LA80_0>=99 && LA80_0<=100)||(LA80_0>=102 && LA80_0<=108)||LA80_0==114||(LA80_0>=116 && LA80_0<=120)) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5347:1: (lv_blocks_1_0= ruleblockStatement )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5347:1: (lv_blocks_1_0= ruleblockStatement )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5348:3: lv_blocks_1_0= ruleblockStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBlockAccess().getBlocksBlockStatementParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleblockStatement_in_ruleblock9710);
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
            	    break loop80;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleblock9721); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5382:1: entryRuleparExpression returns [EObject current=null] : iv_ruleparExpression= ruleparExpression EOF ;
    public final EObject entryRuleparExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleparExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5383:2: (iv_ruleparExpression= ruleparExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5384:2: iv_ruleparExpression= ruleparExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleparExpression_in_entryRuleparExpression9757);
            iv_ruleparExpression=ruleparExpression();
            _fsp--;

             current =iv_ruleparExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleparExpression9767); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5391:1: ruleparExpression returns [EObject current=null] : ( '(' this_expression_1= ruleexpression ')' ) ;
    public final EObject ruleparExpression() throws RecognitionException {
        EObject current = null;

        EObject this_expression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5396:6: ( ( '(' this_expression_1= ruleexpression ')' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5397:1: ( '(' this_expression_1= ruleexpression ')' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5397:1: ( '(' this_expression_1= ruleexpression ')' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5397:3: '(' this_expression_1= ruleexpression ')'
            {
            match(input,71,FOLLOW_71_in_ruleparExpression9802); 

                    createLeafNode(grammarAccess.getParExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParExpressionAccess().getExpressionParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleexpression_in_ruleparExpression9824);
            this_expression_1=ruleexpression();
            _fsp--;

             
                    current = this_expression_1; 
                    currentNode = currentNode.getParent();
                
            match(input,72,FOLLOW_72_in_ruleparExpression9833); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5422:1: entryRuleassignmentOperator returns [String current=null] : iv_ruleassignmentOperator= ruleassignmentOperator EOF ;
    public final String entryRuleassignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleassignmentOperator = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5423:2: (iv_ruleassignmentOperator= ruleassignmentOperator EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5424:2: iv_ruleassignmentOperator= ruleassignmentOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator9870);
            iv_ruleassignmentOperator=ruleassignmentOperator();
            _fsp--;

             current =iv_ruleassignmentOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleassignmentOperator9881); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5431:1: ruleassignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' | kw= '-=' ) ;
    public final AntlrDatatypeRuleToken ruleassignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5436:6: ( (kw= '=' | kw= '+=' | kw= '-=' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5437:1: (kw= '=' | kw= '+=' | kw= '-=' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5437:1: (kw= '=' | kw= '+=' | kw= '-=' )
            int alt81=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt81=1;
                }
                break;
            case 93:
                {
                alt81=2;
                }
                break;
            case 94:
                {
                alt81=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5437:1: (kw= '=' | kw= '+=' | kw= '-=' )", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5438:2: kw= '='
                    {
                    kw=(Token)input.LT(1);
                    match(input,53,FOLLOW_53_in_ruleassignmentOperator9919); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5445:2: kw= '+='
                    {
                    kw=(Token)input.LT(1);
                    match(input,93,FOLLOW_93_in_ruleassignmentOperator9938); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5452:2: kw= '-='
                    {
                    kw=(Token)input.LT(1);
                    match(input,94,FOLLOW_94_in_ruleassignmentOperator9957); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5465:1: entryRuleexpressionList returns [EObject current=null] : iv_ruleexpressionList= ruleexpressionList EOF ;
    public final EObject entryRuleexpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpressionList = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5466:2: (iv_ruleexpressionList= ruleexpressionList EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5467:2: iv_ruleexpressionList= ruleexpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleexpressionList_in_entryRuleexpressionList9997);
            iv_ruleexpressionList=ruleexpressionList();
            _fsp--;

             current =iv_ruleexpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpressionList10007); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5474:1: ruleexpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) ;
    public final EObject ruleexpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5479:6: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5480:1: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5480:1: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5480:2: ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5480:2: ( (lv_expressions_0_0= ruleexpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5481:1: (lv_expressions_0_0= ruleexpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5481:1: (lv_expressions_0_0= ruleexpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5482:3: lv_expressions_0_0= ruleexpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList10053);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5504:2: ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==28) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5504:4: ',' ( (lv_expressions_2_0= ruleexpression ) )
            	    {
            	    match(input,28,FOLLOW_28_in_ruleexpressionList10064); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5508:1: ( (lv_expressions_2_0= ruleexpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5509:1: (lv_expressions_2_0= ruleexpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5509:1: (lv_expressions_2_0= ruleexpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5510:3: lv_expressions_2_0= ruleexpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleexpression_in_ruleexpressionList10085);
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
            	    break loop82;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5540:1: entryRuleexpression returns [EObject current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final EObject entryRuleexpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5541:2: (iv_ruleexpression= ruleexpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5542:2: iv_ruleexpression= ruleexpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleexpression_in_entryRuleexpression10123);
            iv_ruleexpression=ruleexpression();
            _fsp--;

             current =iv_ruleexpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexpression10133); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5549:1: ruleexpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) ;
    public final EObject ruleexpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5554:6: ( ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5555:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5555:1: ( ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5555:2: ( (lv_expression1_0_0= ruleconditionalExpression ) ) ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5555:2: ( (lv_expression1_0_0= ruleconditionalExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5556:1: (lv_expression1_0_0= ruleconditionalExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5556:1: (lv_expression1_0_0= ruleconditionalExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5557:3: lv_expression1_0_0= ruleconditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpression1ConditionalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleconditionalExpression_in_ruleexpression10179);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5579:2: ( ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) ) )?
            int alt83=2;
            switch ( input.LA(1) ) {
                case 53:
                    {
                    alt83=1;
                    }
                    break;
                case 93:
                    {
                    alt83=1;
                    }
                    break;
                case 94:
                    {
                    alt83=1;
                    }
                    break;
            }

            switch (alt83) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5580:5: ruleassignmentOperator ( (lv_expression2_2_0= ruleexpression ) )
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAssignmentOperatorParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleassignmentOperator_in_ruleexpression10196);
                    ruleassignmentOperator();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5587:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5588:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5588:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5589:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleexpression10216);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5619:1: entryRuleconditionalExpression returns [EObject current=null] : iv_ruleconditionalExpression= ruleconditionalExpression EOF ;
    public final EObject entryRuleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5620:2: (iv_ruleconditionalExpression= ruleconditionalExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5621:2: iv_ruleconditionalExpression= ruleconditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression10254);
            iv_ruleconditionalExpression=ruleconditionalExpression();
            _fsp--;

             current =iv_ruleconditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalExpression10264); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5628:1: ruleconditionalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) ;
    public final EObject ruleconditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expression2_2_0 = null;

        EObject lv_expression3_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5633:6: ( ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5634:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5634:1: ( ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5634:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) ) ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5634:2: ( (lv_expression1_0_0= ruleconditionalOrExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5635:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5635:1: (lv_expression1_0_0= ruleconditionalOrExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5636:3: lv_expression1_0_0= ruleconditionalOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression1ConditionalOrExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression10310);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5658:2: ( '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==95) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5658:4: '?' ( (lv_expression2_2_0= ruleexpression ) ) ':' ( (lv_expression3_4_0= ruleexpression ) )
                    {
                    match(input,95,FOLLOW_95_in_ruleconditionalExpression10321); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5662:1: ( (lv_expression2_2_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5663:1: (lv_expression2_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5663:1: (lv_expression2_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5664:3: lv_expression2_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression2ExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression10342);
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

                    match(input,14,FOLLOW_14_in_ruleconditionalExpression10352); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5690:1: ( (lv_expression3_4_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5691:1: (lv_expression3_4_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5691:1: (lv_expression3_4_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5692:3: lv_expression3_4_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpression3ExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleconditionalExpression10373);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5722:1: entryRuleconditionalOrExpression returns [EObject current=null] : iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF ;
    public final EObject entryRuleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalOrExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5723:2: (iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5724:2: iv_ruleconditionalOrExpression= ruleconditionalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression10411);
            iv_ruleconditionalOrExpression=ruleconditionalOrExpression();
            _fsp--;

             current =iv_ruleconditionalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalOrExpression10421); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5731:1: ruleconditionalOrExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) ;
    public final EObject ruleconditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5736:6: ( ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5737:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5737:1: ( ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5737:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) ) ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5737:2: ( (lv_expression1_0_0= ruleconditionalAndExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5738:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5738:1: (lv_expression1_0_0= ruleconditionalAndExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5739:3: lv_expression1_0_0= ruleconditionalAndExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpression1ConditionalAndExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10467);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5761:2: ( '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==96) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5761:4: '||' ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    {
            	    match(input,96,FOLLOW_96_in_ruleconditionalOrExpression10478); 

            	            createLeafNode(grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5765:1: ( (lv_expressionRest_2_0= ruleconditionalAndExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5766:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5766:1: (lv_expressionRest_2_0= ruleconditionalAndExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5767:3: lv_expressionRest_2_0= ruleconditionalAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpressionRestConditionalAndExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10499);
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
            	    break loop85;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5797:1: entryRuleconditionalAndExpression returns [EObject current=null] : iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF ;
    public final EObject entryRuleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleconditionalAndExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5798:2: (iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5799:2: iv_ruleconditionalAndExpression= ruleconditionalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression10537);
            iv_ruleconditionalAndExpression=ruleconditionalAndExpression();
            _fsp--;

             current =iv_ruleconditionalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleconditionalAndExpression10547); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5806:1: ruleconditionalAndExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) ;
    public final EObject ruleconditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5811:6: ( ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5812:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5812:1: ( ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5812:2: ( (lv_expression1_0_0= ruleequalityExpression ) ) ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5812:2: ( (lv_expression1_0_0= ruleequalityExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5813:1: (lv_expression1_0_0= ruleequalityExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5813:1: (lv_expression1_0_0= ruleequalityExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5814:3: lv_expression1_0_0= ruleequalityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpression1EqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10593);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5836:2: ( '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==97) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5836:4: '&&' ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    {
            	    match(input,97,FOLLOW_97_in_ruleconditionalAndExpression10604); 

            	            createLeafNode(grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5840:1: ( (lv_expressionRest_2_0= ruleequalityExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5841:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5841:1: (lv_expressionRest_2_0= ruleequalityExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5842:3: lv_expressionRest_2_0= ruleequalityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpressionRestEqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10625);
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
    // $ANTLR end ruleconditionalAndExpression


    // $ANTLR start entryRuleequalityExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5872:1: entryRuleequalityExpression returns [EObject current=null] : iv_ruleequalityExpression= ruleequalityExpression EOF ;
    public final EObject entryRuleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5873:2: (iv_ruleequalityExpression= ruleequalityExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5874:2: iv_ruleequalityExpression= ruleequalityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression10663);
            iv_ruleequalityExpression=ruleequalityExpression();
            _fsp--;

             current =iv_ruleequalityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleequalityExpression10673); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5881:1: ruleequalityExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) ;
    public final EObject ruleequalityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5886:6: ( ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5887:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5887:1: ( ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5887:2: ( (lv_expression1_0_0= rulerelationalExpression ) ) ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5887:2: ( (lv_expression1_0_0= rulerelationalExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5888:1: (lv_expression1_0_0= rulerelationalExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5888:1: (lv_expression1_0_0= rulerelationalExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5889:3: lv_expression1_0_0= rulerelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpression1RelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression10719);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5911:2: ( ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==89||LA88_0==98) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5911:3: ( '==' | '!=' ) ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5911:3: ( '==' | '!=' )
            	    int alt87=2;
            	    int LA87_0 = input.LA(1);

            	    if ( (LA87_0==89) ) {
            	        alt87=1;
            	    }
            	    else if ( (LA87_0==98) ) {
            	        alt87=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("5911:3: ( '==' | '!=' )", 87, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt87) {
            	        case 1 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5911:5: '=='
            	            {
            	            match(input,89,FOLLOW_89_in_ruleequalityExpression10731); 

            	                    createLeafNode(grammarAccess.getEqualityExpressionAccess().getEqualsSignEqualsSignKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5916:7: '!='
            	            {
            	            match(input,98,FOLLOW_98_in_ruleequalityExpression10747); 

            	                    createLeafNode(grammarAccess.getEqualityExpressionAccess().getExclamationMarkEqualsSignKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5920:2: ( (lv_expressionRest_3_0= rulerelationalExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5921:1: (lv_expressionRest_3_0= rulerelationalExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5922:3: lv_expressionRest_3_0= rulerelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpressionRestRelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulerelationalExpression_in_ruleequalityExpression10769);
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
            	    break loop88;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5952:1: entryRulerelationalExpression returns [EObject current=null] : iv_rulerelationalExpression= rulerelationalExpression EOF ;
    public final EObject entryRulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5953:2: (iv_rulerelationalExpression= rulerelationalExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5954:2: iv_rulerelationalExpression= rulerelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression10807);
            iv_rulerelationalExpression=rulerelationalExpression();
            _fsp--;

             current =iv_rulerelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalExpression10817); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5961:1: rulerelationalExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) ;
    public final EObject rulerelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5966:6: ( ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5967:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5967:1: ( ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5967:2: ( (lv_expression1_0_0= ruleadditiveExpression ) ) ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5967:2: ( (lv_expression1_0_0= ruleadditiveExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5968:1: (lv_expression1_0_0= ruleadditiveExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5968:1: (lv_expression1_0_0= ruleadditiveExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5969:3: lv_expression1_0_0= ruleadditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpression1AdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10863);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5991:2: ( rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( ((LA89_0>=87 && LA89_0<=88)||(LA89_0>=90 && LA89_0<=91)) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5992:5: rulerelationalOp ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRelationalOpParserRuleCall_1_0(), currentNode); 
            	        
            	    pushFollow(FOLLOW_rulerelationalOp_in_rulerelationalExpression10880);
            	    rulerelationalOp();
            	    _fsp--;

            	     
            	            currentNode = currentNode.getParent();
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:5999:1: ( (lv_expressionRest_2_0= ruleadditiveExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6000:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6000:1: (lv_expressionRest_2_0= ruleadditiveExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6001:3: lv_expressionRest_2_0= ruleadditiveExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpressionRestAdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10900);
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
            	    break loop89;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6031:1: entryRulerelationalOp returns [String current=null] : iv_rulerelationalOp= rulerelationalOp EOF ;
    public final String entryRulerelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerelationalOp = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6032:2: (iv_rulerelationalOp= rulerelationalOp EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6033:2: iv_rulerelationalOp= rulerelationalOp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalOpRule(), currentNode); 
            pushFollow(FOLLOW_rulerelationalOp_in_entryRulerelationalOp10939);
            iv_rulerelationalOp=rulerelationalOp();
            _fsp--;

             current =iv_rulerelationalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalOp10950); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6040:1: rulerelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken rulerelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6045:6: ( (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6046:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6046:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )
            int alt90=4;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt90=1;
                }
                break;
            case 88:
                {
                alt90=2;
                }
                break;
            case 90:
                {
                alt90=3;
                }
                break;
            case 87:
                {
                alt90=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6046:1: (kw= '<=' | kw= '<' | kw= '>=' | kw= '>' )", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6047:2: kw= '<='
                    {
                    kw=(Token)input.LT(1);
                    match(input,91,FOLLOW_91_in_rulerelationalOp10988); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6054:2: kw= '<'
                    {
                    kw=(Token)input.LT(1);
                    match(input,88,FOLLOW_88_in_rulerelationalOp11007); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6061:2: kw= '>='
                    {
                    kw=(Token)input.LT(1);
                    match(input,90,FOLLOW_90_in_rulerelationalOp11026); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6068:2: kw= '>'
                    {
                    kw=(Token)input.LT(1);
                    match(input,87,FOLLOW_87_in_rulerelationalOp11045); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6081:1: entryRuleadditiveExpression returns [EObject current=null] : iv_ruleadditiveExpression= ruleadditiveExpression EOF ;
    public final EObject entryRuleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6082:2: (iv_ruleadditiveExpression= ruleadditiveExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6083:2: iv_ruleadditiveExpression= ruleadditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression11085);
            iv_ruleadditiveExpression=ruleadditiveExpression();
            _fsp--;

             current =iv_ruleadditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleadditiveExpression11095); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6090:1: ruleadditiveExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) ;
    public final EObject ruleadditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6095:6: ( ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6096:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6096:1: ( ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6096:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) ) ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6096:2: ( (lv_expression1_0_0= rulemultiplicativeExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6097:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6097:1: (lv_expression1_0_0= rulemultiplicativeExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6098:3: lv_expression1_0_0= rulemultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpression1MultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11141);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6120:2: ( ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( ((LA92_0>=99 && LA92_0<=100)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6120:3: ( '+' | '-' ) ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6120:3: ( '+' | '-' )
            	    int alt91=2;
            	    int LA91_0 = input.LA(1);

            	    if ( (LA91_0==99) ) {
            	        alt91=1;
            	    }
            	    else if ( (LA91_0==100) ) {
            	        alt91=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("6120:3: ( '+' | '-' )", 91, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt91) {
            	        case 1 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6120:5: '+'
            	            {
            	            match(input,99,FOLLOW_99_in_ruleadditiveExpression11153); 

            	                    createLeafNode(grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6125:7: '-'
            	            {
            	            match(input,100,FOLLOW_100_in_ruleadditiveExpression11169); 

            	                    createLeafNode(grammarAccess.getAdditiveExpressionAccess().getHyphenMinusKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6129:2: ( (lv_expressionRest_3_0= rulemultiplicativeExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6130:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6130:1: (lv_expressionRest_3_0= rulemultiplicativeExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6131:3: lv_expressionRest_3_0= rulemultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpressionRestMultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11191);
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
    // $ANTLR end ruleadditiveExpression


    // $ANTLR start entryRulemultiplicativeExpression
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6161:1: entryRulemultiplicativeExpression returns [EObject current=null] : iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF ;
    public final EObject entryRulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6162:2: (iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6163:2: iv_rulemultiplicativeExpression= rulemultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression11229);
            iv_rulemultiplicativeExpression=rulemultiplicativeExpression();
            _fsp--;

             current =iv_rulemultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicativeExpression11239); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6170:1: rulemultiplicativeExpression returns [EObject current=null] : ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) ;
    public final EObject rulemultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression1_0_0 = null;

        EObject lv_expressionRest_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6175:6: ( ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6176:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6176:1: ( ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6176:2: ( (lv_expression1_0_0= ruleunaryExpression ) ) ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6176:2: ( (lv_expression1_0_0= ruleunaryExpression ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6177:1: (lv_expression1_0_0= ruleunaryExpression )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6177:1: (lv_expression1_0_0= ruleunaryExpression )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6178:3: lv_expression1_0_0= ruleunaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpression1UnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11285);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6200:2: ( ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==46||LA94_0==74||LA94_0==101) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6200:3: ( '*' | '/' | '%' ) ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6200:3: ( '*' | '/' | '%' )
            	    int alt93=3;
            	    switch ( input.LA(1) ) {
            	    case 46:
            	        {
            	        alt93=1;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt93=2;
            	        }
            	        break;
            	    case 101:
            	        {
            	        alt93=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("6200:3: ( '*' | '/' | '%' )", 93, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt93) {
            	        case 1 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6200:5: '*'
            	            {
            	            match(input,46,FOLLOW_46_in_rulemultiplicativeExpression11297); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_0(), null); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6205:7: '/'
            	            {
            	            match(input,74,FOLLOW_74_in_rulemultiplicativeExpression11313); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_0_1(), null); 
            	                

            	            }
            	            break;
            	        case 3 :
            	            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6210:7: '%'
            	            {
            	            match(input,101,FOLLOW_101_in_rulemultiplicativeExpression11329); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_0_2(), null); 
            	                

            	            }
            	            break;

            	    }

            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6214:2: ( (lv_expressionRest_4_0= ruleunaryExpression ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6215:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6215:1: (lv_expressionRest_4_0= ruleunaryExpression )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6216:3: lv_expressionRest_4_0= ruleunaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpressionRestUnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11351);
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
            	    break loop94;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6246:1: entryRuleunaryExpression returns [EObject current=null] : iv_ruleunaryExpression= ruleunaryExpression EOF ;
    public final EObject entryRuleunaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpression = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6247:2: (iv_ruleunaryExpression= ruleunaryExpression EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6248:2: iv_ruleunaryExpression= ruleunaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression11389);
            iv_ruleunaryExpression=ruleunaryExpression();
            _fsp--;

             current =iv_ruleunaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpression11399); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6255:1: ruleunaryExpression returns [EObject current=null] : ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) ;
    public final EObject ruleunaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp1_1_0 = null;

        EObject lv_exp1_3_0 = null;

        EObject lv_exp1_5_0 = null;

        EObject lv_exp1_7_0 = null;

        EObject lv_exp2_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6260:6: ( ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6261:1: ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6261:1: ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )
            int alt95=5;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt95=1;
                }
                break;
            case 100:
                {
                alt95=2;
                }
                break;
            case 102:
                {
                alt95=3;
                }
                break;
            case 41:
                {
                alt95=4;
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
                alt95=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6261:1: ( ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) ) | ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) ) | ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) ) | ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) ) | ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) ) )", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6261:2: ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6261:2: ( '+' ( (lv_exp1_1_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6261:4: '+' ( (lv_exp1_1_0= ruleunaryExpression ) )
                    {
                    match(input,99,FOLLOW_99_in_ruleunaryExpression11435); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getPlusSignKeyword_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6265:1: ( (lv_exp1_1_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6266:1: (lv_exp1_1_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6266:1: (lv_exp1_1_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6267:3: lv_exp1_1_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11456);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6290:6: ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6290:6: ( '-' ( (lv_exp1_3_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6290:8: '-' ( (lv_exp1_3_0= ruleunaryExpression ) )
                    {
                    match(input,100,FOLLOW_100_in_ruleunaryExpression11474); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getHyphenMinusKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6294:1: ( (lv_exp1_3_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6295:1: (lv_exp1_3_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6295:1: (lv_exp1_3_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6296:3: lv_exp1_3_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11495);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6319:6: ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6319:6: ( '++' ( (lv_exp1_5_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6319:8: '++' ( (lv_exp1_5_0= ruleunaryExpression ) )
                    {
                    match(input,102,FOLLOW_102_in_ruleunaryExpression11513); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getPlusSignPlusSignKeyword_2_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6323:1: ( (lv_exp1_5_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6324:1: (lv_exp1_5_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6324:1: (lv_exp1_5_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6325:3: lv_exp1_5_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11534);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6348:6: ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6348:6: ( '--' ( (lv_exp1_7_0= ruleunaryExpression ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6348:8: '--' ( (lv_exp1_7_0= ruleunaryExpression ) )
                    {
                    match(input,41,FOLLOW_41_in_ruleunaryExpression11552); 

                            createLeafNode(grammarAccess.getUnaryExpressionAccess().getHyphenMinusHyphenMinusKeyword_3_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6352:1: ( (lv_exp1_7_0= ruleunaryExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6353:1: (lv_exp1_7_0= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6353:1: (lv_exp1_7_0= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6354:3: lv_exp1_7_0= ruleunaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp1UnaryExpressionParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpression11573);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6377:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6377:6: ( (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6378:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6378:1: (lv_exp2_8_0= ruleunaryExpressionNotPlusMinus )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6379:3: lv_exp2_8_0= ruleunaryExpressionNotPlusMinus
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExp2UnaryExpressionNotPlusMinusParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression11601);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6409:1: entryRuleunaryExpressionNotPlusMinus returns [EObject current=null] : iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF ;
    public final EObject entryRuleunaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryExpressionNotPlusMinus = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6410:2: (iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6411:2: iv_ruleunaryExpressionNotPlusMinus= ruleunaryExpressionNotPlusMinus EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusRule(), currentNode); 
            pushFollow(FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus11637);
            iv_ruleunaryExpressionNotPlusMinus=ruleunaryExpressionNotPlusMinus();
            _fsp--;

             current =iv_ruleunaryExpressionNotPlusMinus; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus11647); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6418:1: ruleunaryExpressionNotPlusMinus returns [EObject current=null] : ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) ) ;
    public final EObject ruleunaryExpressionNotPlusMinus() throws RecognitionException {
        EObject current = null;

        EObject this_unaryExpression_1 = null;

        EObject this_unaryExpression_3 = null;

        EObject this_primary_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6423:6: ( ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6424:1: ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6424:1: ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) )
            int alt97=3;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt97=1;
                }
                break;
            case 104:
                {
                alt97=2;
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
                alt97=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6424:1: ( ( '~' this_unaryExpression_1= ruleunaryExpression ) | ( '!' this_unaryExpression_3= ruleunaryExpression ) | (this_primary_4= ruleprimary ( '++' | '--' )? ) )", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6424:2: ( '~' this_unaryExpression_1= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6424:2: ( '~' this_unaryExpression_1= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6424:4: '~' this_unaryExpression_1= ruleunaryExpression
                    {
                    match(input,103,FOLLOW_103_in_ruleunaryExpressionNotPlusMinus11683); 

                            createLeafNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getTildeKeyword_0_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11705);
                    this_unaryExpression_1=ruleunaryExpression();
                    _fsp--;

                     
                            current = this_unaryExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6438:6: ( '!' this_unaryExpression_3= ruleunaryExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6438:6: ( '!' this_unaryExpression_3= ruleunaryExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6438:8: '!' this_unaryExpression_3= ruleunaryExpression
                    {
                    match(input,104,FOLLOW_104_in_ruleunaryExpressionNotPlusMinus11722); 

                            createLeafNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getExclamationMarkKeyword_1_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getUnaryExpressionParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11744);
                    this_unaryExpression_3=ruleunaryExpression();
                    _fsp--;

                     
                            current = this_unaryExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6452:6: (this_primary_4= ruleprimary ( '++' | '--' )? )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6452:6: (this_primary_4= ruleprimary ( '++' | '--' )? )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6453:5: this_primary_4= ruleprimary ( '++' | '--' )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPrimaryParserRuleCall_2_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus11773);
                    this_primary_4=ruleprimary();
                    _fsp--;

                     
                            current = this_primary_4; 
                            currentNode = currentNode.getParent();
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6461:1: ( '++' | '--' )?
                    int alt96=3;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==102) ) {
                        alt96=1;
                    }
                    else if ( (LA96_0==41) ) {
                        alt96=2;
                    }
                    switch (alt96) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6461:3: '++'
                            {
                            match(input,102,FOLLOW_102_in_ruleunaryExpressionNotPlusMinus11783); 

                                    createLeafNode(grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPlusSignPlusSignKeyword_2_1_0(), null); 
                                

                            }
                            break;
                        case 2 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6466:7: '--'
                            {
                            match(input,41,FOLLOW_41_in_ruleunaryExpressionNotPlusMinus11799); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6478:1: entryRuleprimary returns [EObject current=null] : iv_ruleprimary= ruleprimary EOF ;
    public final EObject entryRuleprimary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimary = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6479:2: (iv_ruleprimary= ruleprimary EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6480:2: iv_ruleprimary= ruleprimary EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryRule(), currentNode); 
            pushFollow(FOLLOW_ruleprimary_in_entryRuleprimary11838);
            iv_ruleprimary=ruleprimary();
            _fsp--;

             current =iv_ruleprimary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimary11848); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6487:1: ruleprimary returns [EObject current=null] : (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) ;
    public final EObject ruleprimary() throws RecognitionException {
        EObject current = null;

        EObject this_parExpression_0 = null;

        EObject this_literal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6492:6: ( (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6493:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6493:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==71) ) {
                alt98=1;
            }
            else if ( ((LA98_0>=RULE_STRING && LA98_0<=RULE_INT)||(LA98_0>=105 && LA98_0<=108)) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6493:1: (this_parExpression_0= ruleparExpression | this_literal_1= ruleliteral )", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6494:5: this_parExpression_0= ruleparExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryAccess().getParExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleparExpression_in_ruleprimary11895);
                    this_parExpression_0=ruleparExpression();
                    _fsp--;

                     
                            current = this_parExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6504:5: this_literal_1= ruleliteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleliteral_in_ruleprimary11922);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6520:1: entryRuleliteral returns [EObject current=null] : iv_ruleliteral= ruleliteral EOF ;
    public final EObject entryRuleliteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleliteral = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6521:2: (iv_ruleliteral= ruleliteral EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6522:2: iv_ruleliteral= ruleliteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleliteral_in_entryRuleliteral11957);
            iv_ruleliteral=ruleliteral();
            _fsp--;

             current =iv_ruleliteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleliteral11967); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6529:1: ruleliteral returns [EObject current=null] : ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' ) ;
    public final EObject ruleliteral() throws RecognitionException {
        EObject current = null;

        EObject this_javaFunctionCall_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6534:6: ( ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6535:1: ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6535:1: ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' )
            int alt99=9;
            alt99 = dfa99.predict(input);
            switch (alt99) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6535:2: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleliteral12001); 
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6541:5: ruleDOUBLE
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDOUBLEParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDOUBLE_in_ruleliteral12022);
                    ruleDOUBLE();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6549:6: RULE_STRING
                    {
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleliteral12036); 
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6555:5: ruleextendedID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getExtendedIDParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleliteral12057);
                    ruleextendedID();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6564:5: this_javaFunctionCall_4= rulejavaFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getJavaFunctionCallParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_rulejavaFunctionCall_in_ruleliteral12084);
                    this_javaFunctionCall_4=rulejavaFunctionCall();
                    _fsp--;

                     
                            current = this_javaFunctionCall_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6573:7: 'true'
                    {
                    match(input,105,FOLLOW_105_in_ruleliteral12099); 

                            createLeafNode(grammarAccess.getLiteralAccess().getTrueKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6578:7: 'TRUE'
                    {
                    match(input,106,FOLLOW_106_in_ruleliteral12115); 

                            createLeafNode(grammarAccess.getLiteralAccess().getTRUEKeyword_6(), null); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6583:7: 'false'
                    {
                    match(input,107,FOLLOW_107_in_ruleliteral12131); 

                            createLeafNode(grammarAccess.getLiteralAccess().getFalseKeyword_7(), null); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6588:7: 'FALSE'
                    {
                    match(input,108,FOLLOW_108_in_ruleliteral12147); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6602:1: entryRulefunctionDeclaration returns [EObject current=null] : iv_rulefunctionDeclaration= rulefunctionDeclaration EOF ;
    public final EObject entryRulefunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefunctionDeclaration = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6603:2: (iv_rulefunctionDeclaration= rulefunctionDeclaration EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6604:2: iv_rulefunctionDeclaration= rulefunctionDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_rulefunctionDeclaration_in_entryRulefunctionDeclaration12185);
            iv_rulefunctionDeclaration=rulefunctionDeclaration();
            _fsp--;

             current =iv_rulefunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulefunctionDeclaration12195); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6611:1: rulefunctionDeclaration returns [EObject current=null] : ( (lv_java_0_0= rulejavaFunctionDeclaration ) ) ;
    public final EObject rulefunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_java_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6616:6: ( ( (lv_java_0_0= rulejavaFunctionDeclaration ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6617:1: ( (lv_java_0_0= rulejavaFunctionDeclaration ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6617:1: ( (lv_java_0_0= rulejavaFunctionDeclaration ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6618:1: (lv_java_0_0= rulejavaFunctionDeclaration )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6618:1: (lv_java_0_0= rulejavaFunctionDeclaration )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6619:3: lv_java_0_0= rulejavaFunctionDeclaration
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDeclarationAccess().getJavaJavaFunctionDeclarationParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_rulefunctionDeclaration12240);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6649:1: entryRulefunctionDefinition returns [EObject current=null] : iv_rulefunctionDefinition= rulefunctionDefinition EOF ;
    public final EObject entryRulefunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefunctionDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6650:2: (iv_rulefunctionDefinition= rulefunctionDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6651:2: iv_rulefunctionDefinition= rulefunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_rulefunctionDefinition_in_entryRulefunctionDefinition12275);
            iv_rulefunctionDefinition=rulefunctionDefinition();
            _fsp--;

             current =iv_rulefunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulefunctionDefinition12285); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6658:1: rulefunctionDefinition returns [EObject current=null] : ( (lv_java_0_0= rulejavaFunctionDefinition ) ) ;
    public final EObject rulefunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_java_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6663:6: ( ( (lv_java_0_0= rulejavaFunctionDefinition ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6664:1: ( (lv_java_0_0= rulejavaFunctionDefinition ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6664:1: ( (lv_java_0_0= rulejavaFunctionDefinition ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6665:1: (lv_java_0_0= rulejavaFunctionDefinition )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6665:1: (lv_java_0_0= rulejavaFunctionDefinition )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6666:3: lv_java_0_0= rulejavaFunctionDefinition
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getJavaJavaFunctionDefinitionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDefinition_in_rulefunctionDefinition12330);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6696:1: entryRulejavaFunctionDeclaration returns [EObject current=null] : iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF ;
    public final EObject entryRulejavaFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDeclaration = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6697:2: (iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6698:2: iv_rulejavaFunctionDeclaration= rulejavaFunctionDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaFunctionDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration12365);
            iv_rulejavaFunctionDeclaration=rulejavaFunctionDeclaration();
            _fsp--;

             current =iv_rulejavaFunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDeclaration12375); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6705:1: rulejavaFunctionDeclaration returns [EObject current=null] : ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) ) ;
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
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6710:6: ( ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6711:1: ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6711:1: ( ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6711:2: ( 'static' )? ( 'public' | 'private' | 'protected' ) ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) ) ( (lv_name_7_0= RULE_ID ) ) ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6711:2: ( 'static' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==109) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6711:4: 'static'
                    {
                    match(input,109,FOLLOW_109_in_rulejavaFunctionDeclaration12411); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getStaticKeyword_0(), null); 
                        

                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6715:3: ( 'public' | 'private' | 'protected' )
            int alt101=3;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt101=1;
                }
                break;
            case 111:
                {
                alt101=2;
                }
                break;
            case 112:
                {
                alt101=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6715:3: ( 'public' | 'private' | 'protected' )", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6715:5: 'public'
                    {
                    match(input,110,FOLLOW_110_in_rulejavaFunctionDeclaration12424); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getPublicKeyword_1_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6720:7: 'private'
                    {
                    match(input,111,FOLLOW_111_in_rulejavaFunctionDeclaration12440); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getPrivateKeyword_1_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6725:7: 'protected'
                    {
                    match(input,112,FOLLOW_112_in_rulejavaFunctionDeclaration12456); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getProtectedKeyword_1_2(), null); 
                        

                    }
                    break;

            }

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6729:2: ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) )
            int alt102=3;
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
                alt102=1;
                }
                break;
            case 113:
                {
                alt102=2;
                }
                break;
            case RULE_ID:
                {
                alt102=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6729:2: ( ( (lv_returnType_4_0= ruleattributeType ) ) | 'void' | ( (lv_referenceType_6_0= RULE_ID ) ) )", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6729:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6729:3: ( (lv_returnType_4_0= ruleattributeType ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6730:1: (lv_returnType_4_0= ruleattributeType )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6730:1: (lv_returnType_4_0= ruleattributeType )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6731:3: lv_returnType_4_0= ruleattributeType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getReturnTypeAttributeTypeParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12479);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6754:7: 'void'
                    {
                    match(input,113,FOLLOW_113_in_rulejavaFunctionDeclaration12495); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getVoidKeyword_2_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6759:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6759:6: ( (lv_referenceType_6_0= RULE_ID ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6760:1: (lv_referenceType_6_0= RULE_ID )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6760:1: (lv_referenceType_6_0= RULE_ID )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6761:3: lv_referenceType_6_0= RULE_ID
                    {
                    lv_referenceType_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12518); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6783:3: ( (lv_name_7_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6784:1: (lv_name_7_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6784:1: (lv_name_7_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6785:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12541); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6807:2: ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' )
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
                    new NoViableAltException("6807:2: ( ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' ) | '()' )", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6807:3: ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6807:3: ( '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6807:5: '(' ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )? ')'
                    {
                    match(input,71,FOLLOW_71_in_rulejavaFunctionDeclaration12558); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisKeyword_4_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6811:1: ( ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )* )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==29||LA104_0==33||LA104_0==36||(LA104_0>=54 && LA104_0<=61)) ) {
                        alt104=1;
                    }
                    switch (alt104) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6811:2: ( (lv_argList_9_0= ruleattributeType ) ) ( (lv_argListID_10_0= ruleextendedID ) ) ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6811:2: ( (lv_argList_9_0= ruleattributeType ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6812:1: (lv_argList_9_0= ruleattributeType )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6812:1: (lv_argList_9_0= ruleattributeType )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6813:3: lv_argList_9_0= ruleattributeType
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12580);
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

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6835:2: ( (lv_argListID_10_0= ruleextendedID ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6836:1: (lv_argListID_10_0= ruleextendedID )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6836:1: (lv_argListID_10_0= ruleextendedID )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6837:3: lv_argListID_10_0= ruleextendedID
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12601);
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

                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6859:2: ( ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) ) )*
                            loop103:
                            do {
                                int alt103=2;
                                int LA103_0 = input.LA(1);

                                if ( (LA103_0==28) ) {
                                    alt103=1;
                                }


                                switch (alt103) {
                            	case 1 :
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6859:4: ',' ( (lv_argList_12_0= ruleattributeType ) ) ( (lv_argListID_13_0= ruleextendedID ) )
                            	    {
                            	    match(input,28,FOLLOW_28_in_rulejavaFunctionDeclaration12612); 

                            	            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getCommaKeyword_4_0_1_2_0(), null); 
                            	        
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6863:1: ( (lv_argList_12_0= ruleattributeType ) )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6864:1: (lv_argList_12_0= ruleattributeType )
                            	    {
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6864:1: (lv_argList_12_0= ruleattributeType )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6865:3: lv_argList_12_0= ruleattributeType
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListAttributeTypeParserRuleCall_4_0_1_2_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12633);
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

                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6887:2: ( (lv_argListID_13_0= ruleextendedID ) )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6888:1: (lv_argListID_13_0= ruleextendedID )
                            	    {
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6888:1: (lv_argListID_13_0= ruleextendedID )
                            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6889:3: lv_argListID_13_0= ruleextendedID
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDeclarationAccess().getArgListIDExtendedIDParserRuleCall_4_0_1_2_2_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12654);
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
                            	    break loop103;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,72,FOLLOW_72_in_rulejavaFunctionDeclaration12668); 

                            createLeafNode(grammarAccess.getJavaFunctionDeclarationAccess().getRightParenthesisKeyword_4_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6916:7: '()'
                    {
                    match(input,86,FOLLOW_86_in_rulejavaFunctionDeclaration12685); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6928:1: entryRulejavaFunctionDefinition returns [EObject current=null] : iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF ;
    public final EObject entryRulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionDefinition = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6929:2: (iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6930:2: iv_rulejavaFunctionDefinition= rulejavaFunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition12722);
            iv_rulejavaFunctionDefinition=rulejavaFunctionDefinition();
            _fsp--;

             current =iv_rulejavaFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionDefinition12732); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6937:1: rulejavaFunctionDefinition returns [EObject current=null] : ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) ;
    public final EObject rulejavaFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_decl_0_0 = null;

        EObject lv_code_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6942:6: ( ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6943:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6943:1: ( ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6943:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) ) ( (lv_code_1_0= ruleblock ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6943:2: ( (lv_decl_0_0= rulejavaFunctionDeclaration ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6944:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6944:1: (lv_decl_0_0= rulejavaFunctionDeclaration )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6945:3: lv_decl_0_0= rulejavaFunctionDeclaration
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getDeclJavaFunctionDeclarationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition12778);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6967:2: ( (lv_code_1_0= ruleblock ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6968:1: (lv_code_1_0= ruleblock )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6968:1: (lv_code_1_0= ruleblock )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6969:3: lv_code_1_0= ruleblock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionDefinitionAccess().getCodeBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleblock_in_rulejavaFunctionDefinition12799);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:6999:1: entryRulejavaFunctionCall returns [EObject current=null] : iv_rulejavaFunctionCall= rulejavaFunctionCall EOF ;
    public final EObject entryRulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulejavaFunctionCall = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7000:2: (iv_rulejavaFunctionCall= rulejavaFunctionCall EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7001:2: iv_rulejavaFunctionCall= rulejavaFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJavaFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall12835);
            iv_rulejavaFunctionCall=rulejavaFunctionCall();
            _fsp--;

             current =iv_rulejavaFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRulejavaFunctionCall12845); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7008:1: rulejavaFunctionCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) ) ;
    public final EObject rulejavaFunctionCall() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_args_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7013:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7014:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7014:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7014:2: ( (lv_name_0_0= ruleextendedID ) ) ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7014:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7015:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7015:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7016:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionCallAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulejavaFunctionCall12891);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7038:2: ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==71) ) {
                alt107=1;
            }
            else if ( (LA107_0==86) ) {
                alt107=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("7038:2: ( ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' ) | '()' )", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7038:3: ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7038:3: ( '(' ( (lv_args_2_0= ruleexpressionList ) )? ')' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7038:5: '(' ( (lv_args_2_0= ruleexpressionList ) )? ')'
                    {
                    match(input,71,FOLLOW_71_in_rulejavaFunctionCall12903); 

                            createLeafNode(grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisKeyword_1_0_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7042:1: ( (lv_args_2_0= ruleexpressionList ) )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( ((LA106_0>=RULE_STRING && LA106_0<=RULE_INT)||LA106_0==41||LA106_0==71||(LA106_0>=99 && LA106_0<=100)||(LA106_0>=102 && LA106_0<=108)) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7043:1: (lv_args_2_0= ruleexpressionList )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7043:1: (lv_args_2_0= ruleexpressionList )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7044:3: lv_args_2_0= ruleexpressionList
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getJavaFunctionCallAccess().getArgsExpressionListParserRuleCall_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleexpressionList_in_rulejavaFunctionCall12924);
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

                    match(input,72,FOLLOW_72_in_rulejavaFunctionCall12935); 

                            createLeafNode(grammarAccess.getJavaFunctionCallAccess().getRightParenthesisKeyword_1_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7071:7: '()'
                    {
                    match(input,86,FOLLOW_86_in_rulejavaFunctionCall12952); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7083:1: entryRuleblockStatement returns [EObject current=null] : iv_ruleblockStatement= ruleblockStatement EOF ;
    public final EObject entryRuleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleblockStatement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7084:2: (iv_ruleblockStatement= ruleblockStatement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7085:2: iv_ruleblockStatement= ruleblockStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBlockStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleblockStatement_in_entryRuleblockStatement12989);
            iv_ruleblockStatement=ruleblockStatement();
            _fsp--;

             current =iv_ruleblockStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleblockStatement12999); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7092:1: ruleblockStatement returns [EObject current=null] : (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) ;
    public final EObject ruleblockStatement() throws RecognitionException {
        EObject current = null;

        EObject this_statement_0 = null;

        EObject this_localVariableDeclarationStatement_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7097:6: ( (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7098:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7098:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( ((LA108_0>=RULE_STRING && LA108_0<=RULE_INT)||LA108_0==15||LA108_0==17||LA108_0==41||LA108_0==71||(LA108_0>=99 && LA108_0<=100)||(LA108_0>=102 && LA108_0<=108)||LA108_0==114||(LA108_0>=116 && LA108_0<=120)) ) {
                alt108=1;
            }
            else if ( (LA108_0==29||LA108_0==33||LA108_0==36||(LA108_0>=54 && LA108_0<=61)) ) {
                alt108=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("7098:1: (this_statement_0= rulestatement | this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement )", 108, 0, input);

                throw nvae;
            }
            switch (alt108) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7099:5: this_statement_0= rulestatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBlockStatementAccess().getStatementParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulestatement_in_ruleblockStatement13046);
                    this_statement_0=rulestatement();
                    _fsp--;

                     
                            current = this_statement_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7109:5: this_localVariableDeclarationStatement_1= rulelocalVariableDeclarationStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBlockStatementAccess().getLocalVariableDeclarationStatementParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement13073);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7125:1: entryRulelocalVariableDeclarationStatement returns [EObject current=null] : iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF ;
    public final EObject entryRulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclarationStatement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7126:2: (iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7127:2: iv_rulelocalVariableDeclarationStatement= rulelocalVariableDeclarationStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLocalVariableDeclarationStatementRule(), currentNode); 
            pushFollow(FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement13108);
            iv_rulelocalVariableDeclarationStatement=rulelocalVariableDeclarationStatement();
            _fsp--;

             current =iv_rulelocalVariableDeclarationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement13118); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7134:1: rulelocalVariableDeclarationStatement returns [EObject current=null] : (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' ) ;
    public final EObject rulelocalVariableDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject this_localVariableDeclaration_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7139:6: ( (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7140:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7140:1: (this_localVariableDeclaration_0= rulelocalVariableDeclaration ';' )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7141:5: this_localVariableDeclaration_0= rulelocalVariableDeclaration ';'
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLocalVariableDeclarationStatementAccess().getLocalVariableDeclarationParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement13165);
            this_localVariableDeclaration_0=rulelocalVariableDeclaration();
            _fsp--;

             
                    current = this_localVariableDeclaration_0; 
                    currentNode = currentNode.getParent();
                
            match(input,15,FOLLOW_15_in_rulelocalVariableDeclarationStatement13174); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7161:1: entryRulelocalVariableDeclaration returns [EObject current=null] : iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF ;
    public final EObject entryRulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelocalVariableDeclaration = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7162:2: (iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7163:2: iv_rulelocalVariableDeclaration= rulelocalVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLocalVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration13210);
            iv_rulelocalVariableDeclaration=rulelocalVariableDeclaration();
            _fsp--;

             current =iv_rulelocalVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRulelocalVariableDeclaration13220); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7170:1: rulelocalVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) ;
    public final EObject rulelocalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_dec_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7175:6: ( ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7176:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7176:1: ( ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7176:2: ( (lv_type_0_0= ruleattributeType ) ) ( (lv_dec_1_0= rulevariableDeclarators ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7176:2: ( (lv_type_0_0= ruleattributeType ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7177:1: (lv_type_0_0= ruleattributeType )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7177:1: (lv_type_0_0= ruleattributeType )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7178:3: lv_type_0_0= ruleattributeType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getTypeAttributeTypeParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration13266);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7200:2: ( (lv_dec_1_0= rulevariableDeclarators ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7201:1: (lv_dec_1_0= rulevariableDeclarators )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7201:1: (lv_dec_1_0= rulevariableDeclarators )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7202:3: lv_dec_1_0= rulevariableDeclarators
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLocalVariableDeclarationAccess().getDecVariableDeclaratorsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration13287);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7232:1: entryRulevariableDeclarators returns [EObject current=null] : iv_rulevariableDeclarators= rulevariableDeclarators EOF ;
    public final EObject entryRulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarators = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7233:2: (iv_rulevariableDeclarators= rulevariableDeclarators EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7234:2: iv_rulevariableDeclarators= rulevariableDeclarators EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclaratorsRule(), currentNode); 
            pushFollow(FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators13323);
            iv_rulevariableDeclarators=rulevariableDeclarators();
            _fsp--;

             current =iv_rulevariableDeclarators; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarators13333); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7241:1: rulevariableDeclarators returns [EObject current=null] : ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) ;
    public final EObject rulevariableDeclarators() throws RecognitionException {
        EObject current = null;

        EObject lv_vd_0_0 = null;

        EObject lv_vd_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7246:6: ( ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7247:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7247:1: ( ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7247:2: ( (lv_vd_0_0= rulevariableDeclarator ) ) ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7247:2: ( (lv_vd_0_0= rulevariableDeclarator ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7248:1: (lv_vd_0_0= rulevariableDeclarator )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7248:1: (lv_vd_0_0= rulevariableDeclarator )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7249:3: lv_vd_0_0= rulevariableDeclarator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13379);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7271:2: ( ',' ( (lv_vd_2_0= rulevariableDeclarator ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==28) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7271:4: ',' ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    {
            	    match(input,28,FOLLOW_28_in_rulevariableDeclarators13390); 

            	            createLeafNode(grammarAccess.getVariableDeclaratorsAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7275:1: ( (lv_vd_2_0= rulevariableDeclarator ) )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7276:1: (lv_vd_2_0= rulevariableDeclarator )
            	    {
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7276:1: (lv_vd_2_0= rulevariableDeclarator )
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7277:3: lv_vd_2_0= rulevariableDeclarator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorsAccess().getVdVariableDeclaratorParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13411);
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
            	    break loop109;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7307:1: entryRulevariableDeclarator returns [EObject current=null] : iv_rulevariableDeclarator= rulevariableDeclarator EOF ;
    public final EObject entryRulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDeclarator = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7308:2: (iv_rulevariableDeclarator= rulevariableDeclarator EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7309:2: iv_rulevariableDeclarator= rulevariableDeclarator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclaratorRule(), currentNode); 
            pushFollow(FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator13449);
            iv_rulevariableDeclarator=rulevariableDeclarator();
            _fsp--;

             current =iv_rulevariableDeclarator; 
            match(input,EOF,FOLLOW_EOF_in_entryRulevariableDeclarator13459); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7316:1: rulevariableDeclarator returns [EObject current=null] : ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) ;
    public final EObject rulevariableDeclarator() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7321:6: ( ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7322:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7322:1: ( ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7322:2: ( (lv_name_0_0= ruleextendedID ) ) ( '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7322:2: ( (lv_name_0_0= ruleextendedID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7323:1: (lv_name_0_0= ruleextendedID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7323:1: (lv_name_0_0= ruleextendedID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7324:3: lv_name_0_0= ruleextendedID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorAccess().getNameExtendedIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleextendedID_in_rulevariableDeclarator13505);
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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7346:2: ( '=' ( (lv_exp_2_0= ruleexpression ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==53) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7346:4: '=' ( (lv_exp_2_0= ruleexpression ) )
                    {
                    match(input,53,FOLLOW_53_in_rulevariableDeclarator13516); 

                            createLeafNode(grammarAccess.getVariableDeclaratorAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7350:1: ( (lv_exp_2_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7351:1: (lv_exp_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7351:1: (lv_exp_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7352:3: lv_exp_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclaratorAccess().getExpExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_rulevariableDeclarator13537);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7382:1: entryRulestatement returns [EObject current=null] : iv_rulestatement= rulestatement EOF ;
    public final EObject entryRulestatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestatement = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7383:2: (iv_rulestatement= rulestatement EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7384:2: iv_rulestatement= rulestatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_rulestatement_in_entryRulestatement13575);
            iv_rulestatement=rulestatement();
            _fsp--;

             current =iv_rulestatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulestatement13585); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7391:1: rulestatement returns [EObject current=null] : (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) ) ;
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
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7396:6: ( (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7397:1: (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7397:1: (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )
            int alt113=9;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt113=1;
                }
                break;
            case 114:
                {
                alt113=2;
                }
                break;
            case 116:
                {
                alt113=3;
                }
                break;
            case 117:
                {
                alt113=4;
                }
                break;
            case 118:
                {
                alt113=5;
                }
                break;
            case 15:
                {
                alt113=6;
                }
                break;
            case 119:
                {
                alt113=7;
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
                alt113=8;
                }
                break;
            case 120:
                {
                alt113=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("7397:1: (this_block_0= ruleblock | ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? ) | ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) ) | ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) ) | ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' ) | ';' | ( 'break' ';' ) | (this_expression_20= ruleexpression ';' ) | ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) ) )", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7398:5: this_block_0= ruleblock
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleblock_in_rulestatement13632);
                    this_block_0=ruleblock();
                    _fsp--;

                     
                            current = this_block_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7407:6: ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7407:6: ( 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )? )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7407:8: 'if' ( (lv_condition_2_0= ruleparExpression ) ) ( (lv_state1_3_0= rulestatement ) ) ( 'else' ( (lv_state2_5_0= rulestatement ) ) )?
                    {
                    match(input,114,FOLLOW_114_in_rulestatement13648); 

                            createLeafNode(grammarAccess.getStatementAccess().getIfKeyword_1_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7411:1: ( (lv_condition_2_0= ruleparExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7412:1: (lv_condition_2_0= ruleparExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7412:1: (lv_condition_2_0= ruleparExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7413:3: lv_condition_2_0= ruleparExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getConditionParExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleparExpression_in_rulestatement13669);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7435:2: ( (lv_state1_3_0= rulestatement ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7436:1: (lv_state1_3_0= rulestatement )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7436:1: (lv_state1_3_0= rulestatement )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7437:3: lv_state1_3_0= rulestatement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getState1StatementParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement13690);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7459:2: ( 'else' ( (lv_state2_5_0= rulestatement ) ) )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==115) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7459:4: 'else' ( (lv_state2_5_0= rulestatement ) )
                            {
                            match(input,115,FOLLOW_115_in_rulestatement13701); 

                                    createLeafNode(grammarAccess.getStatementAccess().getElseKeyword_1_3_0(), null); 
                                
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7463:1: ( (lv_state2_5_0= rulestatement ) )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7464:1: (lv_state2_5_0= rulestatement )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7464:1: (lv_state2_5_0= rulestatement )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7465:3: lv_state2_5_0= rulestatement
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getState2StatementParserRuleCall_1_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_rulestatement_in_rulestatement13722);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7488:6: ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7488:6: ( 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7488:8: 'for' '(' ( (lv_control_8_0= ruleforControl ) ) ')' ( (lv_state_10_0= rulestatement ) )
                    {
                    match(input,116,FOLLOW_116_in_rulestatement13742); 

                            createLeafNode(grammarAccess.getStatementAccess().getForKeyword_2_0(), null); 
                        
                    match(input,71,FOLLOW_71_in_rulestatement13752); 

                            createLeafNode(grammarAccess.getStatementAccess().getLeftParenthesisKeyword_2_1(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7496:1: ( (lv_control_8_0= ruleforControl ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7497:1: (lv_control_8_0= ruleforControl )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7497:1: (lv_control_8_0= ruleforControl )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7498:3: lv_control_8_0= ruleforControl
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getControlForControlParserRuleCall_2_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleforControl_in_rulestatement13773);
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

                    match(input,72,FOLLOW_72_in_rulestatement13783); 

                            createLeafNode(grammarAccess.getStatementAccess().getRightParenthesisKeyword_2_3(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7524:1: ( (lv_state_10_0= rulestatement ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7525:1: (lv_state_10_0= rulestatement )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7525:1: (lv_state_10_0= rulestatement )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7526:3: lv_state_10_0= rulestatement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getStateStatementParserRuleCall_2_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement13804);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7549:6: ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7549:6: ( 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7549:8: 'while' ( (lv_condition_12_0= ruleparExpression ) ) ( (lv_state_13_0= rulestatement ) )
                    {
                    match(input,117,FOLLOW_117_in_rulestatement13822); 

                            createLeafNode(grammarAccess.getStatementAccess().getWhileKeyword_3_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7553:1: ( (lv_condition_12_0= ruleparExpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7554:1: (lv_condition_12_0= ruleparExpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7554:1: (lv_condition_12_0= ruleparExpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7555:3: lv_condition_12_0= ruleparExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getConditionParExpressionParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleparExpression_in_rulestatement13843);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7577:2: ( (lv_state_13_0= rulestatement ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7578:1: (lv_state_13_0= rulestatement )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7578:1: (lv_state_13_0= rulestatement )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7579:3: lv_state_13_0= rulestatement
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getStateStatementParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulestatement_in_rulestatement13864);
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
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7602:6: ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7602:6: ( 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7602:8: 'return' ( (lv_retVal_15_0= ruleexpression ) )? ';'
                    {
                    match(input,118,FOLLOW_118_in_rulestatement13882); 

                            createLeafNode(grammarAccess.getStatementAccess().getReturnKeyword_4_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7606:1: ( (lv_retVal_15_0= ruleexpression ) )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( ((LA112_0>=RULE_STRING && LA112_0<=RULE_INT)||LA112_0==41||LA112_0==71||(LA112_0>=99 && LA112_0<=100)||(LA112_0>=102 && LA112_0<=108)) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7607:1: (lv_retVal_15_0= ruleexpression )
                            {
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7607:1: (lv_retVal_15_0= ruleexpression )
                            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7608:3: lv_retVal_15_0= ruleexpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getRetValExpressionParserRuleCall_4_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleexpression_in_rulestatement13903);
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

                    match(input,15,FOLLOW_15_in_rulestatement13914); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_4_2(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7635:7: ';'
                    {
                    match(input,15,FOLLOW_15_in_rulestatement13931); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7640:6: ( 'break' ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7640:6: ( 'break' ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7640:8: 'break' ';'
                    {
                    match(input,119,FOLLOW_119_in_rulestatement13948); 

                            createLeafNode(grammarAccess.getStatementAccess().getBreakKeyword_6_0(), null); 
                        
                    match(input,15,FOLLOW_15_in_rulestatement13958); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_6_1(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7649:6: (this_expression_20= ruleexpression ';' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7649:6: (this_expression_20= ruleexpression ';' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7650:5: this_expression_20= ruleexpression ';'
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getExpressionParserRuleCall_7_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleexpression_in_rulestatement13988);
                    this_expression_20=ruleexpression();
                    _fsp--;

                     
                            current = this_expression_20; 
                            currentNode = currentNode.getParent();
                        
                    match(input,15,FOLLOW_15_in_rulestatement13997); 

                            createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_7_1(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7663:6: ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7663:6: ( 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7663:8: 'try' ( (lv_tryBlock_23_0= ruleblock ) ) 'catch' ( (lv_catchBlock_25_0= ruleblock ) )
                    {
                    match(input,120,FOLLOW_120_in_rulestatement14015); 

                            createLeafNode(grammarAccess.getStatementAccess().getTryKeyword_8_0(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7667:1: ( (lv_tryBlock_23_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7668:1: (lv_tryBlock_23_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7668:1: (lv_tryBlock_23_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7669:3: lv_tryBlock_23_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getTryBlockBlockParserRuleCall_8_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_rulestatement14036);
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

                    match(input,121,FOLLOW_121_in_rulestatement14046); 

                            createLeafNode(grammarAccess.getStatementAccess().getCatchKeyword_8_2(), null); 
                        
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7695:1: ( (lv_catchBlock_25_0= ruleblock ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7696:1: (lv_catchBlock_25_0= ruleblock )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7696:1: (lv_catchBlock_25_0= ruleblock )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7697:3: lv_catchBlock_25_0= ruleblock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStatementAccess().getCatchBlockBlockParserRuleCall_8_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleblock_in_rulestatement14067);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7727:1: entryRuleforControl returns [EObject current=null] : iv_ruleforControl= ruleforControl EOF ;
    public final EObject entryRuleforControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforControl = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7728:2: (iv_ruleforControl= ruleforControl EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7729:2: iv_ruleforControl= ruleforControl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForControlRule(), currentNode); 
            pushFollow(FOLLOW_ruleforControl_in_entryRuleforControl14104);
            iv_ruleforControl=ruleforControl();
            _fsp--;

             current =iv_ruleforControl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforControl14114); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7736:1: ruleforControl returns [EObject current=null] : ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? ) ;
    public final EObject ruleforControl() throws RecognitionException {
        EObject current = null;

        EObject lv_init_0_0 = null;

        EObject lv_condition_2_0 = null;

        EObject lv_update_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7741:6: ( ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7742:1: ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7742:1: ( ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )? )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7742:2: ( (lv_init_0_0= ruleforInit ) )? ';' ( (lv_condition_2_0= ruleexpression ) )? ';' ( (lv_update_4_0= ruleforUpdate ) )?
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7742:2: ( (lv_init_0_0= ruleforInit ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( ((LA114_0>=RULE_STRING && LA114_0<=RULE_INT)||LA114_0==29||LA114_0==33||LA114_0==36||LA114_0==41||(LA114_0>=54 && LA114_0<=61)||LA114_0==71||(LA114_0>=99 && LA114_0<=100)||(LA114_0>=102 && LA114_0<=108)) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7743:1: (lv_init_0_0= ruleforInit )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7743:1: (lv_init_0_0= ruleforInit )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7744:3: lv_init_0_0= ruleforInit
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForControlAccess().getInitForInitParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleforInit_in_ruleforControl14160);
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

            match(input,15,FOLLOW_15_in_ruleforControl14171); 

                    createLeafNode(grammarAccess.getForControlAccess().getSemicolonKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7770:1: ( (lv_condition_2_0= ruleexpression ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( ((LA115_0>=RULE_STRING && LA115_0<=RULE_INT)||LA115_0==41||LA115_0==71||(LA115_0>=99 && LA115_0<=100)||(LA115_0>=102 && LA115_0<=108)) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7771:1: (lv_condition_2_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7771:1: (lv_condition_2_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7772:3: lv_condition_2_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForControlAccess().getConditionExpressionParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforControl14192);
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

            match(input,15,FOLLOW_15_in_ruleforControl14203); 

                    createLeafNode(grammarAccess.getForControlAccess().getSemicolonKeyword_3(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7798:1: ( (lv_update_4_0= ruleforUpdate ) )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( ((LA116_0>=RULE_STRING && LA116_0<=RULE_INT)||LA116_0==41||LA116_0==71||(LA116_0>=99 && LA116_0<=100)||(LA116_0>=102 && LA116_0<=108)) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7799:1: (lv_update_4_0= ruleforUpdate )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7799:1: (lv_update_4_0= ruleforUpdate )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7800:3: lv_update_4_0= ruleforUpdate
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForControlAccess().getUpdateForUpdateParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleforUpdate_in_ruleforControl14224);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7830:1: entryRuleforInit returns [EObject current=null] : iv_ruleforInit= ruleforInit EOF ;
    public final EObject entryRuleforInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforInit = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7831:2: (iv_ruleforInit= ruleforInit EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7832:2: iv_ruleforInit= ruleforInit EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForInitRule(), currentNode); 
            pushFollow(FOLLOW_ruleforInit_in_entryRuleforInit14261);
            iv_ruleforInit=ruleforInit();
            _fsp--;

             current =iv_ruleforInit; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforInit14271); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7839:1: ruleforInit returns [EObject current=null] : ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) ;
    public final EObject ruleforInit() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;

        EObject this_localVariableDeclaration_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7844:6: ( ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7845:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7845:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( ((LA118_0>=RULE_STRING && LA118_0<=RULE_INT)||LA118_0==41||LA118_0==71||(LA118_0>=99 && LA118_0<=100)||(LA118_0>=102 && LA118_0<=108)) ) {
                alt118=1;
            }
            else if ( (LA118_0==29||LA118_0==33||LA118_0==36||(LA118_0>=54 && LA118_0<=61)) ) {
                alt118=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("7845:1: ( ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* ) | this_localVariableDeclaration_3= rulelocalVariableDeclaration )", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7845:2: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7845:2: ( ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )* )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7845:3: ( (lv_expressions_0_0= ruleexpression ) ) ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7845:3: ( (lv_expressions_0_0= ruleexpression ) )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7846:1: (lv_expressions_0_0= ruleexpression )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7846:1: (lv_expressions_0_0= ruleexpression )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7847:3: lv_expressions_0_0= ruleexpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleexpression_in_ruleforInit14318);
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

                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7869:2: ( ',' ( (lv_expressions_2_0= ruleexpression ) ) )*
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( (LA117_0==28) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7869:4: ',' ( (lv_expressions_2_0= ruleexpression ) )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleforInit14329); 

                    	            createLeafNode(grammarAccess.getForInitAccess().getCommaKeyword_0_1_0(), null); 
                    	        
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7873:1: ( (lv_expressions_2_0= ruleexpression ) )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7874:1: (lv_expressions_2_0= ruleexpression )
                    	    {
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7874:1: (lv_expressions_2_0= ruleexpression )
                    	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7875:3: lv_expressions_2_0= ruleexpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getForInitAccess().getExpressionsExpressionParserRuleCall_0_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleexpression_in_ruleforInit14350);
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
                    	    break loop117;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7899:5: this_localVariableDeclaration_3= rulelocalVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getForInitAccess().getLocalVariableDeclarationParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_rulelocalVariableDeclaration_in_ruleforInit14381);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7915:1: entryRuleforUpdate returns [EObject current=null] : iv_ruleforUpdate= ruleforUpdate EOF ;
    public final EObject entryRuleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleforUpdate = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7916:2: (iv_ruleforUpdate= ruleforUpdate EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7917:2: iv_ruleforUpdate= ruleforUpdate EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForUpdateRule(), currentNode); 
            pushFollow(FOLLOW_ruleforUpdate_in_entryRuleforUpdate14416);
            iv_ruleforUpdate=ruleforUpdate();
            _fsp--;

             current =iv_ruleforUpdate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleforUpdate14426); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7924:1: ruleforUpdate returns [EObject current=null] : this_expressionList_0= ruleexpressionList ;
    public final EObject ruleforUpdate() throws RecognitionException {
        EObject current = null;

        EObject this_expressionList_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7929:6: (this_expressionList_0= ruleexpressionList )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7931:5: this_expressionList_0= ruleexpressionList
            {
             
                    currentNode=createCompositeNode(grammarAccess.getForUpdateAccess().getExpressionListParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleexpressionList_in_ruleforUpdate14472);
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7947:1: entryRuleattributeType returns [String current=null] : iv_ruleattributeType= ruleattributeType EOF ;
    public final String entryRuleattributeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleattributeType = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7948:2: (iv_ruleattributeType= ruleattributeType EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7949:2: iv_ruleattributeType= ruleattributeType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleattributeType_in_entryRuleattributeType14507);
            iv_ruleattributeType=ruleattributeType();
            _fsp--;

             current =iv_ruleattributeType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleattributeType14518); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7956:1: ruleattributeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) ;
    public final AntlrDatatypeRuleToken ruleattributeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7961:6: ( (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7962:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7962:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )
            int alt119=11;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt119=1;
                }
                break;
            case 55:
                {
                alt119=2;
                }
                break;
            case 56:
                {
                alt119=3;
                }
                break;
            case 36:
                {
                alt119=4;
                }
                break;
            case 57:
                {
                alt119=5;
                }
                break;
            case 58:
                {
                alt119=6;
                }
                break;
            case 33:
                {
                alt119=7;
                }
                break;
            case 59:
                {
                alt119=8;
                }
                break;
            case 29:
                {
                alt119=9;
                }
                break;
            case 60:
                {
                alt119=10;
                }
                break;
            case 61:
                {
                alt119=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("7962:1: (kw= 'Date' | kw= 'Time' | kw= 'Double' | kw= 'double' | kw= 'Integer' | kw= 'integer' | kw= 'int' | kw= 'Boolean' | kw= 'boolean' | kw= 'String' | kw= 'string' )", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7963:2: kw= 'Date'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleattributeType14556); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getDateKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7970:2: kw= 'Time'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleattributeType14575); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getTimeKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7977:2: kw= 'Double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleattributeType14594); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getDoubleKeyword_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7984:2: kw= 'double'
                    {
                    kw=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_ruleattributeType14613); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getDoubleKeyword_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7991:2: kw= 'Integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_ruleattributeType14632); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getIntegerKeyword_4(), null); 
                        

                    }
                    break;
                case 6 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:7998:2: kw= 'integer'
                    {
                    kw=(Token)input.LT(1);
                    match(input,58,FOLLOW_58_in_ruleattributeType14651); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getIntegerKeyword_5(), null); 
                        

                    }
                    break;
                case 7 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8005:2: kw= 'int'
                    {
                    kw=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleattributeType14670); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getIntKeyword_6(), null); 
                        

                    }
                    break;
                case 8 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8012:2: kw= 'Boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,59,FOLLOW_59_in_ruleattributeType14689); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getBooleanKeyword_7(), null); 
                        

                    }
                    break;
                case 9 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8019:2: kw= 'boolean'
                    {
                    kw=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleattributeType14708); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getBooleanKeyword_8(), null); 
                        

                    }
                    break;
                case 10 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8026:2: kw= 'String'
                    {
                    kw=(Token)input.LT(1);
                    match(input,60,FOLLOW_60_in_ruleattributeType14727); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAttributeTypeAccess().getStringKeyword_9(), null); 
                        

                    }
                    break;
                case 11 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8033:2: kw= 'string'
                    {
                    kw=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_ruleattributeType14746); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8046:1: entryRulephpFunction returns [EObject current=null] : iv_rulephpFunction= rulephpFunction EOF ;
    public final EObject entryRulephpFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulephpFunction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8047:2: (iv_rulephpFunction= rulephpFunction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8048:2: iv_rulephpFunction= rulephpFunction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPhpFunctionRule(), currentNode); 
            pushFollow(FOLLOW_rulephpFunction_in_entryRulephpFunction14786);
            iv_rulephpFunction=rulephpFunction();
            _fsp--;

             current =iv_rulephpFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRulephpFunction14796); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8055:1: rulephpFunction returns [EObject current=null] : ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) ) ;
    public final EObject rulephpFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8060:6: ( ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8061:1: ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8061:1: ( 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8061:3: 'public' 'function' ( (lv_name_2_0= RULE_ID ) ) ( ( RULE_ID ) )
            {
            match(input,110,FOLLOW_110_in_rulephpFunction14831); 

                    createLeafNode(grammarAccess.getPhpFunctionAccess().getPublicKeyword_0(), null); 
                
            match(input,122,FOLLOW_122_in_rulephpFunction14841); 

                    createLeafNode(grammarAccess.getPhpFunctionAccess().getFunctionKeyword_1(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8069:1: ( (lv_name_2_0= RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8070:1: (lv_name_2_0= RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8070:1: (lv_name_2_0= RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8071:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulephpFunction14858); 

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

            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8093:2: ( ( RULE_ID ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8094:1: ( RULE_ID )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8094:1: ( RULE_ID )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8095:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPhpFunctionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulephpFunction14881); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8117:1: entryRulerubyFunction returns [String current=null] : iv_rulerubyFunction= rulerubyFunction EOF ;
    public final String entryRulerubyFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerubyFunction = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8118:2: (iv_rulerubyFunction= rulerubyFunction EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8119:2: iv_rulerubyFunction= rulerubyFunction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRubyFunctionRule(), currentNode); 
            pushFollow(FOLLOW_rulerubyFunction_in_entryRulerubyFunction14920);
            iv_rulerubyFunction=rulerubyFunction();
            _fsp--;

             current =iv_rulerubyFunction.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerubyFunction14931); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8126:1: rulerubyFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_RUBY_FUNCTION_0= RULE_RUBY_FUNCTION ;
    public final AntlrDatatypeRuleToken rulerubyFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RUBY_FUNCTION_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8131:6: (this_RUBY_FUNCTION_0= RULE_RUBY_FUNCTION )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8132:5: this_RUBY_FUNCTION_0= RULE_RUBY_FUNCTION
            {
            this_RUBY_FUNCTION_0=(Token)input.LT(1);
            match(input,RULE_RUBY_FUNCTION,FOLLOW_RULE_RUBY_FUNCTION_in_rulerubyFunction14970); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8147:1: entryRuleextendedID returns [String current=null] : iv_ruleextendedID= ruleextendedID EOF ;
    public final String entryRuleextendedID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleextendedID = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8148:2: (iv_ruleextendedID= ruleextendedID EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8149:2: iv_ruleextendedID= ruleextendedID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExtendedIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleextendedID_in_entryRuleextendedID15015);
            iv_ruleextendedID=ruleextendedID();
            _fsp--;

             current =iv_ruleextendedID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleextendedID15026); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8156:1: ruleextendedID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleextendedID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8161:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8162:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8162:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8162:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID15066); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8169:1: (kw= '.' this_ID_2= RULE_ID )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==123) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8170:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,123,FOLLOW_123_in_ruleextendedID15085); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getExtendedIDAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleextendedID15100); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getExtendedIDAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop120;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8190:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8191:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8192:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDOUBLERule(), currentNode); 
            pushFollow(FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE15148);
            iv_ruleDOUBLE=ruleDOUBLE();
            _fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOUBLE15159); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8199:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8204:6: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8205:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8205:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8205:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE15199); 

            		current.merge(this_INT_0);
                
             
                createLeafNode(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,123,FOLLOW_123_in_ruleDOUBLE15217); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1(), null); 
                
            this_INT_2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDOUBLE15232); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8233:1: entryRulefileID returns [String current=null] : iv_rulefileID= rulefileID EOF ;
    public final String entryRulefileID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulefileID = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8234:2: (iv_rulefileID= rulefileID EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8235:2: iv_rulefileID= rulefileID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFileIDRule(), currentNode); 
            pushFollow(FOLLOW_rulefileID_in_entryRulefileID15278);
            iv_rulefileID=rulefileID();
            _fsp--;

             current =iv_rulefileID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulefileID15289); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8242:1: rulefileID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* ) ;
    public final AntlrDatatypeRuleToken rulefileID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CHARS_0 = null;

        AntlrDatatypeRuleToken this_CHARS_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8247:6: ( (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8248:1: (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8248:1: (this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )* )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8249:5: this_CHARS_0= ruleCHARS (this_CHARS_1= ruleCHARS )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getFileIDAccess().getCHARSParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCHARS_in_rulefileID15336);
            this_CHARS_0=ruleCHARS();
            _fsp--;


            		current.merge(this_CHARS_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8259:1: (this_CHARS_1= ruleCHARS )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( ((LA121_0>=RULE_ID && LA121_0<=RULE_INT)) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8260:5: this_CHARS_1= ruleCHARS
            	    {
            	     
            	            currentNode=createCompositeNode(grammarAccess.getFileIDAccess().getCHARSParserRuleCall_1(), currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleCHARS_in_rulefileID15364);
            	    this_CHARS_1=ruleCHARS();
            	    _fsp--;


            	    		current.merge(this_CHARS_1);
            	        
            	     
            	            currentNode = currentNode.getParent();
            	        

            	    }
            	    break;

            	default :
            	    break loop121;
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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8278:1: entryRuleCHARS returns [String current=null] : iv_ruleCHARS= ruleCHARS EOF ;
    public final String entryRuleCHARS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCHARS = null;


        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8279:2: (iv_ruleCHARS= ruleCHARS EOF )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8280:2: iv_ruleCHARS= ruleCHARS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCHARSRule(), currentNode); 
            pushFollow(FOLLOW_ruleCHARS_in_entryRuleCHARS15412);
            iv_ruleCHARS=ruleCHARS();
            _fsp--;

             current =iv_ruleCHARS.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCHARS15423); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8287:1: ruleCHARS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleCHARS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_extendedID_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8292:6: ( (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8293:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8293:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==RULE_ID) ) {
                alt122=1;
            }
            else if ( (LA122_0==RULE_INT) ) {
                alt122=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("8293:1: (this_extendedID_0= ruleextendedID | this_INT_1= RULE_INT )", 122, 0, input);

                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8294:5: this_extendedID_0= ruleextendedID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCHARSAccess().getExtendedIDParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleextendedID_in_ruleCHARS15470);
                    this_extendedID_0=ruleextendedID();
                    _fsp--;


                    		current.merge(this_extendedID_0);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8305:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCHARS15496); 

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
    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8320:1: ruleModifier returns [Enumerator current=null] : ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) ) ;
    public final Enumerator ruleModifier() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8324:6: ( ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) ) )
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8325:1: ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) )
            {
            // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8325:1: ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) )
            int alt123=5;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt123=1;
                }
                break;
            case 125:
                {
                alt123=2;
                }
                break;
            case 126:
                {
                alt123=3;
                }
                break;
            case 127:
                {
                alt123=4;
                }
                break;
            case 128:
                {
                alt123=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("8325:1: ( ( 'immutable' ) | ( 'settable' ) | ( 'internal' ) | ( 'defaulted' ) | ( 'const' ) )", 123, 0, input);

                throw nvae;
            }

            switch (alt123) {
                case 1 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8325:2: ( 'immutable' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8325:2: ( 'immutable' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8325:4: 'immutable'
                    {
                    match(input,124,FOLLOW_124_in_ruleModifier15553); 

                            current = grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getIMMUTABLEEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8331:6: ( 'settable' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8331:6: ( 'settable' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8331:8: 'settable'
                    {
                    match(input,125,FOLLOW_125_in_ruleModifier15568); 

                            current = grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getSETTABLEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8337:6: ( 'internal' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8337:6: ( 'internal' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8337:8: 'internal'
                    {
                    match(input,126,FOLLOW_126_in_ruleModifier15583); 

                            current = grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getINTERNALEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8343:6: ( 'defaulted' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8343:6: ( 'defaulted' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8343:8: 'defaulted'
                    {
                    match(input,127,FOLLOW_127_in_ruleModifier15598); 

                            current = grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierAccess().getDEFAULTEDEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8349:6: ( 'const' )
                    {
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8349:6: ( 'const' )
                    // ../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g:8349:8: 'const'
                    {
                    match(input,128,FOLLOW_128_in_ruleModifier15613); 

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
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA99 dfa99 = new DFA99(this);
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
    static final String DFA29_eotS =
        "\20\uffff";
    static final String DFA29_eofS =
        "\20\uffff";
    static final String DFA29_minS =
        "\1\4\2\uffff\3\5\1\uffff\1\5\1\uffff\1\6\1\5\2\uffff\2\5\1\17";
    static final String DFA29_maxS =
        "\1\u0080\2\uffff\2\55\1\173\1\uffff\1\173\1\uffff\1\56\1\5\2\uffff"+
        "\2\53\1\173";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\5\1\uffff\1\6\2\uffff\1\4\1\3\3\uffff";
    static final String DFA29_specialS =
        "\20\uffff}>";
    static final String[] DFA29_transitionS = {
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "1666:1: (this_UmpleClass_0= ruleUmpleClass | this_Depend_1= ruleDepend | this_singleAssociationEnd_2= rulesingleAssociationEnd | this_StateMachine_3= ruleStateMachine | this_UmpleAttribute_4= ruleUmpleAttribute | this_InlineAssociation_5= ruleInlineAssociation )";
        }
    }
    static final String DFA53_eotS =
        "\13\uffff";
    static final String DFA53_eofS =
        "\13\uffff";
    static final String DFA53_minS =
        "\1\5\1\21\1\5\1\uffff\1\5\1\21\1\uffff\1\21\1\5\1\uffff\1\21";
    static final String DFA53_maxS =
        "\1\5\1\173\1\5\1\uffff\1\123\1\173\1\uffff\1\173\1\5\1\uffff\1\173";
    static final String DFA53_acceptS =
        "\3\uffff\1\3\2\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA53_specialS =
        "\13\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\1",
            "\1\4\60\uffff\1\3\70\uffff\1\2",
            "\1\5",
            "",
            "\1\7\14\uffff\1\6\60\uffff\3\6\14\uffff\2\6",
            "\1\4\60\uffff\1\3\70\uffff\1\2",
            "",
            "\1\6\1\11\11\uffff\1\11\136\uffff\1\10",
            "\1\12",
            "",
            "\1\6\1\11\11\uffff\1\11\136\uffff\1\10"
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "3094:1: (this_ENUM_0= ruleENUM | this_InlineStateMachine_1= ruleInlineStateMachine | this_ReferencedStateMachine_2= ruleReferencedStateMachine )";
        }
    }
    static final String DFA63_eotS =
        "\11\uffff";
    static final String DFA63_eofS =
        "\11\uffff";
    static final String DFA63_minS =
        "\1\4\1\uffff\1\17\4\uffff\1\5\1\17";
    static final String DFA63_maxS =
        "\1\154\1\uffff\1\173\4\uffff\1\5\1\173";
    static final String DFA63_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\2\uffff";
    static final String DFA63_specialS =
        "\11\uffff}>";
    static final String[] DFA63_transitionS = {
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

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "3521:1: (this_Transition_0= ruleTransition | this_EntryOrExitAction_1= ruleEntryOrExitAction | (this_Activity_2= ruleActivity ( '->' ruleextendedID ';' )? ) | this_State_6= ruleState | ( ( (lv_expression_7_0= ruleexpression ) ) ';' ) )";
        }
    }
    static final String DFA99_eotS =
        "\16\uffff";
    static final String DFA99_eofS =
        "\1\uffff\1\11\1\uffff\1\14\11\uffff\1\14";
    static final String DFA99_minS =
        "\1\4\1\16\1\uffff\1\16\6\uffff\1\5\2\uffff\1\16";
    static final String DFA99_maxS =
        "\1\154\1\173\1\uffff\1\173\6\uffff\1\5\2\uffff\1\173";
    static final String DFA99_acceptS =
        "\2\uffff\1\3\1\uffff\1\6\1\7\1\10\1\11\1\2\1\1\1\uffff\1\5\1\4\1"+
        "\uffff";
    static final String DFA99_specialS =
        "\16\uffff}>";
    static final String[] DFA99_transitionS = {
            "\1\2\1\3\1\1\142\uffff\1\4\1\5\1\6\1\7",
            "\2\11\14\uffff\1\11\14\uffff\1\11\4\uffff\1\11\6\uffff\1\11"+
            "\22\uffff\1\11\1\uffff\1\11\14\uffff\5\11\1\uffff\12\11\24\uffff"+
            "\1\10",
            "",
            "\2\14\14\uffff\1\14\14\uffff\1\14\4\uffff\1\14\6\uffff\1\14"+
            "\21\uffff\1\13\1\14\1\uffff\1\14\13\uffff\1\13\5\14\1\uffff"+
            "\12\14\24\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "",
            "",
            "\2\14\14\uffff\1\14\14\uffff\1\14\4\uffff\1\14\6\uffff\1\14"+
            "\21\uffff\1\13\1\14\1\uffff\1\14\13\uffff\1\13\5\14\1\uffff"+
            "\12\14\24\uffff\1\12"
    };

    static final short[] DFA99_eot = DFA.unpackEncodedString(DFA99_eotS);
    static final short[] DFA99_eof = DFA.unpackEncodedString(DFA99_eofS);
    static final char[] DFA99_min = DFA.unpackEncodedStringToUnsignedChars(DFA99_minS);
    static final char[] DFA99_max = DFA.unpackEncodedStringToUnsignedChars(DFA99_maxS);
    static final short[] DFA99_accept = DFA.unpackEncodedString(DFA99_acceptS);
    static final short[] DFA99_special = DFA.unpackEncodedString(DFA99_specialS);
    static final short[][] DFA99_transition;

    static {
        int numStates = DFA99_transitionS.length;
        DFA99_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA99_transition[i] = DFA.unpackEncodedString(DFA99_transitionS[i]);
        }
    }

    class DFA99 extends DFA {

        public DFA99(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 99;
            this.eot = DFA99_eot;
            this.eof = DFA99_eof;
            this.min = DFA99_min;
            this.max = DFA99_max;
            this.accept = DFA99_accept;
            this.special = DFA99_special;
            this.transition = DFA99_transition;
        }
        public String getDescription() {
            return "6535:1: ( RULE_INT | ruleDOUBLE | RULE_STRING | ruleextendedID | this_javaFunctionCall_4= rulejavaFunctionCall | 'true' | 'TRUE' | 'false' | 'FALSE' )";
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
    public static final BitSet FOLLOW_17_in_ruleUmpleInterface2201 = new BitSet(new long[]{0x8000000008040000L,0x0001E00000000000L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleUmpleInterface2222 = new BitSet(new long[]{0x8000000008040000L,0x0001E00000000000L});
    public static final BitSet FOLLOW_27_in_ruleUmpleInterface2234 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleInterface2252 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_28_in_ruleUmpleInterface2263 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleInterface2281 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleInterface2293 = new BitSet(new long[]{0x0000000000040000L,0x0001E00000000000L});
    public static final BitSet FOLLOW_rulefunctionDeclaration_in_ruleUmpleInterface2317 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleInterface2327 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUmpleInterface2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAssociation_in_entryRuleUmpleAssociation2375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAssociation2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleUmpleAssociation2420 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleAssociation2437 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleUmpleAssociation2453 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_ruleAssociation_in_ruleUmpleAssociation2474 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUmpleAssociation2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAssociationClass_in_entryRuleUmpleAssociationClass2520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAssociationClass2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUmpleAssociationClass2565 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleAssociationClass2582 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleUmpleAssociationClass2597 = new BitSet(new long[]{0xBFCC401226040070L,0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleassociationClassContent_in_ruleUmpleAssociationClass2618 = new BitSet(new long[]{0xBFCC401226040070L,0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_18_in_ruleUmpleAssociationClass2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleassociationClassContent_in_entryRuleassociationClassContent2665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleassociationClassContent2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleClass_in_ruleassociationClassContent2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_ruleassociationClassContent2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesingleAssociationEnd_in_ruleassociationClassContent2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_ruleassociationClassContent2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttribute_in_ruleassociationClassContent2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_ruleassociationClassContent2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociation_in_entryRuleAssociation2892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociation2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation2943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2959 = new BitSet(new long[]{0x00000F0000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation2981 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_40_in_ruleAssociation2998 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_41_in_ruleAssociation3014 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_42_in_ruleAssociation3030 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_43_in_ruleAssociation3046 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleAssociation3063 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation3079 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssociation3101 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssociation3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymmetricReflexiveAssociation_in_entryRuleSymmetricReflexiveAssociation3153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSymmetricReflexiveAssociation3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleSymmetricReflexiveAssociation3204 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleSymmetricReflexiveAssociation3213 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSymmetricReflexiveAssociation3230 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSymmetricReflexiveAssociation3245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineAssociation_in_entryRuleInlineAssociation3281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineAssociation3291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation3332 = new BitSet(new long[]{0x00000F0000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3348 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_40_in_ruleInlineAssociation3365 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_41_in_ruleInlineAssociation3381 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_42_in_ruleInlineAssociation3397 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_43_in_ruleInlineAssociation3413 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_rulemultiplicity_in_ruleInlineAssociation3430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3446 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineAssociation3468 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInlineAssociation3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesingleAssociationEnd_in_entryRulesingleAssociationEnd3520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulesingleAssociationEnd3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_rulesingleAssociationEnd3571 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulesingleAssociationEnd3591 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulesingleAssociationEnd3608 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulesingleAssociationEnd3624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicity_in_entryRulemultiplicity3661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicity3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity3753 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_rulemultiplicity3771 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_rulebound_in_rulemultiplicity3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebound_in_entryRulebound3840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulebound3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulebound3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rulebound3915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingleton_in_entryRuleSingleton3955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingleton3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSingleton4008 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSingleton4031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeInjection_in_entryRuleCodeInjection4067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodeInjection4077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleCodeInjection4113 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection4134 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleCodeInjection4155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleCodeInjection4173 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCodeInjection4194 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleCodeInjection4215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttribute_in_entryRuleUmpleAttribute4252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAttribute4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleUmpleAttribute4306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleUmpleAttribute4340 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleAttribute4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUmpleAttribute4376 = new BitSet(new long[]{0x3FC0001220000020L,0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleModifier_in_ruleUmpleAttribute4411 = new BitSet(new long[]{0x3FC0001220000020L});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_ruleUmpleAttribute4435 = new BitSet(new long[]{0x0010000000000020L});
    public static final BitSet FOLLOW_52_in_ruleUmpleAttribute4453 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUmpleAttribute4493 = new BitSet(new long[]{0x0010000000000020L});
    public static final BitSet FOLLOW_52_in_ruleUmpleAttribute4511 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleUmpleAttribute4549 = new BitSet(new long[]{0x0020000000008000L});
    public static final BitSet FOLLOW_53_in_ruleUmpleAttribute4560 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_ruleUmpleAttribute4581 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleUmpleAttribute4593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmplePrimitiveType_in_entryRuleUmplePrimitiveType4631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmplePrimitiveType4642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUmplePrimitiveType4682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUmplePrimitiveType4708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUmpleAttributeType_in_entryRuleUmpleAttributeType4754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUmpleAttributeType4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUmpleAttributeType4803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUmpleAttributeType4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleUmpleAttributeType4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUmpleAttributeType4860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleUmpleAttributeType4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUmpleAttributeType4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleUmpleAttributeType4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUmpleAttributeType4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleUmpleAttributeType4955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUmpleAttributeType4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUmpleAttributeType4993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKey_in_entryRuleKey5033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKey5043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleKey5078 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleKey5097 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKey5115 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleKey5131 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKey5148 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_ruleKey5167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDepend_in_entryRuleDepend5203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDepend5213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleDepend5248 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleDepend5269 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleDepend5280 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDepend5292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachineDefinition_in_entryRuleStateMachineDefinition5328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachineDefinition5338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleStateMachineDefinition5373 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleStateMachineDefinition5394 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStateMachineDefinition5404 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateMachineDefinition5425 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_18_in_ruleStateMachineDefinition5436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateMachine_in_entryRuleStateMachine5472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateMachine5482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleENUM_in_ruleStateMachine5529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStateMachine_in_ruleStateMachine5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedStateMachine_in_ruleStateMachine5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStateMachine_in_entryRuleInlineStateMachine5618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineStateMachine5628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleInlineStateMachine5674 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInlineStateMachine5684 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_ruleState_in_ruleInlineStateMachine5705 = new BitSet(new long[]{0x0000000000040020L,0x00000000000C0038L});
    public static final BitSet FOLLOW_18_in_ruleInlineStateMachine5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedStateMachine_in_entryRuleReferencedStateMachine5752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedStateMachine5762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleReferencedStateMachine5808 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleReferencedStateMachine5818 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedStateMachine5836 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleReferencedStateMachine5846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleENUM_in_entryRuleENUM5882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleENUM5892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleENUM5938 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleENUM5948 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleENUM5969 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleENUM5980 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleENUM6001 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_ruleENUM6013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState6049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState6059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceDirective_in_ruleState6105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleState6123 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_ruleState6136 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleState6149 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleState6172 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState6182 = new BitSet(new long[]{0x0000420000040070L,0x00001FD8000C7AF8L});
    public static final BitSet FOLLOW_46_in_ruleState6194 = new BitSet(new long[]{0x0000020000000070L,0x00001FD8000C7AF8L});
    public static final BitSet FOLLOW_ruleStateEntity_in_ruleState6217 = new BitSet(new long[]{0x0000420000040070L,0x00001FD8000C7AF8L});
    public static final BitSet FOLLOW_18_in_ruleState6229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateEntity_in_entryRuleStateEntity6266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateEntity6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStateEntity6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryOrExitAction_in_ruleStateEntity6350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivity_in_ruleStateEntity6378 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleStateEntity6388 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleStateEntity6404 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStateEntity6413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStateEntity6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleStateEntity6471 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStateEntity6481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition6518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition6528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTransition6576 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000240L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleTransition6596 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleTransition6606 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransition6627 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleTransition6649 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransition6659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleTransition6689 = new BitSet(new long[]{0x0000010000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleTransition6709 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleTransition6720 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransition6741 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleTransition6763 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransition6773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition6810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedEvent_in_ruleEventDefinition6871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWaitEvent_in_ruleEventDefinition6903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDefinition6926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedEvent_in_entryRuleTimedEvent6968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimedEvent6979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleTimedEvent7017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleTimedEvent7030 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimedEvent7046 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTimedEvent7072 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleTimedEvent7091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWaitEvent_in_entryRuleWaitEvent7132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWaitEvent7143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleWaitEvent7181 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleWaitEvent7194 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleWaitEvent7210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWaitEvent7236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleWaitEvent7255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction7295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction7305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleAction7340 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleAction7361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryOrExitAction_in_entryRuleEntryOrExitAction7397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryOrExitAction7407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleEntryOrExitAction7451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_76_in_ruleEntryOrExitAction7488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleEntryOrExitAction7512 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleEntryOrExitAction7533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivity_in_entryRuleActivity7569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivity7579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleActivity7614 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_ruleActivity7635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard7671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard7681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleGuard7716 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleGuardCode_in_ruleGuard7738 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleGuard7747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardCode_in_entryRuleGuardCode7783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardCode7793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_ruleGuardCode7838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePosition_in_entryRulePosition7873 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePosition7883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_rulePosition7929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassPosition_in_rulePosition7956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassPosition_in_entryRuleClassPosition7992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassPosition8002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleClassPosition8037 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition8054 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition8076 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition8098 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClassPosition8120 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleClassPosition8135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssociationPosition_in_entryRuleAssociationPosition8171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssociationPosition8181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleAssociationPosition8216 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssociationPosition8233 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition8259 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCoordinate_in_ruleAssociationPosition8280 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssociationPosition8290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinate_in_entryRuleCoordinate8326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinate8336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate8378 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleCoordinate8393 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCoordinate8410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceDirective_in_entryRuleTraceDirective8451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTraceDirective8461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleTraceDirective8506 = new BitSet(new long[]{0x0000000000000020L,0x0000000000201800L});
    public static final BitSet FOLLOW_83_in_ruleTraceDirective8535 = new BitSet(new long[]{0x0000000000000020L,0x0000000000201800L});
    public static final BitSet FOLLOW_ruleModelElement_in_ruleTraceDirective8572 = new BitSet(new long[]{0x0000400000000002L,0x000000000F800000L});
    public static final BitSet FOLLOW_ruleConditionRHS_in_ruleTraceDirective8593 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleTraceDirective8612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceCase_in_entryRuleTraceCase8662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTraceCase8672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleTraceCase8707 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTraceCase8724 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTraceCase8739 = new BitSet(new long[]{0x0000000000040000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_ruleTraceDirective_in_ruleTraceCase8760 = new BitSet(new long[]{0x0000000000040000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleTraceCase8771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundTraceCondition_in_entryRuleCompoundTraceCondition8811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompoundTraceCondition8821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCompoundTraceCondition8862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTraceCondition_in_entryRuleSimpleTraceCondition8902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTraceCondition8912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElement_in_ruleSimpleTraceCondition8958 = new BitSet(new long[]{0x0000000000000000L,0x000000000F800000L});
    public static final BitSet FOLLOW_ruleConditionRHS_in_ruleSimpleTraceCondition8979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionRHS_in_entryRuleConditionRHS9015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionRHS9025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonOperator_in_ruleConditionRHS9071 = new BitSet(new long[]{0x0000001FE0000000L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleConditionRHS9092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement9128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElement9138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleModelElement9183 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_76_in_ruleModelElement9220 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_85_in_ruleModelElement9257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement9289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleModelElement9304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement9329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonOperator_in_entryRuleComparisonOperator9366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparisonOperator9377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleComparisonOperator9415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleComparisonOperator9434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleComparisonOperator9453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleComparisonOperator9472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleComparisonOperator9491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTraceMechanism_in_entryRuleTraceMechanism9531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTraceMechanism9541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleTraceMechanism9576 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTraceMechanism9593 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTraceMechanism9608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_entryRuleblock9644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblock9654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleblock9689 = new BitSet(new long[]{0x3FC0021220068070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_ruleblockStatement_in_ruleblock9710 = new BitSet(new long[]{0x3FC0021220068070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_18_in_ruleblock9721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_entryRuleparExpression9757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleparExpression9767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleparExpression9802 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleparExpression9824 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleparExpression9833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_entryRuleassignmentOperator9870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleassignmentOperator9881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleassignmentOperator9919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleassignmentOperator9938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleassignmentOperator9957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_entryRuleexpressionList9997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpressionList10007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList10053 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleexpressionList10064 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpressionList10085 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleexpression_in_entryRuleexpression10123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexpression10133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_ruleexpression10179 = new BitSet(new long[]{0x0020000000000002L,0x0000000060000000L});
    public static final BitSet FOLLOW_ruleassignmentOperator_in_ruleexpression10196 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleexpression10216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalExpression_in_entryRuleconditionalExpression10254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalExpression10264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_ruleconditionalExpression10310 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleconditionalExpression10321 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression10342 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleconditionalExpression10352 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleconditionalExpression10373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalOrExpression_in_entryRuleconditionalOrExpression10411 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalOrExpression10421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10467 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_ruleconditionalOrExpression10478 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_ruleconditionalOrExpression10499 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_ruleconditionalAndExpression_in_entryRuleconditionalAndExpression10537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleconditionalAndExpression10547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10593 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ruleconditionalAndExpression10604 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_ruleconditionalAndExpression10625 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_ruleequalityExpression_in_entryRuleequalityExpression10663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleequalityExpression10673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression10719 = new BitSet(new long[]{0x0000000000000002L,0x0000000402000000L});
    public static final BitSet FOLLOW_89_in_ruleequalityExpression10731 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_98_in_ruleequalityExpression10747 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_ruleequalityExpression10769 = new BitSet(new long[]{0x0000000000000002L,0x0000000402000000L});
    public static final BitSet FOLLOW_rulerelationalExpression_in_entryRulerelationalExpression10807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalExpression10817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10863 = new BitSet(new long[]{0x0000000000000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_rulerelationalOp_in_rulerelationalExpression10880 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_rulerelationalExpression10900 = new BitSet(new long[]{0x0000000000000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_rulerelationalOp_in_entryRulerelationalOp10939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalOp10950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_rulerelationalOp10988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_rulerelationalOp11007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_rulerelationalOp11026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_rulerelationalOp11045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveExpression_in_entryRuleadditiveExpression11085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleadditiveExpression11095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11141 = new BitSet(new long[]{0x0000000000000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_99_in_ruleadditiveExpression11153 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_100_in_ruleadditiveExpression11169 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_ruleadditiveExpression11191 = new BitSet(new long[]{0x0000000000000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_rulemultiplicativeExpression_in_entryRulemultiplicativeExpression11229 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicativeExpression11239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11285 = new BitSet(new long[]{0x0000400000000002L,0x0000002000000400L});
    public static final BitSet FOLLOW_46_in_rulemultiplicativeExpression11297 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_74_in_rulemultiplicativeExpression11313 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_101_in_rulemultiplicativeExpression11329 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_rulemultiplicativeExpression11351 = new BitSet(new long[]{0x0000400000000002L,0x0000002000000400L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_entryRuleunaryExpression11389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpression11399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleunaryExpression11435 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleunaryExpression11474 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleunaryExpression11513 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleunaryExpression11552 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpression11573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_ruleunaryExpression11601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryExpressionNotPlusMinus_in_entryRuleunaryExpressionNotPlusMinus11637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryExpressionNotPlusMinus11647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleunaryExpressionNotPlusMinus11683 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleunaryExpressionNotPlusMinus11722 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleunaryExpression_in_ruleunaryExpressionNotPlusMinus11744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_ruleunaryExpressionNotPlusMinus11773 = new BitSet(new long[]{0x0000020000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_ruleunaryExpressionNotPlusMinus11783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleunaryExpressionNotPlusMinus11799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimary_in_entryRuleprimary11838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimary11848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleparExpression_in_ruleprimary11895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_ruleprimary11922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleliteral_in_entryRuleliteral11957 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleliteral11967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleliteral12001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_ruleliteral12022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleliteral12036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleliteral12057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_ruleliteral12084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleliteral12099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleliteral12115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleliteral12131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleliteral12147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulefunctionDeclaration_in_entryRulefunctionDeclaration12185 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulefunctionDeclaration12195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_rulefunctionDeclaration12240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulefunctionDefinition_in_entryRulefunctionDefinition12275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulefunctionDefinition12285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDefinition_in_rulefunctionDefinition12330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_entryRulejavaFunctionDeclaration12365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDeclaration12375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_rulejavaFunctionDeclaration12411 = new BitSet(new long[]{0x0000000000000000L,0x0001C00000000000L});
    public static final BitSet FOLLOW_110_in_rulejavaFunctionDeclaration12424 = new BitSet(new long[]{0x3FC0001220000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_111_in_rulejavaFunctionDeclaration12440 = new BitSet(new long[]{0x3FC0001220000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_112_in_rulejavaFunctionDeclaration12456 = new BitSet(new long[]{0x3FC0001220000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12479 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_113_in_rulejavaFunctionDeclaration12495 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12518 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulejavaFunctionDeclaration12541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400080L});
    public static final BitSet FOLLOW_71_in_rulejavaFunctionDeclaration12558 = new BitSet(new long[]{0x3FC0001220000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12580 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12601 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_28_in_rulejavaFunctionDeclaration12612 = new BitSet(new long[]{0x3FC0001220000000L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulejavaFunctionDeclaration12633 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionDeclaration12654 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rulejavaFunctionDeclaration12668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rulejavaFunctionDeclaration12685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDefinition_in_entryRulejavaFunctionDefinition12722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionDefinition12732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionDeclaration_in_rulejavaFunctionDefinition12778 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_rulejavaFunctionDefinition12799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulejavaFunctionCall_in_entryRulejavaFunctionCall12835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulejavaFunctionCall12845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulejavaFunctionCall12891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400080L});
    public static final BitSet FOLLOW_71_in_rulejavaFunctionCall12903 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000180L});
    public static final BitSet FOLLOW_ruleexpressionList_in_rulejavaFunctionCall12924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rulejavaFunctionCall12935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_rulejavaFunctionCall12952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblockStatement_in_entryRuleblockStatement12989 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleblockStatement12999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_ruleblockStatement13046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_ruleblockStatement13073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclarationStatement_in_entryRulelocalVariableDeclarationStatement13108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclarationStatement13118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_rulelocalVariableDeclarationStatement13165 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulelocalVariableDeclarationStatement13174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_entryRulelocalVariableDeclaration13210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelocalVariableDeclaration13220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_rulelocalVariableDeclaration13266 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_rulelocalVariableDeclaration13287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarators_in_entryRulevariableDeclarators13323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarators13333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13379 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_rulevariableDeclarators13390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_rulevariableDeclarators13411 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rulevariableDeclarator_in_entryRulevariableDeclarator13449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulevariableDeclarator13459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_rulevariableDeclarator13505 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_rulevariableDeclarator13516 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_rulevariableDeclarator13537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestatement_in_entryRulestatement13575 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulestatement13585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement13632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_rulestatement13648 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleparExpression_in_rulestatement13669 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13690 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_rulestatement13701 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_rulestatement13742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_rulestatement13752 = new BitSet(new long[]{0x3FC0021220008070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleforControl_in_rulestatement13773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rulestatement13783 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_rulestatement13822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleparExpression_in_rulestatement13843 = new BitSet(new long[]{0x0000020000028070L,0x01F41FD800000080L});
    public static final BitSet FOLLOW_rulestatement_in_rulestatement13864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_rulestatement13882 = new BitSet(new long[]{0x0000020000008070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_rulestatement13903 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulestatement13914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rulestatement13931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_rulestatement13948 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulestatement13958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_rulestatement13988 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulestatement13997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_rulestatement14015 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement14036 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_rulestatement14046 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleblock_in_rulestatement14067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforControl_in_entryRuleforControl14104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforControl14114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_ruleforControl14160 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleforControl14171 = new BitSet(new long[]{0x0000020000008070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforControl14192 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleforControl14203 = new BitSet(new long[]{0x0000020000000072L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleforUpdate_in_ruleforControl14224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforInit_in_entryRuleforInit14261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforInit14271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit14318 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleforInit14329 = new BitSet(new long[]{0x0000020000000070L,0x00001FD800000080L});
    public static final BitSet FOLLOW_ruleexpression_in_ruleforInit14350 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rulelocalVariableDeclaration_in_ruleforInit14381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleforUpdate_in_entryRuleforUpdate14416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleforUpdate14426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexpressionList_in_ruleforUpdate14472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleattributeType_in_entryRuleattributeType14507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleattributeType14518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleattributeType14556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleattributeType14575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleattributeType14594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleattributeType14613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleattributeType14632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleattributeType14651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleattributeType14670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleattributeType14689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleattributeType14708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleattributeType14727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleattributeType14746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulephpFunction_in_entryRulephpFunction14786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulephpFunction14796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_rulephpFunction14831 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_rulephpFunction14841 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulephpFunction14858 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_rulephpFunction14881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerubyFunction_in_entryRulerubyFunction14920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerubyFunction14931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RUBY_FUNCTION_in_rulerubyFunction14970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_entryRuleextendedID15015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleextendedID15026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID15066 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_ruleextendedID15085 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleextendedID15100 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE15148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE15159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE15199 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_ruleDOUBLE15217 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDOUBLE15232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulefileID_in_entryRulefileID15278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulefileID15289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCHARS_in_rulefileID15336 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_ruleCHARS_in_rulefileID15364 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_ruleCHARS_in_entryRuleCHARS15412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCHARS15423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedID_in_ruleCHARS15470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCHARS15496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleModifier15553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleModifier15568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleModifier15583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleModifier15598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_ruleModifier15613 = new BitSet(new long[]{0x0000000000000002L});

}