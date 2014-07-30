
$language_replace_strings = {
  "java" => "@@@PUT JAVA OUTPUTS HERE@@@",
  "cpp" => "@@@PUT CPP OUTPUTS HERE@@@",
  "php" => "@@@PUT PHP OUTPUTS HERE@@@"
}

def get_output_files(directory)

  file_dict = {}

  $language_replace_strings.each do |lang, val|
    temp_array = []
    
    begin
      Dir.entries("#{directory}/#{lang}").each do |filename|
        if filename =~ /.*\.output/
          temp_array << "#{directory}/#{lang}/#{filename}"
        end
      end
    rescue Errno::ENOENT 
      #ignores missing folders from the subtargets
      next
    end

    file_dict[lang] = temp_array
  end

  return file_dict
end

def parse_output_files(filename_dict)
  output_strings = {}

  filename_dict.each do |lang, files|
    temp_string = ""

    files.each do |filename|
      open(filename, 'r').each do |line|
        temp_string << line unless line =~ /\[echo\] Current Version:.*/
      end
    end

    output_strings[lang] = temp_string
  end

  return output_strings
end

def build_final_output(output_strings_dict, output_file)

  output = ""

  open(output_file, 'r').each do |line|
    output << line 
  end

  output_strings_dict.each do |lang, replacement_output|
    output = output.gsub("#{$language_replace_strings[lang]}", replacement_output)
  end

  file = open(output_file, 'w')
  file.write(output)
  file.close
end

output_file = ARGV[0]
temporary_file_dir = ARGV[1]

file_dict = get_output_files(temporary_file_dir)
output_strings_dict = parse_output_files(file_dict)
build_final_output(output_strings_dict, output_file)
