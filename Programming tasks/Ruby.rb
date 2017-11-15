class String

  def shout
    return self.upcase + "!"
  end

  def frequency

    h = Hash.new(0)
    self.upcase.each_char {|c|  h[c] += 1}
    return h
  end

  def histogram


    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    z = Hash.new(0)
    v = self.upcase.delete('^A-Z')

    alphabet.each_char {|c| z[c] += 0 }
    v.each_char {|c| z[c] += 1}
    z.each { |key, value| puts "#{key} #{"*" * value}" }

    puts z;

  end

  end
