# Enigma
The Enigma machine is made up of X  components:
- Keyboard
    - Initial input of each letter by the user.
- Plugboard
    - Up to 10 double ended cables link 2 letter together.
- Rotors
    - Selection of 5 rotors that can be places in any order in 3 rotor slots.
    - Each rotor has a start letter.
    - Each rotor has a unique notch that triggers the next rotor in the sequence to move one position.
    - Each rotor has a ring setting that shifts the configuration of the rotor.

    - Ring Setting
      ---> The ring setting shifts each letter of the rotor configuration down the alphabet by a specific number of 
           steps depending on the ring setting.
         - For example:
         - When the ring setting is B Rotor I's original configuration is shifted down by one letter.
         - EKMFLGDQVZNTOWYHXUSPAIBRCJ
         - ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
         - FLNGMHERWAOUPXZIYVTQBJCSDK

         - Also, the rotors notch position also moves by one space.

- Reflector
    - There are two reflector configurations. Each configuration connects each letter to another letter.
- Lampboard
    - Displays the encrypted letter to the user.


The machine is pre-configured with a set of machine settings before entering the message. The user must pick the
following settings:
- Plugboard pairs
- Rotors + position of the rotors in the machine 
