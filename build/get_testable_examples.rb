require 'optparse'
require 'fileutils'

def populate_possible_matches(directories, pattern)
  #Find all the matching filename from each directory

  matches = []
  pattern = pattern.chomp(".ump") + "\\.ump"
  pattern = pattern.gsub("*", ".*")
  directories.each do |directory|
    possibles = Dir.entries(directory)

    possibles.each do |filename|
      if filename =~ /#{pattern}/
        matches << directory + "/" + filename
      end
    end
  end

  return matches
end

def check_for_flags(filenames, language)
  #read each file and check the target languages
  
  matches = []

  #For langauge choice, we are looking for @@@testlanguage=lang,lang,....
  #If this tag is missing, it will always add it to the directory
  filenames.each do |filename|
    should_add = true
    open(filename, 'r').each do |line|
      tag = line[/@@@testlanguage=.*/]
      next if tag.nil?
      if tag =~ /.*#{language}.*/
        break
      else
        should_add = false
        break
      end
    end
    matches << filename if should_add
  end

  return matches
end

def copy_to_output(filenames, output_dir)
  
  filenames.each do |filename|
    new_filename = "#{output_dir}/#{filename.split("/")[-1]}"
    FileUtils.cp(filename, new_filename)
  end
end

# command line input arguments
search_dir = []
language = ""
output_dir = ""
search_pattern = ""

OptionParser.new do |option|
  option.on('-i DIRNAME') { |dirname| search_dir << dirname }
  option.on('-l LANGNAME') { |langname| language = langname }
  option.on('-o DIRNAME') { |dirname| output_dir = dirname }
  option.on('-s PATTERN') { |pattern| search_pattern = pattern }
  option.on('-h') { puts option; exit }
  option.parse!
end

matches = populate_possible_matches(search_dir, search_pattern)
matches = check_for_flags(matches, language)
copy_to_output(matches, output_dir)
