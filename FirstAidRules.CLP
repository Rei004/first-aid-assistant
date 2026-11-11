(deftemplate recommendation
    (slot text))

(deftemplate object-embedded
    (slot present))

(deftemplate bleeding-continuous
    (slot present))
	
(deftemplate object-embedded
    (slot present))

(deftemplate severity
    (slot severity))
	
(deftemplate blister-charring
	(slot present))

(deftemplate large-area-burn
	(slot present))	
	
(deftemplate bone-protruding
    (slot present))
	
(deftemplate swelling
    (slot present))
	
(deftemplate bleeding-fluid
    (slot present))
	
(deftemplate consciousness-lost
    (slot present))
	
(deftemplate can-cough
    (slot present))

(deftemplate gasping-turnBlue
    (slot present))

(deftemplate pale-cold
    (slot present))

(deftemplate unresponsive
    (slot present))
	
(deftemplate shivering-confused
    (slot present))
	
(deftemplate confused-unresponsive
    (slot present))
	
(deftemplate sweating-hotDrySkin
    (slot present))
	
(deftemplate nausea-dizziness
    (slot present))
	
(deftemplate difficultyBreathing-unresponsive
    (slot present))
	
(deftemplate awake-absentminded
    (slot present))
	
(deftemplate shaking-convulsions
    (slot present))
	
(defrule response-to-severe-Seizure
   (severity (severity severe))
   (or (and (awake-absentminded (present no)) (shaking-convulsions (present yes)))
       (and (awake-absentminded (present yes)) (shaking-convulsions (present yes))))
   =>
   (printout t "Injury Identified as 'Severe Seizure'" crlf)
   (assert (recommendation (text "1.Clear the area of any dangerous objects that the casualty could hit. \
    2.Do not restrain them or put anything in their mouth. \
    3.Protect their head with soft padding, such as a jacket or blanket. \
    4.After the seizure ends, place them in the recovery position. \
    5.Call emergency services if the seizure lasts more than 5 minutes or if they do not regain consciousness."))))

(defrule response-to-mild-Seizure
   (severity (severity mild))
   (awake-absentminded (present yes))
   (shaking-convulsions (present no))
   =>
   (printout t "Injury Identified as 'Mild Seizure'" crlf)
   (assert (recommendation (text "1.Reassure the casualty and guide them to a safe place. \
    2.Allow the seizure to run its course without interference. \
    3.Ensure they rest after the seizure and avoid any dangerous activities. \
    4.Advise them to seek medical advice, especially if it’s their first seizure."))))

(defrule response-to-ambiguous-Seizure
   (severity (severity ambiguous))
   (awake-absentminded (present no))
   (shaking-convulsions (present no))
   =>
   (assert (recommendation (text "The symptoms do not reflect a case of seizure. The person may not be experiencing a seizure. Check another type of injury available."))))

	
	
(defrule response-to-severe-PoisoningOverdose
   (severity (severity severe))
   (or (and (nausea-dizziness (present yes)) (difficultyBreathing-unresponsive (present yes)))
       (and (nausea-dizziness (present no)) (difficultyBreathing-unresponsive (present yes))))
   =>
   (printout t "Injury Identified as 'Severe Poisoning or Overdose'" crlf)
   (assert (recommendation (text "1.Call emergency services immediately. \
    2.If the casualty is unresponsive but breathing, place them in the recovery position. \
    3.Monitor their breathing and be prepared to perform CPR if necessary. \
    4.Provide emergency personnel with details of the substance ingested. \
    5.Do not induce vomiting unless advised by professionals."))))


(defrule response-to-mild-PoisoningOverdose
   (severity (severity mild))
   (nausea-dizziness (present yes))
   (difficultyBreathing-unresponsive (present no))
   =>
   (printout t "Injury Identified as 'Mild Poisoning or Overdose'" crlf)
   (assert (recommendation (text "1.Try to find out what substance was ingested and how much. \
    2.Reassure the casualty and keep them calm. \
    3.Do not induce vomiting unless instructed by medical professionals. \
    4.Offer water if advised, but do not give food or drink unless recommended. \
    5.Call Poison Control for advice and seek medical help if symptoms worsen."))))


(defrule response-to-ambiguous-PoisoningOverdose
   (severity (severity ambiguous))
   (nausea-dizziness (present no))
   (difficultyBreathing-unresponsive (present no))
   =>
   (assert (recommendation (text "The symptoms do not reflect a case of poisoning or overdose. The injury may not be neither poisoning or overdose. Check another type of injury available."))))

	
(defrule response-to-severe-heatstroke
   (severity (severity severe))
   (sweating-hotDrySkin (present yes))
   (confused-unresponsive (present yes))
   =>
   (printout t "Injury Identified as 'Severe Heatstroke'" crlf)
   (assert (recommendation (text "1.Call emergency services immediately. \
    2.Move the casualty to a cool, shaded area. \
    3.Remove excess clothing and rapidly cool them using wet towels or spraying water on their skin. \
    4. Do not give them food or drink if they are unresponsive. \
    5.Monitor their breathing and be prepared to start CPR if necessary. \
    6.Stay with the casualty and keep cooling them until emergency help arrives."))))


(defrule response-to-mild-heatstroke
   (severity (severity mild))
   (sweating-hotDrySkin (present yes))
   (confused-unresponsive (present no))
   =>
   (printout t "Injury Identified as 'Mild Heatstroke'" crlf)
   (assert (recommendation (text "1.Move the casualty to a cool, shaded area and help them sit or lie down. \
    2.Remove excess clothing and help cool them by sponging or spraying water on their skin. \
    3.Offer cool water or an electrolyte drink. \
    4.Reassure them and advise them to rest for the remainder of the day. \
    5.If symptoms persist or worsen, seek medical advice."))))


(defrule response-to-ambiguous-heatstroke
   (severity (severity ambiguous))
   (or (and (sweating-hotDrySkin (present no)) (confused-unresponsive (present no)))
       (and (sweating-hotDrySkin (present no)) (confused-unresponsive (present yes))))
   =>
   (assert (recommendation (text "The symptoms do not reflect a case of heatstroke. The injury may not be heatstroke. Check another type of injury available."))))

	
(defrule response-to-ambiguous-hypothermia
   (severity (severity ambiguous))
   (or (and (shivering-confused (present no)) (unresponsive (present no)))
       (and (shivering-confused (present yes)) (unresponsive (present yes))))
   =>
   (assert (recommendation (text "The symptoms do not reflect a case of hypothermia. The injury may not be hypothermia. Check another type of injury available."))))

(defrule response-to-severe-hypothermia
   (severity (severity severe))
   (shivering-confused (present no))
   (unresponsive (present yes))
   =>
   (printout t "Injury Identified as 'Severe Hypothermia'" crlf)
   (assert (recommendation (text "1. Call emergency services immediately. \
    2. Handle the casualty gently, as rough movements can cause cardiac arrest. \
    3. Insulate the casualty with warm blankets, including their head, but avoid overheating. \
    4. Do not give them anything to eat or drink if they are unresponsive. \
    5. Monitor breathing and pulse, and be prepared to start CPR if necessary. \
    6. Stay with the casualty and provide reassurance until help arrives."))))


(defrule response-to-mild-hypothermia
   (severity (severity mild))
   (shivering-confused (present yes))
   (unresponsive (present no))
   =>
   (printout t "Injury Identified as 'Mild Hypothermia'" crlf)
   (assert (recommendation (text "1. Move the casualty to a warm environment if possible. \
    2. Remove any wet clothing and replace it with warm, dry layers. \
    3. Offer warm drinks (not alcohol or caffeine) and high-energy foods. \
    4. Encourage movement to generate body heat, if they are able to. \
    5. Monitor for worsening signs and seek medical attention if needed."))))
	
	

(defrule response-to-ambiguous-shock
   (severity (severity ambiguous))
   (or (and (pale-cold (present no)) (unresponsive (present no)))
       (and (pale-cold (present no)) (unresponsive (present yes))))
   =>
   (assert (recommendation (text "The symptoms do not reflect a case of shock. The person may not be in shock. Check another type of injury available."))))

(defrule response-to-severe-shock
   (severity (severity severe))
   (pale-cold (present yes))
   (unresponsive (present yes))
   =>
   (printout t "Injury Identified as 'Severe Shock'" crlf)
   (assert (recommendation (text " 1. Call emergency services immediately. \
    2. Lay the casualty flat and elevate their legs (unless contraindicated by injury). \
    3. Keep the casualty warm and avoid giving them anything to eat or drink. \
    4. Monitor their breathing and pulse, and prepare to perform CPR if necessary. \
    5. Stay with the casualty and reassure them until help arrives."))))

(defrule response-to-mild-shock
   (severity (severity mild))
   (pale-cold (present yes))
   (unresponsive (present no))
   =>
   (printout t "Injury Identified as 'Mild Shock'" crlf)
   (assert (recommendation (text "1. Reassure the casualty and have them lie down. \
    2. Elevate their legs to improve circulation (unless there are injuries that prevent it). \
    3. Keep them warm using a blanket or clothing. \
    4. Monitor their breathing and pulse. \
    5. Seek medical attention if their condition worsens or doesn’t improve."))))	
	

(defrule response-to-mild-chocking
   (severity (severity mild))
   (can-cough (present yes))
   (gasping-turnBlue (present no))
   =>
   (printout t "Injury Identified as 'Mild Chocking'" crlf)
   (assert (recommendation (text "1. Encourage the casualty to cough and keep doing so. \
    2. Keep calm and reassure them. \
    3. Do not hit their back while they can still cough effectively. \
    4. Monitor them to see if the situation worsens."))))

(defrule response-to-severe-chocking
   (severity (severity severe))
   (can-cough (present no))
   (gasping-turnBlue (present yes))
   =>
   (printout t "Injury Identified as 'Severe Chocking'" crlf)
   (assert (recommendation (text "1. Ask if the casualty is choking and confirm they cannot breathe or speak. \
    2. Perform up to 5 back blows between the shoulder blades. \
    3. If the obstruction persists, perform up to 5 abdominal thrusts (Heimlich maneuver). \
    4. If the person becomes unresponsive, lay them down and start CPR. \
    5. Call emergency services immediately and continue first aid until help arrives."))))


(defrule response-to-ambiguous-chocking
   (severity (severity ambiguous))
   (or (and (can-cough (present no)) (gasping-turnBlue (present no)))
       (and (can-cough (present yes)) (gasping-turnBlue (present yes))))
   =>
   (assert (recommendation (text "The symptoms do not reflect a case of choking. The person may not be choking. Check another type of injury available."))))

	
(defrule response-to-severe-HeadInjury
   (severity (severity severe))
   (or (bleeding-fluid (present yes))
       (consciousness-lost (present yes)))
   =>
   (printout t "Injury Identified as 'Severe Head Injury'" crlf)
   (assert (recommendation (text "1. Call emergency services immediately. \
    2. Keep the casualty still and avoid moving their head or neck. \
    3. If there’s bleeding from the head, apply a sterile dressing without pressing too hard. \
    4. Monitor the casualty for changes in breathing and responsiveness. \
    5. Do not allow the casualty to fall asleep** if they are drowsy or confused. \
    6. Be prepared to perform CPR if the casualty becomes unresponsive or stops breathing. \
    7. Keep the casualty warm and stay with them until help arrives."))))

(defrule response-to-mild-HeadInjury
   (severity (severity mild))
   (bleeding-fluid (present no))
   (consciousness-lost (present no))
   =>
   (printout t "Injury Identified as 'Mild Head Injury'" crlf)
   (assert (recommendation (text "1. Check for any visible signs of swelling or bruising. \
    2. Apply a cold compress to the injured area to reduce swelling. \
    3. Monitor the casualty for any changes in their level of consciousness. \
    4. Advise them to rest and avoid strenuous activity for 24-48 hours. \
    5. Seek medical advice if symptoms worsen (e.g., headaches, dizziness)."))))	

	
(defrule response-to-severe-bleeding
   (severity (severity severe))  ; Match when severity is severe
   (or (object-embedded (present yes))  ; Embedded object condition
       (bleeding-continuous (present yes)))  ; Continuous bleeding condition
   =>
   (printout t "Injury Identified as 'Severe Bleeding'" crlf)
   (assert (recommendation (text "1. Wear gloves and ensure the safety of the casualty. \
2. If there’s an embedded object, **do not remove it**. Apply pressure around the object. \
3. Apply firm, direct pressure to the wound using a sterile dressing or clean cloth. \
4. Elevate the injured limb above the heart if possible to reduce blood flow. \
5. If the bleeding continues, apply additional dressings but **do not remove the original dressing**. \
6. Dial emergency services (999 or 112) for help. \
7. Monitor the casualty for signs of shock (e.g., pale, cold skin, fast pulse). \
8. Keep the casualty warm and calm until help arrives."))))

(defrule response-to-mild-bleeding
   (object-embedded (present no))
   (bleeding-continuous (present no))
   (severity (severity mild))
   =>
   (printout t "Injury Identified as 'Mild Bleeding'" crlf)
   (assert (recommendation (text 
   "1. Wash hands and put on gloves. \
    2. Clean the wound with clean water. \
    3. Apply direct pressure using a sterile dressing. \
    4. Once bleeding stops, apply a clean bandage. \
    5. Advise the casualty to keep the area clean and monitor for signs of infection."))))
	
(defrule response-to-mild-burn
   (severity (severity mild))
   (blister-charring (present no))
   (or (large-area-burn (present yes))
       (large-area-burn (present no)))
   =>
   (printout t "Injury Identified as 'Mild Burn'" crlf)
   (assert (recommendation (text "1. Cool the burn under running water for at least 10 minutes. \
    2. Gently pat the area dry and apply a sterile, non-stick dressing. \
    3. Avoid using ice, butter, or creams on the burn. \
    4. Monitor for signs of infection (e.g., redness, swelling)."))))
	
(defrule response-to-severe-burn
   (severity (severity severe))
   (blister-charring (present yes))
   (or (large-area-burn (present yes))
       (large-area-burn (present no)))
   =>
   (printout t "Injury Identified as 'Severe Burn'" crlf)
   (assert (recommendation (text "1. Ensure the casualty is safe from the source of the burn (e.g., remove them from fire). \
    2. Call emergency services immediately. \
    3. Cool the burn under running water for at least 10 minutes, if possible. \
    4. If the burn covers a large area, do not immerse in water but apply clean, cool cloths. \
    5. Do not remove any stuck clothing. \
    6. Cover the burn with a sterile, non-stick dressing or clean cloth. \
    7. Elevate the burned area if possible to reduce swelling. \
    8. Monitor the casualty for signs of shock and reassure them until help."))))
	
(defrule response-to-ambiguous-fractures
   (severity (severity ambiguous))
   (or (and (bone-protruding (present yes)) (swelling (present no)))
       (and (bone-protruding (present no)) (swelling (present yes))))
   =>
   (printout t "Injury Identified as 'Ambiguous Fracture'" crlf)
   (assert (recommendation (text "The symptoms do not reflect a fracture. The injury may not be a fracture. Check another type of injury available."))))
	
(defrule response-to-mild-fractures
   (severity (severity mild))
   (bone-protruding (present no)) 
   (swelling (present no))    
   =>
   (printout t "Injury Identified as 'Mild Fracture'" crlf)
   (assert (recommendation (text "1. Assess for any deformity or swelling in the injured area. \
    2. Immobilize the injured area using a splint or by supporting it with soft padding. \
    3. Avoid moving the casualty if a fracture is suspected. \
    4. Apply a cold compress to reduce swelling. \
    5. Seek medical attention for further examination and treatment."))))

(defrule response-to-severe-fractures
   (severity (severity severe))
   (bone-protruding (present yes)) 
   (swelling (present yes))    
   =>
   (printout t "Injury Identified as 'Severe Fracture'" crlf)
   (assert (recommendation (text "1.Do not try to realign the bone. \
    2. If the bone is protruding, cover it with a sterile dressing without applying direct pressure. \
    3. Immobilize the area to prevent movement. \
    4. Call emergency services immediately. \
    5. Monitor for signs of shock (e.g., rapid pulse, pale skin). \
    6. Keep the casualty calm and warm while waiting for help."))))


(defrule show-recommendations
   ?r <- (recommendation (text ?text))
   =>
   (printout t "Recommendation: \ " ?text crlf))