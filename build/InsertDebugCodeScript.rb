load "InsertDebugCode.rb"

puts("Modifying templates")
Dir.chdir("..")
InsertDebugCode.modifytemplates("UmpleToJava/templates/", "java")
InsertDebugCode.modifytemplates("UmpleToCpp/templates/", "cpp")
InsertDebugCode.modifytemplates("UmpleToPhp/templates/", "php")
InsertDebugCode.modifytemplates("UmpleToRuby/templates/", "ruby")