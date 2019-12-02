//
//  LoginViewController.swift
//  laboratorio13
//
//  Created by Alexander on 11/14/19.
//  Copyright © 2019 Alexander. All rights reserved.
//

import UIKit
import FirebaseAuth
class LoginViewController: UIViewController {

    @IBOutlet weak var usernameTextField: UITextField!
    
    @IBOutlet weak var passwrodTextField: UITextField!
    
    @IBOutlet weak var errorlabel: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func loginClickButton(_ sender: Any) {
        print("Login button clicked")
        if(usernameTextField.text != "" && passwrodTextField.text != ""){
            Auth.auth().signIn(withEmail: usernameTextField.text!, password:passwrodTextField.text!){
                (user,Error) in
                if(user != nil){
                    print("Usuario autenticado")
                    self.presentingViewController?.dismiss(animated: true, completion: nil);
                }else{
                    print("Error en la auteneticacion")
                    self.errorlabel.isHidden = false
                }
                
                }
            }else {
                print("Datos incorrectos")
            self.errorlabel.isHidden = false
            
            }
        }
    
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
