;; Copyright (c) 2014-2015 Andrey Antukh <niwi@niwi.be>
;; All rights reserved.
;;
;; Redistribution and use in source and binary forms, with or without
;; modification, are permitted provided that the following conditions are met:
;;
;; * Redistributions of source code must retain the above copyright notice, this
;;   list of conditions and the following disclaimer.
;;
;; * Redistributions in binary form must reproduce the above copyright notice,
;;   this list of conditions and the following disclaimer in the documentation
;;   and/or other materials provided with the distribution.
;;
;; THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
;; AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
;; IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
;; DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
;; FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
;; DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
;; SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
;; CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
;; OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
;; OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

(ns suricatta.proto)

(defprotocol IContextHolder
  (-context [_] "Get jooq context with attached configuration")
  (-config [_] "Get attached configuration."))

(defprotocol IConnectionFactory
  (-connection [_] "Create a jdbc connection."))

(defprotocol IExecute
  (-execute [q ctx] "Execute a query and return a number of rows affected."))

(defprotocol IFetch
  (-fetch [q ctx opts] "Fetch eagerly results executing query."))

(defprotocol IFetchLazy
  (-fetch-lazy [q ctx opts] "Fetch lazy results executing query."))

(defprotocol IQuery
  (-query [_ ctx] "Build a query."))

(defprotocol IParam
  (-param [_ ctx] "Returns a jOOQ compatible param type."))

(defprotocol ISQLType
  "An abstraction for handle the backward type
  conversion: from SQL->User."
  (-convert [_] "Convert sql type to user type."))
