Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/xenial64"

  config.vm.network "private_network", ip: "192.168.33.33"

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
  end

  config.vm.provision "shell", inline: <<-SHELL
    set -x

    #apt-get update
    #apt-get upgrade -y
    apt-get install -y openjdk-8-jdk
  SHELL

  config.vm.provision "shell", privileged: false, inline: <<-SHELL
      pwd
      mkdir bin
      echo "PATH=\$PATH:~/bin" >> .bashrc

      cd bin
      wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
      chmod +x lein
      ./lein

      cd /vagrant
      ~/bin/lein deps
    SHELL
end
