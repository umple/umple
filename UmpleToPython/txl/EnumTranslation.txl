rule replaceEnumDeclaration
    replace [enum_declaration]
        _ [opt acess_modifier] 'enum enumName [id] '{ vals [list id] '}
    construct enumValDeclarations [repeat enum_value_declaration]
        _ [generateEnumValues vals]
    by
        'class enumName '(Enum'):
            'def '_generate_next_value_('name, 'start, 'count, 'last_values)':
                'return 'name
            'def '__str__'(self):
                'return 'str(self. 'value)
        enumValDeclarations
end rule

function generateEnumValues vals [list id]
    replace [repeat enum_value_declaration]
        decls [repeat enum_value_declaration]
    by
        decls [generateEnumValue each vals]
end function

function generateEnumValue val [id]
    replace [repeat enum_value_declaration]
        decls [repeat enum_value_declaration]
    construct decl [enum_value_declaration]
        val '= 'auto()
    by decls [. decl]
end function