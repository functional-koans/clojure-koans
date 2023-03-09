{
  description = "Clojure Koans";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = inputs@{ self, nixpkgs, flake-utils, ... }:
  flake-utils.lib.eachDefaultSystem (system:
  let
    overlays = [ ];

    pkgs = import nixpkgs {inherit system overlays;};

    additionalPkgs = with pkgs; [  ];

    buildPkgs = with pkgs; [ clojure leiningen ]; 

    project = pkgs.stdenv.mkDerivation {
      name = "koans-env";
      root = self;
      buildInputs = buildPkgs;
      shellInputs = additionalPkgs;
    };

  in {
  defaultPackage = project;
  devShell = project;
  });
}
