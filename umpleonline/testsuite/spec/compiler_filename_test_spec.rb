require 'net/http'
require 'test_utils.rb'

# Issue #2549: compiler.php must never work in the ump/ directory shared by
# all users. A filename has to name a model directory; without one a new
# private directory is used. Plain HTTP requests, so no browser is needed.
describe "Filename handling of compiler.php", :feature => :compilerFilename do

  def post(params)
    Net::HTTP.post_form(URI("#{TestUtils::HOST}scripts/compiler.php"), params)
  end

  def generate(params = {})
    post({"language" => "Java", "languageStyle" => "codegen",
      "umpleCode" => "class Person { String name; }"}.merge(params))
  end

  def save_svg(params)
    post({"save" => "1", "svgContent" => "<svg/>"}.merge(params))
  end

  # The model directory named in the links of a response
  def model_id(response)
    response.body[%r{ump/((?:tmp|\d{6})\w*)/}, 1]
  end

  ["model.ump", "./model.ump", "../ump/model.ump", "tmpx/../model.ump",
    "/tmp/model.ump", "0"].each do |filename|
    it "rejects the filename #{filename.inspect}" do
      response = generate("filename" => filename)
      expect(response.code).to eq("400")
      expect(response.body).to include("Invalid filename")
    end
  end

  it "rejects a filename given as an array" do
    expect(generate("filename[]" => "tmpx/model.ump").code).to eq("400")
  end

  it "rejects a filename before printing the Python notice" do
    response = generate("language" => "Python", "filename" => "model.ump")
    expect(response.code).to eq("400")
    expect(response.body).not_to include("Generated Python")
  end

  it "uses a new private directory when the filename is omitted or empty" do
    responses = [generate, generate, generate("filename" => "")]
    responses.each do |response|
      expect(response.code).to eq("200")
      expect(response.body).to include("public class Person")
    end
    ids = responses.map { |response| model_id(response) }
    expect(ids).to all(start_with("tmp"))
    expect(ids.uniq.length).to eq(3)
  end

  it "rejects saves outside a model directory" do
    response = post("save" => "1", "umpleCode" => "class A {}", "filename" => "model.ump")
    expect(response.code).to eq("400")
    expect(save_svg("filename[]" => "tmpx/diagram.svg").code).to eq("400")
  end

  it "saves an svg in a new directory when the named one no longer exists" do
    response = save_svg("filename" => "tmpcleanedup/diagram.svg")
    expect(response.code).to eq("200")
    expect(model_id(response)).to start_with("tmp")
    expect(model_id(response)).not_to eq("tmpcleanedup")
  end

  describe "with an existing model directory" do
    before(:all) do
      @id = model_id(generate)
    end

    it "compiles in it when the page names it" do
      response = generate("filename" => "../ump/#{@id}/model.ump")
      expect(response.code).to eq("200")
      expect(model_id(response)).to eq(@id)
    end

    it "saves a model in it" do
      response = post("save" => "1", "umpleCode" => "class A {}",
        "filename" => "../ump/#{@id}/A.ump")
      expect(response.code).to eq("200")
      expect(response.body).to end_with("../ump/#{@id}/A.ump")
    end

    it "saves an svg in it, but no other file type" do
      response = save_svg("filename" => "../ump/#{@id}/diagram.svg")
      expect(response.code).to eq("200")
      expect(response.body).to end_with("ump/#{@id}/diagram.svg")
      response = save_svg("filename" => "../ump/#{@id}/notes.txt")
      expect(response.code).to eq("400")
      expect(response.body).to include("Invalid file type.")
    end
  end
end
